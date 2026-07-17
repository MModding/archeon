package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.block.*;
import com.mmodding.archeon.block.sapling.*;
import com.mmodding.archeon.bootstrap.init.ArcheonCauldronBehaviors;
import com.mmodding.library.block.api.BlockWithItem;
import com.mmodding.library.block.api.catalog.*;
import com.mmodding.library.block.api.catalog.transparent.TransparentSlabBlock;
import com.mmodding.library.block.api.catalog.transparent.TransparentStairsBlock;
import com.mmodding.library.block.api.catalog.transparent.TransparentWallBlock;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;

import java.util.Map;

public class ArcheonBlocks {

	public static final FluidBlock HOT_SPRING_WATER = new FluidBlock(ArcheonFluids.HOT_SPRING_WATER, FabricBlockSettings.copyOf(Blocks.WATER).mapColor(DyeColor.LIGHT_BLUE));
	public static final FluidBlock DASCIUM = new FluidBlock(ArcheonFluids.DASCIUM, FabricBlockSettings.copyOf(Blocks.WATER).mapColor(DyeColor.YELLOW));

	public static final AdvancedCauldronBlock HOT_SPRING_WATER_CAULDRON = new AdvancedCauldronBlock(
		FabricBlockSettings.copyOf(Blocks.CAULDRON),
		null,
		Map.of(
			ArcheonItems.WOODEN_HOT_SPRING_WATER_BUCKET,
			(state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, )
		)
	).withItem();

	public static final AdvancedCauldronBlock DASCIUM_CAULDRON = new AdvancedCauldronBlock(
		FabricBlockSettings.copyOf(Blocks.CAULDRON),
		null,
		ArcheonCauldronBehaviors.DASCIUM_BEHAVIOR
	).withItem();

	public static final SimpleFlowerBlock SUNSET_ORCHID = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.RESISTANCE,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock ROSEYPIA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.UNLUCK,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock AEROLIA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.REGENERATION,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)).withItem();

	public static final SimpleFlowerBlock ASTEDIBES = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.WATER_BREATHING,
		30,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock TWILIGHT_ROSE = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.REGENERATION,
		60,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock PINK_LYCORIS = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.NAUSEA,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock RED_LYCORIS = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.SPEED,
		30,
		FabricBlockSettings.copyOf(Blocks.POPPY)).withItem();

	public static final SimpleFlowerBlock ORANGE_LYCORIS = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.STRENGTH,
		20,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleTallFlowerBlock ASCENDIA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)
 ).withItem();

	public static final SimpleFlowerBlock OEA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.NIGHT_VISION,
		30,
		FabricBlockSettings.copyOf(Blocks.POPPY)
 ).withItem();

	public static final SimpleFlowerBlock IOPEA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.DOLPHINS_GRACE,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleTallFlowerBlock TALL_IOPEA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)).withItem();

	public static final SimpleFlowerBlock ORGANDEANE_BLOSSOM = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.JUMP_BOOST,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)).withItem();

	public static final SimpleTallFlowerBlock TALL_ORGANDEANE = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock SEPTICEOLIA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.DARKNESS,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock DOTTED_STOVIA = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.INSTANT_HEALTH,
		0,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock WILLS_OF_LIGHT = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.ABSORPTION,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleFlowerBlock ETERNAL_FORTUNES = new SimpleFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		StatusEffects.LUCK,
		10,
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimpleTallFlowerBlock BLUE_DOELDIA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.ACHREAN_CAVES_PLACEABLE),
		FabricBlockSettings.copyOf(Blocks.POPPY).luminance(9)
	).withItem();

	public static final SimpleTallFlowerBlock WHITE_DOELDIA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.ACHREAN_CAVES_PLACEABLE),
		FabricBlockSettings.copyOf(Blocks.POPPY).luminance(9)
	).withItem();

	public static final SimpleTallFlowerBlock PINK_DOELDIA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.ACHREAN_CAVES_PLACEABLE),
		FabricBlockSettings.copyOf(Blocks.POPPY).luminance(9)
	).withItem();

	public static final SimpleTallFlowerBlock YELLOW_DOELDIA = new SimpleTallFlowerBlock(
		floor -> floor.isIn(ArcheonBlockTags.ACHREAN_CAVES_PLACEABLE),
		FabricBlockSettings.copyOf(Blocks.POPPY).luminance(9)
	).withItem();

	public static final SimpleLilyPadBlock SMALL_HOT_SPRING_LILY_PAD = new SimpleLilyPadBlock(
		(fluid, floor) -> fluid.isOf(ArcheonFluids.HOT_SPRING_WATER) || fluid.isOf(Fluids.WATER) || floor.isIn(BlockTags.ICE),
		FabricBlockSettings.copyOf(Blocks.POPPY).collidable(true)
	).withItem(new FabricItemSettings(), PlaceableOnWaterItem::new);

	public static final SimpleLilyPadBlock HOT_SPRING_LILY_PAD = new SimpleLilyPadBlock(
		(fluid, floor) -> fluid.isOf(ArcheonFluids.HOT_SPRING_WATER) || fluid.isOf(Fluids.WATER) || floor.isIn(BlockTags.ICE),
		FabricBlockSettings.copyOf(Blocks.POPPY).collidable(true)
	).withItem(new FabricItemSettings(), PlaceableOnWaterItem::new);

	public static final GiantLilyBlock GIANT_LILY = new GiantLilyBlock(
		FabricBlockSettings.copyOf(Blocks.POPPY).collidable(true)
	).withItem(new FabricItemSettings(), PlaceableOnWaterItem::new);

	public static final GrowsDownPlantBlock ACHREAN_VINES = new AchreanVinesBlock(
		FabricBlockSettings.copyOf(Blocks.POPPY)
			.luminance(state -> state.get(AchreanVinesBlock.NEAVE_BERRIES) && state.get(AchreanVinesBlock.DONE) ? 14 : 0)
			.sounds(BlockSoundGroup.CAVE_VINES),
		false,
		0.1f,
		1,
		BlockState::isAir
	).configureHead(BlockWithItem::withItem);

	public static final SimpleFernBlock WET_GRASS = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XYZ)
	).withItem();

	public static final SimpleTallPlantBlock TALL_WET_GRASS = new SimpleTallPlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XZ)
	).withItem();

	public static final SimpleFernBlock FLOWERED_WET_GRASS = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XYZ)
	).withItem();

	public static final SimpleTallPlantBlock FLOWERED_TALL_WET_GRASS = new SimpleTallPlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XZ)
	).withItem();

	public static final SimpleFernBlock WET_FERN = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XYZ)
	).withItem();

	public static final SimpleTallPlantBlock TALL_WET_FERN = new SimpleTallPlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XZ)
	).withItem();

	public static final SimpleFernBlock WET_GRASS_TUFFET = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isIn(ArcheonBlockTags.STONE) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XZ)
	).withItem();

	public static final SimpleFernBlock DEAD_WET_GRASS_TUFFET = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isIn(ArcheonBlockTags.STONE) || floor.isOf(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GRASS).offset(AbstractBlock.OffsetType.XZ)
	).withItem();

	public static final SimpleFernBlock SNOWY_GRASS_TUFFET = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isIn(ArcheonBlockTags.STONE) || floor.isOf(ArcheonBlocks.PEAKS_SNOW_BLOCK),
		FabricBlockSettings.copyOf(Blocks.GLASS).noCollision().breakInstantly().offset(AbstractBlock.OffsetType.NONE).nonOpaque()).withItem();

	public static final SouthWheatBlock SOUTH_WHEAT = new SouthWheatBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.GRASS)
	).withItem();

	public static final SimpleFernBlock BUSH = new SimpleFernBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final ToBushBlock VINE = new ToBushBlock(
		() -> ArcheonItems.GRAPE,
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final ToBushBlock BLOOD_ORANGE_BUSH = new ToBushBlock(
		() -> ArcheonItems.BLOOD_ORANGE,
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final XetulianSugarCaneBlock XETULIAN_SUGAR_CANE = new XetulianSugarCaneBlock(
		floor -> floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.DUNE_SAND) || floor.isOf(ArcheonBlocks.SALT_BLOCK),
		(state, fluid) -> fluid.isOf(Fluids.WATER),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SporeRootcapBlock SPORE_ROOTCAP = new SporeRootcapBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES), true, new AdvancedItemSettings().food(1, 0.1f, false, true, true)).withItem();

	public static final SimplePlantBlock GLOWSPROUTS = new SimplePlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.STONE) || floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final SimplePlantBlock GLOWSHROOMS = new SimplePlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.STONE) || floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.POPPY).luminance(14)
	).withItem();

	public static final SimplePlantBlock GLOWSHROOM_PARASITES = new SimplePlantBlock(
		floor -> floor.isIn(ArcheonBlockTags.STONE) || floor.isIn(ArcheonBlockTags.SOIL) || floor.isOf(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
		FabricBlockSettings.copyOf(Blocks.POPPY)
	).withItem();

	public static final LayeredBlock GLOWSHROOM_MOSS = new LayeredBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final Block GLOWSHROOM_MOSS_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();

	public static final PeaksSnowyBlock WET_GRASS_BLOCK = new PeaksSnowyBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)).withItem();
	public static final Block WET_DIRT = new Block(FabricBlockSettings.copyOf(Blocks.DIRT)).withItem();

	public static final LayeredBlock ACHREAN_MOSS = new LayeredBlock(FabricBlockSettings.copyOf(Blocks.MOSS_CARPET).sounds(BlockSoundGroup.MOSS_BLOCK)).withItem();
	public static final Block ACHREAN_MOSS_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).sounds(BlockSoundGroup.MOSS_BLOCK)).withItem();

	public static final FallingBlock DUNE_SAND = new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)).withItem();
	public static final FallingBlock SHELLSAND = new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)).withItem();
	public static final FallingBlock SALT_BLOCK = new FallingBlock(FabricBlockSettings.copyOf(Blocks.CLAY)).withItem();
	public static final FallingBlock DUST = new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).sounds(BlockSoundGroup.GRAVEL)).withItem();
	public static final GoldenClayBlock GOLDEN_CLAY = new GoldenClayBlock(FabricBlockSettings.copyOf(Blocks.CLAY)).withItem();

	public static final PillarBlock PALM_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock PALM_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final BlockRelatives PALM = BlockRelatives.createWood(Archeon.createId("palm"), ArcheonWoodSets.PALM, settings -> settings.mapColor(MapColor.PALE_YELLOW));

	public static final PillarBlock NECLANE_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock NECLANE_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final BlockRelatives NECLANE = BlockRelatives.createWood(Archeon.createId("neclane"), ArcheonWoodSets.NECLANE, settings -> settings.mapColor(MapColor.ORANGE));

	public static final PillarBlock CYPRESS_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock CYPRESS_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final HollowCypressLogBlock HOLLOW_CYPRESS_LOG = new HollowCypressLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).nonOpaque()).withItem();
	public static final BlockRelatives CYPRESS = BlockRelatives.createWood(Archeon.createId("cypress"), ArcheonWoodSets.CYPRESS, settings -> settings);

	public static final PillarBlock VUXANCIA_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock VUXANCIA_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final BlockRelatives VUXANCIA = BlockRelatives.createWood(Archeon.createId("vuxancia"), ArcheonWoodSets.VUXANCIA, settings -> settings);

	public static final PillarBlock NUME_WILLOW_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock NUME_WILLOW_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final BlockRelatives NUME_WILLOW = BlockRelatives.createWood(Archeon.createId("nume_willow"), ArcheonWoodSets.NUME_WILLOW, settings -> settings);

	public static final PillarBlock NYRETH_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock NYRETH_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final BlockRelatives NYRETH = BlockRelatives.createWood(Archeon.createId("nyreth"), ArcheonWoodSets.NYRETH, settings -> settings);

	public static final PeaksSnowyBlock CHIASPEN = new PeaksSnowyBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock CHIASPEN_STAIRS = new StairsBlock(CHIASPEN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock CHIASPEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock CHIASPEN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock CHIASPEN_BRICK_STAIRS = new StairsBlock(CHIASPEN_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock CHIASPEN_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock CHIASPEN_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block COBBLED_CHIASPEN = new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final StairsBlock COBBLED_CHIASPEN_STAIRS = new StairsBlock(COBBLED_CHIASPEN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final SlabBlock COBBLED_CHIASPEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final WallBlock COBBLED_CHIASPEN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();

	public static final Block GILDED_COBBLED_CHIASPEN = new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final StairsBlock GILDED_COBBLED_CHIASPEN_STAIRS = new StairsBlock(GILDED_COBBLED_CHIASPEN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final SlabBlock GILDED_COBBLED_CHIASPEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final WallBlock GILDED_COBBLED_CHIASPEN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();

	public static final PillarBlock CHIASPEN_PILLAR_TOP = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final PillarBlock CHIASPEN_PILLAR = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final PillarBlock CHIASPEN_PILLAR_BOTTOM = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final ChiaspenColumnBlock CHIASPEN_COLUMN = new ChiaspenColumnBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block SMOOTH_CHIASPEN = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock SMOOTH_CHIASPEN_STAIRS = new StairsBlock(SMOOTH_CHIASPEN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock SMOOTH_CHIASPEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CHISELED_CHIASPEN = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CRACKED_CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final PressurePlateBlock CHIASPEN_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final ButtonBlock CHIASPEN_BUTTON = new ButtonBlock.Stone(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block MOSSY_CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock MOSSY_CHIASPEN_BRICK_STAIRS = new StairsBlock(MOSSY_CHIASPEN_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock MOSSY_CHIASPEN_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock MOSSY_CHIASPEN_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block MOSSY_COBBLED_CHIASPEN = new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final StairsBlock MOSSY_COBBLED_CHIASPEN_STAIRS = new StairsBlock(MOSSY_COBBLED_CHIASPEN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final SlabBlock MOSSY_COBBLED_CHIASPEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();
	public static final WallBlock MOSSY_COBBLED_CHIASPEN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).hardness(2.0f)).withItem();

	public static final Block FALSE_CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block FALSE_CRACKED_CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block FALSE_MOSSY_CHIASPEN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block PHOSNOR_SLATE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final StairsBlock PHOSNOR_SLATE_STAIRS = new StairsBlock(PHOSNOR_SLATE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final SlabBlock PHOSNOR_SLATE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final WallBlock PHOSNOR_SLATE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block PHOSNOR_SLATE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final StairsBlock PHOSNOR_SLATE_BRICK_STAIRS = new StairsBlock(PHOSNOR_SLATE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final SlabBlock PHOSNOR_SLATE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final WallBlock PHOSNOR_SLATE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block PHOSNOR_SLATE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final StairsBlock PHOSNOR_SLATE_TILE_STAIRS = new StairsBlock(PHOSNOR_SLATE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final SlabBlock PHOSNOR_SLATE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final WallBlock PHOSNOR_SLATE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block COBBLED_PHOSNOR_SLATE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final StairsBlock COBBLED_PHOSNOR_SLATE_STAIRS = new StairsBlock(COBBLED_PHOSNOR_SLATE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final SlabBlock COBBLED_PHOSNOR_SLATE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final WallBlock COBBLED_PHOSNOR_SLATE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block POLISHED_PHOSNOR_SLATE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final StairsBlock POLISHED_PHOSNOR_SLATE_STAIRS = new StairsBlock(POLISHED_PHOSNOR_SLATE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final SlabBlock POLISHED_PHOSNOR_SLATE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final WallBlock POLISHED_PHOSNOR_SLATE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block CHISELED_PHOSNOR_SLATE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final TorchBlock EXYRIANE_TORCH = new TorchBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).collidable(false).breakInstantly().luminance(14), ArcheonParticleTypes.EXYRIANE_FLAME).withItem();
	public static final WallTorchBlock WALL_EXYRIANE_TORCH = new WallTorchBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).collidable(false).breakInstantly().luminance(14), ArcheonParticleTypes.EXYRIANE_FLAME).withItem();
	public static final ExyrianeLanternBlock EXYRIANE_LANTERN = new ExyrianeLanternBlock(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15)).withItem();

	public static final FurnaceBlock CHIASPEN_FURNACE = new FurnaceBlock(FabricBlockSettings.copyOf(Blocks.STONE).luminance(state -> state.get(Properties.LIT) ? 13 : 0)).withItem();
	public static final FurnaceBlock PHOSNOR_SLATE_FURNACE = new FurnaceBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).luminance(state -> state.get(Properties.LIT) ? 13 : 0)).withItem();

	public static final Block APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block FAELITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block LUSONYTH_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block SLIGHTLY_CONDENSED_APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block SLIGHTLY_CONDENSED_EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CONDENSED_APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CONDENSED_EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block PHOSNOR_SLATE_APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final Block PHOSNOR_SLATE_EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final Block PHOSNOR_SLATE_FAELITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final Block PHOSNOR_SLATE_LUSONYTH_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block SLIGHTLY_CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final Block SLIGHTLY_CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();
	public static final Block CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)).withItem();

	public static final Block APAFLORITE_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();
	public static final Block EXYRIANE_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0f)).withItem();
	public static final Block FAELITE_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();
	public static final Block LUSONYTH_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();
	public static final Block CLEMENTIUM_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();

	public static final Block AKETITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.TUFF)).withItem();
	public static final StairsBlock AKETITE_STAIRS = new StairsBlock(AKETITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.TUFF)).withItem();
	public static final SlabBlock AKETITE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.TUFF)).withItem();
	public static final WallBlock AKETITE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.TUFF)).withItem();

	public static final Block AKETITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock AKETITE_BRICK_STAIRS = new StairsBlock(AKETITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock AKETITE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock AKETITE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block AKETITE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock AKETITE_TILE_STAIRS = new StairsBlock(AKETITE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock AKETITE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock AKETITE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ORNATE_CHISELED_AKETITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block ORNATE_AKETITE_BRICKS_TEARS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block ORNATE_AKETITE_BRICKS_LINES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block SMOOTH_AKETITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CHISELED_AKETITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CRACKED_AKETITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block AKETITE_BASEBOARD = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block INNERMOST_ROCK = new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)).withItem();

	public static final Block MYSTERIOUS_STONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock MYSTERIOUS_STONE_STAIRS = new StairsBlock(MYSTERIOUS_STONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock MYSTERIOUS_STONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final SquaredPortalBlock ARCHEON_PORTAL = new SquaredPortalBlock(ParticleTypes.ENCHANT, FabricBlockSettings.of(Material.PORTAL).noCollision().strength(-1.0F).luminance(11).sounds(BlockSoundGroup.GLASS)).withItem();

	public static final Block ARTEMNITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHERRACK)).withItem();
	public static final StairsBlock ARTEMNITE_STAIRS = new StairsBlock(ARTEMNITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHERRACK)).withItem();
	public static final SlabBlock ARTEMNITE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHERRACK)).withItem();
	public static final WallBlock ARTEMNITE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHERRACK)).withItem();

	public static final Block ARTEMNITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock ARTEMNITE_BRICK_STAIRS = new StairsBlock(ARTEMNITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock ARTEMNITE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock ARTEMNITE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ARTEMNITE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock ARTEMNITE_TILE_STAIRS = new StairsBlock(ARTEMNITE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock ARTEMNITE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock ARTEMNITE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block MOSSY_ARTEMNITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock MOSSY_ARTEMNITE_BRICK_STAIRS = new StairsBlock(MOSSY_ARTEMNITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock MOSSY_ARTEMNITE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock MOSSY_ARTEMNITE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block FANCY_CHISELED_ARTEMNITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block FANCY_ARTEMNITE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock FANCY_ARTEMNITE_TILE_STAIRS = new StairsBlock(FANCY_ARTEMNITE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock FANCY_ARTEMNITE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock FANCY_ARTEMNITE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ORNATE_ARTEMNITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block ORNATE_ARTEMNITE_BRICKS_TEARS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block ORNATE_ARTEMNITE_BRICKS_LINES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block SMOOTH_ARTEMNITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CHISELED_ARTEMNITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CRACKED_ARTEMNITE_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ARTEMNITE_BASEBOARD = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CHIASPEN_LAMP = new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15)).withItem();
	public static final Block AKETITE_LAMP = new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15)).withItem();

	public static final PaneBlock CLEMENTIUM_BARS = new PaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();
	public static final ChainBlock CLEMENTIUM_CHAIN = new ChainBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)).withItem();

	public static final CentaurLifeVaultBlock CENTAUR_LIFE_VAULT = new CentaurLifeVaultBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque().strength(-1, 3600000.0f)).withItem();

	public static final PowerKeystoneBlock POWER_KEYSTONE = new PowerKeystoneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(-1, 3600000.0f)).withItem();
	public static final NaturiteBlock NATURITE = new NaturiteBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)).withItem();

	public static final PillarBlock STRIPPED_PALM_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_PALM_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final PillarBlock STRIPPED_NECLANE_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_NECLANE_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final PillarBlock STRIPPED_CYPRESS_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_CYPRESS_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final PillarBlock STRIPPED_VUXANCIA_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_VUXANCIA_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final PillarBlock STRIPPED_NUME_WILLOW_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_NUME_WILLOW_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final PillarBlock STRIPPED_NYRETH_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final PillarBlock STRIPPED_NYRETH_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final BushLeavesBlock BUSH_LEAVES = new BushLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).innerVelocityMultiplier(0.5f)).withItem();
	public static final LeavesBlock PALM_LEAVES = new PalmLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final LeavesBlock NECLANE_LEAVES = new NeclaneLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final LeavesBlock FLOWERED_NECLANE_LEAVES = new NeclaneLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final LeavesBlock CYPRESS_LEAVES = new CypressLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();

	public static final VuxanciaLeavesBlock PNEVENTIAL_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final VuxanciaLeavesBlock STREIAN_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final VuxanciaLeavesBlock ORIAN_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final VuxanciaLeavesBlock VALE_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final VuxanciaLeavesBlock ZIAL_VUXANCIA_LEAVES = new VuxanciaLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();

	public static final LeavesBlock NUME_WILLOW_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final LeavesBlock NYRETH_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();
	public static final LeavesBlock PALE_NYRETH_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)).withItem();

	public static final GrowsDownPlantBlock HANGING_PNEVENTIAL_VUXANCIA_LEAVES = new GrowsDownPlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY),
		false, 0.005f, 1, BlockState::isAir).configureHead(GrowsDownPlantBlock.Head::withItem);
	public static final GrowsDownPlantBlock HANGING_STREIAN_VUXANCIA_LEAVES = new GrowsDownPlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY),
		false, 0.005f, 1, BlockState::isAir).configureHead(GrowsDownPlantBlock.Head::withItem);
	public static final GrowsDownPlantBlock HANGING_ORIAN_VUXANCIA_LEAVES = new GrowsDownPlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY),
		false, 0.005f, 1, BlockState::isAir).configureHead(GrowsDownPlantBlock.Head::withItem);
	public static final GrowsDownPlantBlock HANGING_VALE_VUXANCIA_LEAVES = new GrowsDownPlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY),
		false, 0.005f, 1, BlockState::isAir).configureHead(GrowsDownPlantBlock.Head::withItem);
	public static final GrowsDownPlantBlock HANGING_ZIAL_VUXANCIA_LEAVES = new GrowsDownPlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY),
		false, 0.005f, 1, BlockState::isAir).configureHead(GrowsDownPlantBlock.Head::withItem);

	public static final FabricBlockSettings LEAVES_CARPET = FabricBlockSettings.copyOf(Blocks.GRASS).strength(0.2f);

	public static final LeavesCarpetBlock ORIAN_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET).withItem();
	public static final LeavesCarpetBlock PNEVENTIAL_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET).withItem();
	public static final LeavesCarpetBlock STREIAN_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET).withItem();
	public static final LeavesCarpetBlock VALE_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET).withItem();
	public static final LeavesCarpetBlock ZIAL_VUXANCIA_LEAVES_CARPET = new LeavesCarpetBlock(ArcheonBlocks.LEAVES_CARPET).withItem();

	public static final CraftingTableBlock PALM_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final CraftingTableBlock NECLANE_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final CraftingTableBlock CYPRESS_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final CraftingTableBlock VUXANCIA_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final CraftingTableBlock NUME_WILLOW_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();
	public static final CraftingTableBlock NYRETH_CRAFTING_TABLE = new CraftingTableBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)).withItem();

	public static final Block PALM_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();
	public static final Block NECLANE_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();
	public static final Block CYPRESS_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();
	public static final Block VUXANCIA_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();
	public static final Block NUME_WILLOW_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();
	public static final Block NYRETH_BOOKSHELF = new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)).withItem();

	public static final SimpleSaplingBlock PALM_SAPLING = new SimpleSaplingBlock(
		new PalmSaplingGenerator(),
		floor -> floor.isOf(ArcheonBlocks.DUNE_SAND),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock NECLANE_SAPLING = new SimpleSaplingBlock(
		new NeclaneSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock CYPRESS_SAPLING = new SimpleSaplingBlock(
		new CypressSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock PNEVENTIAL_VUXANCIA_SAPLING = new SimpleSaplingBlock(
		new PneventialVuxanciaSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock STREIAN_VUXANCIA_SAPLING = new SimpleSaplingBlock(
		new StreianVuxanciaSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock ORIAN_VUXANCIA_SAPLING = new SimpleSaplingBlock(
		new OrianVuxanciaSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock VALE_VUXANCIA_SAPLING = new SimpleSaplingBlock(
		new ValeVuxanciaSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final SimpleSaplingBlock ZIAL_VUXANCIA_SAPLING = new SimpleSaplingBlock(
		new ZialVuxanciaSaplingGenerator(),
		floor -> floor.isIn(ArcheonBlockTags.SOIL),
		FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
	).withItem();

	public static final PillarBlock CERAMIC_BLOCK = new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final StairsBlock CERAMIC_STAIRS = new StairsBlock(CERAMIC_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final SlabBlock CERAMIC_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();

	public static final PillarBlock CERAMIC_BRICKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final StairsBlock CERAMIC_BRICK_STAIRS = new StairsBlock(CERAMIC_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final SlabBlock CERAMIC_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final WallBlock CERAMIC_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();

	public static final FenceBlock CERAMIC_FENCE = new FenceBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)).withItem();
	public static final PressurePlateBlock CERAMIC_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.BONE_BLOCK), ArcheonBlockSetTypes.CERAMIC).withItem();
	public static final ButtonBlock CERAMIC_BUTTON = new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.BONE), ArcheonBlockSetTypes.CERAMIC, 20, false).withItem();

	public static final Block SHORESTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock SHORESTONE_STAIRS = new StairsBlock(SHORESTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock SHORESTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock SHORESTONE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final AdvancedPointedDripstoneBlock POINTED_CRIADAN = new AdvancedPointedDripstoneBlock(() -> ArcheonBlocks.CRIADAN, FabricBlockSettings.copyOf(Blocks.BASALT).dynamicBounds().offset(AbstractBlock.OffsetType.XZ)).withItem();

	public static final Block CRIADAN = new Block(FabricBlockSettings.copyOf(Blocks.BASALT)).withItem();
	public static final StairsBlock CRIADAN_STAIRS = new StairsBlock(CRIADAN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BASALT)).withItem();
	public static final SlabBlock CRIADAN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.BASALT)).withItem();
	public static final WallBlock CRIADAN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BASALT)).withItem();
	public static final PressurePlateBlock CRIADAN_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.BASALT)).withItem();

	public static final Block CRIADAN_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock CRIADAN_BRICK_STAIRS = new StairsBlock(CRIADAN_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock CRIADAN_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock CRIADAN_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final PressurePlateBlock CRIADAN_BRICK_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CRIADAN_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock CRIADAN_TILE_STAIRS = new StairsBlock(CRIADAN_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock CRIADAN_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock CRIADAN_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final PressurePlateBlock CRIADAN_TILE_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block POLISHED_CRIADAN = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock POLISHED_CRIADAN_STAIRS = new StairsBlock(POLISHED_CRIADAN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock POLISHED_CRIADAN_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock POLISHED_CRIADAN_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final PressurePlateBlock POLISHED_CRIADAN_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final PillarBlock CRIADAN_PILLAR = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final Block CHISELED_CRIADAN = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ROUGHCAST = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock ROUGHCAST_STAIRS = new StairsBlock(ROUGHCAST.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock ROUGHCAST_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock ROUGHCAST_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final PointedDripstoneBlock POINTED_ANHYDRITE = new PointedDripstoneBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
			.dynamicBounds()
			.offset(AbstractBlock.OffsetType.XZ)
		).withItem();

	public static final Block ANHYDRITE = new TransparentBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final StairsBlock ANHYDRITE_STAIRS = new TransparentStairsBlock(
		ANHYDRITE.getDefaultState(),
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final SlabBlock ANHYDRITE_SLAB = new TransparentSlabBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final WallBlock ANHYDRITE_WALL = new TransparentWallBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final PressurePlateBlock ANHYDRITE_PRESSURE_PLATE = new PressurePlateBlock(
		ActivationRule.MOBS,
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always),
		null
	).withItem();

	public static final FenceBlock ANHYDRITE_FENCE = new FenceBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final Block ANHYDRITE_BRICKS = new TransparentBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final StairsBlock ANHYDRITE_BRICK_STAIRS = new TransparentStairsBlock(
		ANHYDRITE_BRICKS.getDefaultState(),
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final SlabBlock ANHYDRITE_BRICK_SLAB = new TransparentSlabBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final WallBlock ANHYDRITE_BRICK_WALL = new TransparentWallBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final PressurePlateBlock ANHYDRITE_BRICK_PRESSURE_PLATE = new PressurePlateBlock(
		ActivationRule.MOBS,
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always),
		null
	).withItem();

	public static final Block ANHYDRITE_TILES = new TransparentBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final StairsBlock ANHYDRITE_TILE_STAIRS = new TransparentStairsBlock(
		ANHYDRITE_TILES.getDefaultState(),
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final SlabBlock ANHYDRITE_TILE_SLAB = new TransparentSlabBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final WallBlock ANHYDRITE_TILE_WALL = new TransparentWallBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final PressurePlateBlock ANHYDRITE_TILE_PRESSURE_PLATE = new PressurePlateBlock(
		ActivationRule.MOBS,
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always),
		null
	).withItem();

	public static final Block POLISHED_ANHYDRITE = new TransparentBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final StairsBlock POLISHED_ANHYDRITE_STAIRS = new TransparentStairsBlock(
		POLISHED_ANHYDRITE.getDefaultState(),
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final SlabBlock POLISHED_ANHYDRITE_SLAB = new TransparentSlabBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final WallBlock POLISHED_ANHYDRITE_WALL = new TransparentWallBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final PressurePlateBlock POLISHED_ANHYDRITE_PRESSURE_PLATE = new PressurePlateBlock(
		ActivationRule.MOBS,
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always),
		null
	).withItem();

	public static final PillarBlock ANHYDRITE_PILLAR = new PillarBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final Block CHISELED_ANHYDRITE = new TransparentBlock(
		FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
			.nonOpaque()
			.blockVision(Blocks::never)
			.luminance(3)
			.emissiveLighting(Blocks::always)
	).withItem();

	public static final Block DUNE_SAND_GLASS = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final Block DUNE_SAND_GLASS_TILES = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final Block DUNE_SAND_GLASS_TILES_TOP_LEFT = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final Block DUNE_SAND_GLASS_TILES_TOP_RIGHT = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final Block DUNE_SAND_GLASS_TILES_BOTTOM_LEFT = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final Block DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT = new Block(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();

	public static final PaneBlock DUNE_SAND_GLASS_PANE = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final PaneBlock DUNE_SAND_GLASS_PANE_TILES = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final PaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final PaneBlock DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final PaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();
	public static final PaneBlock DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT = new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS)).withItem();

	public static final Block ANTIC_MOSAIC = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock ANTIC_MOSAIC_STAIRS = new StairsBlock(ANTIC_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock ANTIC_MOSAIC_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock ANTIC_MOSAIC_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block ANTIC_FLOORTILE = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock ANTIC_FLOORTILE_STAIRS = new StairsBlock(ANTIC_FLOORTILE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock ANTIC_FLOORTILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock ANTIC_FLOORTILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block SNAIL_SHELL_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock SNAIL_SHELL_BRICK_STAIRS = new StairsBlock(SNAIL_SHELL_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock SNAIL_SHELL_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock SNAIL_SHELL_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block FANCY_SNAIL_SHELL_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock FANCY_SNAIL_SHELL_BRICK_STAIRS = new StairsBlock(FANCY_SNAIL_SHELL_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock FANCY_SNAIL_SHELL_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock FANCY_SNAIL_SHELL_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final LayeredBlock PEAKS_SNOW = new LayeredBlock(FabricBlockSettings.copyOf(Blocks.SNOW)).withItem();
	public static final Block PEAKS_SNOW_BLOCK = new Block(FabricBlockSettings.copy(Blocks.SNOW_BLOCK)).withItem();

	public static final Block DARK_GREEN_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock DARK_GREEN_TILE_STAIRS = new StairsBlock(DARK_GREEN_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock DARK_GREEN_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock DARK_GREEN_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block GREEN_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock GREEN_TILE_STAIRS = new StairsBlock(GREEN_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock GREEN_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock GREEN_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block LIME_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock LIME_TILE_STAIRS = new StairsBlock(LIME_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock LIME_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock LIME_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block TURQUOISE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock TURQUOISE_TILE_STAIRS = new StairsBlock(TURQUOISE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock TURQUOISE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock TURQUOISE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block LIGHT_BLUE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock LIGHT_BLUE_TILE_STAIRS = new StairsBlock(LIGHT_BLUE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock LIGHT_BLUE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock LIGHT_BLUE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block BLUE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock BLUE_TILE_STAIRS = new StairsBlock(BLUE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock BLUE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock BLUE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block DARK_BLUE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock DARK_BLUE_TILE_STAIRS = new StairsBlock(DARK_BLUE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock DARK_BLUE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock DARK_BLUE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block PURPLE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock PURPLE_TILE_STAIRS = new StairsBlock(PURPLE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock PURPLE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock PURPLE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block PINK_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock PINK_TILE_STAIRS = new StairsBlock(PINK_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock PINK_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock PINK_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block RED_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock RED_TILE_STAIRS = new StairsBlock(RED_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock RED_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock RED_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block BLACK_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock BLACK_TILE_STAIRS = new StairsBlock(BLACK_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock BLACK_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock BLACK_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block CERAMIC_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock CERAMIC_TILE_STAIRS = new StairsBlock(CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock CERAMIC_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock CERAMIC_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final Block OCHRE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final StairsBlock OCHRE_TILE_STAIRS = new StairsBlock(OCHRE_TILES.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final SlabBlock OCHRE_TILE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();
	public static final WallBlock OCHRE_TILE_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)).withItem();

	public static final DuneSandCastleBlock DUNE_SAND_CASTLE = new DuneSandCastleBlock(FabricBlockSettings.copyOf(Blocks.SAND).nonOpaque().strength(0.7f, 0.0f)).withItem();
	public static final UrnBlock URN = new UrnBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).nonOpaque().strength(0.8f, 2.0f).breakInstantly()).withItem();
	public static final HeartOfNatureTrophyBlock HEART_OF_NATURE_TROPHY = new HeartOfNatureTrophyBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE).nonOpaque().strength(1.0f, 6.0f)).withItem(new FabricItemSettings().maxCount(1).fireproof());

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.BLOCK, factory -> {
			factory.register("hot_spring_water", HOT_SPRING_WATER);
			factory.register("dascium", DASCIUM);
			factory.register("hot_spring_water_cauldron", HOT_SPRING_WATER_CAULDRON);
			factory.register("dascium_cauldron", DASCIUM_CAULDRON);
			factory.register("sunset_orchid", SUNSET_ORCHID);
			factory.register("roseypia", ROSEYPIA);
			factory.register("aerolia", AEROLIA);
			factory.register("dotted_stovia", DOTTED_STOVIA);
			factory.register("wills_of_light", WILLS_OF_LIGHT);
			factory.register("eternal_fortunes", ETERNAL_FORTUNES);
			factory.register("astedibes", ASTEDIBES);
			factory.register("twilight_rose", TWILIGHT_ROSE);
			factory.register("pink_lycoris", PINK_LYCORIS);
			factory.register("red_lycoris", RED_LYCORIS);
			factory.register("orange_lycoris", ORANGE_LYCORIS);
			factory.register("ascendia", ASCENDIA);
			factory.register("oea", OEA);
			factory.register("iopea", IOPEA);
			factory.register("tall_iopea", TALL_IOPEA);
			factory.register("organdeane_blossom", ORGANDEANE_BLOSSOM);
			factory.register("tall_organdeane", TALL_ORGANDEANE);
			factory.register("septiceolia", SEPTICEOLIA);
			factory.register("blue_doeldia", BLUE_DOELDIA);
			factory.register("white_doeldia", WHITE_DOELDIA);
			factory.register("pink_doeldia", PINK_DOELDIA);
			factory.register("yellow_doeldia", YELLOW_DOELDIA);
			factory.register("small_hot_spring_lily_pad", SMALL_HOT_SPRING_LILY_PAD);
			factory.register("hot_spring_lily_pad", HOT_SPRING_LILY_PAD);
			factory.register("giant_lily", GIANT_LILY);
			ACHREAN_VINES.register(mod, "achrean_vines");
			factory.register("wet_grass", WET_GRASS);
			factory.register("tall_wet_grass", TALL_WET_GRASS);
			factory.register("flowered_wet_grass", FLOWERED_WET_GRASS);
			factory.register("flowered_tall_wet_grass", FLOWERED_TALL_WET_GRASS);
			factory.register("wet_fern", WET_FERN);
			factory.register("tall_wet_fern", TALL_WET_FERN);
			factory.register("wet_grass_tuffet", WET_GRASS_TUFFET);
			factory.register("dead_wet_grass_tuffet", DEAD_WET_GRASS_TUFFET);
			factory.register("snowy_grass_tuffet", SNOWY_GRASS_TUFFET);
			factory.register("south_wheat", SOUTH_WHEAT);
			factory.register("bush", BUSH);
			factory.register("vine", VINE);
			factory.register("blood_orange_bush", BLOOD_ORANGE_BUSH);
			factory.register("xetulian_sugar_cane", XETULIAN_SUGAR_CANE);
			factory.register("spore_rootcap", SPORE_ROOTCAP);
			factory.register("glowsprouts", GLOWSPROUTS);
			factory.register("glowshrooms", GLOWSHROOMS);
			factory.register("glowshroom_parasites", GLOWSHROOM_PARASITES);
			factory.register("glowshroom_moss", GLOWSHROOM_MOSS);
			factory.register("glowshroom_moss_block", GLOWSHROOM_MOSS_BLOCK);
			factory.register("wet_grass_block", WET_GRASS_BLOCK);
			factory.register("wet_dirt", WET_DIRT);
			factory.register("achrean_moss", ACHREAN_MOSS);
			factory.register("achrean_moss_block", ACHREAN_MOSS_BLOCK);
			factory.register("dune_sand", DUNE_SAND);
			factory.register("shellsand", SHELLSAND);
			factory.register("salt_block", SALT_BLOCK);
			factory.register("dust", DUST);
			factory.register("golden_clay", GOLDEN_CLAY);
			factory.register("palm_wood", PALM_WOOD);
			factory.register("palm_log", PALM_LOG);
			PALM.register();
			factory.register("neclane_wood", NECLANE_WOOD);
			factory.register("neclane_log", NECLANE_LOG);
			NECLANE.register();
			factory.register("cypress_wood", CYPRESS_WOOD);
			factory.register("cypress_log", CYPRESS_LOG);
			factory.register("hollow_cypress_log", HOLLOW_CYPRESS_LOG);
			CYPRESS.register();
			factory.register("vuxancia_wood", VUXANCIA_WOOD);
			factory.register("vuxancia_log", VUXANCIA_LOG);
			VUXANCIA.register();
			factory.register("nume_willow_wood", NUME_WILLOW_WOOD);
			factory.register("nume_willow_log", NUME_WILLOW_LOG);
			NUME_WILLOW.register();
			factory.register("nyreth_wood", NYRETH_WOOD);
			factory.register("nyreth_log", NYRETH_LOG);
			NYRETH.register();
			factory.register("chiaspen", CHIASPEN);
			factory.register("chiaspen_stairs", CHIASPEN_STAIRS);
			factory.register("chiaspen_slab", CHIASPEN_SLAB);
			factory.register("chiaspen_wall", CHIASPEN_WALL);
			factory.register("chiaspen_bricks", CHIASPEN_BRICKS);
			factory.register("chiaspen_brick_stairs", CHIASPEN_BRICK_STAIRS);
			factory.register("chiaspen_brick_slab", CHIASPEN_BRICK_SLAB);
			factory.register("chiaspen_brick_wall", CHIASPEN_BRICK_WALL);
			factory.register("cobbled_chiaspen", COBBLED_CHIASPEN);
			factory.register("cobbled_chiaspen_stairs", COBBLED_CHIASPEN_STAIRS);
			factory.register("cobbled_chiaspen_slab", COBBLED_CHIASPEN_SLAB);
			factory.register("cobbled_chiaspen_wall", COBBLED_CHIASPEN_WALL);
			factory.register("gilded_cobbled_chiaspen", GILDED_COBBLED_CHIASPEN);
			factory.register("gilded_cobbled_chiaspen_stairs", GILDED_COBBLED_CHIASPEN_STAIRS);
			factory.register("gilded_cobbled_chiaspen_slab", GILDED_COBBLED_CHIASPEN_SLAB);
			factory.register("gilded_cobbled_chiaspen_wall", GILDED_COBBLED_CHIASPEN_WALL);
			factory.register("chiaspen_pillar_top", CHIASPEN_PILLAR_TOP);
			factory.register("chiaspen_pillar", CHIASPEN_PILLAR);
			factory.register("chiaspen_pillar_bottom", CHIASPEN_PILLAR_BOTTOM);
			factory.register("chiaspen_column", CHIASPEN_COLUMN);
			factory.register("smooth_chiaspen", SMOOTH_CHIASPEN);
			factory.register("smooth_chiaspen_stairs", SMOOTH_CHIASPEN_STAIRS);
			factory.register("smooth_chiaspen_slab", SMOOTH_CHIASPEN_SLAB);
			factory.register("chiseled_chiaspen", CHISELED_CHIASPEN);
			factory.register("cracked_chiaspen_bricks", CRACKED_CHIASPEN_BRICKS);
			factory.register("chiaspen_pressure_plate", CHIASPEN_PRESSURE_PLATE);
			factory.register("chiaspen_button", CHIASPEN_BUTTON);
			factory.register("mossy_chiaspen_bricks", MOSSY_CHIASPEN_BRICKS);
			factory.register("mossy_chiaspen_brick_stairs", MOSSY_CHIASPEN_BRICK_STAIRS);
			factory.register("mossy_chiaspen_brick_slab", MOSSY_CHIASPEN_BRICK_SLAB);
			factory.register("mossy_chiaspen_brick_wall", MOSSY_CHIASPEN_BRICK_WALL);
			factory.register("mossy_cobbled_chiaspen", MOSSY_COBBLED_CHIASPEN);
			factory.register("mossy_cobbled_chiaspen_stairs", MOSSY_COBBLED_CHIASPEN_STAIRS);
			factory.register("mossy_cobbled_chiaspen_slab", MOSSY_COBBLED_CHIASPEN_SLAB);
			factory.register("mossy_cobbled_chiaspen_wall", MOSSY_COBBLED_CHIASPEN_WALL);
			factory.register("false_chiaspen_bricks", FALSE_CHIASPEN_BRICKS);
			factory.register("false_cracked_chiaspen_bricks", FALSE_CRACKED_CHIASPEN_BRICKS);
			factory.register("false_mossy_chiaspen_bricks", FALSE_MOSSY_CHIASPEN_BRICKS);
			factory.register("phosnor_slate", PHOSNOR_SLATE);
			factory.register("phosnor_slate_stairs", PHOSNOR_SLATE_STAIRS);
			factory.register("phosnor_slate_slab", PHOSNOR_SLATE_SLAB);
			factory.register("phosnor_slate_wall", PHOSNOR_SLATE_WALL);
			factory.register("phosnor_slate_bricks", PHOSNOR_SLATE_BRICKS);
			factory.register("phosnor_slate_brick_stairs", PHOSNOR_SLATE_BRICK_STAIRS);
			factory.register("phosnor_slate_brick_slab", PHOSNOR_SLATE_BRICK_SLAB);
			factory.register("phosnor_slate_brick_wall", PHOSNOR_SLATE_BRICK_WALL);
			factory.register("phosnor_slate_tiles", PHOSNOR_SLATE_TILES);
			factory.register("phosnor_slate_tile_stairs", PHOSNOR_SLATE_TILE_STAIRS);
			factory.register("phosnor_slate_tile_slab", PHOSNOR_SLATE_TILE_SLAB);
			factory.register("phosnor_slate_tile_wall", PHOSNOR_SLATE_TILE_WALL);
			factory.register("cobbled_phosnor_slate", COBBLED_PHOSNOR_SLATE);
			factory.register("cobbled_phosnor_slate_stairs", COBBLED_PHOSNOR_SLATE_STAIRS);
			factory.register("cobbled_phosnor_slate_slab", COBBLED_PHOSNOR_SLATE_SLAB);
			factory.register("cobbled_phosnor_slate_wall", COBBLED_PHOSNOR_SLATE_WALL);
			factory.register("polished_phosnor_slate", POLISHED_PHOSNOR_SLATE);
			factory.register("polished_phosnor_slate_stairs", POLISHED_PHOSNOR_SLATE_STAIRS);
			factory.register("polished_phosnor_slate_slab", POLISHED_PHOSNOR_SLATE_SLAB);
			factory.register("polished_phosnor_slate_wall", POLISHED_PHOSNOR_SLATE_WALL);
			factory.register("chiseled_phosnor_slate", CHISELED_PHOSNOR_SLATE);
			factory.register("exyriane_torch", EXYRIANE_TORCH);
			factory.register("wall_exyriane_torch", WALL_EXYRIANE_TORCH);
			factory.register("exyriane_lantern", EXYRIANE_LANTERN);
			factory.register("apaflorite_ore", APAFLORITE_ORE);
			factory.register("exyriane_ore", EXYRIANE_ORE);
			factory.register("faelite_ore", FAELITE_ORE);
			factory.register("lusonyth_ore", LUSONYTH_ORE);
			factory.register("slightly_condensed_apaflorite_ore", SLIGHTLY_CONDENSED_APAFLORITE_ORE);
			factory.register("slightly_condensed_exyriane_ore", SLIGHTLY_CONDENSED_EXYRIANE_ORE);
			factory.register("condensed_apaflorite_ore", CONDENSED_APAFLORITE_ORE);
			factory.register("condensed_exyriane_ore", CONDENSED_EXYRIANE_ORE);
			factory.register("phosnor_slate_apaflorite_ore", PHOSNOR_SLATE_APAFLORITE_ORE);
			factory.register("phosnor_slate_exyriane_ore", PHOSNOR_SLATE_EXYRIANE_ORE);
			factory.register("phosnor_slate_faelite_ore", PHOSNOR_SLATE_FAELITE_ORE);
			factory.register("phosnor_slate_lusonyth_ore", PHOSNOR_SLATE_LUSONYTH_ORE);
			factory.register("slightly_condensed_phosnor_slate_apaflorite_ore", SLIGHTLY_CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE);
			factory.register("slightly_condensed_phosnor_slate_exyriane_ore", SLIGHTLY_CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE);
			factory.register("condensed_phosnor_slate_apaflorite_ore", CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE);
			factory.register("condensed_phosnor_slate_exyriane_ore", CONDENSED_PHOSNOR_SLATE_EXYRIANE_ORE);
			factory.register("apaflorite_block", APAFLORITE_BLOCK);
			factory.register("exyriane_block", EXYRIANE_BLOCK);
			factory.register("faelite_block", FAELITE_BLOCK);
			factory.register("lusonyth_block", LUSONYTH_BLOCK);
			factory.register("clementium_block", CLEMENTIUM_BLOCK);
			factory.register("aketite", AKETITE);
			factory.register("aketite_stairs", AKETITE_STAIRS);
			factory.register("aketite_slab", AKETITE_SLAB);
			factory.register("aketite_wall", AKETITE_WALL);
			factory.register("aketite_bricks", AKETITE_BRICKS);
			factory.register("aketite_brick_stairs", AKETITE_BRICK_STAIRS);
			factory.register("aketite_brick_slab", AKETITE_BRICK_SLAB);
			factory.register("aketite_brick_wall", AKETITE_BRICK_WALL);
			factory.register("aketite_tiles", AKETITE_TILES);
			factory.register("aketite_tile_stairs", AKETITE_TILE_STAIRS);
			factory.register("aketite_tile_slab", AKETITE_TILE_SLAB);
			factory.register("aketite_tile_wall", AKETITE_TILE_WALL);
			factory.register("ornate_chiseled_aketite", ORNATE_CHISELED_AKETITE);
			factory.register("ornate_aketite_bricks_tears", ORNATE_AKETITE_BRICKS_TEARS);
			factory.register("ornate_aketite_bricks_lines", ORNATE_AKETITE_BRICKS_LINES);
			factory.register("smooth_aketite", SMOOTH_AKETITE);
			factory.register("chiseled_aketite", CHISELED_AKETITE);
			factory.register("cracked_aketite_bricks", CRACKED_AKETITE_BRICKS);
			factory.register("aketite_baseboard", AKETITE_BASEBOARD);
			factory.register("innermost_rock", INNERMOST_ROCK);
			factory.register("mysterious_stone", MYSTERIOUS_STONE);
			factory.register("mysterious_stone_stairs", MYSTERIOUS_STONE_STAIRS);
			factory.register("mysterious_stone_slab", MYSTERIOUS_STONE_SLAB);
			factory.register("artemnite", ARTEMNITE);
			factory.register("artemnite_stairs", ARTEMNITE_STAIRS);
			factory.register("artemnite_slab", ARTEMNITE_SLAB);
			factory.register("artemnite_wall", ARTEMNITE_WALL);
			factory.register("artemnite_bricks", ARTEMNITE_BRICKS);
			factory.register("artemnite_brick_stairs", ARTEMNITE_BRICK_STAIRS);
			factory.register("artemnite_brick_slab", ARTEMNITE_BRICK_SLAB);
			factory.register("artemnite_brick_wall", ARTEMNITE_BRICK_WALL);
			factory.register("artemnite_tiles", ARTEMNITE_TILES);
			factory.register("artemnite_tile_stairs", ARTEMNITE_TILE_STAIRS);
			factory.register("artemnite_tile_slab", ARTEMNITE_TILE_SLAB);
			factory.register("artemnite_tile_wall", ARTEMNITE_TILE_WALL);
			factory.register("mossy_artemnite_bricks", MOSSY_ARTEMNITE_BRICKS);
			factory.register("mossy_artemnite_brick_stairs", MOSSY_ARTEMNITE_BRICK_STAIRS);
			factory.register("mossy_artemnite_brick_slab", MOSSY_ARTEMNITE_BRICK_SLAB);
			factory.register("mossy_artemnite_brick_wall", MOSSY_ARTEMNITE_BRICK_WALL);
			factory.register("fancy_chiseled_artemnite", FANCY_CHISELED_ARTEMNITE);
			factory.register("fancy_artemnite_tiles", FANCY_ARTEMNITE_TILES);
			factory.register("fancy_artemnite_tile_stairs", FANCY_ARTEMNITE_TILE_STAIRS);
			factory.register("fancy_artemnite_tile_slab", FANCY_ARTEMNITE_TILE_SLAB);
			factory.register("fancy_artemnite_tile_wall", FANCY_ARTEMNITE_TILE_WALL);
			factory.register("ornate_artemnite_bricks", ORNATE_ARTEMNITE_BRICKS);
			factory.register("ornate_artemnite_bricks_tears", ORNATE_ARTEMNITE_BRICKS_TEARS);
			factory.register("ornate_artemnite_bricks_lines", ORNATE_ARTEMNITE_BRICKS_LINES);
			factory.register("smooth_artemnite", SMOOTH_ARTEMNITE);
			factory.register("chiseled_artemnite", CHISELED_ARTEMNITE);
			factory.register("cracked_artemnite_bricks", CRACKED_ARTEMNITE_BRICKS);
			factory.register("artemnite_baseboard", ARTEMNITE_BASEBOARD);
			factory.register("chiaspen_lamp", CHIASPEN_LAMP);
			factory.register("aketite_lamp", AKETITE_LAMP);
			factory.register("clementium_bars", CLEMENTIUM_BARS);
			factory.register("clementium_chain", CLEMENTIUM_CHAIN);
			factory.register("centaur_life_vault", CENTAUR_LIFE_VAULT);
			factory.register("power_keystone", POWER_KEYSTONE);
			factory.register("naturite", NATURITE);
			factory.register("stripped_palm_wood", STRIPPED_PALM_WOOD);
			factory.register("stripped_palm_log", STRIPPED_PALM_LOG);
			factory.register("stripped_neclane_wood", STRIPPED_NECLANE_WOOD);
			factory.register("stripped_neclane_log", STRIPPED_NECLANE_LOG);
			factory.register("stripped_cypress_wood", STRIPPED_CYPRESS_WOOD);
			factory.register("stripped_cypress_log", STRIPPED_CYPRESS_LOG);
			factory.register("stripped_vuxancia_wood", STRIPPED_VUXANCIA_WOOD);
			factory.register("stripped_vuxancia_log", STRIPPED_VUXANCIA_LOG);
			factory.register("stripped_nume_willow_wood", STRIPPED_NUME_WILLOW_WOOD);
			factory.register("stripped_nume_willow_log", STRIPPED_NUME_WILLOW_LOG);
			factory.register("stripped_nyreth_wood", STRIPPED_NYRETH_WOOD);
			factory.register("stripped_nyreth_log", STRIPPED_NYRETH_LOG);
			factory.register("bush_leaves", BUSH_LEAVES);
			factory.register("palm_leaves", PALM_LEAVES);
			factory.register("neclane_leaves", NECLANE_LEAVES);
			factory.register("flowered_neclane_leaves", FLOWERED_NECLANE_LEAVES);
			factory.register("cypress_leaves", CYPRESS_LEAVES);
			factory.register("pnevential_vuxancia_leaves", PNEVENTIAL_VUXANCIA_LEAVES);
			factory.register("streian_vuxancia_leaves", STREIAN_VUXANCIA_LEAVES);
			factory.register("orian_vuxancia_leaves", ORIAN_VUXANCIA_LEAVES);
			factory.register("vale_vuxancia_leaves", VALE_VUXANCIA_LEAVES);
			factory.register("zial_vuxancia_leaves", ZIAL_VUXANCIA_LEAVES);
			factory.register("nume_willow_leaves", NUME_WILLOW_LEAVES);
			factory.register("nyreth_leaves", NYRETH_LEAVES);
			factory.register("pale_nyreth_leaves", PALE_NYRETH_LEAVES);
			HANGING_PNEVENTIAL_VUXANCIA_LEAVES.register(mod, "hanging_pnevential_vuxancia_leaves");
			HANGING_STREIAN_VUXANCIA_LEAVES.register(mod, "hanging_streian_vuxancia_leaves");
			HANGING_ORIAN_VUXANCIA_LEAVES.register(mod, "hanging_orian_vuxancia_leaves");
			HANGING_VALE_VUXANCIA_LEAVES.register(mod, "hanging_vale_vuxancia_leaves");
			HANGING_ZIAL_VUXANCIA_LEAVES.register(mod, "hanging_zial_vuxancia_leaves");
			factory.register("pnevential_vuxancia_leaves_carpet", PNEVENTIAL_VUXANCIA_LEAVES_CARPET);
			factory.register("streian_vuxancia_leaves_carpet", STREIAN_VUXANCIA_LEAVES_CARPET);
			factory.register("orian_vuxancia_leaves_carpet", ORIAN_VUXANCIA_LEAVES_CARPET);
			factory.register("vale_vuxancia_leaves_carpet", VALE_VUXANCIA_LEAVES_CARPET);
			factory.register("zial_vuxancia_leaves_carpet", ZIAL_VUXANCIA_LEAVES_CARPET);
			factory.register("palm_crafting_table", PALM_CRAFTING_TABLE);
			factory.register("neclane_crafting_table", NECLANE_CRAFTING_TABLE);
			factory.register("cypress_crafting_table", CYPRESS_CRAFTING_TABLE);
			factory.register("vuxancia_crafting_table", VUXANCIA_CRAFTING_TABLE);
			factory.register("nume_willow_crafting_table", NUME_WILLOW_CRAFTING_TABLE);
			factory.register("nyreth_crafting_table", NYRETH_CRAFTING_TABLE);
			factory.register("chiaspen_furnace", CHIASPEN_FURNACE);
			factory.register("phosnor_slate_furnace", PHOSNOR_SLATE_FURNACE);
			factory.register("palm_bookshelf", PALM_BOOKSHELF);
			factory.register("neclane_bookshelf", NECLANE_BOOKSHELF);
			factory.register("cypress_bookshelf", CYPRESS_BOOKSHELF);
			factory.register("vuxancia_bookshelf", VUXANCIA_BOOKSHELF);
			factory.register("nume_willow_bookshelf", NUME_WILLOW_BOOKSHELF);
			factory.register("nyreth_bookshelf", NYRETH_BOOKSHELF);
			factory.register("palm_sapling", PALM_SAPLING);
			factory.register("neclane_sapling", NECLANE_SAPLING);
			factory.register("cypress_sapling", CYPRESS_SAPLING);
			factory.register("pnevential_vuxancia_sapling", PNEVENTIAL_VUXANCIA_SAPLING);
			factory.register("streian_vuxancia_sapling", STREIAN_VUXANCIA_SAPLING);
			factory.register("orian_vuxancia_sapling", ORIAN_VUXANCIA_SAPLING);
			factory.register("vale_vuxancia_sapling", VALE_VUXANCIA_SAPLING);
			factory.register("zial_vuxancia_sapling", ZIAL_VUXANCIA_SAPLING);
			factory.register("ceramic_block", CERAMIC_BLOCK);
			factory.register("ceramic_stairs", CERAMIC_STAIRS);
			factory.register("ceramic_slab", CERAMIC_SLAB);
			factory.register("ceramic_bricks", CERAMIC_BRICKS);
			factory.register("ceramic_brick_stairs", CERAMIC_BRICK_STAIRS);
			factory.register("ceramic_brick_slab", CERAMIC_BRICK_SLAB);
			factory.register("ceramic_brick_wall", CERAMIC_BRICK_WALL);
			factory.register("ceramic_fence", CERAMIC_FENCE);
			factory.register("ceramic_pressure_plate", CERAMIC_PRESSURE_PLATE);
			factory.register("ceramic_button", CERAMIC_BUTTON);
			factory.register("shorestone", SHORESTONE);
			factory.register("shorestone_stairs", SHORESTONE_STAIRS);
			factory.register("shorestone_slab", SHORESTONE_SLAB);
			factory.register("shorestone_wall", SHORESTONE_WALL);
			factory.register("pointed_criadan", POINTED_CRIADAN);
			factory.register("criadan", CRIADAN);
			factory.register("criadan_stairs", CRIADAN_STAIRS);
			factory.register("criadan_slab", CRIADAN_SLAB);
			factory.register("criadan_wall", CRIADAN_WALL);
			factory.register("criadan_pressure_plate", CRIADAN_PRESSURE_PLATE);
			factory.register("criadan_bricks", CRIADAN_BRICKS);
			factory.register("criadan_brick_stairs", CRIADAN_BRICK_STAIRS);
			factory.register("criadan_brick_slab", CRIADAN_BRICK_SLAB);
			factory.register("criadan_brick_wall", CRIADAN_BRICK_WALL);
			factory.register("criadan_brick_pressure_plate", CRIADAN_BRICK_PRESSURE_PLATE);
			factory.register("criadan_tiles", CRIADAN_TILES);
			factory.register("criadan_tile_stairs", CRIADAN_TILE_STAIRS);
			factory.register("criadan_tile_slab", CRIADAN_TILE_SLAB);
			factory.register("criadan_tile_wall", CRIADAN_TILE_WALL);
			factory.register("criadan_tile_pressure_plate", CRIADAN_TILE_PRESSURE_PLATE);
			factory.register("polished_criadan", POLISHED_CRIADAN);
			factory.register("polished_criadan_stairs", POLISHED_CRIADAN_STAIRS);
			factory.register("polished_criadan_slab", POLISHED_CRIADAN_SLAB);
			factory.register("polished_criadan_wall", POLISHED_CRIADAN_WALL);
			factory.register("polished_criadan_pressure_plate", POLISHED_CRIADAN_PRESSURE_PLATE);
			factory.register("criadan_pillar", CRIADAN_PILLAR);
			factory.register("chiseled_criadan", CHISELED_CRIADAN);
			factory.register("roughcast", ROUGHCAST);
			factory.register("roughcast_stairs", ROUGHCAST_STAIRS);
			factory.register("roughcast_slab", ROUGHCAST_SLAB);
			factory.register("roughcast_wall", ROUGHCAST_WALL);
			factory.register("pointed_anhydrite", POINTED_ANHYDRITE);
			factory.register("anhydrite", ANHYDRITE);
			factory.register("anhydrite_stairs", ANHYDRITE_STAIRS);
			factory.register("anhydrite_slab", ANHYDRITE_SLAB);
			factory.register("anhydrite_wall", ANHYDRITE_WALL);
			factory.register("anhydrite_pressure_plate", ANHYDRITE_PRESSURE_PLATE);
			factory.register("anhydrite_fence", ANHYDRITE_FENCE);
			factory.register("anhydrite_bricks", ANHYDRITE_BRICKS);
			factory.register("anhydrite_brick_stairs", ANHYDRITE_BRICK_STAIRS);
			factory.register("anhydrite_brick_slab", ANHYDRITE_BRICK_SLAB);
			factory.register("anhydrite_brick_wall", ANHYDRITE_BRICK_WALL);
			factory.register("anhydrite_brick_pressure_plate", ANHYDRITE_BRICK_PRESSURE_PLATE);
			factory.register("anhydrite_tiles", ANHYDRITE_TILES);
			factory.register("anhydrite_tile_stairs", ANHYDRITE_TILE_STAIRS);
			factory.register("anhydrite_tile_slab", ANHYDRITE_TILE_SLAB);
			factory.register("anhydrite_tile_wall", ANHYDRITE_TILE_WALL);
			factory.register("anhydrite_tile_pressure_plate", ANHYDRITE_TILE_PRESSURE_PLATE);
			factory.register("polished_anhydrite", POLISHED_ANHYDRITE);
			factory.register("polished_anhydrite_stairs", POLISHED_ANHYDRITE_STAIRS);
			factory.register("polished_anhydrite_slab", POLISHED_ANHYDRITE_SLAB);
			factory.register("polished_anhydrite_wall", POLISHED_ANHYDRITE_WALL);
			factory.register("polished_anhydrite_pressure_plate", POLISHED_ANHYDRITE_PRESSURE_PLATE);
			factory.register("anhydrite_pillar", ANHYDRITE_PILLAR);
			factory.register("chiseled_anhydrite", CHISELED_ANHYDRITE);
			factory.register("dune_sand_glass", DUNE_SAND_GLASS);
			factory.register("dune_sand_glass_tiles", DUNE_SAND_GLASS_TILES);
			factory.register("dune_sand_glass_tiles_top_left", DUNE_SAND_GLASS_TILES_TOP_LEFT);
			factory.register("dune_sand_glass_tiles_top_right", DUNE_SAND_GLASS_TILES_TOP_RIGHT);
			factory.register("dune_sand_glass_tiles_bottom_left", DUNE_SAND_GLASS_TILES_BOTTOM_LEFT);
			factory.register("dune_sand_glass_tiles_bottom_right", DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT);
			factory.register("dune_sand_glass_pane", DUNE_SAND_GLASS_PANE);
			factory.register("dune_sand_glass_pane_tiles", DUNE_SAND_GLASS_PANE_TILES);
			factory.register("dune_sand_glass_pane_tiles_top_left", DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT);
			factory.register("dune_sand_glass_pane_tiles_top_right", DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT);
			factory.register("dune_sand_glass_pane_tiles_bottom_left", DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT);
			factory.register("dune_sand_glass_pane_tiles_bottom_right", DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT);
			factory.register("antic_mosaic", ANTIC_MOSAIC);
			factory.register("antic_mosaic_stairs", ANTIC_MOSAIC_STAIRS);
			factory.register("antic_mosaic_slab", ANTIC_MOSAIC_SLAB);
			factory.register("antic_mosaic_wall", ANTIC_MOSAIC_WALL);
			factory.register("antic_floortile", ANTIC_FLOORTILE);
			factory.register("antic_floortile_stairs", ANTIC_FLOORTILE_STAIRS);
			factory.register("antic_floortile_slab", ANTIC_FLOORTILE_SLAB);
			factory.register("antic_floortile_wall", ANTIC_FLOORTILE_WALL);
			factory.register("snail_shell_bricks", SNAIL_SHELL_BRICKS);
			factory.register("snail_shell_brick_stairs", SNAIL_SHELL_BRICK_STAIRS);
			factory.register("snail_shell_brick_slab", SNAIL_SHELL_BRICK_SLAB);
			factory.register("snail_shell_brick_wall", SNAIL_SHELL_BRICK_WALL);
			factory.register("fancy_snail_shell_bricks", FANCY_SNAIL_SHELL_BRICKS);
			factory.register("fancy_snail_shell_brick_stairs", FANCY_SNAIL_SHELL_BRICK_STAIRS);
			factory.register("fancy_snail_shell_brick_slab", FANCY_SNAIL_SHELL_BRICK_SLAB);
			factory.register("fancy_snail_shell_brick_wall", FANCY_SNAIL_SHELL_BRICK_WALL);
			factory.register("peaks_snow", PEAKS_SNOW);
			factory.register("peaks_snow_block", PEAKS_SNOW_BLOCK);
			factory.register("dark_green_tiles", DARK_GREEN_TILES);
			factory.register("dark_green_tile_stairs", DARK_GREEN_TILE_STAIRS);
			factory.register("dark_green_tile_slab", DARK_GREEN_TILE_SLAB);
			factory.register("dark_green_tile_wall", DARK_GREEN_TILE_WALL);
			factory.register("green_tiles", GREEN_TILES);
			factory.register("green_tile_stairs", GREEN_TILE_STAIRS);
			factory.register("green_tile_slab", GREEN_TILE_SLAB);
			factory.register("green_tile_wall", GREEN_TILE_WALL);
			factory.register("lime_tiles", LIME_TILES);
			factory.register("lime_tile_stairs", LIME_TILE_STAIRS);
			factory.register("lime_tile_slab", LIME_TILE_SLAB);
			factory.register("lime_tile_wall", LIME_TILE_WALL);
			factory.register("turquoise_tiles", TURQUOISE_TILES);
			factory.register("turquoise_tile_stairs", TURQUOISE_TILE_STAIRS);
			factory.register("turquoise_tile_slab", TURQUOISE_TILE_SLAB);
			factory.register("turquoise_tile_wall", TURQUOISE_TILE_WALL);
			factory.register("light_blue_tiles", LIGHT_BLUE_TILES);
			factory.register("light_blue_tile_stairs", LIGHT_BLUE_TILE_STAIRS);
			factory.register("light_blue_tile_slab", LIGHT_BLUE_TILE_SLAB);
			factory.register("light_blue_tile_wall", LIGHT_BLUE_TILE_WALL);
			factory.register("blue_tiles", BLUE_TILES);
			factory.register("blue_tile_stairs", BLUE_TILE_STAIRS);
			factory.register("blue_tile_slab", BLUE_TILE_SLAB);
			factory.register("blue_tile_wall", BLUE_TILE_WALL);
			factory.register("dark_blue_tiles", DARK_BLUE_TILES);
			factory.register("dark_blue_tile_stairs", DARK_BLUE_TILE_STAIRS);
			factory.register("dark_blue_tile_slab", DARK_BLUE_TILE_SLAB);
			factory.register("dark_blue_tile_wall", DARK_BLUE_TILE_WALL);
			factory.register("purple_tiles", PURPLE_TILES);
			factory.register("purple_tile_stairs", PURPLE_TILE_STAIRS);
			factory.register("purple_tile_slab", PURPLE_TILE_SLAB);
			factory.register("purple_tile_wall", PURPLE_TILE_WALL);
			factory.register("pink_tiles", PINK_TILES);
			factory.register("pink_tile_stairs", PINK_TILE_STAIRS);
			factory.register("pink_tile_slab", PINK_TILE_SLAB);
			factory.register("pink_tile_wall", PINK_TILE_WALL);
			factory.register("red_tiles", RED_TILES);
			factory.register("red_tile_stairs", RED_TILE_STAIRS);
			factory.register("red_tile_slab", RED_TILE_SLAB);
			factory.register("red_tile_wall", RED_TILE_WALL);
			factory.register("black_tiles", BLACK_TILES);
			factory.register("black_tile_stairs", BLACK_TILE_STAIRS);
			factory.register("black_tile_slab", BLACK_TILE_SLAB);
			factory.register("black_tile_wall", BLACK_TILE_WALL);
			factory.register("ceramic_tiles", CERAMIC_TILES);
			factory.register("ceramic_tile_stairs", CERAMIC_TILE_STAIRS);
			factory.register("ceramic_tile_slab", CERAMIC_TILE_SLAB);
			factory.register("ceramic_tile_wall", CERAMIC_TILE_WALL);
			factory.register("ochre_tiles", OCHRE_TILES);
			factory.register("ochre_tile_stairs", OCHRE_TILE_STAIRS);
			factory.register("ochre_tile_slab", OCHRE_TILE_SLAB);
			factory.register("ochre_tile_wall", OCHRE_TILE_WALL);
			factory.register("dune_sand_castle", DUNE_SAND_CASTLE);
			factory.register("urn", URN);
			factory.register("heart_of_nature_trophy", HEART_OF_NATURE_TROPHY);
		});
	}
}
