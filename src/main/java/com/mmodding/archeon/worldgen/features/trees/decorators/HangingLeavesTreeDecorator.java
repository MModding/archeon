package com.mmodding.archeon.worldgen.features.trees.decorators;

import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class HangingLeavesTreeDecorator extends CustomTreeDecorator {

	public static final HangingLeavesTreeDecorator INSTANCE = new HangingLeavesTreeDecorator();

	public static final Codec<HangingLeavesTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

	public HangingLeavesTreeDecorator() {
	}

	@Override
	public TreeDecoratorType<?> getType() {
		return ArcheonFeatures.HANGING_LEAVES_TREE_DECORATOR;
	}

	@Override
	public void generate(Placer placer) {

	}
}
