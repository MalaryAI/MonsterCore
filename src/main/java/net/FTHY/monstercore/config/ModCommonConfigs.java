package net.FTHY.monstercore.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue SHOW_RARE_MESSAGES;
    public static final ForgeConfigSpec.BooleanValue SHOW_LEGENDARY_MESSAGES;

    public static final ForgeConfigSpec.DoubleValue CHANCE_SHARD;
    public static final ForgeConfigSpec.DoubleValue CHANCE_F;
    public static final ForgeConfigSpec.DoubleValue CHANCE_E;
    public static final ForgeConfigSpec.DoubleValue CHANCE_D;
    public static final ForgeConfigSpec.DoubleValue CHANCE_C;
    public static final ForgeConfigSpec.DoubleValue CHANCE_B;
    public static final ForgeConfigSpec.DoubleValue CHANCE_A;
    public static final ForgeConfigSpec.DoubleValue CHANCE_S;

    static {
        BUILDER.push("Message display");

        SHOW_RARE_MESSAGES = BUILDER.comment("Show Client Drop Messages ? (ex: shard, F, E, D, C)")
                .define("showRareMessages", true);  // Par défaut activé

        SHOW_LEGENDARY_MESSAGES = BUILDER.comment("Show Server Legendary Drop Messages ? (ex: B, A, S)")
                .define("showLegendaryMessages", true);  // Par défaut activé

        BUILDER.pop();

        BUILDER.push("Class Core Drop Chances (%)");

        CHANCE_SHARD = BUILDER.comment("Drop chance for Raw Class Core Shard")
                .defineInRange("chanceShard", 30.0, 0.0, 100.0);
        CHANCE_F = BUILDER.comment("Drop chance for F-Class Core")
                .defineInRange("chanceF", 40.0, 0.0, 100.0);
        CHANCE_E = BUILDER.comment("Drop chance for E-Class Core")
                .defineInRange("chanceE", 21.5, 0.0, 100.0);
        CHANCE_D = BUILDER.comment("Drop chance for D-Class Core")
                .defineInRange("chanceD", 5.5, 0.0, 100.0);
        CHANCE_C = BUILDER.comment("Drop chance for C-Class Core")
                .defineInRange("chanceC", 2.5, 0.0, 100.0);
        CHANCE_B = BUILDER.comment("Drop chance for B-Class Core")
                .defineInRange("chanceB", 0.4, 0.0, 100.0);
        CHANCE_A = BUILDER.comment("Drop chance for A-Class Core")
                .defineInRange("chanceA", 0.09, 0.0, 100.0);
        CHANCE_S = BUILDER.comment("Drop chance for S-Class Core")
                .defineInRange("chanceS", 0.01, 0.0, 100.0);

        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static void save() {
        if (SPEC != null) {
            SPEC.save();
        }
    }
}

