package com.mmodding.archeon.client.init;

import com.mmodding.archeon.client.entities.renderers.*;
import com.mmodding.archeon.entities.AuroraCatalystEntity;
import com.mmodding.archeon.entities.CentaurSpearEntity;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.client.render.entity.renderer.SpearItemEntityRenderer;
import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ArcheonEntityRenderers implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		EntityRendererRegistry.register(ArcheonEntities.AURORA_CATALYST, ctx -> new AuroraCatalystEntityRenderer(ctx, AuroraCatalystEntity.Type.NORMAL));
		EntityRendererRegistry.register(ArcheonEntities.POISONOUS_AURORA_CATALYST, ctx -> new AuroraCatalystEntityRenderer(ctx, AuroraCatalystEntity.Type.POISONOUS));
		EntityRendererRegistry.register(ArcheonEntities.EXPLOSIVE_AURORA_CATALYST, ctx -> new AuroraCatalystEntityRenderer(ctx, AuroraCatalystEntity.Type.EXPLOSIVE));
		EntityRendererRegistry.register(ArcheonEntities.HEART_OF_NATURE, HeartOfNatureEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.SNAIL, SnailEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.SUNSTRADIVER, SunstradiverEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.HEIFER, HeiferEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.DEER, DeerEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.MOURNCREEP, MourncreepEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.CENTAUR, CentaurEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.ARMORED_CENTAUR, CentaurEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.LUSONYTH_ARROW, LusonythArrowEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.CENTAUR_SPEAR, SpearItemEntityRenderer<CentaurSpearEntity>::new);
	}
}
