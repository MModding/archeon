package com.mmodding.archeon;

import com.mmodding.archeon.block.entity.ArcheonBlockEntities;
import com.mmodding.archeon.resource.ArcheonFeaturePacks;
import com.mmodding.archeon.init.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class Archeon implements ExtendedModInitializer {

	public static final ResourceKey<Level> DIMENSION_KEY = ResourceKey.create(Registries.DIMENSION, Archeon.createId("archeon"));

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(ArcheonParticleTypes::register);
		manager.content(ArcheonBlocks::register);
		manager.content(ArcheonBlockEntities::register);
		manager.content(ArcheonItems::register);
		manager.content(ArcheonEntities::register);
		manager.content(ArcheonContentRegistries::register);
		manager.content(ArcheonEnchantments::register);
		manager.content(ArcheonFluids::register);
		manager.content(ArcheonEvents::register);
		manager.content(ArcheonItemGroups::register);
		manager.content(ArcheonScreenHandlers::register);
		manager.content(ArcheonNoiseRouter::register);
		manager.content(ArcheonChunkGeneratorSettings::register);
		manager.content(ArcheonBiomes::register);
		manager.content(ArcheonSoundEvents::register);
		manager.content(ArcheonMiscellaneous::register);
		manager.content(ArcheonTreeParts::register);
		manager.content(ArcheonFeatures::register);
		manager.resource(ArcheonFeaturePacks::registerConfiguredFeatures);
		manager.resource(ArcheonFeaturePacks::registerPlacedFeatures);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {}

	public static String namespace() {
		return "archeon";
	}

	public static Identifier createId(String path) {
		return new Identifier(Archeon.namespace(), path);
	}
}
