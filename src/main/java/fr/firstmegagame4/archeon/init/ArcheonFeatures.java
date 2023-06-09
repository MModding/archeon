package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.worldgen.features.CustomFeature;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.worldgen.features.RockyFieldsRockFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

public class ArcheonFeatures implements ElementsInitializer {

	public static final CustomFeature<RockyFieldsRockFeature.Config> ROCKY_FIELDS_ROCK = new RockyFieldsRockFeature(RockyFieldsRockFeature.Config.CODEC);

	@Override
	public void register() {
		ROCKY_FIELDS_ROCK.register(Archeon.createId("rocky_fields_rock"));

		BiomeModifications.addFeature(
			ctx -> ctx.getBiomeKey().equals(ArcheonBiomes.ROCKY_FIELDS) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.VUXANCIA_FOREST) ||
				ctx.getBiomeKey().equals(ArcheonBiomes.MAGICAL_VUXANCIA_FOREST),
			GenerationStep.Feature.LOCAL_MODIFICATIONS,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Archeon.createId("rocky_fields_rock"))
		);
	}
}
