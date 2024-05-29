package mod.master_bw3.arcanegardens.common.blocks

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.state.BlockState

class BlockLog(properties: Properties) : RotatedPillarBlock(properties) {

    fun isFlammable(state: BlockState?, level: BlockGetter?, pos: BlockPos?, direction: Direction?): Boolean {
        return true
    }

    fun getFlammability(state: BlockState?, level: BlockGetter?, pos: BlockPos?, direction: Direction?): Int {
        return 5
    }

    fun getFireSpreadSpeed(state: BlockState?, level: BlockGetter?, pos: BlockPos?, direction: Direction?): Int {
        return 5
    }
}