package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomBedBlock;
import com.mmodding.mmodding_lib.library.utils.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BedPart;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class NeclaneBedBlock extends CustomBedBlock {

	protected static final VoxelShapeUtils.RotatingVoxelShapeFactory HEAD_SHAPE = VoxelShapeUtils.rotatingUnion(
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 0.0, 0.0, 2.0, 2.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 14.0, 0.0, 0.0, 16.0, 2.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 2.0, 0.0, 16.0, 6.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 6.0, 0.0, 16.0, 13.0, 2.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 3.0, 6.0, 2.0, 13.0, 7.75, 7.5)
	);

	protected static final VoxelShapeUtils.RotatingVoxelShapeFactory FOOT_SHAPE = VoxelShapeUtils.rotatingUnion(
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 0.0, 0.0, 2.0, 2.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 14.0, 0.0, 0.0, 16.0, 2.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 2.0, 0.0, 16.0, 6.0, 16.0),
		VoxelShapeUtils.horizontalRotatingCuboid(Block::createCuboidShape, 0.0, 6.0, 14.0, 16.0, 9.0, 16.0)
	);

	protected static final VoxelShape NORTH_HEAD_SHAPE = NeclaneBedBlock.HEAD_SHAPE.create(Direction.NORTH);
	protected static final VoxelShape WEST_HEAD_SHAPE = NeclaneBedBlock.HEAD_SHAPE.create(Direction.WEST);
	protected static final VoxelShape SOUTH_HEAD_SHAPE = NeclaneBedBlock.HEAD_SHAPE.create(Direction.SOUTH);
	protected static final VoxelShape EAST_HEAD_SHAPE = NeclaneBedBlock.HEAD_SHAPE.create(Direction.EAST);

	protected static final VoxelShape NORTH_FOOT_SHAPE = NeclaneBedBlock.FOOT_SHAPE.create(Direction.NORTH);
	protected static final VoxelShape WEST_FOOT_SHAPE = NeclaneBedBlock.FOOT_SHAPE.create(Direction.WEST);
	protected static final VoxelShape SOUTH_FOOT_SHAPE = NeclaneBedBlock.FOOT_SHAPE.create(Direction.SOUTH);
	protected static final VoxelShape EAST_FOOT_SHAPE = NeclaneBedBlock.FOOT_SHAPE.create(Direction.EAST);

	public NeclaneBedBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		if (state.get(NeclaneBedBlock.PART).equals(BedPart.HEAD)) {
			return switch (state.get(NeclaneBedBlock.FACING)) {
				case NORTH -> NeclaneBedBlock.NORTH_HEAD_SHAPE;
				case WEST -> NeclaneBedBlock.WEST_HEAD_SHAPE;
				case SOUTH -> NeclaneBedBlock.SOUTH_HEAD_SHAPE;
				case EAST -> NeclaneBedBlock.EAST_HEAD_SHAPE;
				default -> throw new IllegalStateException("Invalid facing direction");
			};
		}
		else {
			return switch (state.get(NeclaneBedBlock.FACING)) {
				case NORTH -> NeclaneBedBlock.NORTH_FOOT_SHAPE;
				case SOUTH -> NeclaneBedBlock.SOUTH_FOOT_SHAPE;
				case WEST -> NeclaneBedBlock.WEST_FOOT_SHAPE;
				case EAST -> NeclaneBedBlock.EAST_FOOT_SHAPE;
				default -> throw new IllegalStateException("Invalid facing direction");
			};
		}
	}
}
