package net.FTHY.monstercore.item;

import net.FTHY.monstercore.MonsterCore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MonsterCore.MOD_ID);

    public static final RegistryObject<Item> RAW_CLASSCORE = ITEMS.register("raw_classcore",
            () -> new RawClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> FCLASSCORE = ITEMS.register("fclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ECLASSCORE = ITEMS.register("eclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DCLASSCORE = ITEMS.register("dclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CCLASSCORE = ITEMS.register("cclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BCLASSCORE = ITEMS.register("bclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ACLASSCORE = ITEMS.register("aclasscore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCLASSCORE = ITEMS.register("sclasscore",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
