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
	public static final QuiltBlockSettings BONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.BONE);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.REGENERATION,
		10,
		QuiltBlockSettings.of(Material.PLANT),
		true
	);

	// Double Plant : Need to Fix This

	public static final CustomFlowerBlock ASCENDIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.LEVITATION,
		5,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock ASTEDIBES = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.WATER_BREATHING,
		30,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock BLOOD_ORANGE_BUSH = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		LEAVES_SETTINGS,
		true
	);

	public static final CustomFlowerBlock COKIPLANT = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.POISON,
		5,
		LEAVES_SETTINGS,
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

	public static final CustomBlock BLUE_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock BLUE_TILES_STAIRS = new CustomStairsBlock(BLUE_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock BLUE_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock BLUE_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	public static final CustomBlock BUSH_LEAVES = new CustomBlock(LEAVES_SETTINGS, true);

	public static final CustomPillarBlock BLOCK_OF_CERAMIC = new CustomPillarBlock(BONE_SETTINGS, true);
	public static final CustomButtonBlock.Stone CERAMIC_BUTTON = new CustomButtonBlock.Stone(BONE_SETTINGS, true);
	public static final CustomFenceBlock CERAMIC_FENCE = new CustomFenceBlock(BONE_SETTINGS, true);
	public static final CustomPressurePlateBlock CERAMIC_PRESSURE_PLATE = new CustomPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_STAIRS = new CustomStairsBlock(BLOCK_OF_CERAMIC.getDefaultState(), BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_SLAB = new CustomSlabBlock(BONE_SETTINGS, true);

	public static final CustomPillarBlock CERAMIC_BRICKS = new CustomPillarBlock(BONE_SETTINGS, true);
	public static final CustomStairsBlock CERAMIC_BRICK_STAIRS = new CustomStairsBlock(CERAMIC_BRICKS.getDefaultState(), BONE_SETTINGS, true);
	public static final CustomSlabBlock CERAMIC_BRICK_SLAB = new CustomSlabBlock(BONE_SETTINGS, true);
	public static final CustomWallBlock CERAMIC_BRICK_WALL = new CustomWallBlock(BONE_SETTINGS, true);

	public static final CustomBlock CHISELED_AKETITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_ARTEMNITE = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CHISELED_TROPICSTONE = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock CLEMENTIUM_BLOCK = new CustomBlock(METAL_SETTINGS, true);

	public static final CustomBlock CRACKLED_AKETITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_ARTEMNITE_BRICKS = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomBlock CRACKLED_TROPICSTONE_BRICKS = new CustomBlock(STONE_SETTINGS, true);

	public static final CustomBlock CRIMSON_TILES = new CustomBlock(STONE_SETTINGS, true);
	public static final CustomStairsBlock CRIMSON_TILES_STAIRS = new CustomStairsBlock(CRIMSON_TILES.getDefaultState(), STONE_SETTINGS, true);
	public static final CustomSlabBlock CRIMSON_TILES_SLAB = new CustomSlabBlock(STONE_SETTINGS, true);
	public static final CustomWallBlock CRIMSON_TILES_WALL = new CustomWallBlock(STONE_SETTINGS, true);

	@Override
	public void register() {
		AEROLIA.register(Archeon.newIdentifier("aerolia"));
		ASCENDIA.register(Archeon.newIdentifier("ascendia"));
		ASTEDIBES.register(Archeon.newIdentifier("astedibes"));
		BLOOD_ORANGE_BUSH.register(Archeon.newIdentifier("blood_orange_bush"));
		COKIPLANT.register(Archeon.newIdentifier("cokiplant"));
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
		BLUE_TILES.register(Archeon.newIdentifier("blue_tiles"));
		BLUE_TILES_STAIRS.register(Archeon.newIdentifier("blue_tiles_stairs"));
		BLUE_TILES_SLAB.register(Archeon.newIdentifier("blue_tiles_slab"));
		BLUE_TILES_WALL.register(Archeon.newIdentifier("blue_tiles_wall"));
		BUSH_LEAVES.register(Archeon.newIdentifier("bush_leaves"));
		BLOCK_OF_CERAMIC.register(Archeon.newIdentifier("block_of_ceramic"));
		CERAMIC_BUTTON.register(Archeon.newIdentifier("ceramic_button"));
		CERAMIC_FENCE.register(Archeon.newIdentifier("ceramic_fence"));
		CERAMIC_PRESSURE_PLATE.register(Archeon.newIdentifier("ceramic_pressure_plate"));
		CERAMIC_STAIRS.register(Archeon.newIdentifier("ceramic_stairs"));
		CERAMIC_SLAB.register(Archeon.newIdentifier("ceramic_slab"));
		CERAMIC_BRICKS.register(Archeon.newIdentifier("ceramic_bricks"));
		CERAMIC_BRICK_STAIRS.register(Archeon.newIdentifier("ceramic_brick_stairs"));
		CERAMIC_BRICK_SLAB.register(Archeon.newIdentifier("ceramic_brick_slab"));
		CERAMIC_BRICK_WALL.register(Archeon.newIdentifier("ceramic_brick_wall"));
		CHISELED_AKETITE.register(Archeon.newIdentifier("chiseled_aketite"));
		CHISELED_ARTEMNITE.register(Archeon.newIdentifier("chiseled_artemnite"));
		CHISELED_TROPICSTONE.register(Archeon.newIdentifier("chiseled_tropicstone"));
		CLEMENTIUM_BLOCK.register(Archeon.newIdentifier("clementium_block"));
		CRACKLED_AKETITE_BRICKS.register(Archeon.newIdentifier("crackled_aketite_bricks"));
		CRACKLED_ARTEMNITE_BRICKS.register(Archeon.newIdentifier("crackled_artemnite_bricks"));
		CRACKLED_TROPICSTONE_BRICKS.register(Archeon.newIdentifier("crackled_tropicstone_bricks"));
		CRIMSON_TILES.register(Archeon.newIdentifier("crimson_tiles"));
		CRIMSON_TILES_STAIRS.register(Archeon.newIdentifier("crimson_tiles_stairs"));
		CRIMSON_TILES_SLAB.register(Archeon.newIdentifier("crimson_tiles_slab"));
		CRIMSON_TILES_WALL.register(Archeon.newIdentifier("crimson_tiles_wall"));
	}
}
