package fr.firstmegagame4.archeon.bootstrap.init;

import com.mmodding.mmodding_lib.library.fluids.cauldrons.CauldronBehaviorMap;
import com.mmodding.mmodding_lib.library.initializers.BootstrapElementsInitializer;
import com.mmodding.mmodding_lib.library.initializers.invokepoints.BootstrapInvokePoint;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFluids;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.sound.SoundEvents;

public class ArcheonCauldronBehaviors implements BootstrapElementsInitializer {

	public static final CauldronBehaviorMap HOT_SPRING_WATER_BEHAVIOR = CauldronBehaviorMap.create();

	public static final CauldronBehaviorMap GLOWING_WATER_BEHAVIOR = CauldronBehaviorMap.create();

	@Override
	public BootstrapInvokePoint getInvokePoint() {
		return BootstrapInvokePoint.before(BootstrapInvokePoint.Type.CAULDRON_BEHAVIORS);
	}

	@Override
	public void registerBootstrap() {
		HOT_SPRING_WATER_BEHAVIOR.addFillCauldronBehavior(
			ArcheonFluids.HOT_SPRING_WATER.getBucket(),
			ArcheonBlocks.HOT_SPRING_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3),
			SoundEvents.ITEM_BUCKET_EMPTY
		);
		GLOWING_WATER_BEHAVIOR.addFillCauldronBehavior(
			ArcheonFluids.GLOWING_WATER.getBucket(),
			ArcheonBlocks.GLOWING_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3),
			SoundEvents.ITEM_BUCKET_EMPTY
		);
		HOT_SPRING_WATER_BEHAVIOR.addEmptyCauldronBehavior(
			ArcheonFluids.HOT_SPRING_WATER.getBucket(),
			state -> state.get(LeveledCauldronBlock.LEVEL) == 3,
			SoundEvents.ITEM_BUCKET_FILL
		);
		GLOWING_WATER_BEHAVIOR.addEmptyCauldronBehavior(
			ArcheonFluids.GLOWING_WATER.getBucket(),
			state -> state.get(LeveledCauldronBlock.LEVEL) == 3,
			SoundEvents.ITEM_BUCKET_FILL
		);
		HOT_SPRING_WATER_BEHAVIOR.addBucketBehaviors();
		GLOWING_WATER_BEHAVIOR.addBucketBehaviors();
	}
}
