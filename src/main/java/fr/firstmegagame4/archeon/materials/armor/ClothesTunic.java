package fr.firstmegagame4.archeon.materials.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ClothesTunic implements ArmorMaterial {

	public static final ClothesTunic INSTANCE = new ClothesTunic();

	@Override
	public int getDurability(EquipmentSlot slot) {
		return new int[] {13, 15, 16, 1} [slot.getEntitySlotId()] * 40;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return new int[] {0, 2, 2, 1000} [slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 9;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.BLOCK_WOOL_PLACE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.EMPTY;
	}

	@Override
	public String getName() {
		return "clothes";
	}

	@Override
	public float getToughness() {
		return 0.0f;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.0f;
	}
}
