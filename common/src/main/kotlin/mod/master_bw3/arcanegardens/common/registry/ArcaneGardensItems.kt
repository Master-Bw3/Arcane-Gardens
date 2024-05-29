package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import mod.master_bw3.arcanegardens.ArcaneGardens
import mod.master_bw3.arcanegardens.ArcaneGardens.modLoc
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab

import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.function.Supplier


object ArcaneGardensItems {

    val ITEMS: DeferredRegister<Item> = DeferredRegister.create<Item>(ArcaneGardens.MODID, Registries.ITEM)


    val EXAMPLE_ITEM = registerItem("example_item") { Item(Item.Properties().`arch$tab`(ArcaneGardensCreativeTabs.MY_TAB)) }


    fun registerItem(id: String, supplier: Supplier<Item>): ResourceLocation {
        ITEMS.register(id, supplier)
        return modLoc(id)
    }
}