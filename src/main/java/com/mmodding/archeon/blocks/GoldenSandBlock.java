package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blocks.CustomInfluenceableBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.LandingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class GoldenSandBlock extends CustomInfluenceableBlock<GoldenSandBlock.Influence> implements LandingBlock {

	public static final EnumProperty<GoldenSandBlock.Influence> INFLUENCE = CustomInfluenceableBlock.createInfluenceProperty(GoldenSandBlock.Influence.class);

	public GoldenSandBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(GoldenSandBlock.INFLUENCE, Influence.DEFAULT));
	}

	@Override
	protected EnumProperty<Influence> getInfluenceProperty() {
		return GoldenSandBlock.INFLUENCE;
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		world.scheduleBlockTick(pos, this, 2);
		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		if (FallingBlock.canFallThrough(world.getBlockState(pos.down())) && pos.getY() >= world.getBottomY()) {
			FallingBlockEntity.fall(world, pos, state);
		}
	}

	public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
		if (random.nextInt(16) == 0) {
			BlockPos down = pos.down();
			if (FallingBlock.canFallThrough(world.getBlockState(down))) {
				world.addParticle(
					new BlockStateParticleEffect(ParticleTypes.FALLING_DUST, state),
					pos.getX() + random.nextDouble(),
					pos.getY() - 0.05,
					pos.getZ() + random.nextDouble(),
					0.0,
					0.0,
					0.0
				);
			}
		}
	}

	@Override
	public Influence getInfluence(BlockState state) {
		return state.isOf(ArcheonBlocks.ACHREAN_MOSS) ? Influence.MOSSY : Influence.DEFAULT;
	}

	public enum Influence implements StringIdentifiable {
		DEFAULT("default"),
		MOSSY("mossy");

		private final String name;

		Influence(String name) {
			this.name = name;
		}

		@Override
		public String asString() {
			return this.name;
		}
	}
}
