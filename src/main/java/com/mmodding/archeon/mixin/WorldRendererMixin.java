package com.mmodding.archeon.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

	@Shadow
	private @Nullable ClientWorld world;

	@WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/BufferRenderer;drawWithShader(Lcom/mojang/blaze3d/vertex/BufferBuilder$RenderedBuffer;)V", ordinal = 2))
	private void cancelMoon(BufferBuilder.RenderedBuffer renderedBuffer, Operation<Void> original) {
		if (this.world != null && !this.world.getRegistryKey().getValue().getNamespace().equals("archeon")) {
			original.call(renderedBuffer);
		}
	}
}
