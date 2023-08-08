package fr.firstmegagame4.archeon.worldgen.features.trees.foliage;

import com.mmodding.mmodding_lib.library.worldgen.features.trees.CustomFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class PalmFoliagePlacer extends CustomFoliagePlacer {

	public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create(
		instance -> fillCustomFoliagePlacerFields(instance).apply(instance, PalmFoliagePlacer::new)
	);

	public PalmFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
		super(radius, offset, foliageHeight);
	}

	@Override
	public FoliagePlacerType<?> getType() {
		return ArcheonFeatures.PALM_FOLIAGE_PLACER;
	}

	@Override
	protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, int trunkHeight, TreeNode node, int foliageHeight, int radius, int offset) {

		BlockPos downPos = node.getCenter().down();

		Direction.Type.HORIZONTAL.forEach(direction -> {

			BlockPos downSidePos = downPos.offset(direction);

			this.placePalmFoliage(world, replacer, random, config, downSidePos);

			if (random.nextInt(3) == 0) {
				this.placePalmFoliage(world, replacer, random, config, downSidePos.offset(direction.rotateYCounterclockwise()));
			}
		});

		BlockPos centerPos = node.getCenter();

		Direction.Type.HORIZONTAL.forEach(direction -> {

			BlockPos centerSidePos = centerPos.offset(direction);

			this.placePalmFoliage(world, replacer, random, config, centerSidePos);
			this.placePalmFoliage(world, replacer, random, config, centerSidePos.offset(direction.rotateYClockwise()));

			Direction yClockedDir = direction.rotateYClockwise();

			for (int index = 0; index < 2; index++) {

				int size = index == 0 || random.nextBoolean() || node.isGiantTrunk() ? 3 : 2;

				BlockPos start;
				BlockPos end;

				boolean isBig = random.nextInt(3) == 0;

				if (index == 0) {
					if (isBig) {
						start = centerSidePos.offset(yClockedDir).offset(direction).offset(yClockedDir);
					}
					else {
						start = centerSidePos.offset(yClockedDir);
					}
					end = start.offset(yClockedDir).offset(direction);
				}
				else {
					start = centerSidePos.offset(direction);
					end = start.offset(direction);
				}

				this.placePalmFoliage(world, replacer, random, config, start);
				this.placePalmFoliage(world, replacer, random, config, end);

				if (size > 2) {
					BlockPos last;

					if (index == 0) {
						last = switch (isBig ? random.nextInt(3) : 0) {
							default -> end.down().offset(direction).offset(yClockedDir);
							case 1 -> end.down().offset(yClockedDir);
							case 2 -> end.down().offset(direction);
						};
					}
					else {
						last = end.down().offset(direction);
					}

					this.placePalmFoliage(world, replacer, random, config, last);
				}
			}
		});

		BlockPos upPos = node.getCenter().up();

		this.placePalmFoliage(world, replacer, random, config, upPos);

		Direction.Type.HORIZONTAL.forEach(direction -> {

			BlockPos upSidePos = upPos.offset(direction);

			if (random.nextBoolean()) {
				this.placePalmFoliage(world, replacer, random, config, upSidePos);
			}

			if (random.nextBoolean()) {
				this.placePalmFoliage(world, replacer, random, config, upSidePos.offset(direction.rotateYCounterclockwise()));
			}
		});
	}

	protected void placePalmFoliage(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, TreeFeatureConfig config, BlockPos pos) {
		if (TreeFeature.canReplace(world, pos)) {
			BlockState blockState = config.foliageProvider.getBlockState(random, pos);
			if (blockState.contains(Properties.WATERLOGGED)) {
				blockState = blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, state -> state.isEqualAndStill(Fluids.WATER)));
			}
			replacer.accept(pos, blockState);
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
