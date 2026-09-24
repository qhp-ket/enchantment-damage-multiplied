package com.qhp.enchantmentdamagemultiplied.mixin;

import com.qhp.enchantmentdamagemultiplied.EnchantmentDamageScaler;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public abstract class PlayerAttackMixin {
    @ModifyExpressionValue(
        method = "attack(Lnet/minecraft/world/entity/Entity;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"
        ),
        require = 1,
        expect = 2
    )
    private float enchantmentDamageMultiplied$scaleBonus(float original) {
        return EnchantmentDamageScaler.scaleEnchantmentDamage((Player) (Object) this, original);
    }
}
