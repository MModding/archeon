package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ArcheonSoundEvents implements ElementsInitializer {

	public static final SoundEvent ENTITY_AURORA_CATALYST_AMBIENT = new SoundEvent(Archeon.createId("aurora_catalyst.ambient"));
	public static final SoundEvent ENTITY_AURORA_CATALYST_HIT = new SoundEvent(Archeon.createId("aurora_catalyst.hit"));

	@Override
	public void register() {
		Registry.register(Registry.SOUND_EVENT, ENTITY_AURORA_CATALYST_AMBIENT.getId(), ENTITY_AURORA_CATALYST_AMBIENT);
		Registry.register(Registry.SOUND_EVENT, ENTITY_AURORA_CATALYST_HIT.getId(), ENTITY_AURORA_CATALYST_HIT);
	}
}
