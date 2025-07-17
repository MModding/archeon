package com.mmodding.archeon.entities;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blockentities.ArcheonBlockEntities;
import com.mmodding.archeon.blockentities.CentaurLifeVaultBlockEntity;
import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.action.EntityAction;
import com.mmodding.mmodding_lib.library.entities.goals.CooledDownMeleeAttackGoal;
import com.mmodding.mmodding_lib.library.math.OrientedBlockPos;
import com.mmodding.mmodding_lib.library.utils.MapUtils;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.apache.logging.log4j.util.TriConsumer;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class CentaurEntity extends HostileEntity implements RangedAttackMob {

	private static final TrackedData<Integer> TIME_WITHOUT_TARGET = DataTracker.registerData(CentaurEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public final EntityAction firstHalfAction;
	public final EntityAction secondHalfAction;

	private final ServerBossBar bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.YELLOW, BossBar.Style.PROGRESS);

	private final Goal firstHalfGoal;
	private final Goal secondHalfGoal;

	public AnimationState breathing = new AnimationState();
	public AnimationState galloping = new AnimationState();

	private BlockPos vaultPos = BlockPos.ORIGIN;

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
		this.goalSelector.add(1, new CentaurMovementGoal(this));
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
		this.galloping.start(this.age);
	}

	@Override
	protected void mobTick() {
		super.mobTick();

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

	public static class CentaurMovementGoal extends Goal {

		private final CentaurEntity centaur;

		public CentaurMovementGoal(CentaurEntity centaur) {
			this.centaur = centaur;
			this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
		}

		@Override
		public boolean canStart() {
			if (this.centaur.getType().equals(ArcheonEntities.CENTAUR) && this.centaur.getHealth() <= this.centaur.getMaxHealth() / 2.0f) {
				return false;
			}
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

	public static class CentaurTargetGoal extends TargetGoal<PlayerEntity> {

		private final CentaurEntity centaur;

		public CentaurTargetGoal(CentaurEntity mob, boolean checkVisibility) {
			super(mob, PlayerEntity.class, checkVisibility);
			this.centaur = mob;
		}

		@Override
		protected Box getSearchBox(double distance) {
			return Box.of(Vec3d.ofCenter(this.centaur.vaultPos), 22.5, 22.5, 22.5);
		}
	}

	public static class CentaurCrossAttackGoal extends CooledDownMeleeAttackGoal {

		private final CentaurEntity centaur;

		public CentaurCrossAttackGoal(PathAwareEntity mob, int cooldownInTicks, double speed) {
			super(mob, cooldownInTicks, speed);
			this.centaur = (CentaurEntity) mob;
		}

		@Override
		protected void tryAttack(LivingEntity target) {
			if (this.centaur.getWorld() instanceof ServerWorld) {
				this.centaur.firstHalfAction.execute(() -> {
					this.centaur.tryAttack(target);
					Vec3d relativePos = this.mob.getPos().add(target.getPos());
					Vec3d velocity = relativePos.multiply(0.25);
					target.addVelocity(velocity.x, 0.6f, velocity.z);
				});
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
		private int cooldown;

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
			this.cooldown = 0;
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
			if (this.cooldown > 0) {
				this.cooldown -= 1;
			}
			else if (this.cooldown == 0) {
				LivingEntity target = this.centaur.getTarget();
				assert target != null;
				this.centaur.teleport(target.getX(), target.getY() + 10.0, target.getZ());
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
				this.cooldown = -1; // Prevents repeated execution
				this.centaur.secondHalfAction.execute(() -> {
					List<Entity> entitiesToOffend = this.centaur.world.getOtherEntities(this.centaur, Box.of(this.centaur.getPos(), 10.0, 1.0, 10.0), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);
					entitiesToOffend.forEach(this.centaur::tryAttack);
					this.centaur.world.playSoundFromEntity(null, this.centaur, SoundEvents.ENTITY_RAVAGER_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
				});
				WorldUtils.doSyncedTaskAfter(this.centaur.world, 27, () -> this.cooldown = this.getTickCount(this.cooldownIntTicks));
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
		private int cooldown;
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
			this.cooldown = -1;
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
				if (this.cooldown-- == 0) {
					if (!this.centaur.getVisibilityCache().canSee(this.target)) {
						return;
					}
					this.centaur.attack(this.target, 0);
					this.cooldown = this.getTickCount(this.cooldownInTicks);
				} else if (this.cooldown < 0) {
					this.cooldown = this.getTickCount(this.cooldownInTicks);
				}
			}
		}
	}
}
