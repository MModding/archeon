package com.mmodding.archeon.init;

import com.mmodding.archeon.fluid.DasciumFluid;
import com.mmodding.archeon.fluid.HotSpringWaterFluid;
import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;

public class ArcheonFluids {

	public static final HotSpringWaterFluid HOT_SPRING_WATER = new HotSpringWaterFluid(Properties.LEVEL_1_8, true);
	public static final HotSpringWaterFluid FLOWING_HOT_SPRING_WATER = new HotSpringWaterFluid(Properties.LEVEL_1_8, false);

	public static final DasciumFluid DASCIUM = new DasciumFluid(Properties.LEVEL_1_8, true);
	public static final DasciumFluid FLOWING_DASCIUM = new DasciumFluid(Properties.LEVEL_1_8, false);

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.FLUID, factory -> {
			factory.register("hot_spring_water", HOT_SPRING_WATER);
			factory.register("flowing_hot_spring_water", FLOWING_HOT_SPRING_WATER);
			factory.register("dascium", DASCIUM);
			factory.register("flowing_dacsium", FLOWING_DASCIUM);
		});
	}
}
