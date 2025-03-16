package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.worldgen.features.HollowCypressLogFeature;
import com.mmodding.archeon.worldgen.features.MenhirFeature;
import com.mmodding.archeon.worldgen.features.RockyFieldsRockFeature;
import com.mmodding.archeon.worldgen.features.trees.decorators.HangingLeavesTreeDecorator;
import com.mmodding.archeon.worldgen.features.trees.decorators.SporeRootcapTreeDecorator;
import com.mmodding.archeon.worldgen.features.trees.foliage.CypressFoliagePlacer;
import com.mmodding.archeon.worldgen.features.trees.foliage.NeclaneFoliagePlacer;
import com.mmodding.archeon.worldgen.features.trees.foliage.PalmFoliagePlacer;
import com.mmodding.archeon.worldgen.features.trees.foliage.VuxanciaFoliagePlacer;
import com.mmodding.archeon.worldgen.features.trees.trunk.NeclaneTrunkPlacer;
import com.mmodding.archeon.worldgen.features.trees.trunk.PalmTrunkPlacer;
import com.mmodding.archeon.worldgen.features.trees.trunk.VuxanciaTrunkPlacer;
import com.mmodding.mmodding_lib.library.blocks.CustomLayeredBlock;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.BiList;
import com.mmodding.mmodding_lib.library.utils.ListUtils;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.*;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.floatprovider.ClampedNormalFloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ClampedNormalIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.BlockColumnFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectionContext;

import java.util.List;
import java.util.function.Predicate;

public class ArcheonFeatures implements ElementsInitializer {

	public static final TrunkPlacerType<NeclaneTrunkPlacer> NECLANE_TRUNK_PLACER = CustomTrunkPlacer.createType(NeclaneTrunkPlacer.CODEC);
	public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = CustomTrunkPlacer.createType(PalmTrunkPlacer.CODEC);
	public static final TrunkPlacerType<VuxanciaTrunkPlacer> VUXANCIA_TRUNK_PLACER = CustomTrunkPlacer.createType(VuxanciaTrunkPlacer.CODEC);

	public static final FoliagePlacerType<NeclaneFoliagePlacer> NECLANE_FOLIAGE_PLACER = CustomFoliagePlacer.createType(NeclaneFoliagePlacer.CODEC);
	public static final FoliagePlacerType<CypressFoliagePlacer> CYPRESS_FOLIAGE_PLACER = CustomFoliagePlacer.createType(CypressFoliagePlacer.CODEC);
	public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = CustomFoliagePlacer.createType(PalmFoliagePlacer.CODEC);
	public static final FoliagePlacerType<VuxanciaFoliagePlacer> VUXANCIA_FOLIAGE_PLACER = CustomFoliagePlacer.createType(VuxanciaFoliagePlacer.CODEC);

	public static final TreeDecoratorType<HangingLeavesTreeDecorator> HANGING_LEAVES_TREE_DECORATOR = CustomTreeDecorator.createType(HangingLeavesTreeDecorator.CODEC);
	public static final TreeDecoratorType<SporeRootcapTreeDecorator> SPORE_ROOTCAP_TREE_DECORATOR = CustomTreeDecorator.createType(SporeRootcapTreeDecorator.CODEC);

	public static final AdvancedFeature<RockyFieldsRockFeature.Config> ROCKY_FIELDS_ROCK = new RockyFieldsRockFeature(RockyFieldsRockFeature.Config.CODEC);
	public static final AdvancedFeature<MenhirFeature.Config> MENHIR = new MenhirFeature(MenhirFeature.Config.CODEC);
	public static final AdvancedFeature<HollowCypressLogFeature.Config> HOLLOW_CYPRESS_LOG = new HollowCypressLogFeature(HollowCypressLogFeature.Config.CODEC);

	public static final CustomTreeFeature PALM_TREE = new CustomTreeFeature(
		ArcheonBlocks.PALM_LOG,
		new PalmTrunkPlacer(6, 3, 0),
		ArcheonBlocks.PALM_LEAVES,
		new PalmFoliagePlacer(ConstantIntProvider.create(6), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(0, 0.5f, 1),
		ArcheonBlocks.PALM_SAPLING
	).setGroundBlock(ArcheonBlocks.DUNE_SAND);

	public static final CustomTreeFeature NECLANE_TREE = new CustomTreeFeature(
		ArcheonBlocks.NECLANE_LOG,
		new NeclaneTrunkPlacer(4, 2, 0),
		ArcheonBlocks.NECLANE_LEAVES,
		new NeclaneFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(2, 0.1f, 1),
		ArcheonBlocks.NECLANE_SAPLING
	).setGroundBlock(ArcheonBlocks.WET_DIRT).addPlacedFeature(
		PlacedFeatureUtil.createCountExtraModifier(3, 0.1f, 1),
		ArcheonBlocks.NECLANE_SAPLING,
		"rocky_fields"
	);

	public static final CustomTreeFeature CYPRESS_TREE = new CustomTreeFeature(
		ArcheonBlocks.CYPRESS_LOG,
		new StraightTrunkPlacer(9, 9, 3),
		ArcheonBlocks.CYPRESS_LEAVES,
		new CypressFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(2, 0.1f, 1),
		ArcheonBlocks.CYPRESS_SAPLING
	).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature PNEVENTIAL_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(3, 0.1f, 1),
		ArcheonBlocks.PNEVENTIAL_VUXANCIA_SAPLING
	).addTreeDecorators(SporeRootcapTreeDecorator.INSTANCE, HangingLeavesTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature STREIAN_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.STREIAN_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(2, 0.1f, 1),
		ArcheonBlocks.STREIAN_VUXANCIA_SAPLING
	).addTreeDecorators(SporeRootcapTreeDecorator.INSTANCE, HangingLeavesTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature ORIAN_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.ORIAN_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(1, 0.1f, 1),
		ArcheonBlocks.ORIAN_VUXANCIA_SAPLING
	).addTreeDecorators(SporeRootcapTreeDecorator.INSTANCE, HangingLeavesTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VALE_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VALE_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(1, 0.1f, 1),
		ArcheonBlocks.VALE_VUXANCIA_SAPLING
	).addTreeDecorators(SporeRootcapTreeDecorator.INSTANCE, HangingLeavesTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature ZIAL_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.ZIAL_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(1, 0.1f, 1),
		ArcheonBlocks.ZIAL_VUXANCIA_SAPLING
	).addTreeDecorators(SporeRootcapTreeDecorator.INSTANCE, HangingLeavesTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomRandomPatchFeature PATCH_WET_GRASS = new CustomRandomPatchFeature(45, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_GRASS)))).setCount(10);
	public static final CustomRandomPatchFeature PATCH_TALL_WET_GRASS = new CustomRandomPatchFeature(25, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_WET_GRASS)))).setCount(7);
	public static final CustomRandomPatchFeature PATCH_FLOWERED_WET_GRASS = new CustomRandomPatchFeature(3, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.FLOWERED_WET_GRASS)))).setCount(3);
	public static final CustomRandomPatchFeature PATCH_FLOWERED_TALL_WET_GRASS = new CustomRandomPatchFeature(2, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.FLOWERED_TALL_WET_GRASS)))).setCount(2);
	public static final CustomRandomPatchFeature PATCH_WET_FERN = new CustomRandomPatchFeature(40, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_FERN)))).setRarity(6);
	public static final CustomRandomPatchFeature PATCH_TALL_WET_FERN = new CustomRandomPatchFeature(50, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_WET_FERN)))).setRarity(7);
	public static final CustomRandomPatchFeature PATCH_SOUTH_WHEAT = new CustomRandomPatchFeature(40, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.SOUTH_WHEAT)))).setRarity(5);
	public static final CustomRandomPatchFeature PATCH_WET_GRASS_TUFFET = new CustomRandomPatchFeature(10, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_GRASS_TUFFET)))).setCount(3);

	public static final CustomRandomPatchFeature PATCH_SNOWY_GRASS_TUFFET = new CustomRandomPatchFeature(20, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.SNOWY_GRASS_TUFFET)))).setCount(7);

	public static final CustomFlowerFeature SUNSET_ORCHID_FEATURE = new CustomFlowerFeature(32, 7, 3,
		ArcheonBlocks.SUNSET_ORCHID).setRarity(5);
	public static final CustomFlowerFeature ROSEYPIA_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.ROSEYPIA).setRarity(2);
	public static final CustomFlowerFeature AEROLIA_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.AEROLIA).setRarity(2);
	public static final CustomFlowerFeature ASTEDIBES_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.ASTEDIBES).setRarity(2);
	public static final CustomFlowerFeature TWILIGHT_ROSE_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.TWILIGHT_ROSE).setRarity(2);
	public static final CustomFlowerFeature PINK_LYCORIS_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.PINK_LYCORIS).setRarity(2);
	public static final CustomFlowerFeature RED_LYCORIS_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.RED_LYCORIS).setRarity(2);
	public static final CustomFlowerFeature ORANGE_LYCORIS_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.ORANGE_LYCORIS).setRarity(2);
	public static final CustomFlowerFeature ASCENDIA_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.ASCENDIA).setRarity(2);
	public static final CustomFlowerFeature OEA_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.OEA).setRarity(2);
	public static final CustomFlowerFeature IOPEA_FEATURE = new CustomFlowerFeature(4, 12, 6,
		BiList.of(ArcheonBlocks.IOPEA, 3, ArcheonBlocks.TALL_IOPEA, 1)
	).setRarity(2);
	public static final CustomFlowerFeature ORGANDEANE_FEATURE = new CustomFlowerFeature(4, 12, 6,
		BiList.of(ArcheonBlocks.ORGANDEANE_BLOSSOM, 3, ArcheonBlocks.TALL_ORGANDEANE, 1)
	).setRarity(2);
	public static final CustomFlowerFeature SEPTICEOLIA_FEATURE = new CustomFlowerFeature(4, 7, 3,
		ArcheonBlocks.SEPTICEOLIA).setRarity(2);

	public static final RuleTest CHIASPEN = new BlockMatchRuleTest(ArcheonBlocks.CHIASPEN);
	public static final RuleTest PHOSNOR_SLATE = new BlockMatchRuleTest(ArcheonBlocks.PHOSNOR_SLATE);
	public static final RuleTest DUNE_SAND = new BlockMatchRuleTest(ArcheonBlocks.DUNE_SAND);

	public static final RuleTest CHIASPEN_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.Blocks.CHIASPEN_ORES_REPLACEABLES);
	public static final RuleTest PHOSNOR_SLATE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.Blocks.PHOSNOR_SLATE_ORES_REPLACEABLES);

	public static final CustomOreFeature ARTEMNITE_PATCH = new CustomOreFeature(
		64, 8, 0, 120, List.of(OreFeatureConfig.createTarget(CHIASPEN, ArcheonBlocks.ARTEMNITE.getDefaultState()))
	);

	public static final CustomOreFeature CRIADAN_PATCH = new CustomOreFeature(
		64, 8, 0, 120,
		List.of(OreFeatureConfig.createTarget(CHIASPEN, ArcheonBlocks.CRIADAN.getDefaultState()))
	);

	public static final CustomOreFeature AKETITE_PATCH = new CustomOreFeature(
		64, 8, -64, 0,
		List.of(OreFeatureConfig.createTarget(PHOSNOR_SLATE, ArcheonBlocks.AKETITE.getDefaultState()))
	);

	public static final CustomOreFeature SALT_PATCH = new CustomOreFeature(
		32, 4, 45, 80,
		List.of(OreFeatureConfig.createTarget(DUNE_SAND, ArcheonBlocks.SALT_BLOCK.getDefaultState()))
	);

	public static final CustomOreFeature SHELLSAND_PATCH = new CustomOreFeature(
		3, 32, 45, 80,
		List.of(OreFeatureConfig.createTarget(DUNE_SAND, ArcheonBlocks.SHELLSAND.getDefaultState()))
	);

	public static final CustomRandomPatchFeature XETULIAN_SUGAR_CANE = new CustomRandomPatchFeature(
		20, 4, 0,
		PlacedFeatureUtil.placedInline(
			Feature.BLOCK_COLUMN,
			BlockColumnFeatureConfig.create(BiasedToBottomIntProvider.create(2, 4), BlockStateProvider.of(ArcheonBlocks.XETULIAN_SUGAR_CANE)),
			BlockPredicateFilterPlacementModifier.create(
				BlockPredicate.allOf(
					BlockPredicate.IS_AIR,
					BlockPredicate.wouldSurvive(ArcheonBlocks.XETULIAN_SUGAR_CANE.getDefaultState(), BlockPos.ORIGIN),
					BlockPredicate.anyOf(
						BlockPredicate.method_43289(new BlockPos(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
						BlockPredicate.method_43289(new BlockPos(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
						BlockPredicate.method_43289(new BlockPos(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
						BlockPredicate.method_43289(new BlockPos(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER)
					)
				)
			)
		)
	);

	public static final List<OreFeatureConfig.Target> APAFLORITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.APAFLORITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> EXYRIANE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.EXYRIANE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_EXYRIANE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> FAELITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.FAELITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_FAELITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> LUSONYTH_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.LUSONYTH_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_LUSONYTH_ORE.getDefaultState())
	);

	public static final CustomOreFeature APAFLORITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, APAFLORITE_ORE_TARGETS);
	public static final CustomOreFeature EXYRIANE_ORE_FEATURE = new CustomOreFeature(30, 7, -60, 160, EXYRIANE_ORE_TARGETS);
	public static final CustomOreFeature FAELITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, FAELITE_ORE_TARGETS);
	public static final CustomOreFeature LUSONYTH_ORE_FEATURE = new CustomOreFeature(6, 3, -60, 0, LUSONYTH_ORE_TARGETS, 0.75f);

	public static final CustomLiquidVegetationPatchFeature GLOWSHROOMS_POOL = new CustomLiquidVegetationPatchFeature(
		5,
		Direction.DOWN,
		12,
		ArcheonTags.Blocks.PHOSNOR_SLATE_ORES_REPLACEABLES,
		ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK.getDefaultState(),
		ArcheonFluids.DASCIUM.getBlock().getDefaultState(),
		ListUtils.biBuilder(
			vegetation -> vegetation.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState(), 1)
		),
		VerticalSurfaceType.FLOOR,
		ConstantIntProvider.create(3),
		0.8f,
		2,
		0.1f,
		UniformIntProvider.create(1, 2),
		0.7f
	);

	public static final CustomVegetationPatchFeature GLOWSHROOMS_PATCH = new CustomVegetationPatchFeature(
		5,
		Direction.DOWN,
		12,
		ArcheonTags.Blocks.PHOSNOR_SLATE_ORES_REPLACEABLES,
		ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK.getDefaultState(),
		ListUtils.biBuilder(
			vegetation -> {
				vegetation.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 1), 5);
				vegetation.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 2), 5);
				vegetation.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 3), 5);
				vegetation.add(ArcheonBlocks.GLOWSPROUTS.getDefaultState(), 10);
				vegetation.add(ArcheonBlocks.GLOWSHROOMS.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.GLOWSHROOM_PARASITES.getDefaultState(), 5);
			}
		),
		VerticalSurfaceType.FLOOR,
		ConstantIntProvider.create(3),
		0.8f,
		3,
		0.6f,
		UniformIntProvider.create(2, 3),
		0.9f
	);

	public static final CustomLayeredFeature GLOWSHROOMS = new CustomLayeredFeature(
		() -> List.of(
			RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Archeon.createId("glowshrooms_pool")),
			RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Archeon.createId("glowshrooms_patch"))
		),
		GenerationStep.Feature.VEGETAL_DECORATION,
		CountPlacementModifier.create(10),
		InSquarePlacementModifier.getInstance(),
		PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE,
		EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
		RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
		BiomePlacementModifier.getInstance()
	);

	public static final CustomDripstoneClusterFeature CRIADAN_CLUSTER = new CustomDripstoneClusterFeature(
		ArcheonBlocks.POINTED_CRIADAN,
		ArcheonBlocks.CRIADAN,
		UniformIntProvider.create(48, 96),
		12,
		UniformIntProvider.create(3, 6),
		UniformIntProvider.create(2, 8),
		1,
		3,
		UniformIntProvider.create(2, 4),
		UniformFloatProvider.create(0.3f, 0.7f),
		ClampedNormalFloatProvider.create(0.1f, 0.3f, 0.1f, 0.9f),
		0.1f,
		3,
		8
	);

	public static final CustomLargeDripstoneFeature LARGE_CRIADAN = new CustomLargeDripstoneFeature(
		ArcheonBlocks.CRIADAN,
		UniformIntProvider.create(10, 48),
		30,
		UniformIntProvider.create(3, 19),
		UniformFloatProvider.create(0.4f, 2.0f),
		0.33f,
		UniformFloatProvider.create(0.3f, 0.9f),
		UniformFloatProvider.create(0.4f, 1.0f),
		UniformFloatProvider.create(0.0f, 0.3f),
		4,
		0.6f
	);

	public static final CustomPointedDripstoneFeature POINTED_CRIADAN = new CustomPointedDripstoneFeature(
		ArcheonBlocks.POINTED_CRIADAN,
		ArcheonBlocks.CRIADAN,
		UniformIntProvider.create(192, 256),
		UniformIntProvider.create(1, 5),
		ClampedNormalIntProvider.create(0.0f, 3.0f, -10, 10),
		ClampedNormalIntProvider.create(0.0f, 0.6f, -2, 2),
		0.2f,
		0.7f,
		0.5f,
		0.5f
	);

	public static final CustomDripstoneClusterFeature ANHYDRITE_CLUSTER = new CustomDripstoneClusterFeature(
		ArcheonBlocks.POINTED_ANHYDRITE,
		ArcheonBlocks.ANHYDRITE,
		UniformIntProvider.create(48, 96),
		12,
		UniformIntProvider.create(3, 6),
		UniformIntProvider.create(2, 8),
		1,
		3,
		UniformIntProvider.create(2, 4),
		UniformFloatProvider.create(0.3f, 0.7f),
		ClampedNormalFloatProvider.create(0.1f, 0.3f, 0.1f, 0.9f),
		0.1f,
		3,
		8
	);

	public static final CustomLargeDripstoneFeature LARGE_ANHYDRITE = new CustomLargeDripstoneFeature(
		ArcheonBlocks.ANHYDRITE,
		UniformIntProvider.create(10, 48),
		30,
		UniformIntProvider.create(3, 19),
		UniformFloatProvider.create(0.4f, 2.0f),
		0.33f,
		UniformFloatProvider.create(0.3f, 0.9f),
		UniformFloatProvider.create(0.4f, 1.0f),
		UniformFloatProvider.create(0.0f, 0.3f),
		4,
		0.6f
	);

	public static final CustomPointedDripstoneFeature POINTED_ANHYDRITE = new CustomPointedDripstoneFeature(
		ArcheonBlocks.POINTED_ANHYDRITE,
		ArcheonBlocks.ANHYDRITE,
		UniformIntProvider.create(192, 256),
		UniformIntProvider.create(1, 5),
		ClampedNormalIntProvider.create(0.0f, 3.0f, -10, 10),
		ClampedNormalIntProvider.create(0.0f, 0.6f, -2, 2),
		0.2f,
		0.7f,
		0.5f,
		0.5f
	);

	public static final CustomVegetationPatchFeature GOLDEN_CLAY_PATCH = new CustomVegetationPatchFeature(
		125,
		Direction.DOWN,
		12,
		ArcheonTags.Blocks.ACHREAN_MOSS_REPLACEABLES,
		ArcheonBlocks.GOLDEN_CLAY.getDefaultState(),
		ListUtils.biBuilder(
			vegetation -> {
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 1, 50);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 2, 35);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 3, 30);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 4, 25);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 5, 20);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 6, 15);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 7, 10);
				ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, 8, 5);
			}
		),
		VerticalSurfaceType.FLOOR,
		ConstantIntProvider.create(3),
		0.8f,
		2,
		0.8f,
		UniformIntProvider.create(4, 7),
		0.7f
	);

	public static final CustomLiquidVegetationPatchFeature GOLDEN_CLAY_POOL = new CustomLiquidVegetationPatchFeature(
		125,
		Direction.DOWN,
		12,
		ArcheonTags.Blocks.ACHREAN_MOSS_REPLACEABLES,
		ArcheonBlocks.GOLDEN_CLAY.getDefaultState(),
		ArcheonFluids.HOT_SPRING_WATER.getBlock().getDefaultState(),
		ListUtils.biBuilder(
			vegetation -> {
				vegetation.add(ArcheonBlocks.SMALL_HOT_SPRING_LILY_PAD.getDefaultState(), 30);
				vegetation.add(ArcheonBlocks.HOT_SPRING_LILY_PAD.getDefaultState(), 20);
				vegetation.add(ArcheonBlocks.GIANT_LILY.getDefaultState(), 10);
			}
		),
		VerticalSurfaceType.FLOOR,
		ConstantIntProvider.create(3),
		0.8f,
		5,
		0.1f,
		UniformIntProvider.create(4, 7),
		0.7f
	);

	public static final CustomVegetationPatchFeature ACHREAN_MOSS_PATCH = new CustomVegetationPatchFeature(
		125,
		Direction.DOWN,
		12,
		ArcheonTags.Blocks.ACHREAN_MOSS_REPLACEABLES,
		ArcheonBlocks.ACHREAN_MOSS_BLOCK.getDefaultState(),
		ListUtils.biBuilder(
			vegetation -> {
				for (int i = 0; i < 4; i++) {
					ArcheonFeatures.addLayeredBlock(vegetation, ArcheonBlocks.ACHREAN_MOSS, i + 1, 25);
				}
				vegetation.add(ArcheonBlocks.WET_GRASS.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.TALL_WET_GRASS.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.FLOWERED_WET_GRASS.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.FLOWERED_TALL_WET_GRASS.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.WET_FERN.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.TALL_WET_FERN.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.WET_GRASS_TUFFET.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.BLUE_DOELDIA.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.WHITE_DOELDIA.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.PINK_DOELDIA.getDefaultState(), 5);
				vegetation.add(ArcheonBlocks.YELLOW_DOELDIA.getDefaultState(), 5);
			}
		),
		VerticalSurfaceType.FLOOR,
		ConstantIntProvider.create(1),
		0.0f,
		5,
		0.8f,
		UniformIntProvider.create(4, 7),
		0.3f
	);

	public static final CustomGrowsDownPlantWithCeilingFeature ACHREAN_MOSS_CEILING = new CustomGrowsDownPlantWithCeilingFeature(
		125,
		12,
		() -> ArcheonBlocks.ACHREAN_VINES,
		() -> ArcheonBlocks.ACHREAN_MOSS_BLOCK,
		ArcheonTags.Blocks.ACHREAN_MOSS_REPLACEABLES,
		UniformIntProvider.create(1, 2),
		0.0f,
		5,
		0.08f,
		UniformIntProvider.create(4, 7),
		0.3f
	);

	public static final CustomBooleanFeature ACHREAN_GOLDEN_CLAY = new CustomBooleanFeature(
		() -> RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Archeon.createId("golden_clay_patch")),
		() -> RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Archeon.createId("golden_clay_pool")),
		GenerationStep.Feature.VEGETAL_DECORATION,
		CountPlacementModifier.create(62),
		InSquarePlacementModifier.getInstance(),
		PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE,
		EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
		RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
		BiomePlacementModifier.getInstance()
	);

	private static void addLayeredBlock(BiList<BlockState, Integer> vegetation, @SuppressWarnings("SameParameterValue") CustomLayeredBlock layered, int layer, int weight) {
		vegetation.add(layered.getDefaultState().with(Properties.LAYERS, layer), weight);
	}

	@Override
	public void register() {
		RegistrationUtils.registerTrunkPlacerType(Archeon.createId("neclane_trunk_placer"), NECLANE_TRUNK_PLACER);
		RegistrationUtils.registerTrunkPlacerType(Archeon.createId("palm_trunk_placer"), PALM_TRUNK_PLACER);
		RegistrationUtils.registerTrunkPlacerType(Archeon.createId("vuxancia_trunk_placer"), VUXANCIA_TRUNK_PLACER);
		RegistrationUtils.registerFoliagePlacerType(Archeon.createId("neclane_foliage_placer"), NECLANE_FOLIAGE_PLACER);
		RegistrationUtils.registerFoliagePlacerType(Archeon.createId("cypress_foliage_placer"), CYPRESS_FOLIAGE_PLACER);
		RegistrationUtils.registerFoliagePlacerType(Archeon.createId("palm_foliage_placer"), PALM_FOLIAGE_PLACER);
		RegistrationUtils.registerFoliagePlacerType(Archeon.createId("vuxancia_foliage_placer"), VUXANCIA_FOLIAGE_PLACER);
		RegistrationUtils.registerTreeDecoratorType(Archeon.createId("hanging_leaves_tree_decorator"), HANGING_LEAVES_TREE_DECORATOR);
		RegistrationUtils.registerTreeDecoratorType(Archeon.createId("spore_rootcap_tree_decorator"), SPORE_ROOTCAP_TREE_DECORATOR);

		ROCKY_FIELDS_ROCK.register(Archeon.createId("rocky_fields_rock"));
		MENHIR.register(Archeon.createId("menhir"));
		HOLLOW_CYPRESS_LOG.register(Archeon.createId("hollow_cypress_log"));
		PALM_TREE.register(Archeon.createId("palm_tree"));
		NECLANE_TREE.register(Archeon.createId("neclane_tree"));
		CYPRESS_TREE.register(Archeon.createId("cypress_tree"));
		PNEVENTIAL_VUXANCIA_TREE.register(Archeon.createId("pnevential_vuxancia_tree"));
		STREIAN_VUXANCIA_TREE.register(Archeon.createId("streian_vuxancia_tree"));
		ORIAN_VUXANCIA_TREE.register(Archeon.createId("orian_vuxancia_tree"));
		VALE_VUXANCIA_TREE.register(Archeon.createId("vale_vuxancia_tree"));
		ZIAL_VUXANCIA_TREE.register(Archeon.createId("zial_vuxancia_tree"));
		PATCH_WET_GRASS.register(Archeon.createId("patch_wet_grass"));
		PATCH_TALL_WET_GRASS.register(Archeon.createId("patch_tall_wet_grass"));
		PATCH_FLOWERED_WET_GRASS.register(Archeon.createId("patch_flowered_wet_grass"));
		PATCH_FLOWERED_TALL_WET_GRASS.register(Archeon.createId("patch_flowered_tall_wet_grass"));
		PATCH_WET_FERN.register(Archeon.createId("path_wet_fern"));
		PATCH_TALL_WET_FERN.register(Archeon.createId("patch_tall_wet_fern"));
		PATCH_SOUTH_WHEAT.register(Archeon.createId("patch_south_wheat"));
		PATCH_WET_GRASS_TUFFET.register(Archeon.createId("patch_wet_grass_tuffet"));
		PATCH_SNOWY_GRASS_TUFFET.register(Archeon.createId("patch_snowy_grass_tuffet"));
		SUNSET_ORCHID_FEATURE.register(Archeon.createId("sunset_orchid_feature"));
		ROSEYPIA_FEATURE.register(Archeon.createId("roseypia_feature"));
		AEROLIA_FEATURE.register(Archeon.createId("aerolia_feature"));
		ASTEDIBES_FEATURE.register(Archeon.createId("astedibes_feature"));
		TWILIGHT_ROSE_FEATURE.register(Archeon.createId("twilight_rose_feature"));
		PINK_LYCORIS_FEATURE.register(Archeon.createId("pink_lycoris_feature"));
		RED_LYCORIS_FEATURE.register(Archeon.createId("red_lycoris_feature"));
		ORANGE_LYCORIS_FEATURE.register(Archeon.createId("orange_lycoris_feature"));
		ASCENDIA_FEATURE.register(Archeon.createId("ascendia_feature"));
		OEA_FEATURE.register(Archeon.createId("oea_feature"));
		IOPEA_FEATURE.register(Archeon.createId("iopea_feature"));
		ORGANDEANE_FEATURE.register(Archeon.createId("organdeane_feature"));
		SEPTICEOLIA_FEATURE.register(Archeon.createId("septiceolia_feature"));
		ARTEMNITE_PATCH.register(Archeon.createId("artemnite_patch"));
		CRIADAN_PATCH.register(Archeon.createId("criadan_patch"));
		AKETITE_PATCH.register(Archeon.createId("aketite_patch"));
		SALT_PATCH.register(Archeon.createId("salt_patch"));
		SHELLSAND_PATCH.register(Archeon.createId("shellsand_patch"));
		XETULIAN_SUGAR_CANE.register(Archeon.createId("xetulian_sugar_cane"));
		APAFLORITE_ORE_FEATURE.register(Archeon.createId("apaflorite_ore_feature"));
		EXYRIANE_ORE_FEATURE.register(Archeon.createId("exyriane_ore_feature"));
		FAELITE_ORE_FEATURE.register(Archeon.createId("faelite_ore_feature"));
		LUSONYTH_ORE_FEATURE.register(Archeon.createId("lusonyth_ore_feature"));
		GLOWSHROOMS_POOL.register(Archeon.createId("glowshrooms_pool"));
		GLOWSHROOMS_PATCH.register(Archeon.createId("glowshrooms_patch"));
		GLOWSHROOMS.register(Archeon.createId("glowshrooms"));
		CRIADAN_CLUSTER.register(Archeon.createId("criadan_cluster"));
		LARGE_CRIADAN.register(Archeon.createId("large_criadan"));
		POINTED_CRIADAN.register(Archeon.createId("pointed_criadan"));
		ANHYDRITE_CLUSTER.register(Archeon.createId("anhydrite_cluster"));
		LARGE_ANHYDRITE.register(Archeon.createId("large_anhydrite"));
		POINTED_ANHYDRITE.register(Archeon.createId("pointed_anhydrite"));
		GOLDEN_CLAY_PATCH.register(Archeon.createId("golden_clay_patch"));
		GOLDEN_CLAY_POOL.register(Archeon.createId("golden_clay_pool"));
		ACHREAN_MOSS_PATCH.register(Archeon.createId("achrean_moss_patch"));
		ACHREAN_MOSS_CEILING.register(Archeon.createId("achrean_moss_ceiling"));
		ACHREAN_GOLDEN_CLAY.register(Archeon.createId("achrean_golden_clay"));

		Predicate<BiomeSelectionContext> randomPatchPredicate = ctx -> !ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_PEAKS) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.UNDERGROUND_CAVES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES);

		Predicate<BiomeSelectionContext> inArcheonPredicate = ctx -> ctx.canGenerateIn(RegistryKey.of(Registry.DIMENSION_KEY, Archeon.createId("archeon")));

		Predicate<BiomeSelectionContext> criadanPredicate = ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.CRIADAN_VALLEYS);

		Predicate<BiomeSelectionContext> anhydritePredicate = ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ANHYDRITE_VALLEYS);

		Predicate<BiomeSelectionContext> achreanPredicate = ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ACHREAN_CAVES);

		BiomeModifications.addFeature(
			ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.SHORE) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("rocky_fields_rock"))
		);

		BiomeModifications.addFeature(
			inArcheonPredicate, GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("menhir"))
		);

		BiomeModifications.addFeature(
			ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_MEADOWS),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("hollow_cypress_log"))
		);

		PALM_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN));
		NECLANE_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.NECLANE_GROVE));
		NECLANE_TREE.addAdditionalToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS), "rocky_fields");
		CYPRESS_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS));
		PNEVENTIAL_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		STREIAN_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		ORIAN_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		VALE_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		ZIAL_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));

		PATCH_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_TALL_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_FLOWERED_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_FLOWERED_TALL_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_WET_FERN.addDefaultToBiomes(randomPatchPredicate);
		PATCH_TALL_WET_FERN.addDefaultToBiomes(randomPatchPredicate);
		PATCH_SOUTH_WHEAT.addDefaultToBiomes(randomPatchPredicate);
		PATCH_WET_GRASS_TUFFET.addDefaultToBiomes(randomPatchPredicate);

		PATCH_SNOWY_GRASS_TUFFET.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES));

		SUNSET_ORCHID_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ROSEYPIA_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		AEROLIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ASTEDIBES_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) && !ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		TWILIGHT_ROSE_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		PINK_LYCORIS_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		RED_LYCORIS_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ORANGE_LYCORIS_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) && !ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		ASCENDIA_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS));
		OEA_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS));
		IOPEA_FEATURE.addDefaultToBiomes(ctx -> randomPatchPredicate.test(ctx) && !ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		ORGANDEANE_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		SEPTICEOLIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);

		ARTEMNITE_PATCH.addDefaultToBiomes(inArcheonPredicate);
		CRIADAN_PATCH.addDefaultToBiomes(inArcheonPredicate);
		AKETITE_PATCH.addDefaultToBiomes(inArcheonPredicate);

		SALT_PATCH.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN));
		SHELLSAND_PATCH.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN));
		XETULIAN_SUGAR_CANE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN));

		APAFLORITE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		EXYRIANE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		FAELITE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		LUSONYTH_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);

		GLOWSHROOMS.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES));

		CRIADAN_CLUSTER.addDefaultToBiomes(criadanPredicate);
		LARGE_CRIADAN.addDefaultToBiomes(criadanPredicate);
		POINTED_CRIADAN.addDefaultToBiomes(criadanPredicate);

		ANHYDRITE_CLUSTER.addDefaultToBiomes(anhydritePredicate);
		LARGE_ANHYDRITE.addDefaultToBiomes(anhydritePredicate);
		POINTED_ANHYDRITE.addDefaultToBiomes(anhydritePredicate);

		ACHREAN_MOSS_PATCH.addDefaultToBiomes(achreanPredicate);
		ACHREAN_MOSS_CEILING.addDefaultToBiomes(achreanPredicate);
		ACHREAN_GOLDEN_CLAY.addDefaultToBiomes(achreanPredicate);
	}
}
