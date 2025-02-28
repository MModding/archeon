package com.mmodding.archeon.client.screens;

import com.mmodding.archeon.Archeon;
import com.mmodding.archeon.items.LoreScrapItem;
import com.mmodding.mmodding_lib.library.colors.Color;
import com.mmodding.mmodding_lib.library.utils.TextUtils;
import com.mmodding.mmodding_lib.library.utils.TextureLocation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;

public class LoreScrapScreen extends Screen {

	public static final Style LORE_SCRAP = TextUtils.createStyle(null, null, null, null, null, null, null, null, null, Archeon.createId("lore_scrap"));

	private final MutableText display;
	private final int backgroundWidth;
	private final int backgroundHeight;

	public LoreScrapScreen(LoreScrapItem.LoreData data) {
		super(data.getTitle());
		this.display = data.getDescription();
		this.backgroundWidth = 200;
		this.backgroundHeight = 250;
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		int x = (this.width / 2 - this.backgroundWidth / 2) + 16;
		int max = this.backgroundWidth - this.backgroundWidth / 7;
		int startY = (this.height / 4 - this.backgroundHeight / 4) + 26;
		int endY = startY + this.backgroundHeight - 50;
		TextUtils.drawCenteredTrimmed(this.textRenderer, this.display.fillStyle(LoreScrapScreen.LORE_SCRAP), x, max, startY, endY, Color.BLANK.get().toDecimal());
	}

	@Override
	public void renderBackground(MatrixStack matrices) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, new TextureLocation(Archeon.id(), "gui/lore_scrap"));
		int x = this.width / 2 - this.backgroundWidth / 2;
		int y = this.height / 4 - this.backgroundHeight / 4;
		DrawableHelper.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight, 200, 250);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
