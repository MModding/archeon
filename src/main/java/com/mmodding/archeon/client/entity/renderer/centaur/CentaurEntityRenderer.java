package com.mmodding.archeon.client.entity.renderer.centaur;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entity.model.centaur.CentaurEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entity.centaur.CentaurEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class CentaurEntityRenderer extends AbstractCentaurEntityRenderer<CentaurEntity, CentaurEntityModel> {

	public CentaurEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new CentaurEntityModel(context.getPart(ArcheonEntityModelLayers.CENTAUR)), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(CentaurEntity entity) {
		return new TextureLocation(Archeon.namespace(), "entity/centaur/main");
	}
}
