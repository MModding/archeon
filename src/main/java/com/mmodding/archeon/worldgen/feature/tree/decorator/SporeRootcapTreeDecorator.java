package com.mmodding.archeon.worldgen.feature.tree.decorator;

import com.mmodding.archeon.block.SporeRootcapBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonTreeParts;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class SporeRootcapTreeDecorator extends TreeDecorator {

	public static final SporeRootcapTreeDecorator INSTANCE = new SporeRootcapTreeDecorator();

	public static final Codec<SporeRootcapTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

	public SporeRootcapTreeDecorator() {
	}

	@Override
	public TreeDecoratorType<?> getType() {
		return ArcheonTreeParts.SPORE_ROOTCAP_DECORATOR;
	}

	@Override
	public void generate(Generator placer) {
		placer.getLogPositions().forEach(pos -> {
			for (Direction direction : Direction.Type.HORIZONTAL) {
				if (placer.getWorld().testBlockState(pos.offset(direction), BlockState::isAir) && placer.getRandom().nextFloat() <= 0.1f) {
					placer.replace(
						pos.offset(direction),
						ArcheonBlocks.SPORE_ROOTCAP.getDefaultState().with(SporeRootcapBlock.FACING, direction)
					);
				}
			}
		});
	}
}
