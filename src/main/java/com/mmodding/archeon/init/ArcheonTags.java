package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ArcheonTags {

	public static class Blocks {

		public static final TagKey<Biome> SURFACE_BIOMES = TagKey.of(Registry.BIOME_KEY, Archeon.createId("surface_biomes"));
		public static final TagKey<Biome> CAVE_BIOMES = TagKey.of(Registry.BIOME_KEY, Archeon.createId("cave_biomes"));
		public static final TagKey<Biome> TERRAIN_BIOMES = TagKey.of(Registry.BIOME_KEY, Archeon.createId("terrain_biomes"));

		public static final TagKey<Block> SOIL = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/soil"));
		public static final TagKey<Block> STONE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/stone"));
		public static final TagKey<Block> LEAVES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/leaves"));
		public static final TagKey<Block> WOOD = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/wood"));
		public static final TagKey<Block> METALS = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/metals"));

		public static final TagKey<Block> CHIASPEN_ORES_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/chiaspen_ore"));
		public static final TagKey<Block> PHOSNOR_SLATE_ORES_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/phosnor_slate_ore"));
		public static final TagKey<Block> ACHREAN_MOSS_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/achrean_moss"));

		public static final TagKey<Block> SUNSTRADIVERS_SPAWNABLE_ON = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("sunstradivers_spawnable_on"));

		public static final TagKey<Block> CHIASPEN = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/chiaspen"));
		public static final TagKey<Block> ORES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ores"));
		public static final TagKey<Block> AKETITE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/aketite"));
		public static final TagKey<Block> MYSTERIOUS_STONE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/mysterious_stone"));
		public static final TagKey<Block> ARTEMNITE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/artemnite"));
		public static final TagKey<Block> CRIADAN = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/criadan"));
		public static final TagKey<Block> ANHYDRITE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/anhydrite"));
		public static final TagKey<Block> ROUGHCAST = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/roughcast"));
		public static final TagKey<Block> DARK_GREEN_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/dark_green_tiles"));
		public static final TagKey<Block> GREEN_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/green_tiles"));
		public static final TagKey<Block> LIME_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/lime_tiles"));
		public static final TagKey<Block> TURQUOISE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/turquoise_tiles"));
		public static final TagKey<Block> LIGHT_BLUE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/light_blue_tiles"));
		public static final TagKey<Block> BLUE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/blue_tiles"));
		public static final TagKey<Block> DARK_BLUE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/dark_blue_tiles"));
		public static final TagKey<Block> PURPLE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/purple_tiles"));
		public static final TagKey<Block> PINK_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/pink_tiles"));
		public static final TagKey<Block> RED_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/red_tiles"));
		public static final TagKey<Block> CERAMIC_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ceramic_tiles"));
		public static final TagKey<Block> OCHRE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ochre_tiles"));

		public static final TagKey<Block> PALM = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/palm"));
		public static final TagKey<Block> NECLANE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/neclane"));
		public static final TagKey<Block> CYPRESS = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/cypress"));
		public static final TagKey<Block> VUXANCIA = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/vuxancia"));
		public static final TagKey<Block> NUME_WILLOW = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/nume_willow"));
		public static final TagKey<Block> NYRETH = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/nyreth"));
	}

	public static class Items {

		public static final TagKey<Item> LEAVES = TagKey.of(Registry.ITEM_KEY, Archeon.createId("leaves"));
		public static final TagKey<Item> LYCORIS_PETALS = TagKey.of(Registry.ITEM_KEY, Archeon.createId("lycoris_petals"));
		public static final TagKey<Item> LYCORIS_JAM_POTS = TagKey.of(Registry.ITEM_KEY, Archeon.createId("lycoris_jam_pots"));
		public static final TagKey<Item> PLANKS = TagKey.of(Registry.ITEM_KEY, Archeon.createId("planks"));
		public static final TagKey<Item> SHELLS = TagKey.of(Registry.ITEM_KEY, Archeon.createId("shells"));
		public static final TagKey<Item> TILES = TagKey.of(Registry.ITEM_KEY, Archeon.createId("tiles"));
	}

	public static class Entities {

		public static final TagKey<EntityType<?>> AURORA_CATALYSTS = TagKey.of(Registry.ENTITY_TYPE_KEY, Archeon.createId("aurora_catalysts"));
		public static final TagKey<EntityType<?>> CENTAURS = TagKey.of(Registry.ENTITY_TYPE_KEY, Archeon.createId("centaurs"));
	}
}
