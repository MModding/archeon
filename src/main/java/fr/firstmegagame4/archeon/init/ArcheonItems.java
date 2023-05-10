package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.items.*;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.materials.armor.ApafloriteArmor;
import fr.firstmegagame4.archeon.materials.armor.ClothesTunic;
import fr.firstmegagame4.archeon.materials.armor.FaeliteArmor;
import fr.firstmegagame4.archeon.materials.tool.ApafloriteTool;
import fr.firstmegagame4.archeon.materials.tool.FaeliteTool;
import fr.firstmegagame4.archeon.materials.tool.MassacreDaggerTool;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ArcheonItems implements ElementsInitializer {

	public static final CustomItem APAFLORITE_GEMSTONE = new CustomItem(new CustomItemSettings());

	public static final CustomArmorItem APAFLORITE_HELMET = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.HEAD, new CustomItemSettings());
	public static final CustomArmorItem APAFLORITE_CHESTPLATE = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.CHEST, new CustomItemSettings());
	public static final CustomArmorItem APAFLORITE_LEGGINGS = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.LEGS, new CustomItemSettings());
	public static final CustomArmorItem APAFLORITE_BOOTS = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.FEET, new CustomItemSettings());

	public static final CustomSwordItem APAFLORITE_SABER = new CustomSwordItem(ApafloriteTool.INSTANCE, 5, -0.8f, new CustomItemSettings());
	public static final CustomPickaxeItem APAFLORITE_PICKAXE = new CustomPickaxeItem(ApafloriteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());
	public static final CustomAxeItem APAFLORITE_AXE = new CustomAxeItem(ApafloriteTool.INSTANCE, 6, -3.1f, new CustomItemSettings());
	public static final CustomShovelItem APAFLORITE_SHOVEL = new CustomShovelItem(ApafloriteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());
	public static final CustomHoeItem APAFLORITE_HOE = new CustomHoeItem(ApafloriteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());

	public static final CustomMusicDiscItem ARCHEON_CHRISTMAS = new CustomMusicDiscItem(new CustomItemSettings().maxCount(1),
		new SoundEvent(Archeon.createId("archeon_christmas")), 0, 165);

	public static final CustomItem BLOOD_ORANGE = new CustomItem(new CustomItemSettings());
	public static final CustomItem BLUE_SHELL = new CustomItem(new CustomItemSettings());

	public static final CustomArmorItem CLOTHES_CHESTPLATE = new CustomArmorItem(ClothesTunic.INSTANCE, EquipmentSlot.CHEST, new CustomItemSettings());
	public static final CustomArmorItem CLOTHES_LEGGINGS = new CustomArmorItem(ClothesTunic.INSTANCE, EquipmentSlot.LEGS, new CustomItemSettings());

	public static final CustomItem COOKED_HEIFER = new CustomItem(new CustomItemSettings());
	public static final CustomItem COOKED_SUNSTRADIVER_CHOP = new CustomItem(new CustomItemSettings());

	public static final CustomSwordItem CYPRESS_SWORD = new CustomSwordItem(ToolMaterials.WOOD, 3, -2.4f, new CustomItemSettings());
	public static final CustomPickaxeItem CYPRESS_PICKAXE = new CustomPickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new CustomItemSettings());
	public static final CustomAxeItem CYPRESS_AXE = new CustomAxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new CustomItemSettings());
	public static final CustomShovelItem CYPRESS_SHOVEL = new CustomShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new CustomItemSettings());
	public static final CustomHoeItem CYPRESS_HOE = new CustomHoeItem(ToolMaterials.WOOD, 0, -3.0f, new CustomItemSettings());

	public static final CustomMusicDiscItem DEVOURING = new CustomMusicDiscItem(new CustomItemSettings().maxCount(1),
		new SoundEvent(Archeon.createId("glaive")), 0, 176);

	public static final CustomItem EXYRIANE_CRYSTAL = new CustomItem(new CustomItemSettings());
	public static final CustomFishingRodItem EXYRIANE_FISHING_ROD = new CustomFishingRodItem(new CustomItemSettings());

	public static final CustomItem FAELITE_INGOT = new CustomItem(new Item.Settings());

	public static final CustomArmorItem FAELITE_HELMET = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.HEAD, new CustomItemSettings());
	public static final CustomArmorItem FAELITE_CHESTPLATE = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.CHEST, new CustomItemSettings());
	public static final CustomArmorItem FAELITE_LEGGINGS = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.LEGS, new CustomItemSettings());
	public static final CustomArmorItem FAELITE_BOOTS = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.FEET, new CustomItemSettings());

	public static final CustomSwordItem FAELITE_SWORD = new CustomSwordItem(FaeliteTool.INSTANCE, 7, -2.4f, new CustomItemSettings());
	public static final CustomPickaxeItem FAELITE_PICKAXE = new CustomPickaxeItem(FaeliteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());
	public static final CustomAxeItem FAELITE_AXE = new CustomAxeItem(FaeliteTool.INSTANCE, 8, -3.1f, new CustomItemSettings());
	public static final CustomShovelItem FAELITE_SHOVEL = new CustomShovelItem(FaeliteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());
	public static final CustomHoeItem FAELITE_HOE = new CustomHoeItem(FaeliteTool.INSTANCE, 1, -3.1f, new CustomItemSettings());

	public static final CustomItem GEAR = new CustomItem(new CustomItemSettings());

	public static final CustomMusicDiscItem GEOMETRIC_FALL = new CustomMusicDiscItem(new CustomItemSettings().maxCount(1),
		new SoundEvent(Archeon.createId("geometric_fall")), 0, 74);

	public static final CustomItem GOBLET = new CustomItem(new CustomItemSettings());

	public static final CustomItemSettings.ItemFinishUsingSetting GOBLET_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.GOBLET) : stack);

	public static final CustomItem GOBLET_WATER = new CustomItem(new CustomItemSettings().maxCount(1)
		.food(0, 0.0f, false, true).drinkable().itemFinishUsing(GOBLET_USE));

	public static final CustomItem GOBLET_BLOOD_ORANGE_JUICE = new CustomItem(new CustomItemSettings().maxCount(1)
		.food(4, 0.5f).drinkable().itemFinishUsing(GOBLET_USE));

	public static final CustomItem GOBLET_COCONUT_MILK = new CustomItem(new CustomItemSettings().maxCount(1)
		.food(0, 0.0f, false, true).drinkable().itemFinishUsing((stack, world, user) -> {
		if (!world.isClient()) {
			user.clearStatusEffects();
		}
		return GOBLET_USE.apply(stack, world, user);
	}));

	public static final CustomItem GRAPE = new CustomItem(new CustomItemSettings().food(1, 0.3f));

	public static final CustomItem GOLDEN_GRAPE = new CustomItem(new CustomItemSettings().food(
		new FoodComponent.Builder()
			.hunger(5)
			.saturationModifier(2.5f)
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 160, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 0, 3), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160, 1), 1.0f)
			.build()
	));

	public static final CustomItem HERBICIDE = new CustomItem(new CustomItemSettings().maxCount(1).eatable()
		.descriptionLines(Text.of("§7Don't use this.")).itemDropped((stack, world, user, droppedItem) -> world.createExplosion(
				droppedItem,
				droppedItem.getX(),
				droppedItem.getY(),
				droppedItem.getZ(),
				3,
				Explosion.DestructionType.NONE
		)));

	public static final CustomItem INK_BOTTLE = new CustomItem(new CustomItemSettings().maxCount(16));

	public static final CustomItem JAM_POT = new CustomItem(new CustomItemSettings());

	public static final CustomItemSettings.ItemFinishUsingSetting JAM_POT_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.JAM_POT) : stack);

	public static final CustomItem ORANGE_LYCORIS_JAM_POT = new CustomItem(new CustomItemSettings().maxCount(1).food(
		new FoodComponent.Builder()
			.hunger(5)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000), 1.0f)
			.build()
	).itemFinishUsing(JAM_POT_USE));

	public static final CustomItem ORANGE_LYCORIS_PETAL = new CustomItem(new CustomItemSettings().food(3, 0.2f));

	public static final CustomItem MANUSCRIPT = new CustomItem(new CustomItemSettings());

	public static final CustomSwordItem MASSACRE_DAGGER = new CustomSwordItem(MassacreDaggerTool.INSTANCE, 3, -0.5f,
		new CustomItemSettings().fireproof().itemPostHit((stack, target, attacker) -> {
			World world = target.getWorld();
			world.syncWorldEvent(2001, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60));
			world.syncWorldEvent(2001, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
		}));

	public static final CustomItem MOSS_BALL = new CustomItem(new CustomItemSettings().food(1, 0.5f));

	public static final CustomSwordItem NECLANE_SWORD = new CustomSwordItem(ToolMaterials.WOOD, 3, -2.4f, new CustomItemSettings());
	public static final CustomPickaxeItem NECLANE_PICKAXE = new CustomPickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new CustomItemSettings());
	public static final CustomAxeItem NECLANE_AXE = new CustomAxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new CustomItemSettings());
	public static final CustomShovelItem NECLANE_SHOVEL = new CustomShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new CustomItemSettings());
	public static final CustomHoeItem NECLANE_HOE = new CustomHoeItem(ToolMaterials.WOOD, 0, -3.0f, new CustomItemSettings());

	public static final CustomMusicDiscItem PARALLELIFY = new CustomMusicDiscItem(new CustomItemSettings().maxCount(1),
		new SoundEvent(Archeon.createId("parallelify")), 0, 101);

	public static final CustomMusicDiscItem PE_4K = new CustomMusicDiscItem(new CustomItemSettings().maxCount(1),
		new SoundEvent(Archeon.createId("pe_4k")), 0, 116);

	@Override
	public void register() {
		APAFLORITE_GEMSTONE.register(Archeon.createId("apaflorite_gemstone"));
		APAFLORITE_HELMET.register(Archeon.createId("apaflorite_helmet"));
		APAFLORITE_CHESTPLATE.register(Archeon.createId("apaflorite_chestplate"));
		APAFLORITE_LEGGINGS.register(Archeon.createId("apaflorite_apaflorite_leggings"));
		APAFLORITE_BOOTS.register(Archeon.createId("apaflorite_boots"));
		APAFLORITE_SABER.register(Archeon.createId("apaflorite_saber"));
		APAFLORITE_PICKAXE.register(Archeon.createId("apaflorite_pickaxe"));
		APAFLORITE_AXE.register(Archeon.createId("apaflorite_axe"));
		APAFLORITE_SHOVEL.register(Archeon.createId("apaflorite_shovel"));
		APAFLORITE_HOE.register(Archeon.createId("apaflorite_hoe"));
		ARCHEON_CHRISTMAS.register(Archeon.createId("archeon_christmas"));
		BLOOD_ORANGE.register(Archeon.createId("blood_orange"));
		BLUE_SHELL.register(Archeon.createId("blue_shell"));
		CLOTHES_CHESTPLATE.register(Archeon.createId("clothes_chestplate"));
		CLOTHES_LEGGINGS.register(Archeon.createId("clothes_leggings"));
		COOKED_HEIFER.register(Archeon.createId("cooked_heifer"));
		COOKED_SUNSTRADIVER_CHOP.register(Archeon.createId("cooked_sunstradiver_chop"));
		CYPRESS_SWORD.register(Archeon.createId("cypress_sword"));
		CYPRESS_PICKAXE.register(Archeon.createId("cypress_pickaxe"));
		CYPRESS_AXE.register(Archeon.createId("cypress_axe"));
		CYPRESS_SHOVEL.register(Archeon.createId("cypress_shovel"));
		CYPRESS_HOE.register(Archeon.createId("cypress_hoe"));
		DEVOURING.register(Archeon.createId("devouring"));
		EXYRIANE_CRYSTAL.register(Archeon.createId("exyriane_crystal"));
		EXYRIANE_FISHING_ROD.register(Archeon.createId("exyriane_fishing_rod"));
		FAELITE_INGOT.register(Archeon.createId("faelite_ingot"));
		FAELITE_HELMET.register(Archeon.createId("faelite_helmet"));
		FAELITE_CHESTPLATE.register(Archeon.createId("faelite_chestplate"));
		FAELITE_LEGGINGS.register(Archeon.createId("faelite_leggings"));
		FAELITE_BOOTS.register(Archeon.createId("faelite_boots"));
		FAELITE_SWORD.register(Archeon.createId("faelite_sword"));
		FAELITE_PICKAXE.register(Archeon.createId("faelite_pickaxe"));
		FAELITE_AXE.register(Archeon.createId("faelite_axe"));
		FAELITE_SHOVEL.register(Archeon.createId("faelite_shovel"));
		FAELITE_HOE.register(Archeon.createId("faelite_hoe"));
		GEAR.register(Archeon.createId("gear"));
		GEOMETRIC_FALL.register(Archeon.createId("geometric_fall"));
		GOBLET.register(Archeon.createId("goblet"));
		GOBLET_WATER.register(Archeon.createId("goblet_water"));
		GOBLET_BLOOD_ORANGE_JUICE.register(Archeon.createId("goblet_blood_orange_juice"));
		GOBLET_COCONUT_MILK.register(Archeon.createId("goblet_coconut_milk"));
		GRAPE.register(Archeon.createId("grape"));
		GOLDEN_GRAPE.register(Archeon.createId("golden_grape"));
		HERBICIDE.register(Archeon.createId("herbicide"));
		INK_BOTTLE.register(Archeon.createId("ink_bottle"));
		JAM_POT.register(Archeon.createId("jam_pot"));
		ORANGE_LYCORIS_JAM_POT.register(Archeon.createId("orange_lycoris_jam_pot"));
		ORANGE_LYCORIS_PETAL.register(Archeon.createId("orange_lycoris_petal"));
		MANUSCRIPT.register(Archeon.createId("manuscript"));
		MASSACRE_DAGGER.register(Archeon.createId("massacre_dagger"));
		MOSS_BALL.register(Archeon.createId("moss_ball"));
		NECLANE_SWORD.register(Archeon.createId("neclane_sword"));
		NECLANE_PICKAXE.register(Archeon.createId("neclane_pickaxe"));
		NECLANE_AXE.register(Archeon.createId("neclane_axe"));
		NECLANE_SHOVEL.register(Archeon.createId("neclane_shovel"));
		NECLANE_HOE.register(Archeon.createId("neclane_hoe"));
		PARALLELIFY.register(Archeon.createId("parallelify"));
		PE_4K.register(Archeon.createId("pe_4k"));
	}
}
