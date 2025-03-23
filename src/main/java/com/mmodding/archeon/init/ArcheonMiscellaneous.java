package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.glint.DefaultGlintPacks;
import com.mmodding.mmodding_lib.library.glint.DynamicGlintPackView;
import com.mmodding.mmodding_lib.library.glint.GlintPackView;
import com.mmodding.mmodding_lib.library.glint.SimpleGlintPackView;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomPortalLink;
import com.mmodding.mmodding_lib.library.portals.CustomPortals;
import com.mmodding.mmodding_lib.library.portals.Ignition;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortal;
import com.mmodding.mmodding_lib.library.soundtracks.Soundtrack;
import com.mmodding.mmodding_lib.library.stellar.StellarCycle;
import com.mmodding.mmodding_lib.library.utils.MModdingIdentifier;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import com.mmodding.mmodding_lib.library.worldgen.structures.StructureSpreadLoot;
import net.minecraft.client.sound.MusicType;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.StructureFeature;

public class ArcheonMiscellaneous implements ElementsInitializer {

	public static final CustomSquaredPortal ARCHEON_PORTAL = CustomPortals.ofSquared(
		ArcheonBlocks.MYSTERIOUS_STONE, ArcheonBlocks.ARCHEON_PORTAL, Ignition.ofKey(ArcheonItems.WAND_OF_NATURE)
	).applyLink(CustomPortalLink.create(Archeon.createId("archeon")));

	public static final StellarCycle DIETHEA = StellarCycle.ofAngle(130, 160, 160, 288000, Archeon.createId("archeon"));
	public static final StellarCycle NAPOR = StellarCycle.ofAngle(-30, -60, -60, 36000, Archeon.createId("archeon"));

	public static final GlintPackView VIEW = DynamicGlintPackView.deviate((SimpleGlintPackView) DefaultGlintPacks.WHITE, (stack, ref) -> {
		if (stack.isOf(ArcheonItems.FAELITE_PICKAXE)) {
			ref.set(new MModdingIdentifier("lightened_blue"));
		}
		else if (stack.isOf(ArcheonItems.FAELITE_AXE)) {
			ref.set(new MModdingIdentifier("lightened_magenta"));
		}
	});

	public static final RegistryKey<StructureFeature> PANOPTICON_KEY = RegistryKey.of(Registry.STRUCTURE_WORLDGEN, Archeon.createId("panopticon"));
	public static final RegistryKey<StructureFeature> ATMOSPHERE_TOWER_KEY = RegistryKey.of(Registry.STRUCTURE_WORLDGEN, Archeon.createId("atmosphere_tower"));

	public static final MusicSound PANOPTICON = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_PANOPTICON);
	public static final MusicSound ATMOSPHERE_TOWER = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_ATMOSPHERE_TOWER);

	public static final MusicSound DAY = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_DAY);
	public static final MusicSound SUNSET = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_SUNSET);
	public static final MusicSound NIGHT = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_NIGHT);
	public static final MusicSound SUNRISE = MusicType.createIngameMusic(ArcheonSoundEvents.MUSIC_SUNRISE);

	public static final Soundtrack HEART_OF_NATURE = Soundtrack.create(
		Archeon.createId("heart_of_nature"),
		Soundtrack.Part.iterations(Archeon.createId("heart_of_nature.intro"), 1),
		Soundtrack.Part.looping(Archeon.createId("heart_of_nature.petrified")),
		Soundtrack.Part.looping(Archeon.createId("heart_of_nature.first_phase")),
		Soundtrack.Part.looping(Archeon.createId("heart_of_nature.second_phase")),
		Soundtrack.Part.looping(Archeon.createId("heart_of_nature.third_phase")),
		Soundtrack.Part.iterations(Archeon.createId("heart_of_nature.outro"), 1)
	);

	public static final Soundtrack ELKIN = Soundtrack.create(
		Archeon.createId("elkin"),
		Soundtrack.Part.iterations(Archeon.createId("elkin.intro"), 1),
		Soundtrack.Part.looping(Archeon.createId("elkin.first_phase")),
		Soundtrack.Part.iterations(Archeon.createId("elkin.first_phase_transition"), 1),
		Soundtrack.Part.looping(Archeon.createId("elkin.first_phase_climax")),
		Soundtrack.Part.iterations(Archeon.createId("elkin.transition"), 1),
		Soundtrack.Part.looping(Archeon.createId("elkin.second_phase")),
		Soundtrack.Part.iterations(Archeon.createId("elkin.second_phase_transition"), 1),
		Soundtrack.Part.looping(Archeon.createId("elkin.second_phase_climax")),
		Soundtrack.Part.iterations(Archeon.createId("elkin.outro"), 1)
	);

	@Override
	public void register() {
		ARCHEON_PORTAL.register(Archeon.createId("portal"));

		DIETHEA.register(Archeon.createId("diethea"));
		NAPOR.register(Archeon.createId("napor"));

		WorldUtils.addSpreadStructureLoot(PANOPTICON_KEY, StructureSpreadLoot.create().addStructureCommonLoot(ArcheonItems.CENTAUR_LIFE_IGNITER.getDefaultStack()));
		WorldUtils.addSpreadStructureLoot(ATMOSPHERE_TOWER_KEY, StructureSpreadLoot.create().addStructureCommonLoot(ArcheonItems.POWER_KEY.getDefaultStack()));
	}
}
