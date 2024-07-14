package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.SnailEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.SnailEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SnailEntityRenderer extends MobEntityRenderer<SnailEntity, SnailEntityModel> {

	public SnailEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new SnailEntityModel(context.getPart(ArcheonEntityModelLayers.SNAIL)), 0.5f);
	}

	@Override
	public Identifier getTexture(SnailEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/snail");
	}
}
