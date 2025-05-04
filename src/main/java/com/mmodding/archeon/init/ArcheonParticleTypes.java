package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;

public class ArcheonParticleTypes implements ElementsInitializer {

	public static final DefaultParticleType EXYRIANE_FLAME = FabricParticleTypes.simple();
	public static final DefaultParticleType CATALYST_TEAR = FabricParticleTypes.simple();

	@Override
	public void register() {
		Registry.register(Registry.PARTICLE_TYPE, Archeon.createId("exyriane_flame"), EXYRIANE_FLAME);
		Registry.register(Registry.PARTICLE_TYPE, Archeon.createId("catalyst_tear"), CATALYST_TEAR);
	}
}
