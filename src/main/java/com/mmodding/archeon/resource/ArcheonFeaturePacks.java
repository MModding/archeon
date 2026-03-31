package com.mmodding.archeon.resource;

import com.mmodding.archeon.block.LeavesCarpetBlock;
import com.mmodding.archeon.block.SouthWheatBlock;
import com.mmodding.archeon.block.VuxanciaLeavesBlock;
import com.mmodding.archeon.init.*;
import com.mmodding.archeon.worldgen.feature.tree.decorator.HangingLeavesTreeDecorator;
import com.mmodding.archeon.worldgen.feature.tree.decorator.SporeRootcapTreeDecorator;
import com.mmodding.archeon.worldgen.feature.tree.foliage.CypressFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.NeclaneFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.PalmFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.VuxanciaFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.NeclaneTrunkPlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.PalmTrunkPlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.VuxanciaTrunkPlacer;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.worldgen.api.feature.FeaturePack;
import com.mmodding.library.worldgen.api.feature.MModdingFeatures;
import com.mmodding.library.worldgen.api.feature.catalog.AdvancedFreezeTopLayerFeature;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ArcheonFeaturePacks {

	private static final FeaturePack<TreeFeatureConfig> PALM_TREE = FeaturePack.of(Feature.TREE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PALM_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.PALM_LOG),
				new PalmTrunkPlacer(6, 3, 0),
				BlockStateProvider.of(ArcheonBlocks.PALM_LEAVES),
				new PalmFoliagePlacer(ConstantIntProvider.create(6), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.DUNE_SAND)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PALM_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(0, 0.5f, 1),
						ArcheonBlocks.PALM_SAPLING
					)
				)
		);

	private static final FeaturePack<TreeFeatureConfig> NECLANE_TREE = FeaturePack.of(Feature.TREE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.NECLANE_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.NECLANE_LOG),
				new NeclaneTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.NECLANE_LEAVES),
				new NeclaneFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.NECLANE_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
						ArcheonBlocks.NECLANE_SAPLING
					)
				)
				.appendPlacedFeature(
					ArcheonPlacedFeatures.ROCKY_FIELDS_NECLANE_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(3, 0.1f, 1),
						ArcheonBlocks.NECLANE_SAPLING
					)
				)
		);

	private static final FeaturePack<TreeFeatureConfig> CYPRESS_TREE = FeaturePack.of(Feature.TREE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.CYPRESS_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.CYPRESS_LOG),
				new StraightTrunkPlacer(9, 9, 3),
				BlockStateProvider.of(ArcheonBlocks.CYPRESS_LEAVES),
				new CypressFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.CYPRESS_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
						ArcheonBlocks.CYPRESS_SAPLING
					)
				)
		);

	private static final FeaturePack<TreeFeatureConfig> VUXANCIA_TREE = FeaturePack.of(Feature.TREE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PNEVENTIAL_VUXANCIA_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.VUXANCIA_LOG),
				new VuxanciaTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES),
				new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).decorators(List.of(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PNEVENTIAL_VUXANCIA_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(3, 0.1f, 1),
						ArcheonBlocks.PNEVENTIAL_VUXANCIA_SAPLING
					)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.STREIAN_VUXANCIA_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.VUXANCIA_LOG),
				new VuxanciaTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.STREIAN_VUXANCIA_LEAVES),
				new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).decorators(List.of(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.STREIAN_VUXANCIA_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
						ArcheonBlocks.STREIAN_VUXANCIA_SAPLING
					)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORIAN_VUXANCIA_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.VUXANCIA_LOG),
				new VuxanciaTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.ORIAN_VUXANCIA_LEAVES),
				new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).decorators(List.of(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.ORIAN_VUXANCIA_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
						ArcheonBlocks.ORIAN_VUXANCIA_SAPLING
					)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.VALE_VUXANCIA_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.VUXANCIA_LOG),
				new VuxanciaTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.VALE_VUXANCIA_LEAVES),
				new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).decorators(List.of(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.VALE_VUXANCIA_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
						ArcheonBlocks.VALE_VUXANCIA_SAPLING
					)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ZIAL_VUXANCIA_TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ArcheonBlocks.VUXANCIA_LOG),
				new VuxanciaTrunkPlacer(4, 2, 0),
				BlockStateProvider.of(ArcheonBlocks.ZIAL_VUXANCIA_LEAVES),
				new VuxanciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
				new TwoLayersFeatureSize(1, 0, 1)
			).dirtProvider(BlockStateProvider.of(ArcheonBlocks.WET_DIRT)).decorators(List.of(HangingLeavesTreeDecorator.INSTANCE, SporeRootcapTreeDecorator.INSTANCE)).build(),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.ZIAL_VUXANCIA_TREE,
					VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
						PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
						ArcheonBlocks.ZIAL_VUXANCIA_SAPLING
					)
				)
		);

	private static final FeaturePack<VegetationPatchFeatureConfig> PATCH_VUXANCIA_LEAVES = FeaturePack.of(Feature.VEGETATION_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_PNEVENTIAL_VUXANCIA_LEAVES,
			patchVuxanciaLeaves(
				ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES,
				ArcheonBlocks.PNEVENTIAL_VUXANCIA_LEAVES_CARPET
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_PNEVENTIAL_VUXANCIA_LEAVES,
				VegetationPlacedFeatures.modifiers(6)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_STREIAN_VUXANCIA_LEAVES,
			patchVuxanciaLeaves(
				ArcheonBlocks.STREIAN_VUXANCIA_LEAVES,
				ArcheonBlocks.STREIAN_VUXANCIA_LEAVES_CARPET
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_STREIAN_VUXANCIA_LEAVES,
				VegetationPlacedFeatures.modifiers(6)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ORIAN_VUXANCIA_LEAVES,
			patchVuxanciaLeaves(
				ArcheonBlocks.ORIAN_VUXANCIA_LEAVES,
				ArcheonBlocks.ORIAN_VUXANCIA_LEAVES_CARPET
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ORIAN_VUXANCIA_LEAVES,
				VegetationPlacedFeatures.modifiers(4)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_VALE_VUXANCIA_LEAVES,
			patchVuxanciaLeaves(
				ArcheonBlocks.VALE_VUXANCIA_LEAVES,
				ArcheonBlocks.VALE_VUXANCIA_LEAVES_CARPET
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_VALE_VUXANCIA_LEAVES,
				VegetationPlacedFeatures.modifiers(4)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ZIAL_VUXANCIA_LEAVES,
			patchVuxanciaLeaves(
				ArcheonBlocks.ZIAL_VUXANCIA_LEAVES,
				ArcheonBlocks.ZIAL_VUXANCIA_LEAVES_CARPET
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ZIAL_VUXANCIA_LEAVES,
				VegetationPlacedFeatures.modifiers(4)
			)
		);

	private static final FeaturePack<VegetationPatchFeatureConfig> VUXANCIA_POUND = FeaturePack.of(Feature.WATERLOGGED_VEGETATION_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.VUXANCIA_POUND,
			new VegetationPatchFeatureConfig(
				ArcheonBlockTags.SOIL,
				BlockStateProvider.of(ArcheonBlocks.COBBLED_CHIASPEN),
				PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
					new WeightedBlockStateProvider(
						DataPool.<BlockState>builder()
							.add(ArcheonBlocks.HOT_SPRING_LILY_PAD.getDefaultState(), 2)
							.add(ArcheonBlocks.SMALL_HOT_SPRING_LILY_PAD.getDefaultState(), 1)
					)
				)),
				VerticalSurfaceType.FLOOR,
				ConstantIntProvider.create(3),
				0.8f,
				3,
				0.2f,
				UniformIntProvider.create(1, 2),
				0.7f
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.VUXANCIA_POUND,
				VegetationPlacedFeatures.modifiers(15)
			)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_WET_GRASS = FeaturePack.of(Feature.RANDOM_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_WET_GRASS,
			simpleRandomPatch(45, ArcheonBlocks.WET_GRASS),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_WET_GRASS,
				VegetationPlacedFeatures.modifiers(10)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_TALL_WET_GRASS,
			simpleRandomPatch(25, ArcheonBlocks.TALL_WET_GRASS),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_TALL_WET_GRASS,
				VegetationPlacedFeatures.modifiers(7)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_FLOWERED_WET_GRASS,
			simpleRandomPatch(3, ArcheonBlocks.FLOWERED_WET_GRASS),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_FLOWERED_WET_GRASS,
					VegetationPlacedFeatures.modifiers(3)
				)
				.appendPlacedFeature(
					ArcheonPlacedFeatures.COLD_PATCH_FLOWERED_WET_GRASS,
					VegetationPlacedFeatures.modifiers(8)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_FLOWERED_TALL_WET_GRASS,
			simpleRandomPatch(2, ArcheonBlocks.FLOWERED_TALL_WET_GRASS),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_FLOWERED_TALL_WET_GRASS,
					VegetationPlacedFeatures.modifiers(2)
				)
				.appendPlacedFeature(
					ArcheonPlacedFeatures.COLD_PATCH_FLOWERED_TALL_WET_GRASS,
					VegetationPlacedFeatures.modifiers(5)
				)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_WET_FERN = FeaturePack.of(Feature.RANDOM_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_WET_FERN,
			simpleRandomPatch(40, ArcheonBlocks.WET_FERN),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_WET_FERN,
					rarity(6)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_TALL_WET_FERN,
			simpleRandomPatch(50, ArcheonBlocks.TALL_WET_FERN),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_TALL_WET_FERN,
					rarity(7)
				)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_GRASS_TUFFET = FeaturePack.of(Feature.RANDOM_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_WET_GRASS_TUFFET,
			simpleRandomPatch(10, ArcheonBlocks.WET_GRASS_TUFFET),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_WET_GRASS_TUFFET,
					VegetationPlacedFeatures.modifiers(3)
				)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_SNOWY_GRASS_TUFFET,
			simpleRandomPatch(10, ArcheonBlocks.SNOWY_GRASS_TUFFET),
			pack -> pack
				.appendPlacedFeature(
					ArcheonPlacedFeatures.PATCH_SNOWY_GRASS_TUFFET,
					VegetationPlacedFeatures.modifiers(3)
				)
				.appendPlacedFeature(
					ArcheonPlacedFeatures.FOREST_PATCH_SNOWY_GRASS_TUFFET,
					VegetationPlacedFeatures.modifiers(9)
				)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_SOUTH_WHEAT = FeaturePack.of(Feature.RANDOM_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_SOUTH_WHEAT,
			ConfiguredFeatures.createRandomPatchFeatureConfig(
				40,
				PlacedFeatures.createEntry(
					Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(
						new NoiseBlockStateProvider(
							23456L,
							new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0),
							0.03125f,
							List.of(
								ArcheonBlocks.SOUTH_WHEAT.getDefaultState(),
								ArcheonBlocks.SOUTH_WHEAT.getDefaultState().with(SouthWheatBlock.AGE, 1),
								ArcheonBlocks.SOUTH_WHEAT.getDefaultState().with(SouthWheatBlock.AGE, 2),
								ArcheonBlocks.SOUTH_WHEAT.getDefaultState().with(SouthWheatBlock.AGE, 3),
								ArcheonBlocks.SOUTH_WHEAT.getDefaultState().with(SouthWheatBlock.AGE, 4)
							)
						)
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_SOUTH_WHEAT,
				rarity(5)
			)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_BUSH = FeaturePack.of(Feature.RANDOM_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_BUSH,
			simpleRandomPatch(5, ArcheonBlocks.BUSH),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_BUSH,
				VegetationPlacedFeatures.modifiers(1)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_VINE,
			simpleRandomPatch(1, ArcheonBlocks.VINE),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_VINE,
				VegetationPlacedFeatures.modifiers(1)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_BLOOD_ORANGE_BUSH,
			simpleRandomPatch(1, ArcheonBlocks.BLOOD_ORANGE_BUSH),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_BLOOD_ORANGE_BUSH,
				VegetationPlacedFeatures.modifiers(1)
			)
		);

	private static final FeaturePack<AdvancedFreezeTopLayerFeature.Config> PEAKS_SNOW = FeaturePack.of(MModdingFeatures.ADVANCED_FREEZE_TOP_LAYER)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PEAKS_SNOW,
			new AdvancedFreezeTopLayerFeature.Config(
				BlockStateProvider.of(Blocks.ICE),
				BlockStateProvider.of(ArcheonBlocks.PEAKS_SNOW),
				ConstantIntProvider.create(25)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PEAKS_SNOW,
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<RandomPatchFeatureConfig> PATCH_FLOWER = FeaturePack.of(Feature.FLOWER)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_SUNSET_ORCHID,
			simpleRandomPatch(32, ArcheonBlocks.SUNSET_ORCHID),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_SUNSET_ORCHID,
				rarity(5)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ROSEYPIA,
			simpleRandomPatch(4, ArcheonBlocks.ROSEYPIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ROSEYPIA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_AEROLIA,
			simpleRandomPatch(4, ArcheonBlocks.AEROLIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_AEROLIA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ASTEDIBES,
			simpleRandomPatch(4, ArcheonBlocks.ASTEDIBES),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ASTEDIBES,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_TWILIGHT_ROSE,
			simpleRandomPatch(4, ArcheonBlocks.TWILIGHT_ROSE),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_TWILIGHT_ROSE,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_PINK_LYCORIS,
			simpleRandomPatch(4, ArcheonBlocks.PINK_LYCORIS),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_PINK_LYCORIS,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_RED_LYCORIS,
			simpleRandomPatch(4, ArcheonBlocks.RED_LYCORIS),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_RED_LYCORIS,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ORANGE_LYCORIS,
			simpleRandomPatch(4, ArcheonBlocks.ORANGE_LYCORIS),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ORANGE_LYCORIS,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ASCENDIA,
			simpleRandomPatch(4, ArcheonBlocks.ASCENDIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ASCENDIA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_OEA,
			simpleRandomPatch(4, ArcheonBlocks.OEA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_OEA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_IOPEA,
			new RandomPatchFeatureConfig(
				4, 12, 6,
				PlacedFeatures.createEntry(
					Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(
						new WeightedBlockStateProvider(
							DataPool.<BlockState>builder()
								.add(ArcheonBlocks.IOPEA.getDefaultState(), 3)
								.add(ArcheonBlocks.TALL_IOPEA.getDefaultState(), 1)
						)
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_IOPEA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_ORGANDEANE,
			new RandomPatchFeatureConfig(
				4, 12, 6,
				PlacedFeatures.createEntry(
					Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(
						new WeightedBlockStateProvider(
							DataPool.<BlockState>builder()
								.add(ArcheonBlocks.ORGANDEANE_BLOSSOM.getDefaultState(), 3)
								.add(ArcheonBlocks.TALL_ORGANDEANE.getDefaultState(), 1)
						)
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_ORGANDEANE,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_SEPTICEOLIA,
			simpleRandomPatch(4, ArcheonBlocks.SEPTICEOLIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_SEPTICEOLIA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_WHITE_DOELDIA,
			simpleRandomPatch(4, ArcheonBlocks.WHITE_DOELDIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_WHITE_DOELDIA,
				rarity(2)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_YELLOW_DOELDIA,
			simpleRandomPatch(4, ArcheonBlocks.YELLOW_DOELDIA),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_YELLOW_DOELDIA,
				rarity(2)
			)
		);

	private static RandomPatchFeatureConfig simpleRandomPatch(int tries, Block block) {
		return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(
			Feature.SIMPLE_BLOCK,
			new SimpleBlockFeatureConfig(BlockStateProvider.of(block))
		));
	}

	private static List<PlacementModifier> rarity(int rarity) {
		return List.of(
			RarityFilterPlacementModifier.of(rarity),
			SquarePlacementModifier.of(),
			PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
			BiomePlacementModifier.of()
		);
	}

	private static VegetationPatchFeatureConfig patchVuxanciaLeaves(VuxanciaLeavesBlock leaves, LeavesCarpetBlock carpet) {
		return new VegetationPatchFeatureConfig(
			ArcheonBlockTags.SOIL,
			BlockStateProvider.of(ArcheonBlocks.WET_GRASS_BLOCK),
			PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
				new WeightedBlockStateProvider(
					DataPool.<BlockState>builder()
						.add(leaves.getDefaultState().with(VuxanciaLeavesBlock.PERSISTENT, true), 5)
						.add(carpet.getDefaultState(), 25)
				)
			)),
			VerticalSurfaceType.FLOOR,
			ConstantIntProvider.create(3),
			0.8f,
			3,
			0.6f,
			UniformIntProvider.create(2, 3),
			0.9f
		);
	}

	public static void registerConfiguredFeatures(AdvancedContainer mod, Registerable<ConfiguredFeature<?, ?>> configuredFeatures) {
		PALM_TREE.registerConfiguredFeatures(configuredFeatures);
		NECLANE_TREE.registerConfiguredFeatures(configuredFeatures);
		CYPRESS_TREE.registerConfiguredFeatures(configuredFeatures);
		VUXANCIA_TREE.registerConfiguredFeatures(configuredFeatures);
		PATCH_VUXANCIA_LEAVES.registerConfiguredFeatures(configuredFeatures);
		VUXANCIA_POUND.registerConfiguredFeatures(configuredFeatures);
		PATCH_WET_GRASS.registerConfiguredFeatures(configuredFeatures);
		PATCH_WET_FERN.registerConfiguredFeatures(configuredFeatures);
		PATCH_GRASS_TUFFET.registerConfiguredFeatures(configuredFeatures);
		PATCH_SOUTH_WHEAT.registerConfiguredFeatures(configuredFeatures);
		PATCH_BUSH.registerConfiguredFeatures(configuredFeatures);
		PEAKS_SNOW.registerConfiguredFeatures(configuredFeatures);
		PATCH_FLOWER.registerConfiguredFeatures(configuredFeatures);
	}

	public static void registerPlacedFeatures(AdvancedContainer mod, Registerable<PlacedFeature> placedFeatures) {
		PALM_TREE.registerPlacedFeatures(placedFeatures);
		NECLANE_TREE.registerPlacedFeatures(placedFeatures);
		CYPRESS_TREE.registerPlacedFeatures(placedFeatures);
		VUXANCIA_TREE.registerPlacedFeatures(placedFeatures);
		PATCH_VUXANCIA_LEAVES.registerPlacedFeatures(placedFeatures);
		VUXANCIA_POUND.registerPlacedFeatures(placedFeatures);
		PATCH_WET_GRASS.registerPlacedFeatures(placedFeatures);
		PATCH_WET_FERN.registerPlacedFeatures(placedFeatures);
		PATCH_GRASS_TUFFET.registerPlacedFeatures(placedFeatures);
		PATCH_SOUTH_WHEAT.registerPlacedFeatures(placedFeatures);
		PATCH_BUSH.registerPlacedFeatures(placedFeatures);
		PEAKS_SNOW.registerPlacedFeatures(placedFeatures);
		PATCH_FLOWER.registerPlacedFeatures(placedFeatures);
	}
}
