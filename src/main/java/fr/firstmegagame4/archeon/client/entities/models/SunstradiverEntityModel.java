package fr.firstmegagame4.archeon.client.entities.models;

import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.firstmegagame4.archeon.entities.SunstradiverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SunstradiverEntityModel extends EntityModel<SunstradiverEntity> {

	private final ModelPart bone;
	public SunstradiverEntityModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, 0.0F));

		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(0, 9).cuboid(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(19, 0).cuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -1.5F));

		ModelPartData feather = head.addChild("feather", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.5F, -1.0F, -0.2618F, 0.0F, 0.0F));
		feather.addChild("feather_r1", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, -13.0F, -0.5F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.5F, 2.5F, 0.2618F, 0.0F, 0.0F));

		ModelPartData left_wing = bone.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -2.1F, -2.8F));

		ModelPartData left_wing_rotation = left_wing.addChild("left_wing_rotation", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 2.5F, 2.0F, 0.0F, 3.1416F, 0.0F));
		left_wing_rotation.addChild("left_wing_rotation_r1", ModelPartBuilder.create().uv(14, 0).cuboid(-1.0F, -0.0949F, -1.5665F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.4F, 1.8F, -0.6981F, 0.0F, 0.0F));

		ModelPartData right_wing = bone.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -2.1F, -2.8F));

		ModelPartData right_wing_rotation = right_wing.addChild("right_wing_rotation", ModelPartBuilder.create(), ModelTransform.of(0.0F, 2.5F, 2.0F, 0.0F, 3.1416F, 0.0F));
		right_wing_rotation.addChild("right_wing_rotation_r1", ModelPartBuilder.create().uv(13, 13).cuboid(0.0F, -0.0949F, -1.5665F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.4F, 1.8F, -0.6981F, 0.0F, 0.0F));

		bone.addChild("left_leg", ModelPartBuilder.create().uv(12, 9).cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 2.0F, -1.0F));

		bone.addChild("right_leg", ModelPartBuilder.create().uv(0, 9).cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 2.0F, -1.0F));

		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.1F, -0.8F));
		tail.addChild("tail_r1", ModelPartBuilder.create().uv(18, 9).cuboid(-1.0F, -1.9F, 2.2F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.9F, 0.8F, 1.1781F, 0.0F, 0.0F));

		ModelPartData body = bone.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.5F, -1.0F));
		body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -8.5F, -1.5F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.5F, 1.0F, 0.3054F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(SunstradiverEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
