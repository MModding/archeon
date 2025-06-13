package com.mmodding.archeon.mixin;

import com.google.common.collect.Multimap;
import com.mmodding.archeon.items.RingItem;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(value = RingItem.class, remap = false)
public class RingItemMixin extends ItemMixin implements Trinket {

	@Shadow
	@Final
	private TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void registerAsTrinket(TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak, Item.Settings settings, CallbackInfo ci) {
		TrinketsApi.registerTrinket((RingItem) (Object) this, this);
	}

	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		return this.tweak.apply(Trinket.super.getModifiers(stack, slot, entity, uuid));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);
		return TrinketItem.equipItem(user, stack) ? TypedActionResult.success(stack, world.isClient()) : super.use(world, user, hand);
	}
}
