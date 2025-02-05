package com.mmodding.archeon.worldgen.features.trees.decorators;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.blocks.CustomGrowsDownPlantBlock;
import com.mmodding.mmodding_lib.library.blocks.CustomLeavesBlock;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTreeDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

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
		List<BlockPos> leaves = placer.getLeafPositions().stream()
			.filter(pos -> placer.getWorld().testBlockState(pos, state -> state.getBlock() instanceof CustomLeavesBlock))
			.toList();
		BlockPos testingPos = leaves.get(0);
		CustomGrowsDownPlantBlock hangingLeavesBlock;
		if (placer.getWorld().testBlockState(testingPos, state -> state.isOf(ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES))) {
			hangingLeavesBlock = ArcheonBlocks.HANGING_PNEVENTIAL_VUXANCIA_LEAVES;
		}
		else if (placer.getWorld().testBlockState(testingPos, state -> state.isOf(ArcheonBlocks.STREIAN_VUXANCIA_LEAVES))) {
			hangingLeavesBlock = ArcheonBlocks.HANGING_STREIAN_VUXANCIA_LEAVES;
		}
		else if (placer.getWorld().testBlockState(testingPos, state -> state.isOf(ArcheonBlocks.ORIAN_VUXANCIA_LEAVES))) {
			hangingLeavesBlock = ArcheonBlocks.HANGING_ORIAN_VUXANCIA_LEAVES;
		}
		else if (placer.getWorld().testBlockState(testingPos, state -> state.isOf(ArcheonBlocks.VALE_VUXANCIA_LEAVES))) {
			hangingLeavesBlock = ArcheonBlocks.HANGING_VALE_VUXANCIA_LEAVES;
		}
		else {
			hangingLeavesBlock = ArcheonBlocks.HANGING_ZIAL_VUXANCIA_LEAVES;
		}
		leaves.stream().filter(pos -> placer.getWorld().testBlockState(pos.down(), BlockState::isAir)).forEach(pos -> {
			int hangingLeavesSize = placer.getRandom().nextInt(5);
			for (int i = 1; i <= hangingLeavesSize; i++) {
				if (placer.getWorld().testBlockState(pos.down(i), BlockState::isAir)) {
					placer.replace(pos.down(i), i == hangingLeavesSize ? hangingLeavesBlock.getHead().getDefaultState() : hangingLeavesBlock.getBody().getDefaultState());
				}
				else {
					break;
				}
			}
		});
	}
}
