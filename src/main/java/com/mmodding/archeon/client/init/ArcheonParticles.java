package com.mmodding.archeon.client.init;

import com.mmodding.archeon.init.ArcheonParticleTypes;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SoulParticle;
import net.minecraft.client.particle.SpellParticle;

public class ArcheonParticles implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ParticleFactoryRegistry.getInstance().register(ArcheonParticleTypes.EXYRIANE_FLAME, SpellParticle.InstantFactory::new);
		ParticleFactoryRegistry.getInstance().register(ArcheonParticleTypes.CATALYST_TEAR, SoulParticle.SculkFactory::new);
	}
}
