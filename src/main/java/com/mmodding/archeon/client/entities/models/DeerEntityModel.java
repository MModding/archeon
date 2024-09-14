package com.mmodding.archeon.client.entities.models;

import com.mmodding.archeon.entities.DeerEntity;
import com.mmodding.mmodding_lib.library.client.utils.AnimationUtils;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

// Originally Made with Blockbench 4.9.0
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class DeerEntityModel extends SinglePartEntityModel<DeerEntity> {

	public static final String HORNS = "horns";

	private final ModelPart root;
	private final ModelPart bone;
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart leftHorn;
	private final ModelPart rightHorn;
	private final ModelPart mouth;
	private final ModelPart leftEar;
	private final ModelPart rightEar;
	private final ModelPart neck;
	private final ModelPart body;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart rightHindLeg;

	public DeerEntityModel(ModelPart root) {
		this.root = root;
		this.bone = this.root.getChild(EntityModelPartNames.BONE);
		this.head = this.bone.getChild(EntityModelPartNames.HEAD);
		this.horns = this.head.getChild(DeerEntityModel.HORNS);
		this.leftHorn = this.horns.getChild(EntityModelPartNames.LEFT_HORN);
		this.rightHorn = this.horns.getChild(EntityModelPartNames.RIGHT_HORN);
		this.mouth = this.head.getChild(EntityModelPartNames.MOUTH);
		this.leftEar = this.head.getChild(EntityModelPartNames.LEFT_EAR);
		this.rightEar = this.head.getChild(EntityModelPartNames.RIGHT_EAR);
		this.neck = this.head.getChild(EntityModelPartNames.NECK);
		this.body = this.bone.getChild(EntityModelPartNames.BODY);
		this.leftFrontLeg = this.bone.getChild(EntityModelPartNames.LEFT_FRONT_LEG);
		this.rightFrontLeg = this.bone.getChild(EntityModelPartNames.RIGHT_FRONT_LEG);
		this.leftHindLeg = this.bone.getChild(EntityModelPartNames.LEFT_HIND_LEG);
		this.rightHindLeg = this.bone.getChild(EntityModelPartNames.LEFT_HIND_LEG);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild(EntityModelPartNames.BONE, ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 24.0f, 0.0f));

		ModelPartData head = bone.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 13).cuboid(-3.0f, -11.0f, -2.0f, 6.0f, 5.0f, 7.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, -20.0f, -12.0f));

		ModelPartData horns = head.addChild(DeerEntityModel.HORNS, ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 28.0f, 9.0f));
		ModelPartData leftHorn = horns.addChild(EntityModelPartNames.LEFT_HORN, ModelPartBuilder.create().uv(0, -13).cuboid(0.0f, -10.0f, -6.0f, 0.0f, 11.0f, 13.0f, new Dilation(0.0f)), ModelTransform.of(-3.0f, -39.0f, -11.0f, 0.0f, 0.1745f, -0.4363f));
		ModelPartData rightHorn = horns.addChild(EntityModelPartNames.RIGHT_HORN, ModelPartBuilder.create().uv(0, -13).cuboid(0.0f, -10.0f, -6.0f, 0.0f, 11.0f, 13.0f, new Dilation(0.0f)), ModelTransform.of(3.0f, -39.0f, -11.0f, 0.0f, -0.1745f, 0.4363f));

		ModelPartData mouth = head.addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 25).cuboid(-2.0f, -10.0f, -7.0f, 4.0f, 4.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

		ModelPartData leftEar = head.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create(), ModelTransform.pivot(1.5f, -9.9f, 4.0f));
		leftEar.addChild("left_ear_r1", ModelPartBuilder.create().uv(0, 12).cuboid(1.5f, -3.0f, 0.0f, 2.0f, 4.0f, 1.0f, new Dilation(0.0f)), ModelTransform.of(-1.5f, -1.1f, 1.0f, -0.48f, 0.6981f, 0.0f));

		ModelPartData rightEar = head.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create(), ModelTransform.of(-1.5f, -9.9f, 4.0f, 0.0f, -0.6981f, 0.0f));
		rightEar.addChild("right_ear_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-3.5f, -3.0f, 0.0f, 2.0f, 4.0f, 1.0f, new Dilation(0.0f)), ModelTransform.of(1.5f, -1.1f, 0.0f, -0.48f, 0.0f, 0.0f));

		ModelPartData neck = head.addChild(EntityModelPartNames.NECK, ModelPartBuilder.create().uv(2, 37).cuboid(-2.05f, -5.0f, -4.0f, 4.0f, 12.0f, 5.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, -2.0f, 3.0f));

		ModelPartData body = bone.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(3, 35).cuboid(-5.0f, -8.0f, -17.0f, 10.0f, 10.0f, 19.0f, new Dilation(0.05f)), ModelTransform.pivot(0.0f, -13.0f, 6.0f));

		ModelPartData leftFrontLeg = bone.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0f, -1.0f, -1.9f, 4.0f, 11.0f, 4.0f, new Dilation(0.0f)).mirrored(false), ModelTransform.pivot(4.0f, -10.0f, -9.0f));
		ModelPartData rightFrontLeg = bone.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(48, 21).cuboid(-1.0f, -1.0f, -1.9f, 4.0f, 11.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(-4.0f, -10.0f, -9.0f));
		ModelPartData leftHindLeg = bone.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(48, 21).mirrored().cuboid(-3.0f, -1.0f, -4.0f, 4.0f, 11.0f, 4.0f, new Dilation(0.0f)).mirrored(false), ModelTransform.pivot(4.0f, -10.0f, 8.0f));
		ModelPartData rightHindLeg = bone.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(48, 21).cuboid(-1.0f, -1.0f, -4.0f, 4.0f, 11.0f, 4.0f, new Dilation(0.0f)), ModelTransform.pivot(-4.0f, -10.0f, 8.0f));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(DeerEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		if (AnimationUtils.isMoving(entity, limbDistance)) {}
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}
}
