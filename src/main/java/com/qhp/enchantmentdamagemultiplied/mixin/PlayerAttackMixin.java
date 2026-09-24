package com.qhp.enchantmentdamagemultiplied.mixin;

import com.qhp.enchantmentdamagemultiplied.EnchantmentDamageScaler;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerAttackMixin {
    @Redirect(
        method = "attack(Lnet/minecraft/world/entity/Entity;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"
        ),
        require = 1,
        expect = 2
    )
    private float enchantmentDamageMultiplied$scaleBonus(ItemStack stack, MobType mobType) {
        float original = EnchantmentHelper.getDamageBonus(stack, mobType);
        return EnchantmentDamageScaler.scaleEnchantmentDamage((Player) (Object) this, original);
    }
}
