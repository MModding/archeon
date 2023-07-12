package fr.firstmegagame4.archeon.client.entities.renderers;

import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.NatureCoreEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.NatureCoreEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NatureCoreEntityRenderer extends MobEntityRenderer<NatureCoreEntity, NatureCoreEntityModel> {

	public NatureCoreEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new NatureCoreEntityModel(context.getPart(ArcheonEntityModelLayers.NATURE_CORE)), 0.5f);
	}

	@Override
	public Identifier getTexture(NatureCoreEntity entity) {
		return switch (entity.getPhase()) {
			case PETRIFIED -> Archeon.createId("textures/entities/petrified_nature_core.png");
			case NORMAL -> Archeon.createId("textures/entities/nature_core.png");
			case POISONOUS -> Archeon.createId("textures/entities/poisonous_nature_core.png");
			case EXPLOSIVE -> Archeon.createId("textures/entities/explosive_nature_core.png");
			case DEFEATED -> Archeon.createId("textures/entities/defeated_nature_core.png");
		};
	}
}
