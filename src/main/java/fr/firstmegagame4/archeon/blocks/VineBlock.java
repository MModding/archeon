package fr.firstmegagame4.archeon.blocks;

import com.mmodding.mmodding_lib.library.blocks.CustomPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.tag.BlockTags;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.function.Predicate;

public class VineBlock extends CustomPlantBlock {

	public static final BooleanProperty HAS_GRAPES = BooleanProperty.of("has_grapes");

	public VineBlock(Settings settings) {
		this(settings, false);
	}

	public VineBlock(Settings settings, boolean hasItem) {
		this(settings, hasItem, (ItemGroup) null);
	}

	public VineBlock(Settings settings, boolean hasItem, ItemGroup itemGroup) {
		this(settings, hasItem, itemGroup != null ? new QuiltItemSettings().group(itemGroup) : new QuiltItemSettings());
	}

	public VineBlock(Settings settings, boolean hasItem, Item.Settings itemSettings) {
		this(floor -> floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND), settings, hasItem, itemSettings);
	}

	public VineBlock(Predicate<BlockState> placementConditions, Settings settings) {
		this(placementConditions, settings, false);
	}

	public VineBlock(Predicate<BlockState> placementConditions, Settings settings, boolean hasItem) {
		this(placementConditions, settings, hasItem, (ItemGroup) null);
	}

	public VineBlock(Predicate<BlockState> placementConditions, Settings settings, boolean hasItem, ItemGroup itemGroup) {
		this(placementConditions, settings, hasItem, itemGroup != null ? new QuiltItemSettings().group(itemGroup) : new QuiltItemSettings());
	}

	public VineBlock(Predicate<BlockState> placementConditions, Settings settings, boolean hasItem, Item.Settings itemSettings) {
		super(placementConditions, settings, hasItem, itemSettings);
		this.setDefaultState(this.getDefaultState().with(HAS_GRAPES, false));
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(HAS_GRAPES, false);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(HAS_GRAPES);
	}
}
