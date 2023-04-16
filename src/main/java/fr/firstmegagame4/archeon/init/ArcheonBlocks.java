package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.blocks.DuneSandCastleBlock;
import fr.firstmegagame4.archeon.blocks.HeartOfNatureTrophyBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonBlocks implements ElementsInitializer {

	private static final QuiltBlockSettings STONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE);
	public static final QuiltBlockSettings WOOD_SETTINGS = QuiltBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD);
	public static final QuiltBlockSettings LEAVES_SETTINGS = QuiltBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque();
	public static final QuiltBlockSettings METAL_SETTINGS = QuiltBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL);
	public static final QuiltBlockSettings BONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.BONE);
	public static final QuiltBlockSettings GLASS_SETTINGS = QuiltBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque();
	public static final QuiltBlockSettings SAND_SETTINGS = QuiltBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND);
	public static final QuiltBlockSettings BASALT_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.BASALT);
	public static final QuiltBlockSettings LODESTONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.LODESTONE);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.REGENERATION,
		10,
		QuiltBlockSettings.of(Material.PLANT),
		true
	);

	// Double Plant : Need to Fix This

	public static final CustomFlowerBlock ASCENDIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.LEVITATION,
		5,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WATER_BREATHING,
		30,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock BLOOD_ORANGE_BUSH = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock COKIPLANT = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock DEAD_WET_GRASS_TUFFET = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.DARKNESS,
		20,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomBlock AKETITE_BASEBOARD = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_STAIRS = new CustomStairsBlock(AKETITE.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_BRICK_STAIRS = new CustomStairsBlock(AKETITE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_TILE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock AKETITE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_TILES_STAIRS = new CustomStairsBlock(AKETITE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomPillarBlock NECLANE_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NECLANE_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomBlock FLOWERED_NECLANE_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock NECLANE_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NECLANE_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NECLANE_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock NECLANE_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NECLANE_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock NECLANE_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NECLANE_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock NECLANE_STAIRS = new CustomStairsBlock(NECLANE_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock NECLANE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomTrapdoorBlock NECLANE_TRAPDOOR = new CustomTrapdoorBlock(STONE_SETTINGS, true);

	public static final CustomBlock APAFLORITE_BLOCK = new CustomBlock(METAL_SETTINGS, true);
	public static final CustomBlock APAFLORITE_ORE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BASEBOARD = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(ARTEMNITE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_TILES_STAIRS = new CustomStairsBlock(ARTEMNITE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock BLUE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock BLUE_TILES_STAIRS = new CustomStairsBlock(BLUE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock BLUE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock BLUE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock BUSH_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);

	public static final CustomPillarBlock BLOCK_OF_CERAMIC = new CustomPillarBlock(BONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone CERAMIC_BUTTON = new CustomButtonBlock.Stone(BONE_SETTINGS, true);
	public static final CustomFenceBlock CERAMIC_FENCE = new CustomFenceBlock(BONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CERAMIC_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_STAIRS = new CustomStairsBlock(BLOCK_OF_CERAMIC.getDefaultState(), BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_SLAB = new CustomSlabBlock(BONE_SETTINGS, true);

	public static final CustomPillarBlock CERAMIC_BRICKS = new CustomPillarBlock(BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_BRICK_STAIRS = new CustomStairsBlock(CERAMIC_BRICKS.getDefaultState(), BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_BRICK_SLAB = new CustomSlabBlock(BONE_SETTINGS, true);
	public static final CustomWallBlock CERAMIC_BRICK_WALL = new CustomWallBlock(BONE_SETTINGS, true);

	public static final CustomBlock CHISELED_AKETITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_ARTEMNITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_TROPICSTONE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock CLEMENTIUM_BLOCK = new CustomBlock(METAL_SETTINGS, true);

	public static final CustomBlock CRACKLED_AKETITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_TROPICSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock CRIMSON_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock CRIMSON_TILES_STAIRS = new CustomStairsBlock(CRIMSON_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock CRIMSON_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock CRIMSON_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomPillarBlock CYPRESS_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock CYPRESS_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock CYPRESS_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock CYPRESS_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden CYPRESS_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock CYPRESS_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock CYPRESS_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock CYPRESS_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock CYPRESS_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock CYPRESS_STAIRS = new CustomStairsBlock(CYPRESS_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock CYPRESS_SLAB = new CustomSlabBlock(WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock CYPRESS_TRAPDOOR = new CustomTrapdoorBlock(WOOD_SETTINGS, true);

	public static final CustomBlock DUNE_SAND_GLASS = new CustomBlock(GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES = new CustomBlock(GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_TOP_LEFT = new CustomBlock(GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_TOP_RIGHT = new CustomBlock(GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_BOTTOM_LEFT = new CustomBlock(GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT = new CustomBlock(GLASS_SETTINGS, true);

	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE = new CustomPaneBlock(GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES = new CustomPaneBlock(GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT = new CustomPaneBlock(GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT = new CustomPaneBlock(GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT = new CustomPaneBlock(GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT = new CustomPaneBlock(GLASS_SETTINGS, true);

	public static final DuneSandCastleBlock DUNE_SAND_CASTLE = new DuneSandCastleBlock(SAND_SETTINGS.nonOpaque(), true);

	public static final CustomFallingBlock DUST = new CustomFallingBlock(SAND_SETTINGS, true);

	public static final CustomBlock EXYRIANE_BLOCK = new CustomBlock(METAL_SETTINGS, true);
	public static final CustomBlock EXYRIANE_ORE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock FAELITE_BLOCK = new CustomBlock(METAL_SETTINGS, true);
	public static final CustomBlock FAELITE_ORE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock FALSE_SOUTHSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock FALSE_CRACKED_SOUTHSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock FALSE_MOSSY_SOUTHSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock FANCY_ARTEMNITE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock FANCY_ARTEMNITE_TILES_STAIRS = new CustomStairsBlock(FANCY_ARTEMNITE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock FANCY_ARTEMNITE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock FANCY_ARTEMNITE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock FANCY_CHISELED_ARTEMNITE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock GILDED_COBBLED_SOUTHSTONE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock GILDED_COBBLED_SOUTHSTONE_STAIRS = new CustomStairsBlock(GILDED_COBBLED_SOUTHSTONE.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock GILDED_COBBLED_SOUTHSTONE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock GILDED_COBBLED_SOUTHSTONE_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock GOLDEN_SAND = new CustomBlock(SAND_SETTINGS, true);

	public static final CustomBlock GREEN_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock GREEN_TILES_STAIRS = new CustomStairsBlock(GREEN_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock GREEN_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock GREEN_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock GYPSUM = new CustomBlock(BASALT_SETTINGS, true);
	public static final CustomPressurePlateBlock GYPSUM_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, BASALT_SETTINGS, true);
	public static final CustomStairsBlock GYPSUM_STAIRS = new CustomStairsBlock(GYPSUM.getDefaultState(), BASALT_SETTINGS, true);
	public static final CustomSlabBlock GYPSUM_SLAB = new CustomSlabBlock(BASALT_SETTINGS, true);
	public static final CustomWallBlock GYPSUM_WALL = new CustomWallBlock(BASALT_SETTINGS, true);

	public static final CustomBlock GYPSUM_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomFenceBlock GYPSUM_BRICK_FENCE = new CustomFenceBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock GYPSUM_BRICK_STAIRS = new CustomStairsBlock(GYPSUM_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock GYPSUM_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock GYPSUM_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final HeartOfNatureTrophyBlock HEART_OF_NATURE_TROPHY = new HeartOfNatureTrophyBlock(LODESTONE_SETTINGS.nonOpaque(), true);

	@Override
	public void register() {
		AEROLIA.register(Archeon.newIdentifier("aerolia"));
		ASCENDIA.register(Archeon.newIdentifier("ascendia"));
		ASTEDIBES.register(Archeon.newIdentifier("astedibes"));
		BLOOD_ORANGE_BUSH.register(Archeon.newIdentifier("blood_orange_bush"));
		COKIPLANT.register(Archeon.newIdentifier("cokiplant"));
		DEAD_WET_GRASS_TUFFET.register(Archeon.newIdentifier("dead_wet_grass_tuffet"));
		AKETITE_BASEBOARD.register(Archeon.newIdentifier("aketite_baseboard"));
		AKETITE.register(Archeon.newIdentifier("aketite"));
		AKETITE_STAIRS.register(Archeon.newIdentifier("aketite_stairs"));
		AKETITE_SLAB.register(Archeon.newIdentifier("aketite_slab"));
		AKETITE_WALL.register(Archeon.newIdentifier("aketite_wall"));
		AKETITE_BRICKS.register(Archeon.newIdentifier("aketite_bricks"));
		AKETITE_BRICK_STAIRS.register(Archeon.newIdentifier("aketite_brick_stairs"));
		AKETITE_BRICK_SLAB.register(Archeon.newIdentifier("aketite_brick_slab"));
		AKETITE_BRICK_WALL.register(Archeon.newIdentifier("aketite_brick_wall"));
		AKETITE_TILE.register(Archeon.newIdentifier("aketite_tile"));
		AKETITE_TILES.register(Archeon.newIdentifier("aketite_tiles"));
		AKETITE_TILES_STAIRS.register(Archeon.newIdentifier("aketite_tiles_stairs"));
		AKETITE_TILES_SLAB.register(Archeon.newIdentifier("aketite_tiles_slab"));
		AKETITE_TILES_WALL.register(Archeon.newIdentifier("aketite_tiles_wall"));
		NECLANE_LOG.register(Archeon.newIdentifier("neclane_log"));
		NECLANE_LEAVES.register(Archeon.newIdentifier("neclane_leaves"));
		FLOWERED_NECLANE_LEAVES.register(Archeon.newIdentifier("flowered_neclane_leaves"));
		NECLANE_WOOD.register(Archeon.newIdentifier("neclane_wood"));
		NECLANE_PLANKS.register(Archeon.newIdentifier("neclane_planks"));
		NECLANE_BUTTON.register(Archeon.newIdentifier("neclane_button"));
		NECLANE_DOOR.register(Archeon.newIdentifier("neclane_door"));
		NECLANE_PRESSURE_PLATE.register(Archeon.newIdentifier("neclane_pressure_plate"));
		NECLANE_FENCE.register(Archeon.newIdentifier("neclane_fence"));
		NECLANE_FENCE_GATE.register(Archeon.newIdentifier("neclane_fence_gate"));
		NECLANE_STAIRS.register(Archeon.newIdentifier("neclane_stairs"));
		NECLANE_SLAB.register(Archeon.newIdentifier("neclane_slab"));
		NECLANE_TRAPDOOR.register(Archeon.newIdentifier("neclane_trapdoor"));
		APAFLORITE_BLOCK.register(Archeon.newIdentifier("apaflorite_block"));
		APAFLORITE_ORE.register(Archeon.newIdentifier("apaflorite_ore"));
		ARTEMNITE_BASEBOARD.register(Archeon.newIdentifier("artemnite_baseboard"));
		ARTEMNITE.register(Archeon.newIdentifier("artemnite"));
		ARTEMNITE_BRICKS.register(Archeon.newIdentifier("artemnite_bricks"));
		ARTEMNITE_BRICK_STAIRS.register(Archeon.newIdentifier("artemnite_brick_stairs"));
		ARTEMNITE_BRICK_SLAB.register(Archeon.newIdentifier("artemnite_brick_slab"));
		ARTEMNITE_BRICK_WALL.register(Archeon.newIdentifier("artemnite_brick_wall"));
		ARTEMNITE_TILES.register(Archeon.newIdentifier("artemnite_tiles"));
		ARTEMNITE_TILES_STAIRS.register(Archeon.newIdentifier("artemnite_tiles_stairs"));
		ARTEMNITE_TILES_SLAB.register(Archeon.newIdentifier("artemnite_tiles_slab"));
		ARTEMNITE_TILES_WALL.register(Archeon.newIdentifier("artemnite_tiles_wall"));
		BLUE_TILES.register(Archeon.newIdentifier("blue_tiles"));
		BLUE_TILES_STAIRS.register(Archeon.newIdentifier("blue_tiles_stairs"));
		BLUE_TILES_SLAB.register(Archeon.newIdentifier("blue_tiles_slab"));
		BLUE_TILES_WALL.register(Archeon.newIdentifier("blue_tiles_wall"));
		BUSH_LEAVES.register(Archeon.newIdentifier("bush_leaves"));
		BLOCK_OF_CERAMIC.register(Archeon.newIdentifier("block_of_ceramic"));
		CERAMIC_BUTTON.register(Archeon.newIdentifier("ceramic_button"));
		CERAMIC_FENCE.register(Archeon.newIdentifier("ceramic_fence"));
		CERAMIC_PRESSURE_PLATE.register(Archeon.newIdentifier("ceramic_pressure_plate"));
		CERAMIC_STAIRS.register(Archeon.newIdentifier("ceramic_stairs"));
		CERAMIC_SLAB.register(Archeon.newIdentifier("ceramic_slab"));
		CERAMIC_BRICKS.register(Archeon.newIdentifier("ceramic_bricks"));
		CERAMIC_BRICK_STAIRS.register(Archeon.newIdentifier("ceramic_brick_stairs"));
		CERAMIC_BRICK_SLAB.register(Archeon.newIdentifier("ceramic_brick_slab"));
		CERAMIC_BRICK_WALL.register(Archeon.newIdentifier("ceramic_brick_wall"));
		CHISELED_AKETITE.register(Archeon.newIdentifier("chiseled_aketite"));
		CHISELED_ARTEMNITE.register(Archeon.newIdentifier("chiseled_artemnite"));
		CHISELED_TROPICSTONE.register(Archeon.newIdentifier("chiseled_tropicstone"));
		CLEMENTIUM_BLOCK.register(Archeon.newIdentifier("clementium_block"));
		CRACKLED_AKETITE_BRICKS.register(Archeon.newIdentifier("crackled_aketite_bricks"));
		CRACKLED_ARTEMNITE_BRICKS.register(Archeon.newIdentifier("crackled_artemnite_bricks"));
		CRACKLED_TROPICSTONE_BRICKS.register(Archeon.newIdentifier("crackled_tropicstone_bricks"));
		CRIMSON_TILES.register(Archeon.newIdentifier("crimson_tiles"));
		CRIMSON_TILES_STAIRS.register(Archeon.newIdentifier("crimson_tiles_stairs"));
		CRIMSON_TILES_SLAB.register(Archeon.newIdentifier("crimson_tiles_slab"));
		CRIMSON_TILES_WALL.register(Archeon.newIdentifier("crimson_tiles_wall"));
		CYPRESS_LOG.register(Archeon.newIdentifier("cypress_log"));
		CYPRESS_LEAVES.register(Archeon.newIdentifier("cypress_leaves"));
		CYPRESS_WOOD.register(Archeon.newIdentifier("cypress_wood"));
		CYPRESS_PLANKS.register(Archeon.newIdentifier("cypress_planks"));
		CYPRESS_BUTTON.register(Archeon.newIdentifier("cypress_button"));
		CYPRESS_DOOR.register(Archeon.newIdentifier("cypress_door"));
		CYPRESS_PRESSURE_PLATE.register(Archeon.newIdentifier("cypress_pressure_plate"));
		CYPRESS_FENCE.register(Archeon.newIdentifier("cypress_fence"));
		CYPRESS_FENCE_GATE.register(Archeon.newIdentifier("cypress_fence_gate"));
		CYPRESS_STAIRS.register(Archeon.newIdentifier("cypress_stairs"));
		CYPRESS_SLAB.register(Archeon.newIdentifier("cypress_slab"));
		CYPRESS_TRAPDOOR.register(Archeon.newIdentifier("cypress_trapdoor"));
		DUNE_SAND_GLASS.register(Archeon.newIdentifier("dune_sand_glass"));
		DUNE_SAND_GLASS_TILES.register(Archeon.newIdentifier("dune_sand_glass_tiles"));
		DUNE_SAND_GLASS_TILES_TOP_LEFT.register(Archeon.newIdentifier("dune_sand_glass_tiles_top_left"));
		DUNE_SAND_GLASS_TILES_TOP_RIGHT.register(Archeon.newIdentifier("dune_sand_glass_tiles_top_right"));
		DUNE_SAND_GLASS_TILES_BOTTOM_LEFT.register(Archeon.newIdentifier("dune_sand_glass_tiles_bottom_left"));
		DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT.register(Archeon.newIdentifier("dune_sand_glass_tiles_bottom_right"));
		DUNE_SAND_GLASS_PANE.register(Archeon.newIdentifier("dune_sand_glass_pane"));
		DUNE_SAND_GLASS_PANE_TILES.register(Archeon.newIdentifier("dune_sand_glass_pane_tiles"));
		DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT.register(Archeon.newIdentifier("dune_sand_glass_pane_tiles_top_left"));
		DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT.register(Archeon.newIdentifier("dune_sand_glass_pane_tiles_top_right"));
		DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT.register(Archeon.newIdentifier("dune_sand_glass_pane_tiles_bottom_left"));
		DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT.register(Archeon.newIdentifier("dune_sand_glass_pane_tiles_bottom_right"));
		DUNE_SAND_CASTLE.register(Archeon.newIdentifier("dune_sand_castle"));
		DUST.register(Archeon.newIdentifier("dust"));
		EXYRIANE_BLOCK.register(Archeon.newIdentifier("exyriane_block"));
		EXYRIANE_ORE.register(Archeon.newIdentifier("exyriane_ore"));
		FAELITE_BLOCK.register(Archeon.newIdentifier("faelite_block"));
		FAELITE_ORE.register(Archeon.newIdentifier("faelite_ore"));
		FALSE_SOUTHSTONE_BRICKS.register(Archeon.newIdentifier("false_southstone_bricks"));
		FALSE_CRACKED_SOUTHSTONE_BRICKS.register(Archeon.newIdentifier("false_cracked_southstone_bricks"));
		FALSE_MOSSY_SOUTHSTONE_BRICKS.register(Archeon.newIdentifier("false_mossy_southstone_bricks"));
		FANCY_ARTEMNITE_TILES.register(Archeon.newIdentifier("fancy_artemnite_tiles"));
		FANCY_ARTEMNITE_TILES_STAIRS.register(Archeon.newIdentifier("fancy_artemnite_tiles_stairs"));
		FANCY_ARTEMNITE_TILES_SLAB.register(Archeon.newIdentifier("fancy_artemnite_tiles_slab"));
		FANCY_ARTEMNITE_TILES_WALL.register(Archeon.newIdentifier("fancy_artemnite_tiles_wall"));
		FANCY_CHISELED_ARTEMNITE.register(Archeon.newIdentifier("fancy_chiseled_artemnite"));
		GILDED_COBBLED_SOUTHSTONE.register(Archeon.newIdentifier("gilded_cobbled_southstone"));
		GILDED_COBBLED_SOUTHSTONE_STAIRS.register(Archeon.newIdentifier("gilded_cobbled_southstone_stairs"));
		GILDED_COBBLED_SOUTHSTONE_SLAB.register(Archeon.newIdentifier("gilded_cobbled_southstone_slab"));
		GILDED_COBBLED_SOUTHSTONE_WALL.register(Archeon.newIdentifier("gilded_cobbled_southstone_wall"));
		GOLDEN_SAND.register(Archeon.newIdentifier("golden_sand"));
		GREEN_TILES.register(Archeon.newIdentifier("green_tiles"));
		GREEN_TILES_STAIRS.register(Archeon.newIdentifier("green_tiles_stairs"));
		GREEN_TILES_SLAB.register(Archeon.newIdentifier("green_tiles_slab"));
		GREEN_TILES_WALL.register(Archeon.newIdentifier("green_tiles_wall"));
		GYPSUM.register(Archeon.newIdentifier("gypsum"));
		GYPSUM_PRESSURE_PLATE.register(Archeon.newIdentifier("gypsum_pressure_plate"));
		GYPSUM_STAIRS.register(Archeon.newIdentifier("gypsum_stairs"));
		GYPSUM_SLAB.register(Archeon.newIdentifier("gypsum_slab"));
		GYPSUM_WALL.register(Archeon.newIdentifier("gypsum_wall"));
		GYPSUM_BRICKS.register(Archeon.newIdentifier("gypsum_bricks"));
		GYPSUM_BRICK_FENCE.register(Archeon.newIdentifier("gypsum_brick_fence"));
		GYPSUM_BRICK_STAIRS.register(Archeon.newIdentifier("gypsum_brick_stairs"));
		GYPSUM_BRICK_SLAB.register(Archeon.newIdentifier("gypsum_brick_slab"));
		GYPSUM_BRICK_WALL.register(Archeon.newIdentifier("gypsum_brick_wall"));
		HEART_OF_NATURE_TROPHY.register(Archeon.newIdentifier("heart_of_nature_trophy"));
	}
}
