package com.mmodding.archeon.client.init;

import com.mmodding.archeon.fluids.HotSpringWaterFluid;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;

public class ArcheonColorProviders implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> {
				if (world != null && pos != null) {
					return BiomeColors.getGrassColor(world, state.get(TallPlantBlock.HALF) == DoubleBlockHalf.UPPER ? pos.down() : pos);
				}
				else {
					return -1;
				}
			},
			ArcheonBlocks.TALL_WET_GRASS,
			ArcheonBlocks.TALL_WET_FERN,
			ArcheonBlocks.FLOWERED_TALL_WET_GRASS
		);
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> {
				if (world != null && pos != null) {
					return BiomeColors.getGrassColor(world, pos);
				}
				else {
					return GrassColors.getColor(0.5f, 1.0f);
				}
			},
			ArcheonBlocks.WET_GRASS_BLOCK,
			ArcheonBlocks.WET_FERN,
			ArcheonBlocks.WET_GRASS,
			ArcheonBlocks.WET_GRASS_TUFFET,
			ArcheonBlocks.FLOWERED_WET_GRASS
		);
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null ? HotSpringWaterFluid.TINT_COLOR.toDecimal() : -1,
			ArcheonFluids.HOT_SPRING_WATER.getBlock(),
			ArcheonBlocks.HOT_SPRING_WATER_CAULDRON
		);
		ColorProviderRegistry.ITEM.register(
			(stack, tintIndex) -> GrassColors.getColor(0.5f, 1.0f),
			ArcheonBlocks.WET_GRASS_BLOCK.getItem(),
			ArcheonBlocks.WET_GRASS.getItem(),
			ArcheonBlocks.WET_FERN.getItem(),
			ArcheonBlocks.WET_GRASS_TUFFET.getItem(),
			ArcheonBlocks.TALL_WET_GRASS.getItem(),
			ArcheonBlocks.TALL_WET_FERN.getItem()
		);
		ColorProviderRegistry.ITEM.register(
			(stack, tintIndex) -> tintIndex == 0 ? GrassColors.getColor(0.5f, 1.0f) : -1,
			ArcheonBlocks.FLOWERED_WET_GRASS.getItem(),
			ArcheonBlocks.FLOWERED_TALL_WET_GRASS.getItem()
		);
	}
}
