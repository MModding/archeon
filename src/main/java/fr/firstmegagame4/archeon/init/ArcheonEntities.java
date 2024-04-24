package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.entities.CustomEntityType;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.entities.*;
import fr.firstmegagame4.archeon.entities.projectiles.LusonythArrowEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;

public class ArcheonEntities implements ElementsInitializer {

	public static final CustomEntityType<AuroraCatalystEntity> AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> POISONOUS_AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> EXPLOSIVE_AURORA_CATALYST = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<HeartOfNatureEntity> HEART_OF_NATURE = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(HeartOfNatureEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(HeartOfNatureEntity.createHeartOfNatureAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 2.0f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<SnailEntity> SNAIL = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(SnailEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SnailEntity.createSnailAttributes())
			.setDimensions(EntityDimensions.fixed(0.8f, 0.8f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<SunstradiverEntity> SUNSTRADIVER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(SunstradiverEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SunstradiverEntity.createSunstradiverAttributes())
			.setDimensions(EntityDimensions.fixed(0.5f, 0.9f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<HeiferEntity> HEIFER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(HeiferEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(HeiferEntity.createHeiferAttributes())
			.setDimensions(EntityDimensions.fixed(0.9f, 1.4f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<DeerEntity> DEER = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(DeerEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(DeerEntity.createDeerAttributes())
			.setDimensions(EntityDimensions.fixed(1.3f, 2.6f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<MouncreepEntity> MOUNCREEP = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(MouncreepEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(MouncreepEntity.createMouncreepAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.95f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<CentaurEntity> CENTAUR = CustomEntityType.createMob(
		builder -> builder
			.entityFactory(CentaurEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(CentaurEntity.createCentaurAttributes())
			.setDimensions(EntityDimensions.fixed(1.0f, 5.0f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<LusonythArrowEntity> LUSONYTH_ARROW = CustomEntityType.create(
		builder -> builder
			.entityFactory(LusonythArrowEntity::new)
			.spawnGroup(SpawnGroup.MISC)
			.setDimensions(EntityDimensions.fixed(0.5f, 0.5f))
			.maxChunkTrackingRange(4)
			.trackingTickInterval(20)
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
		MOUNCREEP.register(Archeon.createId("mouncreep"));
		CENTAUR.register(Archeon.createId("centaur"));
		LUSONYTH_ARROW.register(Archeon.createId("lusonyth_arrow"));
	}
}
