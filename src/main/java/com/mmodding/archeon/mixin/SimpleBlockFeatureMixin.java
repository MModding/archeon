package com.mmodding.archeon.mixin;

import com.mmodding.archeon.blocks.GoldenClayBlock;
import com.mmodding.archeon.blocks.PeaksSnowyBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.SimpleBlockFeature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SimpleBlockFeature.class)
public class SimpleBlockFeatureMixin {

	@Inject(method = "place(Lnet/minecraft/world/gen/feature/util/FeatureContext;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/stateprovider/BlockStateProvider;getBlockState(Lnet/minecraft/util/random/RandomGenerator;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
	private void fixMossInfluence(FeatureContext<SimpleBlockFeatureConfig> context, CallbackInfoReturnable<Boolean> cir, SimpleBlockFeatureConfig simpleBlockFeatureConfig, StructureWorldAccess structureWorldAccess, BlockPos blockPos) {
		BlockState state = simpleBlockFeatureConfig.toPlace().getBlockState(context.getRandom(), blockPos);
		if (state.isOf(ArcheonBlocks.ACHREAN_MOSS) && structureWorldAccess.getBlockState(blockPos.down()).isOf(ArcheonBlocks.GOLDEN_CLAY)) {
			structureWorldAccess.setBlockState(blockPos.down(), ArcheonBlocks.GOLDEN_CLAY.getDefaultState().with(GoldenClayBlock.INFLUENCE, GoldenClayBlock.Influence.MOSSY), Block.NOTIFY_LISTENERS);
		}
		if (state.isOf(ArcheonBlocks.SNOWY_GRASS_TUFFET)) {
			BlockState blockState = structureWorldAccess.getBlockState(blockPos.down());
			if (blockState.getBlock() instanceof PeaksSnowyBlock) {
				structureWorldAccess.setBlockState(blockPos.down(), blockState.with(PeaksSnowyBlock.INFLUENCE, PeaksSnowyBlock.Influence.SNOWY), Block.NOTIFY_LISTENERS);
			}
		}
	}
}
