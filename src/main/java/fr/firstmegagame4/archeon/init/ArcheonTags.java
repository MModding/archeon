package fr.firstmegagame4.archeon.init;

import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class ArcheonTags {

	public static final TagKey<Block> SOIL = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/soil"));
	public static final TagKey<Block> STONE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/stone"));
	public static final TagKey<Block> LEAVES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/leaves"));
	public static final TagKey<Block> WOOD = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/wood"));

	public static final TagKey<Block> SOUTHSTONE_ORES_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/southstone_ore"));
	public static final TagKey<Block> DEPTHS_AKETITE_ORES_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/depths_aketite_ore"));

	public static final TagKey<Block> SOUTHSTONE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/southstone"));
	public static final TagKey<Block> ORES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ores"));
	public static final TagKey<Block> AKETITE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/aketite"));
	public static final TagKey<Block> MYSTERIOUS_STONE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/mysterious_stone"));
	public static final TagKey<Block> ARTEMNITE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/artemnite"));
	public static final TagKey<Block> GYPSUM_BRICKS = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/gypsum_bricks"));
	public static final TagKey<Block> ROUGHCAST = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/roughcast"));
	public static final TagKey<Block> WARPED_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/warped_tiles"));
	public static final TagKey<Block> CRIMSON_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/crimson_tiles"));
	public static final TagKey<Block> RED_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/red_tiles"));
	public static final TagKey<Block> OCHRE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ochre_tiles"));
	public static final TagKey<Block> BLUE_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/blue_tiles"));
	public static final TagKey<Block> GREEN_TILES = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/green_tiles"));

	public static final TagKey<Block> PALM = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/palm"));
	public static final TagKey<Block> NECLANE = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/neclane"));
	public static final TagKey<Block> CYPRESS = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/cypress"));
	public static final TagKey<Block> VUXANCIA = TagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/vuxancia"));
}
