package com.mmodding.archeon.bootstrap.init;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.initializers.BootstrapElementsInitializer;
import com.mmodding.mmodding_lib.library.initializers.invokepoints.BootstrapInvokePoint;
import net.minecraft.block.ComposterBlock;

public class ArcheonCompostables implements BootstrapElementsInitializer {

	@Override
	public BootstrapInvokePoint getInvokePoint() {
		return BootstrapInvokePoint.after(BootstrapInvokePoint.Type.COMPOSTABLE_ITEMS);
	}

	@Override
	public void registerBootstrap() {
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.BUSH_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PALM_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.NECLANE_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.FLOWERED_NECLANE_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.CYPRESS_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.STREIAN_VUXANCIA_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ORIAN_VUXANCIA_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.VALE_VUXANCIA_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ZIAL_VUXANCIA_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ORIAN_VUXANCIA_LEAVES_CARPET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES_CARPET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.STREIAN_VUXANCIA_LEAVES_CARPET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.VALE_VUXANCIA_LEAVES_CARPET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ZIAL_VUXANCIA_LEAVES_CARPET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.NUME_WILLOW_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.NYRETH_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PALE_NYRETH_LEAVES, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PALM_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.NECLANE_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.CYPRESS_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PNEVENTIAL_VUXANCIA_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.STREIAN_VUXANCIA_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ORIAN_VUXANCIA_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.VALE_VUXANCIA_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ZIAL_VUXANCIA_SAPLING, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.WET_GRASS, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.TALL_WET_GRASS, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.FLOWERED_WET_GRASS, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.FLOWERED_TALL_WET_GRASS, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.WET_FERN, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.TALL_WET_FERN, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.WET_GRASS_TUFFET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.SNOWY_GRASS_TUFFET, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.SUNSET_ORCHID, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ROSEYPIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.AEROLIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ASTEDIBES, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.TWILIGHT_ROSE, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PINK_LYCORIS, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.RED_LYCORIS, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ORANGE_LYCORIS, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.OEA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.IOPEA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.TALL_IOPEA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ORGANDEANE_BLOSSOM, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.TALL_ORGANDEANE, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.SEPTICEOLIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.DOTTED_STOVIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.WILLS_OF_LIGHT, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ETERNAL_FORTUNES, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.BLUE_DOELDIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.WHITE_DOELDIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.PINK_DOELDIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.YELLOW_DOELDIA, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.SMALL_HOT_SPRING_LILY_PAD, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.HOT_SPRING_LILY_PAD, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.GIANT_LILY, 1.0f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonItems.PLANT_FIBER, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonItems.MOSS_BALL, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ACHREAN_MOSS, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ArcheonBlocks.ACHREAN_MOSS_BLOCK, 0.65f);
	}
}
