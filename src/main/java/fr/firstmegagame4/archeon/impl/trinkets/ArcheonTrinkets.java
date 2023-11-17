package fr.firstmegagame4.archeon.impl.trinkets;

import com.google.common.collect.Multimap;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ArcheonTrinkets {

	public static Trinket createRing(TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak) {
		return new Trinket() {
			@Override
			public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
				return tweak.apply(Trinket.super.getModifiers(stack, slot, entity, uuid));
			}
		};
	}

	public static Trinket createAmulet() {
		return new Trinket() {
			@Override
			public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
				Multimap<EntityAttribute, EntityAttributeModifier> modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
				SlotAttributes.addSlotModifier(modifiers, "hand/ring", uuid, 1.0, EntityAttributeModifier.Operation.ADDITION);
				return modifiers;
			}
		};
	}
}
