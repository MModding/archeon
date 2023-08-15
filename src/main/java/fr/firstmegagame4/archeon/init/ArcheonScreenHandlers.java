package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.screenhandlers.CustomScreenHandlerType;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.screenhandlers.PouchScreenHandler;

public class ArcheonScreenHandlers implements ElementsInitializer {

    public static final CustomScreenHandlerType<PouchScreenHandler> POUCH_HANDLER = new CustomScreenHandlerType<>(PouchScreenHandler::new);

    @Override
    public void register() {
        POUCH_HANDLER.register(Archeon.createId("pouch_handler"));
    }
}
