package com.mmodding.archeon.worldgen.feature.tree.trunk;

import com.mmodding.archeon.init.ArcheonTreeParts;
import com.mmodding.library.math.api.AreaUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class VuxanciaTrunkPlacer extends TrunkPlacer {

	public static final Codec<VuxanciaTrunkPlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillTrunkPlacerFields(instance).apply(instance, VuxanciaTrunkPlacer::new)
	);

	public VuxanciaTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	public TrunkPlacerType<VuxanciaTrunkPlacer> getType() {
		return ArcheonTreeParts.VUXANCIA_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

		setToDirt(world, replacer, random, startPos.down(), config);

		List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();
		Consumer<BlockPos> consumer = pos -> this.getAndSetState(world, replacer, random, pos, config);

		int startHeight = 4 + random.nextInt(3);

		for (int i = 0; i < startHeight; i++) {
			this.getAndSetState(world, replacer, random, startPos.up(i), config);
		}

		BlockPos smallBranchAnchorPos = startPos.up(startHeight).down(MathHelper.floor(startHeight * 2.0 / 3.0));
		BlockPos smallBranchPos = smallBranchAnchorPos.add(random.nextBoolean() ? -3 : 3, 3, random.nextBoolean() ? -3 : 3);
		AreaUtil.forBlockPosInLine(smallBranchAnchorPos, smallBranchPos, consumer);
		nodes.add(new FoliagePlacer.TreeNode(smallBranchPos, 0, true));

		BlockPos middleStart = startPos.up(startHeight);
		nodes.add(new FoliagePlacer.TreeNode(middleStart, 0, false));

		BlockPos topPos = middleStart.add(random.nextBoolean() ? -2 : 2, 4, random.nextBoolean() ? -2 : 2);
		AreaUtil.forBlockPosInLine(middleStart.down(), topPos, consumer);
		nodes.add(new FoliagePlacer.TreeNode(topPos, 0, true));

		return nodes;
	}
}
