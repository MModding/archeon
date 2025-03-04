package com.mmodding.archeon.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mmodding.archeon.blocks.XetulianSugarCaneBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.BlockColumnFeature;
import net.minecraft.world.gen.feature.BlockColumnFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(BlockColumnFeature.class)
public class BlockColumnFeatureMixin {

	@Inject(method = "place", at = @At("HEAD"))
	private void initList(FeatureContext<BlockColumnFeatureConfig> context, CallbackInfoReturnable<Boolean> cir, @Share("xetulianSugarCanes") LocalRef<List<BlockPos>> xetulianSugarCanes) {
		xetulianSugarCanes.set(new ArrayList<>());
	}

	@WrapOperation(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/StructureWorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
	private boolean addXetulianPositions(StructureWorldAccess instance, BlockPos blockPos, BlockState blockState, int i, Operation<Boolean> original, @Share("xetulianSugarCanes") LocalRef<List<BlockPos>> xetulianSugarCanes) {
		if (blockState.isOf(ArcheonBlocks.XETULIAN_SUGAR_CANE)) {
			List<BlockPos> list = xetulianSugarCanes.get();
			list.add(blockPos);
			xetulianSugarCanes.set(list);
		}
		return original.call(instance, blockPos, blockState, i);
	}

	@Inject(method = "place", at = @At(value = "TAIL"))
	private void fixXetulianTop(FeatureContext<BlockColumnFeatureConfig> context, CallbackInfoReturnable<Boolean> cir, @Share("xetulianSugarCanes") LocalRef<List<BlockPos>> xetulianSugarCanes) {
		int maxY = 0;
		for (BlockPos pos : xetulianSugarCanes.get()) {
			maxY = Math.max(maxY, pos.getY());
		}
		for (BlockPos pos : xetulianSugarCanes.get()) {
			if (pos.getY() == maxY) {
				context.getWorld().setBlockState(pos, ArcheonBlocks.XETULIAN_SUGAR_CANE.getDefaultState().with(XetulianSugarCaneBlock.HEAD, true), XetulianSugarCaneBlock.NOTIFY_NEIGHBORS);
			}
		}
	}
}
