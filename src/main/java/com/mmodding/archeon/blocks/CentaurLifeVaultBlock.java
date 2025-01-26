package com.mmodding.archeon.blocks;

import com.mmodding.archeon.entities.CentaurEntity;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.blocks.CustomBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CentaurLifeVaultBlock extends CustomBlock {

	public static final EnumProperty<Lives> LIVES = EnumProperty.of("lives", Lives.class);

	public CentaurLifeVaultBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(CentaurLifeVaultBlock.LIVES, Lives.EMPTY));
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if (!world.isClient()) {
			world.scheduleBlockTick(pos, this, 20);
		}
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		world.setBlockState(pos, state.with(CentaurLifeVaultBlock.LIVES, Lives.FULL));
		world.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX() - 0.5, pos.getY() - 0.5, pos.getZ() - 0.5, 10, 1, 1, 1, 3.0f);
		CentaurEntity armoredCentaurEntity = new CentaurEntity(world, pos, true);
		armoredCentaurEntity.setPosition(Vec3d.ofCenter(pos.west(13)));
		armoredCentaurEntity.setStackInHand(Hand.MAIN_HAND, ArcheonItems.CENTAUR_BATTLE_AXE.getDefaultStack());
		CentaurEntity centaurEntity = new CentaurEntity(world, pos, false);
		centaurEntity.setPosition(Vec3d.ofCenter(pos.east(13)));
		centaurEntity.setStackInHand(Hand.MAIN_HAND, ArcheonItems.CENTAUR_SPEAR.getDefaultStack());
		armoredCentaurEntity.setupBossBar();
		centaurEntity.setupBossBar();
		world.spawnEntity(armoredCentaurEntity);
		world.spawnEntity(centaurEntity);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(CentaurLifeVaultBlock.LIVES);
	}

	public enum Lives implements StringIdentifiable {
		EMPTY("empty"),
		LEFT("left"),
		RIGHT("right"),
		FULL("full");

		private final String identifier;

		Lives(String identifier) {
			this.identifier = identifier;
		}

		@Override
		public String asString() {
			return this.identifier;
		}

		public Lives decadeLeft() {
			return switch (this) {
				case EMPTY, LEFT -> Lives.EMPTY;
				case RIGHT, FULL -> Lives.RIGHT;
			};
		}

		public Lives decadeRight() {
			return switch (this) {
				case EMPTY, RIGHT -> Lives.EMPTY;
				case LEFT, FULL -> Lives.LEFT;
			};
		}
	}
}
