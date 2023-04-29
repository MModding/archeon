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
		ArcheonBlocks.NECLANE_DOOR.cutout();
		ArcheonBlocks.BUSH_LEAVES.cutout();
		ArcheonBlocks.DEAD_WET_GRASS_TUFFET.cutout();
		ArcheonBlocks.IOPEA.cutout();
		ArcheonBlocks.LYCORIS_RADIATA.cutout();
		ArcheonBlocks.LYCORIS_SANGUINEA.cutout();
		ArcheonBlocks.OEA.cutout();
		ArcheonBlocks.ORCHID.cutout();
		ArcheonBlocks.ORGANDEANE_BLOSSOM.cutout();
		ArcheonBlocks.ORGANDEANE_TALL.cutout();

		ArcheonBlocks.WITHERED_AEROLIA.cutout();
		ArcheonBlocks.WITHERED_ASCENDIA.cutout();
		ArcheonBlocks.WITHERED_ASTEDIBES.cutout();
		ArcheonBlocks.WITHERED_IOPEA.cutout();
		ArcheonBlocks.WITHERED_OEA.cutout();
		ArcheonBlocks.WITHERED_ORCHID.cutout();

		ArcheonBlocks.NECLANE_LEAVES.cutout();
		ArcheonBlocks.FLOWERED_NECLANE_LEAVES.cutout();
		ArcheonBlocks.CYPRESS_LEAVES.cutout();
		ArcheonBlocks.NUME_WILLOW_LEAVES.cutout();
		ArcheonBlocks.NYRETH_LEAVES.cutout();
		ArcheonBlocks.PALE_NYRETH_LEAVES.cutout();
		ArcheonBlocks.PALM_LEAVES.cutout();

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

		ArcheonBlocks.LEAVES_CARPET_ORIAN.cutout();
		ArcheonBlocks.LEAVES_CARPET_PNEVANTIAL.cutout();
		ArcheonBlocks.LEAVES_CARPET_STREIAN.cutout();
		ArcheonBlocks.LEAVES_CARPET_VALE.cutout();
		ArcheonBlocks.LEAVES_CARPET_ZIAL.cutout();

		ArcheonBlocks.NYRETH_DOOR.cutout();
		ArcheonBlocks.NYRETH_TRAPDOOR.cutout();

		ArcheonBlocks.PALM_DOOR.cutout();
		ArcheonBlocks.PALM_TRAPDOOR.cutout();
	}
}
