package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ArcheonBiomeTags {

	public static final TagKey<Biome> SURFACE_BIOMES = TagKey.create(Registries.BIOME, Archeon.createId("surface_biomes"));
	public static final TagKey<Biome> CAVE_BIOMES = TagKey.create(Registries.BIOME, Archeon.createId("cave_biomes"));
	public static final TagKey<Biome> TERRAIN_BIOMES = TagKey.create(Registries.BIOME, Archeon.createId("terrain_biomes"));
}
