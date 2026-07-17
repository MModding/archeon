package com.mmodding.archeon.worldgen.feature;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class RockyFieldsRockFeature extends Feature<RockyFieldsRockFeature.Config> {

	public RockyFieldsRockFeature(Codec<Config> configCodec) {
		super(configCodec);
	}

	@Override
	public boolean generate(FeatureContext<Config> context) {
		BlockPos originPos = context.getOrigin();
		BlockPos basePos = originPos.down();
		StructureWorldAccess structureWorldAccess = context.getWorld();
		Random random = context.getRandom();
		RockyFieldsRockFeature.Config config = context.getConfig();

		BlockState baseState = structureWorldAccess.getBlockState(basePos);

		if (!baseState.isOf(ArcheonBlocks.WET_GRASS_BLOCK) && !baseState.isOf(ArcheonBlocks.SHORESTONE)) {
			return false;
		}

		for (BlockPos pos : BlockPos.iterate(basePos.add(-1, 0, -1), basePos.add(1, 0, 1))) {
			if (structureWorldAccess.getBlockState(pos).isAir()) {
				return false;
			}
		}

		if (originPos.getY() > structureWorldAccess.getBottomY() + 4) {

			int longerSide = random.nextInt(2);
			boolean bool0 = random.nextBoolean();
			boolean bool1 = random.nextBoolean();

			int side0 = random.nextInt(2 + (longerSide == 0 ? 1 : 0)) * (bool0 ? 1 : -1);
			int side1 = random.nextInt(2 + (longerSide == 1 ? 1 : 0)) * (bool1 ? 1 : -1);

			BlockPos.iterate(basePos, new BlockPos(basePos).north(side0).west(side1)).forEach(pos -> {
				BlockPos subtractedPos = pos.subtract(basePos);
				int distanceX = Math.abs(subtractedPos.getX());
				int distanceZ = Math.abs(subtractedPos.getZ());

				float probabilityX = 0.5f - (distanceX / 15.0f);
				float probabilityZ = 0.5f - (distanceZ / 15.0f);

				float probability = probabilityX + probabilityZ;

				if (random.nextFloat() <= probability) {
					structureWorldAccess.setBlockState(pos, config.rockBlock().get(random, pos), Block.NOTIFY_LISTENERS);

					int highSize = random.nextInt(2) + random.nextInt(2);

					if (highSize != 0 && random.nextFloat() <= probability) {
						BlockPos.iterate(pos.up(), pos.up(highSize)).forEach(highPos -> {
							boolean isSlab = random.nextBoolean();
							boolean isTop = highPos.getY() == pos.getY() + highSize;
							structureWorldAccess.setBlockState(
								highPos,
								(isSlab && isTop ? config.rockSlab().get(random, highPos) : config.rockBlock().get(random, highPos)),
								Block.NOTIFY_LISTENERS
							);
						});
					}
				}
			});

			return true;
		}

		return false;
	}

	public record Config(BlockStateProvider rockBlock, BlockStateProvider rockSlab) implements FeatureConfig {

		public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance ->
			instance.group(
				BlockStateProvider.TYPE_CODEC.fieldOf("rockBlock").forGetter(Config::rockBlock),
				BlockStateProvider.TYPE_CODEC.fieldOf("rockSlab").forGetter(Config::rockSlab)
			).apply(instance, Config::new)
		);
	}
}
