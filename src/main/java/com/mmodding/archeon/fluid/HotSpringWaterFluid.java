package com.mmodding.archeon.fluid;

import com.mmodding.archeon.init.ArcheonBlocks;
import com.mmodding.archeon.init.ArcheonFluids;
import com.mmodding.archeon.init.ArcheonItems;
import com.mmodding.library.fluid.api.AdvancedFlowableFluid;
import com.mmodding.library.fluid.api.property.FluidProperties;
import com.mmodding.library.java.api.color.Color;
import com.mmodding.library.java.api.color.RGB;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class HotSpringWaterFluid extends AdvancedFlowableFluid {

	public static final RGB TINT_COLOR = Color.rgb(65, 200, 250);
	public static final RGB FOG_COLOR = Color.rgb(25,  75, 150);

	public HotSpringWaterFluid(IntProperty levels, boolean still) {
		super(levels, still);
	}

	@Override
	protected void appendFluidProperties(FluidProperties.Builder builder) {}

	@Override
	public Vec3d getVelocity(BlockView world, BlockPos pos, FluidState state) {
		return super.getVelocity(world, pos, state).multiply(3.0);
	}

	@Override
	public ParticleEffect getDrippingParticle() {
		return ParticleTypes.SMOKE;
	}

	@Override
	public void neighborCollision(World world, BlockPos pos, Direction direction, BlockPos neighborPos) {
		if (world.getBlockState(pos.down()).isOf(ArcheonBlocks.ANHYDRITE)) {
			world.setBlockState(pos, ArcheonBlocks.PHOSNOR_SLATE.getDefaultState(), Block.NOTIFY_NEIGHBORS);
		}
	}

	@Override
	public Fluid getFlowing() {
		return ArcheonFluids.FLOWING_HOT_SPRING_WATER;
	}

	@Override
	public Fluid getStill() {
		return ArcheonFluids.HOT_SPRING_WATER;
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
		return ArcheonItems.CERAMIC_BUCKET;
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
		return ArcheonBlocks.HOT_SPRING_WATER.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
	}
}
