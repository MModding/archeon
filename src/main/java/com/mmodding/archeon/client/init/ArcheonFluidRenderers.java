package com.mmodding.archeon.client.init;

import com.mmodding.archeon.fluid.DasciumFluid;
import com.mmodding.archeon.fluid.HotSpringWaterFluid;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.fluid.api.client.FluidClientRegistries;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;

public class ArcheonFluidRenderers {

	public static void register(AdvancedContainer mod) {
		FluidRenderHandlerRegistry.INSTANCE.register(ArcheonFluids.HOT_SPRING_WATER, ArcheonFluids.FLOWING_HOT_SPRING_WATER, SimpleFluidRenderHandler.coloredWater(HotSpringWaterFluid.TINT_COLOR.toDecimal()));
		FluidRenderHandlerRegistry.INSTANCE.register(ArcheonFluids.DASCIUM, ArcheonFluids.FLOWING_DASCIUM, new SimpleFluidRenderHandler(DasciumFluid.STILL_TEXTURE, DasciumFluid.FLOWING_TEXTURE));
		FluidClientRegistries.FOG_COLOR.put(ArcheonFluids.HOT_SPRING_WATER, HotSpringWaterFluid.FOG_COLOR);
		FluidClientRegistries.FOG_COLOR.put(ArcheonFluids.DASCIUM, DasciumFluid.FOG_COLOR);
	}
}
