package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.entities.MourncreepEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.*;

public class MourncreepEntityModel extends ZombieEntityModel<MourncreepEntity> {

	public MourncreepEntityModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		return TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE, 0.0f), 64, 64);
	}

	public static TexturedModelData getInnerArmorTexturedModelData() {
		return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5f), 0.0f), 64, 32);
	}

	public static TexturedModelData getOuterArmorTexturedModelData() {
		return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0f), 0.0f), 64, 32);
	}

	public static TexturedModelData getHeadTexturedModelData() {
		return SkullEntityModel.getHeadTexturedModelData();
	}

	@Override
	public void setAngles(MourncreepEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
	}
}
