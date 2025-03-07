package com.mmodding.archeon.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mmodding.archeon.Archeon;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

	@Shadow
	private @Nullable ClientWorld world;

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;begin(Lcom/mojang/blaze3d/vertex/VertexFormat$DrawMode;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", ordinal = 2))
	private void cancelMoon(BufferBuilder instance, VertexFormat.DrawMode drawMode, VertexFormat format, Operation<Void> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			original.call(instance, drawMode, format);
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;vertex(Lnet/minecraft/util/math/Matrix4f;FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", ordinal = 6))
	private VertexConsumer cancelMoonFirst(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			return original.call(instance, matrix4f, x, y, z);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;vertex(Lnet/minecraft/util/math/Matrix4f;FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", ordinal = 7))
	private VertexConsumer cancelMoonSecond(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			return original.call(instance, matrix4f, x, y, z);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;vertex(Lnet/minecraft/util/math/Matrix4f;FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", ordinal = 8))
	private VertexConsumer cancelMoonThird(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			return original.call(instance, matrix4f, x, y, z);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;vertex(Lnet/minecraft/util/math/Matrix4f;FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", ordinal = 9))
	private VertexConsumer cancelMoonFourth(BufferBuilder instance, Matrix4f matrix4f, float x, float y, float z, Operation<VertexConsumer> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			return original.call(instance, matrix4f, x, y, z);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;uv(FF)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
	private VertexConsumer cancelMoon(VertexConsumer instance, float u, float v, Operation<VertexConsumer> original) {
		if (instance != null) {
			return original.call(instance, u, v);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;next()V"))
	private void cancelMoon(VertexConsumer instance, Operation<Void> original) {
		if (instance != null) {
			original.call(instance);
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferBuilder;end()Lcom/mojang/blaze3d/vertex/BufferBuilder$RenderedBuffer;", ordinal = 2))
	private BufferBuilder.RenderedBuffer cancelMoon(BufferBuilder instance, Operation<BufferBuilder.RenderedBuffer> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			return original.call(instance);
		}
		else {
			return null;
		}
	}

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferRenderer;drawWithShader(Lcom/mojang/blaze3d/vertex/BufferBuilder$RenderedBuffer;)V", ordinal = 2))
	private void cancelMoon(BufferBuilder.RenderedBuffer renderedBuffer, Operation<Void> original) {
		if (this.world != null && !this.world.getRegistryKey().equals(Archeon.WORLD_KEY)) {
			original.call(renderedBuffer);
		}
	}
}
