package fr.firstmegagame4.archeon.worldgen.features.trees.trunk;

import com.google.common.collect.ImmutableList;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTrunkPlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends CustomTrunkPlacer {

	public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillTrunkPlacerFields(instance).apply(instance, PalmTrunkPlacer::new)
	);

	public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	public TrunkPlacerType<?> getType() {
		return ArcheonFeatures.PALM_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {
		return ImmutableList.of(new FoliagePlacer.TreeNode(startPos, 0, false));
	}
}
