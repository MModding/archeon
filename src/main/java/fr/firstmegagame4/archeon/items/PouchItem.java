package fr.firstmegagame4.archeon.items;

import com.mmodding.mmodding_lib.library.containers.DefaultContainer;
import com.mmodding.mmodding_lib.library.items.CustomItemWithInventory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class PouchItem extends CustomItemWithInventory {

	public PouchItem(Settings settings, DefaultContainer defaultContainer) {
		super(settings, defaultContainer);
	}

	@Override
	@Nullable
	public SoundEvent getUseSound() {
		return SoundEvents.ITEM_BUNDLE_INSERT;
	}
}
