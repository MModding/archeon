package com.mmodding.archeon.client.init;

import com.mmodding.archeon.client.screens.PouchScreen;
import com.mmodding.archeon.init.ArcheonScreenHandlers;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ArcheonScreens implements ClientElementsInitializer {

    @Override
    public void registerClient() {
        HandledScreens.register(ArcheonScreenHandlers.POUCH_HANDLER, PouchScreen::new);
    }
}
