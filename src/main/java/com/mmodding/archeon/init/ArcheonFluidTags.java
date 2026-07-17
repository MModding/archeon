package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ArcheonFluidTags {

	public static final TagKey<Fluid> HOT_SPRING_WATER = TagKey.of(RegistryKeys.FLUID, Archeon.createId("hot_spring_water"));
	public static final TagKey<Fluid> DASCIUM = TagKey.of(RegistryKeys.FLUID, Archeon.createId("dascium"));
}
