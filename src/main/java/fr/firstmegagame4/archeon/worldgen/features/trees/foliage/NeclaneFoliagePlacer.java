package fr.firstmegagame4.archeon.worldgen.features.trees.foliage;

import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class NeclaneFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<NeclaneFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance).apply(instance, NeclaneFoliagePlacer::new)
	);

	public NeclaneFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
		super(radius, offset, foliageHeight);
	}

	@Override
	public FoliagePlacerType<?> getType() {
		return ArcheonFeatures.NECLANE_FOLIAGE_PLACER;
	}

	@Override
	protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, int trunkHeight, TreeNode node, int foliageHeight, int radius, int offset) {

		BlockPos centerPos = node.getCenter();

		this.placeNeclaneFoliage(world, replacer, random, config, centerPos);

		for (Direction direction : Direction.values()) {
			this.generateCrossAtDirection(world, replacer, random, config, centerPos, direction);
			if (node.isGiantTrunk()) {
				this.generateCrossAtDirection(world, replacer, random, config, centerPos.offset(direction), direction);
			}
		}

		if (node.isGiantTrunk()) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {
						this.placeNeclaneFoliage(world, replacer, random, config, centerPos.add(i == 0 ? i - 1 : i, j == 0 ? j - 1 : j, k == 0 ? k - 1 : k));
					}
				}
			}
		}
	}

	protected void generateCrossAtDirection(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos, Direction direction) {
		Direction opposite = direction.getOpposite();
		BlockPos crossPos = pos.offset(direction);
		this.placeNeclaneFoliage(world, replacer, random, config, crossPos);
		Arrays.stream(Direction.values()).filter(filter -> filter != direction && filter != opposite).forEach(crossDirection -> this.placeNeclaneFoliage(world, replacer, random, config, crossPos.offset(crossDirection)));
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

	@Override
	public int getRandomHeight(RandomGenerator random, int trunkHeight, TreeFeatureConfig config) {
		return 0;
	}

	@Override
	protected boolean isInvalidForLeaves(RandomGenerator random, int dx, int y, int dz, int radius, boolean giantTrunk) {
		return false;
	}
}
