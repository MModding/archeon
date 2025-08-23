package com.mmodding.archeon.entities.centaur;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.entities.CentaurSpearEntity;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.entities.action.EntityAction;
import com.mmodding.mmodding_lib.library.math.OrientedBlockPos;
import com.mmodding.mmodding_lib.library.utils.MapUtils;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.Arrays;
import java.util.Map;

public class CentaurEntity extends AbstractCentaurEntity implements RangedAttackMob {

	// First Half Goal
	private final Goal spearAttackGoal = new CentaurSpearAttackGoal(this, 1.0, 40, 30.0f);
	// Second Half Goal
	private final Goal movingSpearAttackGoal = new CentaurMovingSpearAttackGoal(this, 30);

	// First Half Action
	public final EntityAction spearAttackAction = new EntityAction(this, Archeon.createId("spear_attack"), 8, 7);
	// Second Half Action
	public final EntityAction movingSpearAttackAction = new EntityAction(this, Archeon.createId("moving_spear_attack"), 15, 12);

	public CentaurEntity(EntityType<? extends AbstractCentaurEntity> entityType, World world) {
		super(entityType, world);
		this.updateGoals();
	}

	public CentaurEntity(World world, BlockPos vaultPos) {
		super(ArcheonEntities.CENTAUR, world, vaultPos);
		this.updateGoals();
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new CentaurMovementGoal(this, () -> this.getTarget() == null && this.isInvalidTimeWithoutTarget()));
		this.targetSelector.add(0, new CentaurTargetGoal(this, true));
	}

	@Override
	protected void updateGoals() {
		if (!this.getWorld().isClient()) {
			this.goalSelector.remove(this.spearAttackGoal);
			this.goalSelector.remove(this.movingSpearAttackGoal);
			if (this.getHealth() >= this.getMaxHealth() / 2) {
				this.goalSelector.add(0, this.spearAttackGoal);
			}
			else {
				this.goalSelector.add(0, this.movingSpearAttackGoal);
			}
		}
	}

	@Override
	protected int getMaxTimeWithoutTarget() {
		return this.getHealth() < this.getMaxHealth() / 2.0f ? 1000 : 200;
	}

	@Override
	public void tick() {
		super.tick();

		this.spearAttackAction.tick();
		this.movingSpearAttackAction.tick();
	}

	public void attack(LivingEntity target, float pullProgress) {
		if (this.getWorld() instanceof ServerWorld serverWorld) {
			this.spearAttackAction.execute(() -> {
				CentaurSpearEntity spear = new CentaurSpearEntity(serverWorld, this, new ItemStack(ArcheonItems.CENTAUR_SPEAR));
				double relativeX = target.getX() - this.getX();
				double relativeY = target.getBodyY(0.4) - spear.getY();
				double relativeZ = target.getZ() - this.getZ();
				double length = Math.sqrt(Math.pow(relativeX, 2) + Math.pow(relativeZ, 2));
				spear.setVelocity(relativeX, relativeY + length * 0.2f, relativeZ, 1.6f, 5 - serverWorld.getDifficulty().getId() * 2.5f);
				this.playSound(SoundEvents.ITEM_TRIDENT_THROW, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
				this.getWorld().spawnEntity(spear);
			});
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
				this.centaur.movingSpearAttackAction.execute(() -> this.centaur.world.playSoundFromEntity(null, this.centaur, SoundEvents.ENTITY_RAVAGER_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f));
			}
			if (!this.centaur.movingSpearAttackAction.isExecutingAction()) {
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
