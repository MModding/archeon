package com.mmodding.archeon.materials.tool;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.materials.RepairOperations;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ClementiumTool implements ToolMaterial, RepairOperations {

	public static final ClementiumTool INSTANCE = new ClementiumTool();

	@Override
	public int getDurability() {
		return 2031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 9.0f;
	}

	@Override
	public float getAttackDamage() {
		return 4.5f;
	}

	@Override
	public int getMiningLevel() {
		return 4;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.LUSONYTH_INGOT);
	}

	@Override
	public boolean preventsRepair(ItemStack stack) {
		if (stack.hasNbt()) {
			assert stack.getNbt() != null;
			if (stack.getNbt().contains("repair_rate")) {
				return stack.getNbt().getInt("repair_rate") >= 3;
			}
		}
		return false;
	}

	@Override
	public void afterRepaired(ItemStack stack) {
		if (!stack.getOrCreateNbt().contains("repair_rate")) {
			assert stack.getNbt() != null;
			stack.getNbt().putInt("repair_rate", 0);
		}
		assert stack.getNbt() != null;
		stack.getNbt().putInt("repair_rate", stack.getNbt().getInt("repair_rate") + 1);
	}
}
