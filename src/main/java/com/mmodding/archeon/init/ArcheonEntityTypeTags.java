package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ArcheonEntityTypeTags {

	public static final TagKey<EntityType<?>> AURORA_CATALYSTS = TagKey.of(RegistryKeys.ENTITY_TYPE, Archeon.createId("aurora_catalysts"));
	public static final TagKey<EntityType<?>> CENTAURS = TagKey.of(RegistryKeys.ENTITY_TYPE, Archeon.createId("centaurs"));
}
