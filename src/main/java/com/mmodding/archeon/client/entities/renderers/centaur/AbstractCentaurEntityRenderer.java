package com.mmodding.archeon.client.entities.renderers.centaur;

import com.mmodding.archeon.client.entities.models.centaur.AbstractCentaurEntityModel;
import com.mmodding.archeon.entities.centaur.AbstractCentaurEntity;
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
