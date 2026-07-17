package com.mmodding.archeon.resource;

import com.mmodding.archeon.block.LeavesCarpetBlock;
import com.mmodding.archeon.block.SouthWheatBlock;
import com.mmodding.archeon.block.VuxanciaLeavesBlock;
import com.mmodding.archeon.init.*;
import com.mmodding.archeon.worldgen.feature.HollowCypressLogFeature;
import com.mmodding.archeon.worldgen.feature.MenhirFeature;
import com.mmodding.archeon.worldgen.feature.RockyFieldsRockFeature;
import com.mmodding.archeon.worldgen.feature.tree.decorator.HangingLeavesTreeDecorator;
import com.mmodding.archeon.worldgen.feature.tree.decorator.SporeRootcapTreeDecorator;
import com.mmodding.archeon.worldgen.feature.tree.foliage.CypressFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.NeclaneFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.PalmFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.foliage.VuxanciaFoliagePlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.NeclaneTrunkPlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.PalmTrunkPlacer;
import com.mmodding.archeon.worldgen.feature.tree.trunk.VuxanciaTrunkPlacer;
import com.mmodding.library.block.api.catalog.GrowsDownPlantBlock;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.worldgen.api.feature.FeaturePack;
import com.mmodding.library.worldgen.api.feature.MModdingFeatures;
import com.mmodding.library.worldgen.api.feature.catalog.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.floatprovider.ClampedNormalFloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ArcheonFeaturePacks {

	private static final FeaturePack<RockyFieldsRockFeature.Config> ROCKY_FIELDS_ROCK = FeaturePack.of(ArcheonFeatures.ROCKY_FIELDS_ROCK)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ROCKY_FIELDS_ROCK,
			new RockyFieldsRockFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.COBBLED_CHIASPEN),
				BlockStateProvider.of(ArcheonBlocks.COBBLED_CHIASPEN_SLAB)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ROCKY_FIELDS_ROCK,
				CountPlacementModifier.of(2),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<MenhirFeature.Config> MENHIR = FeaturePack.of(ArcheonFeatures.MENHIR)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.MENHIR,
			new MenhirFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.CHIASPEN),
				BlockStateProvider.of(ArcheonBlocks.CHISELED_CHIASPEN),
				BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICKS),
				BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_STAIRS),
				BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_SLAB),
				BlockStateProvider.of(ArcheonBlocks.CHIASPEN_BRICK_WALL),
				BlockStateProvider.of(ArcheonBlocks.CRACKED_CHIASPEN_BRICKS)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.MENHIR,
				RarityFilterPlacementModifier.of(250),
				SquarePlacementModifier.of(),
				PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP
			)
		);

	private static final FeaturePack<HollowCypressLogFeature.Config> HOLLOW_CYPRESS_LOG = FeaturePack.of(ArcheonFeatures.HOLLOW_CYPRESS_LOG)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.HOLLOW_CYPRESS_LOG,
			new HollowCypressLogFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.HOLLOW_CYPRESS_LOG)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.HOLLOW_CYPRESS_LOG,
				CountPlacementModifier.of(2),
				SquarePlacementModifier.of(),
				PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
				BiomePlacementModifier.of()
			)
		);

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
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.PATCH_XETULIAN_SUGAR_CANE,
			new RandomPatchFeatureConfig(
				20, 4, 0,
				PlacedFeatures.createEntry(
					Feature.BLOCK_COLUMN,
					BlockColumnFeatureConfig.create(BiasedToBottomIntProvider.create(2, 4), BlockStateProvider.of(ArcheonBlocks.XETULIAN_SUGAR_CANE)),
					BlockPredicate.allOf(
						BlockPredicate.IS_AIR,
						BlockPredicate.wouldSurvive(ArcheonBlocks.XETULIAN_SUGAR_CANE.getDefaultState(), BlockPos.ORIGIN),
						BlockPredicate.anyOf(
							BlockPredicate.matchingFluids(new BlockPos(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
							BlockPredicate.matchingFluids(new BlockPos(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
							BlockPredicate.matchingFluids(new BlockPos(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
							BlockPredicate.matchingFluids(new BlockPos(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER)
						)
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.PATCH_XETULIAN_SUGAR_CANE,
				SquarePlacementModifier.of(),
				PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
				BiomePlacementModifier.of()
			)
		);

	private static final RuleTest CHIASPEN = new BlockMatchRuleTest(ArcheonBlocks.CHIASPEN);
	private static final RuleTest PHOSNOR_SLATE = new BlockMatchRuleTest(ArcheonBlocks.PHOSNOR_SLATE);
	private static final RuleTest DUNE_SAND = new BlockMatchRuleTest(ArcheonBlocks.DUNE_SAND);

	private static final RuleTest CHIASPEN_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonBlockTags.CHIASPEN_ORES_REPLACEABLES);
	private static final RuleTest PHOSNOR_SLATE_ORES_REPLACEABLES = new TagMatchRuleTest(ArcheonBlockTags.PHOSNOR_SLATE_ORES_REPLACEABLES);

	private static final FeaturePack<OreFeatureConfig> ORE = FeaturePack.of(Feature.ORE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_ARTEMNITE,
			new OreFeatureConfig(CHIASPEN, ArcheonBlocks.ARTEMNITE.getDefaultState(), 64),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_ARTEMNITE,
				CountPlacementModifier.of(8),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_CRIADAN,
			new OreFeatureConfig(CHIASPEN, ArcheonBlocks.CRIADAN.getDefaultState(), 64),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_CRIADAN,
				CountPlacementModifier.of(8),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_AKETITE,
			new OreFeatureConfig(PHOSNOR_SLATE, ArcheonBlocks.AKETITE.getDefaultState(), 64),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_AKETITE,
				CountPlacementModifier.of(8),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(0))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_SALT,
			new OreFeatureConfig(DUNE_SAND, ArcheonBlocks.SALT_BLOCK.getDefaultState(), 32),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_SALT,
				CountPlacementModifier.of(4),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(45), YOffset.fixed(80))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_SHELLSAND,
			new OreFeatureConfig(DUNE_SAND, ArcheonBlocks.SALT_BLOCK.getDefaultState(), 3),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_SHELLSAND,
				CountPlacementModifier.of(32),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(45), YOffset.fixed(80))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_APAFLORITE,
			new OreFeatureConfig(
				List.of(
					OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.APAFLORITE_ORE.getDefaultState()),
					OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE.getDefaultState())
				),
				6
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_APAFLORITE,
				CountPlacementModifier.of(5),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(45))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_EXYRIANE,
			new OreFeatureConfig(
				List.of(
					OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.EXYRIANE_ORE.getDefaultState()),
					OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_EXYRIANE_ORE.getDefaultState())
				),
				30
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_EXYRIANE,
				CountPlacementModifier.of(7),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(160))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_FAELITE,
			new OreFeatureConfig(
				List.of(
					OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.FAELITE_ORE.getDefaultState()),
					OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_FAELITE_ORE.getDefaultState())
				),
				6
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_FAELITE,
				CountPlacementModifier.of(5),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(45))
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ORE_LUSONYTH,
			new OreFeatureConfig(
				List.of(
					OreFeatureConfig.createTarget(CHIASPEN_ORES_REPLACEABLES, ArcheonBlocks.LUSONYTH_ORE.getDefaultState()),
					OreFeatureConfig.createTarget(PHOSNOR_SLATE_ORES_REPLACEABLES, ArcheonBlocks.PHOSNOR_SLATE_LUSONYTH_ORE.getDefaultState())
				),
				6
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ORE_LUSONYTH,
				CountPlacementModifier.of(3),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(0))
			)
		);

	private static final FeaturePack<LayeredFeature.Config> GLOWSHROOMS = FeaturePack.of(MModdingFeatures.LAYERED)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.GLOWSHROOMS,
			new LayeredFeature.Config(
				RegistryEntryList.of(
					PlacedFeatures.createEntry(
						MModdingFeatures.ADVANCED_LIQUID_VEGETATION_PATCH,
						new AdvancedLiquidVegetationPatchFeature.Config(
							ArcheonBlockTags.PHOSNOR_SLATE_ORES_REPLACEABLES,
							BlockStateProvider.of(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
							BlockStateProvider.of(ArcheonBlocks.DASCIUM_STILL),
							PlacedFeatures.createEntry(
								Feature.SIMPLE_BLOCK,
								new SimpleBlockFeatureConfig(
									new WeightedBlockStateProvider(
										DataPool.<BlockState>builder()
											.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState(), 1)
									)
								)
							),
							VerticalSurfaceType.FLOOR,
							ConstantIntProvider.create(3),
							0.8f,
							2,
							0.1f,
							UniformIntProvider.create(1, 2),
							0.7f
						) // might need to add back placed features (same for bottom) -> 5 ; Direction.DOWN ; 12
					),
					PlacedFeatures.createEntry(
						Feature.VEGETATION_PATCH,
						new VegetationPatchFeatureConfig(
							ArcheonBlockTags.PHOSNOR_SLATE_ORES_REPLACEABLES,
							BlockStateProvider.of(ArcheonBlocks.GLOWSHROOM_MOSS_BLOCK),
							PlacedFeatures.createEntry(
								Feature.SIMPLE_BLOCK,
								new SimpleBlockFeatureConfig(
									new WeightedBlockStateProvider(
										DataPool.<BlockState>builder()
											.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 1), 5)
											.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 2), 5)
											.add(ArcheonBlocks.GLOWSHROOM_MOSS.getDefaultState().with(Properties.LAYERS, 3), 5)
											.add(ArcheonBlocks.GLOWSPROUTS.getDefaultState(), 10)
											.add(ArcheonBlocks.GLOWSHROOMS.getDefaultState(), 5)
											.add(ArcheonBlocks.GLOWSHROOM_PARASITES.getDefaultState(), 5)
									)
								)
							),
							VerticalSurfaceType.FLOOR,
							ConstantIntProvider.create(3),
							0.8f,
							3,
							0.6f,
							UniformIntProvider.create(2, 3),
							0.9f
						)
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.GLOWSHROOMS,
				CountPlacementModifier.of(10),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
				RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)),
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<AdvancedDripstoneClusterFeature.Config> CLUSTER = FeaturePack.of(MModdingFeatures.ADVANCED_DRIPSTONE_CLUSTER)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.CRIADAN_CLUSTER,
			new AdvancedDripstoneClusterFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.POINTED_CRIADAN),
				BlockStateProvider.of(ArcheonBlocks.CRIADAN),
				12,
				UniformIntProvider.create(3, 6),
				UniformIntProvider.create(2, 8),
				1,
				3,
				UniformIntProvider.create(2, 4),
				UniformFloatProvider.create(0.3f, 0.7f),
				ClampedNormalFloatProvider.create(0.1f, 0.3f, 0.1f, 0.9f),
				0.1f,
				3,
				8
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.CRIADAN_CLUSTER,
				CountPlacementModifier.of(UniformIntProvider.create(48, 96)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				BiomePlacementModifier.of()
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ANHYDRITE_CLUSTER,
			new AdvancedDripstoneClusterFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.POINTED_ANHYDRITE),
				BlockStateProvider.of(ArcheonBlocks.ANHYDRITE),
				12,
				UniformIntProvider.create(3, 6),
				UniformIntProvider.create(2, 8),
				1,
				3,
				UniformIntProvider.create(2, 4),
				UniformFloatProvider.create(0.3f, 0.7f),
				ClampedNormalFloatProvider.create(0.1f, 0.3f, 0.1f, 0.9f),
				0.1f,
				3,
				8
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ANHYDRITE_CLUSTER,
				CountPlacementModifier.of(UniformIntProvider.create(48, 96)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<SimpleRandomFeatureConfig> SMALL = FeaturePack.of(Feature.SIMPLE_RANDOM_SELECTOR)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.SMALL_CRIADAN,
			new SimpleRandomFeatureConfig(
				RegistryEntryList.of(
					PlacedFeatures.createEntry(
						MModdingFeatures.ADVANCED_SMALL_DRIPSTONE,
						new AdvancedSmallDripstoneFeature.Config(
							BlockStateProvider.of(ArcheonBlocks.POINTED_CRIADAN),
							BlockStateProvider.of(ArcheonBlocks.CRIADAN),
							0.2f,
							0.7f,
							0.5f,
							0.5f
						),
						EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
						RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1))
					),
					PlacedFeatures.createEntry(
						MModdingFeatures.ADVANCED_SMALL_DRIPSTONE,
						new AdvancedSmallDripstoneFeature.Config(
							BlockStateProvider.of(ArcheonBlocks.POINTED_CRIADAN),
							BlockStateProvider.of(ArcheonBlocks.CRIADAN),
							0.2f,
							0.7f,
							0.5f,
							0.5f
						),
						EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
						RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1))
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.SMALL_CRIADAN,
				CountPlacementModifier.of(UniformIntProvider.create(192, 256)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				CountPlacementModifier.of(UniformIntProvider.create(1, 5)),
				RandomOffsetPlacementModifier.of(
					ClampedNormalIntProvider.of(0.0f, 3.0f, -10, 10),
					ClampedNormalIntProvider.of(0.0f, 0.6f, -2, 2)
				),
				BiomePlacementModifier.of()
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.SMALL_ANHYDRITE,
			new SimpleRandomFeatureConfig(
				RegistryEntryList.of(
					PlacedFeatures.createEntry(
						MModdingFeatures.ADVANCED_SMALL_DRIPSTONE,
						new AdvancedSmallDripstoneFeature.Config(
							BlockStateProvider.of(ArcheonBlocks.POINTED_ANHYDRITE),
							BlockStateProvider.of(ArcheonBlocks.ANHYDRITE),
							0.2f,
							0.7f,
							0.5f,
							0.5f
						),
						EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
						RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1))
					),
					PlacedFeatures.createEntry(
						MModdingFeatures.ADVANCED_SMALL_DRIPSTONE,
						new AdvancedSmallDripstoneFeature.Config(
							BlockStateProvider.of(ArcheonBlocks.POINTED_ANHYDRITE),
							BlockStateProvider.of(ArcheonBlocks.ANHYDRITE),
							0.2f,
							0.7f,
							0.5f,
							0.5f
						),
						EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
						RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1))
					)
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.SMALL_ANHYDRITE,
				CountPlacementModifier.of(UniformIntProvider.create(192, 256)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				CountPlacementModifier.of(UniformIntProvider.create(1, 5)),
				RandomOffsetPlacementModifier.of(
					ClampedNormalIntProvider.of(0.0f, 3.0f, -10, 10),
					ClampedNormalIntProvider.of(0.0f, 0.6f, -2, 2)
				),
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<AdvancedLargeDripstoneFeature.Config> LARGE = FeaturePack.of(MModdingFeatures.ADVANCED_LARGE_DRIPSTONE)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.LARGE_CRIADAN,
			new AdvancedLargeDripstoneFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.CRIADAN),
				30,
				UniformIntProvider.create(3, 19),
				UniformFloatProvider.create(0.4f, 2.0f),
				0.33f,
				UniformFloatProvider.create(0.3f, 0.9f),
				UniformFloatProvider.create(0.4f, 1.0f),
				UniformFloatProvider.create(0.0f, 0.3f),
				4,
				0.6f
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.LARGE_CRIADAN,
				CountPlacementModifier.of(UniformIntProvider.create(10, 48)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				BiomePlacementModifier.of()
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.LARGE_ANHYDRITE,
			new AdvancedLargeDripstoneFeature.Config(
				BlockStateProvider.of(ArcheonBlocks.ANHYDRITE),
				30,
				UniformIntProvider.create(3, 19),
				UniformFloatProvider.create(0.4f, 2.0f),
				0.33f,
				UniformFloatProvider.create(0.3f, 0.9f),
				UniformFloatProvider.create(0.4f, 1.0f),
				UniformFloatProvider.create(0.0f, 0.3f),
				4,
				0.6f
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.LARGE_ANHYDRITE,
				CountPlacementModifier.of(UniformIntProvider.create(10, 48)),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<RandomBooleanFeatureConfig> ACHREAN_GOLDEN_CLAY = FeaturePack.of(Feature.RANDOM_BOOLEAN_SELECTOR)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ACHREAN_GOLDEN_CLAY,
			new RandomBooleanFeatureConfig(
				PlacedFeatures.createEntry(
					Feature.VEGETATION_PATCH,
					new VegetationPatchFeatureConfig(
						ArcheonBlockTags.ACHREAN_MOSS_REPLACEABLES,
						BlockStateProvider.of(ArcheonBlocks.GOLDEN_CLAY),
						PlacedFeatures.createEntry(
							Feature.SIMPLE_BLOCK,
							new SimpleBlockFeatureConfig(
								new WeightedBlockStateProvider(
									DataPool.<BlockState>builder()
										.add(achreanMossLayer(1), 50)
										.add(achreanMossLayer(2), 35)
										.add(achreanMossLayer(3), 30)
										.add(achreanMossLayer(4), 25)
										.add(achreanMossLayer(5), 20)
										.add(achreanMossLayer(6), 15)
										.add(achreanMossLayer(7), 10)
										.add(achreanMossLayer(8), 5)
								)
							)
						),
						VerticalSurfaceType.FLOOR,
						ConstantIntProvider.create(3),
						0.8f,
						2,
						0.8f,
						UniformIntProvider.create(4, 7),
						0.7f
					),
					CountPlacementModifier.of(125),
					SquarePlacementModifier.of(),
					PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
					BiomePlacementModifier.of()
				),
				PlacedFeatures.createEntry(
					MModdingFeatures.ADVANCED_LIQUID_VEGETATION_PATCH,
					new AdvancedLiquidVegetationPatchFeature.Config(
						ArcheonBlockTags.ACHREAN_MOSS_REPLACEABLES,
						BlockStateProvider.of(ArcheonBlocks.GOLDEN_CLAY),
						BlockStateProvider.of(ArcheonBlocks.HOT_SPRING_WATER_STILL),
						PlacedFeatures.createEntry(
							Feature.SIMPLE_BLOCK,
							new SimpleBlockFeatureConfig(
								new WeightedBlockStateProvider(
									DataPool.<BlockState>builder()
										.add(ArcheonBlocks.SMALL_HOT_SPRING_LILY_PAD.getDefaultState(), 30)
										.add(ArcheonBlocks.HOT_SPRING_LILY_PAD.getDefaultState(), 20)
										.add(ArcheonBlocks.GIANT_LILY.getDefaultState(), 10)
								)
							)
						),
						VerticalSurfaceType.FLOOR,
						ConstantIntProvider.create(3),
						0.8f,
						5,
						0.1f,
						UniformIntProvider.create(4, 7),
						0.7f
					),
					CountPlacementModifier.of(125),
					SquarePlacementModifier.of(),
					PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
					BiomePlacementModifier.of()
				)
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ACHREAN_GOLDEN_CLAY,
				CountPlacementModifier.of(62),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
				RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)),
				BiomePlacementModifier.of()
			)
		);

	private static final FeaturePack<VegetationPatchFeatureConfig> ACHREAN_MOSS_PATCH = FeaturePack.of(Feature.VEGETATION_PATCH)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ACHREAN_MOSS_PATCH,
			new VegetationPatchFeatureConfig(
				ArcheonBlockTags.ACHREAN_MOSS_REPLACEABLES,
				BlockStateProvider.of(ArcheonBlocks.ACHREAN_MOSS),
				PlacedFeatures.createEntry(
					Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(
						new WeightedBlockStateProvider(
							DataPool.<BlockState>builder()
								.add(achreanMossLayer(1), 15)
								.add(achreanMossLayer(2), 15)
								.add(achreanMossLayer(3), 15)
								.add(achreanMossLayer(4), 15)
								.add(ArcheonBlocks.WET_GRASS.getDefaultState(), 5)
								.add(ArcheonBlocks.TALL_WET_GRASS.getDefaultState(), 5)
								.add(ArcheonBlocks.FLOWERED_WET_GRASS.getDefaultState(), 5)
								.add(ArcheonBlocks.FLOWERED_TALL_WET_GRASS.getDefaultState(), 5)
								.add(ArcheonBlocks.WET_FERN.getDefaultState(), 5)
								.add(ArcheonBlocks.TALL_WET_FERN.getDefaultState(), 5)
								.add(ArcheonBlocks.WET_GRASS_TUFFET.getDefaultState(), 5)
								.add(ArcheonBlocks.BLUE_DOELDIA.getDefaultState(), 5)
								.add(ArcheonBlocks.WHITE_DOELDIA.getDefaultState(), 5)
								.add(ArcheonBlocks.PINK_DOELDIA.getDefaultState(), 5)
								.add(ArcheonBlocks.YELLOW_DOELDIA.getDefaultState(), 5)
						)
					)
				),
				VerticalSurfaceType.FLOOR,
				ConstantIntProvider.create(1),
				0.0f,
				5,
				0.9f,
				UniformIntProvider.create(4, 7),
				0.3f
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ACHREAN_MOSS_PATCH,
				VegetationPlacedFeatures.modifiers(125)
			)
		)
		.appendConfiguredFeature(
			ArcheonConfiguredFeatures.ACHREAN_MOSS_CEILING,
			new VegetationPatchFeatureConfig(
				ArcheonBlockTags.ACHREAN_MOSS_REPLACEABLES,
				BlockStateProvider.of(ArcheonBlocks.ACHREAN_MOSS_BLOCK),
				PlacedFeatures.createEntry(
					Feature.BLOCK_COLUMN,
					new BlockColumnFeatureConfig(
						List.of(
							BlockColumnFeatureConfig.createLayer(
								new WeightedListIntProvider(
									DataPool.<IntProvider>builder()
										.add(UniformIntProvider.create(0, 3), 5)
										.add(UniformIntProvider.create(1, 7), 1)
										.build()
								),
								new WeightedBlockStateProvider(
									DataPool.<BlockState>builder()
										.add(ArcheonBlocks.ACHREAN_VINES.getBody().getDefaultState(), 4)
										.add(ArcheonBlocks.ACHREAN_VINES.withFruits(ArcheonBlocks.ACHREAN_VINES.getBody().getDefaultState()), 1)
								)
							),
							BlockColumnFeatureConfig.createLayer(
								ConstantIntProvider.create(1),
								new RandomizedIntBlockStateProvider(
									new WeightedBlockStateProvider(
										DataPool.<BlockState>builder()
											.add(ArcheonBlocks.ACHREAN_VINES.getHead().getDefaultState(), 4)
											.add(ArcheonBlocks.ACHREAN_VINES.withFruits(ArcheonBlocks.ACHREAN_VINES.getHead().getDefaultState()), 1)
									),
									GrowsDownPlantBlock.Head.AGE,
									UniformIntProvider.create(23, 25)
								)
							)
						),
						Direction.DOWN,
						BlockPredicate.IS_AIR,
						true
					)
				),
				VerticalSurfaceType.CEILING,
				UniformIntProvider.create(1, 2),
				0.0f,
				5,
				0.08f,
				UniformIntProvider.create(4, 7),
				0.3f
			),
			pack -> pack.appendPlacedFeature(
				ArcheonPlacedFeatures.ACHREAN_MOSS_CEILING,
				CountPlacementModifier.of(125),
				SquarePlacementModifier.of(),
				PlacedFeatures.BOTTOM_TO_TOP_RANGE,
				EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
				RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1)),
				BiomePlacementModifier.of()
			)
		);

	private static BlockState achreanMossLayer(int layer) {
		return ArcheonBlocks.ACHREAN_MOSS.getDefaultState().with(Properties.LAYERS, layer);
	}

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
		ROCKY_FIELDS_ROCK.registerConfiguredFeatures(configuredFeatures);
		MENHIR.registerConfiguredFeatures(configuredFeatures);
		HOLLOW_CYPRESS_LOG.registerConfiguredFeatures(configuredFeatures);
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
		ORE.registerConfiguredFeatures(configuredFeatures);
		GLOWSHROOMS.registerConfiguredFeatures(configuredFeatures);
		CLUSTER.registerConfiguredFeatures(configuredFeatures);
		SMALL.registerConfiguredFeatures(configuredFeatures);
		LARGE.registerConfiguredFeatures(configuredFeatures);
		ACHREAN_GOLDEN_CLAY.registerConfiguredFeatures(configuredFeatures);
		ACHREAN_MOSS_PATCH.registerConfiguredFeatures(configuredFeatures);
	}
}
