package net.FTHY.monstercore.client;

import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.client.screen.MessageConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MonsterCore.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (KeyBindingHandler.TOGGLE_MESSAGE_SCREEN != null &&
                KeyBindingHandler.TOGGLE_MESSAGE_SCREEN.consumeClick()) {
            Minecraft.getInstance().setScreen(new MessageConfigScreen());
        }
    }
}
