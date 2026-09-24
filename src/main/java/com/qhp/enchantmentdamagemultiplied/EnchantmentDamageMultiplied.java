package com.qhp.enchantmentdamagemultiplied;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(EnchantmentDamageMultiplied.MOD_ID)
public final class EnchantmentDamageMultiplied {
    public static final String MOD_ID = "enchantment_damage_multiplied";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnchantmentDamageMultiplied() {
        ModLoadingContext.get().registerConfig(
            ModConfig.Type.COMMON,
            EnchantmentDamageMultipliedConfig.SPEC,
            MOD_ID + "-common.toml"
        );
        LOGGER.info("Enchantment Damage Multiplied initialized");
    }
}
