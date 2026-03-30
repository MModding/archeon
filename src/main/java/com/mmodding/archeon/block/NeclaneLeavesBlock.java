package com.mmodding.archeon.block;

import com.mmodding.library.block.api.catalog.AdvancedLeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.IntProperty;

public class NeclaneLeavesBlock extends AdvancedLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 1, 13);

	public NeclaneLeavesBlock(Settings settings) {
		super(settings);
	}

	@Override
	public IntProperty getDistanceProperty() {
		return NeclaneLeavesBlock.DISTANCE;
	}

	@Override
	protected int getMaxDistance() {
		return 13;
	}

	@Override
	protected boolean areLeavesValid(BlockState state) {
		return state.getBlock() instanceof NeclaneLeavesBlock;
	}
}
