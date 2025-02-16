package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import org.quiltmc.qsl.tag.api.QuiltTagKey;
import org.quiltmc.qsl.tag.api.TagType;

public class ArcheonTags {

	public static class Blocks {

		public static final TagKey<Biome> SURFACE_BIOMES = QuiltTagKey.of(Registry.BIOME_KEY, Archeon.createId("surface_biomes"), TagType.NORMAL);
		public static final TagKey<Biome> CAVE_BIOMES = QuiltTagKey.of(Registry.BIOME_KEY, Archeon.createId("cave_biomes"), TagType.NORMAL);
		public static final TagKey<Biome> TERRAIN_BIOMES = QuiltTagKey.of(Registry.BIOME_KEY, Archeon.createId("terrain_biomes"), TagType.NORMAL);

		public static final TagKey<Block> SOIL = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/soil"), TagType.NORMAL);
		public static final TagKey<Block> STONE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/stone"), TagType.NORMAL);
		public static final TagKey<Block> LEAVES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/leaves"), TagType.NORMAL);
		public static final TagKey<Block> WOOD = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/wood"), TagType.NORMAL);
		public static final TagKey<Block> METALS = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/metals"), TagType.NORMAL);

		public static final TagKey<Block> BASE_STONE_ARCHEON = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("base_stone_archeon"), TagType.NORMAL);

		public static final TagKey<Block> CHIASPEN_ORES_REPLACEABLES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/chiaspen_ore"), TagType.NORMAL);
		public static final TagKey<Block> PHOSNOR_SLATE_ORES_REPLACEABLES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/phosnor_slate_ore"), TagType.NORMAL);
		public static final TagKey<Block> ACHREAN_MOSS_REPLACEABLES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/achrean_moss"), TagType.NORMAL);

		public static final TagKey<Block> CHIASPEN = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/chiaspen"), TagType.NORMAL);
		public static final TagKey<Block> ORES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ores"), TagType.NORMAL);
		public static final TagKey<Block> AKETITE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/aketite"), TagType.NORMAL);
		public static final TagKey<Block> MYSTERIOUS_STONE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/mysterious_stone"), TagType.NORMAL);
		public static final TagKey<Block> ARTEMNITE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/artemnite"), TagType.NORMAL);
		public static final TagKey<Block> CRIADAN = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/criadan"), TagType.NORMAL);
		public static final TagKey<Block> ANHYDRITE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/anhydrite"), TagType.NORMAL);
		public static final TagKey<Block> ROUGHCAST = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/roughcast"), TagType.NORMAL);
		public static final TagKey<Block> DARK_GREEN_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/dark_green_tiles"), TagType.NORMAL);
		public static final TagKey<Block> GREEN_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/green_tiles"), TagType.NORMAL);
		public static final TagKey<Block> LIME_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/lime_tiles"), TagType.NORMAL);
		public static final TagKey<Block> TURQUOISE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/turquoise_tiles"), TagType.NORMAL);
		public static final TagKey<Block> LIGHT_BLUE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/light_blue_tiles"), TagType.NORMAL);
		public static final TagKey<Block> BLUE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/blue_tiles"), TagType.NORMAL);
		public static final TagKey<Block> DARK_BLUE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/dark_blue_tiles"), TagType.NORMAL);
		public static final TagKey<Block> PURPLE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/purple_tiles"), TagType.NORMAL);
		public static final TagKey<Block> PINK_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/pink_tiles"), TagType.NORMAL);
		public static final TagKey<Block> RED_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/red_tiles"), TagType.NORMAL);
		public static final TagKey<Block> CERAMIC_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ceramic_tiles"), TagType.NORMAL);
		public static final TagKey<Block> OCHRE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ochre_tiles"), TagType.NORMAL);

		public static final TagKey<Block> PALM = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/palm"), TagType.NORMAL);
		public static final TagKey<Block> NECLANE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/neclane"), TagType.NORMAL);
		public static final TagKey<Block> CYPRESS = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/cypress"), TagType.NORMAL);
		public static final TagKey<Block> VUXANCIA = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/vuxancia"), TagType.NORMAL);
		public static final TagKey<Block> NUME_WILLOW = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/nume_willow"), TagType.NORMAL);
		public static final TagKey<Block> NYRETH = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/nyreth"), TagType.NORMAL);
	}

	public static class Items {

		public static final TagKey<Item> LEAVES = QuiltTagKey.of(Registry.ITEM_KEY, Archeon.createId("leaves"), TagType.NORMAL);
		public static final TagKey<Item> LYCORIS_PETALS = QuiltTagKey.of(Registry.ITEM_KEY, Archeon.createId("lycoris_petals"), TagType.NORMAL);
		public static final TagKey<Item> PLANKS = QuiltTagKey.of(Registry.ITEM_KEY, Archeon.createId("planks"), TagType.NORMAL);
		public static final TagKey<Item> SHELLS = QuiltTagKey.of(Registry.ITEM_KEY, Archeon.createId("shells"), TagType.NORMAL);
		public static final TagKey<Item> TILES = QuiltTagKey.of(Registry.ITEM_KEY, Archeon.createId("tiles"), TagType.NORMAL);
	}

	public static class Entities {

		public static final TagKey<EntityType<?>> AURORA_CATALYSTS = QuiltTagKey.of(Registry.ENTITY_TYPE_KEY, Archeon.createId("aurora_catalysts"), TagType.NORMAL);
		public static final TagKey<EntityType<?>> CENTAURS = QuiltTagKey.of(Registry.ENTITY_TYPE_KEY, Archeon.createId("centaurs"), TagType.NORMAL);
	}
}
