package com.mmodding.archeon.items;

import com.mmodding.mmodding_lib.library.items.CustomSwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.UseAction;

public class CentaurSpearIem extends CustomSwordItem {

	public CentaurSpearIem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.SPEAR;
	}
}
