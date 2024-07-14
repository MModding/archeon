package com.mmodding.archeon.mixin;

import com.mmodding.archeon.init.ArcheonItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

	@Inject(method = "isInGroup", at = @At("TAIL"), cancellable = true)
	private void isInGroup(ItemGroup group, CallbackInfoReturnable<Boolean> cir) {
		if (Registry.ITEM.getId((Item) (Object) this).getNamespace().equals("archeon")) {
			cir.setReturnValue(ArcheonItemGroups.IS_IN_CREATIVE_TAB.test((Item) (Object) this) && group == ItemGroup.SEARCH);
		}
	}
}
