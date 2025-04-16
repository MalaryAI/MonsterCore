package net.FTHY.monstercore.datagen;

import net.FTHY.monstercore.MonsterCore;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MonsterCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        /**this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.nom_block.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.nom_block.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.nom_block.get());**/
    }
}
