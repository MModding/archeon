package com.mmodding.archeon.blockentities;

import com.mmodding.archeon.blocks.CentaurLifeVaultBlock;
import com.mmodding.archeon.entities.centaur.AbstractCentaurEntity;
import com.mmodding.archeon.entities.centaur.ArmoredCentaurEntity;
import com.mmodding.archeon.entities.centaur.CentaurEntity;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.archeon.init.ArcheonMiscellaneous;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CentaurLifeVaultBlockEntity extends BlockEntity {

	@Nullable
	private ArmoredCentaurEntity armoredCentaurEntity = null;

	@Nullable
	private CentaurEntity centaurEntity = null;

	public CentaurLifeVaultBlockEntity(BlockPos pos, BlockState state) {
		super(ArcheonBlockEntities.CENTAUR_LIFE_VAULT, pos, state);
	}

	public ArmoredCentaurEntity initArmoredCentaur(ServerWorld world, BlockPos pos) {
		ArmoredCentaurEntity entity = new ArmoredCentaurEntity(world, pos);
		entity.setPosition(Vec3d.ofCenter(pos.west(13)));
		entity.setStackInHand(Hand.MAIN_HAND, ArcheonItems.CENTAUR_BATTLE_AXE.getDefaultStack());
		entity.setupBossBar();
		world.spawnEntity(entity);
		return entity;
	}

	public CentaurEntity initCentaur(ServerWorld world, BlockPos pos) {
		CentaurEntity entity = new CentaurEntity(world, pos);
		entity.setPosition(Vec3d.ofCenter(pos.east(13)));
		entity.setStackInHand(Hand.MAIN_HAND, ArcheonItems.CENTAUR_SPEAR.getDefaultStack());
		entity.setupBossBar();
		world.spawnEntity(entity);
		return entity;
	}

	public void beginFight(ServerWorld world, BlockPos pos, BlockState state) {
		world.setBlockState(pos, state.with(CentaurLifeVaultBlock.LIVES, CentaurLifeVaultBlock.Lives.FULL));
		world.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX() - 0.5, pos.getY() - 0.5, pos.getZ() - 0.5, 10, 1, 1, 1, 3.0f);
		this.armoredCentaurEntity = this.initArmoredCentaur(world, pos);
		this.centaurEntity = this.initCentaur(world, pos);
	}

	public static void tick(World world, BlockPos pos, BlockState state, CentaurLifeVaultBlockEntity blockEntity) {
		ServerWorld serverWorld = (ServerWorld) world;
		Phase phase = blockEntity.getPhase();
		if (phase != null) {
			WorldUtils.getPlayersAround(serverWorld, Vec3d.ofCenter(pos), length -> length <= 50.0).forEach(player -> {
				player.getSoundtrackPlayer().lock(ArcheonMiscellaneous.ELKIN);
				int fromPart, toPart;
				switch (phase) {
					case FIRST_PHASE -> {
						fromPart = 0;
						toPart = 1;
					}
					case FIRST_PHASE_HALF -> {
						fromPart = 2;
						toPart = 2;
					}
					case SECOND_PHASE -> {
						fromPart = 3;
						toPart = 4;
					}
					case SECOND_PHASE_HALF -> {
						fromPart = 5;
						toPart = 5;
					}
					case DEATH -> {
						fromPart = 6;
						toPart = 6;
					}
					default -> throw new IllegalStateException("Unexpected value: " + phase);
				}
				player.getSoundtrackPlayer().play(ArcheonMiscellaneous.ELKIN, fromPart, toPart);
				player.getSoundtrackPlayer().seal();
			});
			WorldUtils.getPlayersAround(serverWorld, Vec3d.ofCenter(pos), length -> length >= 50.0 && length <= 60.0).forEach(player -> {
				player.getSoundtrackPlayer().unlock();
				player.getSoundtrackPlayer().clear();
				player.getSoundtrackPlayer().unseal();
			});
		}
		if (blockEntity.armoredCentaurEntity != null && blockEntity.armoredCentaurEntity.isDead()) {
			blockEntity.armoredCentaurEntity = null;
		}
		if (blockEntity.centaurEntity != null && blockEntity.centaurEntity.isDead()) {
			blockEntity.centaurEntity = null;
		}
	}

	public void releaseSoundtrack() {
		if (this.world instanceof ServerWorld serverWorld) {
			WorldUtils.getPlayersAround(serverWorld, Vec3d.ofCenter(this.getPos()), length -> length <= 50.0).forEach(player -> {
				player.getSoundtrackPlayer().release();
				player.getSoundtrackPlayer().unseal();
			});
		}
	}

	public boolean hasMoreThanHalfItsLife(@Nullable AbstractCentaurEntity centaurEntity) {
		return centaurEntity != null && !centaurEntity.isDead() && centaurEntity.getHealth() >= centaurEntity.getMaxHealth() / 2.0f;
	}

	public boolean hasLessThanHalfItsLife(@Nullable AbstractCentaurEntity centaurEntity) {
		return centaurEntity != null && !centaurEntity.isDead() && centaurEntity.getHealth() <= centaurEntity.getMaxHealth() / 2.0f;
	}

	public boolean isDead(@Nullable AbstractCentaurEntity centaurEntity) {
		return centaurEntity == null || centaurEntity.isDead();
	}

	@Nullable
	public Phase getPhase() {
		if (this.armoredCentaurEntity == null && this.centaurEntity == null) {
			return null;
		}
		else if (this.hasMoreThanHalfItsLife(this.armoredCentaurEntity) && this.hasMoreThanHalfItsLife(this.centaurEntity)) {
			return Phase.FIRST_PHASE;
		}
		else {
			boolean armoredCentaurBelowHalf = this.hasLessThanHalfItsLife(this.armoredCentaurEntity) && this.hasMoreThanHalfItsLife(this.centaurEntity);
			boolean centaurBelowHalf = this.hasMoreThanHalfItsLife(this.armoredCentaurEntity) && this.hasLessThanHalfItsLife(this.centaurEntity);
			if (armoredCentaurBelowHalf || centaurBelowHalf) {
				return Phase.FIRST_PHASE_HALF;
			}
			else {
				boolean bothBelowHalf = this.hasLessThanHalfItsLife(this.armoredCentaurEntity) && this.hasLessThanHalfItsLife(this.centaurEntity);
				boolean armoredCentaurDead = this.isDead(this.armoredCentaurEntity) && this.hasMoreThanHalfItsLife(this.centaurEntity);
				boolean centaurDead = this.hasMoreThanHalfItsLife(this.armoredCentaurEntity) && this.isDead(this.centaurEntity);
				if (bothBelowHalf || armoredCentaurDead || centaurDead) {
					return Phase.SECOND_PHASE;
				}
				else {
					boolean armoredCentaurDeadAndCentaurBelowHalf = this.isDead(this.armoredCentaurEntity) && this.hasLessThanHalfItsLife(this.centaurEntity);
					boolean centaurDeadAndArmoredCentaurBelowHalf = this.hasLessThanHalfItsLife(this.armoredCentaurEntity) && this.isDead(this.centaurEntity);
					if (armoredCentaurDeadAndCentaurBelowHalf || centaurDeadAndArmoredCentaurBelowHalf) {
						return Phase.SECOND_PHASE_HALF;
					}
				}
			}
		}
		return Phase.DEATH;
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		if (this.world instanceof ServerWorld serverWorld) {
			if (nbt.contains("armored_centaur_uuid")) {
				this.armoredCentaurEntity = (ArmoredCentaurEntity) serverWorld.getEntity(nbt.getUuid("armored_centaur_uuid"));
			}
			if (nbt.contains("centaur_uuid")) {
				this.centaurEntity = (CentaurEntity) serverWorld.getEntity(nbt.getUuid("centaur_uuid"));
			}
		}
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		if (this.world instanceof ServerWorld) {
			if (this.armoredCentaurEntity != null) {
				nbt.putUuid("armored_centaur_uuid", this.armoredCentaurEntity.getUuid());
			}
			if (this.centaurEntity != null) {
				nbt.putUuid("centaur_uuid", this.centaurEntity.getUuid());
			}
		}
	}

	public enum Phase {

		/**
		 * When both centaurs have more than half their lives.
		 */
		FIRST_PHASE,

		/**
		 * When one centaur has less than half its life.
		 */
		FIRST_PHASE_HALF,

		/**
		 * When both centaurs have less than half their lives or that one centaur is dead and that the other has more than half its life.
		 */
		SECOND_PHASE,

		/**
		 * When one centaur is dead and that the other has less than half its life.
		 */
		SECOND_PHASE_HALF,

		/**
		 * When booth centaurs are dead.
		 */
		DEATH
	}
}
