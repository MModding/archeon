package com.mmodding.archeon.init;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.worldgen.biomes.ArcheonBiomesProvider;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.BiomeSourceUtils;
import com.mmodding.mmodding_lib.library.utils.BiomeUtils;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.util.annotation.Debug;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryOps;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.lifecycle.api.event.ServerWorldLoadEvents;

import java.io.FileWriter;
import java.io.IOException;

public class ArcheonBiomes implements ElementsInitializer {

	public static final ArcheonBiomesProvider ARCHEON_BIOMES_PROVIDER = new ArcheonBiomesProvider();

	public static final RegistryKey<Biome> ACHREAN_CAVES = BiomeUtils.getBiomeKey(Archeon.createId("achrean_caves"));
	public static final RegistryKey<Biome> ABYSS_CAVES = BiomeUtils.getBiomeKey(Archeon.createId("abyss_caves"));
	public static final RegistryKey<Biome> ANHYDRITE_VALLEYS = BiomeUtils.getBiomeKey(Archeon.createId("anhydrite_valleys"));
	public static final RegistryKey<Biome> DUNE_OCEAN = BiomeUtils.getBiomeKey(Archeon.createId("dune_ocean"));
	public static final RegistryKey<Biome> CRIADAN_VALLEYS = BiomeUtils.getBiomeKey(Archeon.createId("criadan_valleys"));
	public static final RegistryKey<Biome> MAGICAL_VUXANCIA_FOREST = BiomeUtils.getBiomeKey(Archeon.createId("magical_vuxancia_forest"));
	public static final RegistryKey<Biome> NECLANE_GROVE = BiomeUtils.getBiomeKey(Archeon.createId("neclane_grove"));
	public static final RegistryKey<Biome> ROCKY_FIELDS = BiomeUtils.getBiomeKey(Archeon.createId("rocky_fields"));
	public static final RegistryKey<Biome> NUME_SWAMP = BiomeUtils.getBiomeKey(Archeon.createId("nume_swamp"));
	public static final RegistryKey<Biome> NYRETH_GLADE = BiomeUtils.getBiomeKey(Archeon.createId("nyreth_glade"));
	public static final RegistryKey<Biome> SHORE = BiomeUtils.getBiomeKey(Archeon.createId("shore"));
	public static final RegistryKey<Biome> SOUTH_MEADOWS = BiomeUtils.getBiomeKey(Archeon.createId("south_meadows"));
	public static final RegistryKey<Biome> SOUTH_SNOWY_PEAKS = BiomeUtils.getBiomeKey(Archeon.createId("south_snowy_peaks"));
	public static final RegistryKey<Biome> SOUTH_SNOWY_SLOPES = BiomeUtils.getBiomeKey(Archeon.createId("south_snowy_slopes"));
	public static final RegistryKey<Biome> UNDERGROUND_CAVES = BiomeUtils.getBiomeKey(Archeon.createId("underground_caves"));
	public static final RegistryKey<Biome> VUXANCIA_FOREST = BiomeUtils.getBiomeKey(Archeon.createId("vuxancia_forest"));

	@Override
	public void register() {
		WorldUtils.addDifferedSeed(Archeon.createId("archeon"));
		ArcheonBiomes.writeArcheonProvider(BiomeSourceUtils.createMultiNoisePreset(Archeon.createId("biome_provider"), ARCHEON_BIOMES_PROVIDER), false);
	}

	@Debug
	public static void writeArcheonProvider(MultiNoiseBiomeSource.Preset preset, boolean enabled) {
		if (enabled) {
			ServerWorldLoadEvents.LOAD.register((server, world) -> {
				if (world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
					MultiNoiseBiomeSource source = preset.getBiomeSource(world.getRegistryManager().get(Registry.BIOME_KEY));
					DataResult<JsonElement> result = MultiNoiseBiomeSource.CUSTOM_CODEC.encoder().encodeStart(RegistryOps.create(JsonOps.INSTANCE, world.getRegistryManager().freeze()), source);
					try {
						JsonObject biomeSource = new JsonObject();
						biomeSource.addProperty("type", "minecraft:multi_noise");
						biomeSource.add("biomes", result.result().orElseThrow());
						JsonObject generator = new JsonObject();
						generator.addProperty("type", "minecraft:noise");
						generator.addProperty("settings", "minecraft:overworld");
						generator.add("biome_source", biomeSource);
						JsonObject provider = new JsonObject();
						provider.addProperty("type", "minecraft:overworld");
						provider.add("generator", generator);
						FileWriter configWriter = new FileWriter(QuiltLoader.getCacheDir().toString() + "/written-archeon-provider.json");
						String json = new GsonBuilder().setPrettyPrinting().create().toJson(provider);
						configWriter.write(json);
						configWriter.close();
					} catch (IOException error) {
						throw new RuntimeException(error);
					}
				}
			});
		}
	}
}
