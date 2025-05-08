package com.mmodding.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.BlockRegistrable;
import com.mmodding.mmodding_lib.library.blocks.BlockWithItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.concurrent.atomic.AtomicBoolean;

public class SporeRootcapBlock extends LadderBlock implements BlockRegistrable, BlockWithItem {

	private final AtomicBoolean registered = new AtomicBoolean(false);
	private BlockItem item = null;

	public SporeRootcapBlock(Settings settings) {
		this(settings, false);
	}

	public SporeRootcapBlock(Settings settings, boolean hasItem) {
		this(settings, hasItem, (ItemGroup) null);
	}

	public SporeRootcapBlock(Settings settings, boolean hasItem, ItemGroup itemGroup) {
		this(settings, hasItem, itemGroup != null ? new FabricItemSettings().group(itemGroup) : new FabricItemSettings());
	}

	public SporeRootcapBlock(Settings settings, boolean hasItem, Item.Settings itemSettings) {
		super(settings);
		if (hasItem) this.item = new BlockItem(this, itemSettings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		Vec3d offSet = state.getModelOffset(world, pos);
		return switch (state.get(FACING)) {
			case NORTH -> VoxelShapes.union(
				createCuboidShape(0, 0, 11, 16, 16, 16)
			).offset(offSet.getX(), offSet.getY(), offSet.getZ());
			case SOUTH -> VoxelShapes.union(
				createCuboidShape(0, 0, 0, 16, 16, 5)
			).offset(offSet.getX(), offSet.getY(), offSet.getZ());
			case WEST -> VoxelShapes.union(
				createCuboidShape(11, 0, 0, 16, 16, 16)
			).offset(offSet.getX(), offSet.getY(), offSet.getZ());
			case EAST -> VoxelShapes.union(
				createCuboidShape(0, 0, 0, 5, 16, 16)
			).offset(offSet.getX(), offSet.getY(), offSet.getZ());
			default -> null;
		};
	}

	@Override
	public BlockItem getItem() {
		return this.item;
	}

	@Override
	public boolean isNotRegistered() {
		return !this.registered.get();
	}

	@Override
	public void setRegistered() {
		this.registered.set(true);
	}
}
