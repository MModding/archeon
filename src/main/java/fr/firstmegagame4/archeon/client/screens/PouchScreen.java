package fr.firstmegagame4.archeon.client.screens;

import com.mmodding.mmodding_lib.library.colors.Color;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import com.mojang.blaze3d.systems.RenderSystem;
import fr.firstmegagame4.archeon.Archeon;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class PouchScreen extends HandledScreen<ScreenHandler> {

	public PouchScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
		this.backgroundWidth = 191;
		this.backgroundHeight = 176;
	}

	@Override
	protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
		this.textRenderer.draw(matrices, this.title, this.titleX, this.titleY, Color.rgb(136, 75, 43).toDecimal());
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, new TextureLocation(Archeon.id(), "gui/container/pouch"));
		int x = (this.width - this.backgroundWidth) / 2 - 8;
		int y = (this.height - this.backgroundHeight) / 2 - 9;
		this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
		this.drawMouseoverTooltip(matrices, mouseX, mouseY);
	}
}
