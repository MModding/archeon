package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.fluids.DasciumFluid;
import fr.firstmegagame4.archeon.fluids.HotSpringWaterFluid;
import net.minecraft.block.Blocks;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonFluids implements ElementsInitializer {

	public static final FluidGroup HOT_SPRING_WATER = new FluidGroup(
		new HotSpringWaterFluid(true),
		new HotSpringWaterFluid(false),
		QuiltBlockSettings.copyOf(Blocks.WATER)
	);

	public static final FluidGroup DASCIUM = new FluidGroup(
		new DasciumFluid(true),
		new DasciumFluid(false),
		QuiltBlockSettings.copyOf(Blocks.WATER)
	);

	@Override
	public void register() {
		HOT_SPRING_WATER.register(Archeon.createId("hot_spring_water"));
		DASCIUM.register(Archeon.createId("dascium"));
	}
}
