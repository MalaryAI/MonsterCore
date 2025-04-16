package net.FTHY.monstercore.item;

import net.FTHY.monstercore.MonsterCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonsterCore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MONSTERCORE_TAB = CREATIVE_MODE_TABS.register("monstercore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_CLASSCORE.get()))
                    .title(Component.translatable("creativetab.monstercore.monstercore_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_CLASSCORE.get());
                        output.accept(ModItems.RAW_CLASSCORE_SHARD.get());
                        output.accept(ModItems.FCLASSCORE.get());
                        output.accept(ModItems.ECLASSCORE.get());
                        output.accept(ModItems.DCLASSCORE.get());
                        output.accept(ModItems.CCLASSCORE.get());
                        output.accept(ModItems.BCLASSCORE.get());
                        output.accept(ModItems.ACLASSCORE.get());
                        output.accept(ModItems.SCLASSCORE.get());
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
