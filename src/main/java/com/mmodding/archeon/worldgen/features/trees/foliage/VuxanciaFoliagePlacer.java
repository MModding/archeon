package com.mmodding.archeon.worldgen.features.trees.foliage;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.math.MathFunction;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class VuxanciaFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<VuxanciaFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance)
			.apply(instance, VuxanciaFoliagePlacer::new)
	);

	public VuxanciaFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
		super(radius, offset, foliageHeight);
	}

	@Override
	public FoliagePlacerType<?> getType() {
		return ArcheonFeatures.VUXANCIA_FOLIAGE_PLACER;
	}

	@Override
	protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, int trunkHeight, TreeNode node, int foliageHeight, int radius, int offset) {
		Set<BlockPos> placedLeaves = new HashSet<>();
		this.placePatch(world, replacer, random, config, node.getCenter(), node.isGiantTrunk() && random.nextBoolean(), placedLeaves);
	}

	private void placePatch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos centerPos, boolean isBig, Set<BlockPos> collector) {
		Direction.Type.HORIZONTAL.forEach(direction -> this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos.down().offset(direction), collector));
		if (isBig) {
			this.placeCircle(world, replacer, random, config, centerPos, 3, collector);
			this.placeCircle(world, replacer, random, config, centerPos.up(), 2, collector);
		}
		else {
			this.placeCircle(world, replacer, random, config, centerPos, 2, collector);
			this.placeCircle(world, replacer, random, config, centerPos.up(), 1, collector);
		}
		Set<BlockPos> removed = new HashSet<>();
		collector.forEach(pos -> {
			int validNeighbors = Direction.stream().filter(
				direction -> world.testBlockState(
					pos.offset(direction),
					state -> state.isOf(config.foliageProvider.getBlockState(random, pos).getBlock()) || state.isOf(ArcheonBlocks.VUXANCIA_LOG)
				)
			).collect(Collectors.toSet()).size();
			// We first verify that the current block position has less or exactly 4 leave / stem blocks as neighbors
			// or that the current block position has 5 leave / stem blocks as neighbor with no one being up.
			// It prevents leave blocks that are important to the shape to be removed.
			if (validNeighbors <= 4 || (validNeighbors == 5 && world.testBlockState(pos.up(), BlockState::isAir))) {
				// Cancellation Probability is obtained with f(x) = 5^x * 6^-x.
				// The function uses the vector length as its parameter.
				MathFunction function = x -> Math.pow(5.0, x) * Math.pow(6.0, -x);
				double cancellationProbability = function.getY(Vec3d.of(pos.subtract(centerPos.withY(pos.getY()))).length());
				if (random.nextDouble() >= cancellationProbability) {
					removed.add(pos);
				}
			}
		});
		removed.forEach(pos -> replacer.accept(pos, Blocks.AIR.getDefaultState()));
		collector.removeIf(removed::contains);
	}

	private void placeCircle(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos centerPos, int size, Set<BlockPos> collector) {
		this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos, collector);
		assert 1 <= size && 3 >= size;
		Direction.Type.HORIZONTAL.forEach(direction -> {
			for (int i = 0; i < size; i++) {
				this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos.offset(direction, i + 1), collector);
				this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos.offset(direction.rotateCounterclockwise(Direction.Axis.Y)).offset(direction, i + 1), collector);
			}
			if (size == 3) {
				for (int i = 0; i < size - 1; i++) {
					this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos.offset(direction.rotateCounterclockwise(Direction.Axis.Y), size - 1).offset(direction, i + 1), collector);
				}
			}
			if (size >= 2) {
				this.placeVuxanciaFoliage(world, replacer, random, config, centerPos, centerPos.offset(direction.rotateCounterclockwise(Direction.Axis.Y), size).offset(direction), collector);
			}
		});
	}

	protected void placeVuxanciaFoliage(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos centerPos, BlockPos pos, Set<BlockPos> collector) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockState blockState = config.foliageProvider.getBlockState(random, pos);
			if (blockState.contains(Properties.WATERLOGGED)) {
				blockState = blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, state -> state.isEqualAndStill(Fluids.WATER)));
			}
			replacer.accept(pos, blockState);
			collector.add(pos);
		}
	}

	@Override
	public int getRandomHeight(RandomGenerator random, int trunkHeight, TreeFeatureConfig config) {
		return 0;
	}

	@Override
	protected boolean isInvalidForLeaves(RandomGenerator random, int dx, int y, int dz, int radius, boolean giantTrunk) {
		return false;
	}
}
