package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.client.entities.animations.CentaurEntityAnimations;
import com.mmodding.archeon.entities.CentaurEntity;
import com.mmodding.archeon.init.ArcheonEntities;
import com.mmodding.mmodding_lib.library.client.utils.AnimationUtils;
import net.minecraft.client.model.*;
import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

// Originally Made with Blockbench 4.9.0
@SuppressWarnings("FieldCanBeLocal")
public class CentaurEntityModel extends SinglePartEntityModel<CentaurEntity> implements ModelWithArms {

	private final ModelPart root;
	private final ModelPart bone;
	private final ModelPart top;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart bottom;
	private final ModelPart flank;
	private final ModelPart leftFrontLeg;
	private final ModelPart leftBackLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart rightBackLeg;

	public CentaurEntityModel(ModelPart root) {
		this.root = root;
		this.bone = this.root.getChild(EntityModelPartNames.BONE);
		this.top = this.bone.getChild("top");
		this.leftArm = this.top.getChild(EntityModelPartNames.LEFT_ARM);
		this.rightArm = this.top.getChild(EntityModelPartNames.RIGHT_ARM);
		this.body = this.top.getChild(EntityModelPartNames.BODY);
		this.head = this.top.getChild(EntityModelPartNames.HEAD);
		this.bottom = this.bone.getChild("bottom");
		this.flank = this.bottom.getChild("flank");
		this.leftFrontLeg = this.bottom.getChild("left_front_leg");
		this.leftBackLeg = this.bottom.getChild("left_back_leg");
		this.rightFrontLeg = this.bottom.getChild("right_front_leg");
		this.rightBackLeg = this.bottom.getChild("right_back_leg");
	}

	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData model = modelPartData.addChild(EntityModelPartNames.BONE, ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 24.0f, 0.0f));

		ModelPartData top = model.addChild("top", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

		ModelPartData leftArm = top.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(64, 29).cuboid(-4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f))
		.uv(76, 24).cuboid(-4.5f, 2.0f, -2.5f, 5.0f, 1.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(-4.0f, -34.0f, -5.75f));

		ModelPartData rightArm = top.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(64, 13).cuboid(0.0f, 0.0f, -1.75f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f))
		.uv(72, 45).cuboid(-0.5f, 2.0f, -2.25f, 5.0f, 1.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(4.0f, -34.0f, -6.0f));

		ModelPartData body = top.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 32).cuboid(-4.0f, -34.0f, -7.75f, 8.0f, 12.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

		ModelPartData head = top.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 32).cuboid(-4.0f, -42.0f, -10.0f, 8.0f, 8.0f, 8.0f, new Dilation(0.0f))
		.uv(0, 2).cuboid(-6.0f, -39.0f, -8.0f, 2.0f, 2.0f, 0.0f, new Dilation(0.0f))
		.uv(0, 0).cuboid(4.0f, -39.0f, -8.0f, 2.0f, 2.0f, 0.0f, new Dilation(0.0f))
		.uv(68, 69).cuboid(-4.0f, -43.0f, -11.0f, 8.0f, 8.0f, 1.0f, new Dilation(0.0f))
		.uv(0, 17).cuboid(-3.0f, -35.0f, -11.0f, 6.0f, 1.0f, 1.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

		ModelPartData leftHorn = head.addChild(EntityModelPartNames.LEFT_HORN, ModelPartBuilder.create().uv(62, 0).cuboid(-10.0f, -11.0f, 0.0f, 10.0f, 13.0f, 0.0f, new Dilation(0.0f)), ModelTransform.of(-2.0f, -42.0f, -6.0f, 0.0f, 0.3927f, 0.0f));

		ModelPartData rightHorn = head.addChild(EntityModelPartNames.RIGHT_HORN, ModelPartBuilder.create().uv(60, 56).cuboid(0.0f, -11.0f, 0.0f, 10.0f, 13.0f, 0.0f, new Dilation(0.0f)), ModelTransform.of(2.0f, -42.0f, -6.0f, 0.0f, -0.3927f, 0.0f));

		ModelPartData bottom = model.addChild("bottom", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

		ModelPartData flank = bottom.addChild("flank", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -10.0f, -2.0f, 10.0f, 10.0f, 22.0f, new Dilation(0.0f))
		.uv(38, 17).cuboid(-8.0f, -10.25f, 11.25f, 10.0f, 0.0f, 4.0f, new Dilation(0.0f))
		.uv(68, 78).cuboid(-4.5f, -8.0f, 20.0f, 3.0f, 9.0f, 3.0f, new Dilation(0.0f)), ModelTransform.pivot(3.0f, -12.0f, -6.0f));

		ModelPartData rightHead_r1 = flank.addChild("right_head", ModelPartBuilder.create().uv(40, 48).cuboid(0.0f, -0.5f, 4.0f, 2.0f, 8.0f, 8.0f, new Dilation(0.0f)), ModelTransform.of(2.0f, -10.0f, 5.0f, 0.0f, 0.0f, -0.1309f));

		ModelPartData leftHead_r1 = flank.addChild("left_head", ModelPartBuilder.create().uv(52, 40).cuboid(-2.0f, -0.5f, 4.0f, 2.0f, 8.0f, 8.0f, new Dilation(0.0f)), ModelTransform.of(-8.0f, -10.0f, 5.0f, 0.0f, 0.0f, 0.1309f));

		ModelPartData leftFrontLeg = bottom.addChild("left_front_leg", ModelPartBuilder.create().uv(52, 69).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f))
		.uv(20, 48).cuboid(-2.5f, -0.5f, -2.5f, 5.0f, 12.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(-3.25f, -12.0f, -6.0f));

		ModelPartData leftBackLeg = bottom.addChild("left_back_leg", ModelPartBuilder.create().uv(0, 65).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f))
		.uv(20, 48).cuboid(-2.5f, -0.5f, -2.5f, 5.0f, 12.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(-3.25f, -12.0f, 12.0f));

		ModelPartData rightFrontLeg = bottom.addChild("right_front_leg", ModelPartBuilder.create().uv(16, 65).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f))
		.uv(0, 48).cuboid(-2.5f, -0.5f, -2.5f, 5.0f, 12.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(3.25f, -12.0f, -6.0f));

		ModelPartData rightBackLeg = bottom.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.5f, -0.5f, -2.25f, 5.0f, 12.0f, 5.0f, new Dilation(0.0f))
		.uv(36, 64).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(3.25f, -12.0f, 12.0f));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(CentaurEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		if (AnimationUtils.isMoving(entity, limbDistance)) {
			Animation galloping = entity.getType().equals(ArcheonEntities.CENTAUR) ? CentaurEntityAnimations.GALLOPING_WITH_SPEAR : CentaurEntityAnimations.GALLOPING;
			AnimationUtils.updateAnimation(this, galloping, entity.galloping, animationProgress, 2.0f);
		}
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		matrices.translate((arm == Arm.LEFT ? -0.25 : 0.25), 1.55, 0.0f);
		this.top.rotate(matrices);
		(arm == Arm.LEFT ? this.leftArm : this.rightArm).rotate(matrices);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}
}
