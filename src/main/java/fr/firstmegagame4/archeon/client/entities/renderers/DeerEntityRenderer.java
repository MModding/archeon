package fr.firstmegagame4.archeon.client.entities.renderers;

import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.DeerEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.DeerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DeerEntityRenderer extends MobEntityRenderer<DeerEntity, DeerEntityModel> {

	public DeerEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new DeerEntityModel(context.getPart(ArcheonEntityModelLayers.DEER)), 0.6f);
	}

	@Override
	public Identifier getTexture(DeerEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/deer");
	}
}
