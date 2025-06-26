package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.entities.*;
import com.mmodding.archeon.entities.projectiles.LusonythArrowEntity;
import com.mmodding.mmodding_lib.library.entities.CustomEntityType;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class ArcheonEntities implements ElementsInitializer {

	public static final CustomEntityType<AuroraCatalystEntity> AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
			.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.fireImmune()
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> POISONOUS_AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
			.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.fireImmune()
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> EXPLOSIVE_AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity::createAuroraCatalystAttributes)
			.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.fireImmune()
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<HeartOfNatureEntity> HEART_OF_NATURE = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(HeartOfNatureEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(HeartOfNatureEntity::createHeartOfNatureAttributes)
			.dimensions(EntityDimensions.fixed(0.6f, 2.0f))
			.fireImmune()
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<SnailEntity> SNAIL = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(SnailEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SnailEntity::createSnailAttributes)
			.dimensions(EntityDimensions.fixed(0.8f, 0.8f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<SunstradiverEntity> SUNSTRADIVER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(SunstradiverEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SunstradiverEntity::createSunstradiverAttributes)
			.dimensions(EntityDimensions.fixed(0.5f, 0.9f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<HeiferEntity> HEIFER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(HeiferEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(HeiferEntity::createHeiferAttributes)
			.dimensions(EntityDimensions.fixed(0.9f, 1.4f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<DeerEntity> DEER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(DeerEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(DeerEntity::createDeerAttributes)
			.dimensions(EntityDimensions.fixed(1.3f, 2.6f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<MourncreepEntity> MOURNCREEP = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(MourncreepEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(MourncreepEntity::createMourncreepAttributes)
			.dimensions(EntityDimensions.changing(0.6f, 1.95f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<CentaurEntity> CENTAUR = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(CentaurEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(CentaurEntity::createCentaurAttributes)
			.dimensions(EntityDimensions.fixed(1.75f, 3.5f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<CentaurEntity> ARMORED_CENTAUR = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(CentaurEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(CentaurEntity::createCentaurAttributes)
			.dimensions(EntityDimensions.fixed(1.75f, 3.5f))
			.trackRangeChunks(8)
	);

	public static final CustomEntityType<LusonythArrowEntity> LUSONYTH_ARROW = CustomEntityType.create(
		builder -> builder
			.entityFactory(LusonythArrowEntity::new)
			.spawnGroup(SpawnGroup.MISC)
			.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
			.trackRangeChunks(4)
			.trackedUpdateRate(20)
	);

	public static final CustomEntityType<CentaurSpearEntity> CENTAUR_SPEAR = CustomEntityType.create(
		builder -> builder
			.entityFactory(CentaurSpearEntity::new)
			.spawnGroup(SpawnGroup.MISC)
			.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
			.trackRangeChunks(4)
			.trackedUpdateRate(20)
	);

	@Override
	public void register() {
		AURORA_CATALYST.register(Archeon.createId("aurora_catalyst"));
		POISONOUS_AURORA_CATALYST.register(Archeon.createId("poisonous_aurora_catalyst"));
		EXPLOSIVE_AURORA_CATALYST.register(Archeon.createId("explosive_aurora_catalyst"));
		HEART_OF_NATURE.register(Archeon.createId("heart_of_nature"));
		SNAIL.register(Archeon.createId("snail"));
		SUNSTRADIVER.register(Archeon.createId("sunstradiver"));
		HEIFER.register(Archeon.createId("heifer"));
		DEER.register(Archeon.createId("deer"));
		MOURNCREEP.register(Archeon.createId("mourncreep"));
		CENTAUR.register(Archeon.createId("centaur"));
		ARMORED_CENTAUR.register(Archeon.createId("armored_centaur"));
		LUSONYTH_ARROW.register(Archeon.createId("lusonyth_arrow"));
		CENTAUR_SPEAR.register(Archeon.createId("centaur_spear"));

		SpawnRestriction.register(SNAIL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnailEntity::isValidNaturalSpawn);
		SpawnRestriction.register(SUNSTRADIVER, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SunstradiverEntity::canSpawn);
		SpawnRestriction.register(HEIFER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HeiferEntity::isValidNaturalSpawn);
		SpawnRestriction.register(DEER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DeerEntity::isValidNaturalSpawn);
		SpawnRestriction.register(MOURNCREEP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MourncreepEntity::canSpawnInDark);
	}
}
