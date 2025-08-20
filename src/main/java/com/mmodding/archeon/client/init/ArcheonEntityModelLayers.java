package com.mmodding.archeon.client.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.*;
import com.mmodding.archeon.client.entities.models.centaur.AbstractCentaurEntityModel;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ArcheonEntityModelLayers implements ClientElementsInitializer {

	public static final EntityModelLayer AURORA_CATALYST = new EntityModelLayer(Archeon.createId("aurora_catalyst"), "main");
	public static final EntityModelLayer HEART_OF_NATURE = new EntityModelLayer(Archeon.createId("heart_of_nature"), "main");
	public static final EntityModelLayer SNAIL = new EntityModelLayer(Archeon.createId("snail"), "main");
	public static final EntityModelLayer SUNSTRADIVER = new EntityModelLayer(Archeon.createId("sunstradiver"), "main");
	public static final EntityModelLayer HEIFER = new EntityModelLayer(Archeon.createId("heifer"), "main");
	public static final EntityModelLayer DEER = new EntityModelLayer(Archeon.createId("deer"), "main");
	public static final EntityModelLayer MOURNCREEP = new EntityModelLayer(Archeon.createId("mourncreep"), "main");
	public static final EntityModelLayer MOURNCREEP_INNER_ARMOR = new EntityModelLayer(Archeon.createId("mourncreep"), "inner_armor");
	public static final EntityModelLayer MOURNCREEP_OUTER_ARMOR = new EntityModelLayer(Archeon.createId("mourncreep"), "outer_armor");
	public static final EntityModelLayer MOURNCREEP_HEAD = new EntityModelLayer(Archeon.createId("mourncreep_head"), "main");
	public static final EntityModelLayer CENTAUR = new EntityModelLayer(Archeon.createId("centaur"), "main");

	@Override
	public void registerClient() {
		EntityModelLayerRegistry.registerModelLayer(AURORA_CATALYST, AuroraCatalystEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEART_OF_NATURE, HeartOfNatureEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SNAIL, SnailEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SUNSTRADIVER, SunstradiverEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HEIFER, HeiferEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(DEER, DeerEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOURNCREEP, MourncreepEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOURNCREEP_INNER_ARMOR, MourncreepEntityModel::getInnerArmorTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOURNCREEP_OUTER_ARMOR, MourncreepEntityModel::getOuterArmorTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MOURNCREEP_HEAD, MourncreepEntityModel::getHeadTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(CENTAUR, AbstractCentaurEntityModel::getTexturedModelData);
	}
}
