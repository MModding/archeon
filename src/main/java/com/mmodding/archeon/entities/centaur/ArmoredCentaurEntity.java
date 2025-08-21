package com.mmodding.archeon.entities.centaur;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.entities.action.EntityAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ArmoredCentaurEntity extends AbstractCentaurEntity {

	// First Half Goal
	private final Goal crossAttackGoal = new CentaurCrossAttackGoal(this, 80, 1.5f);
	// Second Half Goal
	private final Goal damageZoneAttackGoal = new CentaurDamageZoneAttackGoal(this, 60);

	// First Half Action
	public final EntityAction crossAttackAction = new EntityAction(this, Archeon.createId("cross_attack"), 10, 7);
	// Second Half Action
	public final EntityAction damageZoneAttackAction = new EntityAction(this, Archeon.createId("damage_zone_attack"), 15, 12);

	// Cooldown used for the CentaurCrossAttackGoal. When combined with the priority system, it allows
	// to put an interval between different centaur attacks, this interval being another entity goal.
	private int attackCooldown;

	public ArmoredCentaurEntity(EntityType<? extends AbstractCentaurEntity> entityType, World world) {
		super(entityType, world);
		this.updateGoals();
	}

	public ArmoredCentaurEntity(World world, BlockPos vaultPos) {
		super(ArcheonEntities.ARMORED_CENTAUR, world, vaultPos);
		this.updateGoals();
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new CentaurMovementGoal( // When there is a target, but that the attack cooldown is still up.
			this, () -> Objects.requireNonNull(this.getTarget()).getPos(),
			3.33f, () -> this.getTarget() != null && !this.crossAttackAction.isExecutingAction() && !this.damageZoneAttackAction.isExecutingAction()
		));
		this.goalSelector.add(2, new CentaurMovementGoal(this, () -> this.getTarget() == null)); // When there is no target.
		this.targetSelector.add(0, new CentaurTargetGoal(this, true));
	}

	@Override
	protected void updateGoals() {
		if (!this.getWorld().isClient()) {
			this.goalSelector.remove(this.crossAttackGoal);
			this.goalSelector.remove(this.damageZoneAttackGoal);
			if (this.getHealth() >= this.getMaxHealth() / 2) {
				this.goalSelector.add(0, this.crossAttackGoal);
			}
			else {
				this.goalSelector.add(0, this.damageZoneAttackGoal);
			}
		}
	}

	@Override
	public void tick() {
		super.tick();

		this.crossAttackAction.tick();
		this.damageZoneAttackAction.tick();
	}

	@Override
	protected void mobTick() {
		super.mobTick();

		if (this.attackCooldown > 0 ) {
			this.attackCooldown--;
		}
	}

	public static class CentaurCrossAttackGoal extends MeleeAttackGoal {

		private final ArmoredCentaurEntity centaur;
		private final int cooldownInTicks;

		public CentaurCrossAttackGoal(PathAwareEntity mob, int cooldownInTicks, double speed) {
			super(mob, speed, false);
			this.centaur = (ArmoredCentaurEntity) mob;
			this.cooldownInTicks = cooldownInTicks;
		}

		@Override
		public boolean canStart() {
			return this.centaur.attackCooldown == 0 && super.canStart();
		}

		@Override
		public boolean shouldContinue() {
			return this.centaur.attackCooldown == 0 && super.shouldContinue();
		}

		@Override
		protected void attack(LivingEntity target, double squaredDistance) {
			if (squaredDistance <= this.getSquaredMaxAttackDistance(target)) {
				this.centaur.attackCooldown = this.getTickCount(this.cooldownInTicks);
				this.centaur.getNavigation().startMovingTo(target, 2.0f);
				if (this.centaur.getWorld() instanceof ServerWorld) {
					this.centaur.crossAttackAction.execute(() -> {
						this.centaur.tryAttack(target);
						Vec3d relativePos = this.mob.getPos().add(target.getPos());
						Vec3d velocity = relativePos.multiply(0.25);
						target.addVelocity(velocity.x, 0.6f, velocity.z);
					});
				}
			}
		}

		@Override
		protected double getSquaredMaxAttackDistance(LivingEntity entity) {
			float f = this.centaur.getWidth() + 1.0f;
			return f * 2.0f * f * 2.0f + entity.getWidth();
		}
	}

	public static class CentaurDamageZoneAttackGoal extends Goal {

		private final ArmoredCentaurEntity centaur;
		private final int cooldownIntTicks;

		private long lastUpdateTime;

		public CentaurDamageZoneAttackGoal(ArmoredCentaurEntity centaur, int cooldownIntTicks) {
			this.centaur = centaur;
			this.cooldownIntTicks = cooldownIntTicks;
		}

		@Override
		public boolean canStart() {
			long l = this.centaur.world.getTime();
			if (l - this.lastUpdateTime < 20L) {
				return false;
			} else {
				this.lastUpdateTime = l;
				LivingEntity livingEntity = this.centaur.getTarget();
				return livingEntity != null && livingEntity.isAlive();
			}
		}

		@Override
		public boolean shouldContinue() {
			LivingEntity livingEntity = this.centaur.getTarget();
			return livingEntity != null && livingEntity.isAlive() && (!(livingEntity instanceof PlayerEntity playerEntity) || (!playerEntity.isSpectator() && !playerEntity.isCreative()));
		}

		@Override
		public void start() {
			this.centaur.setAttacking(true);
		}

		@Override
		public void stop() {
			LivingEntity livingEntity = this.centaur.getTarget();
			if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
				this.centaur.setTarget(null);
			}
			this.centaur.setAttacking(false);
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void tick() {
			if (this.centaur.age % this.cooldownIntTicks == 0) {
				LivingEntity target = this.centaur.getTarget();
				assert target != null;
				Vec3d teleportPosition = new Vec3d(target.getX(), target.getY() + 8.0, target.getZ());
				Predicate<Vec3d> positionValidityChecker = (pos) -> {
					BlockPos center = new BlockPos(pos);
					return BlockPos.stream(center.add(-1, -1, -1), center.add(1, 1, 1))
						.filter(currentPos -> this.centaur.getWorld().getBlockState(currentPos).isAir())
						.count() == 27L;
				};
				while (!positionValidityChecker.test(teleportPosition) && teleportPosition.getY() > target.getY()) {
					teleportPosition = new Vec3d(teleportPosition.getX(), teleportPosition.getY() - 1.0, teleportPosition.getZ());
				}
				this.centaur.teleport(teleportPosition.getX(), teleportPosition.getY(), teleportPosition.getZ());
				RandomGenerator random = this.centaur.getRandom();
				for (int i = 0; i < 5; i++) {
					this.centaur.world.addParticle(
						ParticleTypes.WHITE_ASH,
						target.getX(),
						target.getY() + 10.0,
						target.getZ(),
						random.nextDouble() - 0.5,
						random.nextDouble() - 0.5,
						random.nextDouble() - 0.5
					);
				}
				this.centaur.damageZoneAttackAction.execute(() -> {
					List<Entity> entitiesToOffend = this.centaur.world.getOtherEntities(this.centaur, Box.of(this.centaur.getPos(), 10.0, 1.0, 10.0), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
					entitiesToOffend.forEach(this.centaur::tryAttack);
					this.centaur.world.playSoundFromEntity(null, this.centaur, SoundEvents.ENTITY_RAVAGER_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
				});
			}
		}
	}
}
