package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ArcheonItemTags {

	public static final TagKey<Item> LEAVES = TagKey.of(RegistryKeys.ITEM, Archeon.createId("leaves"));
	public static final TagKey<Item> LYCORIS_PETALS = TagKey.of(RegistryKeys.ITEM, Archeon.createId("lycoris_petals"));
	public static final TagKey<Item> LYCORIS_JAM_POTS = TagKey.of(RegistryKeys.ITEM, Archeon.createId("lycoris_jam_pots"));
	public static final TagKey<Item> PLANKS = TagKey.of(RegistryKeys.ITEM, Archeon.createId("planks"));
	public static final TagKey<Item> SHELLS = TagKey.of(RegistryKeys.ITEM, Archeon.createId("shells"));
	public static final TagKey<Item> TILES = TagKey.of(RegistryKeys.ITEM, Archeon.createId("tiles"));
}
