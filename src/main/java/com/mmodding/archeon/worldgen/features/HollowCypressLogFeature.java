package com.mmodding.archeon.worldgen.features;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFeatures;
import com.mmodding.mmodding_lib.library.worldgen.features.AdvancedFeature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HollowCypressLogFeature extends AdvancedFeature<HollowCypressLogFeature.Config> {

	public HollowCypressLogFeature(Codec<Config> configCodec) {
		super(configCodec);
	}

	@Override
	public ConfiguredFeature<Config, AdvancedFeature<Config>> getDefaultConfigured() {
		return new ConfiguredFeature<>(ArcheonFeatures.HOLLOW_CYPRESS_LOG, new Config(
			BlockStateProvider.of(ArcheonBlocks.HOLLOW_CYPRESS_LOG)
		));
	}

	@Override
	public PlacedFeature getDefaultPlaced() {

		List<PlacementModifier> placementModifiers = new ArrayList<>();
		placementModifiers.add(CountPlacementModifier.create(2));
		placementModifiers.add(InSquarePlacementModifier.getInstance());
		placementModifiers.add(PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP);
		placementModifiers.add(BiomePlacementModifier.getInstance());

		return new PlacedFeature(Holder.createDirect(this.getDefaultConfigured()), placementModifiers);
	}

	@Override
	public boolean place(FeatureContext<Config> context) {
		if (context.getWorld().getBlockState(context.getOrigin().down()).isOf(Blocks.WATER)) {
			return false;
		}
		else {
			Direction randomPickedDirection = Direction.fromHorizontal(context.getRandom().nextInt(4));
			int randomPickedLength = context.getRandom().nextInt(6);
			Set<BlockPos> blockPositions = new HashSet<>();
			for (int i = 0; i < randomPickedLength; i++) {
				blockPositions.add(context.getOrigin().offset(randomPickedDirection, i));
			}
			int numberOfBlocksNotOnAir = blockPositions.stream().filter(pos -> context.getWorld().testBlockState(pos.down(), state -> !state.isAir())).collect(Collectors.toSet()).size();
			if (randomPickedLength * 0.66 <= numberOfBlocksNotOnAir) { // Simple check that at least two thirds of block positions are not on air blocks
				for (BlockPos pos : blockPositions) {
					context.getWorld().setBlockState(
						pos,
						context.getConfig().hollowLog.getBlockState(context.getRandom(), pos).with(Properties.AXIS, randomPickedDirection.getAxis()),
						Block.NOTIFY_LISTENERS
					);
					this.placeRootcapRandomly(context, pos, randomPickedDirection.rotateYClockwise());
					this.placeRootcapRandomly(context, pos, randomPickedDirection.rotateYCounterclockwise());
				}
				return true;
			}
			else {
				return false;
			}
		}
	}

	private void placeRootcapRandomly(FeatureContext<Config> context, BlockPos pos, Direction offset) {
		if (context.getWorld().testBlockState(pos.offset(offset), BlockState::isAir) && context.getRandom().nextFloat() <= 0.35f) {
			context.getWorld().setBlockState(
				pos.offset(offset),
				ArcheonBlocks.SPORE_ROOTCAP.getDefaultState().with(Properties.HORIZONTAL_FACING, offset),
				Block.NOTIFY_LISTENERS
			);
		}
	}

	public record Config(BlockStateProvider hollowLog) implements FeatureConfig {

		public static final Codec<Config> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(BlockStateProvider.TYPE_CODEC.fieldOf("hollow_log").forGetter(Config::hollowLog)).apply(instance, Config::new)
		);
	}
}
