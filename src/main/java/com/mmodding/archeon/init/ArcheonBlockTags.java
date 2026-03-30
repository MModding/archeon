package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

public class ArcheonBlockTags {

	public static final TagKey<Biome> SURFACE_BIOMES = TagKey.of(RegistryKeys.BIOME, Archeon.createId("surface_biomes"));
	public static final TagKey<Biome> CAVE_BIOMES = TagKey.of(RegistryKeys.BIOME, Archeon.createId("cave_biomes"));
	public static final TagKey<Biome> TERRAIN_BIOMES = TagKey.of(RegistryKeys.BIOME, Archeon.createId("terrain_biomes"));

	public static final TagKey<Block> SOIL = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("equivalents/soil"));
	public static final TagKey<Block> STONE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("equivalents/stone"));
	public static final TagKey<Block> LEAVES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("equivalents/leaves"));
	public static final TagKey<Block> WOOD = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("equivalents/wood"));
	public static final TagKey<Block> METALS = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("equivalents/metals"));

	public static final TagKey<Block> ACHREAN_CAVES_PLACEABLE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("placeable/achrean_caves"));

	public static final TagKey<Block> CHIASPEN_ORES_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("replaceables/chiaspen_ore"));
	public static final TagKey<Block> PHOSNOR_SLATE_ORES_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("replaceables/phosnor_slate_ore"));
	public static final TagKey<Block> ACHREAN_MOSS_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("replaceables/achrean_moss"));

	public static final TagKey<Block> SUNSTRADIVERS_SPAWNABLE_ON = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("sunstradivers_spawnable_on"));

	public static final TagKey<Block> CHIASPEN = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/chiaspen"));
	public static final TagKey<Block> ORES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/ores"));
	public static final TagKey<Block> AKETITE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/aketite"));
	public static final TagKey<Block> MYSTERIOUS_STONE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/mysterious_stone"));
	public static final TagKey<Block> ARTEMNITE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/artemnite"));
	public static final TagKey<Block> CRIADAN = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/criadan"));
	public static final TagKey<Block> ANHYDRITE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/anhydrite"));
	public static final TagKey<Block> ROUGHCAST = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/roughcast"));
	public static final TagKey<Block> DARK_GREEN_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/dark_green_tiles"));
	public static final TagKey<Block> GREEN_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/green_tiles"));
	public static final TagKey<Block> LIME_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/lime_tiles"));
	public static final TagKey<Block> TURQUOISE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/turquoise_tiles"));
	public static final TagKey<Block> LIGHT_BLUE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/light_blue_tiles"));
	public static final TagKey<Block> BLUE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/blue_tiles"));
	public static final TagKey<Block> DARK_BLUE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/dark_blue_tiles"));
	public static final TagKey<Block> PURPLE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/purple_tiles"));
	public static final TagKey<Block> PINK_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/pink_tiles"));
	public static final TagKey<Block> RED_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/red_tiles"));
	public static final TagKey<Block> CERAMIC_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/ceramic_tiles"));
	public static final TagKey<Block> OCHRE_TILES = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("stone/ochre_tiles"));

	public static final TagKey<Block> PALM = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/palm"));
	public static final TagKey<Block> NECLANE = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/neclane"));
	public static final TagKey<Block> CYPRESS = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/cypress"));
	public static final TagKey<Block> VUXANCIA = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/vuxancia"));
	public static final TagKey<Block> NUME_WILLOW = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/nume_willow"));
	public static final TagKey<Block> NYRETH = TagKey.of(RegistryKeys.BLOCK, Archeon.createId("wood/nyreth"));
}
