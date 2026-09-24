package com.qhp.enchantmentdamagemultiplied;

import net.minecraftforge.common.ForgeConfigSpec;

public final class EnchantmentDamageMultipliedConfig {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ENABLED;
    public static final ForgeConfigSpec.BooleanValue APPLY_ADDITION;
    public static final ForgeConfigSpec.BooleanValue APPLY_MULTIPLY_BASE;
    public static final ForgeConfigSpec.BooleanValue APPLY_MULTIPLY_TOTAL;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLED = builder
            .comment("Enable enchantment damage scaling during vanilla player melee attacks.")
            .define("enabled", true);
        APPLY_ADDITION = builder
            .comment("Apply ADDITION attack damage modifiers to the enchantment damage bonus.")
            .define("applyAddition", false);
        APPLY_MULTIPLY_BASE = builder
            .comment("Apply MULTIPLY_BASE attack damage modifiers to the enchantment damage bonus.")
            .define("applyMultiplyBase", true);
        APPLY_MULTIPLY_TOTAL = builder
            .comment("Apply MULTIPLY_TOTAL attack damage modifiers to the enchantment damage bonus.")
            .define("applyMultiplyTotal", true);

        SPEC = builder.build();
    }

    private EnchantmentDamageMultipliedConfig() {}
}
