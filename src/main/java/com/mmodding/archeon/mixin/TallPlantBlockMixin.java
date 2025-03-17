package com.mmodding.archeon.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mmodding.archeon.blocks.SouthWheatBlock;
import com.mmodding.archeon.init.ArcheonBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TallPlantBlock.class)
public class TallPlantBlockMixin {

	@WrapOperation(method = "placeAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", ordinal = 1))
	private static boolean cancelUpperStateIfSouthWheatWithLevelBelow2(WorldAccess instance, BlockPos blockPos, BlockState blockState, int i, Operation<Boolean> original) {
		if (blockState.isOf(ArcheonBlocks.SOUTH_WHEAT) && blockState.get(SouthWheatBlock.AGE) < 2) {
			return false;
		}
		else {
			return original.call(instance, blockPos, blockState, i);
		}
	}
}
