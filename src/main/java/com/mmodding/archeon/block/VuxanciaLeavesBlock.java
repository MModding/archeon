package com.mmodding.archeon.block;

import com.mmodding.library.block.api.catalog.AdvancedLeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class VuxanciaLeavesBlock extends AdvancedLeavesBlock {

	public VuxanciaLeavesBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
		return this.getCollisionShape(state, world, pos, ShapeContext.absent());
	}
}
