package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import com.mmodding.mmodding_lib.library.utils.RegistrationUtils;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.entities.SnailEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class ArcheonEntities implements ElementsInitializer {

	public static final EntityType<SnailEntity> SNAIL = QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new)
		.setDimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.maxChunkTrackingRange(8)
		.build();

	@Override
	public void register() {
		RegistrationUtils.registerEntityType(Archeon.createId("snail"), SNAIL);
		DefaultAttributeRegistry.DEFAULT_ATTRIBUTE_REGISTRY.put(SNAIL, SnailEntity.createSnailAttributes());
	}
}
