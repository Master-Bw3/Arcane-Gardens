package mod.master_bw3.arcanegardens.fabric;

import mod.master_bw3.arcanegardens.ArcaneGardens;
import net.fabricmc.api.ModInitializer;

object ArcaneGardensFabric: ModInitializer {
    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ArcaneGardens.init();
    }
}
