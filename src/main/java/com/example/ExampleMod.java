// Добавь эти импорты в начало файла
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

// А это внутрь метода onInitializeClient
KeyBinding openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
    "key.example.opengui", 
    InputUtil.Type.KEYSYM, 
    GLFW.GLFW_KEY_M, // Кнопка M
    "category.example.test"
));

ClientTickEvents.END_CLIENT_TICK.register(client -> {
    while (openGuiKey.wasPressed()) {
        client.setScreen(new AzgardScreen());
    }
});
