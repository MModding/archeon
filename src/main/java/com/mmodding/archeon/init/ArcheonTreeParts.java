package com.mmodding.archeon.init;

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
import net.minecraft.registry.Registries;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ArcheonTreeParts {

	public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = new TrunkPlacerType<>(PalmTrunkPlacer.CODEC);
	public static final TrunkPlacerType<NeclaneTrunkPlacer> NECLANE_TRUNK_PLACER = new TrunkPlacerType<>(NeclaneTrunkPlacer.CODEC);
	public static final TrunkPlacerType<VuxanciaTrunkPlacer> VUXANCIA_TRUNK_PLACER = new TrunkPlacerType<>(VuxanciaTrunkPlacer.CODEC);

	public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = new FoliagePlacerType<>(PalmFoliagePlacer.CODEC);
	public static final FoliagePlacerType<NeclaneFoliagePlacer> NECLANE_FOLIAGE_PLACER = new FoliagePlacerType<>(NeclaneFoliagePlacer.CODEC);
	public static final FoliagePlacerType<CypressFoliagePlacer> CYPRESS_FOLIAGE_PLACER = new FoliagePlacerType<>(CypressFoliagePlacer.CODEC);
	public static final FoliagePlacerType<VuxanciaFoliagePlacer> VUXANCIA_FOLIAGE_PLACER = new FoliagePlacerType<>(VuxanciaFoliagePlacer.CODEC);

	public static final TreeDecoratorType<SporeRootcapTreeDecorator> SPORE_ROOTCAP_DECORATOR = new TreeDecoratorType<>(SporeRootcapTreeDecorator.CODEC);
	public static final TreeDecoratorType<HangingLeavesTreeDecorator> HANGING_LEAVES_DECORATOR = new TreeDecoratorType<>(HangingLeavesTreeDecorator.CODEC);

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.TRUNK_PLACER_TYPE, factory -> {
			factory.register("palm_trunk_placer", PALM_TRUNK_PLACER);
			factory.register("neclane_trunk_placer", NECLANE_TRUNK_PLACER);
			factory.register("vuxancia_trunk_placer", VUXANCIA_TRUNK_PLACER);
		});
		mod.register(Registries.FOLIAGE_PLACER_TYPE, factory -> {
			factory.register("palm_foliage_placer", PALM_FOLIAGE_PLACER);
			factory.register("neclane_foliage_placer", NECLANE_FOLIAGE_PLACER);
			factory.register("cypress_foliage_placer", CYPRESS_FOLIAGE_PLACER);
			factory.register("vuxancia_foliage_placer", VUXANCIA_FOLIAGE_PLACER);
		});
		mod.register(Registries.TREE_DECORATOR_TYPE, factory -> {
			factory.register("spore_rootcap_decorator", SPORE_ROOTCAP_DECORATOR);
			factory.register("hanging_leaves_decorator", HANGING_LEAVES_DECORATOR);
		});
	}
}
