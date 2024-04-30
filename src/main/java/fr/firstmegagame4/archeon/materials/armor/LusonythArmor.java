package fr.firstmegagame4.archeon.materials.armor;

import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class LusonythArmor implements ArmorMaterial {

	public static final LusonythArmor INSTANCE = new LusonythArmor();

	@Override
	public int getDurability(EquipmentSlot slot) {
		return new int[] {13, 15, 16, 11} [slot.getEntitySlotId()] * 32;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return new int[] {2, 5, 8, 3} [slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 18;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.RAW_LUSONYTH);
	}

	@Override
	public String getName() {
		return "lusonyth";
	}

	@Override
	public float getToughness() {
		return 0.2f;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.1f;
	}
}
