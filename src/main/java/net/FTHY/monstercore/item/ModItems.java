package net.FTHY.monstercore.item;

import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.item.custom.FClassCoreItem;
import net.FTHY.monstercore.item.custom.EClassCoreItem;
import net.FTHY.monstercore.item.custom.DClassCoreItem;
import net.FTHY.monstercore.item.custom.CClassCoreItem;
import net.FTHY.monstercore.item.custom.BClassCoreItem;
import net.FTHY.monstercore.item.custom.AClassCoreItem;
import net.FTHY.monstercore.item.custom.SClassCoreItem;
import net.FTHY.monstercore.item.custom.RawClassCoreItem;
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
    public static final RegistryObject<Item> RAW_CLASSCORE_SHARD = ITEMS.register("raw_classcore_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FCLASSCORE = ITEMS.register("fclasscore",
            () -> new FClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> ECLASSCORE = ITEMS.register("eclasscore",
            () -> new EClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> DCLASSCORE = ITEMS.register("dclasscore",
            () -> new DClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> CCLASSCORE = ITEMS.register("cclasscore",
            () -> new CClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> BCLASSCORE = ITEMS.register("bclasscore",
            () -> new BClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> ACLASSCORE = ITEMS.register("aclasscore",
            () -> new AClassCoreItem(new Item.Properties()));
    public static final RegistryObject<Item> SCLASSCORE = ITEMS.register("sclasscore",
            () -> new SClassCoreItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
