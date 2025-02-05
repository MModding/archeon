package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BushLeavesBlock extends CustomLeavesBlock {

	public BushLeavesBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return VoxelShapes.empty();
	}
}
