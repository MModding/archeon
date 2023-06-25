package fr.firstmegagame4.archeon.client.entities.models;

import fr.firstmegagame4.archeon.entities.HeiferEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.CowEntityModel;

public class HeiferEntityModel extends CowEntityModel<HeiferEntity> {

	public HeiferEntityModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		return CowEntityModel.getTexturedModelData();
	}

	@Override
	public void setAngles(HeiferEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
	}
}
