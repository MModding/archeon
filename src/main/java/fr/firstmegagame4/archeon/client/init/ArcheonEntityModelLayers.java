package fr.firstmegagame4.archeon.client.init;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ArcheonEntityModelLayers implements ClientElementsInitializer {

	public static final EntityModelLayer AURORA_CATALYST = new EntityModelLayer(Archeon.createId("aurora_catalyst"), "main");
	public static final EntityModelLayer HEART_OF_NATURE = new EntityModelLayer(Archeon.createId("heart_of_nature"), "main");
	public static final EntityModelLayer SNAIL = new EntityModelLayer(Archeon.createId("snail"), "main");
	public static final EntityModelLayer SUNSTRADIVER = new EntityModelLayer(Archeon.createId("sunstradiver"), "main");
	public static final EntityModelLayer HEIFER = new EntityModelLayer(Archeon.createId("heifer"), "main");

	@Override
	public void registerClient() {
		EntityModelLayerRegistry.registerModelLayer(AURORA_CATALYST, AuroraCatalystEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEART_OF_NATURE, HeartOfNatureEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SNAIL, SnailEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SUNSTRADIVER, SunstradiverEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEIFER, HeiferEntityModel::getTexturedModelData);
	}
}
