package com.mmodding.archeon.enchantments;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.enchantments.CustomEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.types.EnchantmentType;
import net.minecraft.enchantment.EfficiencyEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class EfficiencyOfTheQolmEnchantment extends CustomEnchantment {

	public EfficiencyOfTheQolmEnchantment(EnchantmentType type, Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot... equipmentSlots) {
		super(type, rarity, enchantmentTarget, equipmentSlots);
	}

	@Override
	public int getMaxLevel() {
		return 8;
	}

	@Override
	public boolean canAccept(Enchantment other) {
		return !(other instanceof EfficiencyEnchantment);
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.isOf(ArcheonItems.QOLM_PICK);
	}
}
