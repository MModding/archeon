package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class NeclaneLeavesBlock extends CustomLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 0, 13);

	public NeclaneLeavesBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	protected IntProperty getDistanceProperty() {
		return NeclaneLeavesBlock.DISTANCE;
	}

	@Override
	protected int getMaxDistance() {
		return 13;
	}
}
