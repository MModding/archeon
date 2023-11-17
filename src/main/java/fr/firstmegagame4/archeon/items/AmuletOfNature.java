package fr.firstmegagame4.archeon.items;

import com.google.common.collect.Multimap;
import com.mmodding.mmodding_lib.library.utils.TweakFunction;
import dev.emi.trinkets.api.TrinketsApi;
import fr.firstmegagame4.archeon.impl.trinkets.ArcheonTrinkets;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class AmuletOfNature extends RingItem {

	public AmuletOfNature(Settings settings) {
		super(tweak -> tweak, settings);
	}

	@Override
	protected void registerTrinket(TweakFunction<Multimap<EntityAttribute, EntityAttributeModifier>> tweak) {
		TrinketsApi.registerTrinket(this, ArcheonTrinkets.createAmulet());
	}
}
