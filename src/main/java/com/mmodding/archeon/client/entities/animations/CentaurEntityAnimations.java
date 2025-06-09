package com.mmodding.archeon.client.entities.animations;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;

/**
 * Generated With BlockBench 4.10.4 Before Being Remapped
 * @author Chatoine, FirstMegaGame4
*/
public class CentaurEntityAnimations {

	public static final Animation GALOPPING = Animation.Builder.withLength(0.9167f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -4.0f, -3.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(22.72f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.72f, 0.44f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -0.79f, 0.74f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-6.57f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 3.33f, 0.56f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, 12.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, 2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, -15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation SPEAR_GALLOPING = Animation.Builder.withLength(0.9167f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -4.0f, -4.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(22.72f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.72f, 0.44f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -0.79f, 0.74f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-6.57f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 3.33f, 0.56f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, 12.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, 2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, -15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation BATTLE_AXE_GALLOPING = Animation.Builder.withLength(0.9167f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -4.0f, -4.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-118.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(22.72f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.72f, 0.44f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -0.79f, 0.74f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-6.57f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 3.33f, 0.56f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-115.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, 12.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, 2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, -15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation CROSS_ATTACK = Animation.Builder.withLength(0.875f)
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(16.24f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(16.24f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 9.0f, 12.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -1.31f, 3.56f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -8.34f, -2.47f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -8.34f, -2.47f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(-55.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 8.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 14.0f, 5.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 10.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 15.0f, 6.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 9.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 15.0f, 5.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5833f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 35.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(10.3173f, 88.5469f, 49.4651f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(-360.0f, 90.0f, -320.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(-270.0f, 60.0f, -230.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-427.8581f, -0.7459f, -406.1894f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.rotate(-450.0f, -40.0f, -410.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-450.0f, 42.5f, -410.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(-95.1367f, 74.3851f, -75.3545f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(29.7466f, 88.0688f, 31.4894f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.translate(-1.5f, 1.5f, -0.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.translate(-1.5f, 1.5f, -2.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(-1.5f, -0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.translate(-1.5f, 1.5f, -2.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.translate(-2.0f, 1.5f, -1.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, -35.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, -90.0f, -41.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(0.0f, -90.0f, -45.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(90.0f, -60.0f, -135.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-67.8268f, 3.0613f, 42.1328f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.rotate(-90.0f, 40.0f, 45.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7083f, Animator.rotate(-90.0f, -27.5f, 45.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(-35.0f, -68.5937f, 21.9375f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.7917f, Animator.rotate(0.0f, -90.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.translate(1.58f, 1.5f, -0.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.translate(1.75f, 1.5f, -2.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(1.75f, -0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.translate(1.75f, 1.5f, -2.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.translate(2.08f, 1.5f, -1.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(31.25f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(52.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(35.0f, 0.0f, 15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-5.0f, 0.0f, 7.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, -15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(35.0f, 0.0f, -15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-5.0f, 0.0f, -7.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4583f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4583f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation SPEAR_THROW = Animation.Builder.withLength(0.75f)
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(16.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(16.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, 15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(0.0f, 0.0f, 15.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(17.5f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(25.0f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-40.0f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-57.5f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, -4.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(4.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(4.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, -3.2113f, 14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, 3.2113f, -14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation SPEAR_ATTACK = Animation.Builder.withLength(0.75f)
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-7.6144f, -9.9136f, -1.1816f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(21.0732f, 4.6671f, 1.7958f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(16.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-13.2855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-40.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(1.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 0.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-20.6635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4167f, Animator.rotate(-52.3302f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(1.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 0.0f, -1.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, -3.2113f, 14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, 3.2113f, -14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation BATTLE_AXE_ATTACK = Animation.Builder.withLength(0.8333f)
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(16.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(16.5341f, 14.4061f, 4.224f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 0.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(-39.8925f, -3.2115f, 11.1658f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-56.7535f, -4.8907f, 5.6039f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-56.169f, -11.1448f, 1.4213f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(10.8653f, -13.8019f, -118.8189f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-7.1922f, -18.6057f, -104.0356f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-24.8651f, 13.8257f, -93.9791f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-122.054f, 10.3974f, -94.234f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(-129.554f, 10.3974f, -94.234f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(-1.0f, -3.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(1.0f, -4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.24f, -3.88f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(1.0f, -4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.translate(1.0f, -4.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 2.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, -3.2113f, 14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(12.0868f, 3.2113f, -14.6599f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.75f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation DEATH = Animation.Builder.withLength(1.0f)
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2917f, Animator.rotate(-22.5f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-42.5f, 0.0f, -2.5f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, -2.0f, 2.25f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2083f, Animator.translate(0.0f, -4.08f, 0.36f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.2917f, Animator.translate(0.0f, -8.17f, -1.61f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, -14.0f, -3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.translate(0.0f, -14.31f, -3.21f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, -14.0f, -3.5f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 48.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(23.307f, 9.3073f, 27.9236f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(45.807f, 9.3073f, 27.9236f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, -38.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(17.5f, 0.0f, -38.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(37.7727f, -8.6474f, -9.6616f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.translate(0.0f, 3.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(11.7678f, -4.2453f, 19.5623f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(11.8396f, -3.4251f, 15.9014f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(11.7678f, 4.2453f, -19.5623f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(11.8396f, 3.4251f, -15.9014f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-110.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-117.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 7.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-27.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.3333f, Animator.rotate(-105.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.4167f, Animator.rotate(-130.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-102.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 5.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("body", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(-25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(-59.4776f, 5.2483f, 11.3608f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("bottom", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("bottom", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.translate(0.0f, -8.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, -13.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(77.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.4583f, Animator.rotate(77.3134f, 9.7606f, -2.1856f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(-25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation SPEAR_IDLE = Animation.Builder.withLength(2.0f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(2.49f, 0.0f, 0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(3.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.5f, Animator.rotate(2.49f, 0.0f, 0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("leftHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("rightHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.383f, -0.7499f, 0.0819f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -0.25f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -0.25f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("leftFrontLegDown", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("rightFrontLegDown", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.0f, -0.75f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation AXE_IDLE = Animation.Builder.withLength(2.0f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(2.49f, 0.0f, 0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(3.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.5f, Animator.rotate(2.49f, 0.0f, 0.5f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-115.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-118.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("leftHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("rightHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.383f, -0.7499f, 0.0819f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -0.25f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -0.25f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("leftFrontLegDown", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("rightFrontLegDown", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.0f, -0.75f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(2.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.build();

	public static final Animation SPEAR_WALKING = Animation.Builder.withLength(0.5f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(10.0f, -1.3f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(10.0f, -1.3f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(10.0f, -1.3f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 1.5f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation BATTLE_AXE_WALKING = Animation.Builder.withLength(0.5f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(10.0f, -1.3f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(10.0f, -1.3f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(10.0f, -1.3f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-118.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(-20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 1.5f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 2.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-115.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 10.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, -10.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.rotate(0.0f, 0.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 1.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.125f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.25f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.375f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.25f, Animator.rotate(2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.0833f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2083f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.2917f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.375f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(35.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation SPEAR_FALLING = Animation.Builder.withLength(1.375f)
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5833f, Animator.rotate(-1.87f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.75f, Animator.rotate(0.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.875f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.9167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(21.0732f, 4.6671f, 1.7958f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(21.0732f, 4.6671f, 1.7958f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-44.9291f, -6.2146f, -17.557f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-44.9291f, -6.2146f, -17.557f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(-20.7855f, -21.6347f, -34.5027f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 0.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-57.5f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.1667f, Animator.rotate(-57.5f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-57.5f, 0.0f, -170.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(-28.1635f, 21.772f, 7.9951f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(4.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(4.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(55.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(55.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("left_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-23.8407f, 4.0766f, 9.1391f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(-3.3985f, -0.0652f, -0.1462f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 5.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5417f, Animator.rotate(-23.8407f, -4.0766f, -9.1391f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.625f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.7917f, Animator.rotate(-3.3985f, 0.0652f, 0.1462f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, -5.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.875f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.rotate(-37.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.6667f, Animator.rotate(50.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();

	public static final Animation BATTLE_AXE_FALLING = Animation.Builder.withLength(1.375f)
		.addPartAnimation("bone", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0833f, Animator.rotate(-1.87f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.25f, Animator.rotate(0.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.4167f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(21.0732f, 4.6671f, 1.7958f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(21.0732f, 4.6671f, 1.7958f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -8.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-85.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-85.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(-115.3509f, -34.8432f, 15.2359f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, -4.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-88.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(-88.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(-118.9552f, 19.0474f, 0.7357f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_arm", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, -5.0f, 1.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-2.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -6.0f, 3.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("tail", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(55.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(55.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.1667f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE)
		))
		.addPartAnimation("leftHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0417f, Animator.rotate(-23.8407f, 4.0766f, 9.1391f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.125f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.2917f, Animator.rotate(-3.3985f, -0.0652f, -0.1462f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 5.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("rightHead", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0417f, Animator.rotate(-23.8407f, -4.0766f, -9.1391f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.125f, Animator.rotate(-22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.2917f, Animator.rotate(-3.3985f, 0.0652f, 0.1462f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, -5.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.375f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.1667f, Animator.rotate(-37.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -3.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.1667f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.1667f, Animator.rotate(50.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(22.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -1.0f, -1.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.SPLINE),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(-5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(-5.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_foot", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(20.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();
}
