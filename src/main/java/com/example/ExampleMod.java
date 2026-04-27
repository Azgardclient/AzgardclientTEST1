package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (client.options.allKeys[77].wasPressed()) {
                client.setScreen(new Screen(Text.literal("Azgard")) {
                    @Override
                    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
                        context.fill(width / 2 - 100, height / 2 - 70, width / 2 + 100, height / 2 + 70, 0xBB000000);
                        context.fill(width / 2 - 100, height / 2 - 72, width / 2 + 100, height / 2 - 70, 0xFFFFFFFF);
                        context.drawCenteredTextWithShadow(this.textRenderer, "AZGARD CLIENT", width / 2, height / 2 - 60, 0xFFFFFFFF);
                        super.render(context, mouseX, mouseY, delta);
                    }
                });
            }
        });
    }
}
