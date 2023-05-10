package fr.firstmegagame4.archeon.materials.tool;

import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FaeliteTool implements ToolMaterial {

	public static final FaeliteTool INSTANCE = new FaeliteTool();

	@Override
	public int getDurability() {
		return 2031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 12.0f;
	}

	@Override
	public float getAttackDamage() {
		return 1.0f;
	}

	@Override
	public int getMiningLevel() {
		return 4;
	}

	@Override
	public int getEnchantability() {
		return 42;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ArcheonItems.FAELITE_INGOT);
	}
}
