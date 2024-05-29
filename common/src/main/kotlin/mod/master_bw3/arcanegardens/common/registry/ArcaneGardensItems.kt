package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import mod.master_bw3.arcanegardens.ArcaneGardens
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab

import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.function.Supplier


object ArcaneGardensItems {

    val ITEMS = DeferredRegister.create<Item>(ArcaneGardens.MODID, Registries.ITEM)

    init {
        registerItem("example_item") { Item(Item.Properties().`arch$tab`(ArcaneGardensCreativeTabs.MY_TAB)) }
    }

    fun registerItem(id: String, supplier: Supplier<Item>) {
        ITEMS.register(id, supplier)
    }
}