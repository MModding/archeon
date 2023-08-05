package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.entities.CustomEntityType;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.entities.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class ArcheonEntities implements ElementsInitializer {

	public static final CustomEntityType<AuroraCatalystEntity> AURORA_CATALYST = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> POISONOUS_AURORA_CATALYST = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<AuroraCatalystEntity> EXPLOSIVE_AURORA_CATALYST = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(AuroraCatalystEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(AuroraCatalystEntity.createAuroraCatalystAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<HeartOfNatureEntity> HEART_OF_NATURE = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(HeartOfNatureEntity::new)
			.spawnGroup(SpawnGroup.MONSTER)
			.defaultAttributes(HeartOfNatureEntity.createHeartOfNatureAttributes())
			.setDimensions(EntityDimensions.fixed(0.6f, 2.0f))
			.makeFireImmune()
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<SnailEntity> SNAIL = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(SnailEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SnailEntity.createSnailAttributes())
			.setDimensions(EntityDimensions.fixed(0.8f, 0.8f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<SunstradiverEntity> SUNSTRADIVER = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(SunstradiverEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(SunstradiverEntity.createSunstradiverAttributes())
			.setDimensions(EntityDimensions.fixed(0.5f, 0.9f))
			.maxChunkTrackingRange(8)
	);

	public static final CustomEntityType<HeiferEntity> HEIFER = CustomEntityType.create(
		QuiltEntityTypeBuilder.createMob()
			.entityFactory(HeiferEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(HeiferEntity.createHeiferAttributes())
			.setDimensions(EntityDimensions.fixed(0.9f, 1.4f))
			.maxChunkTrackingRange(8)
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
	}
}
