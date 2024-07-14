package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class NaturiteBlock extends CustomBlock {

	public NaturiteBlock(Settings settings) {
		this(settings, false);
	}

	public NaturiteBlock(Settings settings, boolean hasItem) {
		this(settings, hasItem, (ItemGroup) null);
	}

	public NaturiteBlock(Settings settings, boolean hasItem, ItemGroup itemGroup) {
		this(settings, hasItem, itemGroup != null ? new QuiltItemSettings().group(itemGroup) : new QuiltItemSettings());
	}

	public NaturiteBlock(Settings settings, boolean hasItem, Item.Settings itemSettings) {
		super(settings, hasItem, itemSettings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
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
