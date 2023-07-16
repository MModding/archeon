package fr.firstmegagame4.archeon.client.entities.renderers;

import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.HeartOfNatureEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.HeartOfNatureEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HeartOfNatureEntityRenderer extends MobEntityRenderer<HeartOfNatureEntity, HeartOfNatureEntityModel> {

	public HeartOfNatureEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new HeartOfNatureEntityModel(context.getPart(ArcheonEntityModelLayers.HEART_OF_NATURE)), 0.5f);
	}

	@Override
	public Identifier getTexture(HeartOfNatureEntity entity) {
		return switch (entity.getPhase()) {
			case PETRIFIED -> Archeon.createId("textures/entities/petrified_heart_of_nature.png");
			case NORMAL -> Archeon.createId("textures/entities/heart_of_nature.png");
			case POISONOUS -> Archeon.createId("textures/entities/poisonous_heart_of_nature.png");
			case EXPLOSIVE -> Archeon.createId("textures/entities/explosive_heart_of_nature.png");
			case DEFEATED -> Archeon.createId("textures/entities/defeated_heart_of_nature.png");
		};
	}
}
