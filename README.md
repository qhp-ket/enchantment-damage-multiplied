# Enchantment Damage Multiplied

A focused Forge 1.20.1 mod that applies selected `generic.attack_damage` attribute modifier operations to the enchantment damage bonus in vanilla player melee attacks.

## Damage model

The mod scales the value returned by `EnchantmentHelper.getDamageBonus(ItemStack, MobType)` in `Player.attack`. It preserves Minecraft's operation order: `ADDITION` modifiers first, then each `MULTIPLY_BASE` modifier using the same adjusted base, and finally each `MULTIPLY_TOTAL` modifier in sequence. A zero enchantment bonus remains zero.

## Scope

Modded enchantments that contribute through the same `getDamageBonus` path are included. Custom damage paths are outside this mod's scope. Projectile damage, including arrows and thrown tridents, is not modified. The mod does not change the player's live `ATTACK_DAMAGE` attribute.

## Configuration

The Forge `COMMON` config is generated at `config/enchantment_damage_multiplied-common.toml`:

```toml
enabled = true
addition = false
multiply_base = true
multiply_total = true
```

`enabled` is the master switch. `addition`, `multiply_base`, and `multiply_total` independently control the corresponding `ATTACK_DAMAGE` modifier operation when scaling the enchantment bonus. Forge watches the common config and applies valid changes while running; a restart is normally unnecessary.

## Build

Requirements: Java 17, Minecraft 1.20.1, Forge 47.4.23.

```text
gradlew.bat clean build
```

The complete release JAR (including MixinExtras through Jar-in-Jar) is the JAR in `build/libs` without the `-slim` suffix. The `-slim` JAR does not bundle MixinExtras and is not the recommended release artifact.

## License

GNU General Public License v3.0. See [LICENSE](LICENSE).
