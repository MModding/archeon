package fr.firstmegagame4.archeon;

import com.mmodding.mmodding_lib.library.base.MModdingModInitializer;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomPortalLink;
import com.mmodding.mmodding_lib.library.portals.CustomPortals;
import com.mmodding.mmodding_lib.library.portals.Ignition;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortal;
import fr.firstmegagame4.archeon.init.*;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.ModContainer;

import java.util.ArrayList;
import java.util.List;

public class Archeon implements MModdingModInitializer {

	public static final CustomSquaredPortal ARCHEON_PORTAL = CustomPortals.ofSquared(
		ArcheonBlocks.MYSTERIOUS_STONE, ArcheonBlocks.ARCHEON_PORTAL, Ignition.ofKey(ArcheonItems.WAND_OF_NATURE)
	).applyLink(CustomPortalLink.create(Archeon.createId("archeon")));

	@Override
	public @Nullable Config getConfig() {
		return new ArcheonConfig();
	}

	@Override
	public List<ElementsInitializer> getElementsInitializers() {
		List<ElementsInitializer> elementsInitializers = new ArrayList<>();
		elementsInitializers.add(new ArcheonBlocks());
		elementsInitializers.add(new ArcheonItems());
		elementsInitializers.add(new ArcheonItemGroups());
		elementsInitializers.add(new ArcheonChunkGeneratorSettings());
		elementsInitializers.add(new ArcheonBiomes());
		elementsInitializers.add(new ArcheonFeatures());
		elementsInitializers.add(new ArcheonEntities());
		elementsInitializers.add(new ArcheonSoundEvents());
		return elementsInitializers;
	}

	@Override
	public void onInitialize(ModContainer mod) {
		MModdingModInitializer.super.onInitialize(mod);

		ARCHEON_PORTAL.register(Archeon.createId("portal"));
	}

	public static String id() {
		return "archeon";
	}

	public static Identifier createId(String path) {
		return new Identifier(Archeon.id(), path);
	}
}
