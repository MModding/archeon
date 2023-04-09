package fr.firstmegagame4.archeon.init;

import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class ArcheonTags {

	public static final TagKey<Block> ARCHEON_DIRT = TagKey.of(Registry.BLOCK_KEY, Archeon.newIdentifier("archeon_dirt"));
}
