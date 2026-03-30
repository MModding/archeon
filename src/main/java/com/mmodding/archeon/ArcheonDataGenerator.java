package com.mmodding.archeon;

import com.mmodding.archeon.init.ArcheonBlockTags;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.management.DataManager;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ArcheonDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.data();
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer mod, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {
		pack.addProvider(ArcheonBlockTagProvider::new);
	}

	private static class ArcheonBlockTagProvider extends FabricTagProvider.BlockTagProvider {

		public ArcheonBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
			super(output, future);
		}

		@Override
		protected void configure(RegistryWrapper.WrapperLookup lookup) {
			this.getOrCreateTagBuilder(ArcheonBlockTags.ACHREAN_CAVES_PLACEABLE)
				.addTag(ArcheonBlockTags.SOIL)
				.add(ArcheonBlocks.ACHREAN_MOSS_BLOCK);
		}
	}
}
