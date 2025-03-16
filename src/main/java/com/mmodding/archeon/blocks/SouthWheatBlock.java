package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.blocks.CustomTallPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SouthWheatBlock extends CustomTallPlantBlock implements Fertilizable {

	public static final IntProperty AGE = IntProperty.of("age", 0, 4);

	public SouthWheatBlock(Predicate<BlockState> placementConditions, Settings settings, boolean hasItem) {
		super(placementConditions, settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(SouthWheatBlock.AGE, 0));
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {}

	public boolean isMature(BlockState state) {
		return state.get(SouthWheatBlock.AGE) >= 4;
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return state.get(CustomTallPlantBlock.HALF).equals(DoubleBlockHalf.LOWER) && !this.isMature(state);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		if (world.getBaseLightLevel(pos, 0) >= 9 && !this.isMature(state)) {
			if (state.get(SouthWheatBlock.AGE) != 1 || world.getBlockState(pos.up()).isAir()) {
				if (random.nextInt(10) == 0) {
					world.setBlockState(pos, state.with(SouthWheatBlock.AGE, state.get(SouthWheatBlock.AGE) + 1), Block.NOTIFY_LISTENERS);
					if (state.get(SouthWheatBlock.AGE) >= 1) {
						BlockState upperState = state.with(SouthWheatBlock.HALF, DoubleBlockHalf.UPPER);
						world.setBlockState(pos.up(), upperState.with(SouthWheatBlock.AGE, state.get(SouthWheatBlock.AGE) + 1), Block.NOTIFY_LISTENERS);
					}
				}
			}
		}
	}

	@Override
	public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
		return ArcheonItems.PLANT_FIBER.getDefaultStack();
	}

	@Override
	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMature(state);
	}

	@Override
	public boolean canGrow(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return state.get(SouthWheatBlock.AGE) != 1 || world.getBlockState(pos.up()).isAir();
	}

	public void applyGrowth(World world, RandomGenerator random, BlockPos pos, BlockState state, boolean head) {
		int age = (int) MathHelper.absMax(state.get(SouthWheatBlock.AGE) + MathHelper.nextInt(random, 1, 3), 4);
		if (head) {
			this.applyGrowth(world, pos, state, age);
			this.applyGrowth(world, pos.down(), world.getBlockState(pos.down()), age);
		}
		else {
			this.applyGrowth(world, pos, state, age);
			if (age >= 2) {
				BlockState upperState = ArcheonBlocks.SOUTH_WHEAT.getDefaultState().with(SouthWheatBlock.HALF, DoubleBlockHalf.UPPER);
				this.applyGrowth(world, pos.up(), upperState, age);
			}
		}
	}

	public void applyGrowth(World world, BlockPos pos, BlockState state, int age) {
		world.setBlockState(pos, state.with(SouthWheatBlock.AGE, age));
	}

	@Override
	public void grow(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		this.applyGrowth(world, random, pos, state, state.get(CustomTallPlantBlock.HALF).equals(DoubleBlockHalf.UPPER));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(SouthWheatBlock.AGE);
	}
}
