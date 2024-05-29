package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import mod.master_bw3.arcanegardens.ArcaneGardens.MODID
import mod.master_bw3.arcanegardens.common.blocks.BlockLog
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs.MY_TAB
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems.ITEMS
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor


object ArcaneGardensBlocks {
    val BLOCKS = DeferredRegister.create<Block>(MODID, Registries.BLOCK)

    val EXAMPLE_BLOCK: RegistrySupplier<Block> = BLOCKS.register("example_block") {
        BlockLog(BlockProperties.woody(MapColor.COLOR_BROWN))
    }

    val EXAMPLE_BLOCK_ITEM: RegistrySupplier<Item> = ITEMS.register("example_block") {
        BlockItem(EXAMPLE_BLOCK.get(), Item.Properties())
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