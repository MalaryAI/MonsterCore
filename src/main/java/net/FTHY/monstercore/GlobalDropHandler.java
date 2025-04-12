package net.FTHY.monstercore;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static net.FTHY.monstercore.MonsterCore.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class GlobalDropHandler {

    @SubscribeEvent
    public static void onMobDrop(LivingDropsEvent event) {
        Level level = event.getEntity().level();
        if (!level.isClientSide()) {
            // ⚠️ uniquement pour les mobs hostiles :
            if (!(event.getEntity() instanceof Monster)) return;

            double chance = 0.4;
            if (level.random.nextDouble() <= chance) {
                // Récupère l’item "monstercore:raw_classcore"
                Item rawCore = ForgeRegistries.ITEMS.getValue(new ResourceLocation("monstercore", "raw_classcore"));
                if (rawCore != null) {
                    ItemStack dropStack = new ItemStack(rawCore);
                    ItemEntity drop = new ItemEntity(
                            level,
                            event.getEntity().getX(),
                            event.getEntity().getY(),
                            event.getEntity().getZ(),
                            dropStack
                    );
                    event.getDrops().add(drop);
                }
            }
        }
    }
}
