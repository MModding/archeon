package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.enchantments.BloodySharpnessEnchantment;
import com.mmodding.archeon.enchantments.EfficiencyOfTheQolmEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.CustomEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.types.EnchantmentType;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Formatting;

import java.util.List;

public class ArcheonEnchantments implements ElementsInitializer {

	public static final EnchantmentType MASSACRE = EnchantmentType.builder("massacre")
		.bookItem(() -> ArcheonItems.MASSACRE_BOOK)
		.formattings(enchantment -> List.of(enchantment.isCursed() ? Formatting.DARK_PURPLE : Formatting.DARK_RED))
		.inEnchantingTable(false)
		.build();

	public static final EnchantmentType QOLM = EnchantmentType.builder("qolm")
		.bookItem(() -> ArcheonItems.QOLM_BOOK)
		.formattings(enchantment -> List.of(enchantment.isCursed() ? Formatting.DARK_AQUA : Formatting.DARK_GREEN))
		.inEnchantingTable(false)
		.build();

	public static final CustomEnchantment BLOODY_SHARPNESS = new BloodySharpnessEnchantment(ArcheonEnchantments.MASSACRE, Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
	public static final CustomEnchantment EFFICIENCY_OF_THE_QOLM = new EfficiencyOfTheQolmEnchantment(ArcheonEnchantments.QOLM, Enchantment.Rarity.VERY_RARE, EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND);

	@Override
	public void register() {
		BLOODY_SHARPNESS.register(Archeon.createId("bloody_sharpness"));
		EFFICIENCY_OF_THE_QOLM.register(Archeon.createId("efficiency_of_the_qolm"));
	}
}
