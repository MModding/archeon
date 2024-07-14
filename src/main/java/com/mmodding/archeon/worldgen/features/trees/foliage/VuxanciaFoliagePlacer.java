package com.mmodding.archeon.worldgen.features.trees.foliage;

import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.utils.RadiusUtils;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class VuxanciaFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<VuxanciaFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance).apply(instance, VuxanciaFoliagePlacer::new)
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
		/* if (!node.isGiantTrunk()) { TODO: WIP
			RadiusUtils.iterateFromCenter(node.getCenter(), 2, 1, 2, pos -> this.placeRandomlyFromCenterIfValid(world, replacer, random, config, pos, node.getCenter()));
		} */
	}

	protected void placeRandomlyFromCenterIfValid(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos, BlockPos centerPos) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockPos subtractedPos = pos.subtract(centerPos);
			int distanceX = MathHelper.abs(subtractedPos.getX());
			int distanceY = MathHelper.abs(subtractedPos.getY());
			int distanceZ = MathHelper.abs(subtractedPos.getZ());

			float probabilityX = 1.0f / 3.0f - distanceX / 7.5f;
			float probabilityY = 1.0f / 3.0f - distanceY / 7.5f;
			float probabilityZ = 1.0f / 3.0f - distanceZ / 7.5f;

			float probability = probabilityX + probabilityY + probabilityZ;

			if (random.nextFloat() <= probability) {
				this.placeVuxanciaFoliage(world, replacer, random, config, pos);
			}
		}
	}

	protected void placeVuxanciaFoliage(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockState blockState = config.foliageProvider.getBlockState(random, pos);
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
