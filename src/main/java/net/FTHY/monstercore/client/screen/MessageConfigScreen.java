package net.FTHY.monstercore.client.screen;

import net.FTHY.monstercore.config.ModCommonConfigs;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class MessageConfigScreen extends Screen {

    public MessageConfigScreen() {
        super(Component.translatable("menu.monstercore.config"));
    }

    @Override
    protected void init() {
        int y = this.height / 4;

        Button rareButton = Button.builder(
                getRareLabel(),
                button -> {
                    ModCommonConfigs.SHOW_RARE_MESSAGES.set(!ModCommonConfigs.SHOW_RARE_MESSAGES.get());
                    button.setMessage(getRareLabel());
                    ModCommonConfigs.save();
                }).bounds(this.width / 2 - 100, y, 200, 20).build();

        Button legendaryButton = Button.builder(
                getLegendaryLabel(),
                button -> {
                    ModCommonConfigs.SHOW_LEGENDARY_MESSAGES.set(!ModCommonConfigs.SHOW_LEGENDARY_MESSAGES.get());
                    button.setMessage(getLegendaryLabel());
                    ModCommonConfigs.save();
                }).bounds(this.width / 2 - 100, y + 25, 200, 20).build();

        this.addRenderableWidget(rareButton);
        this.addRenderableWidget(legendaryButton);
    }

    private Component getRareLabel() {
        return Component.translatable("option.monstercore.rare_messages").append(": ")
                .append(ModCommonConfigs.SHOW_RARE_MESSAGES.get() ? "§aON" : "§cOFF");
    }

    private Component getLegendaryLabel() {
        return Component.translatable("option.monstercore.legendary_messages").append(": ")
                .append(ModCommonConfigs.SHOW_LEGENDARY_MESSAGES.get() ? "§aON" : "§cOFF");
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}