package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.buckets.CeramicBucketManager;
import com.mmodding.archeon.buckets.WoodenBucketManager;
import com.mmodding.archeon.entities.CentaurSpearEntity;
import com.mmodding.archeon.entities.HeartOfNatureEntity;
import com.mmodding.archeon.items.*;
import com.mmodding.archeon.materials.armor.ApafloriteArmor;
import com.mmodding.archeon.materials.armor.ClothesTunic;
import com.mmodding.archeon.materials.armor.FaeliteArmor;
import com.mmodding.archeon.materials.armor.LusonythArmor;
import com.mmodding.archeon.materials.tool.*;
import com.mmodding.mmodding_lib.library.fluids.buckets.CustomBucketItem;
import com.mmodding.mmodding_lib.library.fluids.buckets.CustomMilkBucketItem;
import com.mmodding.mmodding_lib.library.glint.DefaultGlintPacks;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.items.*;
import com.mmodding.mmodding_lib.library.items.settings.AdvancedItemSettings;
import com.mmodding.mmodding_lib.library.items.settings.ItemFinishUsing;
import com.mmodding.mmodding_lib.library.portals.CustomPortalKeyItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.explosion.Explosion;

public class ArcheonItems implements ElementsInitializer {

	public static final CustomPortalKeyItem WAND_OF_NATURE = new CustomPortalKeyItem(new AdvancedItemSettings(), SoundEvents.ITEM_FLINTANDSTEEL_USE);

	public static final CustomPickaxeItem QOLM_PICK = new CustomPickaxeItem(QolmTool.INSTANCE, 1, -2.5f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.GREEN).fireproof());

	public static final CustomSwordItem MASSACRE_DAGGER = new CustomSwordItem(MassacreDaggerTool.INSTANCE, 3, -0.5f,
		new AdvancedItemSettings().glintPack(DefaultGlintPacks.RED).fireproof().itemPostHit((stack, target, attacker) -> {
			World world = target.getWorld();
			world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60));
			world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
		})
	);

	public static final CustomItem POWER_KEY = new CustomItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE).itemUseOnBlock(context -> {
		BlockState state = context.getWorld().getBlockState(context.getBlockPos());
		if (state.isOf(ArcheonBlocks.POWER_KEYSTONE) && context.getPlayer() != null) {
			HeartOfNatureEntity heartOfNatureEntity = new HeartOfNatureEntity(ArcheonEntities.HEART_OF_NATURE, context.getWorld());
			Vec3d originalPos = new Vec3d(context.getBlockPos().getX() + 0.5f, context.getBlockPos().getY() + 2.5f, context.getBlockPos().getZ() + 0.5f);
			heartOfNatureEntity.setPosition(originalPos);
			heartOfNatureEntity.onSummonedByPowerKey(originalPos);
			context.getWorld().spawnEntity(heartOfNatureEntity);
			if(!context.getPlayer().isCreative()) context.getPlayer().getInventory().removeOne(context.getPlayer().getStackInHand(context.getHand()));
		}
	}));

	public static final CustomSpearItem CENTAUR_SPEAR = new CustomSpearItem(CentaurSpearEntity::new, new AdvancedItemSettings().maxCount(1).maxDamage(250).rarity(Rarity.EPIC).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final CustomAxeItem CENTAUR_BATTLE_AXE = new CustomAxeItem(CentaurTool.INSTANCE, 6, -2.5f, new AdvancedItemSettings().maxCount(1).rarity(Rarity.EPIC).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));

	public static final CustomSwordItem NECLANE_SWORD = new CustomSwordItem(ToolMaterials.WOOD, 3, -2.4f, new AdvancedItemSettings());
	public static final CustomPickaxeItem NECLANE_PICKAXE = new CustomPickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new AdvancedItemSettings());
	public static final CustomAxeItem NECLANE_AXE = new CustomAxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new AdvancedItemSettings());
	public static final CustomShovelItem NECLANE_SHOVEL = new CustomShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new AdvancedItemSettings());
	public static final CustomHoeItem NECLANE_HOE = new CustomHoeItem(ToolMaterials.WOOD, 0, -3.0f, new AdvancedItemSettings());

	public static final CustomSwordItem CYPRESS_SWORD = new CustomSwordItem(ToolMaterials.WOOD, 3, -2.4f, new AdvancedItemSettings());
	public static final CustomPickaxeItem CYPRESS_PICKAXE = new CustomPickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new AdvancedItemSettings());
	public static final CustomAxeItem CYPRESS_AXE = new CustomAxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new AdvancedItemSettings());
	public static final CustomShovelItem CYPRESS_SHOVEL = new CustomShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new AdvancedItemSettings());
	public static final CustomHoeItem CYPRESS_HOE = new CustomHoeItem(ToolMaterials.WOOD, 0, -3.0f, new AdvancedItemSettings());

	public static final CustomSwordItem VUXANCIA_SWORD = new CustomSwordItem(ToolMaterials.WOOD, 3, -2.4f, new AdvancedItemSettings());
	public static final CustomPickaxeItem VUXANCIA_PICKAXE = new CustomPickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new AdvancedItemSettings());
	public static final CustomAxeItem VUXANCIA_AXE = new CustomAxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new AdvancedItemSettings());
	public static final CustomShovelItem VUXANCIA_SHOVEL = new CustomShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new AdvancedItemSettings());
	public static final CustomHoeItem VUXANCIA_HOE = new CustomHoeItem(ToolMaterials.WOOD, 0, -3.0f, new AdvancedItemSettings());

	public static final CustomSwordItem SOUTHSTONE_SWORD = new CustomSwordItem(ToolMaterials.STONE, 3, -2.4f, new AdvancedItemSettings());
	public static final CustomPickaxeItem SOUTHSTONE_PICKAXE = new CustomPickaxeItem(ToolMaterials.STONE, 1, -2.8f, new AdvancedItemSettings());
	public static final CustomAxeItem SOUTHSTONE_AXE = new CustomAxeItem(ToolMaterials.STONE, 7.0f, -3.2f, new AdvancedItemSettings());
	public static final CustomShovelItem SOUTHSTONE_SHOVEL = new CustomShovelItem(ToolMaterials.STONE, 1.5f, -3.0f, new AdvancedItemSettings());
	public static final CustomHoeItem SOUTHSTONE_HOE = new CustomHoeItem(ToolMaterials.STONE, -1, -2.0f, new AdvancedItemSettings());

	public static final CustomSwordItem APAFLORITE_SABER = new CustomSwordItem(ApafloriteTool.INSTANCE, 5, -0.8f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomPickaxeItem APAFLORITE_PICKAXE = new CustomPickaxeItem(ApafloriteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomAxeItem APAFLORITE_AXE = new CustomAxeItem(ApafloriteTool.INSTANCE, 6, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomShovelItem APAFLORITE_SHOVEL = new CustomShovelItem(ApafloriteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomHoeItem APAFLORITE_HOE = new CustomHoeItem(ApafloriteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));

	public static final CustomArmorItem APAFLORITE_HELMET = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.HEAD, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomArmorItem APAFLORITE_CHESTPLATE = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.CHEST, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomArmorItem APAFLORITE_LEGGINGS = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.LEGS, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));
	public static final CustomArmorItem APAFLORITE_BOOTS = new CustomArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.FEET, new AdvancedItemSettings().glintPack(DefaultGlintPacks.PINK));

	public static final CustomSwordItem FAELITE_SWORD = new CustomSwordItem(FaeliteTool.INSTANCE, 7, -2.4f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomPickaxeItem FAELITE_PICKAXE = new CustomPickaxeItem(FaeliteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomAxeItem FAELITE_AXE = new CustomAxeItem(FaeliteTool.INSTANCE, 8, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomShovelItem FAELITE_SHOVEL = new CustomShovelItem(FaeliteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomHoeItem FAELITE_HOE = new CustomHoeItem(FaeliteTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));

	public static final CustomArmorItem FAELITE_HELMET = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.HEAD, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomArmorItem FAELITE_CHESTPLATE = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.CHEST, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomArmorItem FAELITE_LEGGINGS = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.LEGS, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));
	public static final CustomArmorItem FAELITE_BOOTS = new CustomArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.FEET, new AdvancedItemSettings().glintPack(DefaultGlintPacks.ORANGE));

	public static final CustomSwordItem LUSONYTH_SWORD = new CustomSwordItem(LusonythTool.INSTANCE, 7, -2.4f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomPickaxeItem LUSONYTH_PICKAXE = new CustomPickaxeItem(LusonythTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomAxeItem LUSONYTH_AXE = new CustomAxeItem(LusonythTool.INSTANCE, 8, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomShovelItem LUSONYTH_SHOVEL = new CustomShovelItem(LusonythTool.INSTANCE, 1,-3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomHoeItem LUSONYTH_HOE = new CustomHoeItem(LusonythTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));

	public static final CustomArmorItem LUSONYTH_HELMET = new CustomArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.HEAD, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomArmorItem LUSONYTH_CHESTPLATE = new CustomArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.CHEST, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomArmorItem LUSONYTH_LEGGINGS = new CustomArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.LEGS, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));
	public static final CustomArmorItem LUSONYTH_BOOTS = new CustomArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.FEET, new AdvancedItemSettings().glintPack(DefaultGlintPacks.BLUE));

	public static final CustomSwordItem CLEMENTIUM_SWORD = new CustomSwordItem(ClementiumTool.INSTANCE, 7, -2.4f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final CustomPickaxeItem CLEMENTIUM_PICKAXE = new CustomPickaxeItem(ClementiumTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final CustomAxeItem CLEMENTIUM_AXE = new CustomAxeItem(ClementiumTool.INSTANCE, 8, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final CustomShovelItem CLEMENTIUM_SHOVEL = new CustomShovelItem(ClementiumTool.INSTANCE, 1,-3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final CustomHoeItem CLEMENTIUM_HOE = new CustomHoeItem(ClementiumTool.INSTANCE, 1, -3.1f, new AdvancedItemSettings().glintPack(DefaultGlintPacks.LIGHTENED_BROWN));

	public static final FaeliteBowItem FAELITE_BOW = new FaeliteBowItem(new AdvancedItemSettings().maxCount(1).maxDamage(500));
	public static final CustomArrowItem LUSONYTH_ARROW = new LusonythArrowItem(new AdvancedItemSettings());

	public static final CustomFishingRodItem EXYRIANE_FISHING_ROD = new CustomFishingRodItem(new AdvancedItemSettings());

	public static final CustomArmorItem CLOTHES_CHESTPLATE = new CustomArmorItem(ClothesTunic.INSTANCE, EquipmentSlot.CHEST, new AdvancedItemSettings());
	public static final CustomArmorItem CLOTHES_LEGGINGS = new CustomArmorItem(ClothesTunic.INSTANCE, EquipmentSlot.LEGS, new AdvancedItemSettings());

	public static final RingItem APAFLORITE_RING = new RingItem(RingItem::apafloriteRingModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final RingItem FAELITE_RING = new RingItem(RingItem::faeliteRingModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final RingItem LUSONYTH_RING = new RingItem(RingItem::lusonythRingModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final RingItem CLEMENTIUM_RING = new RingItem(RingItem::clementiumRingModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final RingItem RING_OF_EDEN = new RingItem(RingItem::ringOfEdenModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE));
	public static final RingItem RING_OF_WAHVEN = new RingItem(RingItem::ringOfWahvenModifiers, new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE));

	public static final CustomEnchantedBookItem MASSACRE_BOOK = new CustomEnchantedBookItem(ArcheonEnchantments.MASSACRE, new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE).nameFormattings(Formatting.RED).glintPack(DefaultGlintPacks.LIGHTENED_RED));
	public static final CustomEnchantedBookItem QOLM_BOOK = new CustomEnchantedBookItem(ArcheonEnchantments.QOLM, new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE).nameFormattings(Formatting.GREEN).glintPack(DefaultGlintPacks.LIGHTENED_GREEN));

	public static final AmuletOfNatureItem AMULET_OF_NATURE = new AmuletOfNatureItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.EPIC));

	public static final CustomItem MANUSCRIPT = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem APAFLORITE_GEMSTONE = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem EXYRIANE_SHARD = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem RAW_FAELITE = new CustomItem(new AdvancedItemSettings());
	public static final CustomItem FAELITE_INGOT = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem RAW_LUSONYTH = new CustomItem(new AdvancedItemSettings());
	public static final CustomItem LUSONYTH_INGOT = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem PLANT_FIBER = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem MOSS_BALL = new CustomItem(new AdvancedItemSettings().food(1, 0.5f));

	public static final CustomItem BLUE_SHELL = new CustomItem(new AdvancedItemSettings());
	public static final CustomItem PINK_SHELL = new CustomItem(new AdvancedItemSettings());
	public static final CustomItem YELLOW_SHELL = new CustomItem(new AdvancedItemSettings());

	public static final CustomBucketItem WOODEN_BUCKET = new CustomBucketItem(
		Fluids.EMPTY, WoodenBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(16)
	);

	public static final CustomBucketItem WOODEN_WATER_BUCKET = new CustomBucketItem(
		Fluids.WATER, WoodenBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomMilkBucketItem WOODEN_MILK_BUCKET = new CustomMilkBucketItem(
		WoodenBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem WOODEN_HOT_SPRING_WATER_BUCKET = new CustomBucketItem(
		ArcheonFluids.HOT_SPRING_WATER.getStill(), WoodenBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem WOODEN_DASCIUM_BUCKET = new CustomBucketItem(
		ArcheonFluids.DASCIUM.getStill(), WoodenBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem CERAMIC_BUCKET = new CustomBucketItem(
		Fluids.EMPTY, CeramicBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(16)
	);

	public static final CustomBucketItem CERAMIC_WATER_BUCKET = new CustomBucketItem(
		Fluids.WATER, CeramicBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem CERAMIC_LAVA_BUCKET = new CustomBucketItem(
		Fluids.LAVA, CeramicBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem CERAMIC_HOT_SPRING_WATER_BUCKET = new CustomBucketItem(
		ArcheonFluids.HOT_SPRING_WATER.getStill(), CeramicBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomBucketItem CERAMIC_DASCIUM_BUCKET = new CustomBucketItem(
		ArcheonFluids.DASCIUM.getStill(), CeramicBucketManager.INSTANCE, new AdvancedItemSettings().maxCount(1)
	);

	public static final CustomItem GOBLET = new CustomItem(new AdvancedItemSettings());

	public static final ItemFinishUsing GOBLET_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.GOBLET) : stack);

	public static final CustomItem GOBLET_WATER = new CustomItem(new AdvancedItemSettings().maxCount(1)
		.food(0, 0.0f, false, true).drinkable().itemFinishUsing(GOBLET_USE));

	public static final CustomItem GOBLET_COCONUT_MILK = new CustomItem(new AdvancedItemSettings().maxCount(1)
		.food(0, 0.0f, false, true).drinkable().itemFinishUsing((stack, world, user) -> {
			if (!world.isClient()) {
				user.clearStatusEffects();
			}
			return GOBLET_USE.apply(stack, world, user);
		}));

	public static final CustomItem GOBLET_BLOOD_ORANGE_JUICE = new CustomItem(new AdvancedItemSettings().maxCount(1)
		.food(4, 0.5f).drinkable().itemFinishUsing(GOBLET_USE));

	public static final CustomItem JAM_POT = new CustomItem(new AdvancedItemSettings());

	public static final ItemFinishUsing JAM_POT_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.JAM_POT) : stack);

	public static final CustomItem ORANGE_LYCORIS_JAM_POT = new CustomItem(new AdvancedItemSettings().maxCount(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000), 1.0f)
			.build()
	).drinkable().itemFinishUsing(JAM_POT_USE));

	public static final CustomItem RED_LYCORIS_JAM_POT = new CustomItem(new AdvancedItemSettings().maxCount(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1000, 1), 1.0f)
			.build()
	).drinkable().itemFinishUsing(JAM_POT_USE));

	public static final CustomItem PINK_LYCORIS_JAM_POT = new CustomItem(new AdvancedItemSettings().maxCount(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 1), 1.0f)
			.build()
	).drinkable().itemFinishUsing(JAM_POT_USE));

	public static final CustomItem RED_LYCORIS_PETAL = new CustomItem(new AdvancedItemSettings().food(3, 0.2f));

	public static final CustomItem PINK_LYCORIS_PETAL = new CustomItem(new AdvancedItemSettings().food(3, 0.2f));

	public static final CustomItem ORANGE_LYCORIS_PETAL = new CustomItem(new AdvancedItemSettings().food(3, 0.2f));

	public static final LoreScrapItem LORE_SCRAP = new LoreScrapItem(new AdvancedItemSettings());

	public static final CustomMusicDiscItem PE_4K = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("pe_4k")), 0, 116);

	public static final CustomMusicDiscItem GEOMETRIC_FALL = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("geometric_fall")), 0, 74);

	public static final CustomMusicDiscItem RISING = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("rising")), 0, 90);

	public static final CustomMusicDiscItem PARALLELIFY = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("parallelify")), 0, 101);

	public static final CustomMusicDiscItem RESIDE = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("reside")), 0, 165);

	public static final CustomMusicDiscItem ARCHEON_CHRISTMAS = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("archeon_christmas")), 0, 165);

	public static final CustomMusicDiscItem DEVOURING = new CustomMusicDiscItem(new AdvancedItemSettings().maxCount(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("glaive")), 0, 176);

	public static final CustomItem RECORD_FRAGMENT = new CustomItem(new AdvancedItemSettings().maxCount(16));

	public static final CustomItem SALT = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem RAW_HEIFER = new CustomItem(new AdvancedItemSettings().food(2, 0.3f, true));
	public static final CustomItem COOKED_HEIFER = new CustomItem(new AdvancedItemSettings().food(4, 1.5f, true));

	public static final CustomItem RAW_SUNSTRADIVER_CHOP = new CustomItem(new AdvancedItemSettings().food(2, 0.3f, true));
	public static final CustomItem COOKED_SUNSTRADIVER_CHOP = new CustomItem(new AdvancedItemSettings().food(7, 1.0f, true));

	public static final CustomItem RAW_DEER = new CustomItem(new AdvancedItemSettings().food(3, 0.3f, true));
	public static final CustomItem COOKED_DEER = new CustomItem(new AdvancedItemSettings().food(9, 1.0f, true));

	public static final CustomItem LYCORIS_JAM_PIE = new CustomItem(new AdvancedItemSettings().maxCount(1).food(20, 20.0f));

	public static final CustomItem BLOOD_ORANGE = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem GRAPE = new CustomItem(new AdvancedItemSettings().food(1, 0.3f));

	public static final CustomItem GOLDEN_GRAPE = new CustomItem(new AdvancedItemSettings().food(
		new FoodComponent.Builder()
			.hunger(5)
			.saturationModifier(2.5f)
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 160, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 0, 3), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160, 1), 1.0f)
			.build()
	));

	public static final CustomItem GROWING_NEAVE_BERRIES = new CustomItem(new AdvancedItemSettings().food(1, 0.3f));

	public static final CustomItem NEAVE_BERRIES = new CustomItem(new AdvancedItemSettings().food(3, 0.6f));

	public static final CustomItem GEAR = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem HERBICIDE = new CustomItem(new AdvancedItemSettings().maxCount(1).eatable()
		.descriptionLines(Text.of("§7Don't use this.")).itemDropped((stack, world, user, droppedItem) -> world.createExplosion(
			droppedItem,
			droppedItem.getX(),
			droppedItem.getY(),
			droppedItem.getZ(),
			3,
			Explosion.DestructionType.NONE
		))
	);

	public static final CustomItem INK_BOTTLE = new CustomItem(new AdvancedItemSettings().maxCount(16));

	public static final PouchItem POUCH = new PouchItem(new AdvancedItemSettings().maxCount(1));

	public static final CustomItem SUNSTRADIVER_FEATHER = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem SNAIL_SHELL = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem AURORA_CRYSTAL = new CustomItem(new AdvancedItemSettings());

	public static final CustomItem IMPRESSIVE_AURORA_CRYSTAL = new CustomItem(new AdvancedItemSettings().nameFormattings(Formatting.GOLD));

	public static final CustomSpawnEggItem AURORA_CATALYST_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.AURORA_CATALYST, 4380648, 3876673, new AdvancedItemSettings());
	public static final CustomSpawnEggItem POISONOUS_AURORA_CATALYST_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.POISONOUS_AURORA_CATALYST, 517623, 6633076, new AdvancedItemSettings());
	public static final CustomSpawnEggItem EXPLOSIVE_AURORA_CATALYST_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.EXPLOSIVE_AURORA_CATALYST, 12279738, 6967084, new AdvancedItemSettings());
	public static final CustomSpawnEggItem SNAIL_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.SNAIL, 9198398, 14794633, new AdvancedItemSettings());
	public static final CustomSpawnEggItem SUNSTRADIVER_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.SUNSTRADIVER, 16724787, 16764006, new AdvancedItemSettings());
	public static final CustomSpawnEggItem HEIFER_SPAWN_EGG = new CustomSpawnEggItem(ArcheonEntities.HEIFER, 2298374, 3680013, new AdvancedItemSettings());

	@Override
	public void register() {
		WAND_OF_NATURE.register(Archeon.createId("wand_of_nature"));
		QOLM_PICK.register(Archeon.createId("qolm_pick"));
		MASSACRE_DAGGER.register(Archeon.createId("massacre_dagger"));
		POWER_KEY.register(Archeon.createId("power_key"));
		CENTAUR_SPEAR.register(Archeon.createId("centaur_spear"));
		CENTAUR_BATTLE_AXE.register(Archeon.createId("centaur_battle_axe"));
		NECLANE_SWORD.register(Archeon.createId("neclane_sword"));
		NECLANE_PICKAXE.register(Archeon.createId("neclane_pickaxe"));
		NECLANE_AXE.register(Archeon.createId("neclane_axe"));
		NECLANE_SHOVEL.register(Archeon.createId("neclane_shovel"));
		NECLANE_HOE.register(Archeon.createId("neclane_hoe"));
		CYPRESS_SWORD.register(Archeon.createId("cypress_sword"));
		CYPRESS_PICKAXE.register(Archeon.createId("cypress_pickaxe"));
		CYPRESS_AXE.register(Archeon.createId("cypress_axe"));
		CYPRESS_SHOVEL.register(Archeon.createId("cypress_shovel"));
		CYPRESS_HOE.register(Archeon.createId("cypress_hoe"));
		VUXANCIA_SWORD.register(Archeon.createId("vuxancia_sword"));
		VUXANCIA_PICKAXE.register(Archeon.createId("vuxancia_pickaxe"));
		VUXANCIA_AXE.register(Archeon.createId("vuxancia_axe"));
		VUXANCIA_SHOVEL.register(Archeon.createId("vuxancia_shovel"));
		VUXANCIA_HOE.register(Archeon.createId("vuxancia_hoe"));
		SOUTHSTONE_SWORD.register(Archeon.createId("southstone_sword"));
		SOUTHSTONE_PICKAXE.register(Archeon.createId("southstone_pickaxe"));
		SOUTHSTONE_AXE.register(Archeon.createId("southstone_axe"));
		SOUTHSTONE_SHOVEL.register(Archeon.createId("southstone_shovel"));
		SOUTHSTONE_HOE.register(Archeon.createId("southstone_hoe"));
		APAFLORITE_SABER.register(Archeon.createId("apaflorite_saber"));
		APAFLORITE_PICKAXE.register(Archeon.createId("apaflorite_pickaxe"));
		APAFLORITE_AXE.register(Archeon.createId("apaflorite_axe"));
		APAFLORITE_SHOVEL.register(Archeon.createId("apaflorite_shovel"));
		APAFLORITE_HOE.register(Archeon.createId("apaflorite_hoe"));
		APAFLORITE_HELMET.register(Archeon.createId("apaflorite_helmet"));
		APAFLORITE_CHESTPLATE.register(Archeon.createId("apaflorite_chestplate"));
		APAFLORITE_LEGGINGS.register(Archeon.createId("apaflorite_leggings"));
		APAFLORITE_BOOTS.register(Archeon.createId("apaflorite_boots"));
		FAELITE_SWORD.register(Archeon.createId("faelite_sword"));
		FAELITE_PICKAXE.register(Archeon.createId("faelite_pickaxe"));
		FAELITE_AXE.register(Archeon.createId("faelite_axe"));
		FAELITE_SHOVEL.register(Archeon.createId("faelite_shovel"));
		FAELITE_HOE.register(Archeon.createId("faelite_hoe"));
		FAELITE_HELMET.register(Archeon.createId("faelite_helmet"));
		FAELITE_CHESTPLATE.register(Archeon.createId("faelite_chestplate"));
		FAELITE_LEGGINGS.register(Archeon.createId("faelite_leggings"));
		FAELITE_BOOTS.register(Archeon.createId("faelite_boots"));
		LUSONYTH_SWORD.register(Archeon.createId("lusonyth_sword"));
		LUSONYTH_PICKAXE.register(Archeon.createId("lusonyth_pickaxe"));
		LUSONYTH_AXE.register(Archeon.createId("lusonyth_axe"));
		LUSONYTH_SHOVEL.register(Archeon.createId("lusonyth_shovel"));
		LUSONYTH_HOE.register(Archeon.createId("lusonyth_hoe"));
		LUSONYTH_HELMET.register(Archeon.createId("lusonyth_helmet"));
		LUSONYTH_CHESTPLATE.register(Archeon.createId("lusonyth_chestplate"));
		LUSONYTH_LEGGINGS.register(Archeon.createId("lusonyth_leggings"));
		LUSONYTH_BOOTS.register(Archeon.createId("lusonyth_boots"));
		CLEMENTIUM_SWORD.register(Archeon.createId("clementium_sword"));
		CLEMENTIUM_PICKAXE.register(Archeon.createId("clementium_pickaxe"));
		CLEMENTIUM_AXE.register(Archeon.createId("clementium_axe"));
		CLEMENTIUM_SHOVEL.register(Archeon.createId("clementium_shovel"));
		CLEMENTIUM_HOE.register(Archeon.createId("clementium_hoe"));
		FAELITE_BOW.register(Archeon.createId("faelite_bow"));
		LUSONYTH_ARROW.register(Archeon.createId("lusonyth_arrow"));
		EXYRIANE_FISHING_ROD.register(Archeon.createId("exyriane_fishing_rod"));
		CLOTHES_CHESTPLATE.register(Archeon.createId("clothes_chestplate"));
		CLOTHES_LEGGINGS.register(Archeon.createId("clothes_leggings"));
		APAFLORITE_RING.register(Archeon.createId("apaflorite_ring"));
		FAELITE_RING.register(Archeon.createId("faelite_ring"));
		LUSONYTH_RING.register(Archeon.createId("lusonyth_ring"));
		CLEMENTIUM_RING.register(Archeon.createId("clementium_ring"));
		RING_OF_EDEN.register(Archeon.createId("ring_of_eden"));
		RING_OF_WAHVEN.register(Archeon.createId("ring_of_wahven"));
		MASSACRE_BOOK.register(Archeon.createId("massacre_book"));
		QOLM_BOOK.register(Archeon.createId("qolm_book"));
		AMULET_OF_NATURE.register(Archeon.createId("amulet_of_nature"));
		MANUSCRIPT.register(Archeon.createId("manuscript"));
		APAFLORITE_GEMSTONE.register(Archeon.createId("apaflorite_gemstone"));
		EXYRIANE_SHARD.register(Archeon.createId("exyriane_shard"));
		RAW_FAELITE.register(Archeon.createId("raw_faelite"));
		FAELITE_INGOT.register(Archeon.createId("faelite_ingot"));
		RAW_LUSONYTH.register(Archeon.createId("raw_lusonyth"));
		LUSONYTH_INGOT.register(Archeon.createId("lusonyth_ingot"));
		PLANT_FIBER.register(Archeon.createId("plant_fiber"));
		MOSS_BALL.register(Archeon.createId("moss_ball"));
		BLUE_SHELL.register(Archeon.createId("blue_shell"));
		PINK_SHELL.register(Archeon.createId("pink_shell"));
		YELLOW_SHELL.register(Archeon.createId("yellow_shell"));
		WOODEN_BUCKET.register(Archeon.createId("wooden_bucket"));
		WOODEN_WATER_BUCKET.register(Archeon.createId("wooden_water_bucket"));
		WOODEN_MILK_BUCKET.register(Archeon.createId("wooden_milk_bucket"));
		WOODEN_HOT_SPRING_WATER_BUCKET.register(Archeon.createId("wooden_hot_spring_water_bucket"));
		WOODEN_DASCIUM_BUCKET.register(Archeon.createId("wooden_dascium_bucket"));
		CERAMIC_BUCKET.register(Archeon.createId("ceramic_bucket"));
		CERAMIC_WATER_BUCKET.register(Archeon.createId("ceramic_water_bucket"));
		CERAMIC_LAVA_BUCKET.register(Archeon.createId("ceramic_lava_bucket"));
		CERAMIC_HOT_SPRING_WATER_BUCKET.register(Archeon.createId("ceramic_hot_spring_water_bucket"));
		CERAMIC_DASCIUM_BUCKET.register(Archeon.createId("ceramic_dascium_bucket"));
		GOBLET.register(Archeon.createId("goblet"));
		GOBLET_WATER.register(Archeon.createId("goblet_water"));
		GOBLET_COCONUT_MILK.register(Archeon.createId("goblet_coconut_milk"));
		GOBLET_BLOOD_ORANGE_JUICE.register(Archeon.createId("goblet_blood_orange_juice"));
		JAM_POT.register(Archeon.createId("jam_pot"));
		ORANGE_LYCORIS_JAM_POT.register(Archeon.createId("orange_lycoris_jam_pot"));
		RED_LYCORIS_JAM_POT.register(Archeon.createId("red_lycoris_jam_pot"));
		PINK_LYCORIS_JAM_POT.register(Archeon.createId("pink_lycoris_jam_pot"));
		ORANGE_LYCORIS_PETAL.register(Archeon.createId("orange_lycoris_petal"));
		RED_LYCORIS_PETAL.register(Archeon.createId("red_lycoris_petal"));
		PINK_LYCORIS_PETAL.register(Archeon.createId("pink_lycoris_petal"));
		LORE_SCRAP.register(Archeon.createId("lore_scrap"));
		PE_4K.register(Archeon.createId("pe_4k"));
		GEOMETRIC_FALL.register(Archeon.createId("geometric_fall"));
		RISING.register(Archeon.createId("rising"));
		PARALLELIFY.register(Archeon.createId("parallelify"));
		RESIDE.register(Archeon.createId("reside"));
		ARCHEON_CHRISTMAS.register(Archeon.createId("archeon_christmas"));
		DEVOURING.register(Archeon.createId("devouring"));
		RECORD_FRAGMENT.register(Archeon.createId("record_fragment"));
		SALT.register(Archeon.createId("salt"));
		RAW_HEIFER.register(Archeon.createId("raw_heifer"));
		COOKED_HEIFER.register(Archeon.createId("cooked_heifer"));
		RAW_SUNSTRADIVER_CHOP.register(Archeon.createId("raw_sunstradiver_chop"));
		COOKED_SUNSTRADIVER_CHOP.register(Archeon.createId("cooked_sunstradiver_chop"));
		RAW_DEER.register(Archeon.createId("raw_deer"));
		COOKED_DEER.register(Archeon.createId("cooked_deer"));
		LYCORIS_JAM_PIE.register(Archeon.createId("lycoris_jam_pie"));
		BLOOD_ORANGE.register(Archeon.createId("blood_orange"));
		GRAPE.register(Archeon.createId("grape"));
		GOLDEN_GRAPE.register(Archeon.createId("golden_grape"));
		GROWING_NEAVE_BERRIES.register(Archeon.createId("growing_neave_berries"));
		NEAVE_BERRIES.register(Archeon.createId("neave_berries"));
		GEAR.register(Archeon.createId("gear"));
		HERBICIDE.register(Archeon.createId("herbicide"));
		INK_BOTTLE.register(Archeon.createId("ink_bottle"));
		POUCH.register(Archeon.createId("pouch"));
		SUNSTRADIVER_FEATHER.register(Archeon.createId("sunstradiver_feather"));
		SNAIL_SHELL.register(Archeon.createId("snail_shell"));
		AURORA_CRYSTAL.register(Archeon.createId("aurora_crystal"));
		IMPRESSIVE_AURORA_CRYSTAL.register(Archeon.createId("impressive_aurora_crystal"));
		AURORA_CATALYST_SPAWN_EGG.register(Archeon.createId("aurora_catalyst_spawn_egg"));
		POISONOUS_AURORA_CATALYST_SPAWN_EGG.register(Archeon.createId("poisonous_aurora_catalyst_spawn_egg"));
		EXPLOSIVE_AURORA_CATALYST_SPAWN_EGG.register(Archeon.createId("explosive_aurora_catalyst_spawn_egg"));
		SNAIL_SPAWN_EGG.register(Archeon.createId("snail_spawn_egg"));
		SUNSTRADIVER_SPAWN_EGG.register(Archeon.createId("sunstradiver_spawn_egg"));
		HEIFER_SPAWN_EGG.register(Archeon.createId("heifer_spawn_egg"));
	}
}
