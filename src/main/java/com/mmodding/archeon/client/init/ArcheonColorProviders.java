package com.mmodding.archeon.client.init;

import com.mmodding.archeon.fluids.HotSpringWaterFluid;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class ArcheonColorProviders implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null ? HotSpringWaterFluid.TINT_COLOR.toDecimal() : -1,
			ArcheonFluids.HOT_SPRING_WATER.getBlock(),
			ArcheonBlocks.HOT_SPRING_WATER_CAULDRON
		);
	}
}
