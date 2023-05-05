package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.blocks.*;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonBlocks implements ElementsInitializer {

	private static final QuiltBlockSettings STONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE);
	public static final QuiltBlockSettings WOOD_SETTINGS = QuiltBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD);
	public static final QuiltBlockSettings GRASS_SETTINGS = QuiltBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRASS);
	public static final QuiltBlockSettings PLANT_SETTINGS = QuiltBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).collidable(false);
	public static final QuiltBlockSettings LEAVES_SETTINGS = QuiltBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque();
	public static final QuiltBlockSettings SNOW_SETTINGS = QuiltBlockSettings.of(Material.SNOW_LAYER).sounds(BlockSoundGroup.SNOW).nonOpaque();
	public static final QuiltBlockSettings SNOW_BLOCK_SETTINGS = QuiltBlockSettings.of(Material.SNOW_BLOCK).sounds(BlockSoundGroup.SNOW);
	public static final QuiltBlockSettings METAL_SETTINGS = QuiltBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL);
	public static final QuiltBlockSettings BONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.BONE);
	public static final QuiltBlockSettings GLASS_SETTINGS = QuiltBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque();
	public static final QuiltBlockSettings SAND_SETTINGS = QuiltBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND);
	public static final QuiltBlockSettings CLAY_SETTINGS = QuiltBlockSettings.of(Material.ORGANIC_PRODUCT).sounds(BlockSoundGroup.SAND);
	public static final QuiltBlockSettings BASALT_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.BASALT);
	public static final QuiltBlockSettings LODESTONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.LODESTONE);
	public static final QuiltBlockSettings LEAVES_CARPET = QuiltBlockSettings.of(Material.CARPET).sounds(BlockSoundGroup.GRASS).nonOpaque();
	public static final QuiltBlockSettings NETHERITE_SETTINGS = QuiltBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.REGENERATION,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock ASCENDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WATER_BREATHING,
		30,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock BLOOD_ORANGE_BUSH = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock COKIPLANT = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock DEAD_WET_GRASS_TUFFET = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.DARKNESS,
		20,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock IOPEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.DOLPHINS_GRACE,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock LYCORIS_RADIATA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.NAUSEA,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock LYCORIS_SANGUINEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.STRENGTH,
		20,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock OEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.NIGHT_VISION,
		30,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ORCHID = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.RESISTANCE,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ORGANDEANE_BLOSSOM = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.JUMP_BOOST,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock ORGANDEANE_TALL = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock RED_LYCORIS = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.SPEED,
		30,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ROSEYPIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.UNLUCK,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock SEPTICEOLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.DARKNESS,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WITHER,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock WITHERED_ASCENDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WITHER,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_IOPEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WITHER,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_OEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WITHER,
		10,
		PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_ORCHID = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WITHER,
		10,
		PLANT_SETTINGS,
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
	public static final CustomBlock NECLANE_BOOKSHELF = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NECLANE_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock NECLANE_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NECLANE_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock NECLANE_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NECLANE_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock NECLANE_STAIRS = new CustomStairsBlock(NECLANE_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock NECLANE_SLAB = new CustomSlabBlock(WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NECLANE_TRAPDOOR = new CustomTrapdoorBlock(WOOD_SETTINGS, true);

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
	public static final CustomBlock CHISELED_SOUTHSTONE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock CLEMENTIUM_BLOCK = new CustomBlock(METAL_SETTINGS, true);

	public static final CustomBlock CRACKLED_AKETITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_SOUTHSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);

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

	public static final HollowCypressLogBlock HOLLOW_CYPRESS_LOG = new HollowCypressLogBlock(WOOD_SETTINGS.nonOpaque(), true);

	public static final LeavesCarpetBlock LEAVES_CARPET_ORIAN = new LeavesCarpetBlock(LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_PNEVANTIAL = new LeavesCarpetBlock(LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_STREIAN = new LeavesCarpetBlock(LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_VALE = new LeavesCarpetBlock(LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_ZIAL = new LeavesCarpetBlock(LEAVES_CARPET, true);

	public static final CustomBlock LOOT_URN = new CustomBlock(BONE_SETTINGS.nonOpaque(), true);

	public static final CustomBlock LUSONYTH_BLOCK = new CustomBlock(METAL_SETTINGS, true);

	public static final CustomBlock MOSSY_ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(MOSSY_ARTEMNITE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_ARTEMNITE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_SOUTHSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_SOUTHSTONE_BRICK_STAIRS = new CustomStairsBlock(MOSSY_SOUTHSTONE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_SOUTHSTONE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_SOUTHSTONE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_COBBLED_SOUTHSTONE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_COBBLED_SOUTHSTONE_STAIRS = new CustomStairsBlock(MOSSY_SOUTHSTONE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_COBBLED_SOUTHSTONE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_COBBLED_SOUTHSTONE_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock MYSTERIOUS_STONE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock MYSTERIOUS_STONE_STAIRS = new CustomStairsBlock(MYSTERIOUS_STONE.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock MYSTERIOUS_STONE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);

	public static final NaturiteBlock NATURITE_BLOCK = new NaturiteBlock(NETHERITE_SETTINGS, true);

	public static final CustomPillarBlock NUME_WILLOW_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NUME_WILLOW_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock NUME_WILLOW_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NUME_WILLOW_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NUME_WILLOW_BOOKSHELF = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NUME_WILLOW_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock NUME_WILLOW_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NUME_WILLOW_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock NUME_WILLOW_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NUME_WILLOW_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock NUME_WILLOW_STAIRS = new CustomStairsBlock(NUME_WILLOW_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock NUME_WILLOW_SLAB = new CustomSlabBlock(WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NUME_WILLOW_TRAPDOOR = new CustomTrapdoorBlock(WOOD_SETTINGS, true);

	public static final CustomPillarBlock NYRETH_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomBlock PALE_NYRETH_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock NYRETH_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_BOOKSHELF = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NYRETH_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock NYRETH_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NYRETH_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock NYRETH_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NYRETH_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock NYRETH_STAIRS = new CustomStairsBlock(NYRETH_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock NYRETH_SLAB = new CustomSlabBlock(WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NYRETH_TRAPDOOR = new CustomTrapdoorBlock(WOOD_SETTINGS, true);

	public static final CustomBlock OCHRE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock OCHRE_TILES_STAIRS = new CustomStairsBlock(OCHRE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock OCHRE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock OCHRE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_CHISELED_AKETITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_LINES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_TEARS = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_LINES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_TEARS = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomPillarBlock PALM_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock PALM_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock PALM_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock PALM_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomBlock PALM_BOOKSHELF = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden PALM_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock PALM_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock PALM_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock PALM_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock PALM_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock PALM_STAIRS = new CustomStairsBlock(PALM_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock PALM_SLAB = new CustomSlabBlock(WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock PALM_TRAPDOOR = new CustomTrapdoorBlock(WOOD_SETTINGS, true);

	public static final CustomBlock PEAKS_GRASS_BLOCK = new CustomBlock(GRASS_SETTINGS, true);
	public static final CustomSnowBlock PEAKS_SNOW = new CustomSnowBlock(SNOW_SETTINGS, true);
	public static final CustomSnowBlock PEAKS_SNOW_BLOCK = new CustomSnowBlock(SNOW_BLOCK_SETTINGS, true);

	public static final CustomBlock POWER_KEYSTONE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock RED_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock RED_TILES_STAIRS = new CustomStairsBlock(RED_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock RED_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock RED_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock ROUGHCAST = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock ROUGHCAST_STAIRS = new CustomStairsBlock(ROUGHCAST.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock ROUGHCAST_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock ROUGHCAST_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomFallingBlock SALT_BLOCK = new CustomFallingBlock(SAND_SETTINGS, true);
	public static final CustomFallingBlock SANDY_SOIL = new CustomFallingBlock(CLAY_SETTINGS, true);
	public static final CustomFallingBlock SHELLSAND = new CustomFallingBlock(SAND_SETTINGS, true);

	@Override
	public void register() {
		AEROLIA.register(Archeon.createId("aerolia"));
		ASCENDIA.register(Archeon.createId("ascendia"));
		ASTEDIBES.register(Archeon.createId("astedibes"));
		BLOOD_ORANGE_BUSH.register(Archeon.createId("blood_orange_bush"));
		COKIPLANT.register(Archeon.createId("cokiplant"));
		DEAD_WET_GRASS_TUFFET.register(Archeon.createId("dead_wet_grass_tuffet"));
		IOPEA.register(Archeon.createId("iopea"));
		LYCORIS_RADIATA.register(Archeon.createId("lycoris_radiata"));
		LYCORIS_SANGUINEA.register(Archeon.createId("lycoris_sanguinea"));
		OEA.register(Archeon.createId("oea"));
		ORCHID.register(Archeon.createId("orchid"));
		ORGANDEANE_BLOSSOM.register(Archeon.createId("organdeane_blossom"));
		ORGANDEANE_TALL.register(Archeon.createId("organdeane_tall"));
		RED_LYCORIS.register(Archeon.createId("red_lycoris"));
		ROSEYPIA.register(Archeon.createId("roseypia"));
		SEPTICEOLIA.register(Archeon.createId("septiceolia"));
		WITHERED_AEROLIA.register(Archeon.createId("withered_aerolia"));
		WITHERED_ASCENDIA.register(Archeon.createId("withered_ascendia"));
		WITHERED_ASTEDIBES.register(Archeon.createId("withered_astedibes"));
		WITHERED_IOPEA.register(Archeon.createId("withered_iopea"));
		WITHERED_OEA.register(Archeon.createId("withered_oea"));
		WITHERED_ORCHID.register(Archeon.createId("withered_orchid"));
		AKETITE_BASEBOARD.register(Archeon.createId("aketite_baseboard"));
		AKETITE.register(Archeon.createId("aketite"));
		AKETITE_STAIRS.register(Archeon.createId("aketite_stairs"));
		AKETITE_SLAB.register(Archeon.createId("aketite_slab"));
		AKETITE_WALL.register(Archeon.createId("aketite_wall"));
		AKETITE_BRICKS.register(Archeon.createId("aketite_bricks"));
		AKETITE_BRICK_STAIRS.register(Archeon.createId("aketite_brick_stairs"));
		AKETITE_BRICK_SLAB.register(Archeon.createId("aketite_brick_slab"));
		AKETITE_BRICK_WALL.register(Archeon.createId("aketite_brick_wall"));
		AKETITE_TILE.register(Archeon.createId("aketite_tile"));
		AKETITE_TILES.register(Archeon.createId("aketite_tiles"));
		AKETITE_TILES_STAIRS.register(Archeon.createId("aketite_tiles_stairs"));
		AKETITE_TILES_SLAB.register(Archeon.createId("aketite_tiles_slab"));
		AKETITE_TILES_WALL.register(Archeon.createId("aketite_tiles_wall"));
		NECLANE_LOG.register(Archeon.createId("neclane_log"));
		NECLANE_LEAVES.register(Archeon.createId("neclane_leaves"));
		FLOWERED_NECLANE_LEAVES.register(Archeon.createId("flowered_neclane_leaves"));
		NECLANE_WOOD.register(Archeon.createId("neclane_wood"));
		NECLANE_PLANKS.register(Archeon.createId("neclane_planks"));
		NECLANE_BOOKSHELF.register(Archeon.createId("neclane_bookshelf"));
		NECLANE_BUTTON.register(Archeon.createId("neclane_button"));
		NECLANE_DOOR.register(Archeon.createId("neclane_door"));
		NECLANE_PRESSURE_PLATE.register(Archeon.createId("neclane_pressure_plate"));
		NECLANE_FENCE.register(Archeon.createId("neclane_fence"));
		NECLANE_FENCE_GATE.register(Archeon.createId("neclane_fence_gate"));
		NECLANE_STAIRS.register(Archeon.createId("neclane_stairs"));
		NECLANE_SLAB.register(Archeon.createId("neclane_slab"));
		NECLANE_TRAPDOOR.register(Archeon.createId("neclane_trapdoor"));
		APAFLORITE_BLOCK.register(Archeon.createId("apaflorite_block"));
		APAFLORITE_ORE.register(Archeon.createId("apaflorite_ore"));
		ARTEMNITE_BASEBOARD.register(Archeon.createId("artemnite_baseboard"));
		ARTEMNITE.register(Archeon.createId("artemnite"));
		ARTEMNITE_BRICKS.register(Archeon.createId("artemnite_bricks"));
		ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("artemnite_brick_stairs"));
		ARTEMNITE_BRICK_SLAB.register(Archeon.createId("artemnite_brick_slab"));
		ARTEMNITE_BRICK_WALL.register(Archeon.createId("artemnite_brick_wall"));
		ARTEMNITE_TILES.register(Archeon.createId("artemnite_tiles"));
		ARTEMNITE_TILES_STAIRS.register(Archeon.createId("artemnite_tiles_stairs"));
		ARTEMNITE_TILES_SLAB.register(Archeon.createId("artemnite_tiles_slab"));
		ARTEMNITE_TILES_WALL.register(Archeon.createId("artemnite_tiles_wall"));
		BLUE_TILES.register(Archeon.createId("blue_tiles"));
		BLUE_TILES_STAIRS.register(Archeon.createId("blue_tiles_stairs"));
		BLUE_TILES_SLAB.register(Archeon.createId("blue_tiles_slab"));
		BLUE_TILES_WALL.register(Archeon.createId("blue_tiles_wall"));
		BUSH_LEAVES.register(Archeon.createId("bush_leaves"));
		BLOCK_OF_CERAMIC.register(Archeon.createId("block_of_ceramic"));
		CERAMIC_BUTTON.register(Archeon.createId("ceramic_button"));
		CERAMIC_FENCE.register(Archeon.createId("ceramic_fence"));
		CERAMIC_PRESSURE_PLATE.register(Archeon.createId("ceramic_pressure_plate"));
		CERAMIC_STAIRS.register(Archeon.createId("ceramic_stairs"));
		CERAMIC_SLAB.register(Archeon.createId("ceramic_slab"));
		CERAMIC_BRICKS.register(Archeon.createId("ceramic_bricks"));
		CERAMIC_BRICK_STAIRS.register(Archeon.createId("ceramic_brick_stairs"));
		CERAMIC_BRICK_SLAB.register(Archeon.createId("ceramic_brick_slab"));
		CERAMIC_BRICK_WALL.register(Archeon.createId("ceramic_brick_wall"));
		CHISELED_AKETITE.register(Archeon.createId("chiseled_aketite"));
		CHISELED_ARTEMNITE.register(Archeon.createId("chiseled_artemnite"));
		CHISELED_SOUTHSTONE.register(Archeon.createId("chiseled_southstone"));
		CLEMENTIUM_BLOCK.register(Archeon.createId("clementium_block"));
		CRACKLED_AKETITE_BRICKS.register(Archeon.createId("crackled_aketite_bricks"));
		CRACKLED_ARTEMNITE_BRICKS.register(Archeon.createId("crackled_artemnite_bricks"));
		CRACKLED_SOUTHSTONE_BRICKS.register(Archeon.createId("crackled_southstone_bricks"));
		CRIMSON_TILES.register(Archeon.createId("crimson_tiles"));
		CRIMSON_TILES_STAIRS.register(Archeon.createId("crimson_tiles_stairs"));
		CRIMSON_TILES_SLAB.register(Archeon.createId("crimson_tiles_slab"));
		CRIMSON_TILES_WALL.register(Archeon.createId("crimson_tiles_wall"));
		CYPRESS_LOG.register(Archeon.createId("cypress_log"));
		CYPRESS_LEAVES.register(Archeon.createId("cypress_leaves"));
		CYPRESS_WOOD.register(Archeon.createId("cypress_wood"));
		CYPRESS_PLANKS.register(Archeon.createId("cypress_planks"));
		CYPRESS_BUTTON.register(Archeon.createId("cypress_button"));
		CYPRESS_DOOR.register(Archeon.createId("cypress_door"));
		CYPRESS_PRESSURE_PLATE.register(Archeon.createId("cypress_pressure_plate"));
		CYPRESS_FENCE.register(Archeon.createId("cypress_fence"));
		CYPRESS_FENCE_GATE.register(Archeon.createId("cypress_fence_gate"));
		CYPRESS_STAIRS.register(Archeon.createId("cypress_stairs"));
		CYPRESS_SLAB.register(Archeon.createId("cypress_slab"));
		CYPRESS_TRAPDOOR.register(Archeon.createId("cypress_trapdoor"));
		DUNE_SAND_GLASS.register(Archeon.createId("dune_sand_glass"));
		DUNE_SAND_GLASS_TILES.register(Archeon.createId("dune_sand_glass_tiles"));
		DUNE_SAND_GLASS_TILES_TOP_LEFT.register(Archeon.createId("dune_sand_glass_tiles_top_left"));
		DUNE_SAND_GLASS_TILES_TOP_RIGHT.register(Archeon.createId("dune_sand_glass_tiles_top_right"));
		DUNE_SAND_GLASS_TILES_BOTTOM_LEFT.register(Archeon.createId("dune_sand_glass_tiles_bottom_left"));
		DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT.register(Archeon.createId("dune_sand_glass_tiles_bottom_right"));
		DUNE_SAND_GLASS_PANE.register(Archeon.createId("dune_sand_glass_pane"));
		DUNE_SAND_GLASS_PANE_TILES.register(Archeon.createId("dune_sand_glass_pane_tiles"));
		DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT.register(Archeon.createId("dune_sand_glass_pane_tiles_top_left"));
		DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT.register(Archeon.createId("dune_sand_glass_pane_tiles_top_right"));
		DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT.register(Archeon.createId("dune_sand_glass_pane_tiles_bottom_left"));
		DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT.register(Archeon.createId("dune_sand_glass_pane_tiles_bottom_right"));
		DUNE_SAND_CASTLE.register(Archeon.createId("dune_sand_castle"));
		DUST.register(Archeon.createId("dust"));
		EXYRIANE_BLOCK.register(Archeon.createId("exyriane_block"));
		EXYRIANE_ORE.register(Archeon.createId("exyriane_ore"));
		FAELITE_BLOCK.register(Archeon.createId("faelite_block"));
		FAELITE_ORE.register(Archeon.createId("faelite_ore"));
		FALSE_SOUTHSTONE_BRICKS.register(Archeon.createId("false_southstone_bricks"));
		FALSE_CRACKED_SOUTHSTONE_BRICKS.register(Archeon.createId("false_cracked_southstone_bricks"));
		FALSE_MOSSY_SOUTHSTONE_BRICKS.register(Archeon.createId("false_mossy_southstone_bricks"));
		FANCY_ARTEMNITE_TILES.register(Archeon.createId("fancy_artemnite_tiles"));
		FANCY_ARTEMNITE_TILES_STAIRS.register(Archeon.createId("fancy_artemnite_tiles_stairs"));
		FANCY_ARTEMNITE_TILES_SLAB.register(Archeon.createId("fancy_artemnite_tiles_slab"));
		FANCY_ARTEMNITE_TILES_WALL.register(Archeon.createId("fancy_artemnite_tiles_wall"));
		FANCY_CHISELED_ARTEMNITE.register(Archeon.createId("fancy_chiseled_artemnite"));
		GILDED_COBBLED_SOUTHSTONE.register(Archeon.createId("gilded_cobbled_southstone"));
		GILDED_COBBLED_SOUTHSTONE_STAIRS.register(Archeon.createId("gilded_cobbled_southstone_stairs"));
		GILDED_COBBLED_SOUTHSTONE_SLAB.register(Archeon.createId("gilded_cobbled_southstone_slab"));
		GILDED_COBBLED_SOUTHSTONE_WALL.register(Archeon.createId("gilded_cobbled_southstone_wall"));
		GOLDEN_SAND.register(Archeon.createId("golden_sand"));
		GREEN_TILES.register(Archeon.createId("green_tiles"));
		GREEN_TILES_STAIRS.register(Archeon.createId("green_tiles_stairs"));
		GREEN_TILES_SLAB.register(Archeon.createId("green_tiles_slab"));
		GREEN_TILES_WALL.register(Archeon.createId("green_tiles_wall"));
		GYPSUM.register(Archeon.createId("gypsum"));
		GYPSUM_PRESSURE_PLATE.register(Archeon.createId("gypsum_pressure_plate"));
		GYPSUM_STAIRS.register(Archeon.createId("gypsum_stairs"));
		GYPSUM_SLAB.register(Archeon.createId("gypsum_slab"));
		GYPSUM_WALL.register(Archeon.createId("gypsum_wall"));
		GYPSUM_BRICKS.register(Archeon.createId("gypsum_bricks"));
		GYPSUM_BRICK_FENCE.register(Archeon.createId("gypsum_brick_fence"));
		GYPSUM_BRICK_STAIRS.register(Archeon.createId("gypsum_brick_stairs"));
		GYPSUM_BRICK_SLAB.register(Archeon.createId("gypsum_brick_slab"));
		GYPSUM_BRICK_WALL.register(Archeon.createId("gypsum_brick_wall"));
		HEART_OF_NATURE_TROPHY.register(Archeon.createId("heart_of_nature_trophy"));
		HOLLOW_CYPRESS_LOG.register(Archeon.createId("hollow_cypress_log"));
		LEAVES_CARPET_ORIAN.register(Archeon.createId("leaves_carpet_orian"));
		LEAVES_CARPET_PNEVANTIAL.register(Archeon.createId("leaves_carpet_pnevantial"));
		LEAVES_CARPET_STREIAN.register(Archeon.createId("leaves_carpet_streian"));
		LEAVES_CARPET_VALE.register(Archeon.createId("leaves_carpet_vale"));
		LEAVES_CARPET_ZIAL.register(Archeon.createId("leaves_carpet_zial"));
		LOOT_URN.register(Archeon.createId("loot_urn"));
		LUSONYTH_BLOCK.register(Archeon.createId("lusonyth_block"));
		MOSSY_ARTEMNITE_BRICKS.register(Archeon.createId("mossy_artemnite_bricks"));
		MOSSY_ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("mossy_artemnite_brick_stairs"));
		MOSSY_ARTEMNITE_BRICK_SLAB.register(Archeon.createId("mossy_artemnite_brick_slab"));
		MOSSY_ARTEMNITE_BRICK_WALL.register(Archeon.createId("mossy_artemnite_brick_wall"));
		MOSSY_SOUTHSTONE_BRICKS.register(Archeon.createId("mossy_southstone_bricks"));
		MOSSY_SOUTHSTONE_BRICK_STAIRS.register(Archeon.createId("mossy_southstone_brick_stairs"));
		MOSSY_SOUTHSTONE_BRICK_SLAB.register(Archeon.createId("mossy_southstone_brick_slab"));
		MOSSY_SOUTHSTONE_BRICK_WALL.register(Archeon.createId("mossy_southstone_brick_wall"));
		MOSSY_COBBLED_SOUTHSTONE.register(Archeon.createId("mossy_cobbled_southstone"));
		MOSSY_COBBLED_SOUTHSTONE_STAIRS.register(Archeon.createId("mossy_cobbled_southstone_stairs"));
		MOSSY_COBBLED_SOUTHSTONE_SLAB.register(Archeon.createId("mossy_cobbled_southstone_slab"));
		MOSSY_COBBLED_SOUTHSTONE_WALL.register(Archeon.createId("mossy_cobbled_southstone_wall"));
		MYSTERIOUS_STONE.register(Archeon.createId("mysterious_stone"));
		MYSTERIOUS_STONE_STAIRS.register(Archeon.createId("mysterious_stone_stairs"));
		MYSTERIOUS_STONE_SLAB.register(Archeon.createId("mysterious_stone_slab"));
		NATURITE_BLOCK.register(Archeon.createId("naturite"));
		NUME_WILLOW_LOG.register(Archeon.createId("nume_willow_log"));
		NUME_WILLOW_LEAVES.register(Archeon.createId("nume_willow_leaves"));
		NUME_WILLOW_WOOD.register(Archeon.createId("nume_willow_wood"));
		NUME_WILLOW_PLANKS.register(Archeon.createId("nume_willow_planks"));
		NUME_WILLOW_BOOKSHELF.register(Archeon.createId("nume_willow_bookshelf"));
		NUME_WILLOW_BUTTON.register(Archeon.createId("nume_willow_button"));
		NUME_WILLOW_DOOR.register(Archeon.createId("nume_willow_door"));
		NUME_WILLOW_PRESSURE_PLATE.register(Archeon.createId("nume_willow_pressure_plate"));
		NUME_WILLOW_FENCE.register(Archeon.createId("nume_willow_fence"));
		NUME_WILLOW_FENCE_GATE.register(Archeon.createId("nume_willow_fence_gate"));
		NUME_WILLOW_STAIRS.register(Archeon.createId("nume_willow_stairs"));
		NUME_WILLOW_SLAB.register(Archeon.createId("nume_willow_slab"));
		NUME_WILLOW_TRAPDOOR.register(Archeon.createId("nume_willow_trapdoor"));
		NYRETH_LOG.register(Archeon.createId("nyreth_log"));
		NYRETH_LEAVES.register(Archeon.createId("nyreth_leaves"));
		PALE_NYRETH_LEAVES.register(Archeon.createId("pale_nyreth_leaves"));
		NYRETH_WOOD.register(Archeon.createId("nyreth_wood"));
		NYRETH_PLANKS.register(Archeon.createId("nyreth_planks"));
		NYRETH_BOOKSHELF.register(Archeon.createId("nyreth_bookshelf"));
		NYRETH_BUTTON.register(Archeon.createId("nyreth_button"));
		NYRETH_DOOR.register(Archeon.createId("nyreth_door"));
		NYRETH_PRESSURE_PLATE.register(Archeon.createId("nyreth_pressure_plate"));
		NYRETH_FENCE.register(Archeon.createId("nyreth_fence"));
		NYRETH_FENCE_GATE.register(Archeon.createId("nyreth_fence_gate"));
		NYRETH_STAIRS.register(Archeon.createId("nyreth_stairs"));
		NYRETH_SLAB.register(Archeon.createId("nyreth_slab"));
		NYRETH_TRAPDOOR.register(Archeon.createId("nyreth_trapdoor"));
		OCHRE_TILES.register(Archeon.createId("ochre_tiles"));
		OCHRE_TILES_STAIRS.register(Archeon.createId("ochre_tiles_stairs"));
		OCHRE_TILES_SLAB.register(Archeon.createId("ochre_tiles_slab"));
		OCHRE_TILES_WALL.register(Archeon.createId("ochre_tiles_wall"));
		ORNATE_CHISELED_AKETITE.register(Archeon.createId("ornate_chiseled_aketite"));
		ORNATE_AKETITE_BRICKS_LINES.register(Archeon.createId("ornate_aketite_bricks_lines"));
		ORNATE_AKETITE_BRICKS_TEARS.register(Archeon.createId("ornate_aketite_bricks_tears"));
		ORNATE_ARTEMNITE_BRICKS.register(Archeon.createId("ornate_artemnite_bricks"));
		ORNATE_ARTEMNITE_BRICKS_LINES.register(Archeon.createId("ornate_artemnite_bricks_lines"));
		ORNATE_ARTEMNITE_BRICKS_TEARS.register(Archeon.createId("ornate_artemnite_bricks_tears"));
		PALM_LOG.register(Archeon.createId("palm_log"));
		PALM_LEAVES.register(Archeon.createId("palm_leaves"));
		PALM_WOOD.register(Archeon.createId("palm_wood"));
		PALM_PLANKS.register(Archeon.createId("palm_planks"));
		PALM_BOOKSHELF.register(Archeon.createId("palm_bookshelf"));
		PALM_BUTTON.register(Archeon.createId("palm_button"));
		PALM_DOOR.register(Archeon.createId("palm_door"));
		PALM_PRESSURE_PLATE.register(Archeon.createId("palm_pressure_plate"));
		PALM_FENCE.register(Archeon.createId("palm_fence"));
		PALM_FENCE_GATE.register(Archeon.createId("palm_fence_gate"));
		PALM_STAIRS.register(Archeon.createId("palm_stairs"));
		PALM_SLAB.register(Archeon.createId("palm_slab"));
		PALM_TRAPDOOR.register(Archeon.createId("palm_trapdoor"));
		PEAKS_GRASS_BLOCK.register(Archeon.createId("peaks_grass_block"));
		PEAKS_SNOW.register(Archeon.createId("peaks_snow"));
		PEAKS_SNOW_BLOCK.register(Archeon.createId("peaks_snow_block"));
		POWER_KEYSTONE.register(Archeon.createId("power_keystone"));
		RED_TILES.register(Archeon.createId("red_tiles"));
		RED_TILES_STAIRS.register(Archeon.createId("red_tiles_stairs"));
		RED_TILES_SLAB.register(Archeon.createId("red_tiles_slab"));
		RED_TILES_WALL.register(Archeon.createId("red_tiles_wall"));
		ROUGHCAST.register(Archeon.createId("roughcast"));
		ROUGHCAST_STAIRS.register(Archeon.createId("roughcast_stairs"));
		ROUGHCAST_SLAB.register(Archeon.createId("roughcast_slab"));
		ROUGHCAST_WALL.register(Archeon.createId("roughcast_wall"));
		SALT_BLOCK.register(Archeon.createId("salt_block"));
		SANDY_SOIL.register(Archeon.createId("sandy_soil"));
		SHELLSAND.register(Archeon.createId("shellsand"));
	}
}
