package net.FTHY.monstercore;

import net.FTHY.monstercore.block.ModBlocks;
import net.FTHY.monstercore.config.ModCommonConfigs;
import net.FTHY.monstercore.item.ModCreativeModTabs;
import net.FTHY.monstercore.item.ModItems;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MonsterCore.MOD_ID)
public class MonsterCore {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "monstercore";
    public MonsterCore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfigs.SPEC, "monstercore-common.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        /**if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {//enleve les slash pour le remettre dans ingredients
            event.accept(ModItems.RAW_CLASSCORE);
            event.accept(ModItems.FCLASSCORE);
            event.accept(ModItems.ECLASSCORE);
            event.accept(ModItems.DCLASSCORE);
            event.accept(ModItems.CCLASSCORE);
            event.accept(ModItems.BCLASSCORE);
            event.accept(ModItems.ACLASSCORE);
            event.accept(ModItems.SCLASSCORE);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
        event.accept(ModBlocks.nom_block);
         }**/
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MonsterCore.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        public static KeyMapping OPEN_CONFIG_GUI;

        @SubscribeEvent
        public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
            OPEN_CONFIG_GUI = new KeyMapping("key.monstercore.toggle_config_gui", GLFW.GLFW_KEY_M, "key.categories.monstercore");
            event.register(OPEN_CONFIG_GUI);
        }
    }


    @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

    }
}
