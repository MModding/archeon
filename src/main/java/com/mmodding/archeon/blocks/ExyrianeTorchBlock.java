package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLanternBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ExyrianeTorchBlock extends CustomLanternBlock {

	protected static final VoxelShape STANDING_SHAPE = VoxelShapes.union(
		Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 2.0, 12.0),
		Block.createCuboidShape(5.0, 2.0, 5.0, 11.0, 6.0, 11.0),
		Block.createCuboidShape(4.0, 6.0, 4.0, 12.0, 8.0, 12.0),
		Block.createCuboidShape(5.0, 8.0, 5.0, 11.0, 9.0, 11.0)
	);

	protected static final VoxelShape HANGING_SHAPE = VoxelShapes.union(
		Block.createCuboidShape(4.0, 3.0, 4.0, 12.0, 5.0, 12.0),
		Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 9.0, 11.0),
		Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 11.0, 12.0),
		Block.createCuboidShape(5.0, 11.0, 5.0, 11.0, 12.0, 11.0)
	);

	public ExyrianeTorchBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return state.get(ExyrianeTorchBlock.HANGING) ? ExyrianeTorchBlock.HANGING_SHAPE : ExyrianeTorchBlock.STANDING_SHAPE;
	}
}
