package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.fluids.DasciumFluid;
import com.mmodding.archeon.fluids.HotSpringWaterFluid;
import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;

public class ArcheonFluids implements ElementsInitializer {

	public static final FluidGroup HOT_SPRING_WATER = new FluidGroup(HotSpringWaterFluid::new, FabricBlockSettings.copyOf(Blocks.WATER));

	public static final FluidGroup DASCIUM = new FluidGroup(DasciumFluid::new, FabricBlockSettings.copyOf(Blocks.WATER));

	@Override
	public void register() {
		HOT_SPRING_WATER.register(Archeon.createId("hot_spring_water"));
		DASCIUM.register(Archeon.createId("dascium"));
	}
}
