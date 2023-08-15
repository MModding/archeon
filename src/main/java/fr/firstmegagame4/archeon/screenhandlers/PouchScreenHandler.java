package fr.firstmegagame4.archeon.screenhandlers;

import com.mmodding.mmodding_lib.library.containers.AdvancedInventory;
import fr.firstmegagame4.archeon.init.ArcheonScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;

public class PouchScreenHandler extends GenericContainerScreenHandler {

	public PouchScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new AdvancedInventory(27));
	}

	public PouchScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(ArcheonScreenHandlers.POUCH_HANDLER, syncId, playerInventory, inventory, 3);
	}
}
