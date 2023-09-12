package fr.firstmegagame4.archeon.enchantments;

import com.mmodding.mmodding_lib.library.enchantments.CustomEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.types.EnchantmentType;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class BloodySharpnessEnchantment extends CustomEnchantment {

    public BloodySharpnessEnchantment(EnchantmentType type, Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot... equipmentSlots) {
        super(type, rarity, enchantmentTarget, equipmentSlots);
    }

    @Override
    public int getMinPower(int level) {
        return (level - 1) * 11 + 1;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 32;
    }

    @Override
    public int getMaxLevel() {
        return 8;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return Math.max(0, level - 1) * 0.5f + 1.0f;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment);
    }

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.isOf(ArcheonItems.MASSACRE_DAGGER);
	}
}
