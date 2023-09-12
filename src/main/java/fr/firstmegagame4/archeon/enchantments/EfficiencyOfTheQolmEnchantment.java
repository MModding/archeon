package fr.firstmegagame4.archeon.enchantments;

import com.mmodding.mmodding_lib.library.enchantments.CustomEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.types.EnchantmentType;
import fr.firstmegagame4.archeon.init.ArcheonItems;
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
	public int getMinPower(int level) {
		return (level - 1) * 10 + 1;
	}

	@Override
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 50;
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
