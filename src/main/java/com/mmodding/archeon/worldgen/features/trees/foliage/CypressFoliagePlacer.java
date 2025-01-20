package com.mmodding.archeon.worldgen.features.trees.foliage;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.floats.FloatIntPair;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CypressFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<CypressFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance).apply(instance, CypressFoliagePlacer::new)
	);

	public CypressFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
		super(radius, offset, foliageHeight);
	}

	@Override
	public FoliagePlacerType<?> getType() {
		return ArcheonFeatures.CYPRESS_FOLIAGE_PLACER;
	}

	@Override
	protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, int trunkHeight, TreeNode node, int foliageHeight, int radius, int offset) {

		boolean giant = trunkHeight > 18;

		// Select the third lower position on the truck
		BlockPos centerPos = node.getCenter().down(trunkHeight - (giant ? 3 : 2));

		// Randomizing Trunk Height to obtain Foliage Height
		int height = trunkHeight + 1 + random.rangeClosed(2, 3);

		// Placing the middle foliage column
		for (int i = 0; i < height; i++) {
			CypressFoliagePlacer.placeFoliageBlock(world, replacer, random, config, centerPos.up(i));
		}

		List<IntIntPair> alreadyGenerated = new ArrayList<>();

		// Repeating it for each horizontal direction
		for (Direction direction : Direction.Type.HORIZONTAL.stream().toList()) {

			// Repeating it for each layer ("giant" Cypress Trees have more layer by default)
			for (int i = 1; i <= (giant ? 3 : 2); i++) {

				// Defining the scale of each layer, that will be applied to the height to obtain the heightScaled of the layer
				FloatIntPair scale = switch (i) {
					case 1 -> FloatIntPair.of(0.75f, 3);
					case 2 -> FloatIntPair.of(0.5f, 2);
					case 3 -> FloatIntPair.of(0.25f, 1);
					default -> FloatIntPair.of(0.0f, 0);
				};

				int heightScaled = (int) (height * scale.firstFloat()) - scale.secondInt() + random.nextInt(scale.secondInt() * 2);

				// Placing the foliage column for the current direction dans the current layer
				for (int j = 0; j < heightScaled; j++) {
					CypressFoliagePlacer.placeFoliageBlock(world, replacer, random, config, centerPos.up(i).offset(direction, i).up(j));
				}

				// Adding foliage to the right and to the left of it
				for (Direction orientation : List.of(direction.rotateYCounterclockwise(), direction.rotateYClockwise())) {
					int randomInt = random.nextInt(i);
					for (int j = 0; j < heightScaled - randomInt - 3; j++) {
						BlockPos pos = centerPos.up(i + 1 + randomInt).offset(direction, i).offset(orientation, 1).up(j);
						if (!alreadyGenerated.contains(IntIntPair.of(pos.getX(), pos.getX()))){
							alreadyGenerated.add(IntIntPair.of(pos.getX(), pos.getY()));
							CypressFoliagePlacer.placeFoliageBlock(world, replacer, random, config, pos);
						}
					}
				}
			}
		}

		// Making sure that there is no log block visible
		for (int i = 0; i < height; i++) {
			BlockPos baseCheckPos = centerPos.up(i);

			if (world.testBlockState(baseCheckPos, state -> state.isOf(ArcheonBlocks.CYPRESS_LOG))) {
				for (Direction direction : Direction.Type.HORIZONTAL) {
					BlockPos checkPos = baseCheckPos.offset(direction);

					if (world.testBlockState(checkPos, BlockState::isAir)) {
						CypressFoliagePlacer.placeFoliageBlock(world, replacer, random, config, checkPos);
					}
				}
			}
		}
	}

	@Override
	public int getRandomHeight(RandomGenerator random, int trunkHeight, TreeFeatureConfig config) {
		return 0;
	}

	@Override
	protected boolean isInvalidForLeaves(RandomGenerator random, int dx, int y, int dz, int radius, boolean giantTrunk) {
		return false;
	}
}
