package com.mmodding.archeon.block;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.library.block.api.catalog.GrowsDownPlantBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.function.Predicate;

public class AchreanVinesBlock extends GrowsDownPlantBlock {

	private static final Random RANDOM = Random.create();

	public static final BooleanProperty NEAVE_BERRIES = BooleanProperty.of("neave_berries");

	public static final BooleanProperty DONE = BooleanProperty.of("done");

	public AchreanVinesBlock(AbstractBlock.Settings settings, boolean tickWater, float growthChance, int growLength, Predicate<BlockState> chooseStemState) {
		super(Head::new, Body::new, settings, tickWater, growthChance, growLength, chooseStemState);
	}

	@Override
	public BlockState withFruits(BlockState state) {
		return state.with(AchreanVinesBlock.NEAVE_BERRIES, true).with(AchreanVinesBlock.DONE, RANDOM.nextBoolean());
	}

	public static class Head extends GrowsDownPlantBlock.Head implements NeaveBerries {

		protected Head(Settings settings, GrowsDownPlantBlock plant, boolean tickWater, float growthChance, int growLength, Predicate<BlockState> chooseStemState) {
			super(settings, plant, tickWater, growthChance, growLength, chooseStemState);
			this.setDefaultState(this.getDefaultState().with(AchreanVinesBlock.NEAVE_BERRIES, Boolean.FALSE));
			this.setDefaultState(this.getDefaultState().with(AchreanVinesBlock.DONE, Boolean.FALSE));
		}

		@Override
		public BlockState copyState(BlockState from, BlockState to) {
			return to.with(AchreanVinesBlock.NEAVE_BERRIES, from.get(AchreanVinesBlock.NEAVE_BERRIES)).with(AchreanVinesBlock.DONE, from.get(AchreanVinesBlock.DONE));
		}

		@Override
		public BlockState age(BlockState state, Random random) {
			if (random.nextFloat() < 0.11f) {
				return super.age(state, random).with(AchreanVinesBlock.NEAVE_BERRIES, true).with(AchreanVinesBlock.DONE, random.nextBoolean());
			}
			else {
				return super.age(state, random);
			}
		}

		@Override
		public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
			if (world instanceof World casted) {
				return new ItemStack(this.getFruitItem(state, casted, pos));
			}
			else {
				return super.getPickStack(world, pos, state);
			}
		}

		@Override
		public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity ignoredPlayer, Hand ignoredHand, BlockHitResult ignoredHit) {
			return this.pickBerries(state, world, pos);
		}

		@Override
		public boolean isFertilizable(WorldView ignoredWorld, BlockPos ignoredPos, BlockState state, boolean ignoredIsClient) {
			return !state.get(this.getFruitsProperty());
		}

		@Override
		public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
			world.setBlockState(pos, state.with(AchreanVinesBlock.NEAVE_BERRIES, true).with(AchreanVinesBlock.DONE, state.get(AchreanVinesBlock.NEAVE_BERRIES)), Block.NOTIFY_LISTENERS);
		}

		@Override
		public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
			super.appendProperties(builder);
			builder.add(AchreanVinesBlock.NEAVE_BERRIES);
			builder.add(AchreanVinesBlock.DONE);
		}
	}

	public static class Body extends GrowsDownPlantBlock.Body implements NeaveBerries {

		protected Body(Settings settings, GrowsDownPlantBlock plant, boolean tickWater) {
			super(settings, plant, tickWater);
			this.setDefaultState(this.getDefaultState().with(AchreanVinesBlock.NEAVE_BERRIES, Boolean.FALSE));
			this.setDefaultState(this.getDefaultState().with(AchreanVinesBlock.DONE, Boolean.FALSE));
		}

		@Override
		public BlockState copyState(BlockState from, BlockState to) {
			return to.with(AchreanVinesBlock.NEAVE_BERRIES, from.get(AchreanVinesBlock.NEAVE_BERRIES)).with(AchreanVinesBlock.DONE, from.get(AchreanVinesBlock.DONE));
		}

		@Override
		public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
			if (world instanceof World casted) {
				return new ItemStack(this.getFruitItem(state, casted, pos));
			}
			else {
				return super.getPickStack(world, pos, state);
			}
		}

		@Override
		public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity ignoredPlayer, Hand ignoredHand, BlockHitResult ignoredHit) {
			return this.pickBerries(state, world, pos);
		}

		@Override
		public boolean isFertilizable(WorldView ignoredWorld, BlockPos ignoredPos, BlockState state, boolean ignoredIsClient) {
			return !state.get(this.getFruitsProperty());
		}

		@Override
		public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
			boolean canBeDone = state.get(AchreanVinesBlock.NEAVE_BERRIES) && !state.get(AchreanVinesBlock.DONE);
			boolean isAlreadyDone = state.get(AchreanVinesBlock.NEAVE_BERRIES) && state.get(AchreanVinesBlock.DONE);
			world.setBlockState(pos, state.with(AchreanVinesBlock.NEAVE_BERRIES, true).with(AchreanVinesBlock.DONE, canBeDone || isAlreadyDone), Block.NOTIFY_LISTENERS);
		}

		@Override
		public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
			super.appendProperties(builder);
			builder.add(AchreanVinesBlock.NEAVE_BERRIES);
			builder.add(AchreanVinesBlock.DONE);
		}
	}

	private interface NeaveBerries extends FruitsHolder {

		@Override
		default BooleanProperty getFruitsProperty() {
			return AchreanVinesBlock.NEAVE_BERRIES;
		}

		@Override
		default Item getFruitItem(BlockState state, World world, BlockPos pos) {
			return state.get(AchreanVinesBlock.DONE) ? ArcheonItems.NEAVE_BERRIES : ArcheonItems.GROWING_NEAVE_BERRIES;
		}

		@Override
		default int getPickingCount(BlockState state, World world, BlockPos pos) {
			return 1;
		}
	}
}
