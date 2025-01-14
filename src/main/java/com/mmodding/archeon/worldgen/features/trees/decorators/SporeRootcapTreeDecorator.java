package com.mmodding.archeon.worldgen.features.trees.decorators;

import com.mmodding.archeon.blocks.SporeRootcapBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class SporeRootcapTreeDecorator extends CustomTreeDecorator {

	public static final SporeRootcapTreeDecorator INSTANCE = new SporeRootcapTreeDecorator();

	public static final Codec<SporeRootcapTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

	public SporeRootcapTreeDecorator() {
	}

	@Override
	public TreeDecoratorType<?> getType() {
		return ArcheonFeatures.SPORE_ROOTCAP_TREE_DECORATOR;
	}

	@Override
	public void generate(Placer placer) {
		placer.getLogPositions().forEach(pos -> {
			for (Direction direction : Direction.Type.HORIZONTAL) {
				if (placer.getWorld().testBlockState(pos.offset(direction), BlockState::isAir) && placer.getRandom().nextFloat() <= 0.3f) {
					placer.replace(
						pos.offset(direction),
						ArcheonBlocks.SPORE_ROOTCAP.getDefaultState().with(SporeRootcapBlock.FACING, direction)
					);
				}
			}
		});
	}
}
