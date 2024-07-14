package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.CentaurEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.CentaurEntity;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CentaurEntityRenderer extends MobEntityRenderer<CentaurEntity, CentaurEntityModel> {

	public CentaurEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new CentaurEntityModel(context.getPart(ArcheonEntityModelLayers.CENTAUR)), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(CentaurEntity entity) {
		String texture = entity.getType().equals(ArcheonEntities.ARMORED_CENTAUR) ? "armored" : "main";
		return new TextureLocation(Archeon.id(), "entity/centaur/" + texture);
	}

	@Override
	protected void scale(CentaurEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.3f, 1.3f, 1.3f);
	}
}
