package com.mmodding.archeon.mixin;

import com.google.common.collect.Multimap;
import com.mmodding.archeon.items.AmuletOfNatureItem;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(value = AmuletOfNatureItem.class, remap = false)
public class AmuletOfNatureItemMixin implements Trinket {

	@Inject(method = "<init>", at = @At("TAIL"))
	private void registerAsTrinket(Item.Settings settings, CallbackInfo ci) {
		TrinketsApi.registerTrinket((AmuletOfNatureItem) (Object) this, this);
	}

	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		int amount = stack.getNbt() != null ? stack.getNbt().contains("power") ? stack.getNbt().getInt("power") : 0 : 0;
		Multimap<EntityAttribute, EntityAttributeModifier> modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
		SlotAttributes.addSlotModifier(modifiers, "hand/ring", uuid, amount, EntityAttributeModifier.Operation.ADDITION);
		return modifiers;
	}
}
