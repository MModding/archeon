package fr.firstmegagame4.archeon.client.init;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.client.screens.PouchScreen;
import fr.firstmegagame4.archeon.init.ArcheonScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ArcheonScreens implements ClientElementsInitializer {

    @Override
    public void registerClient() {
        HandledScreens.register(ArcheonScreenHandlers.POUCH_HANDLER, PouchScreen::new);
    }
}
