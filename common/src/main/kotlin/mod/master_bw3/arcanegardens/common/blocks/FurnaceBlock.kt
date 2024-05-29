package mod.master_bw3.arcanegardens.common.blocks

import mod.master_bw3.arcanegardens.ArcaneGardens.LOGGER
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlockEntities.BLOCK_ENTITIES
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlockEntities.FURNACE_BLOCK_ENTITY
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState


class FurnaceBlock(properties: Properties) : Block(properties), EntityBlock {

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        LOGGER.info("entity block")
        return FurnaceBlockEntity(pos, state)
    }

}


class FurnaceBlockEntity(pos: BlockPos, state: BlockState) :
    BlockEntity(BLOCK_ENTITIES.first { it.`is`(FURNACE_BLOCK_ENTITY) }.get(), pos, state) {}