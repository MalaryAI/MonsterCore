package net.FTHY.monstercore.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

public class RawClassCoreItem extends Item {

    public RawClassCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            Item reward = getRandomClassCore(level.random);

            if (reward != null) {
                ItemStack rewardStack = new ItemStack(reward);
                if (!player.getInventory().add(rewardStack)) {
                    player.drop(rewardStack, false);
                }

                stack.shrink(1); // Consomme 1 raw_classcore
            }
        }

        return InteractionResultHolder.success(stack);
    }

    private Item getRandomClassCore(RandomSource random) {
        double roll = random.nextDouble(); // Entre 0.0 et 1.0

        if (roll <= 0.30) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "fclasscore")); // 30%
        } else if (roll <= 0.50) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "eclasscore")); // 20%
        } else if (roll <= 0.99) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "dclasscore")); // 15%
        } else if (roll <= 0.999) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "cclasscore")); // 12%
        } else if (roll <= 0.9999) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "bclasscore")); // 10%
        } else if (roll <= 0.99999) {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "aclasscore")); // 9%
        } else {
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "sclasscore")); // 4%
        }
    }
}
