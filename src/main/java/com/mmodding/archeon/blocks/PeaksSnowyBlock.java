package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blocks.CustomInfluenceableBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class PeaksSnowyBlock extends CustomInfluenceableBlock<PeaksSnowyBlock.Influence> {

	public static final EnumProperty<PeaksSnowyBlock.Influence> INFLUENCE = CustomInfluenceableBlock.createInfluenceProperty(PeaksSnowyBlock.Influence.class);

	public PeaksSnowyBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(PeaksSnowyBlock.INFLUENCE, Influence.DEFAULT));
	}

	@Override
	public EnumProperty<Influence> getInfluenceProperty() {
		return PeaksSnowyBlock.INFLUENCE;
	}

	@Override
	public Influence getInfluence(BlockState state) {
		return state.isOf(ArcheonBlocks.PEAKS_SNOW) || state.isOf(ArcheonBlocks.SNOWY_GRASS_TUFFET) ? Influence.SNOWY : Influence.DEFAULT;
	}

	public enum Influence implements StringIdentifiable {
		DEFAULT("default"),
		SNOWY("snowy");

		private final String name;

		Influence(String name) {
			this.name = name;
		}

		@Override
		public String asString() {
			return this.name;
		}
	}
}
