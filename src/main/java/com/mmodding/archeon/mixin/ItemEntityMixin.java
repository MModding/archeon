package com.mmodding.archeon.mixin;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

	@Shadow
	private int itemAge;

	@Shadow
	public abstract ItemStack getStack();

	@Inject(method = "tick", at = @At("TAIL"))
	private void ceramicCreation(CallbackInfo ci) {
		ItemEntity itemEntity = ((ItemEntity) (Object) this);
		if (!itemEntity.getWorld().isClient()) {
			if (this.getStack().isOf(ArcheonBlocks.CRIADAN.getItem())) {
				if (itemEntity.getWorld().getFluidState(itemEntity.getBlockPos()).isOf(ArcheonFluids.DASCIUM)) {
					if (this.itemAge >= 300) {
						int count = itemEntity.getStack().getCount();
						double x = itemEntity.getX();
						double y = itemEntity.getY();
						double z = itemEntity.getZ();
						double velocityX = itemEntity.getVelocity().x;
						double velocityY = itemEntity.getVelocity().y;
						double velocityZ = itemEntity.getVelocity().z;
						itemEntity.discard();
						itemEntity.world.spawnEntity(new ItemEntity(
							itemEntity.world,
							x, y, z,
							new ItemStack(ArcheonBlocks.CERAMIC_BLOCK.getItem(), count),
							velocityX, velocityY, velocityZ
						));
					}
				}
			}
		}
	}
}
