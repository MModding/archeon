package com.mmodding.archeon.item;

import com.mmodding.archeon.entity.projectile.LusonythArrowEntity;
import com.mmodding.mmodding_lib.library.items.CustomArrowItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LusonythArrowItem extends CustomArrowItem {

	public LusonythArrowItem(Settings settings) {
		super(settings);
	}

	@Override
	public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
		return new LusonythArrowEntity(world, shooter);
	}
}
