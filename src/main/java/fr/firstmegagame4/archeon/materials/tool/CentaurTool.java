package fr.firstmegagame4.archeon.materials.tool;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CentaurTool implements ToolMaterial {

	public static final CentaurTool INSTANCE = new CentaurTool();

	@Override
	public int getDurability() {
		return 2031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 4.0f;
	}

	@Override
	public float getAttackDamage() {
		return 4.0f;
	}

	@Override
	public int getMiningLevel() {
		return 1;
	}

	@Override
	public int getEnchantability() {
		return 2;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.EMPTY;
	}
}
