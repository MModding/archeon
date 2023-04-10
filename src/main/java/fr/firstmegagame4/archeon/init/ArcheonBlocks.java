package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonBlocks implements ElementsInitializer {

	private static final QuiltBlockSettings STONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE);
	public static final QuiltBlockSettings WOOD_SETTINGS = QuiltBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD);
	public static final QuiltBlockSettings LEAVES_SETTINGS = QuiltBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS);
	public static final QuiltBlockSettings METAL_SETTINGS = QuiltBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.REGENERATION,
		10,
		QuiltBlockSettings.of(Material.PLANT),
		true
	);

	public static final CustomBlock AKETITE_BASEBOARD = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_STAIRS = new CustomStairsBlock(AKETITE.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_BRICK_STAIRS = new CustomStairsBlock(AKETITE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_TILE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock AKETITE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_TILES_STAIRS = new CustomStairsBlock(AKETITE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomPillarBlock ANTROPY_LOG = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock ANTROPY_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);
	public static final CustomPillarBlock ANTROPY_WOOD = new CustomPillarBlock(WOOD_SETTINGS, true);
	public static final CustomBlock ANTROPY_PLANKS = new CustomBlock(WOOD_SETTINGS, true);
	public static final CustomButtonBlock.Wooden ANTROPY_BUTTON = new CustomButtonBlock.Wooden(WOOD_SETTINGS, true);
	public static final CustomDoorBlock ANTROPY_DOOR = new CustomDoorBlock(WOOD_SETTINGS, true);
	public static final CustomPressurePlateBlock ANTROPY_PRESSURE_PLATE = new CustomPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, WOOD_SETTINGS, true);
	public static final CustomFenceBlock ANTROPY_FENCE = new CustomFenceBlock(WOOD_SETTINGS, true);
	public static final CustomFenceGateBlock ANTROPY_FENCE_GATE = new CustomFenceGateBlock(WOOD_SETTINGS, true);
	public static final CustomStairsBlock ANTROPY_STAIRS = new CustomStairsBlock(ANTROPY_PLANKS.getDefaultState(), WOOD_SETTINGS, true);
	public static final CustomSlabBlock ANTROPY_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomTrapdoorBlock ANTROPY_TRAPDOOR = new CustomTrapdoorBlock(STONE_SETTINGS, true);

	public static final CustomBlock APAFLORITE_BLOCK = new CustomBlock(METAL_SETTINGS, true);
	public static final CustomBlock APAFLORITE_ORE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BASEBOARD = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_BRICK_STAIRS = new CustomStairsBlock(ARTEMNITE_BRICKS.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_BRICK_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_BRICK_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock ARTEMNITE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock ARTEMNITE_TILES_STAIRS = new CustomStairsBlock(ARTEMNITE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock ARTEMNITE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock ARTEMNITE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);



	@Override
	public void register() {
		AEROLIA.register(Archeon.newIdentifier("aerolia"));
		AKETITE_BASEBOARD.register(Archeon.newIdentifier("aketite_baseboard"));
		AKETITE.register(Archeon.newIdentifier("aketite"));
		AKETITE_STAIRS.register(Archeon.newIdentifier("aketite_stairs"));
		AKETITE_SLAB.register(Archeon.newIdentifier("aketite_slab"));
		AKETITE_WALL.register(Archeon.newIdentifier("aketite_wall"));
		AKETITE_BRICKS.register(Archeon.newIdentifier("aketite_bricks"));
		AKETITE_BRICK_STAIRS.register(Archeon.newIdentifier("aketite_brick_stairs"));
		AKETITE_BRICK_SLAB.register(Archeon.newIdentifier("aketite_brick_slab"));
		AKETITE_BRICK_WALL.register(Archeon.newIdentifier("aketite_brick_wall"));
		AKETITE_TILE.register(Archeon.newIdentifier("aketite_tile"));
		AKETITE_TILES.register(Archeon.newIdentifier("aketite_tiles"));
		AKETITE_TILES_STAIRS.register(Archeon.newIdentifier("aketite_tiles_stairs"));
		AKETITE_TILES_SLAB.register(Archeon.newIdentifier("aketite_tiles_slab"));
		AKETITE_TILES_WALL.register(Archeon.newIdentifier("aketite_tiles_wall"));
		ANTROPY_LOG.register(Archeon.newIdentifier("antropy_log"));
		ANTROPY_LEAVES.register(Archeon.newIdentifier("antropy_leaves"));
		ANTROPY_WOOD.register(Archeon.newIdentifier("antropy_wood"));
		ANTROPY_PLANKS.register(Archeon.newIdentifier("antropy_planks"));
		ANTROPY_BUTTON.register(Archeon.newIdentifier("antropy_button"));
		ANTROPY_DOOR.register(Archeon.newIdentifier("antropy_door"));
		ANTROPY_PRESSURE_PLATE.register(Archeon.newIdentifier("antropy_pressure_plate"));
		ANTROPY_FENCE.register(Archeon.newIdentifier("antropy_fence"));
		ANTROPY_FENCE_GATE.register(Archeon.newIdentifier("antropy_fence_gate"));
		ANTROPY_STAIRS.register(Archeon.newIdentifier("antropy_stairs"));
		ANTROPY_SLAB.register(Archeon.newIdentifier("antropy_slab"));
		ANTROPY_TRAPDOOR.register(Archeon.newIdentifier("antropy_trapdoor"));
		APAFLORITE_BLOCK.register(Archeon.newIdentifier("apaflorite_block"));
		APAFLORITE_ORE.register(Archeon.newIdentifier("apaflorite_ore"));
		ARTEMNITE_BASEBOARD.register(Archeon.newIdentifier("artemnite_baseboard"));
		ARTEMNITE.register(Archeon.newIdentifier("artemnite"));
		ARTEMNITE_BRICKS.register(Archeon.newIdentifier("artemnite_bricks"));
		ARTEMNITE_BRICK_STAIRS.register(Archeon.newIdentifier("artemnite_brick_stairs"));
		ARTEMNITE_BRICK_SLAB.register(Archeon.newIdentifier("artemnite_brick_slab"));
		ARTEMNITE_BRICK_WALL.register(Archeon.newIdentifier("artemnite_brick_wall"));
		ARTEMNITE_TILES.register(Archeon.newIdentifier("artemnite_tiles"));
		ARTEMNITE_TILES_STAIRS.register(Archeon.newIdentifier("artemnite_tiles_stairs"));
		ARTEMNITE_TILES_SLAB.register(Archeon.newIdentifier("artemnite_tiles_slab"));
		ARTEMNITE_TILES_WALL.register(Archeon.newIdentifier("artemnite_tiles_wall"));
	}
}
