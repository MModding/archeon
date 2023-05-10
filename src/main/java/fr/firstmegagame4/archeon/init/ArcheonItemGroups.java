package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.items.*;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.blocks.SporeRootcapBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

import java.util.function.Predicate;

public class ArcheonItemGroups implements ElementsInitializer {

	public static final Predicate<Block> IS_FAUNA = block ->
		(block instanceof CustomFlowerBlock) ||
		(block instanceof CustomTallFlowerBlock) ||
		(block instanceof CustomPlantBlock) ||
		(block instanceof CustomTallPlantBlock) ||
		(block instanceof CustomFernBlock) ||
		(block instanceof CustomSugarCaneBlock) ||
		(block instanceof SporeRootcapBlock);

	public static final Predicate<Item> IS_EQUIPMENT = item ->
		(item instanceof CustomArmorItem) ||
		(item instanceof CustomSwordItem) ||
		(item instanceof CustomPickaxeItem) ||
		(item instanceof CustomAxeItem) ||
		(item instanceof CustomShovelItem) ||
		(item instanceof CustomHoeItem) ||
		(item instanceof CustomFishingRodItem);

	public static final Predicate<Block> HAS_ITEM = block -> {
		if (block instanceof BlockWithItem blockWithItem) {
			return blockWithItem.getItem() != null;
		}
		else return block instanceof CustomGrowsDownPlantBlock.Head;
	};

	public static final ItemGroup BLOCKS = QuiltItemGroup.builder(Archeon.createId("blocks"))
		.icon(ArcheonBlocks.WET_GRASS_BLOCK.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && !IS_FAUNA.test(block) && HAS_ITEM.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final ItemGroup COMBAT_AND_TOOLS = QuiltItemGroup.builder(Archeon.createId("combat_and_tools"))
		.icon(ArcheonItems.SOUTHSTONE_SWORD::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && IS_EQUIPMENT.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	public static final ItemGroup FAUNA = QuiltItemGroup.builder(Archeon.createId("fauna"))
		.icon(ArcheonBlocks.RED_LYCORIS.getItem()::getDefaultStack)
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && IS_FAUNA.test(block) && HAS_ITEM.test(block))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();

	public static final ItemGroup MISCELLANEOUS = QuiltItemGroup.builder(Archeon.createId("miscellaneous"))
		.icon(ArcheonItems.PINK_LYCORIS_PETAL::getDefaultStack)
		.appendItems(itemStacks -> Registry.ITEM.stream().filter(item -> Registry.ITEM.getId(item).getNamespace()
				.equals("archeon") && !(item instanceof BlockItem) && !IS_EQUIPMENT.test(item))
			.forEach(item -> itemStacks.add(item.getDefaultStack())))
		.build();

	@Override
	public void register() {}
}
