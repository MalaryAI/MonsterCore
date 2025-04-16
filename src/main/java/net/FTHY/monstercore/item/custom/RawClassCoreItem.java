package net.FTHY.monstercore.item.custom;

import net.FTHY.monstercore.config.ModCommonConfigs;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
                String itemName = rewardStack.getDisplayName().getString();

                if (!player.getInventory().add(rewardStack)) {
                    player.drop(rewardStack, false);
                }

                ResourceLocation id = ForgeRegistries.ITEMS.getKey(reward);
                if (id != null) {

                    if (isPrivateReward(id) && ModCommonConfigs.SHOW_RARE_MESSAGES.get()) {
                        player.sendSystemMessage(Component.translatable("message.monstercore.rare_item", itemName)
                                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
                    } else if (isBroadcastReward(id) && ModCommonConfigs.SHOW_LEGENDARY_MESSAGES.get()) {
                        Component message = Component.translatable("message.monstercore.legendary_item", player.getName().getString(), itemName)
                                .withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD);
                        if (player.getServer() != null) {
                            player.getServer().getPlayerList().broadcastSystemMessage(message, false);
                        }
                    }
                }

                stack.shrink(1); // Consomme 1 raw_classcore
            } else {
                player.sendSystemMessage(Component.literal("Erreur : aucun item n'a été généré."));
            }
        }

        return InteractionResultHolder.success(stack);
    }

    private Item getRandomClassCore(RandomSource random) {
        double roll = random.nextDouble() * 100; // Entre 0.0 et 100

        double shard = ModCommonConfigs.CHANCE_SHARD.get();
        double f = shard + ModCommonConfigs.CHANCE_F.get();
        double e = f + ModCommonConfigs.CHANCE_E.get();
        double d = e + ModCommonConfigs.CHANCE_D.get();
        double c = d + ModCommonConfigs.CHANCE_C.get();
        double b = c + ModCommonConfigs.CHANCE_B.get();
        double a = b + ModCommonConfigs.CHANCE_A.get();
        double s = a + ModCommonConfigs.CHANCE_S.get();

        if (roll <= shard) { // 30% (0 à 30) shard
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "raw_classcore_shard"));
        } else if (roll <= f) {// 40% (30 à 70) f
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "fclasscore"));
        } else if (roll <= e) {// 21.5% (70 à 91.5) e
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "eclasscore"));
        } else if (roll <= d) {// 5.5% (91.5 à 97)  d
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "dclasscore"));
        } else if (roll <= c) {// 2.5% (97 à 99.5)  c
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "cclasscore"));
        } else if (roll <= b) {// 0.4% (99.5 à 99.9)  b
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "bclasscore"));
        } else if (roll <= a) {// 0.09% (99.9 à 99.99)  a
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "aclasscore"));
        } else if (roll <= s) {// 0.01% (99.99 à 100)  s
            return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("monstercore", "sclasscore"));
        }
        return null;
    }

    private boolean isPrivateReward(ResourceLocation id) {
        return id.getPath().equals("raw_classcore_shard")
                || id.getPath().equals("fclasscore")
                || id.getPath().equals("eclasscore")
                || id.getPath().equals("dclasscore")
                || id.getPath().equals("cclasscore");
    }

    private boolean isBroadcastReward(ResourceLocation id) {
        return id.getPath().equals("bclasscore")
                || id.getPath().equals("aclasscore")
                || id.getPath().equals("sclasscore");
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.monstercore.raw_classcore.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
