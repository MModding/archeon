package com.mmodding.archeon.block;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.library.block.api.catalog.UpsideSensitiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class PeaksSnowyBlock extends UpsideSensitiveBlock<PeaksSnowyBlock.Influence> {

	public static final EnumProperty<PeaksSnowyBlock.Influence> INFLUENCE = UpsideSensitiveBlock.createInfluenceProperty(PeaksSnowyBlock.Influence.class);

	public PeaksSnowyBlock(Settings settings) {
		super(settings);
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
