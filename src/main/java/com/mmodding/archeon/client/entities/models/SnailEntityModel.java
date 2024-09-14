package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.entities.SnailEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SnailEntityModel extends EntityModel<SnailEntity> {

	private final ModelPart bone;

	public SnailEntityModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 20).cuboid(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		bone.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -8.0F, -4.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 0).cuboid(1.0F, -8.0F, -4.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		bone.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -12.0F, -4.0F, 6.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
