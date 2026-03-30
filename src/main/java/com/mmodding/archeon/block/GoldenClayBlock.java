package com.mmodding.archeon.block;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.library.block.api.catalog.UpsideSensitiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class GoldenClayBlock extends UpsideSensitiveBlock<GoldenClayBlock.Influence> {

	public static final EnumProperty<GoldenClayBlock.Influence> INFLUENCE = UpsideSensitiveBlock.createInfluenceProperty(GoldenClayBlock.Influence.class);

	public GoldenClayBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(GoldenClayBlock.INFLUENCE, Influence.DEFAULT));
	}

	@Override
	public EnumProperty<Influence> getInfluenceProperty() {
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
