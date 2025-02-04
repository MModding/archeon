package com.mmodding.archeon.init;

import com.mmodding.archeon.Archeon;
import com.mmodding.mmodding_lib.library.blockentities.BlockEntityTypeBlockSupportCallback;
import com.mmodding.mmodding_lib.library.events.VanillaFluidCollisionEvents;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

public class ArcheonEvents implements ElementsInitializer {

	private static void furnaceBlockEntityTypeCallback(List<Block> supportedBlocks) {
		supportedBlocks.add(ArcheonBlocks.CHIASPEN_FURNACE);
		supportedBlocks.add(ArcheonBlocks.PHOSNOR_SLATE_FURNACE);
	}

	private static BlockState stoneGenerationCallback(WorldAccess access, BlockPos pos, BlockState blockState, Direction direction, FluidState fluidState) {
		if (access instanceof World world) {
			if (world.getRegistryKey() == Archeon.WORLD_KEY) {
				return ArcheonBlocks.CHIASPEN.getDefaultState();
			}
		}
		return null;
	}

	private static Block cobblestoneGenerationCallback(World world, BlockPos pos, BlockState state, Direction direction, BlockPos offsetPos) {
		if (world.getRegistryKey() == Archeon.WORLD_KEY) {
			return ArcheonBlocks.COBBLED_CHIASPEN;
		}
		return null;
	}

	private static Block obsidianGenerationCallback(World world, BlockPos pos, BlockState state, Direction direction, BlockPos offsetPos) {
		if (world.getRegistryKey() == Archeon.WORLD_KEY) {
			return ArcheonBlocks.PHOSNOR_SLATE;
		}
		return null;
	}

	private static BlockState basaltGenerationCallback(World world, BlockPos pos, BlockState state, Direction direction, BlockPos offsetPos) {
		if (world.getRegistryKey() == Archeon.WORLD_KEY) {
			return ArcheonBlocks.AKETITE.getDefaultState();
		}
		return null;
	}

	@Override
	public void register() {
		BlockEntityTypeBlockSupportCallback.blockEntityType(BlockEntityType.FURNACE).register(ArcheonEvents::furnaceBlockEntityTypeCallback);
		VanillaFluidCollisionEvents.STONE_GENERATION_CALLBACK.register(ArcheonEvents::stoneGenerationCallback);
		VanillaFluidCollisionEvents.COBBLESTONE_GENERATION_CALLBACK.register(ArcheonEvents::cobblestoneGenerationCallback);
		VanillaFluidCollisionEvents.OBSIDIAN_GENERATION_CALLBACK.register(ArcheonEvents::obsidianGenerationCallback);
		VanillaFluidCollisionEvents.BASALT_GENERATION_CALLBACK.register(ArcheonEvents::basaltGenerationCallback);
	}
}
