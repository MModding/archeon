package fr.firstmegagame4.archeon.fluids;

import com.mmodding.mmodding_lib.library.colors.Color;
import com.mmodding.mmodding_lib.library.colors.RGB;
import com.mmodding.mmodding_lib.library.fluids.CustomFluid;
import com.mmodding.mmodding_lib.library.fluids.FluidGroup;
import com.mmodding.mmodding_lib.library.fluids.collisions.FluidCollisionHandler;
import fr.firstmegagame4.archeon.init.ArcheonBlocks;
import fr.firstmegagame4.archeon.init.ArcheonFluids;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.quiltmc.loader.api.minecraft.ClientOnly;

public class HotSpringWaterFluid extends CustomFluid {

	public static final RGB TINT_COLOR = Color.rgb(65, 200, 250);
	public static final RGB FOG_COLOR = Color.rgb(25,  75, 150);

	public HotSpringWaterFluid(boolean source) {
		super(source);
	}

	@Override
	public FluidGroup getGroup() {
		return ArcheonFluids.HOT_SPRING_WATER;
	}

	@Override
	public float getVelocityMultiplier() {
		return 3.0f;
	}

	@Override
	public DefaultParticleType getDrippingParticle() {
		return ParticleTypes.SMOKE;
	}

	@Override
	public FluidCollisionHandler getCollisionHandler() {
		return FluidCollisionHandler.ofSimple()
			.addHandling(ArcheonBlocks.ANHYDRITE.getDefaultState(), (world, state) -> ArcheonBlocks.PHOSNOR_SLATE.getDefaultState());
	}

	@ClientOnly
	@Override
	public FluidRenderHandler getRenderHandler() {
		return SimpleFluidRenderHandler.coloredWater(HotSpringWaterFluid.TINT_COLOR.toDecimal());
	}

	@ClientOnly
	@Override
	public Color getFogColor() {
		return HotSpringWaterFluid.FOG_COLOR;
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
