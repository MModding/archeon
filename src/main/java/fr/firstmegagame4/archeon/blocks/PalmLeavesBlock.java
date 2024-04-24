package fr.firstmegagame4.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import net.minecraft.state.property.IntProperty;

public class PalmLeavesBlock extends CustomLeavesBlock {

	public static final IntProperty DISTANCE = IntProperty.of("distance", 0, 9);

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
	protected boolean hasSeparatedLeaves() {
		return true;
	}
}
