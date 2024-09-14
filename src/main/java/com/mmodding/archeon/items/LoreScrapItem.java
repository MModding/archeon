package com.mmodding.archeon.items;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.screens.LoreScrapScreen;
import com.mmodding.archeon.init.ArcheonItemGroups;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.items.CustomItem;
import com.mmodding.mmodding_lib.library.network.support.NetworkSupport;
import com.mmodding.mmodding_lib.library.utils.MapUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class LoreScrapItem extends CustomItem {

	private static final Map<Identifier, LoreData> LORE_SCRAPS = MapUtils.builder(map -> {
		map.put(Archeon.createId("archeology"), new LoreData("loreData.archeon.archeology"));
		map.put(Archeon.createId("artifacts"), new LoreData("loreData.archeon.artifacts"));
		map.put(Archeon.createId("clementium"), new LoreData("loreData.archeon.clementium"));
		map.put(Archeon.createId("columns_and_pots"), new LoreData("loreData.archeon.columns_and_pots"));
		map.put(Archeon.createId("culinary_arts"), new LoreData("loreData.archeon.culinary_arts"));
		map.put(Archeon.createId("faelite"), new LoreData("loreData.archeon.faelite"));
		map.put(Archeon.createId("fauna"), new LoreData("loreData.archeon.fauna"));
		map.put(Archeon.createId("flora_alchemy"), new LoreData("loreData.archeon.flora_alchemy"));
		map.put(Archeon.createId("flora_alchemy_sequel"), new LoreData("loreData.archeon.flora_alchemy_sequel"));
		map.put(Archeon.createId("fruits"), new LoreData("loreData.archeon.fruits"));
		map.put(Archeon.createId("glass_confections"), new LoreData("loreData.archeon.glass_confections"));
		map.put(Archeon.createId("heart_of_nature"), new LoreData("loreData.archeon.heart_of_nature"));
		map.put(Archeon.createId("wood"), new LoreData("loreData.archeon.wood"));
		map.put(Archeon.createId("lusonyth"), new LoreData("loreData.archeon.lusonyth"));
		map.put(Archeon.createId("apaflorite"), new LoreData("loreData.archeon.apaflorite"));
		map.put(Archeon.createId("exyriane"), new LoreData("loreData.archeon.exyriane"));
		map.put(Archeon.createId("seashells"), new LoreData("loreData.archeon.seashells"));
		map.put(Archeon.createId("stones"), new LoreData("loreData.archeon.stones"));
		map.put(Archeon.createId("stones_sequel"), new LoreData("loreData.archeon.stones_sequel"));
		map.put(Archeon.createId("sunstradiver_and_snail"), new LoreData("loreData.archeon.sunstradiver_and_snail"));
		map.put(Archeon.createId("the_panopticon"), new LoreData("loreData.archeon.the_panopticon"));
		map.put(Archeon.createId("the_tower_of_atmosphere"), new LoreData("loreData.archeon.the_tower_of_atmosphere"));
	});

	public LoreScrapItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient()) {
			ItemStack stack = user.getStackInHand(hand);
			MinecraftClient.getInstance().setScreen(new LoreScrapScreen(LoreData.of(stack)));
			return TypedActionResult.success(stack);
		}
		return super.use(world, user, hand);
	}

	@Override
	public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
		if (group == ArcheonItemGroups.SULLEN_RIFTS_ADVENTURE || group == ItemGroup.SEARCH) {
			LoreScrapItem.LORE_SCRAPS.keySet().forEach(key -> {
				ItemStack stack = new ItemStack(ArcheonItems.LORE_SCRAP);
				stack.getOrCreateNbt().putString("LoreData", key.toString());
				stacks.add(stack);
			});
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		LoreData data = LoreData.of(stack);
		if (data != LoreData.EMPTY) {
			tooltip.add(data.getTitle().copy().formatted(Formatting.GREEN));
		}
	}

	public static class LoreData implements NetworkSupport {

		public static final LoreData EMPTY = new LoreData("loreData.empty");

		private final String key;
		private final MutableText title;
		private final MutableText description;

		public LoreData(String translationKey) {
			this.key = translationKey;
			this.title = Text.translatable(this.key + ".title");
			this.description = Text.translatable(this.key + ".desc");
		}

		private static LoreData of(ItemStack stack) {
			if (stack.getItem() instanceof LoreScrapItem && stack.hasNbt()) {
				assert stack.getNbt() != null;
				return LoreData.of(stack.getNbt());
			}
			return LoreData.EMPTY;
		}

		private static LoreData of(NbtCompound nbt) {
			return LoreScrapItem.LORE_SCRAPS.get(Identifier.tryParse(nbt.getString("LoreData")));
		}

		public MutableText getTitle() {
			return this.title;
		}

		public MutableText getDescription() {
			return this.description;
		}

		private static LoreData read(PacketByteBuf buf) {
			return new LoreData(buf.readString());
		}

		@Override
		public void write(PacketByteBuf buf) {
			buf.writeString(this.key);
		}

		static {
			NetworkSupport.register(Archeon.createId("lore_data"), LoreData.class, LoreData::read);
		}
	}
}
