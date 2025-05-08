package com.mmodding.archeon.entities;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blockentities.ArcheonBlockEntities;
import com.mmodding.archeon.blockentities.CentaurLifeVaultBlockEntity;
import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.action.EntityAction;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.EnumSet;

public class CentaurEntity extends HostileEntity implements RangedAttackMob {

	public final EntityAction attackAction = new EntityAction(this, Archeon.createId("attack"), 10, 10);
	public final EntityAction talentAction = new EntityAction(this, Archeon.createId("talent"), 10, 10);

	private final ServerBossBar bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.YELLOW, BossBar.Style.PROGRESS);

	private final Goal attackGoal;
	private final Goal talentGoal;

	public AnimationState galloping = new AnimationState();

	private BlockPos vaultPos = BlockPos.ORIGIN;

	public CentaurEntity(EntityType<? extends CentaurEntity> entityType, World world) {
		super(entityType, world);
		this.attackGoal = new CentaurMeleeAttackGoal(this, 1.5f, false);
		if (this.getType().equals(ArcheonEntities.ARMORED_CENTAUR)) {
			this.talentGoal = new CentaurCrossAttackGoal(this, 1.5f, false);
		}
		else {
			this.talentGoal = new CentaurSpearAttackGoal(this, 1.0, 40, 20.0f);
		}
		this.updateGoals();
	}

	public CentaurEntity(World world, BlockPos vaultPos, boolean armored) {
		this(armored ? ArcheonEntities.ARMORED_CENTAUR : ArcheonEntities.CENTAUR, world);
		this.vaultPos = vaultPos;
	}

	public static DefaultAttributeContainer.Builder createCentaurAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 130.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0f)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3.0f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new CentaurMovementGoal(this));
		this.targetSelector.add(0, new TargetGoal<>(this, PlayerEntity.class, true));
	}

	private void updateGoals() {
		if (!this.getWorld().isClient()) {
			this.goalSelector.remove(this.attackGoal);
			this.goalSelector.remove(this.talentGoal);
			if (this.getHealth() >= this.getMaxHealth() / 2) {
				this.goalSelector.add(0, this.attackGoal);
			} else {
				this.goalSelector.add(0, this.talentGoal);
			}
		}
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		NbtCompound vaultPos = new NbtCompound();
		vaultPos.putInt("X", this.vaultPos.getX());
		vaultPos.putInt("Y", this.vaultPos.getY());
		vaultPos.putInt("Z", this.vaultPos.getZ());
		nbt.put("VaultPos", vaultPos);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		NbtCompound vaultPos = nbt.getCompound("VaultPos");
		this.vaultPos = new BlockPos(
			vaultPos.getInt("X"),
			vaultPos.getInt("Y"),
			vaultPos.getInt("Z")
		);
		this.updateGoals();
		if (this.hasCustomName()) {
			this.bossBar.setName(this.getDisplayName());
		}
	}

	public void setupBossBar() {
		this.bossBar.setPercent(0.0f);
	}

	@Override
	public void onStartedTrackingBy(ServerPlayerEntity player) {
		super.onStartedTrackingBy(player);
		this.bossBar.addPlayer(player);
	}

	@Override
	public void onStoppedTrackingBy(ServerPlayerEntity player) {
		super.onStoppedTrackingBy(player);
		this.bossBar.removePlayer(player);
	}

	@Override
	public void checkDespawn() {
		if (this.world.getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
			this.discard();
		} else {
			this.despawnCounter = 0;
		}
	}

	@Override
	public void tick() {
		if (this.getWorld().isClient()) {
			this.attackAction.tick();
			this.talentAction.tick();
			this.galloping.start(this.age);
		}
		super.tick();
	}

	@Override
	protected void mobTick() {
		super.mobTick();

		this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		float previousHealth = this.getHealth();
		boolean bool = super.damage(source, amount);
		if (this.isDead()) {
			BlockState state = this.getWorld().getBlockState(this.vaultPos);
			TweakFunction<CentaurLifeVaultBlock.Lives> lives = property -> this.getType().equals(ArcheonEntities.ARMORED_CENTAUR) ? property.decadeRight() : property.decadeLeft();
			this.getWorld().setBlockState(this.vaultPos, state.with(CentaurLifeVaultBlock.LIVES, lives.apply(state.get(CentaurLifeVaultBlock.LIVES))));
			this.world.getBlockEntity(this.vaultPos, ArcheonBlockEntities.CENTAUR_LIFE_VAULT).ifPresent(CentaurLifeVaultBlockEntity::releaseSoundtrack);
		}
		else {
			this.updateGoals();
			if (previousHealth >= this.getMaxHealth() / 2.0f && this.getHealth() <= this.getMaxHealth() / 2.0f) {
				this.world.getBlockEntity(this.vaultPos, ArcheonBlockEntities.CENTAUR_LIFE_VAULT).ifPresent(CentaurLifeVaultBlockEntity::releaseSoundtrack);
			}
		}
		return bool;
	}

	// Spear Behavior (Only executed for Default Centaur)
	@Override
	public void attack(LivingEntity target, float pullProgress) {
		if (this.getWorld() instanceof ServerWorld serverWorld) {
			this.talentAction.execute(() -> {
				CentaurSpearEntity spear = new CentaurSpearEntity(serverWorld, this, new ItemStack(ArcheonItems.CENTAUR_SPEAR));
				double relativeX = target.getX() - this.getX();
				double relativeY = target.getBodyY(0.4) - spear.getY();
				double relativeZ = target.getZ() - this.getZ();
				double length = Math.sqrt(Math.pow(relativeX, 2) + Math.pow(relativeZ, 2));
				spear.setVelocity(relativeX, relativeY + length * 0.2f, relativeZ, 1.6f, 10 - serverWorld.getDifficulty().getId() * 3);
				this.playSound(SoundEvents.ITEM_TRIDENT_THROW, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
				this.getWorld().spawnEntity(spear);
			});
		}
	}

	public static class CentaurMovementGoal extends Goal {

		private final CentaurEntity centaur;

		public CentaurMovementGoal(CentaurEntity centaur) {
			this.centaur = centaur;
			this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
		}

		@Override
		public boolean canStart() {
			return this.centaur.vaultPos != BlockPos.ORIGIN && this.centaur.getTarget() == null;
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

	public static class CentaurMeleeAttackGoal extends MeleeAttackGoal {

		final CentaurEntity centaur;

		public CentaurMeleeAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
			super(mob, speed, pauseWhenMobIdle);
			this.centaur = (CentaurEntity) mob;
		}

		public boolean superStart() {
			return super.canStart();
		}

		@Override
		protected int getMaxCooldown() {
			return this.getTickCount(60);
		}

		@Override
		protected void attack(LivingEntity target, double squaredDistance) {
			if (this.centaur.getWorld() instanceof ServerWorld && !this.centaur.attackAction.isExecutingAction()) {
				this.centaur.attackAction.execute(() -> super.attack(target, squaredDistance));
			}
		}
	}

	public static class CentaurSpearAttackGoal extends ProjectileAttackGoal {

		private final CentaurEntity centaur;

		public CentaurSpearAttackGoal(RangedAttackMob rangedAttackMob, double mobSpeed, int intervalTicks, float maxShootRange) {
			super(rangedAttackMob, mobSpeed, intervalTicks, maxShootRange);
			this.centaur = (CentaurEntity) rangedAttackMob;
		}

		@Override
		public boolean canStart() {
			return super.canStart() && this.centaur.getMainHandStack().isOf(ArcheonItems.CENTAUR_SPEAR);
		}

		@Override
		public void start() {
			super.start();
			this.centaur.setAttacking(true);
		}

		@Override
		public void stop() {
			super.stop();
			this.centaur.setAttacking(false);
		}
	}

	public static class CentaurCrossAttackGoal extends CentaurMeleeAttackGoal {

		public CentaurCrossAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
			super(mob, speed, pauseWhenMobIdle);
		}

		@Override
		protected void attack(LivingEntity target, double squaredDistance) {
			if (this.centaur.getWorld() instanceof ServerWorld) {
				this.centaur.attackAction.execute(() -> {
					double max = this.getSquaredMaxAttackDistance(target);
					if (squaredDistance <= max && this.getCooldown() <= 0) {
						this.resetCooldown();
						this.centaur.tryAttack(target);
						Vec3d relativePos = this.mob.getPos().add(target.getPos());
						Vec3d velocity = relativePos.multiply(0.25);
						target.addVelocity(velocity.x, 0.6f, velocity.z);
					}
				});
			}
		}

		@Override
		public boolean canStart() {
			return this.superStart() && !this.centaur.talentAction.isExecutingAction();
		}

		@Override
		public boolean shouldContinue() {
			return super.shouldContinue() && !this.centaur.talentAction.isExecutingAction();
		}
	}
}
