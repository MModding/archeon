package fr.firstmegagame4.archeon.client.entities.renderers;

import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.AuroraCatalystEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.AuroraCatalystEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AuroraCatalystEntityRenderer extends MobEntityRenderer<AuroraCatalystEntity, AuroraCatalystEntityModel> {

	private final AuroraCatalystEntity.Type type;

	public AuroraCatalystEntityRenderer(EntityRendererFactory.Context context, AuroraCatalystEntity.Type type) {
		super(context, new AuroraCatalystEntityModel(context.getPart(ArcheonEntityModelLayers.AURORA_CATALYST)), 0.5f);
		this.type = type;
	}

	@Override
	public Identifier getTexture(AuroraCatalystEntity entity) {
		return switch (this.type) {
			case NORMAL -> Archeon.createId("textures/entity/aurora_catalyst.png");
			case POISONOUS -> Archeon.createId("textures/entity/poisonous_aurora_catalyst.png");
			case EXPLOSIVE -> Archeon.createId("textures/entity/explosive_aurora_catalyst.png");
		};
	}
}
