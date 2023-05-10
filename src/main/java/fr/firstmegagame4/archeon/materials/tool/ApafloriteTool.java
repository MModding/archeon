package fr.firstmegagame4.archeon.materials.tool;

import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ApafloriteTool implements ToolMaterial {

	public static final ApafloriteTool INSTANCE = new ApafloriteTool();

	@Override
	public int getDurability() {
		return 800;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 8.0f;
	}

	@Override
	public float getAttackDamage() {
		return 2.5f;
	}

	@Override
	public int getMiningLevel() {
		return 2;
	}

	@Override
	public int getEnchantability() {
		return 14;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.APAFLORITE_GEMSTONE);
	}
}
