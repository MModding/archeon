package fr.firstmegagame4.archeon.entities;

import fr.firstmegagame4.archeon.init.ArcheonEntities;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SunstradiverEntity extends AnimalEntity {

	public SunstradiverEntity(EntityType<? extends SunstradiverEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new FlightMoveControl(this, 10, false);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
		this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
		this.goalSelector.add(3, new TemptGoal(this, 1.25, Ingredient.ofItems(ArcheonItems.MOSS_BALL), false));
		this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
		this.goalSelector.add(5, new FlyOntoTreeGoal(this, 1.0));
	}

	public static DefaultAttributeContainer createSunstradiverAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0f)
			.add(EntityAttributes.GENERIC_FLYING_SPEED, 0.5f)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
			.build();
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		BirdNavigation birdNavigation = new BirdNavigation(this, world);
		birdNavigation.setCanPathThroughDoors(true);
		birdNavigation.setCanSwim(true);
		birdNavigation.setCanEnterOpenDoors(true);
		return birdNavigation;
	}

	@Override
	protected void addFlapEffects() {
		this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15f, 1.0f);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PARROT_AMBIENT;
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

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ArcheonEntities.SUNSTRADIVER.create(world);
	}
}
