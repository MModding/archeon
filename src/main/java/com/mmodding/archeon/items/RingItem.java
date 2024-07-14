package com.mmodding.archeon.items;

import amymialee.doublejumpattribute.DoubleJumpAttribute;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.mmodding.mmodding_lib.library.items.CustomItem;
import com.mmodding.mmodding_lib.library.utils.CompatibilityUtils;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.quiltmc.loader.api.Requires;

import java.util.ArrayList;
import java.util.UUID;

public class RingItem extends CustomItem implements @Requires("trinkets") Trinket {

	public static final UUID MOVEMENT_SPEED_MODIFIER_ID = UUID.fromString("97de589f-1ae6-4528-8c72-b50c904e8bf1");
	public static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("89cb7bb9-a460-4df2-a844-b6514d412c9b");
	public static final UUID KNOCKBACK_RESISTANCE_MODIFIER_ID = UUID.fromString("8347d59a-4da5-491b-81f2-1f2298baf8f4");
	public static final UUID MAX_HEALTH_MODIFIER_ID = UUID.fromString("78a7c665-180e-4658-b045-0606a78a8118");
	public static final UUID JUMPS_MODIFIER_ID = UUID.fromString("59b89d62-834a-481e-9a99-0582900aaf89");
	public static final UUID ARMOR_MODIFIER_ID = UUID.fromString("2fa34e64-9356-457b-9e07-0d4b4fdf1965");

	private final TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak;

	public RingItem(TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak, Settings settings) {
		super(settings);
		this.tweak = tweak;
		CompatibilityUtils.executeIfModLoaded("trinkets", this::registerTrinket);
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> apafloriteRingModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(
			RingItem.MOVEMENT_SPEED_MODIFIER_ID,
			"Ring modifier",
			0.6,
			EntityAttributeModifier.Operation.MULTIPLY_TOTAL
		));
		return modifiers;
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> faeliteRingModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
			RingItem.ATTACK_DAMAGE_MODIFIER_ID,
			"Ring modifier",
			3.0,
			EntityAttributeModifier.Operation.ADDITION
		));
		return modifiers;
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> clementiumRingModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(
			RingItem.KNOCKBACK_RESISTANCE_MODIFIER_ID,
			"Ring modifier",
			0.1,
			EntityAttributeModifier.Operation.ADDITION
		));
		return modifiers;
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> lusonythRingModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(
			RingItem.MAX_HEALTH_MODIFIER_ID,
			"Ring modifier",
			4.0,
			EntityAttributeModifier.Operation.ADDITION
		));
		return modifiers;
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> ringOfEdenModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(DoubleJumpAttribute.JUMPS, new EntityAttributeModifier(
			RingItem.JUMPS_MODIFIER_ID,
			"Ring modifier",
			1.0,
			EntityAttributeModifier.Operation.ADDITION
		));
		return modifiers;
	}

	public static Multimap<EntityAttribute, EntityAttributeModifier> ringOfWahvenModifiers(Multimap<EntityAttribute, EntityAttributeModifier> modifiers) {
		modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(
			RingItem.ARMOR_MODIFIER_ID,
			"Ring modifier",
			8.0,
			EntityAttributeModifier.Operation.ADDITION
		));
		return modifiers;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);
		return CompatibilityUtils.getIfModLoadedOrElse("trinkets", () -> this.equipTrinket(world, user, hand, stack), () -> super.use(world, user, hand));
	}

	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND ? this.tweak.apply(Multimaps.newMultimap(Maps.newLinkedHashMap(), ArrayList::new)) : super.getAttributeModifiers(slot);
	}

	@Override
	@Requires("trinkets")
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		return this.tweak.apply(Trinket.super.getModifiers(stack, slot, entity, uuid));
	}

	@Requires("trinkets")
	private void registerTrinket() {
		TrinketsApi.registerTrinket(this, this);
	}

	private TypedActionResult<ItemStack> equipTrinket(World world, PlayerEntity user, Hand hand, ItemStack stack) {
		return TrinketItem.equipItem(user, stack) ? TypedActionResult.success(stack, world.isClient()) : super.use(world, user, hand);
	}
}
