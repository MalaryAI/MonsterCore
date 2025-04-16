package net.FTHY.monstercore.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.client.screen.MessageConfigScreen;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = MonsterCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindingHandler {
    public static KeyMapping TOGGLE_MESSAGE_SCREEN;

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        TOGGLE_MESSAGE_SCREEN = new KeyMapping("key.monstercore.toggle_message_screen",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                "key.categories.misc");

        event.register(TOGGLE_MESSAGE_SCREEN);
    }
}
