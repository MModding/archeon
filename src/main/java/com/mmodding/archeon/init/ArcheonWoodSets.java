package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.library.woodset.api.WoodSet;
import com.mmodding.library.woodset.api.WoodSetBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ArcheonWoodSets {

	public static final WoodSet PALM = WoodSetBuilder.create(Archeon.namespace(), "palm", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
	public static final WoodSet NECLANE = WoodSetBuilder.create(Archeon.namespace(), "neclane", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
	public static final WoodSet CYPRESS = WoodSetBuilder.create(Archeon.namespace(), "cypress", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
	public static final WoodSet VUXANCIA = WoodSetBuilder.create(Archeon.namespace(), "vuxancia", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
	public static final WoodSet NUME_WILLOW = WoodSetBuilder.create(Archeon.namespace(), "nume_willow", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
	public static final WoodSet NYRETH = WoodSetBuilder.create(Archeon.namespace(), "nyreth", WoodTypeBuilder.copyOf(WoodType.OAK), BlockSetTypeBuilder.copyOf(BlockSetType.OAK)).buildAndRegister();
}
