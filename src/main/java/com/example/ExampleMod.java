import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;

public class MyCustomScreen extends Screen {
    public MyCustomScreen() {
        super(Text.literal("Мое Кастомное Меню"));
    }

    @Override
    protected void init() {
        // Добавляем кнопку
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Нажми меня"), button -> {
            System.out.println("Кнопка нажата!");
        })
        .dimensions(this.width / 2 - 100, this.height / 2, 200, 20) // Позиция и размер
        .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Затемнение заднего фона
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
