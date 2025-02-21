package com.mmodding.archeon.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import com.mmodding.archeon.init.ArcheonEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	@Inject(method = "getBlockBreakingSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getEfficiency(Lnet/minecraft/entity/LivingEntity;)I"))
	private void efficiencyOfTheQolm(BlockState block, CallbackInfoReturnable<Float> cir, @Local LocalFloatRef f) {
		PlayerEntity playerEntity = ((PlayerEntity) (Object) this);
		int level = EnchantmentHelper.getEquipmentLevel(ArcheonEnchantments.EFFICIENCY_OF_THE_QOLM, playerEntity);
		ItemStack itemStack = playerEntity.getMainHandStack();
		if (level > 0 && !itemStack.isEmpty()) {
			// Vanilla Efficiency uses n^2 + 1, we use e^(0.6n).
			// So with n = 7; it is about 66.6, which is not enough to break phosnor slate instantly.
			// And with n = 8; it is about 121.5, which is enough to break phosnor slate instantly.
			f.set(f.get() + (float) Math.exp(0.6 * level));
		}
	}
}
