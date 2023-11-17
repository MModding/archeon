package fr.firstmegagame4.archeon.client;

import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingClientModInitializer;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import com.mmodding.mmodding_lib.library.stellar.client.StellarObject;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.init.*;
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
	}
}
