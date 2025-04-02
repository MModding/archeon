package com.mmodding.archeon.blocks;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.mmodding_lib.library.blocks.CustomFernBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ToBushBlock extends CustomFernBlock {

	private final Supplier<Item> itemToLoot;

	public ToBushBlock(Supplier<Item> itemToLoot, Predicate<BlockState> placementConditions, Settings settings, boolean hasItem) {
		super(placementConditions, settings, hasItem);
		this.itemToLoot = itemToLoot;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ToBushBlock.dropStack(world, pos, new ItemStack(this.itemToLoot.get(), world.getRandom().nextInt(1)));
		world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.getRandom().nextFloat() * 0.4f);
		BlockState bushState = ArcheonBlocks.BUSH.getDefaultState();
		world.setBlockState(pos, bushState, Block.NOTIFY_LISTENERS);
		world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.create(player, bushState));
		return ActionResult.success(world.isClient());
	}
}
