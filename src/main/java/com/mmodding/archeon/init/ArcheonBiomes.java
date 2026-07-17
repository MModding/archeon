package com.mmodding.archeon.init;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.worldgen.biome.ArcheonBiomesProvider;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;

import java.io.FileWriter;
import java.io.IOException;

public class ArcheonBiomes {

	public static final ArcheonBiomesProvider ARCHEON_BIOMES_PROVIDER = new ArcheonBiomesProvider();

	public static final RegistryKey<Biome> ABYSS_CAVES = of("abyss_caves");
	public static final RegistryKey<Biome> ACHREAN_CAVES = of("achrean_caves");
	public static final RegistryKey<Biome> ANHYDRITE_VALLEYS = of("anhydrite_valleys");
	public static final RegistryKey<Biome> COLD_VUXANCIA_FOREST = of("cold_vuxancia_forest");
	public static final RegistryKey<Biome> CRIADAN_VALLEYS = of("criadan_valleys");
	public static final RegistryKey<Biome> DUNE_OCEAN = of("dune_ocean");
	public static final RegistryKey<Biome> ROCKY_FIELDS = of("rocky_fields");
	public static final RegistryKey<Biome> NECLANE_GROVE = of("neclane_grove");
	public static final RegistryKey<Biome> NUME_SWAMP = of("nume_swamp");
	public static final RegistryKey<Biome> NYRETH_GLADE = of("nyreth_glade");
	public static final RegistryKey<Biome> SHORE = of("shore");
	public static final RegistryKey<Biome> SNOWY_VUXANCIA_FOREST = of("snowy_vuxancia_forest");
	public static final RegistryKey<Biome> SOUTH_MEADOWS = of("south_meadows");
	public static final RegistryKey<Biome> SOUTH_SNOWY_PEAKS = of("south_snowy_peaks");
	public static final RegistryKey<Biome> SOUTH_SNOWY_SLOPES = of("south_snowy_slopes");
	public static final RegistryKey<Biome> UNDERGROUND_CAVES = of("underground_caves");
	public static final RegistryKey<Biome> VUXANCIA_FOREST = of("vuxancia_forest");
	public static final RegistryKey<Biome> WARM_VUXANCIA_FOREST = of("warm_vuxancia_forest");

	private static RegistryKey<Biome> of(String path) {
		return RegistryKey.of(RegistryKeys.BIOME, Archeon.createId(path));
	}

	public static void register() {
		WorldUtils.addDifferedSeed(Archeon.createId("archeon"));
		ArcheonBiomes.writeArcheonProvider(BiomeSourceUtils.createMultiNoisePreset(Archeon.createId("biome_provider"), ARCHEON_BIOMES_PROVIDER), System.getProperty("archeon.provider-debug") != null);
	}

	@Debug
	public static void writeArcheonProvider(MultiNoiseBiomeSource.Preset preset, boolean enabled) {
		if (enabled) {
			ServerLevelEvents.LOAD.register((server, level) -> {
				if (level.getRegistryKey().equals(Archeon.DIMENSION_KEY)) {
					MultiNoiseBiomeSource source = preset.getBiomeSource(level.getRegistryManager().get(Registry.BIOME_KEY));
					DataResult<JsonElement> result = MultiNoiseBiomeSource.CUSTOM_CODEC.encoder().encodeStart(RegistryOps.create(JsonOps.INSTANCE, level.getRegistryManager().freeze()), source);
					try {
						JsonObject biomeSource = new JsonObject();
						biomeSource.addProperty("type", "minecraft:multi_noise");
						biomeSource.add("biomes", result.result().orElseThrow().getAsJsonObject().getAsJsonArray("biomes"));
						JsonObject generator = new JsonObject();
						generator.addProperty("type", "minecraft:noise");
						generator.addProperty("settings", "minecraft:overworld");
						generator.add("biome_source", biomeSource);
						JsonObject provider = new JsonObject();
						provider.addProperty("type", "minecraft:overworld");
						provider.add("generator", generator);
						FileWriter configWriter = new FileWriter(FabricLoader.getInstance().getGameDir().toString() + "/written-archeon-provider.json");
						String json = new GsonBuilder().setPrettyPrinting().create().toJson(provider);
						configWriter.write(json);
						configWriter.close();
						// Can then be pasted to https://misode.github.io/dimension/.
					} catch (IOException error) {
						throw new RuntimeException(error);
					}
				}
			});
		}
	}
}
