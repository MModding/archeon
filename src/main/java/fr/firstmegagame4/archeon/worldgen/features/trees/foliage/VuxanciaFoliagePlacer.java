package fr.firstmegagame4.archeon.worldgen.features.trees.foliage;

import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
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
