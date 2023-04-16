package fr.firstmegagame4.archeon.client;

import com.mmodding.mmodding_lib.library.initializers.ClientElementsInitializer;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;

public class ArcheonRenderLayers implements ClientElementsInitializer {

	@Override
	public void registerClient() {
		ArcheonBlocks.AEROLIA.cutout();
		ArcheonBlocks.ASCENDIA.cutout();
		ArcheonBlocks.ASTEDIBES.cutout();
		ArcheonBlocks.BLOOD_ORANGE_BUSH.cutout();
		ArcheonBlocks.COKIPLANT.cutout();
		ArcheonBlocks.ANTROPY_DOOR.cutout();
		ArcheonBlocks.BUSH_LEAVES.cutout();
		ArcheonBlocks.DEAD_WET_GRASS_TUFFET.cutout();

		ArcheonBlocks.ANTROPY_LEAVES.cutout();
		ArcheonBlocks.CYPRESS_LEAVES.cutout();

		ArcheonBlocks.DUNE_SAND_GLASS.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_TILES.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_TILES_TOP_LEFT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_TILES_TOP_RIGHT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_TILES_BOTTOM_LEFT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_TILES_BOTTOM_RIGHT.cutout();

		ArcheonBlocks.DUNE_SAND_GLASS_PANE.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_PANE_TILES.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_PANE_TILES_TOP_LEFT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_PANE_TILES_TOP_RIGHT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_PANE_TILES_BOTTOM_LEFT.cutout();
		ArcheonBlocks.DUNE_SAND_GLASS_PANE_TILES_BOTTOM_RIGHT.cutout();
	}
}
