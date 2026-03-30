package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;

public class ArcheonWoodTypes {

	public static final WoodType PALM = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("palm"), ArcheonBlockSetTypes.PALM);
	public static final WoodType NECLANE = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("neclane"), ArcheonBlockSetTypes.NECLANE);
	public static final WoodType CYPRESS = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("cypress"), ArcheonBlockSetTypes.CYPRESS);
	public static final WoodType VUXANCIA = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("vuxancia"), ArcheonBlockSetTypes.VUXANCIA);
	public static final WoodType NUME_WILLOW = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("nume_willow"), ArcheonBlockSetTypes.NUME_WILLOW);
	public static final WoodType NYRETH = WoodTypeBuilder.copyOf(WoodType.OAK).build(Archeon.createId("nyreth"), ArcheonBlockSetTypes.NYRETH);
}
