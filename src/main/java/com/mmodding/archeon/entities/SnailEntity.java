package com.mmodding.archeon.entities;

import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SnailEntity extends AnimalEntity {

	public SnailEntity(EntityType<? extends SnailEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
		this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
		this.goalSelector.add(3, new TemptGoal(this, 1.25, Ingredient.ofItems(ArcheonItems.MOSS_BALL), false));
		this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
	}

	public static DefaultAttributeContainer.Builder createSnailAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 7.0f)
			.add(EntityAttributes.GENERIC_ARMOR, 1.0f)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f);
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.BLOCK_HONEY_BLOCK_HIT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_HONEY_BLOCK_BREAK;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 0.15f, 1.0f);
	}

	@Override
	protected float getSoundVolume() {
		return 2.0f;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.isOf(ArcheonItems.MOSS_BALL);
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ArcheonEntities.SNAIL.create(world);
	}
}
