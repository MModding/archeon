package com.mmodding.archeon.init;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArcheonCauldronBehaviors {

	public static ActionResult fillWithHotSpringWater(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
		return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, ArcheonBlocks.HOT_SPRING_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
	}

	public static ActionResult fillWithDascium(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
		// TODO: pour les bucket custom
		return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, ArcheonBlocks.DASCIUM_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
	}
}
