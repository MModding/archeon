package fr.firstmegagame4.archeon.client.entities.renderers;

import com.mmodding.mmodding_lib.library.utils.TextureLocation;
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
			case NORMAL -> new TextureLocation(Archeon.id(), "entity/aurora_catalyst");
			case POISONOUS -> new TextureLocation(Archeon.id(), "entity/poisonous_aurora_catalyst");
			case EXPLOSIVE -> new TextureLocation(Archeon.id(), "entity/explosive_aurora_catalyst");
		};
	}
}
