package com.example;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class AzgardScreen extends Screen {
    public AzgardScreen() {
        super(Text.literal("Azgard Menu"));
    }

    @Override
    protected void init() {
        // Кнопка закрытия
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Закрыть"), button -> this.close())
            .dimensions(this.width / 2 - 50, this.height / 2, 100, 20)
            .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 50, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
