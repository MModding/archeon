package fr.firstmegagame4.archeon.worldgen.features.trees.trunk;

import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomTrunkPlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
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
import java.util.function.Function;

public class NeclaneTrunkPlacer extends CustomTrunkPlacer {

	public static final Codec<NeclaneTrunkPlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillTrunkPlacerFields(instance).apply(instance, NeclaneTrunkPlacer::new)
	);

	public NeclaneTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	public TrunkPlacerType<?> getType() {
		return ArcheonFeatures.NECLANE_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {

		setToDirt(world, replacer, random, startPos.down(), config);

		List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();

		int firstHeight = height == 4 ? 2 : 3;

		for (int y = 0; y < firstHeight; y++) {
			this.method_35375(world, replacer, random, startPos.up(y), config);
		}

		Direction secondDirection = Direction.Type.HORIZONTAL.random(random);

		BlockPos pos = startPos.up(firstHeight).offset(secondDirection);

		for (int y = 0; y < 2; y++) {
			this.method_35375(world, replacer, random, pos.up(y), config);
			if (height <= 5) nodes.add(new FoliagePlacer.TreeNode(pos.up(y), 0, false));
		}

		if (random.nextBoolean()) {
			Direction littleBranchDirection = secondDirection.getOpposite();
			BlockPos littleBranchPos = startPos.up(firstHeight).offset(littleBranchDirection);
			this.method_35375(world, replacer, random, littleBranchPos, config);
			nodes.add(new FoliagePlacer.TreeNode(littleBranchPos, 0, false));
		}

		if (height >= 6) {
			BlockPos highPos = pos.up(2);
			int numberBranch = random.nextInt(3) + 1;
			List<Direction> randomizedDirections = Direction.Type.HORIZONTAL.copyShuffled(random);
			for (int i = 0; i < 4; i++) {
				Direction actualDirection = randomizedDirections.get(i);
				Direction.Axis actualAxis = actualDirection.getAxis();
				boolean isNormalBranch = !(highPos.offset(actualDirection).subtract(startPos).getX() == 0) || !(highPos.offset(actualDirection).subtract(startPos).getZ() == 0);
				if (numberBranch > 0) {
					for (int horizontal = 0 ; horizontal < (isNormalBranch ? 2 : 1); horizontal++) {
						this.setTrunkBlockWithAxis(world, replacer, random, highPos.offset(actualDirection, horizontal + 1), actualAxis, config);
					}
					nodes.add(new FoliagePlacer.TreeNode(highPos.up().offset(actualDirection, isNormalBranch ? 2 : 1), 0, false));
					numberBranch--;
				}
				else {
					nodes.add(new FoliagePlacer.TreeNode(highPos.down().offset(actualDirection), 0, false));
				}
			}
		}

		return nodes;
	}

	protected void setTrunkBlockWithAxis(TestableWorld world, BiConsumer<BlockPos, BlockState> biConsumer, RandomGenerator random, BlockPos pos, Direction.Axis axis, TreeFeatureConfig treeFeatureConfig) {
		Function<BlockState, BlockState> function = Function.identity();
		if (this.method_43196(world, pos)) {
			biConsumer.accept(pos, function.apply(treeFeatureConfig.trunkProvider.getBlockState(random, pos).with(Properties.AXIS, axis)));
		}
	}
}
