package com.qhp.enchantmentdamagemultiplied;

import net.minecraftforge.common.ForgeConfigSpec;

public final class EnchantmentDamageMultipliedConfig {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue enabled;
    public static final ForgeConfigSpec.BooleanValue addition;
    public static final ForgeConfigSpec.BooleanValue multiplyBase;
    public static final ForgeConfigSpec.BooleanValue multiplyTotal;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        enabled = builder
            .comment("Master switch for enchantment damage scaling.")
            .define("enabled", true);
        addition = builder
            .comment("Apply ATTACK_DAMAGE ADDITION modifiers to the enchantment damage bonus.")
            .define("addition", false);
        multiplyBase = builder
            .comment("Apply ATTACK_DAMAGE MULTIPLY_BASE modifiers to the enchantment damage bonus.")
            .define("multiply_base", true);
        multiplyTotal = builder
            .comment("Apply ATTACK_DAMAGE MULTIPLY_TOTAL modifiers to the enchantment damage bonus.")
            .define("multiply_total", true);

        SPEC = builder.build();
    }

    private EnchantmentDamageMultipliedConfig() {
    }
}
