package com.example;

import com.example.client.AzgardScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ExampleModClient implements ClientModInitializer {
    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        // Регистрация кнопки
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.azgard.open", 
            InputUtil.Type.KEYSYM, 
            GLFW.GLFW_KEY_M, 
            "category.azgard.client"
        ));

        // Проверка нажатия каждый тик
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                client.setScreen(new AzgardScreen());
            }
        });
    }
}
