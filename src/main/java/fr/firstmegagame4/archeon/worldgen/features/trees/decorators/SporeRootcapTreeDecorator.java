package fr.firstmegagame4.archeon.worldgen.features.trees.decorators;

import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class SporeRootcapTreeDecorator extends CustomTreeDecorator {

	public static final SporeRootcapTreeDecorator INSTANCE = new SporeRootcapTreeDecorator();

	public static final Codec<SporeRootcapTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

	public SporeRootcapTreeDecorator() {
	}

	@Override
	public TreeDecoratorType<?> getType() {
		return null;
	}

	@Override
	public void generate(Placer placer) {

	}
}
