package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.block.entity.ArcheonBlockEntities;
import com.mmodding.archeon.bucket.CeramicBucketManager;
import com.mmodding.archeon.bucket.WoodenBucketManager;
import com.mmodding.archeon.entity.CentaurSpearEntity;
import com.mmodding.archeon.entity.HeartOfNatureEntity;
import com.mmodding.archeon.item.*;
import com.mmodding.archeon.material.armor.ApafloriteArmor;
import com.mmodding.archeon.material.armor.FaeliteArmor;
import com.mmodding.archeon.material.armor.LusonythArmor;
import com.mmodding.archeon.material.tool.*;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.item.api.catalog.FluidInteractableItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Function;
import java.util.function.Predicate;

public class ArcheonItems {

	public static final PortalKeyItem WAND_OF_NATURE = new PortalKeyItem(new Item.Properties().maxDamage(1), SoundEvents.ITEM_FLINTANDSTEEL_USE);

	public static final PickaxeItem QOLM_PICK = new PickaxeItem(QolmTool.INSTANCE, 1, -2.5f, new Item.Properties().glintPack(DefaultGlintPacks.GREEN).fireproof());

	public static final SwordItem MASSACRE_DAGGER = new SwordItem(MassacreDaggerTool.INSTANCE, 3, -0.5f,
		new Item.Properties().glintPack(DefaultGlintPacks.RED).fireproof().itemPostHit((stack, target, attacker) -> {
			World world = target.getWorld();
			world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60));
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60));
			world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, target.getBlockPos(), Block.getRawIdFromState(Blocks.FIRE_CORAL_BLOCK.getDefaultState()));
		})
	);

	public static final Item CENTAUR_LIFE_IGNITER = new Item(
		new Item.Properties()
			.stacksTo(1)
			.rarity(Rarity.RARE)
			.itemUseOnBlock(context -> context.getWorld().getBlockEntity(context.getBlockPos(), ArcheonBlockEntities.CENTAUR_LIFE_VAULT).ifPresent(blockEntity -> {
				if (context.getPlayer() != null) {
					if (context.getWorld() instanceof ServerWorld world) {
						blockEntity.beginFight(world, context.getBlockPos(), world.getBlockState(context.getBlockPos()));
					}
					if (!context.getPlayer().isCreative()) context.getPlayer().getInventory().removeOne(context.getPlayer().getStackInHand(context.getHand()));
				}
			}))
	);

	public static final Item POWER_KEY = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).itemUseOnBlock(context -> {
		BlockState state = context.getWorld().getBlockState(context.getBlockPos());
		if (state.isOf(ArcheonBlocks.POWER_KEYSTONE) && context.getPlayer() != null) {
			HeartOfNatureEntity heartOfNatureEntity = new HeartOfNatureEntity(ArcheonEntities.HEART_OF_NATURE, context.getWorld());
			Vec3d originalPos = new Vec3d(context.getBlockPos().getX() + 0.5f, context.getBlockPos().getY() + 2.5f, context.getBlockPos().getZ() + 0.5f);
			heartOfNatureEntity.setPosition(originalPos);
			heartOfNatureEntity.onSummonedByPowerKey(originalPos);
			context.getWorld().spawnEntity(heartOfNatureEntity);
			if (!context.getPlayer().isCreative()) context.getPlayer().getInventory().removeOne(context.getPlayer().getStackInHand(context.getHand()));
		}
	}));

	public static final SpearItem CENTAUR_SPEAR = new SpearItem(CentaurSpearEntity::new, new Item.Properties().stacksTo(1).maxDamage(250).rarity(Rarity.EPIC).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final AxeItem CENTAUR_BATTLE_AXE = new AxeItem(CentaurTool.INSTANCE, 4, -2.5f, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));

	public static final SwordItem NECLANE_SWORD = new SwordItem(ToolMaterials.WOOD, 3, -2.4f, new Item.Properties());
	public static final PickaxeItem NECLANE_PICKAXE = new PickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new Item.Properties());
	public static final AxeItem NECLANE_AXE = new AxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new Item.Properties());
	public static final ShovelItem NECLANE_SHOVEL = new ShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new Item.Properties());
	public static final HoeItem NECLANE_HOE = new HoeItem(ToolMaterials.WOOD, 0, -3.0f, new Item.Properties());

	public static final SwordItem CYPRESS_SWORD = new SwordItem(ToolMaterials.WOOD, 3, -2.4f, new Item.Properties());
	public static final PickaxeItem CYPRESS_PICKAXE = new PickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new Item.Properties());
	public static final AxeItem CYPRESS_AXE = new AxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new Item.Properties());
	public static final ShovelItem CYPRESS_SHOVEL = new ShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new Item.Properties());
	public static final HoeItem CYPRESS_HOE = new HoeItem(ToolMaterials.WOOD, 0, -3.0f, new Item.Properties());

	public static final SwordItem VUXANCIA_SWORD = new SwordItem(ToolMaterials.WOOD, 3, -2.4f, new Item.Properties());
	public static final PickaxeItem VUXANCIA_PICKAXE = new PickaxeItem(ToolMaterials.WOOD, 1, -2.8f, new Item.Properties());
	public static final AxeItem VUXANCIA_AXE = new AxeItem(ToolMaterials.WOOD, 6.0f, -3.2f, new Item.Properties());
	public static final ShovelItem VUXANCIA_SHOVEL = new ShovelItem(ToolMaterials.WOOD, 1.5f, -3.0f, new Item.Properties());
	public static final HoeItem VUXANCIA_HOE = new HoeItem(ToolMaterials.WOOD, 0, -3.0f, new Item.Properties());

	public static final SwordItem CHIASPEN_SWORD = new SwordItem(ToolMaterials.STONE, 3, -2.4f, new Item.Properties());
	public static final PickaxeItem CHIASPEN_PICKAXE = new PickaxeItem(ToolMaterials.STONE, 1, -2.8f, new Item.Properties());
	public static final AxeItem CHIASPEN_AXE = new AxeItem(ToolMaterials.STONE, 7.0f, -3.2f, new Item.Properties());
	public static final ShovelItem CHIASPEN_SHOVEL = new ShovelItem(ToolMaterials.STONE, 1.5f, -3.0f, new Item.Properties());
	public static final HoeItem CHIASPEN_HOE = new HoeItem(ToolMaterials.STONE, -1, -2.0f, new Item.Properties());

	public static final SwordItem APAFLORITE_SWORD = new SwordItem(ApafloriteTool.INSTANCE, 3, -2.4f, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final PickaxeItem APAFLORITE_PICKAXE = new PickaxeItem(ApafloriteTool.INSTANCE, 1, -2.8f, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final AxeItem APAFLORITE_AXE = new AxeItem(ApafloriteTool.INSTANCE, 6.0F, -3.1f, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final ShovelItem APAFLORITE_SHOVEL = new ShovelItem(ApafloriteTool.INSTANCE, 1.5f, -3.0f, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final HoeItem APAFLORITE_HOE = new HoeItem(ApafloriteTool.INSTANCE, -2, -1.0f, new Item.Properties().glintPack(DefaultGlintPacks.PINK));

	public static final ArmorItem APAFLORITE_HELMET = new ArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.HEAD, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final ArmorItem APAFLORITE_CHESTPLATE = new ArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.CHEST, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final ArmorItem APAFLORITE_LEGGINGS = new ArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.LEGS, new Item.Properties().glintPack(DefaultGlintPacks.PINK));
	public static final ArmorItem APAFLORITE_BOOTS = new ArmorItem(ApafloriteArmor.INSTANCE, EquipmentSlot.FEET, new Item.Properties().glintPack(DefaultGlintPacks.PINK));

	public static final SwordItem FAELITE_SWORD = new SwordItem(FaeliteTool.INSTANCE, 3, -2.4f, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final PickaxeItem FAELITE_PICKAXE = new PickaxeItem(FaeliteTool.INSTANCE, 1, -2.8f, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final AxeItem FAELITE_AXE = new AxeItem(FaeliteTool.INSTANCE, 5.0f, -3.0f, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final ShovelItem FAELITE_SHOVEL = new ShovelItem(FaeliteTool.INSTANCE, 1.5f, -3.0f, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final HoeItem FAELITE_HOE = new HoeItem(FaeliteTool.INSTANCE, -3, 0.0f, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));

	public static final ArmorItem FAELITE_HELMET = new ArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.HEAD, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final ArmorItem FAELITE_CHESTPLATE = new ArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.CHEST, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final ArmorItem FAELITE_LEGGINGS = new ArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.LEGS, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));
	public static final ArmorItem FAELITE_BOOTS = new ArmorItem(FaeliteArmor.INSTANCE, EquipmentSlot.FEET, new Item.Properties().glintPack(DefaultGlintPacks.ORANGE));

	public static final SwordItem LUSONYTH_SWORD = new SwordItem(LusonythTool.INSTANCE, 3, -2.4f, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final PickaxeItem LUSONYTH_PICKAXE = new PickaxeItem(LusonythTool.INSTANCE, 1, -2.8f, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final AxeItem LUSONYTH_AXE = new AxeItem(LusonythTool.INSTANCE, 5.0f, -3.0f, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final ShovelItem LUSONYTH_SHOVEL = new ShovelItem(LusonythTool.INSTANCE, 1.5f, -3.0f, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final HoeItem LUSONYTH_HOE = new HoeItem(LusonythTool.INSTANCE, -4, 0.0f, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));

	public static final ArmorItem LUSONYTH_HELMET = new ArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.HEAD, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final ArmorItem LUSONYTH_CHESTPLATE = new ArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.CHEST, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final ArmorItem LUSONYTH_LEGGINGS = new ArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.LEGS, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));
	public static final ArmorItem LUSONYTH_BOOTS = new ArmorItem(LusonythArmor.INSTANCE, EquipmentSlot.FEET, new Item.Properties().glintPack(DefaultGlintPacks.BLUE));

	public static final Predicate<ItemStack> CLEMENTIUM_BROKEN_STATE = stack -> stack.getNbt() == null || !stack.getNbt().contains("repair_rate") || stack.getNbt().getInt("repair_rate") < 3;

	public static final SwordItem CLEMENTIUM_SWORD = new SwordItem(ClementiumTool.INSTANCE, 3, -2.4f, new Item.Properties().hasBrokenState(CLEMENTIUM_BROKEN_STATE).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final PickaxeItem CLEMENTIUM_PICKAXE = new PickaxeItem(ClementiumTool.INSTANCE, 1, -2.8f, new Item.Properties().hasBrokenState(CLEMENTIUM_BROKEN_STATE).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final AxeItem CLEMENTIUM_AXE = new AxeItem(ClementiumTool.INSTANCE, 5.0f, -3.0f, new Item.Properties().hasBrokenState(CLEMENTIUM_BROKEN_STATE).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final ShovelItem CLEMENTIUM_SHOVEL = new ShovelItem(ClementiumTool.INSTANCE, 1.5f, -3.0f, new Item.Properties().hasBrokenState(CLEMENTIUM_BROKEN_STATE).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));
	public static final HoeItem CLEMENTIUM_HOE = new HoeItem(ClementiumTool.INSTANCE, -4, 0.0f, new Item.Properties().hasBrokenState(CLEMENTIUM_BROKEN_STATE).glintPack(DefaultGlintPacks.LIGHTENED_BROWN));

	public static final FaeliteBowItem FAELITE_BOW = new FaeliteBowItem(new Item.Properties().stacksTo(1).maxDamage(1561));
	public static final ArrowItem LUSONYTH_ARROW = new LusonythArrowItem(new Item.Properties());

	public static final FishingRodItem EXYRIANE_FISHING_ROD = new FishingRodItem(new Item.Properties());

	public static final RingItem APAFLORITE_RING = new RingItem(RingItem::apafloriteRingModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	public static final RingItem FAELITE_RING = new RingItem(RingItem::faeliteRingModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	public static final RingItem LUSONYTH_RING = new RingItem(RingItem::lusonythRingModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	public static final RingItem CLEMENTIUM_RING = new RingItem(RingItem::clementiumRingModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	public static final RingItem RING_OF_EDEN = new RingItem(RingItem::ringOfEdenModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	public static final RingItem RING_OF_WAHVEN = new RingItem(RingItem::ringOfWahvenModifiers, new Item.Properties().stacksTo(1).rarity(Rarity.RARE));

	public static final EnchantedBookItem MASSACRE_BOOK = new EnchantedBookItem(ArcheonEnchantments.MASSACRE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).nameFormattings(Formatting.RED).glintPack(DefaultGlintPacks.LIGHTENED_RED));
	public static final EnchantedBookItem QOLM_BOOK = new EnchantedBookItem(ArcheonEnchantments.QOLM, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).nameFormattings(Formatting.GREEN).glintPack(DefaultGlintPacks.LIGHTENED_GREEN));

	public static final AmuletOfNatureItem AMULET_OF_NATURE = new AmuletOfNatureItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).descriptionLines(Component.translatable("item.archeon.amulet_of_nature.desc").formatted(Formatting.GRAY)));

	public static final Item MANUSCRIPT = new Item(new Item.Properties());

	public static final Item APAFLORITE_GEMSTONE = new Item(new Item.Properties());

	public static final Item EXYRIANE_SHARD = new Item(new Item.Properties());

	public static final Item RAW_FAELITE = new Item(new Item.Properties());
	public static final Item FAELITE_INGOT = new Item(new Item.Properties());

	public static final Item RAW_LUSONYTH = new Item(new Item.Properties());
	public static final Item LUSONYTH_INGOT = new Item(new Item.Properties());

	public static final Item PLANT_FIBER = new Item(new Item.Properties());

	public static final Item MOSS_BALL = new Item(new Item.Properties().food(1, 0.5f));

	public static final Item BLUE_SHELL = new Item(new Item.Properties());
	public static final Item PINK_SHELL = new Item(new Item.Properties());
	public static final Item YELLOW_SHELL = new Item(new Item.Properties());

	public static final BucketItem WOODEN_BUCKET = new BucketItem(
		Fluids.EMPTY, WoodenBucketManager.INSTANCE, new Item.Properties().stacksTo(16)
	);

	public static final BucketItem WOODEN_WATER_BUCKET = new BucketItem(
		Fluids.WATER, WoodenBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final MilkBucketItem WOODEN_MILK_BUCKET = new MilkBucketItem(
		WoodenBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem WOODEN_HOT_SPRING_WATER_BUCKET = new BucketItem(
		ArcheonFluids.HOT_SPRING_WATER.getStill(), WoodenBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem WOODEN_DASCIUM_BUCKET = new BucketItem(
		ArcheonFluids.DASCIUM.getStill(), WoodenBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem CERAMIC_BUCKET = new BucketItem(
		Fluids.EMPTY, CeramicBucketManager.INSTANCE, new Item.Properties().stacksTo(16)
	);

	public static final BucketItem CERAMIC_WATER_BUCKET = new BucketItem(
		Fluids.WATER, CeramicBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem CERAMIC_LAVA_BUCKET = new BucketItem(
		Fluids.LAVA, CeramicBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem CERAMIC_HOT_SPRING_WATER_BUCKET = new BucketItem(
		ArcheonFluids.HOT_SPRING_WATER.getStill(), CeramicBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final BucketItem CERAMIC_DASCIUM_BUCKET = new BucketItem(
		ArcheonFluids.DASCIUM.getStill(), CeramicBucketManager.INSTANCE, new Item.Properties().stacksTo(1)
	);

	public static final WallStandingBlockItem EXYRIANE_TORCH = new WallStandingBlockItem(ArcheonBlocks.EXYRIANE_TORCH, ArcheonBlocks.WALL_EXYRIANE_TORCH, new Item.Properties());

	public static final FluidInteractableItem GOBLET = new FluidInteractableItem(
		(stack, state, world, pos) -> state.isIn(FluidTags.WATER) ? ArcheonItems.GOBLET_WATER.getDefaultStack() : ItemStack.EMPTY,
		new Item.Properties()
	);

	public static final ItemFinishUsing GOBLET_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.GOBLET) : stack);

	public static final Item GOBLET_WATER = new Item(new Item.Properties().stacksTo(1)
		.food(0, 0.0f, false, true).drinkable().itemFinishUsing(GOBLET_USE));

	public static final Item GOBLET_BLOOD_ORANGE_JUICE = new Item(new Item.Properties().stacksTo(1)
		.food(4, 0.5f).drinkable().itemFinishUsing(GOBLET_USE));

	public static final Item JAM_POT = new Item(new Item.Properties());

	public static final ItemFinishUsing JAM_POT_USE = (stack, world, user) -> (stack.isEmpty() ? new ItemStack(ArcheonItems.JAM_POT) : stack);

	public static final Item ORANGE_LYCORIS_JAM_POT = new Item(new Item.Properties().stacksTo(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200), 1.0f)
			.build()
	).drinkable().recipeRemainder(ArcheonItems.JAM_POT).itemFinishUsing(JAM_POT_USE));

	public static final Item RED_LYCORIS_JAM_POT = new Item(new Item.Properties().stacksTo(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 1), 1.0f)
			.build()
	).drinkable().recipeRemainder(ArcheonItems.JAM_POT).itemFinishUsing(JAM_POT_USE));

	public static final Item PINK_LYCORIS_JAM_POT = new Item(new Item.Properties().stacksTo(1).food(
		new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(3.0f)
			.alwaysEdible()
			.snack()
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0), 1.0f)
			.build()
	).drinkable().recipeRemainder(ArcheonItems.JAM_POT).itemFinishUsing(JAM_POT_USE));

	public static final Item RED_LYCORIS_PETAL = new Item(new Item.Properties().food(3, 0.2f));

	public static final Item PINK_LYCORIS_PETAL = new Item(new Item.Properties().food(3, 0.2f));

	public static final Item ORANGE_LYCORIS_PETAL = new Item(new Item.Properties().food(3, 0.2f));

	public static final LoreScrapItem LORE_SCRAP = new LoreScrapItem(new Item.Properties().stacksTo(1));

	public static final MusicDiscItem MUSIC_DISC_PE4K = new MusicDiscItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("music_disc.pe4k")), 0, 116);

	public static final MusicDiscItem MUSIC_DISC_GEOMETRIC_FALL = new MusicDiscItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("music_disc.geometric_fall")), 0, 74);

	public static final MusicDiscItem MUSIC_DISC_PARALLELIFY = new MusicDiscItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("music_disc.parallelify")), 0, 101);

	public static final MusicDiscItem MUSIC_DISC_GLAIVE = new MusicDiscItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE),
		new SoundEvent(Archeon.createId("music_disc.glaive")), 0, 176);

	public static final MusicDiscItem MUSIC_DISC_AIEL = new MusicDiscItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC),
		new SoundEvent(Archeon.createId("music_disc.aiel")), 0, 0);

	public static final Item RECORD_FRAGMENT = new Item(new Item.Properties().stacksTo(16));

	public static final Item SALT = new Item(new Item.Properties());

	public static final Item PEAKS_SNOW_PILE = new Item(new Item.Properties());

	public static final Item RAW_HEIFER = new Item(new Item.Properties().food(2, 0.3f, true));
	public static final Item SALTED_HEIFER = new Item(new Item.Properties().food(3, 0.9f, true));
	public static final Item COOKED_HEIFER = new Item(new Item.Properties().food(4, 1.5f, true));

	public static final Item RAW_SUNSTRADIVER_CHOP = new Item(new Item.Properties().food(2, 0.3f, true));
	public static final Item COOKED_SUNSTRADIVER_CHOP = new Item(new Item.Properties().food(7, 1.0f, true));

	public static final Item RAW_DEER = new Item(new Item.Properties().food(3, 0.3f, true));
	public static final Item COOKED_DEER = new Item(new Item.Properties().food(9, 1.0f, true));

	public static final Item LYCORIS_JAM_PIE = new Item(new Item.Properties().stacksTo(1).food(6, 10.0f));

	public static final Item BLOOD_ORANGE = new Item(new Item.Properties().food(1, 0.3f));

	public static final Item GRAPE = new Item(new Item.Properties().food(1, 0.3f));

	public static final Item EXYRIANE_GRAPE = new Item(new Item.Properties().food(
		new FoodComponent.Builder()
			.hunger(5)
			.saturationModifier(2.5f)
			.alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 160, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 0, 3), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160, 1), 1.0f)
			.build()
	));

	public static final Item GROWING_NEAVE_BERRIES = new Item(new Item.Properties().food(1, 0.3f));

	public static final Item NEAVE_BERRIES = new Item(new Item.Properties().food(3, 0.6f));

	public static final Item INK_BOTTLE = new Item(new Item.Properties().stacksTo(16));

	public static final PouchItem POUCH = new PouchItem(new Item.Properties().stacksTo(1));

	public static final Item SUNSTRADIVER_FEATHER = new Item(new Item.Properties());

	public static final Item SNAIL_SHELL = new Item(new Item.Properties());

	public static final Item AURORA_CRYSTAL = new Item(new Item.Properties().fireproof());

	public static final Item IMPRESSIVE_AURORA_CRYSTAL = new Item(
		new Item.Properties()
			.fireproof()
			.nameFormattings(Formatting.GOLD)
			.descriptionLines(
				Component.translatable("item.archeon.impressive_aurora_crystal.desc").formatted(Formatting.GRAY),
				Component.translatable("interaction.archeon.amulet_of_nature").formatted(Formatting.GRAY)
			)
	);

	public static final Item CENTAUR_HOOF = new Item(new Item.Properties().fireproof());

	public static final Item CENTAUR_HORSESHOE = new Item(
		new Item.Properties()
			.fireproof()
			.nameFormattings(Formatting.GOLD)
			.descriptionLines(
				Component.translatable("item.archeon.centaur_horseshoe.desc").formatted(Formatting.GRAY),
				Component.translatable("interaction.archeon.amulet_of_nature").formatted(Formatting.GRAY)
			)
	);

	public static final SpawnEggItem AURORA_CATALYST_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.AURORA_CATALYST, 4380648, 3876673, new Item.Properties());
	public static final SpawnEggItem POISONOUS_AURORA_CATALYST_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.POISONOUS_AURORA_CATALYST, 2881287, 6633076, new Item.Properties());
	public static final SpawnEggItem EXPLOSIVE_AURORA_CATALYST_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.EXPLOSIVE_AURORA_CATALYST, 12279738, 6967084, new Item.Properties());
	public static final SpawnEggItem MOURNCREEP_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.MOURNCREEP, 6380368, 5267794, new Item.Properties());
	public static final SpawnEggItem SNAIL_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.SNAIL, 9198398, 14794633, new Item.Properties());
	public static final SpawnEggItem SUNSTRADIVER_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.SUNSTRADIVER, 16724787, 16764006, new Item.Properties());
	public static final SpawnEggItem HEIFER_SPAWN_EGG = new SpawnEggItem(ArcheonEntities.HEIFER, 2298374, 3680013, new Item.Properties());

	private static Item register(String path, Item.Properties properties) {
		return register(path, Item::new, properties);
	}

	private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Archeon.createId(path));
		return Items.registerItem(key, factory, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
