package fr.firstmegagame4.archeon.materials.tool;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class QolmTool implements ToolMaterial {

	public static final QolmTool INSTANCE = new QolmTool();

	@Override
	public int getDurability() {
		return 2031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 3.5f;
	}

	@Override
	public float getAttackDamage() {
		return 1.5f;
	}

	@Override
	public int getMiningLevel() {
		return 5;
	}

	@Override
	public int getEnchantability() {
		return 22;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.EMPTY;
	}
}
