package com.mmodding.archeon.client.init;

import com.mmodding.archeon.fluids.DasciumFluid;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.screen.PlayerScreenHandler;

public class ArcheonSprites implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlas, registry) -> {
			registry.register(DasciumFluid.STILL_TEXTURE);
			registry.register(DasciumFluid.FLOWING_TEXTURE);
		});
	}
}
