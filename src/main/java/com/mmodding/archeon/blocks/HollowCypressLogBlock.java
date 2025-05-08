package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomPillarBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HollowCypressLogBlock extends CustomPillarBlock implements Waterloggable {

	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	public HollowCypressLogBlock(Settings settings) {
		this(settings, false);
	}

	public HollowCypressLogBlock(Settings settings, boolean hasItem) {
		this(settings, hasItem, (ItemGroup) null);
	}

	public HollowCypressLogBlock(Settings settings, boolean hasItem, ItemGroup itemGroup) {
		this(settings, hasItem, itemGroup != null ? new FabricItemSettings().group(itemGroup) : new FabricItemSettings());
	}

	public HollowCypressLogBlock(Settings settings, boolean hasItem, Item.Settings itemSettings) {
		super(settings, hasItem, itemSettings);
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		Vec3d offset = state.getModelOffset(world, pos);
		return switch (state.get(AXIS)) {
			case X -> VoxelShapes.union(
				createCuboidShape(0, 0, 14, 16, 16, 16),
				createCuboidShape(0, 14, 2, 16, 16, 14),
				createCuboidShape(0, 0, 0, 16, 16, 2),
				createCuboidShape(0, 0, 2, 16, 2, 14)
			).offset(offset.getX(), offset.getY(), offset.getZ());
			case Y -> VoxelShapes.union(
				createCuboidShape(14, 0, 0, 16, 16, 16),
				createCuboidShape(2, 0, 14, 14, 16, 16),
				createCuboidShape(0, 0, 0, 2, 16, 16),
				createCuboidShape(2, 0, 0, 14, 16, 2)
			).offset(offset.getX(), offset.getY(), offset.getZ());
			case Z -> VoxelShapes.union(
				createCuboidShape(14, 0, 0, 16, 16, 16),
				createCuboidShape(2, 14, 0, 14, 16, 16),
				createCuboidShape(0, 0, 0, 2, 16, 16),
				createCuboidShape(2, 0, 0, 14, 2, 16)
			).offset(offset.getX(), offset.getY(), offset.getZ());
		};
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		boolean flag = ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER;
		return Objects.requireNonNull(super.getPlacementState(ctx)).with(WATERLOGGED, flag);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false): super.getFluidState(state);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) {
			world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}
}
