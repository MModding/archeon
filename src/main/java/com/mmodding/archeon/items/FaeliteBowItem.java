package com.mmodding.archeon.items;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.items.CustomBowItem;
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
