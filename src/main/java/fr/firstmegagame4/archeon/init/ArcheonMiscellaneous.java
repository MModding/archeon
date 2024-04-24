package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.glint.DefaultGlintPacks;
import com.mmodding.mmodding_lib.library.glint.DynamicGlintPackView;
import com.mmodding.mmodding_lib.library.glint.GlintPackView;
import com.mmodding.mmodding_lib.library.glint.SimpleGlintPackView;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomPortalLink;
import com.mmodding.mmodding_lib.library.portals.CustomPortals;
import com.mmodding.mmodding_lib.library.portals.Ignition;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortal;
import com.mmodding.mmodding_lib.library.stellar.StellarCycle;
import com.mmodding.mmodding_lib.library.utils.MModdingIdentifier;
import fr.firstmegagame4.archeon.Archeon;

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

	@Override
	public void register() {
		ARCHEON_PORTAL.register(Archeon.createId("portal"));

		DIETHEA.register(Archeon.createId("diethea"));
		NAPOR.register(Archeon.createId("napor"));
	}
}
