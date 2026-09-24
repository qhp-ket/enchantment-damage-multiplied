package com.qhp.enchantmentdamagemultiplied;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public final class EnchantmentDamageScaler {
    private EnchantmentDamageScaler() {}

    public static float scaleEnchantmentDamage(Player player, float original) {
        if (!EnchantmentDamageMultipliedConfig.ENABLED.get()) {
            return original;
        }

        if (original == 0.0F) {
            return 0.0F;
        }

        AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attribute == null) {
            return original;
        }

        double base = original;
        if (EnchantmentDamageMultipliedConfig.APPLY_ADDITION.get()) {
            for (AttributeModifier modifier : attribute.getModifiers(AttributeModifier.Operation.ADDITION)) {
                base += modifier.getAmount();
            }
        }

        double value = base;
        if (EnchantmentDamageMultipliedConfig.APPLY_MULTIPLY_BASE.get()) {
            for (AttributeModifier modifier : attribute.getModifiers(AttributeModifier.Operation.MULTIPLY_BASE)) {
                value += base * modifier.getAmount();
            }
        }

        if (EnchantmentDamageMultipliedConfig.APPLY_MULTIPLY_TOTAL.get()) {
            for (AttributeModifier modifier : attribute.getModifiers(AttributeModifier.Operation.MULTIPLY_TOTAL)) {
                value *= 1.0D + modifier.getAmount();
            }
        }

        return (float) value;
    }
}
