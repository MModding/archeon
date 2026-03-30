package com.mmodding.archeon.item;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.library.java.api.list.filter.FilterList;
import com.mmodding.library.java.api.list.filter.WhiteList;
import com.mmodding.mmodding_lib.library.items.CustomItemAcceptingStacks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;

public class AmuletOfNatureItem extends CustomItemAcceptingStacks {

	public AmuletOfNatureItem(Item.Settings settings) {
		super(settings);
	}

	@Override
	public void receiveStack(ItemStack currentStack, ItemStack receivedStack) {
		NbtCompound nbt = currentStack.getOrCreateNbt();
		nbt.putInt("power", receivedStack.getCount() + (nbt.contains("power") ? nbt.getInt("power") : 0));
	}

	@Override
	public void playReceiveStackSound(PlayerEntity player) {
		player.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8f, 0.8f + player.getWorld().getRandom().nextFloat() * 0.4f);
	}

	@Override
	public FilterList<Item> getFilter() {
		return new WhiteList<>(ArcheonItems.IMPRESSIVE_AURORA_CRYSTAL, ArcheonItems.CENTAUR_HORSESHOE);
	}
}
