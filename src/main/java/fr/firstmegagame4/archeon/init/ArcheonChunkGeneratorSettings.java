package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import com.mmodding.mmodding_lib.library.utils.SurfaceRuleUtils;
import com.mmodding.mmodding_lib.library.utils.WorldUtils;
import com.mmodding.mmodding_lib.library.worldgen.chunkgenerators.DefaultGenerationShapes;
import com.mmodding.mmodding_lib.library.worldgen.chunkgenerators.DefaultNoiseRouters;
import com.mmodding.mmodding_lib.library.worldgen.veins.CustomVeinType;
import com.mmodding.mmodding_lib.library.worldgen.veins.CustomVeinType.VeinStateGroup;
import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.source.util.OverworldBiomeParameters;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;

public class ArcheonChunkGeneratorSettings implements ElementsInitializer {

	public static final Identifier GENERATOR_SETTINGS_IDENTIFIER = Archeon.createId("generator_settings");

	public static final ChunkGeneratorSettings ARCHEON_SETTINGS = new ChunkGeneratorSettings(
		DefaultGenerationShapes.OVERWORLD,
		ArcheonBlocks.SOUTHSTONE.getDefaultState(),
		Blocks.WATER.getDefaultState(),
		DefaultNoiseRouters.getOverworld(BuiltinRegistries.DENSITY_FUNCTION, false, false), // TODO : Change Archeon Continentalness
		ArcheonChunkGeneratorSettings.getArcheonRules(),
		new OverworldBiomeParameters().getSpawnSuitabilityNoises(),
		63,
		false,
		true,
		false,
		false
	);

	public static SurfaceRules.MaterialRule getArcheonRules() {
		return SurfaceRules.sequence(SurfaceRuleUtils.createBuilder(
			SurfaceRuleUtils.getBedrockFloor(),
			SurfaceRules.condition(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
				SurfaceRules.condition(SurfaceRuleUtils.onFloor(), SurfaceRules.condition(
					SurfaceRuleUtils.underWater(), SurfaceRules.sequence(
						SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SOUTH_SNOWY_SLOPES),
							SurfaceRuleUtils.getConditionalBlock(SurfaceRuleUtils.water(), ArcheonBlocks.PEAKS_GRASS_BLOCK, ArcheonBlocks.WET_DIRT)
						),
						SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.SOUTH_SNOWY_PEAKS),
							SurfaceRuleUtils.getBlock(ArcheonBlocks.SNOWY_SOUTHSTONE)
						),
						SurfaceRules.condition(SurfaceRules.not(SurfaceRules.biome(
							ArcheonBiomes.DUNE_OCEAN
						)), SurfaceRuleUtils.getConditionalBlock(SurfaceRuleUtils.water(), ArcheonBlocks.WET_GRASS_BLOCK, ArcheonBlocks.WET_DIRT))
					)
				)),
				SurfaceRules.condition(SurfaceRuleUtils.waterWithStoneDepth(), SurfaceRules.sequence(
					SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.DUNE_OCEAN),
						SurfaceRuleUtils.getBlock(ArcheonBlocks.DUNE_SAND)
					),
					SurfaceRules.condition(SurfaceRuleUtils.water(), SurfaceRules.sequence(
						SurfaceRules.condition(SurfaceRules.not(SurfaceRules.biome(
							ArcheonBiomes.SOUTH_SNOWY_PEAKS
						)), SurfaceRuleUtils.getBlock(ArcheonBlocks.WET_DIRT))
					))
				)),
				SurfaceRules.condition(SurfaceRules.aboveY(YOffset.fixed(33), 0),
					SurfaceRules.condition(SurfaceRules.not(SurfaceRules.aboveY(YOffset.fixed(62), 0)),
						SurfaceRules.condition(SurfaceRules.biome(ArcheonBiomes.DUNE_OCEAN),
							SurfaceRules.condition(SurfaceRuleUtils.water(), SurfaceRuleUtils.getBlock(ArcheonBlocks.DUNE_SAND))
						)
					)
				)
			)),
			SurfaceRuleUtils.getDeep("archeon:depths_aketite", ArcheonBlocks.DEPTHS_AKETITE)
		).build().toArray(SurfaceRules.MaterialRule[]::new));
	}

	@Override
	public void register() {
		RegistrationUtils.registerChunkGeneratorSettings(GENERATOR_SETTINGS_IDENTIFIER, ARCHEON_SETTINGS);
		WorldUtils.addCustomVeinTypes(GENERATOR_SETTINGS_IDENTIFIER,
			new CustomVeinType(5, 45,
				VeinStateGroup.single(ArcheonBlocks.EXYRIANE_ORE),
				VeinStateGroup.single(ArcheonBlocks.EXYRIANE_BLOCK),
				VeinStateGroup.create(ArcheonBlocks.ARTEMNITE, ArcheonBlocks.GYPSUM)
			).setMinRichness(0.05f).setMaxRichness(0.15f),
			new CustomVeinType(-45, -5,
				VeinStateGroup.single(ArcheonBlocks.DEPTHS_APAFLORITE_ORE),
				VeinStateGroup.single(ArcheonBlocks.APAFLORITE_BLOCK),
				VeinStateGroup.single(ArcheonBlocks.AKETITE)
			)
		);
	}
}
