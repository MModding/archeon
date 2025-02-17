package com.mmodding.archeon.entities;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.entities.data.MModdingTrackedDataHandlers;
import com.mmodding.mmodding_lib.library.entities.data.syncable.SyncableData;
import com.mmodding.mmodding_lib.library.entities.goals.MoveToSpecificPosGoal;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.feature.ConditionalOverlayOwner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
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
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BooleanSupplier;

public class HeartOfNatureEntity extends HostileEntity implements ConditionalOverlayOwner {

	private static final TrackedData<Integer> PHASE = DataTracker.registerData(HeartOfNatureEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> SHIELD = DataTracker.registerData(HeartOfNatureEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<List<UUID>> SOLDIERS = DataTracker.registerData(HeartOfNatureEntity.class, MModdingTrackedDataHandlers.UUID_LIST);

	private final SyncableData<Boolean> originalPosRecoveringState = new SyncableData<>(
		Boolean.FALSE,
		this,
		Archeon.createId("original_pos_recovering_state"),
		TrackedDataHandlerRegistry.BOOLEAN
	);

	private final ServerBossBar bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.WHITE, BossBar.Style.PROGRESS);

	private boolean reloaded = false;

	private Vec3d originalPos = Vec3d.ZERO;

	public HeartOfNatureEntity(EntityType<? extends HeartOfNatureEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new FlightMoveControl(this, 10, false);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new MoveToSpecificPosGoal(this, 2.0, 16, 16, this::isRecoveringOriginalPos, this::getOriginalPos, this::posRecoveredPostProcess));
		this.goalSelector.add(1, new HeartOfNatureAttackGoal(this, 1.0, false));
		this.targetSelector.add(0, new TargetGoal<>(this, PlayerEntity.class, true));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(HeartOfNatureEntity.PHASE, 0);
		this.dataTracker.startTracking(HeartOfNatureEntity.SHIELD, false);
		this.dataTracker.startTracking(HeartOfNatureEntity.SOLDIERS, new ArrayList<>());
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("Phase", this.getPhaseIndex());
		nbt.putBoolean("ShieldDeployed", this.isShieldDeployed());
		NbtList soldiers = new NbtList();
		this.getSoldiers().forEach(soldier -> soldiers.add(NbtString.of(soldier.toString())));
		nbt.put("Soldiers", soldiers);
		NbtCompound originalPos = new NbtCompound();
		originalPos.putDouble("X", this.originalPos.x);
		originalPos.putDouble("Y", this.originalPos.y);
		originalPos.putDouble("Z", this.originalPos.z);
		nbt.put("OriginalPos", originalPos);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(PHASE, MathHelper.clamp(nbt.getInt("Phase"), 0, 4));
		this.shieldDeployment(nbt.getBoolean("ShieldDeployed"));
		NbtList soldiers = nbt.getList("Soldiers", NbtElement.STRING_TYPE);
		for (int i = 0; i < soldiers.size(); i++) {
			this.addSoldier(UUID.fromString(soldiers.getString(i)));
		}
		NbtCompound originalPos = nbt.getCompound("OriginalPos");
		this.originalPos = new Vec3d(
			originalPos.getDouble("X"),
			originalPos.getDouble("Y"),
			originalPos.getDouble("Z")
		);
		if (this.hasCustomName()) {
			this.bossBar.setName(this.getDisplayName());
		}
	}

	public void onSummonedByPowerKey(Vec3d originalPos) {
		this.originalPos = originalPos;
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

	private int getPhaseIndex() {
		return MathHelper.clamp(this.dataTracker.get(HeartOfNatureEntity.PHASE), 0, 4);
	}

	public Phase getPhase() {
		return Phase.values()[this.getPhaseIndex()];
	}

	public boolean isShieldDeployed() {
		return this.dataTracker.get(HeartOfNatureEntity.SHIELD);
	}

	public void shieldDeployment(boolean deployed) {
		this.dataTracker.set(HeartOfNatureEntity.SHIELD, deployed);
		this.setTarget(null);
	}

	public List<UUID> getSoldiers() {
		return this.dataTracker.get(HeartOfNatureEntity.SOLDIERS);
	}

	public void setSoldiers(List<UUID> soldiers) {
		this.dataTracker.set(HeartOfNatureEntity.SOLDIERS, soldiers);
	}

	public void addSoldier(UUID uuid) {
		List<UUID> soldiers = this.getSoldiers();
		soldiers.add(uuid);
		this.setSoldiers(soldiers);
	}

	public void removeSoldier(UUID uuid) {
		List<UUID> soldiers = this.getSoldiers();
		soldiers.remove(uuid);
		this.setSoldiers(soldiers);
	}

	public void openProtections() {
		this.shieldDeployment(false);
		if (this.world instanceof ServerWorld serverWorld) {
			Phase phaseWhenOpened = this.getPhase();
			WorldUtils.doTaskAfter(serverWorld, 30 * 20, () -> {
				// prevents the behavior if the phase changes; was previously a bug that allowed the heart of nature
				// to make its soldiers spawn twice
				if (!this.isDead() && this.getPhase().equals(phaseWhenOpened)) {
					this.shieldDeployment(true);
					this.nowRecoveringOriginalPos();
				}
			});
		}
	}

	public boolean switchPhase() {
		if (this.getPhase() != Phase.DEFEATED) {
			this.dataTracker.set(HeartOfNatureEntity.PHASE, MathHelper.clamp(this.getPhaseIndex() + 1, 0, 4));
			this.updateBossBar();
			return true;
		}
		return false;
	}

	public void newPhaseProcess() {
		this.shieldDeployment(!this.getPhase().equals(Phase.DEFEATED));
		this.setHealth(this.getPhase().equals(Phase.DEFEATED) ? 50.0f : 0.1f);
		if (!this.getPhase().equals(Phase.DEFEATED)) {
			WorldUtils.repeatSyncedTaskUntil(this.world, 50, () -> this.heal(1.0f));
			this.nowRecoveringOriginalPos();
		}
	}

	public void updateBossBar() {
		this.bossBar.setColor(switch (this.getPhase()) {
			case PETRIFIED -> BossBar.Color.WHITE;
			case NORMAL -> BossBar.Color.BLUE;
			case POISONOUS -> BossBar.Color.GREEN;
			case EXPLOSIVE -> BossBar.Color.RED;
			case DEFEATED -> BossBar.Color.PURPLE;
		});
	}

	private boolean isRecoveringOriginalPos() {
		return this.originalPosRecoveringState.get();
	}

	public Vec3d getOriginalPos() {
		return this.originalPos;
	}

	private void nowRecoveringOriginalPos() {
		this.originalPosRecoveringState.set(true);
		this.originalPosRecoveringState.synchronize();
	}

	private void posRecoveredPostProcess() {
		this.originalPosRecoveringState.set(false);
		this.originalPosRecoveringState.synchronize();
		this.teleport(this.originalPos.x, this.originalPos.y, this.originalPos.z);
		this.setVelocity(Vec3d.ZERO);
		this.invokeSoldiers();
	}

	private void invokeSoldiers() {
		for (int i = 0; i < (this.getPhase() == Phase.NORMAL ? 10 : this.getPhase() == Phase.POISONOUS ? 15 : 20); i++) {
			if (this.world instanceof ServerWorld serverWorld) {
				WorldUtils.doTaskAfter(serverWorld, i * 20, () -> {
					EntityType<AuroraCatalystEntity> type;
					switch (this.getPhase()) {
						case POISONOUS -> type = this.random.nextInt(2) == 1 ? ArcheonEntities.POISONOUS_AURORA_CATALYST : ArcheonEntities.AURORA_CATALYST;
						case EXPLOSIVE -> type = switch (this.random.nextInt(3)) {
							case 1 -> ArcheonEntities.POISONOUS_AURORA_CATALYST;
							case 2 -> ArcheonEntities.EXPLOSIVE_AURORA_CATALYST;
							default -> ArcheonEntities.AURORA_CATALYST;
						};
						default -> type = ArcheonEntities.AURORA_CATALYST;
					}
					AuroraCatalystEntity auroraCatalystEntity = new AuroraCatalystEntity(type, this.world);
					auroraCatalystEntity.onInvokedByMaster(this.getUuid());
					auroraCatalystEntity.teleport(
						this.getX() - 6 + this.random.nextInt(13),
						this.getY() + 3.5f,
						this.getZ() - 6 + this.random.nextInt(13)
					);
					serverWorld.spawnEntity(auroraCatalystEntity);
					this.addSoldier(auroraCatalystEntity.getUuid());
				});
			}
		}
	}

	@Override
	protected void mobTick() {
		super.mobTick();

		if (!this.reloaded) {
			this.updateBossBar();
			this.reloaded = true;
		}

		if (this.getPhase().equals(Phase.PETRIFIED) || (this.isShieldDeployed() && !this.isRecoveringOriginalPos())) {
			this.setVelocity(Vec3d.ZERO);
		}

		if (this.getPhase().equals(Phase.DEFEATED)) {
			this.addVelocity(0.0, (0.3 - this.getVelocity().y) * 0.3, 0.0);
			this.setHealth(this.getHealth() - 0.5f);
		}

		if (this.isDead()) {
			new Explosion(this.world, this, this.getX(), this.getY(), this.getZ(), 5, false, Explosion.DestructionType.NONE).affectWorld(true);
			this.onDeath(DamageSource.GENERIC);
		}

		this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void tickMovement() {
		super.tickMovement();

		if (!this.isOnGround() && this.getVelocity().y < 0.0) {
			this.setVelocity(this.getVelocity().multiply(1.0, 0.6, 1.0));
		}

		DefaultParticleType particleType = switch (this.getPhase()) {
			case PETRIFIED -> ParticleTypes.ASH;
			case NORMAL -> ParticleTypes.ENCHANT;
			case POISONOUS -> ParticleTypes.FALLING_SPORE_BLOSSOM;
			case EXPLOSIVE -> ParticleTypes.LAVA;
			case DEFEATED -> ParticleTypes.SMOKE;
		};

		float velocityMultiplier = !this.getPhase().equals(Phase.EXPLOSIVE) ? 0.5f : 0.1f;

		for (int i = 0; i < 2; i++) {
			this.world.addParticle(
				particleType,
				this.getX() + this.random.nextFloat() - 0.5f,
				this.getY() + this.random.nextFloat() - 0.0f,
				this.getZ() + this.random.nextFloat() - 0.5f,
				(this.random.nextFloat() - 0.5f) * velocityMultiplier,
				(this.random.nextFloat() - 0.5f) * velocityMultiplier,
				(this.random.nextFloat() - 0.5f) * velocityMultiplier
			);
		}
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		if (target instanceof PlayerEntity && !this.isShieldDeployed()) {
			super.setTarget(target);
		}
	}

	public static DefaultAttributeContainer.Builder createHeartOfNatureAttributes() {
		return MobEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.1f)
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

	@Override
	public boolean tryAttack(Entity target) {
		return super.tryAttack(target);
	}

	@Override
	public boolean isImmuneToExplosion() {
		return true;
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (this.getPhase().equals(Phase.DEFEATED)) {
			return false;
		}
		else if (this.getPhase().equals(Phase.PETRIFIED)) {
			if (source.getAttacker() instanceof PlayerEntity entity) {
				if (entity.getMainHandStack().getItem() instanceof PickaxeItem) {
					if (this.switchPhase()) {
						this.newPhaseProcess();
					}
					return true;
				}
			}
		}
		else {
			if (!this.isShieldDeployed()) {
				if (this.getHealth() - amount <= 0.0f) {
					if (this.switchPhase()) {
						this.newPhaseProcess();
						return true;
					}
				}
				else {
					EntityType<? extends AuroraCatalystEntity> type = switch (this.getPhase()) {
						case POISONOUS -> ArcheonEntities.POISONOUS_AURORA_CATALYST;
						case EXPLOSIVE -> ArcheonEntities.EXPLOSIVE_AURORA_CATALYST;
						default -> ArcheonEntities.AURORA_CATALYST;
					};
					AuroraCatalystEntity auroraCatalystEntity = new AuroraCatalystEntity(type, this.world);
					auroraCatalystEntity.teleport(
						this.getX() - 6 + this.random.nextInt(13),
						this.getY() + 3.5f,
						this.getZ() - 6 + this.random.nextInt(13)
					);
					this.world.spawnEntity(auroraCatalystEntity);
					return super.damage(source, amount);
				}
			}
		}
		return false;
	}

	@Override
	public boolean isOverlayConditionMet() {
		return this.isShieldDeployed();
	}

	@Override
	public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
		return false;
	}

	@Override
	public void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.BLOCK_BEACON_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.BLOCK_BEACON_DEACTIVATE;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_BEACON_ACTIVATE;
	}

	public enum Phase {
		PETRIFIED,
		NORMAL,
		POISONOUS,
		EXPLOSIVE,
		DEFEATED
	}

	public static class HeartOfNatureAttackGoal extends MeleeAttackGoal {

		private final HeartOfNatureEntity heartOfNatureEntity;

		public HeartOfNatureAttackGoal(HeartOfNatureEntity heartOfNatureEntity, double speed, boolean pauseWhenMobIdle) {
			super(heartOfNatureEntity, speed, pauseWhenMobIdle);
			this.heartOfNatureEntity = heartOfNatureEntity;
		}

		private boolean canAttack(BooleanSupplier supplier) {
			if (!this.heartOfNatureEntity.getPhase().equals(Phase.PETRIFIED) && !this.heartOfNatureEntity.getPhase().equals(Phase.DEFEATED)) {
				return !this.heartOfNatureEntity.isShieldDeployed() && supplier.getAsBoolean();
			}
			else {
				return false;
			}
		}

		@Override
		public boolean canStart() {
			return this.canAttack(super::canStart);
		}

		@Override
		public boolean shouldContinue() {
			return this.canAttack(super::shouldContinue);
		}
	}
}
