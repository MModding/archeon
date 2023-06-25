package fr.firstmegagame4.archeon.client.entities.renderers;

import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.HeiferEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.HeiferEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HeiferEntityRenderer extends MobEntityRenderer<HeiferEntity, HeiferEntityModel> {

	public HeiferEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new HeiferEntityModel(context.getPart(ArcheonEntityModelLayers.HEIFER)), 0.7f);
	}

	@Override
	public Identifier getTexture(HeiferEntity entity) {
		return Archeon.createId("textures/entities/heifer.png");
	}
}
