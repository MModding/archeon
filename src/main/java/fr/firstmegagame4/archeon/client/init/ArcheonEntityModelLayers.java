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
	public static final EntityModelLayer DEER = new EntityModelLayer(Archeon.createId("deer"), "main");
	public static final EntityModelLayer MOUNCREEP = new EntityModelLayer(Archeon.createId("mouncreep"), "main");
	public static final EntityModelLayer MOUNCREEP_INNER_ARMOR = new EntityModelLayer(Archeon.createId("mouncreep"), "inner_armor");
	public static final EntityModelLayer MOUNCREEP_OUTER_ARMOR = new EntityModelLayer(Archeon.createId("mouncreep"), "outer_armor");
	public static final EntityModelLayer MOUNCREEP_HEAD = new EntityModelLayer(Archeon.createId("mouncreep_head"), "main");
	public static final EntityModelLayer CENTAUR = new EntityModelLayer(Archeon.createId("centaur"), "main");

	@Override
	public void registerClient() {
		EntityModelLayerRegistry.registerModelLayer(AURORA_CATALYST, AuroraCatalystEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEART_OF_NATURE, HeartOfNatureEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SNAIL, SnailEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SUNSTRADIVER, SunstradiverEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEIFER, HeiferEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(DEER, DeerEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOUNCREEP, MouncreepEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOUNCREEP_INNER_ARMOR, MouncreepEntityModel::getInnerArmorTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOUNCREEP_OUTER_ARMOR, MouncreepEntityModel::getOuterArmorTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOUNCREEP_HEAD, MouncreepEntityModel::getHeadTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(CENTAUR, CentaurEntityModel::getTexturedModelData);
	}
}
