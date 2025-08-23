package com.mmodding.archeon.entities;

import com.mmodding.archeon.entities.centaur.AbstractCentaurEntity;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.projectiles.SpearEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class CentaurSpearEntity extends SpearEntity {

	public CentaurSpearEntity(EntityType<? extends CentaurSpearEntity> entityType, World world) {
		super(entityType, world, ArcheonItems.CENTAUR_SPEAR.getDefaultStack());
	}

	public CentaurSpearEntity(World world, LivingEntity owner, ItemStack stack) {
		super(ArcheonEntities.CENTAUR_SPEAR, world, owner, stack);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		if (!(this.getOwner() instanceof AbstractCentaurEntity && entityHitResult.getEntity() instanceof AbstractCentaurEntity)) {
			super.onEntityHit(entityHitResult);
		}
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		if (!(this.getOwner() instanceof AbstractCentaurEntity)) {
			super.onBlockHit(blockHitResult);
		}
		else {
			this.discard();
		}
	}

	@Override
	public float getBaseDamage() {
		return 4.0f;
	}
}
