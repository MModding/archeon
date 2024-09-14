package com.mmodding.archeon.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MouncreepEntity extends ZombieEntity {

	private static final TrackedData<Integer> VARIANT = DataTracker.registerData(MouncreepEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public MouncreepEntity(EntityType<? extends MouncreepEntity> entityType, World world) {
		super(entityType, world);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.setVariant(Variant.values()[world.getRandom().nextInt(4)]);
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MouncreepEntity.VARIANT, 0);
	}

	public static DefaultAttributeContainer.Builder createMouncreepAttributes() {
		return ZombieEntity.createZombieAttributes();
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("Variant", this.getVariantIndex());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariantIndex(nbt.getInt("Variant"));
	}

	public Variant getVariant() {
		return Variant.values()[this.getVariantIndex()];
	}

	public int getVariantIndex() {
		return MathHelper.clamp(this.dataTracker.get(MouncreepEntity.VARIANT), 0, 3);
	}

	public void setVariant(Variant variant) {
		this.setVariantIndex(variant.ordinal());
	}

	public void setVariantIndex(int index) {
		this.dataTracker.set(MouncreepEntity.VARIANT, index);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_HUSK_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_HUSK_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_HUSK_DEATH;
	}

	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_HUSK_STEP;
	}

	public enum Variant {
		BLUE_RAGS,
		BROWN_RAGS,
		GREEN_RAGS,
		YELLOW_RAGS
	}
}
