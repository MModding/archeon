package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.DeerEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.DeerEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DeerEntityRenderer extends MobEntityRenderer<DeerEntity, DeerEntityModel> {

	public DeerEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new DeerEntityModel(context.getPart(ArcheonEntityModelLayers.DEER)), 0.6f);
	}

	@Override
	public Identifier getTexture(DeerEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/deer");
	}
}
