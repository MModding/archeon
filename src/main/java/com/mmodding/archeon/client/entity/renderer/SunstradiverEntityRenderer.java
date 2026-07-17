package com.mmodding.archeon.client.entity.renderer;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entity.model.SunstradiverEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entity.SunstradiverEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SunstradiverEntityRenderer extends MobEntityRenderer<SunstradiverEntity, SunstradiverEntityModel> {

	public SunstradiverEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new SunstradiverEntityModel(context.getPart(ArcheonEntityModelLayers.SUNSTRADIVER)), 0.3f);
	}

	@Override
	public Identifier getTexture(SunstradiverEntity entity) {
		return new TextureLocation(Archeon.namespace(), "entity/sunstradiver");
	}

	public float getAnimationProgress(SunstradiverEntity sunstradiverEntity, float f) {
		float flapProgress = MathHelper.lerp(f, sunstradiverEntity.prevFlapProgress().getValue(), sunstradiverEntity.flapProgress().getValue());
		float wingDeviation = MathHelper.lerp(f, sunstradiverEntity.prevMaxWingDeviation().getValue(), sunstradiverEntity.maxWingDeviation().getValue());
		return (MathHelper.sin(flapProgress) + 1.0F) * wingDeviation;
	}
}
