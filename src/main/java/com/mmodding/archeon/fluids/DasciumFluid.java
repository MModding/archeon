package com.mmodding.archeon.fluids;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.mmodding_lib.library.colors.Color;
import com.mmodding.mmodding_lib.library.colors.RGB;
import com.mmodding.mmodding_lib.library.fluids.CustomFluid;
import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.fluids.collisions.FluidCollisionHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class DasciumFluid extends CustomFluid {

	public static final Identifier STILL_TEXTURE = Archeon.createId("block/dascium_still");
	public static final Identifier FLOWING_TEXTURE = Archeon.createId("block/dascium_flow");

	public static final RGB FOG_COLOR = Color.rgb(175, 155, 85);

	public DasciumFluid(boolean source) {
		super(source);
	}

	@Override
	public FluidGroup getGroup() {
		return ArcheonFluids.DASCIUM;
	}

	@Override
	public float getVelocityMultiplier() {
		return 0.5f;
	}

	@Override
	public DefaultParticleType getDrippingParticle() {
		return ParticleTypes.DRIPPING_HONEY;
	}

	@Override
	public FluidCollisionHandler getCollisionHandler() {
		return FluidCollisionHandler.ofSimple()
			.addHandling(ArcheonFluids.HOT_SPRING_WATER, (world, state) -> ArcheonBlocks.ARTEMNITE.getDefaultState());
	}

	@Override
	@Environment(EnvType.CLIENT)
	public FluidRenderHandler getRenderHandler() {
		return new SimpleFluidRenderHandler(DasciumFluid.STILL_TEXTURE, DasciumFluid.FLOWING_TEXTURE);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public Color getFogColor() {
		return DasciumFluid.FOG_COLOR;
	}

	@Override
	protected boolean isInfinite() {
		return true;
	}

    @Override
	protected int getFlowSpeed(WorldView world) {
		return 4;
	}

	@Override
	protected int getLevelDecreasePerBlock(WorldView world) {
		return 1;
	}

	@Override
	public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}

	@Override
	public int getTickRate(WorldView world) {
		return 5;
	}

	@Override
	protected float getBlastResistance() {
		return 100.0f;
	}
}
