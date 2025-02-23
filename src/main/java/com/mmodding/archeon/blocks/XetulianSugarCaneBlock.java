package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blocks.CustomSugarCaneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class XetulianSugarCaneBlock extends CustomSugarCaneBlock {

	public static final BooleanProperty HEAD = BooleanProperty.of("head");

	public XetulianSugarCaneBlock(@Nullable Predicate<BlockState> validFloor, @Nullable BiPredicate<BlockState, FluidState> validFluid, Settings settings, boolean hasItem) {
		super(validFloor, validFluid, settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(XetulianSugarCaneBlock.HEAD, false));
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos).with(
			XetulianSugarCaneBlock.HEAD,
			!world.getBlockState(pos.up()).isOf(ArcheonBlocks.XETULIAN_SUGAR_CANE)
		);
	}

	@Override
	public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockState state = super.getPlacementState(ctx);
		if (state != null) {
			return state.with(
				XetulianSugarCaneBlock.HEAD,
				!ctx.getWorld().getBlockState(ctx.getBlockPos().up()).isOf(ArcheonBlocks.XETULIAN_SUGAR_CANE)
			);
		}
		else {
			return null;
		}
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(XetulianSugarCaneBlock.HEAD);
	}
}
