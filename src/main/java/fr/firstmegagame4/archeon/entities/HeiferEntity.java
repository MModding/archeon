package fr.firstmegagame4.archeon.entities;

import fr.firstmegagame4.archeon.init.ArcheonEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class HeiferEntity extends CowEntity {

	public HeiferEntity(EntityType<? extends HeiferEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer createHeiferAttributes() {
		return CowEntity.createCowAttributes().build();
	}

	@Override
	public CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		return ArcheonEntities.HEIFER.create(serverWorld);
	}
}
