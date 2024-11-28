package com.catalytictweaks.catalytictweaksmod.mixin;

import de.maxhenkel.pipez.Upgrade;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;

@Mixin(Upgrade.class)  // Target the Upgrade enum class
public class PipezMixin {

    // Inject code into the static block of the Upgrade enum
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void modifyEnumAfterInitialization(CallbackInfo ci) {
        // Modify the enum constants after they are initialized
        for (Upgrade upgrade : Upgrade.values()) {
            try {
                // Access the fields using reflection
                Field canChangeRedstoneModeField = Upgrade.class.getDeclaredField("canChangeRedstoneMode");
                Field canChangeFilterField = Upgrade.class.getDeclaredField("canChangeFilter");
                Field canChangeDistributionModeField = Upgrade.class.getDeclaredField("canChangeDistributionMode");

                // Make the fields accessible
                canChangeRedstoneModeField.setAccessible(true);
                canChangeFilterField.setAccessible(true);
                canChangeDistributionModeField.setAccessible(true);

                // Modify the values for each upgrade
                switch (upgrade) {
                    case BASIC:
                        // Set the fields for BASIC upgrade
                        canChangeRedstoneModeField.set(upgrade, true);
                        canChangeFilterField.set(upgrade, true);
                        canChangeDistributionModeField.set(upgrade, true);
                        break;
                    case IMPROVED:
                        // Set the fields for IMPROVED upgrade
                        canChangeRedstoneModeField.set(upgrade, true);
                        canChangeFilterField.set(upgrade, true);
                        canChangeDistributionModeField.set(upgrade, true);
                        break;
                    case ADVANCED:
                        // Set the fields for ADVANCED upgrade
                        canChangeRedstoneModeField.set(upgrade, true);
                        canChangeFilterField.set(upgrade, true);
                        canChangeDistributionModeField.set(upgrade, true);
                        break;
                    case ULTIMATE:
                        // Set the fields for ULTIMATE upgrade
                        canChangeRedstoneModeField.set(upgrade, true);
                        canChangeFilterField.set(upgrade, true);
                        canChangeDistributionModeField.set(upgrade, true);
                        break;
                    case INFINITY:
                        // Set the fields for INFINITY upgrade
                        canChangeRedstoneModeField.set(upgrade, true);
                        canChangeFilterField.set(upgrade, true);
                        canChangeDistributionModeField.set(upgrade, true);
                        break;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
