package fr.firstmegagame4.archeon.buckets;

import com.mmodding.mmodding_lib.library.fluids.buckets.BucketManager;
import fr.firstmegagame4.archeon.init.ArcheonFluids;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CeramicBucketManager implements BucketManager {

	public static final CeramicBucketManager INSTANCE = new CeramicBucketManager();

	@Override
	public ItemStack getEmptiedItem(ItemStack stack) {
		return new ItemStack(ArcheonItems.CERAMIC_BUCKET);
	}

	@Override
	public ItemStack getFilledItem(ItemStack stack) {
		if (stack.isOf(Items.WATER_BUCKET)) {
			return new ItemStack(ArcheonItems.CERAMIC_WATER_BUCKET);
		}
		else if (stack.isOf(Items.LAVA_BUCKET)) {
			return new ItemStack(ArcheonItems.CERAMIC_LAVA_BUCKET);
		}
		else if (stack.isOf(ArcheonFluids.HOT_SPRING_WATER.getBucket())) {
			return new ItemStack(ArcheonItems.CERAMIC_HOT_SPRING_WATER_BUCKET);
		}
		else if (stack.isOf(ArcheonFluids.DASCIUM.getBucket())) {
			return new ItemStack(ArcheonItems.CERAMIC_DASCIUM_BUCKET);
		}
		else {
			return ItemStack.EMPTY;
		}
	}
}
