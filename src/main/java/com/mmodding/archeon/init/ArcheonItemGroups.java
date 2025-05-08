package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.blocks.GiantLilyBlock;
import com.mmodding.archeon.blocks.SporeRootcapBlock;
import com.mmodding.archeon.items.RingItem;
import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.items.*;
import com.mmodding.mmodding_lib.library.portals.CustomPortalKeyItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.function.Predicate;

public class ArcheonItemGroups implements ElementsInitializer {

	private static final List<Item> NOT_IN_CREATIVE_TAB = List.of(
		ArcheonItems.MASSACRE_BOOK,
		ArcheonItems.QOLM_BOOK
	);

	public static final Predicate<Block> HAS_ITEM = block -> {
		if (block instanceof BlockWithItem blockWithItem) {
			return blockWithItem.getItem() != null;
		}
		else return block instanceof CustomGrowsDownPlantBlock.Head;
	};

	public static final Predicate<Item> IS_IN_CREATIVE_TAB = (item) -> {
		for (Item forbiddenItem : ArcheonItemGroups.NOT_IN_CREATIVE_TAB) {
			if (Registry.ITEM.getId(item).getPath().equals(Registry.ITEM.getId(forbiddenItem).getPath())) {
				return false;
			}
		}
		return true;
	};

	public static final Predicate<Block> BLOCK_IN_CREATIVE_TAB = (block) -> HAS_ITEM.test(block) && IS_IN_CREATIVE_TAB.test(block.asItem());

	public static final Predicate<Block> IS_FAUNA = block ->
		(Registry.BLOCK.getId(block).getPath().contains("achrean")) ||
		(Registry.BLOCK.getId(block).getPath().contains("glowshroom")) ||
		(block instanceof CustomFlowerBlock) ||
		(block instanceof CustomTallFlowerBlock) ||
		(block instanceof CustomPlantBlock) ||
		(block instanceof CustomTallPlantBlock) ||
		(block instanceof CustomFernBlock) ||
		(block instanceof CustomSugarCaneBlock) ||
		(block instanceof SporeRootcapBlock) ||
		(block instanceof CustomLilyPadBlock) ||
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

	public static final ItemGroup SULLEN_RIFTS_ADVENTURE = FabricItemGroupBuilder.create(new Identifier("sullen_rifts", "adventure"))
		.icon(ArcheonItems.LORE_SCRAP::getDefaultStack)
		.appendItems(stacks -> stacks.add(ArcheonItems.LORE_SCRAP.getDefaultStack()))
		.build();

	public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(Archeon.createId("blocks"))
		.icon(ArcheonBlocks.WET_GRASS_BLOCK.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && !IS_FAUNA.test(block) && HAS_ITEM.test(block) && BLOCK_IN_CREATIVE_TAB.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final ItemGroup COMBAT_AND_TOOLS = FabricItemGroupBuilder.create(Archeon.createId("combat_and_tools"))
		.icon(ArcheonItems.CHIASPEN_SWORD::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && IS_EQUIPMENT.test(item) && IS_IN_CREATIVE_TAB.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	public static final ItemGroup FAUNA = FabricItemGroupBuilder.create(Archeon.createId("fauna"))
		.icon(ArcheonBlocks.RED_LYCORIS.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && IS_FAUNA.test(block) && HAS_ITEM.test(block) && BLOCK_IN_CREATIVE_TAB.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final ItemGroup MISCELLANEOUS = FabricItemGroupBuilder.create(Archeon.createId("miscellaneous"))
		.icon(ArcheonItems.PINK_LYCORIS_PETAL::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && !IS_EQUIPMENT.test(item) && IS_IN_CREATIVE_TAB.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	@Override
	public void register() {}
}
