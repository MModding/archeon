package fr.firstmegagame4.archeon.entities;

import fr.firstmegagame4.archeon.init.ArcheonEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class DeerEntity extends CowEntity {

	public DeerEntity(EntityType<? extends DeerEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createDeerAttributes() {
		return CowEntity.createCowAttributes();
	}

	@Override
	public CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		return ArcheonEntities.DEER.create(serverWorld);
	}
}
