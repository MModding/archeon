package com.mmodding.archeon.bootstrap;

import com.mmodding.archeon.bootstrap.init.ArcheonCauldronBehaviors;
import com.mmodding.archeon.bootstrap.init.ArcheonCompostables;
import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingBootstrapInitializer;
import com.mmodding.mmodding_lib.library.initializers.BootstrapElementsInitializer;

import java.util.ArrayList;
import java.util.List;

public class ArcheonBootstrap implements MModdingBootstrapInitializer {

	@Override
	public List<BootstrapElementsInitializer> getBootstrapElementsInitializers() {
		List<BootstrapElementsInitializer> bootstrapElementsInitializers = new ArrayList<>();
		ArcheonCauldronBehaviors.provideInitializers(bootstrapElementsInitializers);
		bootstrapElementsInitializers.add(new ArcheonCompostables());
		return bootstrapElementsInitializers;
	}

	@Override
	public void onInitializeBootstrap(AdvancedModContainer mod) {}
}
