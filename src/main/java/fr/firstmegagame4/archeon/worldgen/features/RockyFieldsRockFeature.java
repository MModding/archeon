package fr.firstmegagame4.archeon.worldgen.features;

import com.mmodding.mmodding_lib.library.worldgen.features.CustomFeature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.ArrayList;
import java.util.List;

public class RockyFieldsRockFeature extends CustomFeature<RockyFieldsRockFeature.Config> {

	public RockyFieldsRockFeature(Codec<Config> configCodec) {
		super(configCodec);
	}

	@Override
	public ConfiguredFeature<Config, CustomFeature<Config>> getDefaultConfigured() {
		return new ConfiguredFeature<>(ArcheonFeatures.ROCKY_FIELDS_ROCK, new Config(
			BlockStateProvider.of(ArcheonBlocks.COBBLED_SOUTHSTONE),
			BlockStateProvider.of(ArcheonBlocks.COBBLED_SOUTHSTONE_SLAB)
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

		BlockPos originPos = context.getOrigin();
		BlockPos basePos = originPos.down();
		StructureWorldAccess structureWorldAccess = context.getWorld();
		RandomGenerator random = context.getRandom();
		RockyFieldsRockFeature.Config config = context.getConfig();

		if (structureWorldAccess.getBlockState(basePos).isOf(Blocks.WATER)) return false;

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
					structureWorldAccess.setBlockState(pos, config.rockBlock().getBlockState(random, pos), Block.NOTIFY_LISTENERS);

					int highSize = random.nextInt(2) + random.nextInt(2);

					if (highSize != 0 && random.nextFloat() <= probability) {
						BlockPos.iterate(pos.up(), pos.up(highSize)).forEach(highPos -> {
							boolean isSlab = random.nextBoolean();
							boolean isTop = highPos.getY() == pos.getY() + highSize;
							structureWorldAccess.setBlockState(
								highPos,
								(isSlab && isTop ? config.rockSlab().getBlockState(random, highPos) : config.rockBlock().getBlockState(random, highPos)),
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
