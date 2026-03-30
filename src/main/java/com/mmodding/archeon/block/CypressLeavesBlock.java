package com.mmodding.archeon.block;

import com.mmodding.library.block.api.catalog.AdvancedLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class CypressLeavesBlock extends AdvancedLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 1, 19);

	public CypressLeavesBlock(Settings settings) {
		super(settings);
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
