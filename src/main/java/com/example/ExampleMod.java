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
            // Кнопка M (код 77)
            while (client.options.allKeys[77].wasPressed()) {
                client.setScreen(new Screen(Text.literal("Nursultan Style")) {
                    
                    @Override
                    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
                        // 1. Рисуем основной фон (темный полупрозрачный прямоугольник)
                        // Координаты: x1, y1, x2, y2, цвет (HEX с прозрачностью)
                        context.fill(width / 2 - 100, height / 2 - 70, width / 2 + 100, height / 2 + 70, 0xBB000000);
                        
                        // 2. Тонкая верхняя полоска (как в Nursultan)
                        context.fill(width / 2 - 100, height / 2 - 72, width / 2 + 100, height / 2 - 70, 0xFFFFFFFF);

                        // 3. Заголовок
                        context.drawCenteredTextWithShadow(this.textRenderer, "AZGARD", width / 2, height / 2 - 60, 0xFFFFFFFF);
                        
                        // 4. Разделительная линия
                        context.fill(width / 2 - 90, height / 2 - 45, width / 2 + 90, height / 2 - 44, 0x44FFFFFF);

                        // 5. Список модулей (пример того, как это будет выглядеть)
                        int yOffset = height / 2 - 30;
                        drawModule(context, "Killaura", yOffset, true);
                        drawModule(context, "Velocity", yOffset + 15, false);
                        drawModule(context, "Fly", yOffset + 30, true);
                        drawModule(context, "Sprint", yOffset + 45, false);

                        super.render(context, mouseX, mouseY, delta);
                    }

                    // Метод для красивой отрисовки строчки модуля
                    private void drawModule(DrawContext context, String name, int y, boolean enabled) {
                        int color = enabled ? 0xFFFFFFFF : 0x88AAAAAA;
                        String status = enabled ? "[ON]" : "[OFF]";
                        context.drawText(this.textRenderer, name, width / 2 - 90, y, color, false);
                        context.drawText(this.textRenderer, status, width / 2 + 60, y, color, false);
                    }

                    @Override
                    public boolean shouldPause() { return false; }
                });
            }
});
    }
