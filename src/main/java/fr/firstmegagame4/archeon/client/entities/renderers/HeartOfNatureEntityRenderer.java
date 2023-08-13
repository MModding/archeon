package fr.firstmegagame4.archeon.client.entities.renderers;

import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.HeartOfNatureEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.HeartOfNatureEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class HeartOfNatureEntityRenderer extends MobEntityRenderer<HeartOfNatureEntity, HeartOfNatureEntityModel> {

	public HeartOfNatureEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new HeartOfNatureEntityModel(context.getPart(ArcheonEntityModelLayers.HEART_OF_NATURE)), 0.5f);
		this.addFeature(new HeartOfNatureShieldFeatureRenderer(this, context.getModelLoader()));
	}

	@Override
	public Identifier getTexture(HeartOfNatureEntity entity) {
		return switch (entity.getPhase()) {
			case PETRIFIED -> Archeon.createId("textures/entity/heart_of_nature/petrified_heart_of_nature.png");
			case NORMAL -> Archeon.createId("textures/entity/heart_of_nature/heart_of_nature.png");
			case POISONOUS -> Archeon.createId("textures/entity/heart_of_nature/poisonous_heart_of_nature.png");
			case EXPLOSIVE -> Archeon.createId("textures/entity/heart_of_nature/explosive_heart_of_nature.png");
			case DEFEATED -> Archeon.createId("textures/entity/heart_of_nature/defeated_heart_of_nature.png");
		};
	}

	public static class HeartOfNatureShieldFeatureRenderer extends EnergySwirlOverlayFeatureRenderer<HeartOfNatureEntity, HeartOfNatureEntityModel> {

		private final HeartOfNatureEntityModel model;

		public HeartOfNatureShieldFeatureRenderer(FeatureRendererContext<HeartOfNatureEntity, HeartOfNatureEntityModel> context, EntityModelLoader loader) {
			super(context);
			this.model = new HeartOfNatureEntityModel(loader.getModelPart(ArcheonEntityModelLayers.HEART_OF_NATURE));
		}

		@Override
		protected float getEnergySwirlOffsetX(float partialAge) {
			return MathHelper.cos(partialAge * 0.02F) * 3.0F;
		}

		@Override
		protected Identifier getEnergySwirlTexture() {
			return Archeon.createId("textures/entity/heart_of_nature/heart_of_nature_shield.png");
		}

		@Override
		protected EntityModel<HeartOfNatureEntity> getEnergySwirlModel() {
			return this.model;
		}
	}
}
