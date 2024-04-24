package fr.firstmegagame4.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomInfluenceableBlock;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class GlowshroomableBlock extends CustomInfluenceableBlock<GlowshroomableBlock.Influence> {

	public static final EnumProperty<GlowshroomableBlock.Influence> INFLUENCE = CustomInfluenceableBlock.createInfluenceProperty(GlowshroomableBlock.Influence.class);

	public GlowshroomableBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(GlowshroomableBlock.INFLUENCE, Influence.DEFAULT));
	}

	@Override
	protected EnumProperty<Influence> getInfluenceProperty() {
		return GlowshroomableBlock.INFLUENCE;
	}

	@Override
	public Influence getInfluence(BlockState state) {
		return state.isOf(ArcheonBlocks.GLOWSHROOM_MOSS) ? Influence.MOSSY : Influence.DEFAULT;
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
