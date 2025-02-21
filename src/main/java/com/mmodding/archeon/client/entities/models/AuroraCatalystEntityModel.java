package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.entities.AuroraCatalystEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AuroraCatalystEntityModel extends EntityModel<AuroraCatalystEntity> {

	private final ModelPart bone;
	private final ModelPart upper_shields;
	private final ModelPart bottom_shields;

	public AuroraCatalystEntityModel(ModelPart root) {
		this.bone = root.getChild(EntityModelPartNames.BONE);
		this.upper_shields = this.bone.getChild("upper_shields");
		this.bottom_shields = this.bone.getChild("bottom_shields");
	}

	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild(
			EntityModelPartNames.BONE,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0f, 24.0f, 0.0f)
		);

		bone.addChild(
			"center",
			ModelPartBuilder.create()
				.uv(0, 0)
				.cuboid(-1.0f, -8.0f, -1.0f, 2.0f, 16.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.pivot(0.0f, -10.0f, 0.0f)
		);

		ModelPartData upper_shields = bone.addChild(
			"upper_shields",
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0f, -15.0f, 0.0f)
		);

		ModelPartData shields3 = upper_shields.addChild(
			"shields3",
			ModelPartBuilder.create()
				.uv(26, 13)
				.cuboid(1.0f, -8.0f, -1.0f, 1.0f, 4.0f, 2.0f, new Dilation(0.0f))
				.uv(22, 9)
				.cuboid(-2.0f, -8.0f, -1.0f, 1.0f, 4.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 7.0f, 0.0f, 0.0f, -1.5708f, 0.0f)
		);

		shields3.addChild(
			"cube_r1",
			ModelPartBuilder.create()
				.uv(22, 20)
				.cuboid(1.0f, -8.0f, -1.0f, 1.0f, 4.0f, 2.0f, new Dilation(0.0f))
				.uv(22, 26)
				.cuboid(-2.0f, -8.0f, -1.0f, 1.0f, 4.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.0f)
		);

		ModelPartData bottom_shields = bone.addChild(
			"bottom_shields",
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0f, -11.0f, 0.0f)
		);

		ModelPartData shields1 = bottom_shields.addChild(
			"shields1",
			ModelPartBuilder.create()
				.uv(6, 16)
				.cuboid(2.0f, -15.0f, -1.0f, 1.0f, 11.0f, 2.0f, new Dilation(0.0f))
				.uv(16, 0)
				.cuboid(-3.0f, -15.0f, -1.0f, 1.0f, 11.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 11.0f, 0.0f, 0.0f, -0.7854f, 0.0f)
		);

		shields1.addChild(
			"cube_r2",
			ModelPartBuilder.create()
				.uv(8, 0)
				.cuboid(2.0f, -14.0f, -1.0f, 1.0f, 11.0f, 2.0f, new Dilation(0.0f))
				.uv(12, 11)
				.cuboid(-3.0f, -14.0f, -1.0f, 1.0f, 11.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.0f)
		);

		ModelPartData shields2 = bottom_shields.addChild(
			"shields2", ModelPartBuilder.create()
				.uv(22, 0)
				.cuboid(2.0f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, new Dilation(0.0f))
				.uv(0, 18)
				.cuboid(-3.0f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 9.0f, 0.0f, 0.0f, -1.5708f, 0.0f)
		);

		shields2.addChild(
			"cube_r3",
			ModelPartBuilder.create()
				.uv(18, 13)
				.cuboid(2.0f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, new Dilation(0.0f))
				.uv(16, 22)
				.cuboid(-3.0f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 1.5708f, 0.0f)
		);

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(AuroraCatalystEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.upper_shields.yaw = animationProgress / 20.f;
		this.bottom_shields.yaw = animationProgress;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
