package fr.firstmegagame4.archeon.client.entities.models;

import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.firstmegagame4.archeon.entities.NatureCoreEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NatureCoreEntityModel extends EntityModel<NatureCoreEntity> {

	private final ModelPart bone;
	private final ModelPart big_cover;
	private final ModelPart middle_cover;
	private final ModelPart low_cover;
	private final ModelPart core;
	private final ModelPart shields;

	public NatureCoreEntityModel(ModelPart root) {
		this.bone = root.getChild(EntityModelPartNames.BONE);
		this.big_cover = this.bone.getChild("big_cover");
		this.middle_cover = this.bone.getChild("middle_cover");
		this.low_cover = this.bone.getChild("low_cover");
		this.core = this.bone.getChild("core");
		this.shields = root.getChild("shields");
	}

	public static TexturedModelData getTexturedModelData() {

		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild(
			EntityModelPartNames.BONE,
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0F, 8.0F, 0.0F)
		);

		bone.addChild(
			"big_cover",
			ModelPartBuilder.create()
				.uv(0, 48)
				.cuboid(-8.0F, -7.7276F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)),
			ModelTransform.of(0F, 0.7276F, 0F, 0.3381F, -0.3498F, -0.2349F)
		);

		bone.addChild(
			"middle_cover",
			ModelPartBuilder.create()
				.uv(0, 0)
				.cuboid(-7.0F, -6.2609F, -7.0F, 14.0F, 14.0F, 14.0F, new Dilation(0.0F)),
			ModelTransform.of(0F, 0.2609F, 0F, -0.3361F, 0.4821F, -0.5072F)
		);

		bone.addChild(
			"low_cover",
			ModelPartBuilder.create()
				.uv(0, 28)
				.cuboid(-5.0F, -4.036F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)),
			ModelTransform.of(0F, 0.036F, 0F, -0.1462F, 0.0967F, -0.5604F)
		);

		bone.addChild(
			"core",
			ModelPartBuilder.create()
				.uv(40, 40)
				.cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(40, 28)
				.cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, -0.7854F, -0.7854F)
		);

		ModelPartData shields = modelPartData.addChild(
			"shields",
			ModelPartBuilder.create(),
			ModelTransform.pivot(0.0F, 24.0F, 0.0F)
		);

		ModelPartData shields1 = shields.addChild(
			"shields1",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F)
		);

		shields1.addChild(
			"cube_r1",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields5 = shields.addChild(
			"shields5",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.3526F, 0.0F)
		);

		shields5.addChild(
			"cube_r5",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields4 = shields.addChild(
			"shields4",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.0036F, 0.0F)
		);

		shields4.addChild(
			"cube_r6",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields3 = shields.addChild(
			"shields3",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3054F, 0.0F)
		);

		shields3.addChild(
			"cube_r7",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields6 = shields.addChild(
			"shields6",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.7017F, 0.0F)
		);

		shields6.addChild(
			"cube_r8",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields7 = shields.addChild(
			"shields7",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.0508F, 0.0F)
		);

		shields7.addChild(
			"cube_r9",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields8 = shields.addChild(
			"shields8",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.3998F, 0.0F)
		);

		shields8.addChild(
			"cube_r10",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields9 = shields.addChild(
			"shields9",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.7925F, 0.0F)
		);

		shields9.addChild(
			"cube_r11",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields10 = shields.addChild(
			"shields10",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
		);

		shields10.addChild(
			"cube_r12",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields2 = shields.addChild(
			"shields2",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F)
		);

		shields2.addChild(
			"cube_r13",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields13 = shields2.addChild(
			"shields13",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F)
		);

		shields13.addChild(
			"cube_r14",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields12 = shields2.addChild(
			"shields12",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.4435F, 0.0F)
		);

		shields12.addChild(
			"cube_r15",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields14 = shields2.addChild(
			"shields14",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.7453F, 0.0F)
		);

		shields14.addChild(
			"cube_r16",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields11 = shields2.addChild(
			"shields11",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.7925F, 0.0F)
		);

		shields11.addChild(
			"cube_r17",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields16 = shields2.addChild(
			"shields16",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F)
		);

		shields16.addChild(
			"cube_r18",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		shields2.addChild(
			"shields17",
			ModelPartBuilder.create(),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F)
		);

		ModelPartData shields18 = shields2.addChild(
			"shields18",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F)
		);

		shields18.addChild(
			"cube_r19",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields15 = shields2.addChild(
			"shields15",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.3963F, 0.0F)
		);

		shields15.addChild(
			"cube_r20",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields19 = shields2.addChild(
			"shields19",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F)
		);

		shields19.addChild(
			"cube_r21",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		ModelPartData shields20 = shields2.addChild(
			"shields20",
			ModelPartBuilder.create()
				.uv(0, 2)
				.cuboid(-1.0F, -18.0F, -17.0F, 2.0F, 11.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.7925F, 0.0F)
		);

		shields20.addChild(
			"cube_r22",
			ModelPartBuilder.create()
				.uv(0, 5)
				.cuboid(-1.0F, -6.0F, 0.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)),
			ModelTransform.of(0.0F, -7.0F, -17.0F, 0.4363F, 0.0F, 0.0F)
		);

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(NatureCoreEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
