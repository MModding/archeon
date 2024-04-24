package fr.firstmegagame4.archeon.items;

import com.google.common.collect.Multimap;
import com.mmodding.mmodding_lib.library.items.CustomItemAcceptingStacks;
import com.mmodding.mmodding_lib.library.utils.CompatibilityUtils;
import com.mmodding.mmodding_lib.library.utils.FilterList;
import com.mmodding.mmodding_lib.library.utils.WhiteList;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import fr.firstmegagame4.archeon.init.ArcheonItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import org.quiltmc.loader.api.Requires;

import java.util.UUID;

public class AmuletOfNature extends CustomItemAcceptingStacks implements @Requires("trinkets") Trinket {

	public AmuletOfNature(Settings settings) {
		super(settings);
		CompatibilityUtils.executeIfModLoaded("trinkets", this::registerTrinket);
	}

	@Override
	public void receiveStack(ItemStack currentStack, ItemStack receivedStack) {
		NbtCompound nbt = currentStack.getOrCreateNbt();
		nbt.putInt("power", receivedStack.getCount() + (nbt.contains("power") ? nbt.getInt("power") : 0));
	}

	@Override
	public void playReceiveStackSound(PlayerEntity player) {
		player.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8f, 0.8f + player.getWorld().getRandom().nextFloat() * 0.4f);
	}

	@Override
	public FilterList<Item> getFilter() {
		return new WhiteList<>(ArcheonItems.IMPRESSIVE_AURORA_CRYSTAL);
	}

	@Override
	@Requires("trinkets")
	public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
		int amount = stack.getNbt() != null ? stack.getNbt().contains("power") ? stack.getNbt().getInt("power") : 0 : 0;
		Multimap<EntityAttribute, EntityAttributeModifier> modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
		SlotAttributes.addSlotModifier(modifiers, "hand/ring", uuid, amount, EntityAttributeModifier.Operation.ADDITION);
		return modifiers;
	}

	@Requires("trinkets")
	private void registerTrinket() {
		TrinketsApi.registerTrinket(this, this);
	}
}
