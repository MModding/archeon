package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.fluid.DasciumFluid;
import com.mmodding.archeon.fluid.HotSpringWaterFluid;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;

public class ArcheonFluids {

	public static final FluidGroup HOT_SPRING_WATER = new FluidGroup(HotSpringWaterFluid::new, FabricBlockSettings.copyOf(Blocks.WATER));

	public static final FluidGroup DASCIUM = new FluidGroup(DasciumFluid::new, FabricBlockSettings.copyOf(Blocks.WATER));

	public static void register(AdvancedContainer mod) {
		HOT_SPRING_WATER.register(Archeon.createId("hot_spring_water"));
		DASCIUM.register(Archeon.createId("dascium"));
	}
}
