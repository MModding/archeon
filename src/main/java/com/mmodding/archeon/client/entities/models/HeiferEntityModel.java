package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.entities.HeiferEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

// Originally Made with Blockbench 4.9.0
@SuppressWarnings("unused")
public class HeiferEntityModel extends QuadrupedEntityModel<HeiferEntity> {

	public HeiferEntityModel(ModelPart root) {
		super(root, false, 10.0f, 4.0f, 2.0f, 2.0f, 24);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-6.0f, -7.5f, -9.75f, 12.0f, 13.0f, 20.0f, new Dilation(0.0f))
			.uv(64, 21).cuboid(-6.0f, 5.5f, -9.75f, 12.0f, 3.0f, 0.0f, new Dilation(0.0f))
			.uv(64, 24).cuboid(-6.0f, 5.5f, 10.26f, 12.0f, 3.0f, 0.0f, new Dilation(0.0f))
			.uv(0, 33).cuboid(6.0f, 5.5f, -9.75f, 0.0f, 3.0f, 20.0f, new Dilation(0.0f))
			.uv(40, 33).cuboid(-6.0f, 5.5f, -9.75f, 0.0f, 3.0f, 20.0f, new Dilation(0.0f))
			.uv(64, 14).cuboid(-2.0f, 5.5f, 4.25f, 4.0f, 1.0f, 6.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 8.5f, 0.75f));

		ModelPartData head = modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 56).cuboid(-4.0f, -4.0f, -6.0f, 8.0f, 10.0f, 6.0f, new Dilation(0.0f))
			.uv(64, 27).cuboid(-3.0f, 1.0f, -7.0f, 6.0f, 4.0f, 1.0f, new Dilation(0.0f))
			.uv(28, 70).cuboid(5.0f, -7.0f, -5.0f, 2.0f, 5.0f, 2.0f, new Dilation(0.0f))
			.uv(44, 70).cuboid(4.0f, -4.0f, -5.0f, 1.0f, 2.0f, 2.0f, new Dilation(0.0f))
			.uv(50, 70).cuboid(-5.0f, -4.0f, -5.0f, 1.0f, 2.0f, 2.0f, new Dilation(0.0f))
			.uv(36, 70).cuboid(-7.0f, -7.0f, -5.0f, 2.0f, 5.0f, 2.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 4.0f, -8.0f));

		ModelPartData leftFrontLeg = modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(60, 56).cuboid(-2.01f, 0.0f, -2.0f, 4.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(4.0f, 14.0f, -5.0f));
		ModelPartData rightFrontLeg = modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(64, 0).cuboid(-1.99f, 0.0f, -2.0f, 4.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(-4.0f, 14.0f, -5.0f));
		ModelPartData leftHindLeg = modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(28, 56).cuboid(-2.01f, 0.0f, -2.01f, 4.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(4.0f, 14.0f, 8.0f));
		ModelPartData rightHindLeg = modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(44, 56).cuboid(-1.99f, 0.0f, -2.01f, 4.0f, 10.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(-4.0f, 14.0f, 8.0f));

		return TexturedModelData.of(modelData, 128, 128);
	}
}
