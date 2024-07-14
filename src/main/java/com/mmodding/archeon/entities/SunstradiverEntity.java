package com.mmodding.archeon.entities;

import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.WingedAnimalEntity;
import com.mmodding.mmodding_lib.library.entities.goals.FlyingAroundFarGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SunstradiverEntity extends WingedAnimalEntity implements Flutterer {

	public SunstradiverEntity(EntityType<? extends SunstradiverEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new FlightMoveControl(this, 10, false);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(2, new TargetGoal<>(this, SnailEntity.class, true));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0f, false));
		this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
		this.goalSelector.add(5, new AnimalMateGoal(this, 1.0));
		this.goalSelector.add(6, new RevengeGoal(this).setGroupRevenge());
		this.goalSelector.add(7, new TemptGoal(this, 1.25, Ingredient.ofItems(ArcheonItems.GRAPE), false));
		this.goalSelector.add(8, new FollowParentGoal(this, 1.25));
		this.goalSelector.add(9, new FlyingAroundFarGoal(this, 1.0));
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		this.flapWings();
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		if (target instanceof SnailEntity) {
			super.setTarget(target);
		}
	}

	public static DefaultAttributeContainer.Builder createSunstradiverAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0f)
			.add(EntityAttributes.GENERIC_FLYING_SPEED, 0.5f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		BirdNavigation birdNavigation = new BirdNavigation(this, world);
		birdNavigation.setCanPathThroughDoors(true);
		birdNavigation.setCanSwim(true);
		birdNavigation.setCanEnterOpenDoors(true);
		return birdNavigation;
	}

	@Nullable
	@Override
	public SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PARROT_AMBIENT;
	}

	@Override
	public SoundEvent getFlapSound() {
		return SoundEvents.ENTITY_PARROT_FLY;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_PARROT_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PARROT_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15f, 1.0f);
	}

	@Override
	protected float getSoundVolume() {
		return 2.0f;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.isOf(ArcheonItems.GRAPE);
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ArcheonEntities.SUNSTRADIVER.create(world);
	}

	@Override
	public boolean isInAir() {
		return !this.onGround;
	}
}
