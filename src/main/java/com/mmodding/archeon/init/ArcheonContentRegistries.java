package com.mmodding.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ArcheonContentRegistries implements ElementsInitializer {

	@Override
	public void register() {
		StrippableBlockRegistry.register(ArcheonBlocks.PALM_WOOD, ArcheonBlocks.STRIPPED_PALM_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.PALM_LOG, ArcheonBlocks.STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(ArcheonBlocks.NECLANE_WOOD, ArcheonBlocks.STRIPPED_NECLANE_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.NECLANE_LOG, ArcheonBlocks.STRIPPED_NECLANE_LOG);
		StrippableBlockRegistry.register(ArcheonBlocks.CYPRESS_WOOD, ArcheonBlocks.STRIPPED_CYPRESS_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.CYPRESS_LOG, ArcheonBlocks.STRIPPED_CYPRESS_LOG);
		StrippableBlockRegistry.register(ArcheonBlocks.VUXANCIA_WOOD, ArcheonBlocks.STRIPPED_VUXANCIA_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.VUXANCIA_LOG, ArcheonBlocks.STRIPPED_VUXANCIA_LOG);
		StrippableBlockRegistry.register(ArcheonBlocks.NUME_WILLOW_WOOD, ArcheonBlocks.STRIPPED_NUME_WILLOW_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.NUME_WILLOW_LOG, ArcheonBlocks.STRIPPED_NUME_WILLOW_LOG);
		StrippableBlockRegistry.register(ArcheonBlocks.NYRETH_WOOD, ArcheonBlocks.STRIPPED_NYRETH_WOOD);
		StrippableBlockRegistry.register(ArcheonBlocks.NYRETH_LOG, ArcheonBlocks.STRIPPED_NYRETH_LOG);
		FuelRegistry.INSTANCE.add(ArcheonItems.EXYRIANE_SHARD, 1600);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.EXYRIANE_BLOCK.getItem(), 16000);
		FuelRegistry.INSTANCE.add(ArcheonTags.Items.PLANKS, 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.PALM_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NECLANE_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.CYPRESS_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.VUXANCIA_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NUME_WILLOW_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NYRETH_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.PALM_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NECLANE_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.CYPRESS_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.VUXANCIA_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NUME_WILLOW_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.NYRETH_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_PALM_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NECLANE_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_CYPRESS_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_VUXANCIA_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NUME_WILLOW_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NYRETH_LOG.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_PALM_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NECLANE_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_CYPRESS_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_VUXANCIA_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NUME_WILLOW_WOOD.getItem(), 300);
		FuelRegistry.INSTANCE.add(ArcheonBlocks.STRIPPED_NYRETH_WOOD.getItem(), 300);
	}
}
