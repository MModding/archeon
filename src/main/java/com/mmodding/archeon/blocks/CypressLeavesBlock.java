package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class CypressLeavesBlock extends CustomLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 1, 19);

	public CypressLeavesBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public IntProperty getDistanceProperty() {
		return CypressLeavesBlock.DISTANCE;
	}

	@Override
	protected int getMaxDistance() {
		return 19;
	}
}
