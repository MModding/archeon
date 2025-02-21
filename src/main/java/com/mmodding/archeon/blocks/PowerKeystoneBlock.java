package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.blocks.CustomBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PowerKeystoneBlock extends CustomBlock {

	public PowerKeystoneBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient()) { // Cannot get the Item on the Client-Side and we always want to Swing the Hand.
			return ActionResult.SUCCESS;
		}
		if (player.getStackInHand(hand).isOf(ArcheonItems.POWER_KEY)) {
			return ActionResult.PASS;
		}
		else {
			player.sendMessage(Text.translatable("interaction.archeon.power_keystone"), true);
			return ActionResult.FAIL;
		}
	}
}
