package com.mmodding.archeon.client.entities.models.centaur;

import com.mmodding.archeon.client.entities.animations.CentaurEntityAnimations;
import com.mmodding.archeon.entities.centaur.ArmoredCentaurEntity;
import com.mmodding.mmodding_lib.library.client.utils.AnimationUtils;
import net.minecraft.client.model.ModelPart;

public class ArmoredCentaurEntityModel extends AbstractCentaurEntityModel<ArmoredCentaurEntity> {

	public ArmoredCentaurEntityModel(ModelPart root) {
		super(root);
	}

	@Override
	public void setAngles(ArmoredCentaurEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		AnimationUtils.updateAnimation(
			this,
			CentaurEntityAnimations.CROSS_ATTACK,
			entity.crossAttackAction.getAnimationState(),
			animationProgress,
			1.0f
		);
		AnimationUtils.updateAnimation(
			this,
			CentaurEntityAnimations.BATTLE_AXE_FALLING,
			entity.damageZoneAttackAction.getAnimationState(),
			animationProgress,
			1.0f
		);
		if (!entity.crossAttackAction.isExecutingAction() && !entity.damageZoneAttackAction.isExecutingAction()) {
			if (AnimationUtils.isMoving(entity, limbDistance, 0.2f)) { // Is Running
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.BATTLE_AXE_GALLOPING,
					entity.moving,
					animationProgress,
					2.0f
				);
			}
			else if (AnimationUtils.isMoving(entity, limbDistance)) { // Is Walking
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.BATTLE_AXE_WALKING,
					entity.moving,
					animationProgress,
					1.0f
				);
			}
			else { // Is Idling
				AnimationUtils.updateAnimation(
					this,
					CentaurEntityAnimations.BATTLE_AXE_IDLE,
					entity.breathing,
					animationProgress,
					1.0f
				);
			}
		}
	}
}
