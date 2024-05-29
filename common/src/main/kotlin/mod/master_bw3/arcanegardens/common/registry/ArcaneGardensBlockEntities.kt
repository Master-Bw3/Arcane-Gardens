package mod.master_bw3.arcanegardens.common.registry

import dev.architectury.registry.registries.DeferredRegister
import mod.master_bw3.arcanegardens.ArcaneGardens
import mod.master_bw3.arcanegardens.common.blocks.FurnaceBlockEntity
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks.BLOCKS
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks.FURNACE_BLOCK
import mod.master_bw3.arcanegardens.util.BlockEntityTypeBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType

object ArcaneGardensBlockEntities {
        val BLOCK_ENTITIES: DeferredRegister<BlockEntityType<*>> = DeferredRegister.create(ArcaneGardens.MODID, Registries.BLOCK_ENTITY_TYPE)


        val FURNACE_BLOCK_ENTITY = registerBlockEntity("furnace_block_entity", ::FurnaceBlockEntity, FURNACE_BLOCK)


        fun<T: BlockEntity> registerBlockEntity(id: String, blockSupplier: BlockEntityType.BlockEntitySupplier<out T>, block: ResourceLocation): ResourceLocation {
            val supplier = {BlockEntityTypeBuilder.build(BlockEntityType.Builder.of(blockSupplier, BLOCKS.first {it.`is`(block)}.get()), null)}
            BLOCK_ENTITIES.register(id, supplier)
            return ArcaneGardens.modLoc(id)
        }
}

