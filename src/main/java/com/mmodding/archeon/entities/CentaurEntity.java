package com.mmodding.archeon.entities;

import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class CentaurEntity extends HostileEntity {

	public AnimationState galloping = new AnimationState();

	private Vec3d vaultPos;

	public CentaurEntity(EntityType<? extends CentaurEntity> entityType, World world) {
		super(entityType, world);
		this.vaultPos = Vec3d.ZERO;
	}

	public CentaurEntity(World world, Vec3d vaultPos, boolean armored) {
		super(armored ? ArcheonEntities.ARMORED_CENTAUR : ArcheonEntities.CENTAUR, world);
		this.vaultPos = vaultPos;
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
		this.goalSelector.add(0, new CentaurMovement(this));
		this.targetSelector.add(0, new TargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		NbtCompound vaultPos = new NbtCompound();
		vaultPos.putDouble("X", this.vaultPos.getX());
		vaultPos.putDouble("Y", this.vaultPos.getY());
		vaultPos.putDouble("Z", this.vaultPos.getZ());
		nbt.put("VaultPos", vaultPos);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		NbtCompound vaultPos = nbt.getCompound("VaultPos");
		this.vaultPos = new Vec3d(
			vaultPos.getDouble("X"),
			vaultPos.getDouble("Y"),
			vaultPos.getDouble("Z")
		);
	}

	@Override
	public void tick() {
		if (this.getWorld().isClient()) {
			this.galloping.start(this.age);
		}
		super.tick();
	}

	@Override
	public void onRemoved() {
		BlockState state = this.getWorld().getBlockState(new BlockPos(this.vaultPos));
		TweakFunction<CentaurLifeVaultBlock.Lives> lives = property -> this.getType().equals(ArcheonEntities.ARMORED_CENTAUR) ? property.decadeRight() : property.decadeLeft();
		this.getWorld().setBlockState(new BlockPos(this.vaultPos), state.with(CentaurLifeVaultBlock.LIVES, lives.apply(state.get(CentaurLifeVaultBlock.LIVES))));
	}

	public static class CentaurMovement extends Goal {

		private final CentaurEntity centaur;

		public CentaurMovement(CentaurEntity centaur) {
			this.centaur = centaur;
			this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
		}

		@Override
		public boolean canStart() {
			return this.centaur.vaultPos != Vec3d.ZERO && this.centaur.getTarget() == null;
		}

		@Override
		public boolean shouldContinue() {
			return this.centaur.getTarget() == null;
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void tick() {
			int degree = (this.centaur.age % 90) * 4 + (this.centaur.getType().equals(ArcheonEntities.ARMORED_CENTAUR) ? 180 : 0);
			double x = this.centaur.vaultPos.getX() + 13.0 * Math.cos(degree * (Math.PI / 180.0));
			double z = this.centaur.vaultPos.getZ() + 13.0 * Math.sin(degree * (Math.PI / 180.0));
			this.centaur.getMoveControl().moveTo(x, this.centaur.getY(), z, 2.0f);
		}
	}
}
