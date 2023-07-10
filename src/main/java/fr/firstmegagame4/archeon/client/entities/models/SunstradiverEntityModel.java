package fr.firstmegagame4.archeon.client.entities.models;

import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.firstmegagame4.archeon.entities.SunstradiverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SunstradiverEntityModel extends EntityModel<SunstradiverEntity> {

	private final ModelPart bone;
	private final ModelPart head;
	private final ModelPart feather;
	private final ModelPart leftWing;
	private final ModelPart rightWing;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart tail;
	private final ModelPart body;

	public SunstradiverEntityModel(ModelPart root) {
		this.bone = root.getChild(EntityModelPartNames.BONE);
		this.head = this.bone.getChild(EntityModelPartNames.HEAD);
		this.feather = this.head.getChild("feather");
		this.leftWing = this.bone.getChild(EntityModelPartNames.LEFT_WING);
		this.rightWing = this.bone.getChild(EntityModelPartNames.RIGHT_WING);
		this.leftLeg = this.bone.getChild(EntityModelPartNames.LEFT_LEG);
		this.rightLeg = this.bone.getChild(EntityModelPartNames.RIGHT_LEG);
		this.tail = this.bone.getChild(EntityModelPartNames.TAIL);
		this.body = this.bone.getChild(EntityModelPartNames.BODY);
	}

	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild(
			EntityModelPartNames.BONE,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0F, 19.0F, 0.0F)
		);

		ModelPartData head = bone.addChild(
			EntityModelPartNames.HEAD,
			ModelPartBuilder.create()
				.uv(0, 9)
				.cuboid(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(19, 0)
				.cuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)),
			ModelTransform.pivot(0.0F, -3.0F, -1.5F)
		);

		ModelPartData feather = head.addChild(
			"feather",
			ModelPartBuilder.create(),
			ModelTransform.of(0.0F, -2.5F, -1.0F, -0.2618F, 0.0F, 0.0F)
		);

		feather.addChild(
			"feather_r1",
			ModelPartBuilder.create()
				.uv(0, 12)
				.cuboid(0.0F, -13.0F, -0.5F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 9.5F, 2.5F, 0.2618F, 0.0F, 0.0F)
		);

		ModelPartData left_wing = bone.addChild(
			EntityModelPartNames.LEFT_WING,
			ModelPartBuilder.create(),
			ModelTransform.pivot(2.5F, -2.1F, -2.8F)
		);

		ModelPartData left_wing_rotation = left_wing.addChild(
			"left_wing_rotation",
			ModelPartBuilder.create(),
			ModelTransform.of(-1.0F, 2.5F, 2.0F, 0.0F, 3.1416F, 0.0F)
		);

		left_wing_rotation.addChild(
			"left_wing_rotation_r1",
			ModelPartBuilder.create()
				.uv(14, 0)
				.cuboid(-1.0F, -0.0949F, -1.5665F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)),
			ModelTransform.of(-0.5F, -2.4F, 1.8F, -0.6981F, 0.0F, 0.0F)
		);

		ModelPartData right_wing = bone.addChild(
			EntityModelPartNames.RIGHT_WING,
			ModelPartBuilder.create(),
			ModelTransform.pivot(-2.5F, -2.1F, -2.8F)
		);

		ModelPartData right_wing_rotation = right_wing.addChild(
			"right_wing_rotation",
			ModelPartBuilder.create(),
			ModelTransform.of(0.0F, 2.5F, 2.0F, 0.0F, 3.1416F, 0.0F)
		);

		right_wing_rotation.addChild(
			"right_wing_rotation_r1",
			ModelPartBuilder.create()
				.uv(13, 13)
				.cuboid(0.0F, -0.0949F, -1.5665F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)),
			ModelTransform.of(-0.5F, -2.4F, 1.8F, -0.6981F, 0.0F, 0.0F)
		);

		bone.addChild(
			EntityModelPartNames.LEFT_LEG,
			ModelPartBuilder.create()
				.uv(12, 9)
				.cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.pivot(-1.0F, 2.0F, -1.0F)
		);

		bone.addChild(
			EntityModelPartNames.RIGHT_LEG,
			ModelPartBuilder.create()
				.uv(0, 9)
				.cuboid(-0.5F, 0.0F, -1.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.pivot(1.0F, 2.0F, -1.0F)
		);

		ModelPartData tail = bone.addChild(
			EntityModelPartNames.TAIL,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0F, 1.1F, -0.8F)
		);

		tail.addChild(
			"tail_r1",
			ModelPartBuilder.create()
				.uv(18, 9)
				.cuboid(-1.0F, -1.9F, 2.2F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 3.9F, 0.8F, 1.1781F, 0.0F, 0.0F)
		);

		ModelPartData body = bone.addChild(
			EntityModelPartNames.BODY,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0F, -2.5F, -1.0F)
		);

		body.addChild(
			"body_r1",
			ModelPartBuilder.create()
				.uv(0, 0)
				.cuboid(-2.0F, -8.5F, -1.5F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 7.5F, 1.0F, 0.3054F, 0.0F, 0.0F)
		);

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(SunstradiverEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.pitch = headPitch * (float) (Math.PI / 180.0);
		this.head.yaw = netHeadYaw * (float) (Math.PI / 180.0);
		this.head.roll = 0.0f;
		this.head.pivotX = 0.0f;
		this.body.pivotX = 0.0f;
		this.tail.pivotX = 0.0f;
		this.leftWing.pivotX = 2.5f;
		this.rightWing.pivotX = -2.5F;
		switch (!entity.isInAir() ? 0 : 1) {
			case 0:
				this.leftLeg.pitch += MathHelper.cos(limbSwing * 0.6662F) * 1.4f * limbSwingAmount;
				this.rightLeg.pitch += MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4f * limbSwingAmount;
			case 1:
			default:
				float pivotAgeBased = ageInTicks * 0.3F;
				this.head.pivotY = -3.0f + pivotAgeBased;
				this.tail.pitch = 0.0f + MathHelper.cos(limbSwing * 0.6662f) * 0.3f * limbSwingAmount;
				this.tail.pivotY = 1.1f + pivotAgeBased;
				this.body.pivotY = -2.5f + pivotAgeBased;
				this.leftWing.roll = -0.0873f - ageInTicks;
				this.leftWing.pivotY = -2.1F + pivotAgeBased;
				this.rightWing.roll = 0.0873f + ageInTicks;
				this.rightWing.pivotY = -2.1F + pivotAgeBased;
				this.leftLeg.pivotY = 2.0f + pivotAgeBased;
				this.rightLeg.pivotY = 2.0f + pivotAgeBased;
		}
	}

	@Override
	public void animateModel(SunstradiverEntity entity, float limbAngle, float limbDistance, float tickDelta) {
		this.feather.pitch = -0.2618f;
		this.body.pitch = 0.0f;
		this.leftWing.pitch = -0.6981f * 2;
		this.leftWing.yaw = (float) -Math.PI;
		this.rightWing.pitch = -0.6981f * 2;
		this.rightWing.yaw = (float) -Math.PI;
		this.leftLeg.pitch = -0.0299f;
		this.rightLeg.pitch = -0.0299f;
		this.leftLeg.pivotY = 2.0f;
		this.rightLeg.pivotY = 2.0f;
		this.leftLeg.roll = 0.0f;
		this.rightLeg.roll = 0.0f;
		if (entity.isInAir()) {
			this.leftLeg.pitch += (float) (Math.PI * 2.0 / 9.0);
			this.rightLeg.pitch += (float) (Math.PI * 2.0 / 9.0);
		}
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
