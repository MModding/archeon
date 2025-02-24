package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.sounds.CustomSoundEvent;

public class ArcheonSoundEvents implements ElementsInitializer {

	public static final CustomSoundEvent MUSIC_SUNSET = new CustomSoundEvent(Archeon.createId("music.sunset"));
	public static final CustomSoundEvent MUSIC_NIGHT = new CustomSoundEvent(Archeon.createId("music.night"));
	public static final CustomSoundEvent MUSIC_SUNRISE = new CustomSoundEvent(Archeon.createId("music.sunrise"));

	public static final CustomSoundEvent ENTITY_AURORA_CATALYST_AMBIENT = new CustomSoundEvent(Archeon.createId("aurora_catalyst.ambient"));
	public static final CustomSoundEvent ENTITY_AURORA_CATALYST_HIT = new CustomSoundEvent(Archeon.createId("aurora_catalyst.hit"));

	@Override
	public void register() {
		MUSIC_SUNSET.register();
		MUSIC_NIGHT.register();
		MUSIC_SUNRISE.register();
		ENTITY_AURORA_CATALYST_AMBIENT.register();
		ENTITY_AURORA_CATALYST_HIT.register();
	}
}
