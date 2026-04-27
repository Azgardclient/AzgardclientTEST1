package com.example;

import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Этот метод выполняется и на сервере, и на клиенте.
        // Здесь мы ничего не рисуем!
        System.out.println("Azgard Mod Initialized!");
    }
}