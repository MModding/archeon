package com.mmodding.archeon.entities;

import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.projectiles.SpearEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CentaurSpearEntity extends SpearEntity {

	public CentaurSpearEntity(EntityType<? extends CentaurSpearEntity> entityType, World world) {
		super(entityType, world, ArcheonItems.CENTAUR_SPEAR.getDefaultStack());
	}

	public CentaurSpearEntity(World world, LivingEntity owner, ItemStack stack) {
		super(ArcheonEntities.CENTAUR_SPEAR, world, owner, stack);
	}
}
