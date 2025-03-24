package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.fluids.DasciumFluid;
import com.mmodding.archeon.fluids.HotSpringWaterFluid;
import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.minecraft.block.Blocks;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonFluids implements ElementsInitializer {

	public static final FluidGroup HOT_SPRING_WATER = new FluidGroup(HotSpringWaterFluid::new, QuiltBlockSettings.copyOf(Blocks.WATER));

	public static final FluidGroup DASCIUM = new FluidGroup(DasciumFluid::new, QuiltBlockSettings.copyOf(Blocks.WATER));

	@Override
	public void register() {
		HOT_SPRING_WATER.register(Archeon.createId("hot_spring_water"));
		DASCIUM.register(Archeon.createId("dascium"));
	}
}
