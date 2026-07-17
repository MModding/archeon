package com.mmodding.archeon.client.entity.renderer;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entity.model.HeiferEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entity.HeiferEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HeiferEntityRenderer extends MobEntityRenderer<HeiferEntity, HeiferEntityModel> {

	public HeiferEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new HeiferEntityModel(context.getPart(ArcheonEntityModelLayers.HEIFER)), 0.7f);
	}

	@Override
	public Identifier getTexture(HeiferEntity entity) {
		return new TextureLocation(Archeon.namespace(), "entity/heifer");
	}
}
