package fr.firstmegagame4.archeon.client.entities.renderers;

import com.mmodding.mmodding_lib.library.client.render.entity.feature.GlowingFeatureRenderer;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import fr.firstmegagame4.archeon.Archeon;
import fr.firstmegagame4.archeon.client.entities.models.HeartOfNatureEntityModel;
import fr.firstmegagame4.archeon.client.init.ArcheonEntityModelLayers;
import fr.firstmegagame4.archeon.entities.HeartOfNatureEntity;
import net.minecraft.client.render.RenderLayer;
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
		this.addFeature(new HeartOfNatureGlowingFeatureRenderer(this));
		this.addFeature(new HeartOfNatureShieldFeatureRenderer(this, context.getModelLoader()));
	}

	@Override
	public Identifier getTexture(HeartOfNatureEntity entity) {
		return switch (entity.getPhase()) {
			case PETRIFIED -> new TextureLocation(Archeon.id(), "entity/heart_of_nature/petrified_heart_of_nature");
			case NORMAL -> new TextureLocation(Archeon.id(), "entity/heart_of_nature/heart_of_nature");
			case POISONOUS -> new TextureLocation(Archeon.id(), "entity/heart_of_nature/poisonous_heart_of_nature");
			case EXPLOSIVE -> new TextureLocation(Archeon.id(), "entity/heart_of_nature/explosive_heart_of_nature");
			case DEFEATED -> new TextureLocation(Archeon.id(), "entity/heart_of_nature/defeated_heart_of_nature");
		};
	}

	public static class HeartOfNatureGlowingFeatureRenderer extends GlowingFeatureRenderer<HeartOfNatureEntity, HeartOfNatureEntityModel> {

		public HeartOfNatureGlowingFeatureRenderer(FeatureRendererContext<HeartOfNatureEntity, HeartOfNatureEntityModel> context) {
			super(context);
		}

		@Override
		public RenderLayer getGlowingLayer(HeartOfNatureEntity entity) {
			return RenderLayer.getEyes(this.getTexture(entity));
		}

		@Override
		public int getLight(HeartOfNatureEntity entity) {
			return 15728;
		}
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
			return new TextureLocation(Archeon.id(), "entity/heart_of_nature/heart_of_nature_shield");
		}

		@Override
		protected EntityModel<HeartOfNatureEntity> getEnergySwirlModel() {
			return this.model;
		}
	}
}
