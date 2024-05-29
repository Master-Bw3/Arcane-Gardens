package mod.master_bw3.arcanegardens.fabric;

import mod.master_bw3.arcanegardens.ArcaneGardens
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import java.util.function.BiConsumer

object ArcaneGardensFabric: ModInitializer {
    override fun onInitialize() {
        ArcaneGardens.init()
    }


}
