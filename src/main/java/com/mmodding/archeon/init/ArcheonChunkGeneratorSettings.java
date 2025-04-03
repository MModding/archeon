package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blocks.BushLeavesBlock;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import com.mmodding.mmodding_lib.library.utils.SurfaceRuleUtils;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import com.mmodding.mmodding_lib.library.worldgen.veins.CustomVeinType;
import com.mmodding.mmodding_lib.library.worldgen.veins.CustomVeinType.VeinStateGroup;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.source.util.OverworldBiomeParameters;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;

public class ArcheonChunkGeneratorSettings implements ElementsInitializer {

	public static final Identifier GENERATOR_SETTINGS_IDENTIFIER = Archeon.createId("generator_settings");

	public static final GenerationShapeConfig ARCHEON_GENERATION_SHAPE = GenerationShapeConfig.create(-64, 416, 1, 2);

	public static ChunkGeneratorSettings createArcheonSettings() {
		return new ChunkGeneratorSettings(
			ArcheonChunkGeneratorSettings.ARCHEON_GENERATION_SHAPE,
			ArcheonBlocks.CHIASPEN.getDefaultState(),
			Blocks.WATER.getDefaultState(),
			ArcheonNoiseRouter.getRouter(BuiltinRegistries.DENSITY_FUNCTION),
			ArcheonChunkGeneratorSettings.getArcheonRules(),
			new OverworldBiomeParameters().getSpawnSuitabilityNoises(),
			63,
			false,
			true,
			false,
			false
		);
	}

	public static SurfaceRules.MaterialRule getArcheonRules() {
		return SurfaceRules.sequence(SurfaceRuleUtils.createBuilder(
			SurfaceRuleUtils.floor("archeon:innermost_rock_floor", ArcheonBlocks.INNERMOST_ROCK),
			SurfaceRules.condition(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
				SurfaceRules.condition(SurfaceRuleUtils.onFloor(), SurfaceRules.condition(
					SurfaceRuleUtils.underWater(), SurfaceRules.sequence(
						SurfaceRules.condition(SurfaceRules.not(SurfaceRules.biome(
							ArcheonBiomes.SOUTH_SNOWY_PEAKS,
							ArcheonBiomes.SOUTH_SNOWY_SLOPES,
							ArcheonBiomes.DUNE_OCEAN,
							ArcheonBiomes.SHORE
						)), SurfaceRuleUtils.conditionalBlock(SurfaceRuleUtils.water(), ArcheonBlocks.WET_GRASS_BLOCK, ArcheonBlocks.WET_DIRT)),
						SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SHORE),
							SurfaceRules.condition(
								SurfaceRules.not(SurfaceRules.noiseThreshold(NoiseParametersKeys.BADLANDS_PILLAR, -0.3)),
								SurfaceRules.block(ArcheonBlocks.BUSH_LEAVES.getDefaultState().with(BushLeavesBlock.PERSISTENT, true).with(BushLeavesBlock.SOLID, true))
							)
						)
					)
				)),
				SurfaceRules.condition(SurfaceRuleUtils.waterWithStoneDepth(), SurfaceRules.sequence(
					SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SOUTH_SNOWY_SLOPES),
						SurfaceRules.condition(SurfaceRules.water(0, 0),
							SurfaceRuleUtils.block(ArcheonBlocks.PEAKS_SNOW_BLOCK)
						)
					),
					SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.DUNE_OCEAN),
						SurfaceRuleUtils.conditionalBlock(
							SurfaceRules.verticalGradient("archeon:dune_sand", YOffset.fixed(80), YOffset.fixed(81)),
							ArcheonBlocks.DUNE_SAND,
							ArcheonBlocks.CHIASPEN
						)
					),
					SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SHORE),
						SurfaceRuleUtils.conditional(
							SurfaceRules.noiseThreshold(NoiseParametersKeys.AQUIFER_LAVA, 0.0),
							SurfaceRuleUtils.block(ArcheonBlocks.SHORESTONE),
							SurfaceRuleUtils.conditionalBlock(
								SurfaceRules.noiseThreshold(NoiseParametersKeys.AQUIFER_BARRIER, 0.0),
								ArcheonBlocks.COBBLED_CHIASPEN,
								ArcheonBlocks.MOSSY_COBBLED_CHIASPEN
							)
						)
					),
					SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SOUTH_MEADOWS),
						SurfaceRuleUtils.block(ArcheonBlocks.WET_DIRT)
					)
				))
			)),
			SurfaceRuleUtils.deep("archeon:phosnor_slate", ArcheonBlocks.PHOSNOR_SLATE)
		).build().toArray(SurfaceRules.MaterialRule[]::new));
	}

	@Override
	public void register() {
		RegistrationUtils.registerChunkGeneratorSettings(GENERATOR_SETTINGS_IDENTIFIER, ArcheonChunkGeneratorSettings.createArcheonSettings());
		WorldUtils.addCustomVeinTypes(GENERATOR_SETTINGS_IDENTIFIER,
			new CustomVeinType(5, 45,
				VeinStateGroup.create(
					ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.EXYRIANE_ORE,
					ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.EXYRIANE_ORE,
					ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.EXYRIANE_ORE, ArcheonBlocks.SLIGHTLY_CONDENSED_EXYRIANE_ORE
				),
				VeinStateGroup.single(ArcheonBlocks.CONDENSED_EXYRIANE_ORE),
				VeinStateGroup.create(ArcheonBlocks.ARTEMNITE, ArcheonBlocks.CRIADAN)
			).setMinRichness(0.05f).setMaxRichness(0.15f),
			new CustomVeinType(-45, -5,
				VeinStateGroup.create(
					ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE,
					ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE,
					ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.PHOSNOR_SLATE_APAFLORITE_ORE, ArcheonBlocks.SLIGHTLY_CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE
				),
				VeinStateGroup.single(ArcheonBlocks.CONDENSED_PHOSNOR_SLATE_APAFLORITE_ORE),
				VeinStateGroup.single(ArcheonBlocks.AKETITE)
			)
		);
	}
}
