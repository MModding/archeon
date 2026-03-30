package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;

public class ArcheonBlockSetTypes {

	public static final BlockSetType PALM = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("palm"));
	public static final BlockSetType NECLANE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("neclane"));
	public static final BlockSetType CYPRESS = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("cypress"));
	public static final BlockSetType VUXANCIA = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("vuxancia"));
	public static final BlockSetType NUME_WILLOW = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("nume_willow"));
	public static final BlockSetType NYRETH = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(Archeon.createId("nyreth"));
}
