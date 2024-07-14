package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.screenhandlers.PouchScreenHandler;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.screenhandlers.CustomScreenHandlerType;

public class ArcheonScreenHandlers implements ElementsInitializer {

    public static final CustomScreenHandlerType<PouchScreenHandler> POUCH_HANDLER = new CustomScreenHandlerType<>(PouchScreenHandler::new);

    @Override
    public void register() {
        POUCH_HANDLER.register(Archeon.createId("pouch_handler"));
    }
}
