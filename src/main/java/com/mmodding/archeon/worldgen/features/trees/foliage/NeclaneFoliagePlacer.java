package com.mmodding.archeon.worldgen.features.trees.foliage;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.utils.RadiusUtils;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NeclaneFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<NeclaneFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance).apply(instance, NeclaneFoliagePlacer::new)
	);

	public NeclaneFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
		super(radius, offset, foliageHeight);
	}

	@Override
	public FoliagePlacerType<NeclaneFoliagePlacer> getType() {
		return ArcheonFeatures.NECLANE_FOLIAGE_PLACER;
	}

	@Override
	protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, int trunkHeight, TreeNode node, int foliageHeight, int radius, int offset) {

		BlockPos centerPos = node.getCenter().up(3);

		this.placeNeclaneFoliage(world, replacer, random, config, centerPos);

		for (Direction direction : Direction.values()) {
			this.generateCrossAtDirection(world, replacer, random, config, centerPos, direction);
		}

		RadiusUtils.iterateFromCenterInSquare(centerPos, node.isGiantTrunk() ? 5 : 3, pos -> this.placeRandomlyFromCenterIfValid(world, replacer, random, config, pos, centerPos));

		RadiusUtils.iterateFromCenterInSquare(centerPos, node.isGiantTrunk() ? 5 : 3, pos -> this.applySmooth(world, replacer, random, config, pos));
	}

	protected void placeNeclaneFoliage(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockState blockState = random.nextInt(5) != 0 ? config.foliageProvider.getBlockState(random, pos) : ArcheonBlocks.FLOWERED_NECLANE_LEAVES.getDefaultState();
			if (blockState.contains(Properties.WATERLOGGED)) {
				blockState = blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, state -> state.isEqualAndStill(Fluids.WATER)));
			}
			replacer.accept(pos, blockState);
		}
	}

	protected void generateCrossAtDirection(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos, Direction direction) {
		Direction opposite = direction.getOpposite();
		BlockPos crossPos = pos.offset(direction);
		this.placeNeclaneFoliage(world, replacer, random, config, crossPos);
		Arrays.stream(Direction.values()).filter(filter -> filter != direction && filter != opposite).forEach(crossDirection -> this.placeNeclaneFoliage(world, replacer, random, config, crossPos.offset(crossDirection)));
	}

	protected void placeRandomlyFromCenterIfValid(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos, BlockPos centerPos) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockPos subtractedPos = pos.subtract(centerPos);
			int distanceX = MathHelper.abs(subtractedPos.getX());
			int distanceY = MathHelper.abs(subtractedPos.getY());
			int distanceZ = MathHelper.abs(subtractedPos.getZ());

			// 0.33 ~ 1/3 & 0.06 ~ 1/15
			float probabilityX = 0.33f - 0.06f * distanceX;
			float probabilityY = 0.33f - 0.06f * distanceY;
			float probabilityZ = 0.33f - 0.06f * distanceZ;

			float probability = probabilityX + probabilityY + probabilityZ;

			if (random.nextFloat() <= probability) {
				Predicate<BlockPos> check = p -> world.testBlockState(p, state -> state.isOf(ArcheonBlocks.NECLANE_LEAVES) || state.isOf(ArcheonBlocks.FLOWERED_NECLANE_LEAVES));

				if (Direction.stream().map(direction -> check.test(pos.offset(direction))).filter(Boolean::booleanValue).collect(Collectors.toSet()).size() >= (probability <= 0.6f ? 2 : 1)) {
					this.placeNeclaneFoliage(world, replacer, random, config, pos);
				}
			}
		}
	}

	protected void applySmooth(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos) {
		if (TreeFeature.canReplace(world, pos)) {
			Consumer<BlockPos> airSetter = airPos -> replacer.accept(airPos, Blocks.AIR.getDefaultState());

			int leavesCounter = 0;
			int airCounter = 0;

			for (Direction direction : Direction.values()) {
				if (world.testBlockState(pos.offset(direction), state -> state.isOf(ArcheonBlocks.NECLANE_LEAVES) || state.isOf(ArcheonBlocks.FLOWERED_NECLANE_LEAVES))) {
					leavesCounter++;
				} else if (world.testBlockState(pos.offset(direction), BlockState::isAir)) {
					airCounter++;
				}
			}

			if (leavesCounter > 3) {
				this.placeNeclaneFoliage(world, replacer, random, config, pos);
			} else if (airCounter > 3) {
				airSetter.accept(pos);
			}
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
