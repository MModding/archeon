package com.mmodding.archeon.materials.armor;

import com.mmodding.archeon.init.ArcheonItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ApafloriteArmor implements ArmorMaterial {

	public static final ApafloriteArmor INSTANCE = new ApafloriteArmor();

	@Override
	public int getDurability(EquipmentSlot slot) {
		return new int[] {13, 15, 16, 11} [slot.getEntitySlotId()] * 21;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return new int[] {2, 5, 6, 2} [slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.APAFLORITE_GEMSTONE);
	}

	@Override
	public String getName() {
		return "apaflorite";
	}

	@Override
	public float getToughness() {
		return 2.5f;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.0f;
	}
}
