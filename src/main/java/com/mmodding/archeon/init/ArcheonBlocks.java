package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blocks.*;
import com.mmodding.archeon.bootstrap.init.ArcheonCauldronBehaviors;
import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.blocks.settings.AdvancedBlockSettings;
import com.mmodding.mmodding_lib.library.blocks.settings.DefaultBlockSettings;
import com.mmodding.mmodding_lib.library.blocks.settings.ImmutableBlockSettings;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.items.settings.AdvancedItemSettings;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortalBlock;
import com.mmodding.mmodding_lib.library.tags.modifiers.TagModifier;
import com.mmodding.mmodding_lib.library.utils.SaplingGeneratorUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;

public class ArcheonBlocks implements ElementsInitializer {

	public static final CustomCauldronBlock HOT_SPRING_WATER_CAULDRON = new CustomCauldronBlock(
		FabricBlockSettings.copyOf(Blocks.CAULDRON),
		null,
		ArcheonCauldronBehaviors.HOT_SPRING_WATER_BEHAVIOR
	);

	public static final CustomCauldronBlock DASCIUM_CAULDRON = new CustomCauldronBlock(
		FabricBlockSettings.copyOf(Blocks.CAULDRON),
		null,
		ArcheonCauldronBehaviors.DASCIUM_BEHAVIOR
	);

	public static final CustomFlowerBlock SUNSET_ORCHID = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.RESISTANCE,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ROSEYPIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.UNLUCK,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.REGENERATION,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.WATER_BREATHING,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock TWILIGHT_ROSE = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.REGENERATION,
		60,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock PINK_LYCORIS = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.NAUSEA,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock RED_LYCORIS = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.SPEED,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ORANGE_LYCORIS = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.STRENGTH,
		20,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock ASCENDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock OEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.NIGHT_VISION,
		30,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock IOPEA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.DOLPHINS_GRACE,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock TALL_IOPEA = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ORGANDEANE_BLOSSOM = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.JUMP_BOOST,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomTallFlowerBlock TALL_ORGANDEANE = new CustomTallFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock SEPTICEOLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.DARKNESS,
		10,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomFlowerBlock DOTTED_STOVIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.INSTANT_HEALTH,
		0,
		DefaultBlockSettings.PLANT_SETTINGS
	);

	public static final CustomFlowerBlock WILLS_OF_LIGHT = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.ABSORPTION,
		10,
		DefaultBlockSettings.PLANT_SETTINGS
	);

	public static final CustomFlowerBlock ETERNAL_FORTUNES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		StatusEffects.LUCK,
		10,
		DefaultBlockSettings.PLANT_SETTINGS
	);

	public static final CustomTallFlowerBlock BLUE_DOELDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(TagModifier.ofSimple(ArcheonTags.Blocks.SOIL).append(ArcheonBlocks.ACHREAN_MOSS_BLOCK)),
		DefaultBlockSettings.PLANT_SETTINGS.luminance(9),
		true
	);

	public static final CustomTallFlowerBlock WHITE_DOELDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(TagModifier.ofSimple(ArcheonTags.Blocks.SOIL).append(ArcheonBlocks.ACHREAN_MOSS_BLOCK)),
		DefaultBlockSettings.PLANT_SETTINGS.luminance(9),
		true
	);

	public static final CustomTallFlowerBlock PINK_DOELDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(TagModifier.ofSimple(ArcheonTags.Blocks.SOIL).append(ArcheonBlocks.ACHREAN_MOSS_BLOCK)),
		DefaultBlockSettings.PLANT_SETTINGS.luminance(9),
		true
	);

	public static final CustomTallFlowerBlock YELLOW_DOELDIA = new CustomTallFlowerBlock(
		floor -> floor.isIn(TagModifier.ofSimple(ArcheonTags.Blocks.SOIL).append(ArcheonBlocks.ACHREAN_MOSS_BLOCK)),
		DefaultBlockSettings.PLANT_SETTINGS.luminance(9),
		true
	);

	public static final CustomLilyPadBlock SMALL_HOT_SPRING_LILY_PAD = new CustomLilyPadBlock(
		(fluid, floor) -> fluid.isOf(ArcheonFluids.HOT_SPRING_WATER) || fluid.isOf(Fluids.WATER) || floor.isIn(BlockTags.ICE),
		DefaultBlockSettings.PLANT_SETTINGS.collidable(true),
		true
	);

	public static final CustomLilyPadBlock HOT_SPRING_LILY_PAD = new CustomLilyPadBlock(
		(fluid, floor) -> fluid.isOf(ArcheonFluids.HOT_SPRING_WATER) || fluid.isOf(Fluids.WATER) || floor.isIn(BlockTags.ICE),
		DefaultBlockSettings.PLANT_SETTINGS.collidable(true),
		true
	);

	public static final GiantLilyBlock GIANT_LILY = new GiantLilyBlock(
		DefaultBlockSettings.PLANT_SETTINGS.collidable(true)
	);

	public static final AchreanVinesBlock ACHREAN_VINES = new AchreanVinesBlock(
		DefaultBlockSettings.PLANT_SETTINGS
			.luminance(state -> state.get(AchreanVinesBlock.NEAVE_BERRIES) && state.get(AchreanVinesBlock.DONE) ? 14 : 0)
			.sounds(BlockSoundGroup.CAVE_VINES),
		false,
		0.1f,
		1,
		BlockState::isAir,
		true,
		new AdvancedItemSettings()
	);

	public static final CustomFernBlock WET_GRASS = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XYZ),
		true
	);

	public static final CustomTallPlantBlock TALL_WET_GRASS = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock FLOWERED_WET_GRASS = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XYZ),
		true
	);

	public static final CustomTallPlantBlock FLOWERED_TALL_WET_GRASS = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock WET_FERN = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XYZ),
		true
	);

	public static final CustomTallPlantBlock TALL_WET_FERN = new CustomTallPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock WET_GRASS_TUFFET = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isIn(ArcheonTags.Blocks.STONE) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock DEAD_WET_GRASS_TUFFET = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isIn(ArcheonTags.Blocks.STONE) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomFernBlock SNOWY_GRASS_TUFFET = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isIn(ArcheonTags.Blocks.STONE) || floor.isOf(ArcheonBlocks.PEAKS_SNOW_BLOCK),
		DefaultBlockSettings.GRASS_SETTINGS.noCollision().breakInstantly().offsetType(AbstractBlock.OffsetType.NONE).nonOpaque(),
		true
	);

	public static final SouthWheatBlock SOUTH_WHEAT = new SouthWheatBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.REPLACEABLE_PLANT_SETTINGS,
		true
	);

	public static final CustomFernBlock BUSH = new CustomFernBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final ToBushBlock VINE = new ToBushBlock(
		() -> ArcheonItems.GRAPE,
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final ToBushBlock BLOOD_ORANGE_BUSH = new ToBushBlock(
		() -> ArcheonItems.BLOOD_ORANGE,
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final XetulianSugarCaneBlock XETULIAN_SUGAR_CANE = new XetulianSugarCaneBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.DUNE_SAND) || floor.isOf(ArcheonBlocks.SALT_BLOCK),
		null,
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final SporeRootcapBlock SPORE_ROOTCAP = new SporeRootcapBlock(DefaultBlockSettings.LEAVES_SETTINGS, true, new AdvancedItemSettings().food(1, 0.1f, false, true, true));

	public static final CustomPlantBlock GLOWSPROUTS = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.STONE) || floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomPlantBlock GLOWSHROOMS = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.STONE) || floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		DefaultBlockSettings.PLANT_SETTINGS.luminance(14),
		true
	);

	public static final CustomPlantBlock GLOWSHROOM_PARASITES = new CustomPlantBlock(
		floor -> floor.isIn(ArcheonTags.Blocks.STONE) || floor.isIn(ArcheonTags.Blocks.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		DefaultBlockSettings.PLANT_SETTINGS,
		true
	);

	public static final CustomLayeredBlock GLOWSHROOM_MOSS = new CustomLayeredBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomBlock GLOWSHROOM_MOSS_BLOCK = new CustomBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	public static final PeaksSnowyBlock WET_GRASS_BLOCK = new PeaksSnowyBlock(DefaultBlockSettings.GRASS_SETTINGS, true);
	public static final CustomBlock WET_DIRT = new CustomBlock(DefaultBlockSettings.DIRT_SETTINGS, true);

	public static final CustomLayeredBlock ACHREAN_MOSS = new CustomLayeredBlock(DefaultBlockSettings.GRASS_SETTINGS.sounds(BlockSoundGroup.MOSS_BLOCK), true);
	public static final CustomBlock ACHREAN_MOSS_BLOCK = new CustomBlock(DefaultBlockSettings.GRASS_SETTINGS.sounds(BlockSoundGroup.MOSS_BLOCK), true);

	public static final CustomFallingBlock DUNE_SAND = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock SHELLSAND = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS, true);
	public static final CustomFallingBlock SALT_BLOCK = new CustomFallingBlock(DefaultBlockSettings.CLAY_SETTINGS, true);
	public static final CustomFallingBlock DUST = new CustomFallingBlock(DefaultBlockSettings.SAND_SETTINGS.sounds(BlockSoundGroup.GRAVEL), true);
	public static final GoldenClayBlock GOLDEN_CLAY = new GoldenClayBlock(DefaultBlockSettings.CLAY_SETTINGS, true);

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
	public static final NeclaneBedBlock NECLANE_BED = new NeclaneBedBlock(DefaultBlockSettings.WOOD_SETTINGS.strength(0.2f).nonOpaque(), true);

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

	public static final CustomPillarBlock NUME_WILLOW_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock NUME_WILLOW_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NUME_WILLOW_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock NUME_WILLOW_STAIRS = new CustomStairsBlock(NUME_WILLOW_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock NUME_WILLOW_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock NUME_WILLOW_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NUME_WILLOW_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NUME_WILLOW_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NUME_WILLOW_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock NUME_WILLOW_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomTrapdoorBlock NUME_WILLOW_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock NYRETH_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock NYRETH_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBlock NYRETH_PLANKS = new CustomBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomStairsBlock NYRETH_STAIRS = new CustomStairsBlock(NYRETH_PLANKS.getDefaultState(), DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomSlabBlock NYRETH_SLAB = new CustomSlabBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceBlock NYRETH_FENCE = new CustomFenceBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock NYRETH_FENCE_GATE = new CustomFenceGateBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock NYRETH_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.EVERYTHING, DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden NYRETH_BUTTON = new CustomButtonBlock.Wooden(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomDoorBlock NYRETH_DOOR = new CustomDoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);
	public static final CustomTrapdoorBlock NYRETH_TRAPDOOR = new CustomTrapdoorBlock(DefaultBlockSettings.WOOD_SETTINGS.nonOpaque(), true);

	public static final PeaksSnowyBlock CHIASPEN = new PeaksSnowyBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CHIASPEN_STAIRS = new CustomStairsBlock(CHIASPEN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CHIASPEN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CHIASPEN_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CHIASPEN_BRICK_STAIRS = new CustomStairsBlock(CHIASPEN_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CHIASPEN_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CHIASPEN_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock COBBLED_CHIASPEN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock COBBLED_CHIASPEN_STAIRS = new CustomStairsBlock(COBBLED_CHIASPEN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock COBBLED_CHIASPEN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock COBBLED_CHIASPEN_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomBlock GILDED_COBBLED_CHIASPEN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock GILDED_COBBLED_CHIASPEN_STAIRS = new CustomStairsBlock(GILDED_COBBLED_CHIASPEN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock GILDED_COBBLED_CHIASPEN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock GILDED_COBBLED_CHIASPEN_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomPillarBlock CHIASPEN_PILLAR_TOP = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPillarBlock CHIASPEN_PILLAR = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPillarBlock CHIASPEN_PILLAR_BOTTOM = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final ChiaspenColumnBlock CHIASPEN_COLUMN = new ChiaspenColumnBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_CHIASPEN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SMOOTH_CHIASPEN_STAIRS = new CustomStairsBlock(SMOOTH_CHIASPEN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SMOOTH_CHIASPEN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CHISELED_CHIASPEN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKED_CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomPressurePlateBlock CHIASPEN_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone CHIASPEN_BUTTON = new CustomButtonBlock.Stone(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_CHIASPEN_BRICK_STAIRS = new CustomStairsBlock(MOSSY_CHIASPEN_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_CHIASPEN_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_CHIASPEN_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_COBBLED_CHIASPEN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomStairsBlock MOSSY_COBBLED_CHIASPEN_STAIRS = new CustomStairsBlock(MOSSY_COBBLED_CHIASPEN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomSlabBlock MOSSY_COBBLED_CHIASPEN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);
	public static final CustomWallBlock MOSSY_COBBLED_CHIASPEN_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.hardness(2.0f), true);

	public static final CustomBlock FALSE_CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FALSE_CRACKED_CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FALSE_MOSSY_CHIASPEN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock PHOSNOR_SLATE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomStairsBlock PHOSNOR_SLATE_STAIRS = new CustomStairsBlock(PHOSNOR_SLATE.getDefaultState(), DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomSlabBlock PHOSNOR_SLATE_SLAB = new CustomSlabBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomWallBlock PHOSNOR_SLATE_WALL = new CustomWallBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock PHOSNOR_SLATE_BRICKS = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomStairsBlock PHOSNOR_SLATE_BRICK_STAIRS = new CustomStairsBlock(PHOSNOR_SLATE_BRICKS.getDefaultState(), DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomSlabBlock PHOSNOR_SLATE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomWallBlock PHOSNOR_SLATE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock PHOSNOR_SLATE_TILES = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomStairsBlock PHOSNOR_SLATE_TILE_STAIRS = new CustomStairsBlock(PHOSNOR_SLATE_TILES.getDefaultState(), DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomSlabBlock PHOSNOR_SLATE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomWallBlock PHOSNOR_SLATE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock COBBLED_PHOSNOR_SLATE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomStairsBlock COBBLED_PHOSNOR_SLATE_STAIRS = new CustomStairsBlock(COBBLED_PHOSNOR_SLATE.getDefaultState(), DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomSlabBlock COBBLED_PHOSNOR_SLATE_SLAB = new CustomSlabBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomWallBlock COBBLED_PHOSNOR_SLATE_WALL = new CustomWallBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock POLISHED_PHOSNOR_SLATE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomStairsBlock POLISHED_PHOSNOR_SLATE_STAIRS = new CustomStairsBlock(POLISHED_PHOSNOR_SLATE.getDefaultState(), DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomSlabBlock POLISHED_PHOSNOR_SLATE_SLAB = new CustomSlabBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomWallBlock POLISHED_PHOSNOR_SLATE_WALL = new CustomWallBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock CHISELED_PHOSNOR_SLATE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomTorchBlock EXYRIANE_TORCH = new CustomTorchBlock(DefaultBlockSettings.WOOD_SETTINGS.collidable(false).breakInstantly().luminance(14), ArcheonParticleTypes.EXYRIANE_FLAME);
	public static final CustomWallTorchBlock WALL_EXYRIANE_TORCH = new CustomWallTorchBlock(DefaultBlockSettings.WOOD_SETTINGS.collidable(false).breakInstantly().luminance(14), ArcheonParticleTypes.EXYRIANE_FLAME);
	public static final ExyrianeLanternBlock EXYRIANE_LANTERN = new ExyrianeLanternBlock(DefaultBlockSettings.STONE_SETTINGS.luminance(15), true);

	public static final CustomFurnaceBlock CHIASPEN_FURNACE = new CustomFurnaceBlock(DefaultBlockSettings.STONE_SETTINGS.luminance(state -> state.get(Properties.LIT) ? 13 : 0), true);
	public static final CustomFurnaceBlock PHOSNOR_SLATE_FURNACE = new CustomFurnaceBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS.luminance(state -> state.get(Properties.LIT) ? 13 : 0), true);

	public static final CustomBlock APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FAELITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock LUSONYTH_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SLIGHTLY_CONDENSED_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock SLIGHTLY_CONDENSED_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CONDENSED_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CONDENSED_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock PHOSNOR_SLATE_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock PHOSNOR_SLATE_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock PHOSNOR_SLATE_FAELITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock PHOSNOR_SLATE_LUSONYTH_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock SLIGHTLY_CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock SLIGHTLY_CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);
	public static final CustomBlock CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE = new CustomBlock(DefaultBlockSettings.DEEPSLATE_SETTINGS, true);

	public static final CustomBlock APAFLORITE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomBlock EXYRIANE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS.strength(4.0f), true);
	public static final CustomBlock FAELITE_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomBlock LUSONYTH_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomBlock CLEMENTIUM_BLOCK = new CustomBlock(DefaultBlockSettings.METAL_SETTINGS, true);

	public static final CustomBlock AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.TUFF), true);
	public static final CustomStairsBlock AKETITE_STAIRS = new CustomStairsBlock(AKETITE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.TUFF), true);
	public static final CustomSlabBlock AKETITE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.TUFF), true);
	public static final CustomWallBlock AKETITE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.TUFF), true);

	public static final CustomBlock AKETITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_BRICK_STAIRS = new CustomStairsBlock(AKETITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_TILE_STAIRS = new CustomStairsBlock(AKETITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_CHISELED_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_TEARS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_AKETITE_BRICKS_LINES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_AKETITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKED_AKETITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_BASEBOARD = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock INNERMOST_ROCK = new CustomBlock(DefaultBlockSettings.DEEP_BEDROCK_SETTINGS, true);

	public static final CustomBlock MYSTERIOUS_STONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MYSTERIOUS_STONE_STAIRS = new CustomStairsBlock(MYSTERIOUS_STONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MYSTERIOUS_STONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomSquaredPortalBlock ARCHEON_PORTAL = new CustomSquaredPortalBlock(ParticleTypes.ENCHANT, FabricBlockSettings.of(Material.PORTAL).noCollision().strength(-1.0F).luminance(11).sounds(BlockSoundGroup.GLASS));

	public static final CustomBlock ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.NETHERRACK), true);
	public static final CustomStairsBlock ARTEMNITE_STAIRS = new CustomStairsBlock(ARTEMNITE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.NETHERRACK), true);
	public static final CustomSlabBlock ARTEMNITE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.NETHERRACK), true);
	public static final CustomWallBlock ARTEMNITE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS.sounds(BlockSoundGroup.NETHERRACK), true);

	public static final CustomBlock ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(ARTEMNITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_TILE_STAIRS = new CustomStairsBlock(ARTEMNITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock MOSSY_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock MOSSY_ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(MOSSY_ARTEMNITE_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock MOSSY_ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock MOSSY_ARTEMNITE_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock FANCY_CHISELED_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock FANCY_ARTEMNITE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock FANCY_ARTEMNITE_TILE_STAIRS = new CustomStairsBlock(FANCY_ARTEMNITE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock FANCY_ARTEMNITE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock FANCY_ARTEMNITE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_TEARS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock ORNATE_ARTEMNITE_BRICKS_LINES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SMOOTH_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_ARTEMNITE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CRACKED_ARTEMNITE_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BASEBOARD = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CHIASPEN_LAMP = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.luminance(15), true);
	public static final CustomBlock AKETITE_LAMP = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS.luminance(15), true);

	public static final CustomPaneBlock CLEMENTIUM_BARS = new CustomPaneBlock(DefaultBlockSettings.METAL_SETTINGS, true);
	public static final CustomChainBlock CLEMENTIUM_CHAIN = new CustomChainBlock(DefaultBlockSettings.METAL_SETTINGS, true);

	public static final CentaurLifeVaultBlock CENTAUR_LIFE_VAULT = new CentaurLifeVaultBlock(DefaultBlockSettings.METAL_SETTINGS.nonOpaque().strength(-1, 3600000.0f), true);

	public static final PowerKeystoneBlock POWER_KEYSTONE = new PowerKeystoneBlock(DefaultBlockSettings.METAL_SETTINGS.strength(-1, 3600000.0f), true);
	public static final NaturiteBlock NATURITE = new NaturiteBlock(DefaultBlockSettings.NETHERITE_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_PALM_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_PALM_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_NECLANE_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NECLANE_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_CYPRESS_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_CYPRESS_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_VUXANCIA_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_VUXANCIA_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_NUME_WILLOW_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NUME_WILLOW_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomPillarBlock STRIPPED_NYRETH_WOOD = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomPillarBlock STRIPPED_NYRETH_LOG = new CustomPillarBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final BushLeavesBlock BUSH_LEAVES = new BushLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS.innerVelocityMultiplier(0.5f), true);
	public static final CustomLeavesBlock PALM_LEAVES = new PalmLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomLeavesBlock NECLANE_LEAVES = new NeclaneLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomLeavesBlock FLOWERED_NECLANE_LEAVES = new NeclaneLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomLeavesBlock CYPRESS_LEAVES = new CypressLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	public static final VuxanciaLeavesBlock PNEVENTIAL_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final VuxanciaLeavesBlock STREIAN_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final VuxanciaLeavesBlock ORIAN_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final VuxanciaLeavesBlock VALE_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final VuxanciaLeavesBlock ZIAL_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	public static final CustomLeavesBlock NUME_WILLOW_LEAVES = new CustomLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomLeavesBlock NYRETH_LEAVES = new CustomLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);
	public static final CustomLeavesBlock PALE_NYRETH_LEAVES = new CustomLeavesBlock(DefaultBlockSettings.LEAVES_SETTINGS, true);

	public static final CustomGrowsDownPlantBlock HANGING_PNEVENTIAL_VUXANCIA_LEAVES = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.005f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock HANGING_STREIAN_VUXANCIA_LEAVES = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.005f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock HANGING_ORIAN_VUXANCIA_LEAVES = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.005f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock HANGING_VALE_VUXANCIA_LEAVES = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.005f, 1, BlockState::isAir, true);
	public static final CustomGrowsDownPlantBlock HANGING_ZIAL_VUXANCIA_LEAVES = new CustomGrowsDownPlantBlock(DefaultBlockSettings.PLANT_SETTINGS,
		false, 0.005f, 1, BlockState::isAir, true);

	public static final ImmutableBlockSettings LEAVES_CARPET = ImmutableBlockSettings.of(Material.REPLACEABLE_PLANT).sounds(BlockSoundGroup.GRASS).noCollision().strength(0.2f);

	public static final LeavesCarpetBlock ORIAN_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock PNEVENTIAL_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock STREIAN_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock VALE_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET, true);
	public static final LeavesCarpetBlock ZIAL_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET, true);

	public static final CustomCraftingTableBlock PALM_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomCraftingTableBlock NECLANE_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomCraftingTableBlock CYPRESS_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomCraftingTableBlock VUXANCIA_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomCraftingTableBlock NUME_WILLOW_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomCraftingTableBlock NYRETH_CRAFTING_TABLE = new CustomCraftingTableBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomBookshelfBlock PALM_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBookshelfBlock NECLANE_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBookshelfBlock CYPRESS_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBookshelfBlock VUXANCIA_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBookshelfBlock NUME_WILLOW_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);
	public static final CustomBookshelfBlock NYRETH_BOOKSHELF = new CustomBookshelfBlock(DefaultBlockSettings.WOOD_SETTINGS, true);

	public static final CustomSaplingBlock PALM_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.PALM_TREE),
		floor -> floor.isOf(ArcheonBlocks.DUNE_SAND),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock NECLANE_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.NECLANE_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock CYPRESS_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.CYPRESS_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock PNEVENTIAL_VUXANCIA_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.PNEVENTIAL_VUXANCIA_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock STREIAN_VUXANCIA_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.STREIAN_VUXANCIA_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock ORIAN_VUXANCIA_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.ORIAN_VUXANCIA_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock VALE_VUXANCIA_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.VALE_VUXANCIA_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomSaplingBlock ZIAL_VUXANCIA_SAPLING = new CustomSaplingBlock(
		SaplingGeneratorUtils.of(() -> ArcheonFeatures.ZIAL_VUXANCIA_TREE),
		floor -> floor.isIn(ArcheonTags.Blocks.SOIL),
		DefaultBlockSettings.SAPLING_SETTINGS,
		true
	);

	public static final CustomPillarBlock CERAMIC_BLOCK = new CustomPillarBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_STAIRS = new CustomStairsBlock(CERAMIC_BLOCK.getDefaultState(), DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_SLAB = new CustomSlabBlock(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomPillarBlock CERAMIC_BRICKS = new CustomPillarBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_BRICK_STAIRS = new CustomStairsBlock(CERAMIC_BRICKS.getDefaultState(), DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomWallBlock CERAMIC_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomFenceBlock CERAMIC_FENCE = new CustomFenceBlock(DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CERAMIC_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.BONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone CERAMIC_BUTTON = new CustomButtonBlock.Stone(DefaultBlockSettings.BONE_SETTINGS, true);

	public static final CustomBlock SHORESTONE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SHORESTONE_STAIRS = new CustomStairsBlock(SHORESTONE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SHORESTONE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock SHORESTONE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomPointedDripstoneBlock POINTED_CRIADAN = new CustomPointedDripstoneBlock(ArcheonBlocks.CRIADAN, DefaultBlockSettings.BASALT_SETTINGS.dynamicBounds().offsetType(AbstractBlock.OffsetType.XZ), true);

	public static final CustomBlock CRIADAN = new CustomBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomStairsBlock CRIADAN_STAIRS = new CustomStairsBlock(CRIADAN.getDefaultState(), DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomSlabBlock CRIADAN_SLAB = new CustomSlabBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomWallBlock CRIADAN_WALL = new CustomWallBlock(DefaultBlockSettings.BASALT_SETTINGS, true);
	public static final CustomPressurePlateBlock CRIADAN_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.BASALT_SETTINGS, true);

	public static final CustomBlock CRIADAN_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CRIADAN_BRICK_STAIRS = new CustomStairsBlock(CRIADAN_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CRIADAN_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CRIADAN_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CRIADAN_BRICK_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CRIADAN_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CRIADAN_TILE_STAIRS = new CustomStairsBlock(CRIADAN_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CRIADAN_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CRIADAN_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CRIADAN_TILE_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock POLISHED_CRIADAN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock POLISHED_CRIADAN_STAIRS = new CustomStairsBlock(POLISHED_CRIADAN.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock POLISHED_CRIADAN_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock POLISHED_CRIADAN_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomPressurePlateBlock POLISHED_CRIADAN_PRESSURE_PLATE = new CustomPressurePlateBlock(ActivationRule.MOBS, DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomPillarBlock CRIADAN_PILLAR = new CustomPillarBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_CRIADAN = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ROUGHCAST = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ROUGHCAST_STAIRS = new CustomStairsBlock(ROUGHCAST.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ROUGHCAST_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ROUGHCAST_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomPointedDripstoneBlock POINTED_ANHYDRITE = new CustomPointedDripstoneBlock(
		ArcheonBlocks.ANHYDRITE,
		DefaultBlockSettings.AMETHYST_CLUSTER_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always)
			.dynamicBounds()
			.offsetType(AbstractBlock.OffsetType.XZ),
		true
	);

	public static final CustomBlock ANHYDRITE = new CustomBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomStairsBlock ANHYDRITE_STAIRS = new CustomStairsBlock(
		ANHYDRITE.getDefaultState(),
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomSlabBlock ANHYDRITE_SLAB = new CustomSlabBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomWallBlock ANHYDRITE_WALL = new CustomWallBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomPressurePlateBlock ANHYDRITE_PRESSURE_PLATE = new CustomPressurePlateBlock(
		ActivationRule.MOBS,
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomBlock ANHYDRITE_BRICKS = new CustomBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomStairsBlock ANHYDRITE_BRICK_STAIRS = new CustomStairsBlock(
		ANHYDRITE_BRICKS.getDefaultState(),
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomSlabBlock ANHYDRITE_BRICK_SLAB = new CustomSlabBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomWallBlock ANHYDRITE_BRICK_WALL = new CustomWallBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomPressurePlateBlock ANHYDRITE_BRICK_PRESSURE_PLATE = new CustomPressurePlateBlock(
		ActivationRule.MOBS,
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomBlock ANHYDRITE_TILES = new CustomBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomStairsBlock ANHYDRITE_TILE_STAIRS = new CustomStairsBlock(
		ANHYDRITE_TILES.getDefaultState(),
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomSlabBlock ANHYDRITE_TILE_SLAB = new CustomSlabBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomWallBlock ANHYDRITE_TILE_WALL = new CustomWallBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomPressurePlateBlock ANHYDRITE_TILE_PRESSURE_PLATE = new CustomPressurePlateBlock(
		ActivationRule.MOBS,
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomBlock POLISHED_ANHYDRITE = new CustomBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomStairsBlock POLISHED_ANHYDRITE_STAIRS = new CustomStairsBlock(
		POLISHED_ANHYDRITE.getDefaultState(),
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomSlabBlock POLISHED_ANHYDRITE_SLAB = new CustomSlabBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomWallBlock POLISHED_ANHYDRITE_WALL = new CustomWallBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomPressurePlateBlock POLISHED_ANHYDRITE_PRESSURE_PLATE = new CustomPressurePlateBlock(
		ActivationRule.MOBS,
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomPillarBlock ANHYDRITE_PILLAR = new CustomPillarBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

	public static final CustomBlock CHISELED_ANHYDRITE = new CustomBlock(
		DefaultBlockSettings.AMETHYST_SETTINGS
			.translucent(TriState.TRUE)
			.invisibleSides()
			.nonOpaque()
			.blockVision(AdvancedBlockSettings::never)
			.luminance(3)
			.emissiveLighting(AdvancedBlockSettings::always),
		true
	);

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

	public static final CustomBlock ANTIC_MOSAIC = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ANTIC_MOSAIC_STAIRS = new CustomStairsBlock(ANTIC_MOSAIC.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ANTIC_MOSAIC_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ANTIC_MOSAIC_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock ANTIC_FLOORTILE = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock ANTIC_FLOORTILE_STAIRS = new CustomStairsBlock(ANTIC_FLOORTILE.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock ANTIC_FLOORTILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock ANTIC_FLOORTILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock SNAIL_SHELL_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock SNAIL_SHELL_BRICK_STAIRS = new CustomStairsBlock(SNAIL_SHELL_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock SNAIL_SHELL_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock SNAIL_SHELL_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock FANCY_SNAIL_SHELL_BRICKS = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock FANCY_SNAIL_SHELL_BRICK_STAIRS = new CustomStairsBlock(FANCY_SNAIL_SHELL_BRICKS.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock FANCY_SNAIL_SHELL_BRICK_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock FANCY_SNAIL_SHELL_BRICK_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomLayeredBlock PEAKS_SNOW = new CustomLayeredBlock(DefaultBlockSettings.SNOW_SETTINGS, true);
	public static final CustomBlock PEAKS_SNOW_BLOCK = new CustomBlock(DefaultBlockSettings.SNOW_BLOCK_SETTINGS, true);

	public static final CustomBlock DARK_GREEN_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock DARK_GREEN_TILE_STAIRS = new CustomStairsBlock(DARK_GREEN_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock DARK_GREEN_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock DARK_GREEN_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock GREEN_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock GREEN_TILE_STAIRS = new CustomStairsBlock(GREEN_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock GREEN_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock GREEN_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock LIME_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock LIME_TILE_STAIRS = new CustomStairsBlock(LIME_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock LIME_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock LIME_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock TURQUOISE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock TURQUOISE_TILE_STAIRS = new CustomStairsBlock(TURQUOISE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock TURQUOISE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock TURQUOISE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock LIGHT_BLUE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock LIGHT_BLUE_TILE_STAIRS = new CustomStairsBlock(LIGHT_BLUE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock LIGHT_BLUE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock LIGHT_BLUE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock BLUE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock BLUE_TILE_STAIRS = new CustomStairsBlock(BLUE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock BLUE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock BLUE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock DARK_BLUE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock DARK_BLUE_TILE_STAIRS = new CustomStairsBlock(DARK_BLUE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock DARK_BLUE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock DARK_BLUE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock PURPLE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock PURPLE_TILE_STAIRS = new CustomStairsBlock(PURPLE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock PURPLE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock PURPLE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock PINK_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock PINK_TILE_STAIRS = new CustomStairsBlock(PINK_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock PINK_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock PINK_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock RED_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock RED_TILE_STAIRS = new CustomStairsBlock(RED_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock RED_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock RED_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock BLACK_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock BLACK_TILE_STAIRS = new CustomStairsBlock(BLACK_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock BLACK_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock BLACK_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock CERAMIC_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_TILE_STAIRS = new CustomStairsBlock(CERAMIC_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock CERAMIC_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final CustomBlock OCHRE_TILES = new CustomBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomStairsBlock OCHRE_TILE_STAIRS = new CustomStairsBlock(OCHRE_TILES.getDefaultState(), DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomSlabBlock OCHRE_TILE_SLAB = new CustomSlabBlock(DefaultBlockSettings.STONE_SETTINGS, true);
	public static final CustomWallBlock OCHRE_TILE_WALL = new CustomWallBlock(DefaultBlockSettings.STONE_SETTINGS, true);

	public static final DuneSandCastleBlock DUNE_SAND_CASTLE = new DuneSandCastleBlock(DefaultBlockSettings.SAND_SETTINGS.nonOpaque().strength(0.7f, 0.0f), true);
	public static final UrnBlock URN = new UrnBlock(DefaultBlockSettings.BONE_SETTINGS.nonOpaque().strength(0.8f, 2.0f).breakInstantly(), true);
	public static final HeartOfNatureTrophyBlock HEART_OF_NATURE_TROPHY = new HeartOfNatureTrophyBlock(DefaultBlockSettings.LODESTONE_SETTINGS.nonOpaque().strength(1.0f, 6.0f), true, new AdvancedItemSettings().maxCount(1).fireproof());

	@Override
	public void register() {
		HOT_SPRING_WATER_CAULDRON.register(Archeon.createId("hot_spring_water_cauldron"));
		DASCIUM_CAULDRON.register(Archeon.createId("dascium_cauldron"));
		SUNSET_ORCHID.register(Archeon.createId("sunset_orchid"));
		ROSEYPIA.register(Archeon.createId("roseypia"));
		AEROLIA.register(Archeon.createId("aerolia"));
		DOTTED_STOVIA.register(Archeon.createId("dotted_stovia"));
		WILLS_OF_LIGHT.register(Archeon.createId("wills_of_light"));
		ETERNAL_FORTUNES.register(Archeon.createId("eternal_fortunes"));
		ASTEDIBES.register(Archeon.createId("astedibes"));
		TWILIGHT_ROSE.register(Archeon.createId("twilight_rose"));
		PINK_LYCORIS.register(Archeon.createId("pink_lycoris"));
		RED_LYCORIS.register(Archeon.createId("red_lycoris"));
		ORANGE_LYCORIS.register(Archeon.createId("orange_lycoris"));
		ASCENDIA.register(Archeon.createId("ascendia"));
		OEA.register(Archeon.createId("oea"));
		IOPEA.register(Archeon.createId("iopea"));
		TALL_IOPEA.register(Archeon.createId("tall_iopea"));
		ORGANDEANE_BLOSSOM.register(Archeon.createId("organdeane_blossom"));
		TALL_ORGANDEANE.register(Archeon.createId("tall_organdeane"));
		SEPTICEOLIA.register(Archeon.createId("septiceolia"));
		BLUE_DOELDIA.register(Archeon.createId("blue_doeldia"));
		WHITE_DOELDIA.register(Archeon.createId("white_doeldia"));
		PINK_DOELDIA.register(Archeon.createId("pink_doeldia"));
		YELLOW_DOELDIA.register(Archeon.createId("yellow_doeldia"));
		SMALL_HOT_SPRING_LILY_PAD.register(Archeon.createId("small_hot_spring_lily_pad"));
		HOT_SPRING_LILY_PAD.register(Archeon.createId("hot_spring_lily_pad"));
		GIANT_LILY.register(Archeon.createId("giant_lily"));
		ACHREAN_VINES.register(Archeon.createId("achrean_vines"));
		WET_GRASS.register(Archeon.createId("wet_grass"));
		TALL_WET_GRASS.register(Archeon.createId("tall_wet_grass"));
		FLOWERED_WET_GRASS.register(Archeon.createId("flowered_wet_grass"));
		FLOWERED_TALL_WET_GRASS.register(Archeon.createId("flowered_tall_wet_grass"));
		WET_FERN.register(Archeon.createId("wet_fern"));
		TALL_WET_FERN.register(Archeon.createId("tall_wet_fern"));
		WET_GRASS_TUFFET.register(Archeon.createId("wet_grass_tuffet"));
		DEAD_WET_GRASS_TUFFET.register(Archeon.createId("dead_wet_grass_tuffet"));
		SNOWY_GRASS_TUFFET.register(Archeon.createId("snowy_grass_tuffet"));
		SOUTH_WHEAT.register(Archeon.createId("south_wheat"));
		BUSH.register(Archeon.createId("bush"));
		VINE.register(Archeon.createId("vine"));
		BLOOD_ORANGE_BUSH.register(Archeon.createId("blood_orange_bush"));
		XETULIAN_SUGAR_CANE.register(Archeon.createId("xetulian_sugar_cane"));
		SPORE_ROOTCAP.register(Archeon.createId("spore_rootcap"));
		GLOWSPROUTS.register(Archeon.createId("glowsprouts"));
		GLOWSHROOMS.register(Archeon.createId("glowshrooms"));
		GLOWSHROOM_PARASITES.register(Archeon.createId("glowshroom_parasites"));
		GLOWSHROOM_MOSS.register(Archeon.createId("glowshroom_moss"));
		GLOWSHROOM_MOSS_BLOCK.register(Archeon.createId("glowshroom_moss_block"));
		WET_GRASS_BLOCK.register(Archeon.createId("wet_grass_block"));
		WET_DIRT.register(Archeon.createId("wet_dirt"));
		ACHREAN_MOSS.register(Archeon.createId("achrean_moss"));
		ACHREAN_MOSS_BLOCK.register(Archeon.createId("achrean_moss_block"));
		DUNE_SAND.register(Archeon.createId("dune_sand"));
		SHELLSAND.register(Archeon.createId("shellsand"));
		SALT_BLOCK.register(Archeon.createId("salt_block"));
		DUST.register(Archeon.createId("dust"));
		GOLDEN_CLAY.register(Archeon.createId("golden_clay"));
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
		NECLANE_BED.register(Archeon.createId("neclane_bed"));
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
		NUME_WILLOW_WOOD.register(Archeon.createId("nume_willow_wood"));
		NUME_WILLOW_LOG.register(Archeon.createId("nume_willow_log"));
		NUME_WILLOW_PLANKS.register(Archeon.createId("nume_willow_planks"));
		NUME_WILLOW_STAIRS.register(Archeon.createId("nume_willow_stairs"));
		NUME_WILLOW_SLAB.register(Archeon.createId("nume_willow_slab"));
		NUME_WILLOW_FENCE.register(Archeon.createId("nume_willow_fence"));
		NUME_WILLOW_FENCE_GATE.register(Archeon.createId("nume_willow_fence_gate"));
		NUME_WILLOW_PRESSURE_PLATE.register(Archeon.createId("nume_willow_pressure_plate"));
		NUME_WILLOW_BUTTON.register(Archeon.createId("nume_willow_button"));
		NUME_WILLOW_DOOR.register(Archeon.createId("nume_willow_door"));
		NUME_WILLOW_TRAPDOOR.register(Archeon.createId("nume_willow_trapdoor"));
		NYRETH_WOOD.register(Archeon.createId("nyreth_wood"));
		NYRETH_LOG.register(Archeon.createId("nyreth_log"));
		NYRETH_PLANKS.register(Archeon.createId("nyreth_planks"));
		NYRETH_STAIRS.register(Archeon.createId("nyreth_stairs"));
		NYRETH_SLAB.register(Archeon.createId("nyreth_slab"));
		NYRETH_FENCE.register(Archeon.createId("nyreth_fence"));
		NYRETH_FENCE_GATE.register(Archeon.createId("nyreth_fence_gate"));
		NYRETH_PRESSURE_PLATE.register(Archeon.createId("nyreth_pressure_plate"));
		NYRETH_BUTTON.register(Archeon.createId("nyreth_button"));
		NYRETH_DOOR.register(Archeon.createId("nyreth_door"));
		NYRETH_TRAPDOOR.register(Archeon.createId("nyreth_trapdoor"));
		CHIASPEN.register(Archeon.createId("chiaspen"));
		CHIASPEN_STAIRS.register(Archeon.createId("chiaspen_stairs"));
		CHIASPEN_SLAB.register(Archeon.createId("chiaspen_slab"));
		CHIASPEN_WALL.register(Archeon.createId("chiaspen_wall"));
		CHIASPEN_BRICKS.register(Archeon.createId("chiaspen_bricks"));
		CHIASPEN_BRICK_STAIRS.register(Archeon.createId("chiaspen_brick_stairs"));
		CHIASPEN_BRICK_SLAB.register(Archeon.createId("chiaspen_brick_slab"));
		CHIASPEN_BRICK_WALL.register(Archeon.createId("chiaspen_brick_wall"));
		COBBLED_CHIASPEN.register(Archeon.createId("cobbled_chiaspen"));
		COBBLED_CHIASPEN_STAIRS.register(Archeon.createId("cobbled_chiaspen_stairs"));
		COBBLED_CHIASPEN_SLAB.register(Archeon.createId("cobbled_chiaspen_slab"));
		COBBLED_CHIASPEN_WALL.register(Archeon.createId("cobbled_chiaspen_wall"));
		GILDED_COBBLED_CHIASPEN.register(Archeon.createId("gilded_cobbled_chiaspen"));
		GILDED_COBBLED_CHIASPEN_STAIRS.register(Archeon.createId("gilded_cobbled_chiaspen_stairs"));
		GILDED_COBBLED_CHIASPEN_SLAB.register(Archeon.createId("gilded_cobbled_chiaspen_slab"));
		GILDED_COBBLED_CHIASPEN_WALL.register(Archeon.createId("gilded_cobbled_chiaspen_wall"));
		CHIASPEN_PILLAR_TOP.register(Archeon.createId("chiaspen_pillar_top"));
		CHIASPEN_PILLAR.register(Archeon.createId("chiaspen_pillar"));
		CHIASPEN_PILLAR_BOTTOM.register(Archeon.createId("chiaspen_pillar_bottom"));
		CHIASPEN_COLUMN.register(Archeon.createId("chiaspen_column"));
		SMOOTH_CHIASPEN.register(Archeon.createId("smooth_chiaspen"));
		SMOOTH_CHIASPEN_STAIRS.register(Archeon.createId("smooth_chiaspen_stairs"));
		SMOOTH_CHIASPEN_SLAB.register(Archeon.createId("smooth_chiaspen_slab"));
		CHISELED_CHIASPEN.register(Archeon.createId("chiseled_chiaspen"));
		CRACKED_CHIASPEN_BRICKS.register(Archeon.createId("cracked_chiaspen_bricks"));
		CHIASPEN_PRESSURE_PLATE.register(Archeon.createId("chiaspen_pressure_plate"));
		CHIASPEN_BUTTON.register(Archeon.createId("chiaspen_button"));
		MOSSY_CHIASPEN_BRICKS.register(Archeon.createId("mossy_chiaspen_bricks"));
		MOSSY_CHIASPEN_BRICK_STAIRS.register(Archeon.createId("mossy_chiaspen_brick_stairs"));
		MOSSY_CHIASPEN_BRICK_SLAB.register(Archeon.createId("mossy_chiaspen_brick_slab"));
		MOSSY_CHIASPEN_BRICK_WALL.register(Archeon.createId("mossy_chiaspen_brick_wall"));
		MOSSY_COBBLED_CHIASPEN.register(Archeon.createId("mossy_cobbled_chiaspen"));
		MOSSY_COBBLED_CHIASPEN_STAIRS.register(Archeon.createId("mossy_cobbled_chiaspen_stairs"));
		MOSSY_COBBLED_CHIASPEN_SLAB.register(Archeon.createId("mossy_cobbled_chiaspen_slab"));
		MOSSY_COBBLED_CHIASPEN_WALL.register(Archeon.createId("mossy_cobbled_chiaspen_wall"));
		FALSE_CHIASPEN_BRICKS.register(Archeon.createId("false_chiaspen_bricks"));
		FALSE_CRACKED_CHIASPEN_BRICKS.register(Archeon.createId("false_cracked_chiaspen_bricks"));
		FALSE_MOSSY_CHIASPEN_BRICKS.register(Archeon.createId("false_mossy_chiaspen_bricks"));
		PHOSNOR_SLATE.register(Archeon.createId("phosnor_slate"));
		PHOSNOR_SLATE_STAIRS.register(Archeon.createId("phosnor_slate_stairs"));
		PHOSNOR_SLATE_SLAB.register(Archeon.createId("phosnor_slate_slab"));
		PHOSNOR_SLATE_WALL.register(Archeon.createId("phosnor_slate_wall"));
		PHOSNOR_SLATE_BRICKS.register(Archeon.createId("phosnor_slate_bricks"));
		PHOSNOR_SLATE_BRICK_STAIRS.register(Archeon.createId("phosnor_slate_brick_stairs"));
		PHOSNOR_SLATE_BRICK_SLAB.register(Archeon.createId("phosnor_slate_brick_slab"));
		PHOSNOR_SLATE_BRICK_WALL.register(Archeon.createId("phosnor_slate_brick_wall"));
		PHOSNOR_SLATE_TILES.register(Archeon.createId("phosnor_slate_tiles"));
		PHOSNOR_SLATE_TILE_STAIRS.register(Archeon.createId("phosnor_slate_tile_stairs"));
		PHOSNOR_SLATE_TILE_SLAB.register(Archeon.createId("phosnor_slate_tile_slab"));
		PHOSNOR_SLATE_TILE_WALL.register(Archeon.createId("phosnor_slate_tile_wall"));
		COBBLED_PHOSNOR_SLATE.register(Archeon.createId("cobbled_phosnor_slate"));
		COBBLED_PHOSNOR_SLATE_STAIRS.register(Archeon.createId("cobbled_phosnor_slate_stairs"));
		COBBLED_PHOSNOR_SLATE_SLAB.register(Archeon.createId("cobbled_phosnor_slate_slab"));
		COBBLED_PHOSNOR_SLATE_WALL.register(Archeon.createId("cobbled_phosnor_slate_wall"));
		POLISHED_PHOSNOR_SLATE.register(Archeon.createId("polished_phosnor_slate"));
		POLISHED_PHOSNOR_SLATE_STAIRS.register(Archeon.createId("polished_phosnor_slate_stairs"));
		POLISHED_PHOSNOR_SLATE_SLAB.register(Archeon.createId("polished_phosnor_slate_slab"));
		POLISHED_PHOSNOR_SLATE_WALL.register(Archeon.createId("polished_phosnor_slate_wall"));
		CHISELED_PHOSNOR_SLATE.register(Archeon.createId("chiseled_phosnor_slate"));
		EXYRIANE_TORCH.register(Archeon.createId("exyriane_torch"));
		WALL_EXYRIANE_TORCH.register(Archeon.createId("wall_exyriane_torch"));
		EXYRIANE_LANTERN.register(Archeon.createId("exyriane_lantern"));
		APAFLORITE_ORE.register(Archeon.createId("apaflorite_ore"));
		EXYRIANE_ORE.register(Archeon.createId("exyriane_ore"));
		FAELITE_ORE.register(Archeon.createId("faelite_ore"));
		LUSONYTH_ORE.register(Archeon.createId("lusonyth_ore"));
		SLIGHTLY_CONDENSED_APAFLORITE_ORE.register(Archeon.createId("slightly_condensed_apaflorite_ore"));
		SLIGHTLY_CONDENSED_EXYRIANE_ORE.register(Archeon.createId("slightly_condensed_exyriane_ore"));
		CONDENSED_APAFLORITE_ORE.register(Archeon.createId("condensed_apaflorite_ore"));
		CONDENSED_EXYRIANE_ORE.register(Archeon.createId("condensed_exyriane_ore"));
		PHOSNOR_SLATE_APAFLORITE_ORE.register(Archeon.createId("phosnor_slate_apaflorite_ore"));
		PHOSNOR_SLATE_EXYRIANE_ORE.register(Archeon.createId("phosnor_slate_exyriane_ore"));
		PHOSNOR_SLATE_FAELITE_ORE.register(Archeon.createId("phosnor_slate_faelite_ore"));
		PHOSNOR_SLATE_LUSONYTH_ORE.register(Archeon.createId("phosnor_slate_lusonyth_ore"));
		SLIGHTLY_CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE.register(Archeon.createId("slightly_condensed_phosnor_slate_apaflorite_ore"));
		SLIGHTLY_CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE.register(Archeon.createId("slightly_condensed_phosnor_slate_exyriane_ore"));
		CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE.register(Archeon.createId("condensed_phosnor_slate_apaflorite_ore"));
		CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE.register(Archeon.createId("condensed_phosnor_slate_exyriane_ore"));
		APAFLORITE_BLOCK.register(Archeon.createId("apaflorite_block"));
		EXYRIANE_BLOCK.register(Archeon.createId("exyriane_block"));
		FAELITE_BLOCK.register(Archeon.createId("faelite_block"));
		LUSONYTH_BLOCK.register(Archeon.createId("lusonyth_block"));
		CLEMENTIUM_BLOCK.register(Archeon.createId("clementium_block"));
		AKETITE.register(Archeon.createId("aketite"));
		AKETITE_STAIRS.register(Archeon.createId("aketite_stairs"));
		AKETITE_SLAB.register(Archeon.createId("aketite_slab"));
		AKETITE_WALL.register(Archeon.createId("aketite_wall"));
		AKETITE_BRICKS.register(Archeon.createId("aketite_bricks"));
		AKETITE_BRICK_STAIRS.register(Archeon.createId("aketite_brick_stairs"));
		AKETITE_BRICK_SLAB.register(Archeon.createId("aketite_brick_slab"));
		AKETITE_BRICK_WALL.register(Archeon.createId("aketite_brick_wall"));
		AKETITE_TILES.register(Archeon.createId("aketite_tiles"));
		AKETITE_TILE_STAIRS.register(Archeon.createId("aketite_tile_stairs"));
		AKETITE_TILE_SLAB.register(Archeon.createId("aketite_tile_slab"));
		AKETITE_TILE_WALL.register(Archeon.createId("aketite_tile_wall"));
		ORNATE_CHISELED_AKETITE.register(Archeon.createId("ornate_chiseled_aketite"));
		ORNATE_AKETITE_BRICKS_TEARS.register(Archeon.createId("ornate_aketite_bricks_tears"));
		ORNATE_AKETITE_BRICKS_LINES.register(Archeon.createId("ornate_aketite_bricks_lines"));
		SMOOTH_AKETITE.register(Archeon.createId("smooth_aketite"));
		CHISELED_AKETITE.register(Archeon.createId("chiseled_aketite"));
		CRACKED_AKETITE_BRICKS.register(Archeon.createId("cracked_aketite_bricks"));
		AKETITE_BASEBOARD.register(Archeon.createId("aketite_baseboard"));
		INNERMOST_ROCK.register(Archeon.createId("innermost_rock"));
		MYSTERIOUS_STONE.register(Archeon.createId("mysterious_stone"));
		MYSTERIOUS_STONE_STAIRS.register(Archeon.createId("mysterious_stone_stairs"));
		MYSTERIOUS_STONE_SLAB.register(Archeon.createId("mysterious_stone_slab"));
		ARCHEON_PORTAL.register(Archeon.createId("archeon_portal"));
		ARTEMNITE.register(Archeon.createId("artemnite"));
		ARTEMNITE_STAIRS.register(Archeon.createId("artemnite_stairs"));
		ARTEMNITE_SLAB.register(Archeon.createId("artemnite_slab"));
		ARTEMNITE_WALL.register(Archeon.createId("artemnite_wall"));
		ARTEMNITE_BRICKS.register(Archeon.createId("artemnite_bricks"));
		ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("artemnite_brick_stairs"));
		ARTEMNITE_BRICK_SLAB.register(Archeon.createId("artemnite_brick_slab"));
		ARTEMNITE_BRICK_WALL.register(Archeon.createId("artemnite_brick_wall"));
		ARTEMNITE_TILES.register(Archeon.createId("artemnite_tiles"));
		ARTEMNITE_TILE_STAIRS.register(Archeon.createId("artemnite_tile_stairs"));
		ARTEMNITE_TILE_SLAB.register(Archeon.createId("artemnite_tile_slab"));
		ARTEMNITE_TILE_WALL.register(Archeon.createId("artemnite_tile_wall"));
		MOSSY_ARTEMNITE_BRICKS.register(Archeon.createId("mossy_artemnite_bricks"));
		MOSSY_ARTEMNITE_BRICK_STAIRS.register(Archeon.createId("mossy_artemnite_brick_stairs"));
		MOSSY_ARTEMNITE_BRICK_SLAB.register(Archeon.createId("mossy_artemnite_brick_slab"));
		MOSSY_ARTEMNITE_BRICK_WALL.register(Archeon.createId("mossy_artemnite_brick_wall"));
		FANCY_CHISELED_ARTEMNITE.register(Archeon.createId("fancy_chiseled_artemnite"));
		FANCY_ARTEMNITE_TILES.register(Archeon.createId("fancy_artemnite_tiles"));
		FANCY_ARTEMNITE_TILE_STAIRS.register(Archeon.createId("fancy_artemnite_tile_stairs"));
		FANCY_ARTEMNITE_TILE_SLAB.register(Archeon.createId("fancy_artemnite_tile_slab"));
		FANCY_ARTEMNITE_TILE_WALL.register(Archeon.createId("fancy_artemnite_tile_wall"));
		ORNATE_ARTEMNITE_BRICKS.register(Archeon.createId("ornate_artemnite_bricks"));
		ORNATE_ARTEMNITE_BRICKS_TEARS.register(Archeon.createId("ornate_artemnite_bricks_tears"));
		ORNATE_ARTEMNITE_BRICKS_LINES.register(Archeon.createId("ornate_artemnite_bricks_lines"));
		SMOOTH_ARTEMNITE.register(Archeon.createId("smooth_artemnite"));
		CHISELED_ARTEMNITE.register(Archeon.createId("chiseled_artemnite"));
		CRACKED_ARTEMNITE_BRICKS.register(Archeon.createId("cracked_artemnite_bricks"));
		ARTEMNITE_BASEBOARD.register(Archeon.createId("artemnite_baseboard"));
		CHIASPEN_LAMP.register(Archeon.createId("chiaspen_lamp"));
		AKETITE_LAMP.register(Archeon.createId("aketite_lamp"));
		CLEMENTIUM_BARS.register(Archeon.createId("clementium_bars"));
		CLEMENTIUM_CHAIN.register(Archeon.createId("clementium_chain"));
		CENTAUR_LIFE_VAULT.register(Archeon.createId("centaur_life_vault"));
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
		STRIPPED_NUME_WILLOW_WOOD.register(Archeon.createId("stripped_nume_willow_wood"));
		STRIPPED_NUME_WILLOW_LOG.register(Archeon.createId("stripped_nume_willow_log"));
		STRIPPED_NYRETH_WOOD.register(Archeon.createId("stripped_nyreth_wood"));
		STRIPPED_NYRETH_LOG.register(Archeon.createId("stripped_nyreth_log"));
		BUSH_LEAVES.register(Archeon.createId("bush_leaves"));
		PALM_LEAVES.register(Archeon.createId("palm_leaves"));
		NECLANE_LEAVES.register(Archeon.createId("neclane_leaves"));
		FLOWERED_NECLANE_LEAVES.register(Archeon.createId("flowered_neclane_leaves"));
		CYPRESS_LEAVES.register(Archeon.createId("cypress_leaves"));
		PNEVENTIAL_VUXANCIA_LEAVES.register(Archeon.createId("pnevential_vuxancia_leaves"));
		STREIAN_VUXANCIA_LEAVES.register(Archeon.createId("streian_vuxancia_leaves"));
		ORIAN_VUXANCIA_LEAVES.register(Archeon.createId("orian_vuxancia_leaves"));
		VALE_VUXANCIA_LEAVES.register(Archeon.createId("vale_vuxancia_leaves"));
		ZIAL_VUXANCIA_LEAVES.register(Archeon.createId("zial_vuxancia_leaves"));
		NUME_WILLOW_LEAVES.register(Archeon.createId("nume_willow_leaves"));
		NYRETH_LEAVES.register(Archeon.createId("nyreth_leaves"));
		PALE_NYRETH_LEAVES.register(Archeon.createId("pale_nyreth_leaves"));
		HANGING_PNEVENTIAL_VUXANCIA_LEAVES.register(Archeon.createId("hanging_pnevential_vuxancia_leaves"));
		HANGING_STREIAN_VUXANCIA_LEAVES.register(Archeon.createId("hanging_streian_vuxancia_leaves"));
		HANGING_ORIAN_VUXANCIA_LEAVES.register(Archeon.createId("hanging_orian_vuxancia_leaves"));
		HANGING_VALE_VUXANCIA_LEAVES.register(Archeon.createId("hanging_vale_vuxancia_leaves"));
		HANGING_ZIAL_VUXANCIA_LEAVES.register(Archeon.createId("hanging_zial_vuxancia_leaves"));
		PNEVENTIAL_VUXANCIA_LEAVES_CARPET.register(Archeon.createId("pnevential_vuxancia_leaves_carpet"));
		STREIAN_VUXANCIA_LEAVES_CARPET.register(Archeon.createId("streian_vuxancia_leaves_carpet"));
		ORIAN_VUXANCIA_LEAVES_CARPET.register(Archeon.createId("orian_vuxancia_leaves_carpet"));
		VALE_VUXANCIA_LEAVES_CARPET.register(Archeon.createId("vale_vuxancia_leaves_carpet"));
		ZIAL_VUXANCIA_LEAVES_CARPET.register(Archeon.createId("zial_vuxancia_leaves_carpet"));
		PALM_CRAFTING_TABLE.register(Archeon.createId("palm_crafting_table"));
		NECLANE_CRAFTING_TABLE.register(Archeon.createId("neclane_crafting_table"));
		CYPRESS_CRAFTING_TABLE.register(Archeon.createId("cypress_crafting_table"));
		VUXANCIA_CRAFTING_TABLE.register(Archeon.createId("vuxancia_crafting_table"));
		NUME_WILLOW_CRAFTING_TABLE.register(Archeon.createId("nume_willow_crafting_table"));
		NYRETH_CRAFTING_TABLE.register(Archeon.createId("nyreth_crafting_table"));
		CHIASPEN_FURNACE.register(Archeon.createId("chiaspen_furnace"));
		PHOSNOR_SLATE_FURNACE.register(Archeon.createId("phosnor_slate_furnace"));
		PALM_BOOKSHELF.register(Archeon.createId("palm_bookshelf"));
		NECLANE_BOOKSHELF.register(Archeon.createId("neclane_bookshelf"));
		CYPRESS_BOOKSHELF.register(Archeon.createId("cypress_bookshelf"));
		VUXANCIA_BOOKSHELF.register(Archeon.createId("vuxancia_bookshelf"));
		NUME_WILLOW_BOOKSHELF.register(Archeon.createId("nume_willow_bookshelf"));
		NYRETH_BOOKSHELF.register(Archeon.createId("nyreth_bookshelf"));
		PALM_SAPLING.register(Archeon.createId("palm_sapling"));
		NECLANE_SAPLING.register(Archeon.createId("neclane_sapling"));
		CYPRESS_SAPLING.register(Archeon.createId("cypress_sapling"));
		PNEVENTIAL_VUXANCIA_SAPLING.register(Archeon.createId("pnevential_vuxancia_sapling"));
		STREIAN_VUXANCIA_SAPLING.register(Archeon.createId("streian_vuxancia_sapling"));
		ORIAN_VUXANCIA_SAPLING.register(Archeon.createId("orian_vuxancia_sapling"));
		VALE_VUXANCIA_SAPLING.register(Archeon.createId("vale_vuxancia_sapling"));
		ZIAL_VUXANCIA_SAPLING.register(Archeon.createId("zial_vuxancia_sapling"));
		CERAMIC_BLOCK.register(Archeon.createId("ceramic_block"));
		CERAMIC_STAIRS.register(Archeon.createId("ceramic_stairs"));
		CERAMIC_SLAB.register(Archeon.createId("ceramic_slab"));
		CERAMIC_BRICKS.register(Archeon.createId("ceramic_bricks"));
		CERAMIC_BRICK_STAIRS.register(Archeon.createId("ceramic_brick_stairs"));
		CERAMIC_BRICK_SLAB.register(Archeon.createId("ceramic_brick_slab"));
		CERAMIC_BRICK_WALL.register(Archeon.createId("ceramic_brick_wall"));
		CERAMIC_FENCE.register(Archeon.createId("ceramic_fence"));
		CERAMIC_PRESSURE_PLATE.register(Archeon.createId("ceramic_pressure_plate"));
		CERAMIC_BUTTON.register(Archeon.createId("ceramic_button"));
		SHORESTONE.register(Archeon.createId("shorestone"));
		SHORESTONE_STAIRS.register(Archeon.createId("shorestone_stairs"));
		SHORESTONE_SLAB.register(Archeon.createId("shorestone_slab"));
		SHORESTONE_WALL.register(Archeon.createId("shorestone_wall"));
		POINTED_CRIADAN.register(Archeon.createId("pointed_criadan"));
		CRIADAN.register(Archeon.createId("criadan"));
		CRIADAN_STAIRS.register(Archeon.createId("criadan_stairs"));
		CRIADAN_SLAB.register(Archeon.createId("criadan_slab"));
		CRIADAN_WALL.register(Archeon.createId("criadan_wall"));
		CRIADAN_PRESSURE_PLATE.register(Archeon.createId("criadan_pressure_plate"));
		CRIADAN_BRICKS.register(Archeon.createId("criadan_bricks"));
		CRIADAN_BRICK_STAIRS.register(Archeon.createId("criadan_brick_stairs"));
		CRIADAN_BRICK_SLAB.register(Archeon.createId("criadan_brick_slab"));
		CRIADAN_BRICK_WALL.register(Archeon.createId("criadan_brick_wall"));
		CRIADAN_BRICK_PRESSURE_PLATE.register(Archeon.createId("criadan_brick_pressure_plate"));
		CRIADAN_TILES.register(Archeon.createId("criadan_tiles"));
		CRIADAN_TILE_STAIRS.register(Archeon.createId("criadan_tile_stairs"));
		CRIADAN_TILE_SLAB.register(Archeon.createId("criadan_tile_slab"));
		CRIADAN_TILE_WALL.register(Archeon.createId("criadan_tile_wall"));
		CRIADAN_TILE_PRESSURE_PLATE.register(Archeon.createId("criadan_tile_pressure_plate"));
		POLISHED_CRIADAN.register(Archeon.createId("polished_criadan"));
		POLISHED_CRIADAN_STAIRS.register(Archeon.createId("polished_criadan_stairs"));
		POLISHED_CRIADAN_SLAB.register(Archeon.createId("polished_criadan_slab"));
		POLISHED_CRIADAN_WALL.register(Archeon.createId("polished_criadan_wall"));
		POLISHED_CRIADAN_PRESSURE_PLATE.register(Archeon.createId("polished_criadan_pressure_plate"));
		CRIADAN_PILLAR.register(Archeon.createId("criadan_pillar"));
		CHISELED_CRIADAN.register(Archeon.createId("chiseled_criadan"));
		ROUGHCAST.register(Archeon.createId("roughcast"));
		ROUGHCAST_STAIRS.register(Archeon.createId("roughcast_stairs"));
		ROUGHCAST_SLAB.register(Archeon.createId("roughcast_slab"));
		ROUGHCAST_WALL.register(Archeon.createId("roughcast_wall"));
		POINTED_ANHYDRITE.register(Archeon.createId("pointed_anhydrite"));
		ANHYDRITE.register(Archeon.createId("anhydrite"));
		ANHYDRITE_STAIRS.register(Archeon.createId("anhydrite_stairs"));
		ANHYDRITE_SLAB.register(Archeon.createId("anhydrite_slab"));
		ANHYDRITE_WALL.register(Archeon.createId("anhydrite_wall"));
		ANHYDRITE_PRESSURE_PLATE.register(Archeon.createId("anhydrite_pressure_plate"));
		ANHYDRITE_BRICKS.register(Archeon.createId("anhydrite_bricks"));
		ANHYDRITE_BRICK_STAIRS.register(Archeon.createId("anhydrite_brick_stairs"));
		ANHYDRITE_BRICK_SLAB.register(Archeon.createId("anhydrite_brick_slab"));
		ANHYDRITE_BRICK_WALL.register(Archeon.createId("anhydrite_brick_wall"));
		ANHYDRITE_BRICK_PRESSURE_PLATE.register(Archeon.createId("anhydrite_brick_pressure_plate"));
		ANHYDRITE_TILES.register(Archeon.createId("anhydrite_tiles"));
		ANHYDRITE_TILE_STAIRS.register(Archeon.createId("anhydrite_tile_stairs"));
		ANHYDRITE_TILE_SLAB.register(Archeon.createId("anhydrite_tile_slab"));
		ANHYDRITE_TILE_WALL.register(Archeon.createId("anhydrite_tile_wall"));
		ANHYDRITE_TILE_PRESSURE_PLATE.register(Archeon.createId("anhydrite_tile_pressure_plate"));
		POLISHED_ANHYDRITE.register(Archeon.createId("polished_anhydrite"));
		POLISHED_ANHYDRITE_STAIRS.register(Archeon.createId("polished_anhydrite_stairs"));
		POLISHED_ANHYDRITE_SLAB.register(Archeon.createId("polished_anhydrite_slab"));
		POLISHED_ANHYDRITE_WALL.register(Archeon.createId("polished_anhydrite_wall"));
		POLISHED_ANHYDRITE_PRESSURE_PLATE.register(Archeon.createId("polished_anhydrite_pressure_plate"));
		ANHYDRITE_PILLAR.register(Archeon.createId("anhydrite_pillar"));
		CHISELED_ANHYDRITE.register(Archeon.createId("chiseled_anhydrite"));
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
		ANTIC_MOSAIC.register(Archeon.createId("antic_mosaic"));
		ANTIC_MOSAIC_STAIRS.register(Archeon.createId("antic_mosaic_stairs"));
		ANTIC_MOSAIC_SLAB.register(Archeon.createId("antic_mosaic_slab"));
		ANTIC_MOSAIC_WALL.register(Archeon.createId("antic_mosaic_wall"));
		ANTIC_FLOORTILE.register(Archeon.createId("antic_floortile"));
		ANTIC_FLOORTILE_STAIRS.register(Archeon.createId("antic_floortile_stairs"));
		ANTIC_FLOORTILE_SLAB.register(Archeon.createId("antic_floortile_slab"));
		ANTIC_FLOORTILE_WALL.register(Archeon.createId("antic_floortile_wall"));
		SNAIL_SHELL_BRICKS.register(Archeon.createId("snail_shell_bricks"));
		SNAIL_SHELL_BRICK_STAIRS.register(Archeon.createId("snail_shell_brick_stairs"));
		SNAIL_SHELL_BRICK_SLAB.register(Archeon.createId("snail_shell_brick_slab"));
		SNAIL_SHELL_BRICK_WALL.register(Archeon.createId("snail_shell_brick_wall"));
		FANCY_SNAIL_SHELL_BRICKS.register(Archeon.createId("fancy_snail_shell_bricks"));
		FANCY_SNAIL_SHELL_BRICK_STAIRS.register(Archeon.createId("fancy_snail_shell_brick_stairs"));
		FANCY_SNAIL_SHELL_BRICK_SLAB.register(Archeon.createId("fancy_snail_shell_brick_slab"));
		FANCY_SNAIL_SHELL_BRICK_WALL.register(Archeon.createId("fancy_snail_shell_brick_wall"));
		PEAKS_SNOW.register(Archeon.createId("peaks_snow"));
		PEAKS_SNOW_BLOCK.register(Archeon.createId("peaks_snow_block"));
		DARK_GREEN_TILES.register(Archeon.createId("dark_green_tiles"));
		DARK_GREEN_TILE_STAIRS.register(Archeon.createId("dark_green_tile_stairs"));
		DARK_GREEN_TILE_SLAB.register(Archeon.createId("dark_green_tile_slab"));
		DARK_GREEN_TILE_WALL.register(Archeon.createId("dark_green_tile_wall"));
		GREEN_TILES.register(Archeon.createId("green_tiles"));
		GREEN_TILE_STAIRS.register(Archeon.createId("green_tile_stairs"));
		GREEN_TILE_SLAB.register(Archeon.createId("green_tile_slab"));
		GREEN_TILE_WALL.register(Archeon.createId("green_tile_wall"));
		LIME_TILES.register(Archeon.createId("lime_tiles"));
		LIME_TILE_STAIRS.register(Archeon.createId("lime_tile_stairs"));
		LIME_TILE_SLAB.register(Archeon.createId("lime_tile_slab"));
		LIME_TILE_WALL.register(Archeon.createId("lime_tile_wall"));
		TURQUOISE_TILES.register(Archeon.createId("turquoise_tiles"));
		TURQUOISE_TILE_STAIRS.register(Archeon.createId("turquoise_tile_stairs"));
		TURQUOISE_TILE_SLAB.register(Archeon.createId("turquoise_tile_slab"));
		TURQUOISE_TILE_WALL.register(Archeon.createId("turquoise_tile_wall"));
		LIGHT_BLUE_TILES.register(Archeon.createId("light_blue_tiles"));
		LIGHT_BLUE_TILE_STAIRS.register(Archeon.createId("light_blue_tile_stairs"));
		LIGHT_BLUE_TILE_SLAB.register(Archeon.createId("light_blue_tile_slab"));
		LIGHT_BLUE_TILE_WALL.register(Archeon.createId("light_blue_tile_wall"));
		BLUE_TILES.register(Archeon.createId("blue_tiles"));
		BLUE_TILE_STAIRS.register(Archeon.createId("blue_tile_stairs"));
		BLUE_TILE_SLAB.register(Archeon.createId("blue_tile_slab"));
		BLUE_TILE_WALL.register(Archeon.createId("blue_tile_wall"));
		DARK_BLUE_TILES.register(Archeon.createId("dark_blue_tiles"));
		DARK_BLUE_TILE_STAIRS.register(Archeon.createId("dark_blue_tile_stairs"));
		DARK_BLUE_TILE_SLAB.register(Archeon.createId("dark_blue_tile_slab"));
		DARK_BLUE_TILE_WALL.register(Archeon.createId("dark_blue_tile_wall"));
		PURPLE_TILES.register(Archeon.createId("purple_tiles"));
		PURPLE_TILE_STAIRS.register(Archeon.createId("purple_tile_stairs"));
		PURPLE_TILE_SLAB.register(Archeon.createId("purple_tile_slab"));
		PURPLE_TILE_WALL.register(Archeon.createId("purple_tile_wall"));
		PINK_TILES.register(Archeon.createId("pink_tiles"));
		PINK_TILE_STAIRS.register(Archeon.createId("pink_tile_stairs"));
		PINK_TILE_SLAB.register(Archeon.createId("pink_tile_slab"));
		PINK_TILE_WALL.register(Archeon.createId("pink_tile_wall"));
		RED_TILES.register(Archeon.createId("red_tiles"));
		RED_TILE_STAIRS.register(Archeon.createId("red_tile_stairs"));
		RED_TILE_SLAB.register(Archeon.createId("red_tile_slab"));
		RED_TILE_WALL.register(Archeon.createId("red_tile_wall"));
		BLACK_TILES.register(Archeon.createId("black_tiles"));
		BLACK_TILE_STAIRS.register(Archeon.createId("black_tile_stairs"));
		BLACK_TILE_SLAB.register(Archeon.createId("black_tile_slab"));
		BLACK_TILE_WALL.register(Archeon.createId("black_tile_wall"));
		CERAMIC_TILES.register(Archeon.createId("ceramic_tiles"));
		CERAMIC_TILE_STAIRS.register(Archeon.createId("ceramic_tile_stairs"));
		CERAMIC_TILE_SLAB.register(Archeon.createId("ceramic_tile_slab"));
		CERAMIC_TILE_WALL.register(Archeon.createId("ceramic_tile_wall"));
		OCHRE_TILES.register(Archeon.createId("ochre_tiles"));
		OCHRE_TILE_STAIRS.register(Archeon.createId("ochre_tile_stairs"));
		OCHRE_TILE_SLAB.register(Archeon.createId("ochre_tile_slab"));
		OCHRE_TILE_WALL.register(Archeon.createId("ochre_tile_wall"));
		DUNE_SAND_CASTLE.register(Archeon.createId("dune_sand_castle"));
		URN.register(Archeon.createId("urn"));
		HEART_OF_NATURE_TROPHY.register(Archeon.createId("heart_of_nature_trophy"));
	}
}
