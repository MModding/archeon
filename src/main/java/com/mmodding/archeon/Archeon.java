package com.mmodding.archeon;

import com.mmodding.archeon.block.entity.ArcheonBlockEntities;
import com.mmodding.archeon.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import com.mmodding.mmodding_lib.library.config.Config;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Archeon implements ExtendedModInitializer {

	public static final RegistryKey<World> WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD, Archeon.createId("archeon"));

	@Nullable
	@Override
	public Config getConfig() {
		return new ArcheonConfig();
	}

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(ArcheonParticleTypes::register);
		manager.content(ArcheonBlocks::register);
		manager.content(ArcheonBlockEntities::register);
		manager.content(ArcheonItems::register);
		manager.content(ArcheonContentRegistries::register);
		manager.content(ArcheonEnchantments::register);
		manager.content(ArcheonFluids::register);
		manager.content(ArcheonEvents::register);
		manager.content(ArcheonItemGroups::register);
		manager.content(ArcheonScreenHandlers::register);
		manager.content(ArcheonNoiseRouter::register);
		manager.content(ArcheonChunkGeneratorSettings::register);
		manager.content(ArcheonBiomes::register);
		manager.content(ArcheonFeatures::register);
		manager.content(ArcheonSoundEvents::register);
		manager.content(ArcheonMiscellaneous::register);
	}

	@Override
	public void onInitialize(AdvancedContainer advancedContainer) {}

	public static String id() {
		return "archeon";
	}

	public static Identifier createId(String path) {
		return new Identifier(Archeon.id(), path);
	}
}
