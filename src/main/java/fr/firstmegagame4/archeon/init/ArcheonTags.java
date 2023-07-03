package fr.firstmegagame4.archeon.init;

import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.tag.api.QuiltTagKey;
import org.quiltmc.qsl.tag.api.TagType;

public class ArcheonTags {

	public static final TagKey<Block> SOIL = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/soil"), TagType.NORMAL);
	public static final TagKey<Block> STONE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/stone"), TagType.NORMAL);
	public static final TagKey<Block> LEAVES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/leaves"), TagType.NORMAL);
	public static final TagKey<Block> WOOD = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/wood"), TagType.NORMAL);
	public static final TagKey<Block> METALS = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("equivalents/metals"), TagType.NORMAL);

	public static final TagKey<Block> SOUTHSTONE_ORES_REPLACEABLES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/southstone_ore"), TagType.NORMAL);
	public static final TagKey<Block> DEPTHS_AKETITE_ORES_REPLACEABLES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("replaceables/depths_aketite_ore"), TagType.NORMAL);

	public static final TagKey<Block> SOUTHSTONE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/southstone"), TagType.NORMAL);
	public static final TagKey<Block> ORES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ores"), TagType.NORMAL);
	public static final TagKey<Block> AKETITE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/aketite"), TagType.NORMAL);
	public static final TagKey<Block> MYSTERIOUS_STONE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/mysterious_stone"), TagType.NORMAL);
	public static final TagKey<Block> ARTEMNITE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/artemnite"), TagType.NORMAL);
	public static final TagKey<Block> GYPSUM_BRICKS = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/gypsum_bricks"), TagType.NORMAL);
	public static final TagKey<Block> ROUGHCAST = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/roughcast"), TagType.NORMAL);
	public static final TagKey<Block> WARPED_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/warped_tiles"), TagType.NORMAL);
	public static final TagKey<Block> CRIMSON_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/crimson_tiles"), TagType.NORMAL);
	public static final TagKey<Block> RED_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/red_tiles"), TagType.NORMAL);
	public static final TagKey<Block> OCHRE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/ochre_tiles"), TagType.NORMAL);
	public static final TagKey<Block> BLUE_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/blue_tiles"), TagType.NORMAL);
	public static final TagKey<Block> GREEN_TILES = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("stone/green_tiles"), TagType.NORMAL);

	public static final TagKey<Block> PALM = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/palm"), TagType.NORMAL);
	public static final TagKey<Block> NECLANE = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/neclane"), TagType.NORMAL);
	public static final TagKey<Block> CYPRESS = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/cypress"), TagType.NORMAL);
	public static final TagKey<Block> VUXANCIA = QuiltTagKey.of(Registry.BLOCK_KEY, Archeon.createId("wood/vuxancia"), TagType.NORMAL);
}
