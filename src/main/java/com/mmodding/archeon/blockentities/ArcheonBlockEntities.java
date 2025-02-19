package com.mmodding.archeon.blockentities;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blockentities.CustomBlockEntityType;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;

import java.util.Set;

public class ArcheonBlockEntities implements ElementsInitializer {

	public static final CustomBlockEntityType<CentaurLifeVaultBlockEntity> CENTAUR_LIFE_VAULT = new CustomBlockEntityType<>(CentaurLifeVaultBlockEntity::new, Set.of(ArcheonBlocks.CENTAUR_LIFE_VAULT), null);

	@Override
	public void register() {
		CENTAUR_LIFE_VAULT.register(Archeon.createId("centaur_life_vault"));
	}
}
