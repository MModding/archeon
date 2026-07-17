package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.block.GiantLilyBlock;
import com.mmodding.archeon.block.SporeRootcapBlock;
import com.mmodding.archeon.item.LoreScrapItem;
import com.mmodding.archeon.item.RingItem;
import com.mmodding.library.block.api.BlockWithItem;
import com.mmodding.library.block.api.catalog.*;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Predicate;

public class ArcheonCreativeModeTabs {

	private static final List<Item> NOT_IN_CREATIVE_TAB = List.of(
		ArcheonItems.MASSACRE_BOOK,
		ArcheonItems.QOLM_BOOK
	);

	public static final Predicate<Block> HAS_ITEM = block -> !block.asItem().equals(Items.AIR) || block instanceof GrowsDownPlantBlock.Head;

	public static final Predicate<Item> IS_IN_CREATIVE_TAB = (item) -> {
		for (Item forbiddenItem : ArcheonCreativeModeTabs.NOT_IN_CREATIVE_TAB) {
			if (BuiltInRegistries.ITEM.getKey(item).getPath().equals(BuiltInRegistries.ITEM.getKey(forbiddenItem).getPath())) {
				return false;
			}
		}
		return true;
	};

	public static final Predicate<Block> BLOCK_IN_CREATIVE_TAB = (block) -> HAS_ITEM.test(block) && IS_IN_CREATIVE_TAB.test(block.asItem());

	public static final Predicate<Block> IS_FAUNA = block ->
		(BuiltInRegistries.BLOCK.getKey(block).getPath().contains("achrean")) ||
		(BuiltInRegistries.BLOCK.getKey(block).getPath().contains("glowshroom")) ||
		(block instanceof SimpleFlowerBlock) ||
		(block instanceof SimpleTallFlowerBlock) ||
		(block instanceof SimplePlantBlock) ||
		(block instanceof SimpleTallPlantBlock) ||
		(block instanceof SimpleFernBlock) ||
		(block instanceof SimpleSugarCaneBlock) ||
		(block instanceof SporeRootcapBlock) ||
		(block instanceof SimpleLilyPadBlock) ||
		(block instanceof GiantLilyBlock);

	public static final Predicate<Item> IS_EQUIPMENT = item ->
		(Registry.ITEM.getId(item).equals(Archeon.createId("centaur_life_igniter"))) ||
		(Registry.ITEM.getId(item).equals(Archeon.createId("power_key"))) ||
		(Registry.ITEM.getId(item).equals(Archeon.createId("amulet_of_nature"))) ||
		(item instanceof CustomPortalKeyItem) ||
		(item instanceof CustomArmorItem) ||
		(item instanceof CustomSwordItem) ||
		(item instanceof CustomSpearItem) ||
		(item instanceof CustomBowItem) ||
		(item instanceof CustomArrowItem) ||
		(item instanceof CustomPickaxeItem) ||
		(item instanceof CustomAxeItem) ||
		(item instanceof CustomShovelItem) ||
		(item instanceof CustomHoeItem) ||
		(item instanceof CustomFishingRodItem) ||
		(item instanceof RingItem);

	public static final CreativeModeTab SULLEN_RIFTS_ADVENTURE = FabricCreativeModeTab.builder()
		.icon(ArcheonItems.LORE_SCRAP::getDefaultStack)
		.displayItems((parameters, entries) -> entries.acceptAll(LoreScrapItem.getLoreScrapItemStacks()))
		.build();

	public static final CreativeModeTab BLOCKS = FabricCreativeModeTab.builder()
		.icon(ArcheonBlocks.WET_GRASS_BLOCK.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && !IS_FAUNA.test(block) && HAS_ITEM.test(block) && BLOCK_IN_CREATIVE_TAB.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final CreativeModeTab COMBAT_AND_TOOLS = FabricCreativeModeTab.builder()
		.icon(ArcheonItems.CHIASPEN_SWORD::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && IS_EQUIPMENT.test(item) && IS_IN_CREATIVE_TAB.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	public static final CreativeModeTab FAUNA = FabricCreativeModeTab.builder()
		.icon(ArcheonBlocks.RED_LYCORIS.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && IS_FAUNA.test(block) && HAS_ITEM.test(block) && BLOCK_IN_CREATIVE_TAB.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final CreativeModeTab MISCELLANEOUS = FabricCreativeModeTab.builder()
		.icon(ArcheonItems.PINK_LYCORIS_PETAL::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && !IS_EQUIPMENT.test(item) && IS_IN_CREATIVE_TAB.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, factory -> {
			factory.register("sullen_rifts", "adventure", SULLEN_RIFTS_ADVENTURE);
			factory.register("blocks", BLOCKS);
			factory.register("combat_and_tools", COMBAT_AND_TOOLS);
			factory.register("fauna", FAUNA);
			factory.register("miscellaneous", MISCELLANEOUS);
		});
	}
}
