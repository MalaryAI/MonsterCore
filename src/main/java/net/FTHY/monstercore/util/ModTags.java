package net.FTHY.monstercore.util;

import net.FTHY.monstercore.MonsterCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MonsterCore.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> CLASSCORE = createTag("classcore");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(MonsterCore.MOD_ID, name));
        }
    }
}
