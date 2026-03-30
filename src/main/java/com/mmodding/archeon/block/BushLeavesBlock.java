package com.mmodding.archeon.block;

import com.mmodding.library.block.api.catalog.AdvancedLeavesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BushLeavesBlock extends AdvancedLeavesBlock {

	public static final BooleanProperty SOLID = BooleanProperty.of("solid");

	public BushLeavesBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(BushLeavesBlock.SOLID, false));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return state.get(BushLeavesBlock.SOLID) ? super.getCollisionShape(state, world, pos, context) : VoxelShapes.empty();
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BushLeavesBlock.SOLID);
	}
}
