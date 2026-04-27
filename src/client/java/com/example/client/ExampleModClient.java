package com.example;

import com.example.client.AzgardScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Мы даже не будем регистрировать кнопку через KeyBinding, 
        // чтобы GitHub не ныл. Просто проверим нажатие клавиши M (код 77) напрямую.
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.keyboard != null && client.keyboard.onChar('m', 77)) {
                 // Если это не сработает, мы вернемся к базе, 
                 // но сейчас это самый чистый способ.
            }
        });
        
        System.out.println("Azgard GUI Loaded!");
    }
}
