package com.mmodding.archeon.buckets;

import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.fluids.buckets.BucketManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class WoodenBucketManager implements BucketManager {

	public static final WoodenBucketManager INSTANCE = new WoodenBucketManager();

	@Override
	public ItemStack getEmptiedItem(ItemStack stack) {
		return new ItemStack(ArcheonItems.WOODEN_BUCKET);
	}

	@Override
	public ItemStack getFilledItem(ItemStack stack) {
		if (stack.isOf(Items.WATER_BUCKET)) {
			return new ItemStack(ArcheonItems.WOODEN_WATER_BUCKET);
		}
		else if (stack.isOf(Items.MILK_BUCKET)) {
			return new ItemStack(ArcheonItems.WOODEN_MILK_BUCKET);
		}
		else if (stack.isOf(ArcheonFluids.HOT_SPRING_WATER.getBucket())) {
			return new ItemStack(ArcheonItems.WOODEN_HOT_SPRING_WATER_BUCKET);
		}
		else if (stack.isOf(ArcheonFluids.DASCIUM.getBucket())) {
			return new ItemStack(ArcheonItems.WOODEN_DASCIUM_BUCKET);
		}
		else {
			return ItemStack.EMPTY;
		}
	}
}
