package com.mmodding.archeon.block;

import com.mmodding.library.block.api.catalog.AdvancedLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class PalmLeavesBlock extends AdvancedLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 1, 9);

	public PalmLeavesBlock(Settings settings) {
		super(settings);
	}

	@Override
	public IntProperty getDistanceProperty() {
		return PalmLeavesBlock.DISTANCE;
	}

	@Override
	protected int getMaxDistance() {
		return 9;
	}

	@Override
	public boolean areLeavesConnected() {
		return false;
	}
}
