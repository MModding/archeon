package fr.firstmegagame4.archeon.items;

import com.mmodding.mmodding_lib.library.items.CustomBowItem;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public class FaeliteBowItem extends CustomBowItem {

	public FaeliteBowItem(Settings settings) {
		super(() -> ArcheonItems.LUSONYTH_ARROW, settings);
	}

	@Override
	public Predicate<ItemStack> getProjectiles() {
		return stack -> stack.isOf(ArcheonItems.LUSONYTH_ARROW);
	}
}
