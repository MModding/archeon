package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blocks.CustomInfluenceableBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class GoldenClayBlock extends CustomInfluenceableBlock<GoldenClayBlock.Influence> {

	public static final EnumProperty<GoldenClayBlock.Influence> INFLUENCE = CustomInfluenceableBlock.createInfluenceProperty(GoldenClayBlock.Influence.class);

	public GoldenClayBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(GoldenClayBlock.INFLUENCE, Influence.DEFAULT));
	}

	@Override
	protected EnumProperty<Influence> getInfluenceProperty() {
		return GoldenClayBlock.INFLUENCE;
	}

	@Override
	public Influence getInfluence(BlockState state) {
		return state.isOf(ArcheonBlocks.ACHREAN_MOSS) ? Influence.MOSSY : Influence.DEFAULT;
	}

	public enum Influence implements StringIdentifiable {
		DEFAULT("default"),
		MOSSY("mossy");

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
