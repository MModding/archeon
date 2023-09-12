package fr.firstmegagame4.archeon;

import com.mmodding.mmodding_lib.library.base.AdvancedModContainer;
import com.mmodding.mmodding_lib.library.base.MModdingModInitializer;
import com.mmodding.mmodding_lib.library.config.Config;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.portals.CustomPortalLink;
import com.mmodding.mmodding_lib.library.portals.CustomPortals;
import com.mmodding.mmodding_lib.library.portals.Ignition;
import com.mmodding.mmodding_lib.library.portals.squared.CustomSquaredPortal;
import com.mmodding.mmodding_lib.library.stellar.client.StellarCycle;
import fr.firstmegagame4.archeon.init.ArcheonEnchantments;
import fr.firstmegagame4.archeon.init.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Archeon implements MModdingModInitializer {

	public static final RegistryKey<World> WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, Archeon.createId("archeon"));

	public static final CustomSquaredPortal ARCHEON_PORTAL = CustomPortals.ofSquared(
		ArcheonBlocks.MYSTERIOUS_STONE, ArcheonBlocks.ARCHEON_PORTAL, Ignition.ofKey(ArcheonItems.WAND_OF_NATURE)
	).applyLink(CustomPortalLink.create(Archeon.createId("archeon")));

	public static final StellarCycle DIETHEA = StellarCycle.ofAngle(130, 160, 160, 288000, Archeon.createId("archeon"));
	public static final StellarCycle NAPOR = StellarCycle.ofAngle(-30, -60, -60, 36000, Archeon.createId("archeon"));

	@Nullable
	@Override
	public Config getConfig() {
		return new ArcheonConfig();
	}

	@Override
	public List<ElementsInitializer> getElementsInitializers() {
		List<ElementsInitializer> elementsInitializers = new ArrayList<>();
		elementsInitializers.add(new ArcheonBlocks());
		elementsInitializers.add(new ArcheonItems());
		elementsInitializers.add(new ArcheonEnchantments());
		elementsInitializers.add(new ArcheonFluids());
		elementsInitializers.add(new ArcheonEvents());
		elementsInitializers.add(new ArcheonItemGroups());
		elementsInitializers.add(new ArcheonScreenHandlers());
		elementsInitializers.add(new ArcheonChunkGeneratorSettings());
		elementsInitializers.add(new ArcheonBiomes());
		elementsInitializers.add(new ArcheonFeatures());
		elementsInitializers.add(new ArcheonEntities());
		elementsInitializers.add(new ArcheonSoundEvents());
		return elementsInitializers;
	}

	@Override
	public void onInitialize(AdvancedModContainer mod) {
		ARCHEON_PORTAL.register(Archeon.createId("portal"));

		DIETHEA.register(Archeon.createId("diethea"));
		NAPOR.register(Archeon.createId("napor"));
	}

	public static String id() {
		return "archeon";
	}

	public static Identifier createId(String path) {
		return new Identifier(Archeon.id(), path);
	}
}
