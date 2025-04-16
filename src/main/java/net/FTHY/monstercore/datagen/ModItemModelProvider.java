package net.FTHY.monstercore.datagen;

import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MonsterCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_CLASSCORE.get());
        basicItem(ModItems.RAW_CLASSCORE_SHARD.get());

        basicItem(ModItems.FCLASSCORE.get());
        basicItem(ModItems.ECLASSCORE.get());
        basicItem(ModItems.DCLASSCORE.get());
        basicItem(ModItems.CCLASSCORE.get());
        basicItem(ModItems.BCLASSCORE.get());
        basicItem(ModItems.ACLASSCORE.get());
        basicItem(ModItems.SCLASSCORE.get());

    }

    private void basicItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MonsterCore.MOD_ID, "item/" + item.getId().getPath()));
    }
}
