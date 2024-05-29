package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import mod.master_bw3.arcanegardens.ArcaneGardens.MODID
import mod.master_bw3.arcanegardens.ArcaneGardens.modLoc
import mod.master_bw3.arcanegardens.common.blocks.BlockLog
import mod.master_bw3.arcanegardens.common.blocks.FurnaceBlock
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs.MY_TAB
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems.ITEMS
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import java.util.function.Supplier


object ArcaneGardensBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create<Block>(MODID, Registries.BLOCK)

    val EXAMPLE_BLOCK = registerBlockAndBlockItem("example_block", MY_TAB) { BlockLog(BlockProperties.woody(MapColor.COLOR_BROWN)) }

    val FURNACE_BLOCK = registerBlockAndBlockItem("furnace", MY_TAB) { FurnaceBlock(BlockProperties.woody(MapColor.COLOR_BROWN)) }




    fun registerBlock(id: String, supplier: Supplier<Block>): ResourceLocation {
        BLOCKS.register(id, supplier)
        return modLoc(id)
    }

    fun registerBlockAndBlockItem(id: String, supplier: Supplier<Block>): ResourceLocation {
        BLOCKS.register(id) {
            supplier.get().also {
                ITEMS.register(id) {
                    BlockItem(it, Item.Properties())
                }
            }
        }
        return modLoc(id)
    }

    fun registerBlockAndBlockItem(id: String, tab: RegistrySupplier<CreativeModeTab>, supplier: Supplier<Block>): ResourceLocation {
        BLOCKS.register(id) {
            supplier.get().also {
                ITEMS.register(id) {
                    BlockItem(it, Item.Properties().`arch$tab`(tab))
                }
            }
        }
        return modLoc(id)
    }

}

object BlockProperties {
    fun woody(color: MapColor): BlockBehaviour.Properties {
        return BlockBehaviour.Properties
            .ofFullCopy(Blocks.OAK_LOG)
            .mapColor(color)
            .sound(SoundType.WOOD)
            .strength(2f)
    }
}