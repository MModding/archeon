package fr.firstmegagame4.archeon.mixin;

import fr.firstmegagame4.archeon.init.ArcheonEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

	@Inject(method = "getEfficiency", at = @At("HEAD"), cancellable = true)
	private static void getEfficiency(LivingEntity entity, CallbackInfoReturnable<Integer> cir) {
		int level = EnchantmentHelper.getEquipmentLevel(ArcheonEnchantments.EFFICIENCY_OF_THE_QOLM, entity);
		if (level != 0) {
			cir.setReturnValue(level);
		}
	}
}
