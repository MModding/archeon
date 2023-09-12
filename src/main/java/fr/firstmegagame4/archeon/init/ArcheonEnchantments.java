package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.enchantments.CustomEnchantment;
import com.mmodding.mmodding_lib.library.enchantments.types.EnchantmentType;
import com.mmodding.mmodding_lib.library.glint.DefaultGlintPacks;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.enchantments.BloodySharpnessEnchantment;
import fr.firstmegagame4.archeon.enchantments.EfficiencyOfTheQolmEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;

import java.util.List;

public class ArcheonEnchantments implements ElementsInitializer {

	public static final EnchantmentType MASSACRE = EnchantmentType.builder("massacre")
		.enchantedBookItemSettings(settings -> settings.rarity(Rarity.RARE).nameFormattings(Formatting.RED).glintPack(DefaultGlintPacks.LIGHTENED_RED))
		.formattings(enchantment -> List.of(enchantment.isCursed() ? Formatting.DARK_PURPLE : Formatting.DARK_RED))
		.inEnchantingTable(false)
		.build();

	public static final EnchantmentType QOLM = EnchantmentType.builder("qolm")
		.enchantedBookItemSettings(settings -> settings.rarity(Rarity.RARE).nameFormattings(Formatting.GREEN).glintPack(DefaultGlintPacks.LIGHTENED_GREEN))
		.formattings(enchantment -> List.of(enchantment.isCursed() ? Formatting.DARK_AQUA : Formatting.DARK_GREEN))
		.inEnchantingTable(false)
		.build();

	public static final CustomEnchantment BLOODY_SHARPNESS = new BloodySharpnessEnchantment(ArcheonEnchantments.MASSACRE, Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
	public static final CustomEnchantment EFFICIENCY_OF_THE_QOLM = new EfficiencyOfTheQolmEnchantment(ArcheonEnchantments.QOLM, Enchantment.Rarity.VERY_RARE, EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND);

	@Override
	public void register() {
		MASSACRE.register(Archeon.createId("massacre_book"));
		QOLM.register(Archeon.createId("qolm_book"));
		BLOODY_SHARPNESS.register(Archeon.createId("bloody_sharpness"));
		EFFICIENCY_OF_THE_QOLM.register(Archeon.createId("efficiency_of_the_qolm"));
	}
}
