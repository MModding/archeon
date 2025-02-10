package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.NoiseRouterUtils;
import com.mmodding.mmodding_lib.library.worldgen.MModdingDensityFunctions;
import com.mmodding.mmodding_lib.library.worldgen.chunkgenerators.routers.CustomNoiseRouters;
import net.minecraft.util.Identifier;
import net.minecraft.util.function.ToFloatFunction;
import net.minecraft.util.math.Spline;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.util.VanillaTerrainParametersCreator;
import net.minecraft.world.gen.DensityFunction;
import net.minecraft.world.gen.DensityFunctions;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.noise.NoiseRouter;
import net.minecraft.world.gen.noise.NoiseRouterData;

public class ArcheonNoiseRouter implements ElementsInitializer {

	public static final RegistryKey<DensityFunction> OFFSET_ARCHEON = RegistryKey.of(Registry.DENSITY_FUNCTION_WORLDGEN, Archeon.createId("archeon/offset"));
	public static final RegistryKey<DensityFunction> DEPTH_ARCHEON = RegistryKey.of(Registry.DENSITY_FUNCTION_WORLDGEN, Archeon.createId("archeon/depth"));
	public static final RegistryKey<DensityFunction> SLOPED_CHEESE_ARCHEON = RegistryKey.of(Registry.DENSITY_FUNCTION_WORLDGEN, Archeon.createId("archeon/sloped_cheese"));

	private static final float ARCHEON_OCEAN_FLOOR = -0.04f;

	private static <C, I extends ToFloatFunction<C>> Spline<C, I> createArcheonOffsetSpline(I continentsWrapper, I erosionWrapper, I ridgesFoldedWrapper) {
		Spline<C, I> spline = VanillaTerrainParametersCreator.method_42051(erosionWrapper, ridgesFoldedWrapper, -0.15f, 0.0f, 0.0f, 0.1f, 0.0f, -0.03f, false, false, ToFloatFunction.field_37409);
		Spline<C, I> spline2 = VanillaTerrainParametersCreator.method_42051(erosionWrapper, ridgesFoldedWrapper, -0.1f, 0.03f, 0.1f, 0.1f, 0.01f, -0.03f, false, false, ToFloatFunction.field_37409);
		Spline<C, I> spline3 = VanillaTerrainParametersCreator.method_42051(erosionWrapper, ridgesFoldedWrapper, -0.1f, 0.03f, 0.1f, 0.7f, 0.01f, -0.03f, true, true, ToFloatFunction.field_37409);
		Spline<C, I> spline4 = VanillaTerrainParametersCreator.method_42051(erosionWrapper, ridgesFoldedWrapper, -0.05f, 0.03f, 0.1f, 1.0f, 0.01f, 0.01f, true, true, ToFloatFunction.field_37409);
		return Spline.builder(continentsWrapper, ToFloatFunction.field_37409)
			.method_41294(-1.1f, 0.044f)
			.method_41294(-1.02f, ArcheonNoiseRouter.ARCHEON_OCEAN_FLOOR) // right parameter was -0.2222, vanilla deep ocean floor
			.method_41294(-0.51f, ArcheonNoiseRouter.ARCHEON_OCEAN_FLOOR) // right parameter was -0.2222, vanilla deep ocean floor
			.method_41294(-0.44f, ArcheonNoiseRouter.ARCHEON_OCEAN_FLOOR) // right parameter was -0.12, vanilla ocean floor
			.method_41294(-0.18f, ArcheonNoiseRouter.ARCHEON_OCEAN_FLOOR) // right parameter was -0.12, vanilla ocean floor
			.method_41295(-0.16f, spline)
			.method_41295(-0.15f, spline)
			.method_41295(-0.1f, spline2)
			.method_41295(0.25f, spline3)
			.method_41295(1.0f, spline4)
			.build();
	}

	@SuppressWarnings("SameParameterValue")
	private static void registerArcheonSlopedCheese(Registry<DensityFunction> registry, DensityFunction jaggedNoise) {
		DensityFunctions.Spline.C_eljbykfw continentsWrapper = new DensityFunctions.Spline.C_eljbykfw(registry.getHolderOrThrow(MModdingDensityFunctions.CONTINENTS_SMALL_BIOMES));
		DensityFunctions.Spline.C_eljbykfw erosionWrapper = new DensityFunctions.Spline.C_eljbykfw(registry.getHolderOrThrow(MModdingDensityFunctions.EROSION_SMALL_BIOMES));
		DensityFunctions.Spline.C_eljbykfw ridgesFoldedWrapper = new DensityFunctions.Spline.C_eljbykfw(registry.getHolderOrThrow(NoiseRouterData.RIDGES_FOLDED_OVERWORLD));
		DensityFunction offsetFunction = NoiseRouterUtils.registerAndGetHolder(
			registry,
			ArcheonNoiseRouter.OFFSET_ARCHEON,
			NoiseRouterUtils.applyBlending(
				DensityFunctions.add(
					DensityFunctions.constant(-0.50375f),
					DensityFunctions.method_41528(ArcheonNoiseRouter.createArcheonOffsetSpline(continentsWrapper, erosionWrapper, ridgesFoldedWrapper))
				),
				DensityFunctions.getBlendOffset()
			)
		);
		DensityFunction factorFunction = NoiseRouterUtils.getFunction(registry, MModdingDensityFunctions.FACTOR_SMALL_BIOMES);
		DensityFunction depthFunction = NoiseRouterUtils.registerAndGetHolder(
			registry, ArcheonNoiseRouter.DEPTH_ARCHEON, DensityFunctions.add(DensityFunctions.clampedGradientY(-64, 320, 1.5, -1.5), offsetFunction)
		);
		DensityFunction jaggednessFunction = NoiseRouterUtils.getFunction(registry, MModdingDensityFunctions.JAGGEDNESS_SMALL_BIOMES);
		DensityFunction jaggedNoiseFunction = DensityFunctions.multiply(jaggednessFunction, jaggedNoise.halfNegative());
		DensityFunction initialDensityFunction = NoiseRouterUtils.createInitialDensityFunction(factorFunction, DensityFunctions.add(depthFunction, jaggedNoiseFunction));
		NoiseRouterUtils.register(registry, ArcheonNoiseRouter.SLOPED_CHEESE_ARCHEON, DensityFunctions.add(initialDensityFunction, NoiseRouterUtils.getFunction(registry, RegistryKey.of(Registry.DENSITY_FUNCTION_WORLDGEN, new Identifier("overworld/base_3d_noise")))));
	}

	public static NoiseRouter getRouter(Registry<DensityFunction> registry) {
		DensityFunction factor = NoiseRouterUtils.getFunction(registry, MModdingDensityFunctions.FACTOR_SMALL_BIOMES);
		DensityFunction depths = NoiseRouterUtils.getFunction(registry, ArcheonNoiseRouter.DEPTH_ARCHEON);

		DensityFunction initialDensity = NoiseRouterUtils.createInitialDensityFunction(factor, depths);

		DensityFunction slopedCheese = NoiseRouterUtils.getFunction(registry, ArcheonNoiseRouter.SLOPED_CHEESE_ARCHEON);

		DensityFunction caveEntrances = DensityFunctions.min(
			slopedCheese, DensityFunctions.multiply(DensityFunctions.constant(5.0), NoiseRouterUtils.getFunction(registry, MModdingDensityFunctions.CAVES_ENTRANCES))
		);

		DensityFunction underground = DensityFunctions.rangeChoice(
			slopedCheese, -1000000.0, 1.5625, caveEntrances, NoiseRouterUtils.createUndergroundCaves(registry, slopedCheese)
		);

		DensityFunction finalDensity = DensityFunctions.min(
			NoiseRouterUtils.applyBlendDensity(NoiseRouterUtils.applySurfaceSlides(false, underground)),
			NoiseRouterUtils.getFunction(registry, MModdingDensityFunctions.CAVES_NOODLES)
		);

		return CustomNoiseRouters.Builders.getSmallBiomes(registry)
			.depth((old, functions, params) -> depths)
			.initialNonJaggedDensity((old, functions, params) -> NoiseRouterUtils.applySurfaceSlides(
				false,
				DensityFunctions
					.add(initialDensity, DensityFunctions.constant(-0.703125))
					.clamp(-64.0, 64.0)
			))
			.fullNoise((old, functions, params) -> finalDensity)
			.build();
	}

	@Override
	public void register() {
		ArcheonNoiseRouter.registerArcheonSlopedCheese(BuiltinRegistries.DENSITY_FUNCTION, DensityFunctions.noise(NoiseRouterUtils.getNoise(NoiseParametersKeys.JAGGED), 1500.0, 0.0));
	}
}
