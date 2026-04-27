package com.example;

import com.example.client.AzgardScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;

public class ExampleModClient implements ClientModInitializer {
    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        // Регистрируем кнопку через ID (77 — это клавиша M)
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.azgard.open", 
            77, 
            "category.azgard.client"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                client.setScreen(new AzgardScreen());
            }
        });
    }
}
