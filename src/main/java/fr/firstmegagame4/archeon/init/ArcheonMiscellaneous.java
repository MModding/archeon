package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomPortalLink;
import com.mmodding.mmodding_lib.library.portals.CustomPortals;
import com.mmodding.mmodding_lib.library.portals.Ignition;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortal;
import com.mmodding.mmodding_lib.library.stellar.StellarCycle;
import fr.firstmegagame4.archeon.Archeon;

public class ArcheonMiscellaneous implements ElementsInitializer {

	public static final CustomSquaredPortal ARCHEON_PORTAL = CustomPortals.ofSquared(
		ArcheonBlocks.MYSTERIOUS_STONE, ArcheonBlocks.ARCHEON_PORTAL, Ignition.ofKey(ArcheonItems.WAND_OF_NATURE)
	).applyLink(CustomPortalLink.create(Archeon.createId("archeon")));

	public static final StellarCycle DIETHEA = StellarCycle.ofAngle(130, 160, 160, 288000, Archeon.createId("archeon"));
	public static final StellarCycle NAPOR = StellarCycle.ofAngle(-30, -60, -60, 36000, Archeon.createId("archeon"));

	@Override
	public void register() {
		ARCHEON_PORTAL.register(Archeon.createId("portal"));

		DIETHEA.register(Archeon.createId("diethea"));
		NAPOR.register(Archeon.createId("napor"));
	}
}
