package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.SunstradiverEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.SunstradiverEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SunstradiverEntityRenderer extends MobEntityRenderer<SunstradiverEntity, SunstradiverEntityModel> {

	public SunstradiverEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new SunstradiverEntityModel(context.getPart(ArcheonEntityModelLayers.SUNSTRADIVER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SunstradiverEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/sunstradiver");
	}

	public float getAnimationProgress(SunstradiverEntity parrotEntity, float f) {
		float flapProgress = MathHelper.lerp(f, parrotEntity.prevFlapProgress().getValue(), parrotEntity.flapProgress().getValue());
		float wingDeviation = MathHelper.lerp(f, parrotEntity.prevMaxWingDeviation().getValue(), parrotEntity.maxWingDeviation().getValue());
		return (MathHelper.sin(flapProgress) + 1.0F) * wingDeviation;
	}
}
