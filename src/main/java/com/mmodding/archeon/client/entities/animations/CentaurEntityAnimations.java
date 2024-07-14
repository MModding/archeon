package com.mmodding.archeon.client.entities.animations;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;

/** Generated With BlockBench 4.9.0
 * @author FirstMegaGame4
 */
public class CentaurEntityAnimations {

	public static final Animation GALLOPING = Animation.Builder.withLength(1.0f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -4.0f, -3.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 3.33f, 0.56f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation GALLOPING_WITH_SPEAR = Animation.Builder.withLength(1.0f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, 4.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 5.0f, 4.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 3.0f, 4.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 4.0f, 4.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 3.33f, 0.56f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0417f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0417f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9583f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR)
		))
		.build();
}
