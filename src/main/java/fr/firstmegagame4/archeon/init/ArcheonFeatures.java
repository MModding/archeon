package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomOreFeature;
import com.mmodding.mmodding_lib.library.worldgen.features.defaults.CustomRandomPatchFeature;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.worldgen.features.MenhirFeature;
import fr.firstmegagame4.archeon.worldgen.features.RockyFieldsRockFeature;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectionContext;

import java.util.List;
import java.util.function.Predicate;

public class ArcheonFeatures implements ElementsInitializer {

	public static final AdvancedFeature<RockyFieldsRockFeature.Config> ROCKY_FIELDS_ROCK = new RockyFieldsRockFeature(RockyFieldsRockFeature.Config.CODEC);
	public static final AdvancedFeature<MenhirFeature.Config> MENHIR = new MenhirFeature(MenhirFeature.Config.CODEC);

	public static final CustomRandomPatchFeature PATCH_WET_GRASS = new CustomRandomPatchFeature(5, 32, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.WET_GRASS))));
	public static final CustomRandomPatchFeature PATCH_TALL_WET_GRASS = new CustomRandomPatchFeature(32, 96, 7, 3,
		PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ArcheonBlocks.TALL_WET_GRASS))));

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
		ROCKY_FIELDS_ROCK.register(Archeon.createId("rocky_fields_rock"));
		MENHIR.register(Archeon.createId("menhir"));
		PATCH_WET_GRASS.register(Archeon.createId("patch_wet_grass"));
		PATCH_TALL_WET_GRASS.hasRarity();
		PATCH_TALL_WET_GRASS.register(Archeon.createId("patch_tall_wet_grass"));
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

		PATCH_WET_GRASS.addToBiomes(randomPatchPredicate);
		PATCH_TALL_WET_GRASS.addToBiomes(randomPatchPredicate);

		APAFLORITE_ORE_FEATURE.addToBiomes(inArcheonPredicate);
		EXYRIANE_ORE_FEATURE.addToBiomes(inArcheonPredicate);
		FAELITE_ORE_FEATURE.addToBiomes(inArcheonPredicate);
		SOUTHSTONE_COAL_ORE_FEATURE.addToBiomes(inArcheonPredicate);
		SOUTHSTONE_GOLD_ORE_FEATURE.addToBiomes(inArcheonPredicate);
		SOUTHSTONE_EMERALD_ORE_FEATURE.addToBiomes(inArcheonPredicate);
	}
}
