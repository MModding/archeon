package com.mmodding.archeon.client.entities.models.centaur;

import com.mmodding.archeon.client.entities.animations.CentaurEntityAnimations;
import com.mmodding.archeon.entities.centaur.CentaurEntity;
import com.mmodding.mmodding_lib.library.client.utils.AnimationUtils;
import net.minecraft.client.model.ModelPart;

public class CentaurEntityModel extends AbstractCentaurEntityModel<CentaurEntity> {

	public CentaurEntityModel(ModelPart root) {
		super(root);
	}

	@Override
	public void setAngles(CentaurEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		AnimationUtils.updateAnimation(
			this,
			CentaurEntityAnimations.SPEAR_THROW,
			entity.spearAttackAction.getAnimationState(),
			animationProgress,
			1.0f
		);
		AnimationUtils.updateAnimation(
			this,
			CentaurEntityAnimations.SPEAR_FALLING,
			entity.movingSpearAttackAction.getAnimationState(),
			animationProgress,
			1.0f
		);
		if (!entity.spearAttackAction.isExecutingAction() && !entity.movingSpearAttackAction.isExecutingAction()) {
			if (AnimationUtils.isMoving(entity, limbDistance, 0.2f)) { // Is Running
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.SPEAR_GALLOPING,
					entity.moving,
					animationProgress,
					2.0f
				);
			}
			else if (AnimationUtils.isMoving(entity, limbDistance)) { // Is Walking
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.SPEAR_WALKING,
					entity.moving,
					animationProgress,
					1.0f
				);
			}
			else { // Is Idling
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.SPEAR_IDLE,
					entity.breathing,
					animationProgress,
					1.0f
				);
			}
		}
	}
}
