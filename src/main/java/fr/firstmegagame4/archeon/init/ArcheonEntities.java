package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.entities.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class ArcheonEntities implements ElementsInitializer {

	public static final EntityType<AuroraCatalystEntity> AURORA_CATALYST = QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, AuroraCatalystEntity::new)
		.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.makeFireImmune()
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<AuroraCatalystEntity> POISONOUS_AURORA_CATALYST = QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, AuroraCatalystEntity::new)
		.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.makeFireImmune()
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<AuroraCatalystEntity> EXPLOSIVE_AURORA_CATALYST = QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, AuroraCatalystEntity::new)
		.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.makeFireImmune()
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<NatureCoreEntity> NATURE_CORE = QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, NatureCoreEntity::new)
		.setDimensions(EntityDimensions.fixed(0.6f, 2.0f))
		.makeFireImmune()
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<SnailEntity> SNAIL = QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new)
		.setDimensions(EntityDimensions.fixed(0.8f, 0.8f))
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<SunstradiverEntity> SUNSTRADIVER = QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, SunstradiverEntity::new)
		.setDimensions(EntityDimensions.fixed(0.5f, 0.9f))
		.maxChunkTrackingRange(8)
		.build();

	public static final EntityType<HeiferEntity> HEIFER = QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, HeiferEntity::new)
		.setDimensions(EntityDimensions.fixed(0.9f, 1.4f))
		.maxChunkTrackingRange(8)
		.build();

	@Override
	public void register() {
		RegistrationUtils.registerEntityType(Archeon.createId("aurora_catalyst"), AURORA_CATALYST);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(AURORA_CATALYST, AuroraCatalystEntity.createAuroraCatalystAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("poisonous_aurora_catalyst"), POISONOUS_AURORA_CATALYST);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(POISONOUS_AURORA_CATALYST, AuroraCatalystEntity.createAuroraCatalystAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("explosive_aurora_catalyst"), EXPLOSIVE_AURORA_CATALYST);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(EXPLOSIVE_AURORA_CATALYST, AuroraCatalystEntity.createAuroraCatalystAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("nature_core"), NATURE_CORE);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(NATURE_CORE, NatureCoreEntity.createNatureCoreAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("snail"), SNAIL);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(SNAIL, SnailEntity.createSnailAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("sunstradiver"), SUNSTRADIVER);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(SUNSTRADIVER, SunstradiverEntity.createSunstradiverAttributes());
		RegistrationUtils.registerEntityType(Archeon.createId("heifer"), HEIFER);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(HEIFER, HeiferEntity.createHeiferAttributes());
	}
}
