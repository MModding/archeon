package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.CustomFlowerBlock;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

public class ArcheonItemGroups implements ElementsInitializer {

	public static final ItemGroup BLOCKS = QuiltItemGroup.builder(Archeon.createId("blocks"))
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && !(block instanceof CustomFlowerBlock))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();
	public static final ItemGroup COMBAT_AND_TOOLS = QuiltItemGroup.create(Archeon.createId("combat_and_tools"));
	public static final ItemGroup FAUNA = QuiltItemGroup.builder(Archeon.createId("fauna"))
		.appendItems(itemStacks -> Registry.BLOCK.stream().filter(block -> block.toString()
				.split(":")[0]
				.contains("archeon") && (block instanceof CustomFlowerBlock))
			.forEach(block -> itemStacks.add(new ItemStack(block))))
		.build();
	public static final ItemGroup MISCELLANEOUS = QuiltItemGroup.create(Archeon.createId("miscellaneous"));

	@Override
	public void register() {}
}
