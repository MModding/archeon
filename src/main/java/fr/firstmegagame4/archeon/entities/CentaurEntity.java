package fr.firstmegagame4.archeon.entities;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CentaurEntity extends HostileEntity {

	public AnimationState galloping = new AnimationState();

	public CentaurEntity(EntityType<? extends CentaurEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createCentaurAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 130.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.5f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new WanderAroundFarGoal(this, 1.0, 0.0f));
		this.targetSelector.add(0, new TargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	public void tick() {
		if (this.getWorld().isClient()) {
			this.galloping.start(this.age);
		}
		super.tick();
	}
}
