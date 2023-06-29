package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomSquaredPortalBlock;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonBlocks implements ElementsInitializer {

	public static final CustomFlowerBlock SUNSET_ORCHID = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.RESISTANCE,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_SUNSET_ORCHID = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ROSEYPIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.UNLUCK,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.REGENERATION,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WATER_BREATHING,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock TWILIGHT_ROSE = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.REGENERATION,
		60,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock LYCORIS_RADIATA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.NAUSEA,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock RED_LYCORIS = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.SPEED,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock LYCORIS_SANGUINEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.STRENGTH,
		20,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock ASCENDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock WITHERED_ASCENDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock OEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.NIGHT_VISION,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_OEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock IOPEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.DOLPHINS_GRACE,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock TALL_IOPEA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_IOPEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock TALL_WITHERED_IOPEA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ORGANDEANE_BLOSSOM = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.JUMP_BOOST,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock ORGANDEANE_TALL = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_ORGANDEANE_BLOSSOM = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock TALL_WITHERED_ORGANDEANE = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock SEPTICEOLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.DARKNESS,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock WITHERED_SEPTICEOLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.WITHER,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFernBlock WET_GRASS = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XYZ),
		true
	);

	public static final CustomTallPlantBlock TALL_WET_GRASS = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock WET_FERN = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XYZ),
		true
	);

	public static final CustomTallPlantBlock TALL_WET_FERN = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomPlantBlock WET_GRASS_TUFFET = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomPlantBlock DEAD_WET_GRASS_TUFFET = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomPlantBlock SNOWY_GRASS_TUFFET = new CustomPlantBlock(
		floor -> floor.isOf(ArcheonBlocks.PEAKS_GRASS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.NONE),
		true
	);

	public static final CustomTallPlantBlock SOUTH_WHEAT = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS,
		true
	);

	public static final CustomTallPlantBlock TALL_SOUTH_WHEAT = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS,
		true
	);

	public static final CustomPlantBlock BUSH = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomPlantBlock VINE = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomPlantBlock BLOOD_ORANGE_BUSH = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock COKIPLANT = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.SOIL),
		StatusEffects.POISON,
		5,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomSugarCaneBlock XETULIAN_SUGAR_CANE = new CustomSugarCaneBlock(DefaultBlockSettings.PLANT_SETTINGS, true);

	public static final SporeRootcapBlock SPORE_ROOTCAP = new SporeRootcapBlock(DefaultBlockSettings.PLANT_SETTINGS, true);

	// public static final TowerSpawn : Later (WorldGen)

	public static final CustomBlock WET_GRASS_BLOCK = new CustomBlock(DefaultBlockSettings.GRASS_SETTINGS, true);
	public static final CustomBlock WET_DIRT = new CustomBlock(DefaultBlockSettings.DIRT_SETTINGS, true);

	public static final CustomFallingBlock DUNE_SAND = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock SHELLSAND = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock SALT_BLOCK = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock GOLDEN_SAND = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock SANDY_SOIL = new CustomFallingBlock(DefaultBlockSettings.CLAY_SETTINGS, true);
	public static final CustomFallingBlock DUST = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);

	public static final CustomPillarBlock PALM_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock PALM_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock PALM_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock PALM_STAIRS = new CustomStairsBlock(PALM_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock PALM_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock PALM_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock PALM_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock PALM_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden PALM_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock PALM_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);
	public static final CustomTrapdoorBlock PALM_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);

	public static final CustomPillarBlock NECLANE_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock NECLANE_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NECLANE_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock NECLANE_STAIRS = new CustomStairsBlock(NECLANE_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock NECLANE_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock NECLANE_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NECLANE_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NECLANE_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NECLANE_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock NECLANE_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);
	public static final CustomDoorBlock SUMMER_NECLANE_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);
	public static final CustomTrapdoorBlock NECLANE_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock SUMMER_NECLANE_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);

	public static final CustomPillarBlock CYPRESS_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock CYPRESS_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final HollowCypressLogBlock HOLLOW_CYPRESS_LOG = new HollowCypressLogBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);
	public static final CustomBlock CYPRESS_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock CYPRESS_STAIRS = new CustomStairsBlock(CYPRESS_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock CYPRESS_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock CYPRESS_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock CYPRESS_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock CYPRESS_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden CYPRESS_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock CYPRESS_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock CYPRESS_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock VUXANCIA_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock VUXANCIA_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock VUXANCIA_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock VUXANCIA_STAIRS = new CustomStairsBlock(VUXANCIA_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock VUXANCIA_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock VUXANCIA_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock VUXANCIA_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock VUXANCIA_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden VUXANCIA_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock VUXANCIA_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock VUXANCIA_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	/* public static final CustomPillarBlock NUME_WILLOW_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock NUME_WILLOW_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NUME_WILLOW_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock NUME_WILLOW_STAIRS = new CustomStairsBlock(NUME_WILLOW_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock NUME_WILLOW_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock NUME_WILLOW_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NUME_WILLOW_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NUME_WILLOW_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NUME_WILLOW_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock NUME_WILLOW_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NUME_WILLOW_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true); */

	/* public static final CustomPillarBlock NYRETH_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock NYRETH_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock NYRETH_STAIRS = new CustomStairsBlock(NYRETH_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock NYRETH_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock NYRETH_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NYRETH_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NYRETH_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NYRETH_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock NYRETH_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NYRETH_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true); */

	public static final CustomBlock SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SOUTHSTONE_STAIRS = new CustomStairsBlock(SOUTHSTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SOUTHSTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SOUTHSTONE_BRICK_STAIRS = new CustomStairsBlock(SOUTHSTONE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SOUTHSTONE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock SOUTHSTONE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock COBBLED_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock COBBLED_SOUTHSTONE_STAIRS = new CustomStairsBlock(COBBLED_SOUTHSTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock COBBLED_SOUTHSTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock COBBLED_SOUTHSTONE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomBlock GILDED_COBBLED_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock GILDED_COBBLED_SOUTHSTONE_STAIRS = new CustomStairsBlock(GILDED_COBBLED_SOUTHSTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock GILDED_COBBLED_SOUTHSTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock GILDED_COBBLED_SOUTHSTONE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomPillarBlock SOUTHSTONE_PILLAR_TOP = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPillarBlock SOUTHSTONE_PILLAR = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPillarBlock SOUTHSTONE_PILLAR_BOTTOM = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final SouthstoneColumnBlock SOUTHSTONE_COLUMN = new SouthstoneColumnBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SMOOTH_SOUTHSTONE_STAIRS = new CustomStairsBlock(SMOOTH_SOUTHSTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SMOOTH_SOUTHSTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CHISELED_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomPressurePlateBlock SOUTHSTONE_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone SOUTHSTONE_BUTTON = new CustomButtonBlock.Stone(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_SOUTHSTONE_BRICK_STAIRS = new CustomStairsBlock(MOSSY_SOUTHSTONE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_SOUTHSTONE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_SOUTHSTONE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_COBBLED_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock MOSSY_COBBLED_SOUTHSTONE_STAIRS = new CustomStairsBlock(MOSSY_COBBLED_SOUTHSTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock MOSSY_COBBLED_SOUTHSTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock MOSSY_COBBLED_SOUTHSTONE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomBlock FALSE_SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FALSE_CRACKLED_SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FALSE_MOSSY_SOUTHSTONE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FAELITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock SOUTHSTONE_COAL_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock SOUTHSTONE_GOLD_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock SOUTHSTONE_EMERALD_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock DEPTHS_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock DEPTHS_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock DEPTHS_FAELITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock DEPTHS_AKETITE_GOLD_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock DEPTHS_AKETITE_EMERALD_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock APAFLORITE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomBlock EXYRIANE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS.strength(4.0f), true);
	public static final CustomBlock FAELITE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	/* public static final CustomBlock LUSONYTH_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomBlock CLEMENTIUM_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true); */

	public static final CustomBlock AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_STAIRS = new CustomStairsBlock(AKETITE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock DEPTHS_AKETITE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock AKETITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_BRICK_STAIRS = new CustomStairsBlock(AKETITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_TILES_STAIRS = new CustomStairsBlock(AKETITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_CHISELED_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_TEARS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_LINES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_AKETITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_BASEBOARD = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MYSTERIOUS_STONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MYSTERIOUS_STONE_STAIRS = new CustomStairsBlock(MYSTERIOUS_STONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MYSTERIOUS_STONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomSquaredPortalBlock ARCHEON_PORTAL = new CustomSquaredPortalBlock(MYSTERIOUS_STONE, Archeon.createId("archeon"), QuiltBlockSettings.of(Material.PORTAL).noCollision().strength(-1.0F).luminance(11).sounds(BlockSoundGroup.GLASS));

	public static final CustomBlock ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(ARTEMNITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_TILES_STAIRS = new CustomStairsBlock(ARTEMNITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(MOSSY_ARTEMNITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_ARTEMNITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock FANCY_CHISELED_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FANCY_ARTEMNITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock FANCY_ARTEMNITE_TILES_STAIRS = new CustomStairsBlock(FANCY_ARTEMNITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock FANCY_ARTEMNITE_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock FANCY_ARTEMNITE_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_TEARS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_LINES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BASEBOARD = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock POWER_KEYSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final NaturiteBlock NATURITE = new NaturiteBlock(DefaultBlockSettings.NETHERITE_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_PALM_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_PALM_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_NECLANE_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NECLANE_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_CYPRESS_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_CYPRESS_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_VUXANCIA_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_VUXANCIA_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	/* public static final CustomPillarBlock STRIPPED_NUME_WILLOW_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NUME_WILLOW_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true); */

	/* public static final CustomPillarBlock STRIPPED_NYRETH_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NYRETH_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true); */

	public static final CustomBlock BUSH_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock PALM_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock NECLANE_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock FLOWERED_NECLANE_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock CYPRESS_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	public static final CustomBlock VUXANCIA_LEAVES_PNEVANTIAL = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock VUXANCIA_LEAVES_STREIAN = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock VUXANCIA_LEAVES_ORIAN = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock VUXANCIA_LEAVES_VALE = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock VUXANCIA_LEAVES_ZIAL = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	/* public static final CustomBlock NUME_WILLOW_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock NYRETH_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock PALE_NYRETH_LEAVES = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true); */

	public static final CustomGrowsDownPlantBlock VUXANCIA_LEAVES_PNEVANTIAL_HANGING = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.1f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock VUXANCIA_LEAVES_STREIAN_HANGING = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.1f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock VUXANCIA_LEAVES_ORIAN_HANGING = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.1f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock VUXANCIA_LEAVES_VALE_HANGING = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.1f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock VUXANCIA_LEAVES_ZIAL_HANGING = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.1f, 1, BlockState::isAir, true);

	public static final LeavesCarpetBlock LEAVES_CARPET_ORIAN = new LeavesCarpetBlock(DefaultBlockSettings.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_PNEVANTIAL = new LeavesCarpetBlock(DefaultBlockSettings.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_STREIAN = new LeavesCarpetBlock(DefaultBlockSettings.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_VALE = new LeavesCarpetBlock(DefaultBlockSettings.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock LEAVES_CARPET_ZIAL = new LeavesCarpetBlock(DefaultBlockSettings.LEAVES_CARPET, true);

	public static final CustomBlock PALM_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NECLANE_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock CYPRESS_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock VUXANCIA_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	/* public static final CustomBlock NUME_WILLOW_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_BOOKSHELF = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true); */

	public static final CustomPillarBlock BLOCK_OF_CERAMIC = new CustomPillarBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_STAIRS = new CustomStairsBlock(BLOCK_OF_CERAMIC.getDefaultState(), DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_SLAB = new CustomSlabBlock(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomPillarBlock CERAMIC_BRICKS = new CustomPillarBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_BRICK_STAIRS = new CustomStairsBlock(CERAMIC_BRICKS.getDefaultState(), DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomWallBlock CERAMIC_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomFenceBlock CERAMIC_FENCE = new CustomFenceBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CERAMIC_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone CERAMIC_BUTTON = new CustomButtonBlock.Stone(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomBlock GYPSUM = new CustomBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomStairsBlock GYPSUM_STAIRS = new CustomStairsBlock(GYPSUM.getDefaultState(), DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomSlabBlock GYPSUM_SLAB = new CustomSlabBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomWallBlock GYPSUM_WALL = new CustomWallBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomPressurePlateBlock GYPSUM_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.BASALT_SETTINGS, true);

	public static final CustomBlock GYPSUM_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock GYPSUM_BRICK_STAIRS = new CustomStairsBlock(GYPSUM_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock GYPSUM_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock GYPSUM_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomFenceBlock GYPSUM_BRICK_FENCE = new CustomFenceBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPressurePlateBlock GYPSUM_BRICK_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ROUGHCAST = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ROUGHCAST_STAIRS = new CustomStairsBlock(ROUGHCAST.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ROUGHCAST_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ROUGHCAST_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock DUNE_SAND_GLASS = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_TOP_LEFT = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_TOP_RIGHT = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_BOTTOM_LEFT = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomBlock DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT = new CustomBlock(DefaultBlockSettings.GLASS_SETTINGS, true);

	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);
	public static final CustomPaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT = new CustomPaneBlock(DefaultBlockSettings.GLASS_SETTINGS, true);

	public static final CustomBlock PEAKS_GRASS_BLOCK = new CustomBlock(DefaultBlockSettings.GRASS_SETTINGS, true);
	public static final CustomBlock SNOWY_SOUTHSTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSnowBlock PEAKS_SNOW = new CustomSnowBlock(DefaultBlockSettings.SNOW_SETTINGS, true);
	public static final CustomBlock PEAKS_SNOW_BLOCK = new CustomBlock(DefaultBlockSettings.SNOW_BLOCK_SETTINGS, true);

	public static final CustomBlock WARPED_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock WARPED_TILES_STAIRS = new CustomStairsBlock(WARPED_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock WARPED_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock WARPED_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CRIMSON_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CRIMSON_TILES_STAIRS = new CustomStairsBlock(CRIMSON_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CRIMSON_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CRIMSON_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock RED_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock RED_TILES_STAIRS = new CustomStairsBlock(RED_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock RED_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock RED_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock OCHRE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock OCHRE_TILES_STAIRS = new CustomStairsBlock(OCHRE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock OCHRE_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock OCHRE_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock BLUE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock BLUE_TILES_STAIRS = new CustomStairsBlock(BLUE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock BLUE_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock BLUE_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock GREEN_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock GREEN_TILES_STAIRS = new CustomStairsBlock(GREEN_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock GREEN_TILES_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock GREEN_TILES_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final DuneSandCastleBlock DUNE_SAND_CASTLE = new DuneSandCastleBlock(DefaultBlockSettings.SAND_SETTINGS.nonOpaque().strength(0.7f, 0.0f), true);
	public static final CustomBlock LOOT_URN = new CustomBlock(DefaultBlockSettings.BONE_SETTINGS.nonOpaque().strength(0.8f, 2.0f), true);
	public static final HeartOfNatureTrophyBlock HEART_OF_NATURE_TROPHY = new HeartOfNatureTrophyBlock(DefaultBlockSettings.LODESTONE_SETTINGS.nonOpaque().strength(1.0f, 6.0f), true);

	@Override
	public void register() {
		SUNSET_ORCHID.register(Archeon.createId("orchid"));
		WITHERED_SUNSET_ORCHID.register(Archeon.createId("withered_orchid"));
		ROSEYPIA.register(Archeon.createId("roseypia"));
		AEROLIA.register(Archeon.createId("aerolia"));
		WITHERED_AEROLIA.register(Archeon.createId("withered_aerolia"));
		ASTEDIBES.register(Archeon.createId("astedibes"));
		WITHERED_ASTEDIBES.register(Archeon.createId("withered_astedibes"));
		TWILIGHT_ROSE.register(Archeon.createId("twilight_rose"));
		LYCORIS_RADIATA.register(Archeon.createId("lycoris_radiata"));
		RED_LYCORIS.register(Archeon.createId("red_lycoris"));
		LYCORIS_SANGUINEA.register(Archeon.createId("lycoris_sanguinea"));
		ASCENDIA.register(Archeon.createId("ascendia"));
		WITHERED_ASCENDIA.register(Archeon.createId("withered_ascendia"));
		OEA.register(Archeon.createId("oea"));
		WITHERED_OEA.register(Archeon.createId("withered_oea"));
		IOPEA.register(Archeon.createId("iopea"));
		TALL_IOPEA.register(Archeon.createId("tall_iopea"));
		WITHERED_IOPEA.register(Archeon.createId("withered_iopea"));
		TALL_WITHERED_IOPEA.register(Archeon.createId("tall_withered_iopea"));
		ORGANDEANE_BLOSSOM.register(Archeon.createId("organdeane_blossom"));
		ORGANDEANE_TALL.register(Archeon.createId("organdeane_tall"));
		WITHERED_ORGANDEANE_BLOSSOM.register(Archeon.createId("withered_organdeane_blossom"));
		TALL_WITHERED_ORGANDEANE.register(Archeon.createId("tall_withered_organdeane"));
		SEPTICEOLIA.register(Archeon.createId("septiceolia"));
		WITHERED_SEPTICEOLIA.register(Archeon.createId("withered_septiceolia"));
		WET_GRASS.register(Archeon.createId("wet_grass"));
		TALL_WET_GRASS.register(Archeon.createId("tall_wet_grass"));
		WET_FERN.register(Archeon.createId("wet_fern"));
		TALL_WET_FERN.register(Archeon.createId("tall_wet_fern"));
		WET_GRASS_TUFFET.register(Archeon.createId("wet_grass_tuffet"));
		DEAD_WET_GRASS_TUFFET.register(Archeon.createId("dead_wet_grass_tuffet"));
		SNOWY_GRASS_TUFFET.register(Archeon.createId("snowy_grass_tuffet"));
		SOUTH_WHEAT.register(Archeon.createId("south_wheat"));
		TALL_SOUTH_WHEAT.register(Archeon.createId("tall_south_wheat"));
		BUSH.register(Archeon.createId("bush"));
		VINE.register(Archeon.createId("vine"));
		BLOOD_ORANGE_BUSH.register(Archeon.createId("blood_orange_bush"));
		COKIPLANT.register(Archeon.createId("cokiplant"));
		XETULIAN_SUGAR_CANE.register(Archeon.createId("xetulian_sugar_cane"));
		SPORE_ROOTCAP.register(Archeon.createId("spore_rootcap"));
		WET_GRASS_BLOCK.register(Archeon.createId("wet_grass_block"));
		WET_DIRT.register(Archeon.createId("wet_dirt"));
		DUNE_SAND.register(Archeon.createId("dune_sand"));
		SHELLSAND.register(Archeon.createId("shellsand"));
		SALT_BLOCK.register(Archeon.createId("salt_block"));
		GOLDEN_SAND.register(Archeon.createId("golden_sand"));
		SANDY_SOIL.register(Archeon.createId("sandy_soil"));
		DUST.register(Archeon.createId("dust"));
		PALM_WOOD.register(Archeon.createId("palm_wood"));
		PALM_LOG.register(Archeon.createId("palm_log"));
		PALM_PLANKS.register(Archeon.createId("palm_planks"));
		PALM_STAIRS.register(Archeon.createId("palm_stairs"));
		PALM_SLAB.register(Archeon.createId("palm_slab"));
		PALM_FENCE.register(Archeon.createId("palm_fence"));
		PALM_FENCE_GATE.register(Archeon.createId("palm_fence_gate"));
		PALM_PRESSURE_PLATE.register(Archeon.createId("palm_pressure_plate"));
		PALM_BUTTON.register(Archeon.createId("palm_button"));
		PALM_DOOR.register(Archeon.createId("palm_door"));
		PALM_TRAPDOOR.register(Archeon.createId("palm_trapdoor"));
		NECLANE_WOOD.register(Archeon.createId("neclane_wood"));
		NECLANE_LOG.register(Archeon.createId("neclane_log"));
		NECLANE_PLANKS.register(Archeon.createId("neclane_planks"));
		NECLANE_STAIRS.register(Archeon.createId("neclane_stairs"));
		NECLANE_SLAB.register(Archeon.createId("neclane_slab"));
		NECLANE_FENCE.register(Archeon.createId("neclane_fence"));
		NECLANE_FENCE_GATE.register(Archeon.createId("neclane_fence_gate"));
		NECLANE_PRESSURE_PLATE.register(Archeon.createId("neclane_pressure_plate"));
		NECLANE_BUTTON.register(Archeon.createId("neclane_button"));
		NECLANE_DOOR.register(Archeon.createId("neclane_door"));
		SUMMER_NECLANE_DOOR.register(Archeon.createId("summer_neclane_door"));
		NECLANE_TRAPDOOR.register(Archeon.createId("neclane_trapdoor"));
		SUMMER_NECLANE_TRAPDOOR.register(Archeon.createId("summer_neclane_trapdoor"));
		CYPRESS_WOOD.register(Archeon.createId("cypress_wood"));
		CYPRESS_LOG.register(Archeon.createId("cypress_log"));
		HOLLOW_CYPRESS_LOG.register(Archeon.createId("hollow_cypress_log"));
		CYPRESS_PLANKS.register(Archeon.createId("cypress_planks"));
		CYPRESS_STAIRS.register(Archeon.createId("cypress_stairs"));
		CYPRESS_SLAB.register(Archeon.createId("cypress_slab"));
		CYPRESS_FENCE.register(Archeon.createId("cypress_fence"));
		CYPRESS_FENCE_GATE.register(Archeon.createId("cypress_fence_gate"));
		CYPRESS_PRESSURE_PLATE.register(Archeon.createId("cypress_pressure_plate"));
		CYPRESS_BUTTON.register(Archeon.createId("cypress_button"));
		CYPRESS_DOOR.register(Archeon.createId("cypress_door"));
		CYPRESS_TRAPDOOR.register(Archeon.createId("cypress_trapdoor"));
		VUXANCIA_WOOD.register(Archeon.createId("vuxancia_wood"));
		VUXANCIA_LOG.register(Archeon.createId("vuxancia_log"));
		VUXANCIA_PLANKS.register(Archeon.createId("vuxancia_planks"));
		VUXANCIA_STAIRS.register(Archeon.createId("vuxancia_stairs"));
		VUXANCIA_SLAB.register(Archeon.createId("vuxancia_slab"));
		VUXANCIA_FENCE.register(Archeon.createId("vuxancia_fence"));
		VUXANCIA_FENCE_GATE.register(Archeon.createId("vuxancia_fence_gate"));
		VUXANCIA_PRESSURE_PLATE.register(Archeon.createId("vuxancia_pressure_plate"));
		VUXANCIA_BUTTON.register(Archeon.createId("vuxancia_button"));
		VUXANCIA_DOOR.register(Archeon.createId("vuxancia_door"));
		VUXANCIA_TRAPDOOR.register(Archeon.createId("vuxancia_trapdoor"));
		/* NUME_WILLOW_WOOD.register(Archeon.createId("nume_willow_wood"));
		NUME_WILLOW_LOG.register(Archeon.createId("nume_willow_log"));
		NUME_WILLOW_PLANKS.register(Archeon.createId("nume_willow_planks"));
		NUME_WILLOW_STAIRS.register(Archeon.createId("nume_willow_stairs"));
		NUME_WILLOW_SLAB.register(Archeon.createId("nume_willow_slab"));
		NUME_WILLOW_FENCE.register(Archeon.createId("nume_willow_fence"));
		NUME_WILLOW_FENCE_GATE.register(Archeon.createId("nume_willow_fence_gate"));
		NUME_WILLOW_PRESSURE_PLATE.register(Archeon.createId("nume_willow_pressure_plate"));
		NUME_WILLOW_BUTTON.register(Archeon.createId("nume_willow_button"));
		NUME_WILLOW_DOOR.register(Archeon.createId("nume_willow_door"));
		NUME_WILLOW_TRAPDOOR.register(Archeon.createId("nume_willow_trapdoor")); */
		/* NYRETH_WOOD.register(Archeon.createId("nyreth_wood"));
		NYRETH_LOG.register(Archeon.createId("nyreth_log"));
		NYRETH_PLANKS.register(Archeon.createId("nyreth_planks"));
		NYRETH_STAIRS.register(Archeon.createId("nyreth_stairs"));
		NYRETH_SLAB.register(Archeon.createId("nyreth_slab"));
		NYRETH_FENCE.register(Archeon.createId("nyreth_fence"));
		NYRETH_FENCE_GATE.register(Archeon.createId("nyreth_fence_gate"));
		NYRETH_PRESSURE_PLATE.register(Archeon.createId("nyreth_pressure_plate"));
		NYRETH_BUTTON.register(Archeon.createId("nyreth_button"));
		NYRETH_DOOR.register(Archeon.createId("nyreth_door"));
		NYRETH_TRAPDOOR.register(Archeon.createId("nyreth_trapdoor")); */
		SOUTHSTONE.register(Archeon.createId("southstone"));
		SOUTHSTONE_STAIRS.register(Archeon.createId("southstone_stairs"));
		SOUTHSTONE_SLAB.register(Archeon.createId("southstone_slab"));
		SOUTHSTONE_BRICKS.register(Archeon.createId("southstone_bricks"));
		SOUTHSTONE_BRICK_STAIRS.register(Archeon.createId("southstone_brick_stairs"));
		SOUTHSTONE_BRICK_SLAB.register(Archeon.createId("southstone_brick_slab"));
		SOUTHSTONE_BRICK_WALL.register(Archeon.createId("southstone_brick_wall"));
		COBBLED_SOUTHSTONE.register(Archeon.createId("cobbled_southstone"));
		COBBLED_SOUTHSTONE_STAIRS.register(Archeon.createId("cobbled_southstone_stairs"));
		COBBLED_SOUTHSTONE_SLAB.register(Archeon.createId("cobbled_southstone_slab"));
		COBBLED_SOUTHSTONE_WALL.register(Archeon.createId("cobbled_southstone_wall"));
		GILDED_COBBLED_SOUTHSTONE.register(Archeon.createId("gilded_cobbled_southstone"));
		GILDED_COBBLED_SOUTHSTONE_STAIRS.register(Archeon.createId("gilded_cobbled_southstone_stairs"));
		GILDED_COBBLED_SOUTHSTONE_SLAB.register(Archeon.createId("gilded_cobbled_southstone_slab"));
		GILDED_COBBLED_SOUTHSTONE_WALL.register(Archeon.createId("gilded_cobbled_southstone_wall"));
		SOUTHSTONE_PILLAR_TOP.register(Archeon.createId("southstone_pillar_top"));
		SOUTHSTONE_PILLAR.register(Archeon.createId("southstone_pillar"));
		SOUTHSTONE_PILLAR_BOTTOM.register(Archeon.createId("southstone_pillar_bottom"));
		SOUTHSTONE_COLUMN.register(Archeon.createId("southstone_column"));
		SMOOTH_SOUTHSTONE.register(Archeon.createId("smooth_southstone"));
		SMOOTH_SOUTHSTONE_STAIRS.register(Archeon.createId("smooth_southstone_stairs"));
		SMOOTH_SOUTHSTONE_SLAB.register(Archeon.createId("smooth_southstone_slab"));
		CHISELED_SOUTHSTONE.register(Archeon.createId("chiseled_southstone"));
		CRACKLED_SOUTHSTONE_BRICKS.register(Archeon.createId("crackled_southstone_bricks"));
		SOUTHSTONE_PRESSURE_PLATE.register(Archeon.createId("southstone_pressure_plate"));
		SOUTHSTONE_BUTTON.register(Archeon.createId("southstone_button"));
		MOSSY_SOUTHSTONE_BRICKS.register(Archeon.createId("mossy_southstone_bricks"));
		MOSSY_SOUTHSTONE_BRICK_STAIRS.register(Archeon.createId("mossy_southstone_brick_stairs"));
		MOSSY_SOUTHSTONE_BRICK_SLAB.register(Archeon.createId("mossy_southstone_brick_slab"));
		MOSSY_SOUTHSTONE_BRICK_WALL.register(Archeon.createId("mossy_southstone_brick_wall"));
		MOSSY_COBBLED_SOUTHSTONE.register(Archeon.createId("mossy_cobbled_southstone"));
		MOSSY_COBBLED_SOUTHSTONE_STAIRS.register(Archeon.createId("mossy_cobbled_southstone_stairs"));
		MOSSY_COBBLED_SOUTHSTONE_SLAB.register(Archeon.createId("mossy_cobbled_southstone_slab"));
		MOSSY_COBBLED_SOUTHSTONE_WALL.register(Archeon.createId("mossy_cobbled_southstone_wall"));
		FALSE_SOUTHSTONE_BRICKS.register(Archeon.createId("false_southstone_bricks"));
		FALSE_CRACKLED_SOUTHSTONE_BRICKS.register(Archeon.createId("false_crackled_southstone_bricks"));
		FALSE_MOSSY_SOUTHSTONE_BRICKS.register(Archeon.createId("false_mossy_southstone_bricks"));
		APAFLORITE_ORE.register(Archeon.createId("apaflorite_ore"));
		EXYRIANE_ORE.register(Archeon.createId("exyriane_ore"));
		FAELITE_ORE.register(Archeon.createId("faelite_ore"));
		SOUTHSTONE_COAL_ORE.register(Archeon.createId("southstone_coal_ore"));
		SOUTHSTONE_GOLD_ORE.register(Archeon.createId("southstone_gold_ore"));
		SOUTHSTONE_EMERALD_ORE.register(Archeon.createId("southstone_emerald_ore"));
		DEPTHS_APAFLORITE_ORE.register(Archeon.createId("depths_apaflorite_ore"));
		DEPTHS_EXYRIANE_ORE.register(Archeon.createId("depths_exyriane_ore"));
		DEPTHS_FAELITE_ORE.register(Archeon.createId("depths_faelite_ore"));
		DEPTHS_AKETITE_GOLD_ORE.register(Archeon.createId("depths_aketite_gold_ore"));
		DEPTHS_AKETITE_EMERALD_ORE.register(Archeon.createId("depths_aketite_emerald_ore"));
		APAFLORITE_BLOCK.register(Archeon.createId("apaflorite_block"));
		EXYRIANE_BLOCK.register(Archeon.createId("exyriane_block"));
		FAELITE_BLOCK.register(Archeon.createId("faelite_block"));
		/* LUSONYTH_BLOCK.register(Archeon.createId("lusonyth_block")); */
		/* CLEMENTIUM_BLOCK.register(Archeon.createId("clementium_block")); */
		AKETITE.register(Archeon.createId("aketite"));
		AKETITE_STAIRS.register(Archeon.createId("aketite_stairs"));
		AKETITE_SLAB.register(Archeon.createId("aketite_slab"));
		AKETITE_WALL.register(Archeon.createId("aketite_wall"));
		DEPTHS_AKETITE.register(Archeon.createId("depths_aketite"));
		AKETITE_BRICKS.register(Archeon.createId("aketite_bricks"));
		AKETITE_BRICK_STAIRS.register(Archeon.createId("aketite_brick_stairs"));
		AKETITE_BRICK_SLAB.register(Archeon.createId("aketite_brick_slab"));
		AKETITE_BRICK_WALL.register(Archeon.createId("aketite_brick_wall"));
		AKETITE_TILES.register(Archeon.createId("aketite_tiles"));
		AKETITE_TILES_STAIRS.register(Archeon.createId("aketite_tiles_stairs"));
		AKETITE_TILES_SLAB.register(Archeon.createId("aketite_tiles_slab"));
		AKETITE_TILES_WALL.register(Archeon.createId("aketite_tiles_wall"));
		ORNATE_CHISELED_AKETITE.register(Archeon.createId("ornate_chiseled_aketite"));
		ORNATE_AKETITE_BRICKS_TEARS.register(Archeon.createId("ornate_aketite_bricks_tears"));
		ORNATE_AKETITE_BRICKS_LINES.register(Archeon.createId("ornate_aketite_bricks_lines"));
		SMOOTH_AKETITE.register(Archeon.createId("smooth_aketite"));
		CHISELED_AKETITE.register(Archeon.createId("chiseled_aketite"));
		CRACKLED_AKETITE_BRICKS.register(Archeon.createId("crackled_aketite_bricks"));
		AKETITE_BASEBOARD.register(Archeon.createId("aketite_baseboard"));
		MYSTERIOUS_STONE.register(Archeon.createId("mysterious_stone"));
		MYSTERIOUS_STONE_STAIRS.register(Archeon.createId("mysterious_stone_stairs"));
		MYSTERIOUS_STONE_SLAB.register(Archeon.createId("mysterious_stone_slab"));
		ARCHEON_PORTAL.register(Archeon.createId("archeon_portal"));
		ARTEMNITE.register(Archeon.createId("artemnite"));
		ARTEMNITE_BRICKS.register(Archeon.createId("artemnite_bricks"));
		ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("artemnite_brick_stairs"));
		ARTEMNITE_BRICK_SLAB.register(Archeon.createId("artemnite_brick_slab"));
		ARTEMNITE_BRICK_WALL.register(Archeon.createId("artemnite_brick_wall"));
		ARTEMNITE_TILES.register(Archeon.createId("artemnite_tiles"));
		ARTEMNITE_TILES_STAIRS.register(Archeon.createId("artemnite_tiles_stairs"));
		ARTEMNITE_TILES_SLAB.register(Archeon.createId("artemnite_tiles_slab"));
		ARTEMNITE_TILES_WALL.register(Archeon.createId("artemnite_tiles_wall"));
		MOSSY_ARTEMNITE_BRICKS.register(Archeon.createId("mossy_artemnite_bricks"));
		MOSSY_ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("mossy_artemnite_brick_stairs"));
		MOSSY_ARTEMNITE_BRICK_SLAB.register(Archeon.createId("mossy_artemnite_brick_slab"));
		MOSSY_ARTEMNITE_BRICK_WALL.register(Archeon.createId("mossy_artemnite_brick_wall"));
		FANCY_CHISELED_ARTEMNITE.register(Archeon.createId("fancy_chiseled_artemnite"));
		FANCY_ARTEMNITE_TILES.register(Archeon.createId("fancy_artemnite_tiles"));
		FANCY_ARTEMNITE_TILES_STAIRS.register(Archeon.createId("fancy_artemnite_tiles_stairs"));
		FANCY_ARTEMNITE_TILES_SLAB.register(Archeon.createId("fancy_artemnite_tiles_slab"));
		FANCY_ARTEMNITE_TILES_WALL.register(Archeon.createId("fancy_artemnite_tiles_wall"));
		ORNATE_ARTEMNITE_BRICKS.register(Archeon.createId("ornate_artemnite_bricks"));
		ORNATE_ARTEMNITE_BRICKS_TEARS.register(Archeon.createId("ornate_artemnite_bricks_tears"));
		ORNATE_ARTEMNITE_BRICKS_LINES.register(Archeon.createId("ornate_artemnite_bricks_lines"));
		SMOOTH_ARTEMNITE.register(Archeon.createId("smooth_artemnite"));
		CHISELED_ARTEMNITE.register(Archeon.createId("chiseled_artemnite"));
		CRACKLED_ARTEMNITE_BRICKS.register(Archeon.createId("crackled_artemnite_bricks"));
		ARTEMNITE_BASEBOARD.register(Archeon.createId("artemnite_baseboard"));
		POWER_KEYSTONE.register(Archeon.createId("power_keystone"));
		NATURITE.register(Archeon.createId("naturite"));
		STRIPPED_PALM_WOOD.register(Archeon.createId("stripped_palm_wood"));
		STRIPPED_PALM_LOG.register(Archeon.createId("stripped_palm_log"));
		STRIPPED_NECLANE_WOOD.register(Archeon.createId("stripped_neclane_wood"));
		STRIPPED_NECLANE_LOG.register(Archeon.createId("stripped_neclane_log"));
		STRIPPED_CYPRESS_WOOD.register(Archeon.createId("stripped_cypress_wood"));
		STRIPPED_CYPRESS_LOG.register(Archeon.createId("stripped_cypress_log"));
		STRIPPED_VUXANCIA_WOOD.register(Archeon.createId("stripped_vuxancia_wood"));
		STRIPPED_VUXANCIA_LOG.register(Archeon.createId("stripped_vuxancia_log"));
		/* STRIPPED_NUME_WILLOW_WOOD.register(Archeon.createId("stripped_nume_willow_wood"));
		STRIPPED_NUME_WILLOW_LOG.register(Archeon.createId("stripped_nume_willow_log")); */
		/* STRIPPED_NYRETH_WOOD.register(Archeon.createId("stripped_nyreth_wood"));
		STRIPPED_NYRETH_LOG.register(Archeon.createId("stripped_nyreth_log"));*/
		BUSH_LEAVES.register(Archeon.createId("bush_leaves"));
		PALM_LEAVES.register(Archeon.createId("palm_leaves"));
		NECLANE_LEAVES.register(Archeon.createId("neclane_leaves"));
		FLOWERED_NECLANE_LEAVES.register(Archeon.createId("flowered_neclane_leaves"));
		CYPRESS_LEAVES.register(Archeon.createId("cypress_leaves"));
		VUXANCIA_LEAVES_PNEVANTIAL.register(Archeon.createId("vuxancia_leaves_pnevantial"));
		VUXANCIA_LEAVES_STREIAN.register(Archeon.createId("vuxancia_leaves_streian"));
		VUXANCIA_LEAVES_ORIAN.register(Archeon.createId("vuxancia_leaves_orian"));
		VUXANCIA_LEAVES_VALE.register(Archeon.createId("vuxancia_leaves_vale"));
		VUXANCIA_LEAVES_ZIAL.register(Archeon.createId("vuxancia_leaves_zial"));
		/* NUME_WILLOW_LEAVES.register(Archeon.createId("nume_willow_leaves")); */
		/* NYRETH_LEAVES.register(Archeon.createId("nyreth_leaves"));
		PALE_NYRETH_LEAVES.register(Archeon.createId("pale_nyreth_leaves")); */
		VUXANCIA_LEAVES_PNEVANTIAL_HANGING.register(Archeon.createId("vuxancia_leaves_pnevantial_hanging"));
		VUXANCIA_LEAVES_STREIAN_HANGING.register(Archeon.createId("vuxancia_leaves_streian_hanging"));
		VUXANCIA_LEAVES_ORIAN_HANGING.register(Archeon.createId("vuxancia_leaves_orian_hanging"));
		VUXANCIA_LEAVES_VALE_HANGING.register(Archeon.createId("vuxancia_leaves_vale_hanging"));
		VUXANCIA_LEAVES_ZIAL_HANGING.register(Archeon.createId("vuxancia_leaves_zial_hanging"));
		LEAVES_CARPET_PNEVANTIAL.register(Archeon.createId("leaves_carpet_pnevantial"));
		LEAVES_CARPET_STREIAN.register(Archeon.createId("leaves_carpet_streian"));
		LEAVES_CARPET_ORIAN.register(Archeon.createId("leaves_carpet_orian"));
		LEAVES_CARPET_VALE.register(Archeon.createId("leaves_carpet_vale"));
		LEAVES_CARPET_ZIAL.register(Archeon.createId("leaves_carpet_zial"));
		PALM_BOOKSHELF.register(Archeon.createId("palm_bookshelf"));
		NECLANE_BOOKSHELF.register(Archeon.createId("neclane_bookshelf"));
		CYPRESS_BOOKSHELF.register(Archeon.createId("cypress_bookshelf"));
		VUXANCIA_BOOKSHELF.register(Archeon.createId("vuxancia_bookshelf"));
		/* NUME_WILLOW_BOOKSHELF.register(Archeon.createId("nume_willow_bookshelf")); */
		/* NYRETH_BOOKSHELF.register(Archeon.createId("nyreth_bookshelf")); */
		BLOCK_OF_CERAMIC.register(Archeon.createId("block_of_ceramic"));
		CERAMIC_STAIRS.register(Archeon.createId("ceramic_stairs"));
		CERAMIC_SLAB.register(Archeon.createId("ceramic_slab"));
		CERAMIC_BRICKS.register(Archeon.createId("ceramic_bricks"));
		CERAMIC_BRICK_STAIRS.register(Archeon.createId("ceramic_brick_stairs"));
		CERAMIC_BRICK_SLAB.register(Archeon.createId("ceramic_brick_slab"));
		CERAMIC_BRICK_WALL.register(Archeon.createId("ceramic_brick_wall"));
		CERAMIC_FENCE.register(Archeon.createId("ceramic_fence"));
		CERAMIC_PRESSURE_PLATE.register(Archeon.createId("ceramic_pressure_plate"));
		CERAMIC_BUTTON.register(Archeon.createId("ceramic_button"));
		GYPSUM.register(Archeon.createId("gypsum"));
		GYPSUM_STAIRS.register(Archeon.createId("gypsum_stairs"));
		GYPSUM_SLAB.register(Archeon.createId("gypsum_slab"));
		GYPSUM_WALL.register(Archeon.createId("gypsum_wall"));
		GYPSUM_PRESSURE_PLATE.register(Archeon.createId("gypsum_pressure_plate"));
		GYPSUM_BRICKS.register(Archeon.createId("gypsum_bricks"));
		GYPSUM_BRICK_STAIRS.register(Archeon.createId("gypsum_brick_stairs"));
		GYPSUM_BRICK_SLAB.register(Archeon.createId("gypsum_brick_slab"));
		GYPSUM_BRICK_WALL.register(Archeon.createId("gypsum_brick_wall"));
		GYPSUM_BRICK_FENCE.register(Archeon.createId("gypsum_brick_fence"));
		GYPSUM_BRICK_PRESSURE_PLATE.register(Archeon.createId("gypsum_brick_pressure_plate"));
		ROUGHCAST.register(Archeon.createId("roughcast"));
		ROUGHCAST_STAIRS.register(Archeon.createId("roughcast_stairs"));
		ROUGHCAST_SLAB.register(Archeon.createId("roughcast_slab"));
		ROUGHCAST_WALL.register(Archeon.createId("roughcast_wall"));
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
		PEAKS_GRASS_BLOCK.register(Archeon.createId("peaks_grass_block"));
		SNOWY_SOUTHSTONE.register(Archeon.createId("snowy_southstone"));
		PEAKS_SNOW.register(Archeon.createId("peaks_snow"));
		PEAKS_SNOW_BLOCK.register(Archeon.createId("peaks_snow_block"));
		WARPED_TILES.register(Archeon.createId("warped_tiles"));
		WARPED_TILES_STAIRS.register(Archeon.createId("warped_tiles_stairs"));
		WARPED_TILES_SLAB.register(Archeon.createId("warped_tiles_slab"));
		WARPED_TILES_WALL.register(Archeon.createId("warped_tiles_wall"));
		CRIMSON_TILES.register(Archeon.createId("crimson_tiles"));
		CRIMSON_TILES_STAIRS.register(Archeon.createId("crimson_tiles_stairs"));
		CRIMSON_TILES_SLAB.register(Archeon.createId("crimson_tiles_slab"));
		CRIMSON_TILES_WALL.register(Archeon.createId("crimson_tiles_wall"));
		RED_TILES.register(Archeon.createId("red_tiles"));
		RED_TILES_STAIRS.register(Archeon.createId("red_tiles_stairs"));
		RED_TILES_SLAB.register(Archeon.createId("red_tiles_slab"));
		RED_TILES_WALL.register(Archeon.createId("red_tiles_wall"));
		OCHRE_TILES.register(Archeon.createId("ochre_tiles"));
		OCHRE_TILES_STAIRS.register(Archeon.createId("ochre_tiles_stairs"));
		OCHRE_TILES_SLAB.register(Archeon.createId("ochre_tiles_slab"));
		OCHRE_TILES_WALL.register(Archeon.createId("ochre_tiles_wall"));
		BLUE_TILES.register(Archeon.createId("blue_tiles"));
		BLUE_TILES_STAIRS.register(Archeon.createId("blue_tiles_stairs"));
		BLUE_TILES_SLAB.register(Archeon.createId("blue_tiles_slab"));
		BLUE_TILES_WALL.register(Archeon.createId("blue_tiles_wall"));
		GREEN_TILES.register(Archeon.createId("green_tiles"));
		GREEN_TILES_STAIRS.register(Archeon.createId("green_tiles_stairs"));
		GREEN_TILES_SLAB.register(Archeon.createId("green_tiles_slab"));
		GREEN_TILES_WALL.register(Archeon.createId("green_tiles_wall"));
		DUNE_SAND_CASTLE.register(Archeon.createId("dune_sand_castle"));
		LOOT_URN.register(Archeon.createId("loot_urn"));
		HEART_OF_NATURE_TROPHY.register(Archeon.createId("heart_of_nature_trophy"));
		ARCHEON_PORTAL.registerPortal(Archeon.createId("portal"));
	}
}
