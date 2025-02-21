package com.mmodding.archeon.materials.tool;

import com.mmodding.archeon.init.ArcheonItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FaeliteTool implements ToolMaterial {

	public static final FaeliteTool INSTANCE = new FaeliteTool();

	@Override
	public int getDurability() {
		return 1561;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 8.0f;
	}

	@Override
	public float getAttackDamage() {
		return 4.0f;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.FAELITE_INGOT);
	}
}
