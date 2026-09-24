# Enchantment Damage Multiplied

Enchantment Damage Multiplied makes enchantment damage bonuses used by vanilla player melee attacks share selected `minecraft:generic.attack_damage` AttributeModifier operations.

This project is licensed under the GNU General Public License v3.0. See [LICENSE](LICENSE).

The mod registers a Forge `COMMON` config at `config/enchantment_damage_multiplied-common.toml`. Its defaults are:

```toml
enabled = true
applyAddition = false
applyMultiplyBase = true
applyMultiplyTotal = true
```

`enabled` turns this mod's scaling on or off. The three `apply...` settings independently select which `ATTACK_DAMAGE` attribute modifier operations are applied to the enchantment bonus. Forge watches the common config file and reloads valid edits while running, so a restart is normally unnecessary.

This scales the bonus returned by the normal `EnchantmentHelper.getDamageBonus(ItemStack, MobType)` call inside `Player.attack`. Modded enchantments contributing through the same damage-bonus path are included automatically. Enchantments implementing their own damage path are outside this mod's scope. Projectile damage, including thrown tridents and arrows, is not handled. There is no config GUI.

Build with Java 17 using `gradlew build`. The resulting JAR is in `build/libs`.
