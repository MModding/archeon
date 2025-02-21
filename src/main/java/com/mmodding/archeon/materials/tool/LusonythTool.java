package com.mmodding.archeon.materials.tool;

import com.mmodding.archeon.init.ArcheonItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LusonythTool implements ToolMaterial {

	public static final LusonythTool INSTANCE = new LusonythTool();

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
		return 5.0f;
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
}
