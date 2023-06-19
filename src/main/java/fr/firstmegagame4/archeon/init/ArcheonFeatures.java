package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomFlowerFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomOreFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomRandomPatchFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomTreeFeature;
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
import net.minecraft.util.math.intprovider.ConstantIntProvider;
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

	public static final CustomTreeFeature NECLANE_TREE = new CustomTreeFeature(
		ArcheonBlocks.NECLANE_LOG,
		new NeclaneTrunkPlacer(4, 2, 0),
		ArcheonBlocks.NECLANE_LEAVES,
		new NeclaneFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(0, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).setGroundBlock(ArcheonBlocks.WET_DIRT).addPlacedFeature(
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS,
		"_rocky_fields"
	);

	public static final CustomTreeFeature CYPRESS_TREE = new CustomTreeFeature(
		ArcheonBlocks.CYPRESS_LOG,
		new StraightTrunkPlacer(4, 2, 0),
		ArcheonBlocks.CYPRESS_LEAVES,
		new CypressFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VUXANCIA_TREE_PNEVANTIAL = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VUXANCIA_LEAVES_PNEVANTIAL,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(new HangingLeavesTreeDecorator(), new SporeRootcapTreeDecorator()).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VUXANCIA_TREE_STREIAN = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VUXANCIA_LEAVES_STREIAN,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(new HangingLeavesTreeDecorator(), new SporeRootcapTreeDecorator()).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VUXANCIA_TREE_ORIAN = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VUXANCIA_LEAVES_ORIAN,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(new HangingLeavesTreeDecorator(), new SporeRootcapTreeDecorator()).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VUXANCIA_TREE_VALE = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VUXANCIA_LEAVES_VALE,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(new HangingLeavesTreeDecorator(), new SporeRootcapTreeDecorator()).setGroundBlock(ArcheonBlocks.WET_DIRT);

	public static final CustomTreeFeature VUXANCIA_TREE_ZIAL = new CustomTreeFeature(
		ArcheonBlocks.VUXANCIA_LOG,
		new VuxanciaTrunkPlacer(4, 2, 0),
		ArcheonBlocks.VUXANCIA_LEAVES_ZIAL,
		new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(3)),
		1, 0, 1,
		PlacedFeatureUtil.createCountExtraModifier(5, 0.1f, 1),
		ArcheonBlocks.WET_GRASS
	).addTreeDecorators(new HangingLeavesTreeDecorator(), new SporeRootcapTreeDecorator()).setGroundBlock(ArcheonBlocks.WET_DIRT);

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

	public static final RuleTest SOUTHSTONE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.SOUTHSTONE_ORES_REPLACEABLES);
	public static final RuleTest DEPTHS_AKETITE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonTags.DEPTHS_AKETITE_ORES_REPLACEABLES);

	public static final List<OreFeatureConfig.Target> APAFLORITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.APAFLORITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(DEPTHS_AKETITE_ORES_REPLACEABLES, ArcheonBlocks.DEPTHS_APAFLORITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> EXYRIANE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.EXYRIANE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(DEPTHS_AKETITE_ORES_REPLACEABLES, ArcheonBlocks.DEPTHS_EXYRIANE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> FAELITE_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.FAELITE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(DEPTHS_AKETITE_ORES_REPLACEABLES, ArcheonBlocks.DEPTHS_FAELITE_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> ARCHEON_COAL_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.SOUTHSTONE_COAL_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> ARCHEON_GOLD_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.SOUTHSTONE_GOLD_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(DEPTHS_AKETITE_ORES_REPLACEABLES, ArcheonBlocks.DEPTHS_AKETITE_GOLD_ORE.getDefaultState())
	);
	public static final List<OreFeatureConfig.Target> ARCHEON_EMERALD_ORE_TARGETS = List.of(
		OreFeatureConfig.createTarget(SOUTHSTONE_ORES_REPLACEABLES, ArcheonBlocks.SOUTHSTONE_EMERALD_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(DEPTHS_AKETITE_ORES_REPLACEABLES, ArcheonBlocks.DEPTHS_AKETITE_EMERALD_ORE.getDefaultState())
	);

	public static final CustomOreFeature APAFLORITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, APAFLORITE_ORE_TARGETS);
	public static final CustomOreFeature FAELITE_ORE_FEATURE = new CustomOreFeature(6, 5, -60, 45, FAELITE_ORE_TARGETS);
	public static final CustomOreFeature EXYRIANE_ORE_FEATURE = new CustomOreFeature(8, 7, -60, 45, EXYRIANE_ORE_TARGETS);
	public static final CustomOreFeature SOUTHSTONE_COAL_ORE_FEATURE = new CustomOreFeature(13, 7, -60, 80, ARCHEON_COAL_ORE_TARGETS);
	public static final CustomOreFeature SOUTHSTONE_GOLD_ORE_FEATURE = new CustomOreFeature(6, 3, -60, 30, ARCHEON_GOLD_ORE_TARGETS);
	public static final CustomOreFeature SOUTHSTONE_EMERALD_ORE_FEATURE = new CustomOreFeature(3, 4, -60, 40, ARCHEON_EMERALD_ORE_TARGETS);

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
		NECLANE_TREE.register(Archeon.createId("neclane_tree"));
		CYPRESS_TREE.register(Archeon.createId("cypress_tree"));
		VUXANCIA_TREE_PNEVANTIAL.register(Archeon.createId("vuxancia_tree_pnevantial"));
		VUXANCIA_TREE_STREIAN.register(Archeon.createId("vuxancia_tree_streian"));
		VUXANCIA_TREE_ORIAN.register(Archeon.createId("vuxancia_tree_orian"));
		VUXANCIA_TREE_VALE.register(Archeon.createId("vuxancia_tree_vale"));
		VUXANCIA_TREE_ZIAL.register(Archeon.createId("vuxancia_tree_zial"));
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
		SOUTHSTONE_EMERALD_ORE_FEATURE.register(Archeon.createId("southstone_emerald_ore_feature"));
		SOUTHSTONE_GOLD_ORE_FEATURE.register(Archeon.createId("southstone_gold_ore_feature"));
		SOUTHSTONE_COAL_ORE_FEATURE.register(Archeon.createId("southstone_coal_ore_feature"));
		FAELITE_ORE_FEATURE.register(Archeon.createId("faelite_ore_feature"));

		Predicate<BiomeSelectionContext> randomPatchPredicate = ctx -> !ctx.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_PEAKS) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.UNDERGROUND_CAVES) ||
			!ctx.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES);

		Predicate<BiomeSelectionContext> inArcheonPredicate = ctx -> ctx.canGenerateIn(RegistryKey.of(Registry.DIMENSION_KEY, Archeon.createId("archeon")));

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

		NECLANE_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.NECLANE_GROVE));
		NECLANE_TREE.addAdditionalToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS), "_rocky_fields");
		CYPRESS_TREE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS));
		VUXANCIA_TREE_PNEVANTIAL.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		VUXANCIA_TREE_STREIAN.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST));
		VUXANCIA_TREE_ORIAN.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		VUXANCIA_TREE_VALE.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));
		VUXANCIA_TREE_ZIAL.addDefaultToBiomes(ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST));

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
		SOUTHSTONE_COAL_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		SOUTHSTONE_GOLD_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
		SOUTHSTONE_EMERALD_ORE_FEATURE.addDefaultToBiomes(inArcheonPredicate);
	}
}
