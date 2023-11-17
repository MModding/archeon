package fr.firstmegagame4.archeon;

import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingModInitializer;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.init.ArcheonEnchantments;
import fr.firstmegagame4.archeon.init.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Archeon implements MModdingModInitializer {

	public static final RegistryKey<World> WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, Archeon.createId("archeon"));

	@Nullable
	@Override
	public Config getConfig() {
		return new ArcheonConfig();
	}

	@Override
	public List<ElementsInitializer> getElementsInitializers() {
		List<ElementsInitializer> elementsInitializers = new ArrayList<>();
		elementsInitializers.add(new ArcheonBlocks());
		elementsInitializers.add(new ArcheonItems());
		elementsInitializers.add(new ArcheonEnchantments());
		elementsInitializers.add(new ArcheonFluids());
		elementsInitializers.add(new ArcheonEvents());
		elementsInitializers.add(new ArcheonItemGroups());
		elementsInitializers.add(new ArcheonScreenHandlers());
		elementsInitializers.add(new ArcheonChunkGeneratorSettings());
		elementsInitializers.add(new ArcheonBiomes());
		elementsInitializers.add(new ArcheonFeatures());
		elementsInitializers.add(new ArcheonEntities());
		elementsInitializers.add(new ArcheonSoundEvents());
		elementsInitializers.add(new ArcheonMiscellaneous());
		return elementsInitializers;
	}

	@Override
	public void onInitialize(AdvancedModContainer mod) {}

	public static String id() {
		return "archeon";
	}

	public static Identifier createId(String path) {
		return new Identifier(Archeon.id(), path);
	}
}
