package com.mmodding.archeon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class UrnBlock extends Block {

	protected static final VoxelShape SHAPE = UrnBlock.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

	public UrnBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return UrnBlock.SHAPE;
	}
}
