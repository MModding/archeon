package fr.firstmegagame4.archeon.bootstrap;

import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingBootstrapInitializer;
import com.mmodding.mmodding_lib.library.initializers.BootstrapElementsInitializer;
import fr.firstmegagame4.archeon.bootstrap.init.ArcheonCauldronBehaviors;

import java.util.ArrayList;
import java.util.List;

public class ArcheonBootstrap implements MModdingBootstrapInitializer {

	@Override
	public List<BootstrapElementsInitializer> getBootstrapElementsInitializers() {
		List<BootstrapElementsInitializer> bootstrapElementsInitializers = new ArrayList<>();
		bootstrapElementsInitializers.add(new ArcheonCauldronBehaviors());
		return bootstrapElementsInitializers;
	}

	@Override
	public void onInitializeBootstrap(AdvancedModContainer mod) {}
}
