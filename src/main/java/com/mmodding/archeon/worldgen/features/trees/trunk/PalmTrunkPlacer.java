package com.mmodding.archeon.worldgen.features.trees.trunk;

import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTrunkPlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends CustomTrunkPlacer {

	public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillTrunkPlacerFields(instance).apply(instance, PalmTrunkPlacer::new)
	);

	public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	public TrunkPlacerType<PalmTrunkPlacer> getType() {
		return ArcheonFeatures.PALM_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {

		setToDirt(world, replacer, random, startPos.down(), config);

		List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();

		for (int y = 0; y < 3; y++) {
			this.method_35375(world, replacer, random, startPos.up(y), config);
		}

		int secondHeight = height != 7 ? 3 : 4;

		Direction secondDirection = Direction.Type.HORIZONTAL.random(random);

		BlockPos pos = startPos.up(3).offset(secondDirection);

		for (int y = 0; y < secondHeight; y++) {
			this.method_35375(world, replacer, random, pos.up(y), config);
		}

		if (height > 7) {
			int thirdHeight = height == 8 ? 2 : 3;

			List<Direction> directions = Direction.Type.HORIZONTAL.stream().toList();

			int index = switch (random.nextInt(3)) {
				default -> directions.indexOf(secondDirection);
				case 1 -> directions.indexOf(secondDirection) < 3 ? directions.indexOf(secondDirection) + 1 : 0;
				case 2 -> directions.indexOf(secondDirection) > 0 ? directions.indexOf(secondDirection) - 1 : 3;
			};

			Direction thirdDirection = directions.get(index);

			BlockPos heightPos = pos.up(secondHeight).offset(thirdDirection);

			for (int y = 0; y < thirdHeight; y++) {
				this.method_35375(world, replacer, random, heightPos.up(y), config);
			}

			nodes.add(new FoliagePlacer.TreeNode(heightPos.up(thirdHeight), 0, true));
		}
		else {
			nodes.add(new FoliagePlacer.TreeNode(pos.up(secondHeight), 0, false));
		}

		return nodes;
	}
}
