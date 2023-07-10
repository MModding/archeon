package fr.firstmegagame4.archeon.client.init;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.client.entities.renderers.AuroraEntityRenderer;
import fr.firstmegagame4.archeon.client.entities.renderers.HeiferEntityRenderer;
import fr.firstmegagame4.archeon.client.entities.renderers.SnailEntityRenderer;
import fr.firstmegagame4.archeon.client.entities.renderers.SunstradiverEntityRenderer;
import fr.firstmegagame4.archeon.entities.AuroraCatalystEntity;
import fr.firstmegagame4.archeon.init.ArcheonEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ArcheonEntityRenderers implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		EntityRendererRegistry.register(ArcheonEntities.AURORA_CATALYST, ctx -> new AuroraEntityRenderer(ctx, AuroraCatalystEntity.Type.NORMAL));
		EntityRendererRegistry.register(ArcheonEntities.POISONOUS_AURORA_CATALYST, ctx -> new AuroraEntityRenderer(ctx, AuroraCatalystEntity.Type.POISONOUS));
		EntityRendererRegistry.register(ArcheonEntities.EXPLOSIVE_AURORA_CATALYST, ctx -> new AuroraEntityRenderer(ctx, AuroraCatalystEntity.Type.EXPLOSIVE));
		EntityRendererRegistry.register(ArcheonEntities.SNAIL, SnailEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.SUNSTRADIVER, SunstradiverEntityRenderer::new);
		EntityRendererRegistry.register(ArcheonEntities.HEIFER, HeiferEntityRenderer::new);
	}
}
