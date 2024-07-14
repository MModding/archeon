package com.mmodding.archeon.items;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.screenhandlers.PouchScreenHandler;
import com.mmodding.mmodding_lib.library.items.CustomItemWithInventory;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.OptionalInt;

public class PouchItem extends CustomItemWithInventory {

	public PouchItem(Settings settings) {
		super(PouchScreenHandler::new, 27, settings);
	}

	@Override
	public TooltipMode getTooltipMode() {
		return TooltipMode.ALL_SLOTS_OVERVIEW;
	}

	@Override
	public Optional<TextureLocation> getOptionalTexture() {
		return Optional.of(new TextureLocation(Archeon.id(), "gui/tooltip/pouch"));
	}

	@Override
	public OptionalInt getOptionalColumns() {
		return OptionalInt.of(9);
	}

	@Override
	public OptionalInt getOptionalRows() {
		return OptionalInt.of(3);
	}

	@Override
	@Nullable
	public SoundEvent getUseSound() {
		return SoundEvents.ITEM_BUNDLE_INSERT;
	}
}
