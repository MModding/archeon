package com.mmodding.archeon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class NaturiteBlock extends Block {

	public NaturiteBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		super.randomDisplayTick(state, world, pos, random);
		for (int i = 0; i < 10; i++) {
			world.addParticle(
				ParticleTypes.ENCHANT,
				pos.getX() + random.nextFloat(),
				pos.getY() + random.nextFloat(),
				pos.getZ() + random.nextFloat(),
				(random.nextFloat() - 0.5f) * 0.5f,
				(random.nextFloat() - 0.5f) * 0.5f,
				(random.nextFloat() - 0.5f) * 0.5f
			);
		}
	}
}
