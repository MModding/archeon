package com.mmodding.archeon.fluid;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.library.fluid.api.AdvancedFlowableFluid;
import com.mmodding.library.fluid.api.UnitedFlowableFluid;
import com.mmodding.library.java.api.color.Color;
import com.mmodding.library.java.api.color.RGB;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class DasciumFluid extends AdvancedFlowableFluid {

	public static final Identifier STILL_TEXTURE = Archeon.createId("block/dascium_still");
	public static final Identifier FLOWING_TEXTURE = Archeon.createId("block/dascium_flow");

	public static final RGB FOG_COLOR = Color.rgb(175, 155, 85);

	public DasciumFluid(IntProperty levels, boolean still) {
		super(levels, still);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {}

	@Override
	public Vec3d getVelocity(BlockView world, BlockPos pos, FluidState state) {
		return super.getVelocity(world, pos, state).multiply(0.5);
	}

	@Override
	public ParticleEffect getDrippingParticle() {
		return ParticleTypes.DRIPPING_HONEY;
	}

	@Override
	public void neighborCollision(World world, BlockPos pos, Direction direction, BlockPos neighborPos) {
		if (world.getFluidState(neighborPos).isOf(ArcheonFluids.HOT_SPRING_WATER)) {
			world.setBlockState(pos, ArcheonBlocks.ARTEMNITE.getDefaultState(), Block.NOTIFY_NEIGHBORS);
		}
	}

	@Override
	public Fluid getFlowing() {
		return ArcheonFluids.FLOWING_DASCIUM;
	}

	@Override
	public Fluid getStill() {
		return ArcheonFluids.DASCIUM;
	}

	@Override
	protected boolean isInfinite(World world) {
		return true;
	}

	@Override
	protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
		BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropStacks(state, world, pos, blockEntity);
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
	public Item getBucketItem() {
		return ArcheonItems.CERAMIC_DASCIUM_BUCKET;
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

	@Override
	protected BlockState toBlockState(FluidState state) {
		return ArcheonBlocks.DASCIUM.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
	}
}
