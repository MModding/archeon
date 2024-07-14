package com.mmodding.archeon.client;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.init.*;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingClientModInitializer;
import com.mmodding.mmodding_lib.library.client.render.model.InventoryModels;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import com.mmodding.mmodding_lib.library.stellar.client.StellarObject;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArcheonClient implements MModdingClientModInitializer {

	@Nullable
	@Override
	public Config getClientConfig() {
		return null;
	}

	@Override
	public List<ClientElementsInitializer> getClientElementsInitializers() {
		List<ClientElementsInitializer> clientElementsInitializers = new ArrayList<>();
		clientElementsInitializers.add(new ArcheonModelPredicates());
		clientElementsInitializers.add(new ArcheonSprites());
		clientElementsInitializers.add(new ArcheonColorProviders());
		clientElementsInitializers.add(new ArcheonRenderLayers());
		clientElementsInitializers.add(new ArcheonEntityModelLayers());
		clientElementsInitializers.add(new ArcheonEntityRenderers());
		clientElementsInitializers.add(new ArcheonScreens());
		return clientElementsInitializers;
	}

	@Override
	public void onInitializeClient(AdvancedModContainer mod) {
		StellarObject.load(Archeon.createId("diethea"), new TextureLocation(Archeon.id(), "environment/diethea"), 16, 16);
		StellarObject.load(Archeon.createId("napor"), new TextureLocation(Archeon.id(), "environment/napor"), 8, 8);
		InventoryModels.REGISTRY.add(Archeon.createId("item/centaur_spear_inventory"));
		InventoryModels.REGISTRY.add(Archeon.createId("item/centaur_battle_axe_inventory"));
		InventoryModels.EVENT.register(stack -> {
			if (stack.isOf(ArcheonItems.CENTAUR_SPEAR)) {
				return Archeon.createId("item/centaur_spear_inventory");
			}
			else if (stack.isOf(ArcheonItems.CENTAUR_BATTLE_AXE)) {
				return Archeon.createId("item/centaur_battle_axe_inventory");
			}
			else {
				return null;
			}
		});
	}
}
