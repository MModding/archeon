package com.mmodding.archeon.client.entity.renderer;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.entity.projectiles.LusonythArrowEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class LusonythArrowEntityRenderer extends ProjectileEntityRenderer<LusonythArrowEntity> {

	public LusonythArrowEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(LusonythArrowEntity entity) {
		return new TextureLocation(Archeon.namespace(), "entity/projectiles/lusonyth_arrow");
	}
}
