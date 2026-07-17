package com.mmodding.archeon.block.sapling;

import com.mmodding.archeon.init.ArcheonConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class ZialVuxanciaSaplingGenerator extends SaplingGenerator {

	@Override
	@Nullable
	protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
		return ArcheonConfiguredFeatures.ZIAL_VUXANCIA_TREE;
	}
}
