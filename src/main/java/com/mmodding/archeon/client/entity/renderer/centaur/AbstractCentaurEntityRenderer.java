package com.mmodding.archeon.client.entity.renderer.centaur;

import com.mmodding.archeon.client.entity.model.centaur.AbstractCentaurEntityModel;
import com.mmodding.archeon.entity.centaur.AbstractCentaurEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;

public abstract class AbstractCentaurEntityRenderer<T extends AbstractCentaurEntity, M extends AbstractCentaurEntityModel<T>> extends MobEntityRenderer<T, M> {

	public AbstractCentaurEntityRenderer(EntityRendererFactory.Context context, M entityModel, float f) {
		super(context, entityModel, f);
	}

	@Override
	protected void scale(AbstractCentaurEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.3f, 1.3f, 1.3f);
	}
}
