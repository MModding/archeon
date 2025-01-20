package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class PalmLeavesBlock extends CustomLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 1, 9);

	public PalmLeavesBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	protected IntProperty getDistanceProperty() {
		return PalmLeavesBlock.DISTANCE;
	}

	@Override
	protected int getMaxDistance() {
		return 9;
	}

	@Override
	protected boolean areLeavesConnected() {
		return false;
	}
}
