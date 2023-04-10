package fr.firstmegagame4.archeon.client;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;

public class ArcheonRenderLayers implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ArcheonBlocks.ANTROPY_DOOR.cutout();
	}
}
