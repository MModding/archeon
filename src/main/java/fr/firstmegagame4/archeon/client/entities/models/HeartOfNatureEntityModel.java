package fr.firstmegagame4.archeon.client.entities.models;

import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.firstmegagame4.archeon.entities.HeartOfNatureEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

import java.util.stream.IntStream;

// Originally Made with Blockbench 4.7.4
public class HeartOfNatureEntityModel extends EntityModel<HeartOfNatureEntity> {

	private static final int BIG_COVER_UVX = 0;
	private static final int BIG_COVER_UVZ = 0;

	private static final int MIDDLE_COVER_UVX = 0;
	private static final int MIDDLE_COVER_UVZ = 32;

	private static final int LOW_COVER_UVX = 46;
	private static final int LOW_COVER_UVZ = 50;

	private static final int OUTER_CORE_UVX = 42;
	private static final int OUTER_CORE_UVZ = 32;

	private static final int INNER_CORE_UVX = 0;
	private static final int INNER_CORE_UVZ = 0;

	private static final int PILLAR_SHIELDS_UVX = 0;
	private static final int PILLAR_SHIELDS_UVZ = 32;

	private static final int SLOPED_SHIELDS_UVX = 0;
	private static final int SLOPED_SHIELDS_UVZ = 8;

	private final ModelPart bone;
	private final ModelPart big_cover;
	private final ModelPart middle_cover;
	private final ModelPart low_cover;
	private final ModelPart core;
	private final ModelPart shields;

	public HeartOfNatureEntityModel(ModelPart root) {
		this.bone = root.getChild(EntityModelPartNames.BONE);
		this.big_cover = this.bone.getChild("big_cover");
		this.middle_cover = this.bone.getChild("middle_cover");
		this.low_cover = this.bone.getChild("low_cover");
		this.core = this.bone.getChild("core");
		this.shields = root.getChild("shields");
	}

	private static void createShieldParts(ModelPartData shields) {
		IntStream.range(-9, 9).forEach(index ->
			shields.addChild(
				"pillar_shield_" + index,
				ModelPartBuilder.create()
					.uv(PILLAR_SHIELDS_UVX, PILLAR_SHIELDS_UVZ)
					.cuboid(-1.0f, -18.0f, -17.0f, 2.0f, 11.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, (float) (index * Math.PI / 9.0f), 0.0f)
			).addChild(
				"sloped_shield_" + index,
				ModelPartBuilder.create()
					.uv(SLOPED_SHIELDS_UVX, SLOPED_SHIELDS_UVZ)
					.cuboid(-1.0f, -6.0f, 0.0f, 2.0f, 6.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -7.0f, -17.0f, 0.4363f, 0.0f, 0.0f)
			)
		);
	}

	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild(
			EntityModelPartNames.BONE,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0f, 8.0f, 0.0f)
		);

		bone.addChild(
			"big_cover",
			ModelPartBuilder.create()
				.uv(BIG_COVER_UVX, BIG_COVER_UVZ)
				.cuboid(-8.0f, -7.7276f, -8.0f, 16.0f, 16.0f, 16.0f, new Dilation(0.0f)),
			ModelTransform.of(0f, 0.7276f, 0f, 0.3381f, -0.3498f, -0.2349f)
		);

		bone.addChild(
			"middle_cover",
			ModelPartBuilder.create()
				.uv(MIDDLE_COVER_UVX, MIDDLE_COVER_UVZ)
				.cuboid(-7.0f, -6.2609f, -7.0f, 14.0f, 14.0f, 14.0f, new Dilation(0.0f)),
			ModelTransform.of(0f, 0.2609f, 0f, -0.3361f, 0.4821f, -0.5072f)
		);

		bone.addChild(
			"low_cover",
			ModelPartBuilder.create()
				.uv(LOW_COVER_UVX, LOW_COVER_UVZ)
				.cuboid(-5.0f, -4.036f, -5.0f, 10.0f, 10.0f, 10.0f, new Dilation(0.0f)),
			ModelTransform.of(0f, 0.036f, 0f, -0.1462f, 0.0967f, -0.5604f)
		);

		bone.addChild(
			"core",
			ModelPartBuilder.create()
				.uv(OUTER_CORE_UVX, OUTER_CORE_UVZ)
				.cuboid(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new Dilation(0.0f))
				.uv(INNER_CORE_UVX, INNER_CORE_UVZ)
				.cuboid(-2.0f, -2.0f, -2.0f, 4.0f, 4.0f, 4.0f, new Dilation(0.0f)),
			ModelTransform.of(0.0f, 0.0f, 0.0f, 0.7854f, -0.7854f, -0.7854f)
		);

		ModelPartData shields = modelPartData.addChild(
			"shields",
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0f, 24.0f, 0.0f)
		);

		HeartOfNatureEntityModel.createShieldParts(shields);

		return TexturedModelData.of(modelData, 96, 80);
	}

	@Override
	public void setAngles(HeartOfNatureEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.big_cover.yaw = ageInTicks / -20.0f;
		this.big_cover.pitch = ageInTicks / -80.0f;
		this.middle_cover.yaw = ageInTicks / 15.0f;
		this.middle_cover.pitch = ageInTicks / -60.0f;
		this.low_cover.yaw = ageInTicks / -10.0f;
		this.low_cover.pitch = ageInTicks / 40.0f;
		this.core.yaw = ageInTicks / 5.0f;
		this.core.pitch = ageInTicks / 20.0f;
		this.shields.yaw = ageInTicks;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		this.shields.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
