package com.example.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class AzgardScreen extends Screen {
    public AzgardScreen() {
        super(Text.literal("Azgard Client Menu"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context); // Затемнение фона
        context.drawCenteredTextWithShadow(this.textRenderer, "Azgard Client v1.0", this.width / 2, 40, 0xFFFFFF);
        context.drawCenteredTextWithShadow(this.textRenderer, "Нажми ESC чтобы выйти", this.width / 2, 60, 0xAAAAAA);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false; // Игра не будет ставиться на паузу в одиночке
    }
}
