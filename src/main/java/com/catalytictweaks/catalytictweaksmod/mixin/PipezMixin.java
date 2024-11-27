package com.catalytictweaks.catalytictweaksmod.mixin;

import de.maxhenkel.pipez.Upgrade;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;

@Mixin(Upgrade.class)
public class PipezMixin {

    // This injects into the static values() method where enum constants are initialized
    @Inject(method = "values", at = @At("RETURN"))
    private static void modifyEnumAfterInitialization(CallbackInfoReturnable<Upgrade[]> cir) {
        // Loop through all enum constants and modify fields
        for (Upgrade upgrade : Upgrade.values()) {
            // Modify the "BASIC" tier booleans as an example
            if (upgrade.name().equals("BASIC")) {
                System.out.println("Modifying BASIC tier booleans!");
                try {
                    // Modify the canChangeRedstoneMode field using reflection
                    Field redstoneModeField = Upgrade.class.getDeclaredField("canChangeRedstoneMode");
                    redstoneModeField.setAccessible(true); // Make the private field accessible
                    redstoneModeField.set(upgrade, true); // Set the value to true

                    // Modify the canChangeDistributionMode field using reflection
                    Field distributionModeField = Upgrade.class.getDeclaredField("canChangeDistributionMode");
                    distributionModeField.setAccessible(true); // Make the private field accessible
                    distributionModeField.set(upgrade, true); // Set the value to true

                    // Modify the canChangeFilter field using reflection
                    Field filterField = Upgrade.class.getDeclaredField("canChangeFilter");
                    filterField.setAccessible(true); // Make the private field accessible
                    filterField.set(upgrade, true); // Set the value to true

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    // Log a simple message if an error occurs modifying the fields
                    System.out.println("Error modifying enum fields for upgrade: " + upgrade.name());
                }
            }

            // You can add similar blocks for other tiers (IMPROVED, ADVANCED, etc.)
            // For example, modifying the "IMPROVED" tier can follow the same pattern
            if (upgrade.name().equals("IMPROVED")) {
                System.out.println("Modifying IMPROVED tier booleans!");
                try {
                    Field redstoneModeField = Upgrade.class.getDeclaredField("canChangeRedstoneMode");
                    redstoneModeField.setAccessible(true);
                    redstoneModeField.set(upgrade, true);

                    Field distributionModeField = Upgrade.class.getDeclaredField("canChangeDistributionMode");
                    distributionModeField.setAccessible(true);
                    distributionModeField.set(upgrade, true);

                    Field filterField = Upgrade.class.getDeclaredField("canChangeFilter");
                    filterField.setAccessible(true);
                    filterField.set(upgrade, true);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    System.out.println("Error modifying enum fields for upgrade: " + upgrade.name());
                }
            }

            // Similarly, you can modify ADVANCED, ULTIMATE, INFINITY tiers
            // For now, just adding the "BASIC" and "IMPROVED" tiers as examples
        }
    }
}