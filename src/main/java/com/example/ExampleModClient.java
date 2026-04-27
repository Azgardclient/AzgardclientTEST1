package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Кнопка M (код 77)
            while (client.options.allKeys[77].wasPressed()) {
                client.setScreen(new Screen(Text.literal("Azgard")) {
                    @Override
                    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
                        // Фон
                        context.fill(width / 2 - 100, height / 2 - 70, width / 2 + 100, height / 2 + 70, 0xBB000000);
                        // Полоска сверху
                        context.fill(width / 2 - 100, height / 2 - 72, width / 2 + 100, height / 2 - 70, 0xFFFFFFFF);
                        // Текст
                        context.drawCenteredTextWithShadow(this.textRenderer, "AZGARD CLIENT 1.21.4", width / 2, height / 2 - 60, 0xFFFFFFFF);
                        super.render(context, mouseX, mouseY, delta);
                    }
                    
                    @Override
                    public boolean shouldPause() { return false; }
                });
            }
        });
    }
}