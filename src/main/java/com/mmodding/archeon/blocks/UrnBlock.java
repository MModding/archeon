package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class UrnBlock extends CustomBlock {

	protected static final VoxelShape SHAPE = UrnBlock.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

	public UrnBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return UrnBlock.SHAPE;
	}
}
