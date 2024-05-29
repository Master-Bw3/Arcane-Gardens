package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import mod.master_bw3.arcanegardens.ArcaneGardens
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs.MY_TAB
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import java.util.function.BiConsumer
import java.util.function.Supplier

object ArcaneGardensItems {

    val ITEMS = DeferredRegister.create<Item>(ArcaneGardens.MODID, Registries.ITEM)

    val EXAMPLE_ITEM = ITEMS.register(
        "example_item"
    ) { Item(Item.Properties().`arch$tab`(MY_TAB)) }

//    fun registerItems(r: BiConsumer<Item, ResourceLocation>) {
//        for ((key, value) in ITEMS) {
//            r.accept(value, key)
//        }
//    }
//
//    fun registerItemCreativeTab(r: CreativeModeTab.Output, tab: CreativeModeTab) {
//        for (item in ITEM_TABS.getOrDefault(tab, listOf())) {
//            item.register(r)
//        }
//    }
//
//    private val ITEMS: MutableMap<ResourceLocation, Item> = LinkedHashMap() // preserve insertion order
//
//    private val ITEM_TABS: MutableMap<CreativeModeTab, List<TabEntry>> =
//        LinkedHashMap<CreativeModeTab, List<TabEntry>>()
//
//    fun props(): Item.Properties {
//        return Item.Properties()
//    }
//
//    private abstract class TabEntry {
//        abstract fun register(r: CreativeModeTab.Output?)
//        internal class ItemEntry(private val item: Item) : TabEntry() {
//            override fun register(r: CreativeModeTab.Output?) {
//                r?.accept(item)
//            }
//        }
//
//        internal class StackEntry(private val stack: Supplier<ItemStack>) : TabEntry() {
//            override fun register(r: CreativeModeTab.Output?) {
//                r?.accept(stack.get())
//            }
//        }
//    }

}