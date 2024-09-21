package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.mmodding_lib.library.blocks.CustomDoubleWidthBlock;
import com.mmodding.mmodding_lib.library.items.settings.AdvancedItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.WaterPlaceableBlockItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class GiantLilyBlock extends CustomDoubleWidthBlock {

	protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.5, 16.0);

	private final BlockItem waterPlaceableBlockItem = new WaterPlaceableBlockItem(this, new AdvancedItemSettings());

	public GiantLilyBlock(Settings settings) {
		super(settings, false);
	}

	@Override
	public BlockItem getItem() {
		return this.waterPlaceableBlockItem;
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(state, world, pos, entity);
		if (world instanceof ServerWorld && entity instanceof BoatEntity) {
			world.breakBlock(new BlockPos(pos), true, entity);
		}
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return GiantLilyBlock.SHAPE;
	}

	@Override
	public boolean canPlacePartAt(WorldView world, BlockPos pos, BlockState state, @Nullable ItemPlacementContext ctx) {
		return super.canPlacePartAt(world, pos, state, ctx) && this.canPlantOnTop(world, pos.down());
	}

	public boolean canPlantOnTop(BlockView world, BlockPos pos) {
		FluidState currentFluidState = world.getFluidState(pos);
		FluidState upperFluidState = world.getFluidState(pos.up());
		return (currentFluidState.isOf(ArcheonFluids.HOT_SPRING_WATER.getStill()) || currentFluidState.isOf(Fluids.WATER)) && upperFluidState.isEmpty();
	}
}
