package fr.firstmegagame4.archeon.client.entities.animations;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;

// Generated With BlockBench 4.9.0
public class CentaurEntityAnimations {

	public static final Animation GALLOPING = Animation.Builder.withLength(1.5833f).looping()
		.addPartAnimation("top", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 3.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -4.0f, -3.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-15.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("flank", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 3.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -2.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.rotate(-67.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-107.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(-7.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 5.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.8333f, Animator.translate(0.0f, 1.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.rotate(-12.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(57.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.1667f, Animator.rotate(92.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("left_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, -1.5f, -2.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -0.75f, -0.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 6.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.1667f, Animator.translate(0.0f, 5.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.rotate(-42.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.rotate(-62.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(25.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(-17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_front_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.1667f, Animator.translate(0.0f, 2.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, 4.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, -1.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.3333f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.rotate(17.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.rotate(-10.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.rotate(75.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.25f, Animator.rotate(82.5f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.4167f, Animator.rotate(31.25f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.5f, Animator.rotate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.addPartAnimation("right_back_leg", new PartAnimation(PartAnimation.AnimationTargets.TRANSLATE,
			new AnimationKeyframe(0.0f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.3333f, Animator.translate(0.0f, -1.5f, -3.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.5f, Animator.translate(0.0f, -0.75f, -1.5f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(0.6667f, Animator.translate(0.0f, 4.0f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.0f, Animator.translate(0.0f, 6.0f, -1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.1667f, Animator.translate(0.0f, 4.67f, 0.67f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.25f, Animator.translate(0.0f, 4.0f, 1.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.4167f, Animator.translate(0.0f, 0.5f, 0.0f), PartAnimation.Interpolators.LINEAR),
			new AnimationKeyframe(1.5f, Animator.translate(0.0f, 0.0f, 0.0f), PartAnimation.Interpolators.LINEAR)
		))
		.build();
}
