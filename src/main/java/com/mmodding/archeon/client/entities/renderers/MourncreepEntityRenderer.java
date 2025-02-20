package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.MourncreepEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.MourncreepEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.util.Identifier;

public class MourncreepEntityRenderer extends BipedEntityRenderer<MourncreepEntity, MourncreepEntityModel> {

	public MourncreepEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new MourncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOURNCREEP)), 0.5f);
		this.addFeature(new ArmorFeatureRenderer<>(this, new MourncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOURNCREEP_INNER_ARMOR)), new MourncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOURNCREEP_OUTER_ARMOR))));
	}

	@Override
	public Identifier getTexture(MourncreepEntity entity) {
		return switch (entity.getVariant()) {
			case BLUE_RAGS -> new TextureLocation(Archeon.id(), "entity/mourncreep/blue_rags");
			case BROWN_RAGS -> new TextureLocation(Archeon.id(), "entity/mourncreep/brown_rags");
			case GREEN_RAGS -> new TextureLocation(Archeon.id(), "entity/mourncreep/green_rags");
			case YELLOW_RAGS -> new TextureLocation(Archeon.id(), "entity/mourncreep/yellow_rags");
		};
	}
}
