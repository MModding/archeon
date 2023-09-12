package fr.firstmegagame4.archeon.client.init;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.fluids.GlowingWaterFluid;
import fr.firstmegagame4.archeon.fluids.HotSpringWaterFluid;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFluids;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class ArcheonColorProviders implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null ? HotSpringWaterFluid.TINT_COLOR.toDecimal() : -1,
			ArcheonFluids.HOT_SPRING_WATER.getBlock(),
			ArcheonBlocks.HOT_SPRING_WATER_CAULDRON
		);
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null ? GlowingWaterFluid.TINT_COLOR.toDecimal() : -1,
			ArcheonFluids.GLOWING_WATER.getBlock(),
			ArcheonBlocks.GLOWING_WATER_CAULDRON
		);
	}
}
