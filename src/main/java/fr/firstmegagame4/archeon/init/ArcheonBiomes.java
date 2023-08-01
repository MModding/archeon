package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.BiomeSourceUtils;
import com.mmodding.mmodding_lib.library.utils.BiomeUtils;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.worldgen.biomes.ArcheonBiomesProvider;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ArcheonBiomes implements ElementsInitializer {

	public static final ArcheonBiomesProvider ARCHEON_BIOMES_PROVIDER = new ArcheonBiomesProvider();

	public static final RegistryKey<Biome> ABYSS_CAVES = BiomeUtils.getBiomeKey(Archeon.createId("abyss_caves"));
	public static final RegistryKey<Biome> ANHYDRITE_VALLEYS = BiomeUtils.getBiomeKey(Archeon.createId("anhydrite_valleys"));
	public static final RegistryKey<Biome> DUNE_OCEAN = BiomeUtils.getBiomeKey(Archeon.createId("dune_ocean"));
	public static final RegistryKey<Biome> GYPSUM_VALLEYS = BiomeUtils.getBiomeKey(Archeon.createId("gypsum_valleys"));
	public static final RegistryKey<Biome> MAGICAL_VUXANCIA_FOREST = BiomeUtils.getBiomeKey(Archeon.createId("magical_vuxancia_forest"));
	public static final RegistryKey<Biome> NECLANE_GROVE = BiomeUtils.getBiomeKey(Archeon.createId("neclane_grove"));
	public static final RegistryKey<Biome> ROCKY_FIELDS = BiomeUtils.getBiomeKey(Archeon.createId("rocky_fields"));
	public static final RegistryKey<Biome> SOUTH_MEADOWS = BiomeUtils.getBiomeKey(Archeon.createId("south_meadows"));
	public static final RegistryKey<Biome> SOUTH_SNOWY_PEAKS = BiomeUtils.getBiomeKey(Archeon.createId("south_snowy_peaks"));
	public static final RegistryKey<Biome> SOUTH_SNOWY_SLOPES = BiomeUtils.getBiomeKey(Archeon.createId("south_snowy_slopes"));
	public static final RegistryKey<Biome> UNDERGROUND_CAVES = BiomeUtils.getBiomeKey(Archeon.createId("underground_caves"));
	public static final RegistryKey<Biome> VUXANCIA_FOREST = BiomeUtils.getBiomeKey(Archeon.createId("vuxancia_forest"));

	@Override
	public void register() {
		WorldUtils.addDifferedSeed(Archeon.createId("archeon"));
		BiomeSourceUtils.createMultiNoisePreset(Archeon.createId("biome_provider"), ARCHEON_BIOMES_PROVIDER);
	}
}
