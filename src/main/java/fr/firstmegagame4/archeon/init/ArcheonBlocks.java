package fr.firstmegagame4.archeon.init;

import com.mmodding.mmodding_lib.library.blocks.*;
import com.mmodding.mmodding_lib.library.initializers.ElementsInitializer;
import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ArcheonBlocks implements ElementsInitializer {

	private static final QuiltBlockSettings BASIC_STONE_SETTINGS = QuiltBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE);

	public static final CustomFlowerBlock AEROLIA = new CustomFlowerBlock(
		floor -> floor.isIn(ArcheonTags.ARCHEON_DIRT),
		StatusEffects.REGENERATION,
		10,
		QuiltBlockSettings.of(Material.PLANT),
		true
	);

	public static final CustomBlock AKETITE_BASEBOARD = new CustomBlock(BASIC_STONE_SETTINGS, true);

	public static final CustomBlock AKETITE = new CustomBlock(BASIC_STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_STAIRS = new CustomStairsBlock(AKETITE.getDefaultState(), BASIC_STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_SLAB = new CustomSlabBlock(BASIC_STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_WALL = new CustomWallBlock(BASIC_STONE_SETTINGS, true);

	public static final CustomBlock AKETITE_BRICKS = new CustomBlock(BASIC_STONE_SETTINGS, true);
	public static final CustomStairsBlock AKETITE_BRICK_STAIRS = new CustomStairsBlock(AKETITE_BRICKS.getDefaultState(), BASIC_STONE_SETTINGS, true);
	public static final CustomSlabBlock AKETITE_BRICK_SLAB = new CustomSlabBlock(BASIC_STONE_SETTINGS, true);
	public static final CustomWallBlock AKETITE_BRICK_WALL = new CustomWallBlock(BASIC_STONE_SETTINGS, true);

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
	}
}
