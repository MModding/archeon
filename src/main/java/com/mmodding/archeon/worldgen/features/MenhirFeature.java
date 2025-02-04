package com.mmodding.archeon.worldgen.features;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.ArrayList;
import java.util.List;

public class MenhirFeature extends AdvancedFeature<MenhirFeature.Config> {

	public MenhirFeature(Codec<Config> configCodec) {
		super(configCodec);
	}

	@Override
	public ConfiguredFeature<Config, AdvancedFeature<Config>> getDefaultConfigured() {
		return new ConfiguredFeature<>(ArcheonFeatures.MENHIR, new Config(
			BlockStateProvider.of(ArcheonBlocks.CHIASPEN),
			BlockStateProvider.of(ArcheonBlocks.CHISELED_CHIASPEN),
			BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICKS),
			BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_STAIRS),
			BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_SLAB),
			BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_WALL),
			BlockStateProvider.of(ArcheonBlocks.CRACKED_CHIASPEN_BRICKS)
		));
	}

	@Override
	public PlacedFeature getDefaultPlaced() {

		List<PlacementModifier> placementModifiers = new ArrayList<>();
		placementModifiers.add(RarityFilterPlacementModifier.create(250));
		placementModifiers.add(InSquarePlacementModifier.getInstance());
		placementModifiers.add(PlacedFeatureUtil.OCEAN_FLOOR_WG_HEIGHTMAP);

		return new PlacedFeature(Holder.createDirect(this.getDefaultConfigured()), placementModifiers);
	}

	public BlockState pickBlock(int maxHeight, BlockPos blockPickedPos, FeatureContext<Config> context) {

		BlockPos originPos = context.getOrigin();
		BlockPos basePos = originPos.down();
		StructureWorldAccess world = context.getWorld();
		RandomGenerator random = context.getRandom();
		MenhirFeature.Config config = context.getConfig();

		int subtractHeight = blockPickedPos.subtract(basePos).getY();
		boolean isCenter = (blockPickedPos.subtract(basePos).getX() == 0) && (blockPickedPos.subtract(basePos).getZ() == 0);

		BlockState wall = config.rockBrickWall.getBlockState(random, blockPickedPos);

		boolean stairsHalfDefault = random.nextBoolean() || world.getBlockState(blockPickedPos.down()).isOf(wall.getBlock());
		BlockState stairs = config.rockBrickStairs.getBlockState(random, blockPickedPos)
			.with(HorizontalFacingBlock.FACING, Direction.Type.HORIZONTAL.random(random))
			.with(Properties.BLOCK_HALF, stairsHalfDefault ? BlockHalf.BOTTOM : BlockHalf.TOP);

		boolean hasBottomStairsBelow = false;
		if (world.getBlockState(blockPickedPos.down()).isOf(stairs.getBlock())) {
			hasBottomStairsBelow = world.getBlockState(blockPickedPos.down()).get(Properties.BLOCK_HALF).equals(BlockHalf.BOTTOM);
		}

		List<BlockState> pickableBlocks = new ArrayList<>();
		pickableBlocks.add(config.rock.getBlockState(random, blockPickedPos));
		pickableBlocks.add(config.chiseledRock.getBlockState(random, blockPickedPos));
		pickableBlocks.add(config.rockBricks.getBlockState(random, blockPickedPos));
		if (!isCenter) pickableBlocks.add(stairs);
		if (subtractHeight == maxHeight) pickableBlocks.add(config.rockBrickSlab.getBlockState(random, blockPickedPos));
		if (subtractHeight >= maxHeight - 1 && !hasBottomStairsBelow) pickableBlocks.add(wall);
		pickableBlocks.add(config.crackedRockBricks.getBlockState(random, blockPickedPos));

		return pickableBlocks.get(random.nextInt(pickableBlocks.size()));
	}

	@Override
	public boolean place(FeatureContext<Config> context) {

		BlockPos originPos = context.getOrigin();
		BlockPos basePos = originPos.down();
		StructureWorldAccess world = context.getWorld();
		RandomGenerator random = context.getRandom();

		if (world.getBlockState(basePos).isOf(Blocks.WATER)) {
			return false;
		}

		if (originPos.getY() > world.getBottomY() + 4) {

			boolean has2SidePillars = random.nextBoolean();

			BlockPos side0 = new BlockPos(basePos.north());
			BlockPos side1 = new BlockPos(basePos.west());
			BlockPos side2 = new BlockPos(basePos.south());
			BlockPos side3 = new BlockPos(basePos.east());

			List<BlockPos> blockPosList = new ArrayList<>();
			blockPosList.add(basePos);

			if (has2SidePillars) {
				int sideIndex = random.nextInt(4);
				switch (sideIndex) {
					case 0 -> blockPosList.addAll(List.of(side0, side1));
					case 1 -> blockPosList.addAll(List.of(side1, side2));
					case 2 -> blockPosList.addAll(List.of(side2, side3));
					case 3 -> blockPosList.addAll(List.of(side3, side0));
				}
			}
			else {
				blockPosList.addAll(List.of(side0, side1, side2, side3));
			}

			blockPosList.forEach(blockPos -> {
				int height = blockPos.equals(basePos) ? 4 : random.nextInt(4) + 1;

				BlockPos.iterate(blockPos, blockPos.up(height)).forEach(heightPos -> world.setBlockState(
					heightPos, this.pickBlock(height, heightPos, context), Block.NOTIFY_LISTENERS
				));
			});

			return true;
		}

		return false;
	}

	public record Config(BlockStateProvider rock, BlockStateProvider chiseledRock, BlockStateProvider rockBricks, BlockStateProvider rockBrickStairs, BlockStateProvider rockBrickSlab, BlockStateProvider rockBrickWall, BlockStateProvider crackedRockBricks) implements FeatureConfig {

		public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance ->
			instance.group(
				BlockStateProvider.TYPE_CODEC.fieldOf("rock").forGetter(Config::rock),
				BlockStateProvider.TYPE_CODEC.fieldOf("chiseledRock").forGetter(Config::chiseledRock),
				BlockStateProvider.TYPE_CODEC.fieldOf("rockBricks").forGetter(Config::rockBricks),
				BlockStateProvider.TYPE_CODEC.fieldOf("rockBrickStairs").forGetter(Config::rockBrickStairs),
				BlockStateProvider.TYPE_CODEC.fieldOf("rockBrickSlab").forGetter(Config::rockBrickSlab),
				BlockStateProvider.TYPE_CODEC.fieldOf("rockBrickWall").forGetter(Config::rockBrickWall),
				BlockStateProvider.TYPE_CODEC.fieldOf("crackedRockBricks").forGetter(Config::crackedRockBricks)
			).apply(instance, Config::new)
		);
	}
}
