package com.mmodding.archeon.block.entity;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;

public class ArcheonBlockEntities {

	public static final BlockEntityType<CentaurLifeVaultBlockEntity> CENTAUR_LIFE_VAULT = FabricBlockEntityTypeBuilder.create(CentaurLifeVaultBlockEntity::new, ArcheonBlocks.CENTAUR_LIFE_VAULT).build();

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.BLOCK_ENTITY_TYPE, "centaur_life_vault", CENTAUR_LIFE_VAULT);
	}
}
