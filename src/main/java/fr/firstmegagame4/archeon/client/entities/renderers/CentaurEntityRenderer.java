package fr.firstmegagame4.archeon.client.entities.renderers;

import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.CentaurEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.CentaurEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CentaurEntityRenderer extends MobEntityRenderer<CentaurEntity, CentaurEntityModel> {

	public CentaurEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new CentaurEntityModel(context.getPart(ArcheonEntityModelLayers.CENTAUR)), 0.5f);
	}

	@Override
	public Identifier getTexture(CentaurEntity entity) {
		return new TextureLocation(Archeon.id(), "entity/centaur/main");
	}

	@Override
	protected void scale(CentaurEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.3f, 1.3f, 1.3f);
	}
}
