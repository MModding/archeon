package com.mmodding.archeon.init;

import com.mmodding.archeon.entity.*;
import com.mmodding.archeon.entity.centaur.ArmoredCentaurEntity;
import com.mmodding.archeon.entity.centaur.CentaurEntity;
import com.mmodding.archeon.entity.projectile.LusonythArrowEntity;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.Registries;
import net.minecraft.world.Heightmap;

public class ArcheonEntities {

	public static final EntityType<AuroraCatalystEntity> AURORA_CATALYST = FabricEntityTypeBuilder.createMob()
		.entityFactory(AuroraCatalystEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
		.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.fireImmune()
		.trackRangeChunks(8)
		.build();

	public static final EntityType<AuroraCatalystEntity> POISONOUS_AURORA_CATALYST = FabricEntityTypeBuilder.createMob()
		.entityFactory(AuroraCatalystEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
		.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.fireImmune()
		.trackRangeChunks(8)
		.build();

	public static final EntityType<AuroraCatalystEntity> EXPLOSIVE_AURORA_CATALYST = FabricEntityTypeBuilder.createMob()
		.entityFactory(AuroraCatalystEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
		.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.fireImmune()
		.trackRangeChunks(8)
		.build();

	public static final EntityType<HeartOfNatureEntity> HEART_OF_NATURE = FabricEntityTypeBuilder.createMob()
		.entityFactory(HeartOfNatureEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(HeartOfNatureEntity::createHeartOfNatureAttributes)
		.dimensions(EntityDimensions.fixed(0.6f, 2.0f))
		.fireImmune()
		.trackRangeChunks(8)
		.build();

	public static final EntityType<SnailEntity> SNAIL = FabricEntityTypeBuilder.createMob()
		.entityFactory(SnailEntity::new)
		.spawnGroup(SpawnGroup.CREATURE)
		.defaultAttributes(SnailEntity::createSnailAttributes)
		.dimensions(EntityDimensions.fixed(0.8f, 0.8f))
		.trackRangeChunks(8)
		.build();

	public static final EntityType<SunstradiverEntity> SUNSTRADIVER = FabricEntityTypeBuilder.createMob()
		.entityFactory(SunstradiverEntity::new)
		.spawnGroup(SpawnGroup.CREATURE)
		.defaultAttributes(SunstradiverEntity::createSunstradiverAttributes)
		.dimensions(EntityDimensions.fixed(0.5f, 0.9f))
		.trackRangeChunks(8)
		.build();

	public static final EntityType<HeiferEntity> HEIFER = FabricEntityTypeBuilder.createMob()
		.entityFactory(HeiferEntity::new)
		.spawnGroup(SpawnGroup.CREATURE)
		.defaultAttributes(HeiferEntity::createHeiferAttributes)
		.dimensions(EntityDimensions.fixed(0.9f, 1.4f))
		.trackRangeChunks(8)
		.build();

	public static final EntityType<DeerEntity> DEER = FabricEntityTypeBuilder.createMob()
		.entityFactory(DeerEntity::new)
		.spawnGroup(SpawnGroup.CREATURE)
		.defaultAttributes(DeerEntity::createDeerAttributes)
		.dimensions(EntityDimensions.fixed(1.3f, 2.6f))
		.trackRangeChunks(8)
		.build();

	public static final EntityType<MourncreepEntity> MOURNCREEP = FabricEntityTypeBuilder.createMob()
		.entityFactory(MourncreepEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(MourncreepEntity::createMourncreepAttributes)
		.dimensions(EntityDimensions.changing(0.6f, 1.95f))
		.trackRangeChunks(8)
		.build();

	public static final EntityType<CentaurEntity> CENTAUR = FabricEntityTypeBuilder.createMob()
		.entityFactory(CentaurEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(CentaurEntity::createCentaurAttributes)
		.dimensions(EntityDimensions.fixed(1.75f, 3.5f))
		.trackRangeChunks(8)
		.forceTrackedVelocityUpdates(true) // without that velocity is not updated properly, which fucks the animation system
		.build();

	public static final EntityType<ArmoredCentaurEntity> ARMORED_CENTAUR = FabricEntityTypeBuilder.createMob()
		.entityFactory(ArmoredCentaurEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.defaultAttributes(ArmoredCentaurEntity::createCentaurAttributes)
		.dimensions(EntityDimensions.fixed(1.75f, 3.5f))
		.trackRangeChunks(8)
		.forceTrackedVelocityUpdates(true)
		.build();

	public static final EntityType<LusonythArrowEntity> LUSONYTH_ARROW = FabricEntityTypeBuilder.create()
		.entityFactory(LusonythArrowEntity::new)
		.spawnGroup(SpawnGroup.MISC)
		.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
		.trackRangeChunks(4)
		.trackedUpdateRate(20)
		.build();

	public static final EntityType<CentaurSpearEntity> CENTAUR_SPEAR = FabricEntityTypeBuilder.create()
		.entityFactory(CentaurSpearEntity::new)
		.spawnGroup(SpawnGroup.MISC)
		.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
		.trackRangeChunks(4)
		.trackedUpdateRate(20)
		.build();

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.ENTITY_TYPE, factory -> {
			factory.register("aurora_catalyst", AURORA_CATALYST);
			factory.register("poisonous_aurora_catalyst", POISONOUS_AURORA_CATALYST);
			factory.register("explosive_aurora_catalyst", EXPLOSIVE_AURORA_CATALYST);
			factory.register("heart_of_nature", HEART_OF_NATURE);
			factory.register("snail", SNAIL);
			factory.register("sunstradiver", SUNSTRADIVER);
			factory.register("heifer", HEIFER);
			factory.register("deer", DEER);
			factory.register("mourncreep", MOURNCREEP);
			factory.register("centaur", CENTAUR);
			factory.register("armored_centaur", ARMORED_CENTAUR);
			factory.register("lusonyth_arrow", LUSONYTH_ARROW);
			factory.register("centaur_spear", CENTAUR_SPEAR);
		});

		SpawnRestriction.register(SNAIL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnailEntity::isValidNaturalSpawn);
		SpawnRestriction.register(SUNSTRADIVER, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SunstradiverEntity::canSpawn);
		SpawnRestriction.register(HEIFER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HeiferEntity::isValidNaturalSpawn);
		SpawnRestriction.register(DEER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DeerEntity::isValidNaturalSpawn);
		SpawnRestriction.register(MOURNCREEP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MourncreepEntity::canSpawnInDark);
	}
}
