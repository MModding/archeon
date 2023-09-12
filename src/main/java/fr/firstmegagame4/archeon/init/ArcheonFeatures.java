package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.*;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTrunkPlacer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.worldgen.features.MenhirFeature;
import fr.firstmegagame4.archeon.worldgen.features.RockyFieldsRockFeature;
import fr.firstmegagame4.archeon.worldgen.features.trees.decorators.HangingLeavesTreeDecorator;
import fr.firstmegagame4.archeon.worldgen.features.trees.decorators.SporeRootcapTreeDecorator;
import fr.firstmegagame4.archeon.worldgen.features.trees.foliage.CypressFoliagePlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.foliage.NeclaneFoliagePlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.foliage.PalmFoliagePlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.foliage.VuxanciaFoliagePlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.trunk.NeclaneTrunkPlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.trunk.PalmTrunkPlacer;
import fr.firstmegagame4.archeon.worldgen.features.trees.trunk.VuxanciaTrunkPlacer;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Pair;
import net.minecraft.util.math.floatprovider.ClampedNormalFloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.ClampedNormalIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
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

	public static final CustomTreeFeature PALM_TREE = new CustomTreeFeature(
		ArcheonBlocks.PALM_LOG,
		new PalmTrunkPlacer(6, 3, 0),
		ArcheonBlocks.PALM_LEAVES,
		new PalmFoliagePlacer(ConstantIntProvider.create(6), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(1, 0.1f, 1),
		ArcheonBlocks.COKIPLANT
	).setGroundBlock(ArcheonBlocks.DUNE_SAND);

	public static final CustomTreeFeature NECLANE_TREE = new CustomTreeFeature(
		ArcheonBlocks.NECLANE_LOG,
		new NeclaneTrunkPlacer(4, 2, 0),
		ArcheonBlocks.NECLANE_LEAVES,
		new NeclaneFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(2, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).setGroundBlock(ArcheonBlocks.WET_DIRT).addPlacedFeature(
		PlacedFeatureUtil.createCountExtraModifier(3, 0.1f, 1),
		ArcheonBlocks.WET_GRASS,
		"rocky_fields"
	);

	public static final CustomTreeFeature CYPRESS_TREE = new CustomTreeFeature(
		ArcheonBlocks.CYPRESS_LOG,
		new StraightTrunkPlacer(4, 2, 0),
		ArcheonBlocks.CYPRESS_LEAVES,
		new CypressFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(3, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature PNEVANTIAL_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.PNEVANTIAL_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature STREIAN_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.STREIAN_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature ORIAN_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.ORIAN_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VALE_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VALE_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature ZIAL_VUXANCIA_TREE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.ZIAL_VUXANCIA_LEAVES,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomRandomPatchFeature PATCH_WET_GRASS = new CustomRandomPatchFeature(50, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_GRASS)))).setCount(10);
	public static final CustomRandomPatchFeature PATCH_TALL_WET_GRASS = new CustomRandomPatchFeature(30, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_WET_GRASS)))).setCount(7);
	public static final CustomRandomPatchFeature PATCH_WET_FERN = new CustomRandomPatchFeature(40, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_FERN)))).setRarity(6);
	public static final CustomRandomPatchFeature PATCH_TALL_WET_FERN = new CustomRandomPatchFeature(50, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_WET_FERN)))).setRarity(7);
	public static final CustomRandomPatchFeature PATCH_SOUTH_WHEAT = new CustomRandomPatchFeature(40, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.SOUTH_WHEAT)))).setRarity(5);
	public static final CustomRandomPatchFeature PATCH_TALL_SOUTH_WHEAT = new CustomRandomPatchFeature(30, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_SOUTH_WHEAT)))).setRarity(5);

	public static final CustomRandomPatchFeature PATCH_SNOWY_GRASS_TUFFET = new CustomRandomPatchFeature(20, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.SNOWY_GRASS_TUFFET)))).setCount(7);

	public static final CustomFlowerFeature ORCHID_FEATURE = new CustomFlowerFeature(64, 7, 3,
		ArcheonBlocks.SUNSET_ORCHID).setRarity(5);
	public static final CustomFlowerFeature ROSEYPIA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.ROSEYPIA).setRarity(2);
	public static final CustomFlowerFeature AEROLIA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.AEROLIA).setRarity(2);
	public static final CustomFlowerFeature ASTEDIBES_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.ASTEDIBES).setRarity(2);
	public static final CustomFlowerFeature TWILIGHT_ROSE_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.TWILIGHT_ROSE).setRarity(2);
	public static final CustomFlowerFeature LYCORIS_RADIATA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.LYCORIS_RADIATA).setRarity(2);
	public static final CustomFlowerFeature RED_LYCORIS_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.RED_LYCORIS).setRarity(2);
	public static final CustomFlowerFeature LYCORIS_SANGUINEA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.LYCORIS_SANGUINEA).setRarity(2);
	public static final CustomFlowerFeature ASCENDIA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.ASCENDIA).setRarity(2);
	public static final CustomFlowerFeature OEA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.OEA).setRarity(2);
	public static final CustomFlowerFeature IOPEA_FEATURE = new CustomFlowerFeature(8, 12, 6,
		List.of(new Pair<>(ArcheonBlocks.IOPEA, 3), new Pair<>(ArcheonBlocks.TALL_IOPEA, 1))).setRarity(2);
	public static final CustomFlowerFeature ORGANDEANE_FEATURE = new CustomFlowerFeature(8, 12, 6,
		List.of(new Pair<>(ArcheonBlocks.ORGANDEANE_BLOSSOM, 3), new Pair<>(ArcheonBlocks.ORGANDEANE_TALL, 1))).setRarity(2);
	public static final CustomFlowerFeature SEPTICEOLIA_FEATURE = new CustomFlowerFeature(8, 7, 3,
		ArcheonBlocks.SEPTICEOLIA).setRarity(2);

	public static final RuleTest SOUTHSTONE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.Blocks.SOUTHSTONE_ORES_REPLACEABLES);
	public static final RuleTest PHOSNOR_SLATE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.Blocks.PHOSNOR_SLATE_ORES_REPLACEABLES);

	public static final List<OreFeatureConfig.Target> APAFLORITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.APAFLORITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> EXYRIANE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.EXYRIANE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_EXYRIANE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> FAELITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.FAELITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_FAELITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> LUSONYTH_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.LUSONYTH_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_LUSONYTH_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> ARCHEON_COAL_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.SOUTHSTONE_COAL_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_COAL_ORE.getDefaultState())
	);

	public static final CustomOreFeature APAFLORITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, APAFLORITE_ORE_TARGETS);
	public static final CustomOreFeature EXYRIANE_ORE_FEATURE = new CustomOreFeature(8, 7, -60, 45, EXYRIANE_ORE_TARGETS);
	public static final CustomOreFeature FAELITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, FAELITE_ORE_TARGETS);
	public static final CustomOreFeature LUSONYTH_ORE_FEATURE = new CustomOreFeature(6, 3, -60, 0, LUSONYTH_ORE_TARGETS, 0.75f);
	public static final CustomOreFeature COAL_ORE_FEATURE = new CustomOreFeature(13, 7, -60, 80, ARCHEON_COAL_ORE_TARGETS);

	public static final CustomDripstoneClusterFeature GYPSUM_CLUSTER = new CustomDripstoneClusterFeature(
		ArcheonBlocks.POINTED_GYPSUM,
		ArcheonBlocks.GYPSUM,
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

	public static final CustomLargeDripstoneFeature LARGE_GYPSUM = new CustomLargeDripstoneFeature(
		ArcheonBlocks.GYPSUM,
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

	public static final CustomPointedDripstoneFeature POINTED_GYPSUM = new CustomPointedDripstoneFeature(
		ArcheonBlocks.POINTED_GYPSUM,
		ArcheonBlocks.GYPSUM,
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
		PALM_TREE.register(Archeon.createId("palm_tree"));
		NECLANE_TREE.register(Archeon.createId("neclane_tree"));
		CYPRESS_TREE.register(Archeon.createId("cypress_tree"));
		PNEVANTIAL_VUXANCIA_TREE.register(Archeon.createId("pnevantial_vuxancia_tree"));
		STREIAN_VUXANCIA_TREE.register(Archeon.createId("streian_vuxancia_tree"));
		ORIAN_VUXANCIA_TREE.register(Archeon.createId("orian_vuxancia_tree"));
		VALE_VUXANCIA_TREE.register(Archeon.createId("vale_vuxancia_tree"));
		ZIAL_VUXANCIA_TREE.register(Archeon.createId("zial_vuxancia_tree"));
		PATCH_WET_GRASS.register(Archeon.createId("patch_wet_grass"));
		PATCH_TALL_WET_GRASS.register(Archeon.createId("patch_tall_wet_grass"));
		PATCH_WET_FERN.register(Archeon.createId("path_wet_fern"));
		PATCH_TALL_WET_FERN.register(Archeon.createId("patch_tall_wet_fern"));
		PATCH_SOUTH_WHEAT.register(Archeon.createId("patch_south_wheat"));
		PATCH_TALL_SOUTH_WHEAT.register(Archeon.createId("patch_tall_south_wheat"));
		PATCH_SNOWY_GRASS_TUFFET.register(Archeon.createId("patch_snowy_grass_tuffet"));
		ORCHID_FEATURE.register(Archeon.createId("orchid_feature"));
		ROSEYPIA_FEATURE.register(Archeon.createId("roseypia_feature"));
		AEROLIA_FEATURE.register(Archeon.createId("aerolia_feature"));
		ASTEDIBES_FEATURE.register(Archeon.createId("astedibes_feature"));
		TWILIGHT_ROSE_FEATURE.register(Archeon.createId("twilight_rose_feature"));
		LYCORIS_RADIATA_FEATURE.register(Archeon.createId("lycoris_radiata_feature"));
		RED_LYCORIS_FEATURE.register(Archeon.createId("red_lycoris_feature"));
		LYCORIS_SANGUINEA_FEATURE.register(Archeon.createId("lycoris_sanguinea_feature"));
		ASCENDIA_FEATURE.register(Archeon.createId("ascendia_feature"));
		OEA_FEATURE.register(Archeon.createId("oea_feature"));
		IOPEA_FEATURE.register(Archeon.createId("iopea_feature"));
		ORGANDEANE_FEATURE.register(Archeon.createId("organdeane_feature"));
		SEPTICEOLIA_FEATURE.register(Archeon.createId("septiceolia_feature"));
		APAFLORITE_ORE_FEATURE.register(Archeon.createId("apaflorite_ore_feature"));
		EXYRIANE_ORE_FEATURE.register(Archeon.createId("exyriane_ore_feature"));
		FAELITE_ORE_FEATURE.register(Archeon.createId("faelite_ore_feature"));
		LUSONYTH_ORE_FEATURE.register(Archeon.createId("lusonyth_ore_feature"));
		COAL_ORE_FEATURE.register(Archeon.createId("coal_ore_feature"));
		GYPSUM_CLUSTER.register(Archeon.createId("gypsum_cluster"));
		LARGE_GYPSUM.register(Archeon.createId("large_gypsum"));
		POINTED_GYPSUM.register(Archeon.createId("pointed_gypsum"));
		ANHYDRITE_CLUSTER.register(Archeon.createId("anhydrite_cluster"));
		LARGE_ANHYDRITE.register(Archeon.createId("large_anhydrite"));
		POINTED_ANHYDRITE.register(Archeon.createId("pointed_anhydrite"));

		Predicate<BiomeSelectionContext> randomPatchPredicate = ctx -> !ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_PEAKS) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.UNDERGROUND_CAVES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES);

		Predicate<BiomeSelectionContext> inArcheonPredicate = ctx -> ctx.canGenerateIn(RegistryKey.of(Registry.DIMENSION_KEY, Archeon.createId("archeon")));

		Predicate<BiomeSelectionContext> gypsumPredicate = ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.GYPSUM_VALLEYS);

		Predicate<BiomeSelectionContext> anhydritePredicate = ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ANHYDRITE_VALLEYS);

		BiomeModifications.addFeature(
			ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("rocky_fields_rock"))
		);

		BiomeModifications.addFeature(
			inArcheonPredicate, GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("menhir"))
		);

		PALM_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN));
		NECLANE_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.NECLANE_GROVE));
		NECLANE_TREE.addAdditionalToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS), "rocky_fields");
		CYPRESS_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS));
		PNEVANTIAL_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		STREIAN_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		ORIAN_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		VALE_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		ZIAL_VUXANCIA_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));

		PATCH_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_TALL_WET_GRASS.addDefaultToBiomes(randomPatchPredicate);
		PATCH_WET_FERN.addDefaultToBiomes(randomPatchPredicate);
		PATCH_TALL_WET_FERN.addDefaultToBiomes(randomPatchPredicate);
		PATCH_SOUTH_WHEAT.addDefaultToBiomes(randomPatchPredicate);
		PATCH_TALL_SOUTH_WHEAT.addDefaultToBiomes(randomPatchPredicate);

		PATCH_SNOWY_GRASS_TUFFET.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES));

		ORCHID_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ROSEYPIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		AEROLIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ASTEDIBES_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		TWILIGHT_ROSE_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		LYCORIS_RADIATA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		RED_LYCORIS_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		LYCORIS_SANGUINEA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ASCENDIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		OEA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		IOPEA_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		ORGANDEANE_FEATURE.addDefaultToBiomes(randomPatchPredicate);
		SEPTICEOLIA_FEATURE.addDefaultToBiomes(randomPatchPredicate);

		APAFLORITE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		EXYRIANE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		FAELITE_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		LUSONYTH_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		COAL_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);

		GYPSUM_CLUSTER.addDefaultToBiomes(gypsumPredicate);
		LARGE_GYPSUM.addDefaultToBiomes(gypsumPredicate);
		POINTED_GYPSUM.addDefaultToBiomes(gypsumPredicate);

		ANHYDRITE_CLUSTER.addDefaultToBiomes(anhydritePredicate);
		LARGE_ANHYDRITE.addDefaultToBiomes(anhydritePredicate);
		POINTED_ANHYDRITE.addDefaultToBiomes(anhydritePredicate);
	}
}
