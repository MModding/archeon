package com.mmodding.archeon.client.entities.renderers;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.client.entities.models.MouncreepEntityModel;
import com.mmodding.archeon.client.init.ArcheonEntityModelLayers;
import com.mmodding.archeon.entities.MouncreepEntity;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.util.Identifier;

public class MouncreepEntityRenderer extends BipedEntityRenderer<MouncreepEntity, MouncreepEntityModel> {

	public MouncreepEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new MouncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOUNCREEP)), 0.5f);
		this.addFeature(new ArmorFeatureRenderer<>(this, new MouncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOUNCREEP_INNER_ARMOR)), new MouncreepEntityModel(context.getPart(ArcheonEntityModelLayers.MOUNCREEP_OUTER_ARMOR))));
	}

	@Override
	public Identifier getTexture(MouncreepEntity entity) {
		return switch (entity.getVariant()) {
			case BLUE_RAGS -> new TextureLocation(Archeon.id(), "entity/mouncreep/blue_rags");
			case BROWN_RAGS -> new TextureLocation(Archeon.id(), "entity/mouncreep/brown_rags");
			case GREEN_RAGS -> new TextureLocation(Archeon.id(), "entity/mouncreep/green_rags");
			case YELLOW_RAGS -> new TextureLocation(Archeon.id(), "entity/mouncreep/yellow_rags");
		};
	}
}
