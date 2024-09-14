package com.mmodding.archeon.entities.projectiles;

import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.projectiles.StuckArrowDisplay;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LusonythArrowEntity extends PersistentProjectileEntity implements StuckArrowDisplay<LusonythArrowEntity> {

	public LusonythArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public LusonythArrowEntity(World world, double x, double y, double z) {
		super(ArcheonEntities.LUSONYTH_ARROW, x, y, z, world);
	}

	public LusonythArrowEntity(World world, LivingEntity owner) {
		super(ArcheonEntities.LUSONYTH_ARROW, owner, world);
	}

	@Override
	protected ItemStack asItemStack() {
		return new ItemStack(ArcheonItems.LUSONYTH_ARROW);
	}

	@Override
	public LusonythArrowEntity getArrowInstance(World world, double x, double y, double z) {
		return new LusonythArrowEntity(world, x, y, z);
	}
}
