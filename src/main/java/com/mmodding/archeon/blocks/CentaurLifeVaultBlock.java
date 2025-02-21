package com.mmodding.archeon.blocks;

import com.mmodding.archeon.blockentities.ArcheonBlockEntities;
import com.mmodding.archeon.blockentities.CentaurLifeVaultBlockEntity;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.mmodding_lib.library.blocks.CustomBlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CentaurLifeVaultBlock extends CustomBlockWithEntity {

	public static final EnumProperty<Lives> LIVES = EnumProperty.of("lives", Lives.class);

	public CentaurLifeVaultBlock(Settings settings, boolean hasItem) {
		super(settings, hasItem);
		this.setDefaultState(this.getDefaultState().with(CentaurLifeVaultBlock.LIVES, Lives.EMPTY));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient()) { // Cannot get the Item on the Client-Side and we always want to Swing the Hand.
			return ActionResult.SUCCESS;
		}
		if (player.getStackInHand(hand).isOf(ArcheonItems.CENTAUR_LIFE_IGNITER)) {
			return ActionResult.PASS;
		}
		else {
			player.sendMessage(Text.translatable("interaction.archeon.centaur_life_vault"), true);
			return ActionResult.FAIL;
		}
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CentaurLifeVaultBlockEntity(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(CentaurLifeVaultBlock.LIVES);
	}

	@Override
	public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return !world.isClient ? checkType(type, ArcheonBlockEntities.CENTAUR_LIFE_VAULT, CentaurLifeVaultBlockEntity::tick) : null;
	}

	public enum Lives implements StringIdentifiable {
		EMPTY("empty"),
		LEFT("left"),
		RIGHT("right"),
		FULL("full");

		private final String identifier;

		Lives(String identifier) {
			this.identifier = identifier;
		}

		@Override
		public String asString() {
			return this.identifier;
		}

		public Lives decadeLeft() {
			return switch (this) {
				case EMPTY, LEFT -> Lives.EMPTY;
				case RIGHT, FULL -> Lives.RIGHT;
			};
		}

		public Lives decadeRight() {
			return switch (this) {
				case EMPTY, RIGHT -> Lives.EMPTY;
				case LEFT, FULL -> Lives.LEFT;
			};
		}
	}
}
