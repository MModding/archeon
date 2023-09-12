package fr.firstmegagame4.archeon.client.entities.renderers;

import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.SnailEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.SnailEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SnailEntityRenderer extends MobEntityRenderer<SnailEntity, SnailEntityModel> {

	public SnailEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new SnailEntityModel(context.getPart(ArcheonEntityModelLayers.SNAIL)), 0.5f);
	}

	@Override
	public Identifier getTexture(SnailEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/snail");
	}
}
