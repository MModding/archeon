package com.mmodding.archeon.entities;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blockentities.ArcheonBlockEntities;
import com.mmodding.archeon.blockentities.CentaurLifeVaultBlockEntity;
import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.debug.WatcherProvider;
import com.mmodding.mmodding_lib.library.entities.action.EntityAction;
import com.mmodding.mmodding_lib.library.math.OrientedBlockPos;
import com.mmodding.mmodding_lib.library.utils.MapUtils;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
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
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.*;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.apache.logging.log4j.util.TriConsumer;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CentaurEntity extends HostileEntity implements RangedAttackMob, WatcherProvider {

	private static final TrackedData<Integer> TIME_WITHOUT_TARGET = DataTracker.registerData(CentaurEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public final EntityAction firstHalfAction;
	public final EntityAction secondHalfAction;

	private final ServerBossBar bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.YELLOW, BossBar.Style.PROGRESS);

	private final Goal firstHalfGoal;
	private final Goal secondHalfGoal;

	public AnimationState breathing = new AnimationState();
	public AnimationState moving = new AnimationState();

	private BlockPos vaultPos = BlockPos.ORIGIN;

	// Cooldown used for the CentaurCrossAttackGoal. When combined with the priority system, it allows
	// to put an interval between different centaur attacks, this interval being another entity goal.
	private int attackCooldown;

	public CentaurEntity(EntityType<? extends CentaurEntity> entityType, World world) {
		super(entityType, world);
		if (this.getType().equals(ArcheonEntities.ARMORED_CENTAUR)) {
			this.firstHalfAction = new EntityAction(this, Archeon.createId("cross_attack"), 10, 7);
			this.firstHalfGoal = new CentaurCrossAttackGoal(this, 80, 1.5f);
			this.secondHalfAction = new EntityAction(this, Archeon.createId("aoe_attack"), 15, 12);
			this.secondHalfGoal = new CentaurDamageZoneAttackGoal(this, 60);
		}
		else {
			this.firstHalfAction = new EntityAction(this, Archeon.createId("spear_throw"), 8, 7);
			this.firstHalfGoal = new CentaurSpearAttackGoal(this, 1.0, 40, 30.0f);
			this.secondHalfAction = new EntityAction(this, Archeon.createId("air_move"), 15, 12);
			this.secondHalfGoal = new CentaurMovingSpearAttackGoal(this, 30);
		}
		this.updateGoals();
	}

	public CentaurEntity(World world, BlockPos vaultPos, boolean armored) {
		this(armored ? ArcheonEntities.ARMORED_CENTAUR : ArcheonEntities.CENTAUR, world);
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
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 130.0f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0f)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3.0f)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	@Override
	protected void initGoals() {
		if (this.getType().equals(ArcheonEntities.ARMORED_CENTAUR)) {
			this.goalSelector.add(1, new CentaurMovementGoal( // When there is a target, but that the attack cooldown is still up.
				this, () -> Objects.requireNonNull(this.getTarget()).getPos(),
				3.33f, () -> this.getTarget() != null
			));
			this.goalSelector.add(2, new CentaurMovementGoal(this)); // When there is no target.
		}
		else {
			this.goalSelector.add(1, new CentaurMovementGoal(this));
		}
		this.targetSelector.add(0, new CentaurTargetGoal(this, true));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(CentaurEntity.TIME_WITHOUT_TARGET, 0);
	}

	private void updateGoals() {
		if (!this.getWorld().isClient()) {
			this.goalSelector.remove(this.firstHalfGoal);
			this.goalSelector.remove(this.secondHalfGoal);
			if (this.getHealth() >= this.getMaxHealth() / 2) {
				this.goalSelector.add(0, this.firstHalfGoal);
			} else {
				this.goalSelector.add(0, this.secondHalfGoal);
			}
		}
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
		this.firstHalfAction.tick();
		this.secondHalfAction.tick();
		this.breathing.start(this.age);
		this.moving.start(this.age);
	}

	@Override
	protected void mobTick() {
		super.mobTick();

		if (this.attackCooldown > 0 ) {
			this.attackCooldown--;
		}

		if (this.getTarget() == null && this.dataTracker.get(TIME_WITHOUT_TARGET) <= 200) {
			this.dataTracker.set(TIME_WITHOUT_TARGET, this.dataTracker.get(TIME_WITHOUT_TARGET) + 1);
		}
		else if (this.getTarget() != null && this.dataTracker.get(TIME_WITHOUT_TARGET) != 0) {
			this.dataTracker.set(TIME_WITHOUT_TARGET, 0);
		}

		if (this.dataTracker.get(TIME_WITHOUT_TARGET) == 200) {
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
		if (source.isProjectile() && source.getSource() != null && source.getSource().getPos().squaredDistanceTo(this.getPos()) >= 10.0f) {
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
					"There is no Centaur Life Vault at [{}, {}, {}]! Centaur data might be corrupted!",
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

	// Spear Behavior (Only executed for Default Centaur)
	@Override
	public void attack(LivingEntity target, float pullProgress) {
		if (this.getWorld() instanceof ServerWorld serverWorld) {
			this.firstHalfAction.execute(() -> {
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

	// Debug Purposes
	private Vec3d nextPosition;

	public static class CentaurMovementGoal extends Goal {

		private static final Vec3d ORIGIN = Vec3d.ofBottomCenter(BlockPos.ORIGIN);

		private final CentaurEntity centaur;
		private final Supplier<Vec3d> center;
		private final double radius;
		private final BooleanSupplier requirements;

		public CentaurMovementGoal(CentaurEntity centaur) {
			this(centaur, () -> Vec3d.ofBottomCenter(centaur.vaultPos), 10.0f, () -> true);
		}

		public CentaurMovementGoal(CentaurEntity centaur, Supplier<Vec3d> center, double radius, BooleanSupplier requirements) {
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
			double speed = 0.765 / this.radius; // nice constant
			double angle = this.centaur.age * speed;
			if (this.centaur.getType().equals(ArcheonEntities.ARMORED_CENTAUR)) {
				angle += Math.PI / 2.0;
			}
			Vec3d pos = this.center.get();
			double x = pos.getX() + this.radius * Math.cos(angle);
			double z = pos.getZ() + this.radius * Math.sin(angle);
			this.centaur.nextPosition = new Vec3d(x, this.centaur.getY() + 0.5, z);
			this.centaur.getMoveControl().moveTo(x, this.centaur.getY(), z, 2.0f);
		}
	}

	public static class CentaurTargetGoal extends TargetGoal<PlayerEntity> {

		private final CentaurEntity centaur;

		public CentaurTargetGoal(CentaurEntity mob, boolean checkVisibility) {
			super(mob, PlayerEntity.class, checkVisibility);
			this.centaur = mob;
		}

		@Override
		protected Box getSearchBox(double distance) {
			Vec3d base = Vec3d.ofBottomCenter(this.centaur.vaultPos);
			return new Box(base.add(-11.25, 0, -11.25), base.add(11.25, 22.5, 11.25));
		}
	}

	public static class CentaurCrossAttackGoal extends MeleeAttackGoal {

		private final CentaurEntity centaur;
		private final int cooldownInTicks;

		public CentaurCrossAttackGoal(PathAwareEntity mob, int cooldownInTicks, double speed) {
			super(mob, speed, false);
			this.centaur = (CentaurEntity) mob;
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
				if (this.centaur.getWorld() instanceof ServerWorld) {
					this.centaur.firstHalfAction.execute(() -> {
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

		private final CentaurEntity centaur;
		private final int cooldownIntTicks;

		private long lastUpdateTime;

		public CentaurDamageZoneAttackGoal(CentaurEntity centaur, int cooldownIntTicks) {
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
				this.centaur.secondHalfAction.execute(() -> {
					List<Entity> entitiesToOffend = this.centaur.world.getOtherEntities(this.centaur, Box.of(this.centaur.getPos(), 10.0, 1.0, 10.0), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
					entitiesToOffend.forEach(this.centaur::tryAttack);
					this.centaur.world.playSoundFromEntity(null, this.centaur, SoundEvents.ENTITY_RAVAGER_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
				});
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

	public static class CentaurMovingSpearAttackGoal extends Goal {

		// Map of with directions when looking from the side of the panopticon to the center of it as keys and tweaks of the centaur position to the corresponding side position as values
		private static final Map<Direction, TweakFunction<BlockPos>> POSITIONS = MapUtils.builder(map -> {
			map.put(Direction.NORTH, pos -> pos.add(0, 9, 15));
			map.put(Direction.EAST, pos -> pos.add(-15, 9, 0));
			map.put(Direction.SOUTH, pos -> pos.add(0, 9, -15));
			map.put(Direction.WEST, pos -> pos.add(15, 9, 0));
		});

		private static final TriConsumer<World, BlockPos, Direction> PLATFORM_MAKER = (world, pos, direction) -> {
			OrientedBlockPos oriented = OrientedBlockPos.of(pos).apply(direction);
			world.setBlockState(oriented.behind(2), ArcheonBlocks.COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction));
			world.setBlockState(oriented.behind(), ArcheonBlocks.POLISHED_ANHYDRITE.getDefaultState());
			world.setBlockState(oriented, ArcheonBlocks.POLISHED_ANHYDRITE.getDefaultState());
			world.setBlockState(oriented.front(), ArcheonBlocks.GILDED_COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.getOpposite()));
			world.setBlockState(oriented.left().behind(), ArcheonBlocks.GILDED_COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYClockwise()));
			world.setBlockState(oriented.left(), ArcheonBlocks.CHIASPEN_BRICK_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYClockwise()));
			world.setBlockState(oriented.left().front(), ArcheonBlocks.COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYClockwise()).with(Properties.STAIR_SHAPE, StairShape.OUTER_RIGHT));
			world.setBlockState(oriented.right().behind(), ArcheonBlocks.CHIASPEN_BRICK_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYCounterclockwise()));
			world.setBlockState(oriented.right(), ArcheonBlocks.GILDED_COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYCounterclockwise()));
			world.setBlockState(oriented.right().front(), ArcheonBlocks.COBBLED_CHIASPEN_STAIRS.getDefaultState().with(Properties.BLOCK_HALF, BlockHalf.TOP).with(Properties.HORIZONTAL_FACING, direction.rotateYCounterclockwise()).with(Properties.STAIR_SHAPE, StairShape.OUTER_LEFT));
		};

		private static final TriConsumer<World, BlockPos, Direction> PLATFORM_REMOVER = (world, pos, direction) -> {
			OrientedBlockPos oriented = OrientedBlockPos.of(pos).apply(direction);
			world.removeBlock(oriented.behind(2), false);
			world.removeBlock(oriented.behind(), false);
			world.removeBlock(oriented, false);
			world.removeBlock(oriented.front(), false);
			world.removeBlock(oriented.left().behind(), false);
			world.removeBlock(oriented.left(), false);
			world.removeBlock(oriented.left().front(), false);
			world.removeBlock(oriented.right().behind(), false);
			world.removeBlock(oriented.right(), false);
			world.removeBlock(oriented.right().front(), false);
		};

		private final CentaurEntity centaur;
		private final int cooldownInTicks;

		private LivingEntity target;
		private Direction lastDirection;

		public CentaurMovingSpearAttackGoal(CentaurEntity centaur, int cooldownInTicks) {
			this.centaur = centaur;
			this.cooldownInTicks = cooldownInTicks;
		}

		@Override
		public boolean canStart() {
			LivingEntity livingEntity = this.centaur.getTarget();
			if (livingEntity != null && livingEntity.isAlive()) {
				this.target = livingEntity;
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean shouldContinue() {
			return this.target.isAlive();
		}

		@Override
		public void start() {
			this.centaur.getNavigation().stop();
		}

		@Override
		public void stop() {
			this.target = null;
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void tick() {
			if (this.centaur.age % 200 == 0) {
				RandomGenerator random = this.centaur.getRandom();
				Direction direction = Arrays.stream(Direction.values()).filter(current -> current != this.lastDirection && current.getAxis().isHorizontal()).toList().get(random.nextInt(3));
				BlockPos pos = POSITIONS.get(direction).apply(this.centaur.vaultPos);
				PLATFORM_MAKER.accept(this.centaur.world, pos.down(), direction);
				Vec3d vec3d = Vec3d.ofBottomCenter(pos);
				this.centaur.teleport(vec3d.getX(), vec3d.getY() + 10.0, vec3d.getZ());
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
				if (this.lastDirection != null) {
					PLATFORM_REMOVER.accept(this.centaur.world, POSITIONS.get(this.lastDirection).apply(this.centaur.vaultPos).down(), this.lastDirection);
				}
				this.lastDirection = direction;
				this.centaur.secondHalfAction.execute(() -> this.centaur.world.playSoundFromEntity(null, this.centaur, SoundEvents.ENTITY_RAVAGER_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f));
			}
			if (!this.centaur.secondHalfAction.isExecutingAction()) {
				this.centaur.getLookControl().lookAt(this.target, 30.0f, 30.0f);
				if (this.centaur.age % this.cooldownInTicks == 0) {
					if (!this.centaur.getVisibilityCache().canSee(this.target)) {
						return;
					}
					this.centaur.attack(this.target, 0);
				}
			}
		}
	}
}
