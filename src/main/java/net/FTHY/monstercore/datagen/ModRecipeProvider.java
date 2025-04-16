package net.FTHY.monstercore.datagen;

import net.FTHY.monstercore.MonsterCore;
import net.FTHY.monstercore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.FCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.FCLASSCORE.get()), has(ModItems.FCLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DCLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ECLASSCORE.get())
                .unlockedBy(getHasName(ModItems.ECLASSCORE.get()), has(ModItems.ECLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CCLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.DCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.DCLASSCORE.get()), has(ModItems.DCLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BCLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.CCLASSCORE.get()), has(ModItems.CCLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ACLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.BCLASSCORE.get()), has(ModItems.ECLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SCLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ACLASSCORE.get())
                .unlockedBy(getHasName(ModItems.ACLASSCORE.get()), has(ModItems.ACLASSCORE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_CLASSCORE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_CLASSCORE_SHARD.get())
                .unlockedBy(getHasName(ModItems.RAW_CLASSCORE_SHARD.get()), has(ModItems.RAW_CLASSCORE_SHARD.get())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FCLASSCORE.get(), 9)
                .requires(ModItems.ECLASSCORE.get())
                .unlockedBy(getHasName(ModItems.ECLASSCORE.get()), has(ModItems.ECLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_eclasscore");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECLASSCORE.get(), 9)
                .requires(ModItems.DCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.DCLASSCORE.get()), has(ModItems.DCLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_dclasscore");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DCLASSCORE.get(), 9)
                .requires(ModItems.CCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.CCLASSCORE.get()), has(ModItems.CCLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_cclasscore");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CCLASSCORE.get(), 9)
                .requires(ModItems.BCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.BCLASSCORE.get()), has(ModItems.BCLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_bclasscore");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BCLASSCORE.get(), 9)
                .requires(ModItems.ACLASSCORE.get())
                .unlockedBy(getHasName(ModItems.ACLASSCORE.get()), has(ModItems.ACLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_aclasscore");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ACLASSCORE.get(), 9)
                .requires(ModItems.SCLASSCORE.get())
                .unlockedBy(getHasName(ModItems.SCLASSCORE.get()), has(ModItems.SCLASSCORE.get()))
                .save(pWriter, MonsterCore.MOD_ID + ":uncraft_sclasscore");
    }
}
