package fr.firstmegagame4.archeon.bootstrap.init;

import com.mmodding.mmodding_lib.library.fluids.cauldrons.CauldronBehaviorMap;
import com.mmodding.mmodding_lib.library.fluids.cauldrons.VanillaCauldronBehaviors;
import com.mmodding.mmodding_lib.library.initializers.BootstrapElementsInitializer;
import com.mmodding.mmodding_lib.library.initializers.invokepoints.BootstrapInvokePoint;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFluids;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ArcheonCauldronBehaviors {

	public static final CauldronBehaviorMap HOT_SPRING_WATER_BEHAVIOR = CauldronBehaviorMap.create();

	public static final CauldronBehaviorMap DASCIUM_BEHAVIOR = CauldronBehaviorMap.create();

	public static void provideInitializers(List<BootstrapElementsInitializer> initializers) {
		initializers.add(new Before());
		initializers.add(new After());
	}

	private static class Before implements BootstrapElementsInitializer {

		@Override
		public BootstrapInvokePoint getInvokePoint() {
			return BootstrapInvokePoint.before(BootstrapInvokePoint.Type.CAULDRON_BEHAVIORS);
		}

		@Override
		public void registerBootstrap() {
			VanillaCauldronBehaviors.WATER_BEHAVIOR.addFillCauldronBehavior(
				Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3),
				SoundEvents.ITEM_BUCKET_EMPTY,
				ArcheonItems.WOODEN_WATER_BUCKET,
				ArcheonItems.CERAMIC_WATER_BUCKET
			);
			VanillaCauldronBehaviors.LAVA_BEHAVIOR.addFillCauldronBehavior(
				Blocks.LAVA_CAULDRON.getDefaultState(),
				SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
				ArcheonItems.CERAMIC_LAVA_BUCKET
			);
			HOT_SPRING_WATER_BEHAVIOR.addFillCauldronBehavior(
				ArcheonBlocks.HOT_SPRING_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3),
				SoundEvents.ITEM_BUCKET_EMPTY,
				ArcheonFluids.HOT_SPRING_WATER.getBucket(),
				ArcheonItems.WOODEN_HOT_SPRING_WATER_BUCKET,
				ArcheonItems.CERAMIC_HOT_SPRING_WATER_BUCKET
			);
			DASCIUM_BEHAVIOR.addFillCauldronBehavior(
				ArcheonBlocks.DASCIUM_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3),
				SoundEvents.ITEM_BUCKET_EMPTY,
				ArcheonFluids.DASCIUM.getBucket(),
				ArcheonItems.WOODEN_DASCIUM_BUCKET,
				ArcheonItems.CERAMIC_DASCIUM_BUCKET
			);
			VanillaCauldronBehaviors.WATER_BEHAVIOR.addEmptyCauldronBehavior(
				state -> state.get(LeveledCauldronBlock.LEVEL) == 3,
				SoundEvents.ITEM_BUCKET_FILL,
				ArcheonItems.WOODEN_WATER_BUCKET,
				ArcheonItems.CERAMIC_WATER_BUCKET
			);
			VanillaCauldronBehaviors.LAVA_BEHAVIOR.addEmptyCauldronBehavior(
				state -> true,
				SoundEvents.ITEM_BUCKET_FILL_LAVA,
				ArcheonItems.CERAMIC_LAVA_BUCKET
			);
			HOT_SPRING_WATER_BEHAVIOR.addEmptyCauldronBehavior(
				state -> state.get(LeveledCauldronBlock.LEVEL) == 3,
				SoundEvents.ITEM_BUCKET_FILL,
				ArcheonFluids.HOT_SPRING_WATER.getBucket(),
				ArcheonItems.WOODEN_HOT_SPRING_WATER_BUCKET,
				ArcheonItems.CERAMIC_HOT_SPRING_WATER_BUCKET
			);
			DASCIUM_BEHAVIOR.addEmptyCauldronBehavior(
				state -> state.get(LeveledCauldronBlock.LEVEL) == 3,
				SoundEvents.ITEM_BUCKET_FILL,
				ArcheonFluids.DASCIUM.getBucket(),
				ArcheonItems.WOODEN_DASCIUM_BUCKET,
				ArcheonItems.CERAMIC_DASCIUM_BUCKET
			);
		}
	}

	private static class After implements BootstrapElementsInitializer {

		@Override
		public BootstrapInvokePoint getInvokePoint() {
			return BootstrapInvokePoint.after(BootstrapInvokePoint.Type.CAULDRON_BEHAVIORS);
		}

		@Override
		public void registerBootstrap() {
			HOT_SPRING_WATER_BEHAVIOR.addBucketBehaviors();
			DASCIUM_BEHAVIOR.addBucketBehaviors();
		}
	}
}
