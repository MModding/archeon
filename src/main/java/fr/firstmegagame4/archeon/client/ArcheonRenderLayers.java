package fr.firstmegagame4.archeon.client;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;

public class ArcheonRenderLayers implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ArcheonBlocks.AEROLIA.cutout();
		ArcheonBlocks.ASCENDIA.cutout();
		ArcheonBlocks.ASTEDIBES.cutout();
		ArcheonBlocks.BLOOD_ORANGE_BUSH.cutout();
		ArcheonBlocks.COKIPLANT.cutout();
		ArcheonBlocks.ANTROPY_DOOR.cutout();
		ArcheonBlocks.BUSH_LEAVES.cutout();
	}
}
