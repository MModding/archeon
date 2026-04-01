package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.worldgen.feature.HollowCypressLogFeature;
import com.mmodding.archeon.worldgen.feature.MenhirFeature;
import com.mmodding.archeon.worldgen.feature.RockyFieldsRockFeature;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class ArcheonFeatures {

	public static final Feature<RockyFieldsRockFeature.Config> ROCKY_FIELDS_ROCK = new RockyFieldsRockFeature(RockyFieldsRockFeature.Config.CODEC);
	public static final Feature<MenhirFeature.Config> MENHIR = new MenhirFeature(MenhirFeature.Config.CODEC);
	public static final Feature<HollowCypressLogFeature.Config> HOLLOW_CYPRESS_LOG = new HollowCypressLogFeature(HollowCypressLogFeature.Config.CODEC);

	private static boolean isInArcheon(BiomeSelectionContext context) {
		return context.canGenerateIn(RegistryKey.of(RegistryKeys.DIMENSION, Archeon.createId("archeon")));
	}

	private static boolean randomPatchNoCold(BiomeSelectionContext context) {
		return isInArcheon(context)
			&& !context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN)
			&& !context.getBiomeKey().equals(ArcheonBiomes.SNOWY_VUXANCIA_FOREST)
			&& !context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST)
			&& !context.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES)
			&& !context.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_PEAKS)
			&& !context.getBiomeKey().equals(ArcheonBiomes.UNDERGROUND_CAVES)
			&& !context.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES);
	}

	private static boolean randomPatchNoColdNoDry(BiomeSelectionContext context) {
		return randomPatchNoCold(context)
			|| !context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN)
			|| !context.getBiomeKey().equals(ArcheonBiomes.SHORE);
	}

	private static boolean randomPatch(BiomeSelectionContext context) {
		return randomPatchNoCold(context) || context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST);
	}

	private static boolean magicalVuxancia(BiomeSelectionContext context) {
		return context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST)
			|| context.getBiomeKey().equals(ArcheonBiomes.SNOWY_VUXANCIA_FOREST)
			|| context.getBiomeKey().equals(ArcheonBiomes.WARM_VUXANCIA_FOREST);
	}

	private static boolean criadan(BiomeSelectionContext context) {
		return context.getBiomeKey().equals(ArcheonBiomes.CRIADAN_VALLEYS);
	}

	private static boolean anhydrite(BiomeSelectionContext context) {
		return context.getBiomeKey().equals(ArcheonBiomes.ANHYDRITE_VALLEYS);
	}

	private static boolean achrean(BiomeSelectionContext context) {
		return context.getBiomeKey().equals(ArcheonBiomes.ACHREAN_CAVES);
	}

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.FEATURE, factory -> {
			factory.register("rocky_fields_rock", ROCKY_FIELDS_ROCK);
			factory.register("menhir", MENHIR);
			factory.register("hollow_cypress_log", HOLLOW_CYPRESS_LOG);
		});

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.SHORE) ||
				context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				magicalVuxancia(context),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			ArcheonPlacedFeatures.ROCKY_FIELDS_ROCK
		);

		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.LOCAL_MODIFICATIONS, ArcheonPlacedFeatures.MENHIR);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				context.getBiomeKey().equals(ArcheonBiomes.WARM_VUXANCIA_FOREST) ||
				context.getBiomeKey().equals(ArcheonBiomes.SOUTH_MEADOWS),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			ArcheonPlacedFeatures.HOLLOW_CYPRESS_LOG
		);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PALM_TREE
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.NECLANE_GROVE),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.NECLANE_TREE
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.ROCKY_FIELDS_NECLANE_TREE
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.CYPRESS_TREE
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PNEVENTIAL_VUXANCIA_TREE
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.STREIAN_VUXANCIA_TREE
		);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.ORIAN_VUXANCIA_TREE);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.VALE_VUXANCIA_TREE);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.ZIAL_VUXANCIA_TREE);

		BiomeModifications.addFeature(ArcheonFeatures::randomPatch, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_WET_GRASS);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatch, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_TALL_WET_GRASS);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_FLOWERED_WET_GRASS);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_FLOWERED_TALL_WET_GRASS);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.COLD_PATCH_FLOWERED_WET_GRASS
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.COLD_PATCH_FLOWERED_TALL_WET_GRASS
		);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatch, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_WET_FERN);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatch, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_TALL_WET_FERN);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatch, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_WET_GRASS_TUFFET);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_SLOPES)
			|| context.getBiomeKey().equals(ArcheonBiomes.SOUTH_SNOWY_PEAKS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_SNOWY_GRASS_TUFFET
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.SNOWY_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.FOREST_PATCH_SNOWY_GRASS_TUFFET
		);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_SOUTH_WHEAT);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_PNEVENTIAL_VUXANCIA_LEAVES
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_STREIAN_VUXANCIA_LEAVES
		);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia,	GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_ORIAN_VUXANCIA_LEAVES);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia,	GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_VALE_VUXANCIA_LEAVES);
		BiomeModifications.addFeature(ArcheonFeatures::magicalVuxancia,	GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_ZIAL_VUXANCIA_LEAVES);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) || magicalVuxancia(context),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.VUXANCIA_POUND
		);

		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoColdNoDry, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_BUSH);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoColdNoDry, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_VINE);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoColdNoDry, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_BLOOD_ORANGE_BUSH);

		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.TOP_LAYER_MODIFICATION, ArcheonPlacedFeatures.PEAKS_SNOW);

		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_SUNSET_ORCHID);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.WARM_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_ROSEYPIA
		);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_AEROLIA);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST)
				|| !context.getBiomeKey().equals(ArcheonBiomes.WARM_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_ASTEDIBES
		);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_TWILIGHT_ROSE);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_PINK_LYCORIS);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_RED_LYCORIS);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.NECLANE_GROVE)
				|| !context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS)
				|| !context.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_ORANGE_LYCORIS
		);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.SOUTH_MEADOWS)
				|| !context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_ASCENDIA
		);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_OEA
		);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.WARM_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_IOPEA
		);
		BiomeModifications.addFeature(ArcheonFeatures::randomPatchNoCold, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.PATCH_ORGANDEANE);
		BiomeModifications.addFeature(
			context -> randomPatchNoCold(context)
				|| !context.getBiomeKey().equals(ArcheonBiomes.SOUTH_MEADOWS),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_SEPTICEOLIA
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_WHITE_DOELDIA
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.COLD_VUXANCIA_FOREST),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_YELLOW_DOELDIA
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.PATCH_XETULIAN_SUGAR_CANE
		);

		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_ARTEMNITE);
		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_CRIADAN);
		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_AKETITE);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN),
			GenerationStep.Feature.UNDERGROUND_ORES,
			ArcheonPlacedFeatures.ORE_SALT
		);
		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.DUNE_OCEAN),
			GenerationStep.Feature.UNDERGROUND_ORES,
			ArcheonPlacedFeatures.ORE_SHELLSAND
		);

		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_APAFLORITE);
		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_EXYRIANE);
		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_FAELITE);
		BiomeModifications.addFeature(ArcheonFeatures::isInArcheon, GenerationStep.Feature.UNDERGROUND_ORES, ArcheonPlacedFeatures.ORE_LUSONYTH);

		BiomeModifications.addFeature(
			context -> context.getBiomeKey().equals(ArcheonBiomes.ABYSS_CAVES),
			GenerationStep.Feature.VEGETAL_DECORATION,
			ArcheonPlacedFeatures.GLOWSHROOMS
		);

		BiomeModifications.addFeature(ArcheonFeatures::criadan, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.CRIADAN_CLUSTER);
		BiomeModifications.addFeature(ArcheonFeatures::criadan, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.LARGE_CRIADAN);
		BiomeModifications.addFeature(ArcheonFeatures::criadan, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.SMALL_CRIADAN);

		BiomeModifications.addFeature(ArcheonFeatures::anhydrite, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.ANHYDRITE_CLUSTER);
		BiomeModifications.addFeature(ArcheonFeatures::anhydrite, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.LARGE_ANHYDRITE);
		BiomeModifications.addFeature(ArcheonFeatures::anhydrite, GenerationStep.Feature.UNDERGROUND_DECORATION, ArcheonPlacedFeatures.SMALL_ANHYDRITE);

		BiomeModifications.addFeature(ArcheonFeatures::achrean, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.ACHREAN_GOLDEN_CLAY);
		BiomeModifications.addFeature(ArcheonFeatures::achrean, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.ACHREAN_MOSS_PATCH);
		BiomeModifications.addFeature(ArcheonFeatures::achrean, GenerationStep.Feature.VEGETAL_DECORATION, ArcheonPlacedFeatures.ACHREAN_MOSS_CEILING);
	}
}
