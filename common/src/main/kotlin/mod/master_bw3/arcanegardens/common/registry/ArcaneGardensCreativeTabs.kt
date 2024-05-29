package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.CreativeTabRegistry
import dev.architectury.registry.registries.DeferredRegister
import mod.master_bw3.arcanegardens.ArcaneGardens.MODID
import mod.master_bw3.arcanegardens.ArcaneGardens.modLoc
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import java.util.function.Supplier


object ArcaneGardensCreativeTabs {
    val TABS = DeferredRegister.create(MODID, Registries.CREATIVE_MODE_TAB)

    val MY_TAB = TABS.register<CreativeModeTab>(
        "test_tab"
    )  // Tab ID
    {
        CreativeTabRegistry.create(
            Component.translatable("category.architectury_test"),  // Tab Name
            Supplier<ItemStack> {
                ItemStack(
                    ArcaneGardensItems.ITEMS.first { it.`is`(modLoc("example_item")) }
                )
            } // Icon
        )
    }
}