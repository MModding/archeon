package com.mmodding.archeon.entities.centaur;

import com.mmodding.archeon.blockentities.ArcheonBlockEntities;
import com.mmodding.archeon.blockentities.CentaurLifeVaultBlockEntity;
import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.debug.WatcherProvider;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.*;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AbstractCentaurEntity extends HostileEntity implements WatcherProvider {

	private static final TrackedData<Integer> TIME_WITHOUT_TARGET = DataTracker.registerData(AbstractCentaurEntity.class, TrackedDataHandlerRegistry.INTEGER);

	private final ServerBossBar bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.YELLOW, BossBar.Style.PROGRESS);

	public AnimationState breathing = new AnimationState();
	public AnimationState moving = new AnimationState();

	protected BlockPos vaultPos = BlockPos.ORIGIN;

	protected AbstractCentaurEntity(EntityType<? extends AbstractCentaurEntity> entityType, World world) {
		super(entityType, world);
	}

	protected AbstractCentaurEntity(EntityType<? extends AbstractCentaurEntity> entityType, World world, BlockPos vaultPos) {
		this(entityType, world);
		this.vaultPos = vaultPos;
	}

	@Override
	public Map<String, Function<PlayerEntity, Object>> valueWatcher() {
		Map<String, Function<PlayerEntity, Object>> map = new LinkedHashMap<>();
		map.put("target", p -> this.getTarget());
		map.put("average_velocity", p -> (MathHelper.abs((float) this.getVelocity().x) + MathHelper.abs((float) this.getVelocity().z)) / 2f);
		map.put("distance", p -> p.distanceTo(this));
		return map;
	}

	@Override
	public Map<String, Function<PlayerEntity, Vec3d>> spaceWatcher() {
		Map<String, Function<PlayerEntity, Vec3d>> map = new LinkedHashMap<>();
		map.put("next_position", p -> this.nextPosition);
		return map;
	}

	public static DefaultAttributeContainer.Builder createCentaurAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0f)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3.0f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	protected abstract void updateGoals();

	protected abstract int getMaxTimeWithoutTarget();

	protected final boolean isValidTimeWithoutTarget() {
		return this.dataTracker.get(AbstractCentaurEntity.TIME_WITHOUT_TARGET) >= this.getMaxTimeWithoutTarget();
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(AbstractCentaurEntity.TIME_WITHOUT_TARGET, 0);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("TimeWithoutTarget", this.dataTracker.get(TIME_WITHOUT_TARGET));
		NbtCompound vaultPos = new NbtCompound();
		vaultPos.putInt("X", this.vaultPos.getX());
		vaultPos.putInt("Y", this.vaultPos.getY());
		vaultPos.putInt("Z", this.vaultPos.getZ());
		nbt.put("VaultPos", vaultPos);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(TIME_WITHOUT_TARGET, nbt.getInt("TimeWithoutTarget"));
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
		super.tick();
		this.breathing.start(this.age);
		this.moving.start(this.age);
	}

	@Override
	protected void mobTick() {
		super.mobTick();

		// So that you can go to the centaur's floor without resetting its life.
		int maxTicksTimeWithoutTarget = this.getMaxTimeWithoutTarget();

		if (this.getTarget() == null && this.dataTracker.get(TIME_WITHOUT_TARGET) <= maxTicksTimeWithoutTarget) {
			this.dataTracker.set(TIME_WITHOUT_TARGET, this.dataTracker.get(TIME_WITHOUT_TARGET) + 1);
		}
		else if (this.getTarget() != null && this.dataTracker.get(TIME_WITHOUT_TARGET) != 0) {
			this.dataTracker.set(TIME_WITHOUT_TARGET, 0);
		}

		if (this.dataTracker.get(TIME_WITHOUT_TARGET) == maxTicksTimeWithoutTarget) {
			this.setHealth(this.getMaxHealth());
			this.updateGoals();
		}

		this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected int computeFallDamage(float fallDistance, float damageMultiplier) {
		return 0;
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (source.isProjectile() && source.getSource() != null && source.getSource().getPos().distanceTo(this.getPos()) >= 10.0f) {
			return false;
		}
		float previousHealth = this.getHealth();
		boolean bool = super.damage(source, amount);
		if (this.isDead()) {
			BlockState state = this.getWorld().getBlockState(this.vaultPos);
			if (state.isOf(ArcheonBlocks.CENTAUR_LIFE_VAULT)) {
				TweakFunction<CentaurLifeVaultBlock.Lives> lives = property -> this.getType().equals(ArcheonEntities.ARMORED_CENTAUR) ? property.decadeRight() : property.decadeLeft();
				this.getWorld().setBlockState(this.vaultPos, state.with(CentaurLifeVaultBlock.LIVES, lives.apply(state.get(CentaurLifeVaultBlock.LIVES))));
				this.world.getBlockEntity(this.vaultPos, ArcheonBlockEntities.CENTAUR_LIFE_VAULT).ifPresent(CentaurLifeVaultBlockEntity::releaseSoundtrack);
			}
			else {
				LoggerFactory.getLogger("Archeon").error(
					"There is no Centaur Life Vault at coordinates [{}, {}, {}]! Centaur data might be corrupted!",
					this.vaultPos.getX(), this.vaultPos.getY(), this.vaultPos.getZ()
				);
			}
		}
		else {
			this.updateGoals();
			if (previousHealth >= this.getMaxHealth() / 2.0f && this.getHealth() <= this.getMaxHealth() / 2.0f) {
				this.world.getBlockEntity(this.vaultPos, ArcheonBlockEntities.CENTAUR_LIFE_VAULT).ifPresent(CentaurLifeVaultBlockEntity::releaseSoundtrack);
			}
		}
		return bool;
	}

	// Debug Purposes
	private Vec3d nextPosition;

	public static class CentaurMovementGoal extends Goal {

		private static final Vec3d ORIGIN = Vec3d.ofBottomCenter(BlockPos.ORIGIN);

		private final AbstractCentaurEntity centaur;
		private final Supplier<Vec3d> center;
		private final double radius;
		private final BooleanSupplier requirements;

		public CentaurMovementGoal(AbstractCentaurEntity centaur, BooleanSupplier requirements) {
			this(centaur, () -> Vec3d.ofBottomCenter(centaur.vaultPos), 11.0f, requirements);
		}

		public CentaurMovementGoal(AbstractCentaurEntity centaur, Supplier<Vec3d> center, double radius, BooleanSupplier requirements) {
			this.centaur = centaur;
			this.center = center;
			this.radius = radius;
			this.requirements = requirements;
			this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
		}

		@Override
		public boolean canStart() {
			if (this.requirements.getAsBoolean()) {
				Vec3d pos = this.center.get();
				return pos != null && pos != ORIGIN;
			}
			else {
				return false;
			}
		}

		@Override
		public boolean shouldContinue() {
			if (this.requirements.getAsBoolean()) {
				Vec3d pos = this.center.get();
				return pos != null && pos != ORIGIN;
			}
			else {
				return false;
			}
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void tick() {
			double speed = 0.765 / this.radius; // nicely working constant
			double angle = this.centaur.age * speed;
			if (this.centaur.getType().equals(ArcheonEntities.ARMORED_CENTAUR)) {
				angle += Math.PI;
			}
			Vec3d pos = this.center.get();
			double x = pos.getX() + this.radius * Math.cos(angle);
			double z = pos.getZ() + this.radius * Math.sin(angle);
			this.centaur.nextPosition = new Vec3d(x, this.centaur.getY() + 0.5, z);
			this.centaur.getMoveControl().moveTo(x, this.centaur.getY(), z, 2.0f);
		}
	}

	public static class CentaurTargetGoal extends TargetGoal<PlayerEntity> {

		private final AbstractCentaurEntity centaur;

		public CentaurTargetGoal(AbstractCentaurEntity mob, boolean checkVisibility) {
			super(mob, PlayerEntity.class, checkVisibility);
			this.centaur = mob;
		}

		@Override
		protected Box getSearchBox(double distance) {
			Vec3d base = Vec3d.ofBottomCenter(this.centaur.vaultPos);
			return new Box(base.add(-11.25, 0, -11.25), base.add(11.25, 22.5, 11.25));
		}
	}
}
