package fr.firstmegagame4.archeon.worldgen.biomes;

import com.mmodding.mmodding_lib.library.utils.BiomeSourceUtils;
import com.mmodding.mmodding_lib.library.worldgen.AdvancedBiomeProvider;
import com.mojang.datafixers.util.Pair;
import fr.firstmegagame4.archeon.init.ArcheonBiomes;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.function.Consumer;

public class ArcheonBiomesProvider implements AdvancedBiomeProvider {

	@Override
	public RegistryKey<Biome>[][] offCoastBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE}
		};
	}

	@Override
	public RegistryKey<Biome>[][] oceanBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN},
			{ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN}
		};
	}

	@Override
	public RegistryKey<Biome>[][] middleBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE},
			{ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.NECLANE_GROVE, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS}
		};
	}

	@Override
	public RegistryKey<Biome>[][] middleBiomesVariant() {
		return new RegistryKey[][] {
			{null, null, null, null, null},
			{null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, null, null, null}
		};
	}

	@Override
	public RegistryKey<Biome>[] hotBiomes() {
		return new RegistryKey[] {ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST};
	}

	@Override
	public RegistryKey<Biome>[] hotBiomesVariant() {
		return new RegistryKey[] {ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST};
	}

	@Override
	public RegistryKey<Biome>[][] peakBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS},
			{ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS, ArcheonBiomes.SOUTH_SNOWY_PEAKS},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS}
		};
	}

	@Override
	public RegistryKey<Biome>[][] peakBiomesVariant() {
		return new RegistryKey[][] {
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null}
		};
	}

	@Override
	public RegistryKey<Biome>[][] plateauBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS},
			{ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.SOUTH_MEADOWS, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST, ArcheonBiomes.VUXANCIA_FOREST},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS}
		};
	}

	@Override
	public RegistryKey<Biome>[][] plateauBiomesVariant() {
		return new RegistryKey[][] {
			{null, null, null, null, null},
			{null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST, ArcheonBiomes.MAGICAL_VUXANCIA_FOREST},
			{null, null, null, null, null}
		};
	}

	@Override
	public RegistryKey<Biome>[][] slopeBiomes() {
		return new RegistryKey[][] {
			{ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES},
			{ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES, ArcheonBiomes.SOUTH_SNOWY_SLOPES},
			{ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS, ArcheonBiomes.ROCKY_FIELDS}
		};
	}

	@Override
	public RegistryKey<Biome>[][] windsweptBiomes() {
		return new RegistryKey[][] {
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null}
		};
	}

	@Override
	public RegistryKey<Biome>[] beachBiomes() {
		return new RegistryKey[] {ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN, ArcheonBiomes.DUNE_OCEAN};
	}

	@Override
	public void provideUnderground(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters) {
		parameters.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(
			this.fullRange(),
			this.fullRange(),
			this.fullRange(),
			this.fullRange(),
			MultiNoiseUtil.ParameterRange.of(0.2f, 0.7f),
			this.fullRange(),
			0.0f
		), ArcheonBiomes.UNDERGROUND_CAVES));
		parameters.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(
			this.fullRange(),
			this.fullRange(),
			this.fullRange(),
			this.fullRange(),
			MultiNoiseUtil.ParameterRange.of(0.7f, 1.1f),
			this.fullRange(),
			0.0f
		), ArcheonBiomes.ABYSS_CAVES));
	}

	@Override
	public void provideValleys(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange weirdness) {
		BiomeSourceUtils.addSurfaceBiomeTo(
			parameters, this.fullRange(), this.fullRange(), this.coastContinentalness(),
			MultiNoiseUtil.ParameterRange.combine(this.erosions()[0], this.erosions()[1]),
			weirdness, 0.0F, weirdness.max() < 0L ? ArcheonBiomes.ROCKY_FIELDS : ArcheonBiomes.DUNE_OCEAN
		);
		BiomeSourceUtils.addSurfaceBiomeTo(
			parameters, this.fullRange(), this.fullRange(), this.nearInlandContinentalness(),
			MultiNoiseUtil.ParameterRange.combine(this.erosions()[0], this.erosions()[1]),
			weirdness, 0.0F, ArcheonBiomes.DUNE_OCEAN
		);
		BiomeSourceUtils.addSurfaceBiomeTo(
			parameters, this.fullRange(), this.fullRange(),
			MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness(), this.farInlandContinentalness()),
			MultiNoiseUtil.ParameterRange.combine(this.erosions()[2], this.erosions()[5]),
			weirdness, 0.0F, ArcheonBiomes.DUNE_OCEAN
		);
		BiomeSourceUtils.addSurfaceBiomeTo(
			parameters, this.fullRange(), this.fullRange(),
			this.coastContinentalness(), this.erosions()[6],
			weirdness, 0.0F, ArcheonBiomes.DUNE_OCEAN
		);
		AdvancedBiomeProvider.super.provideValleys(parameters, weirdness);
	}
}
