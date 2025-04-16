package net.FTHY.monstercore.datagen;

import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.item.ModItems;
import net.FTHY.monstercore.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, MonsterCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
    tag(ModTags.Items.CLASSCORE)
            .add(ModItems.FCLASSCORE.get())
            .add(ModItems.ECLASSCORE.get())
            .add(ModItems.DCLASSCORE.get())
            .add(ModItems.CCLASSCORE.get())
            .add(ModItems.BCLASSCORE.get())
            .add(ModItems.ACLASSCORE.get())
            .add(ModItems.SCLASSCORE.get());
    }
}
