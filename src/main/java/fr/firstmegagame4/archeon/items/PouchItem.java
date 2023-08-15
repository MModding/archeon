package fr.firstmegagame4.archeon.items;

import com.mmodding.mmodding_lib.library.items.CustomItemWithInventory;
import fr.firstmegagame4.archeon.screenhandlers.PouchScreenHandler;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class PouchItem extends CustomItemWithInventory {

	public PouchItem(Settings settings) {
		super(settings, 27, PouchScreenHandler::new);
	}

	@Override
	@Nullable
	public SoundEvent getUseSound() {
		return SoundEvents.ITEM_BUNDLE_INSERT;
	}
}
