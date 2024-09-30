package com.mmodding.archeon.client.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;

import java.util.Objects;

public class ArcheonModelPredicates implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ModelPredicateProviderRegistry.register(ArcheonItems.FAELITE_BOW, Archeon.createId("pull"), (stack, world, entity, seed) ->
			entity != null ? entity.getActiveItem() == stack ? (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f : 0.0f : 0.0f
		);
		ModelPredicateProviderRegistry.register(ArcheonItems.FAELITE_BOW, Archeon.createId("pulling"), (stack, world, entity, seed) ->
			entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f
		);
		ModelPredicateProviderRegistry.register(Archeon.createId("lusonyfied"), (stack, world, entity, seed) ->
			stack.hasNbt() && Objects.requireNonNull(stack.getNbt()).contains("repair_rate") ? stack.getNbt().getInt("repair_rate") / 10.0f : 0.0f
		);
	}
}
