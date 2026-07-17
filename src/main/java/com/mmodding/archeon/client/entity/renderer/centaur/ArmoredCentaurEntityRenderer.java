package com.mmodding.archeon.client.entity.renderer.centaur;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entity.model.centaur.ArmoredCentaurEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entity.centaur.ArmoredCentaurEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class ArmoredCentaurEntityRenderer extends AbstractCentaurEntityRenderer<ArmoredCentaurEntity, ArmoredCentaurEntityModel> {

	public ArmoredCentaurEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ArmoredCentaurEntityModel(context.getPart(ArcheonEntityModelLayers.CENTAUR)), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(ArmoredCentaurEntity entity) {
		return new TextureLocation(Archeon.namespace(), "entity/centaur/armored");
	}
}
