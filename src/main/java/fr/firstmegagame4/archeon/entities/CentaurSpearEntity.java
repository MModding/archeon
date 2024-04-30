package fr.firstmegagame4.archeon.entities;

import com.mmodding.mmodding_lib.library.entities.projectiles.SpearEntity;
import fr.firstmegagame4.archeon.init.ArcheonEntities;
import fr.firstmegagame4.archeon.init.ArcheonItems;
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
