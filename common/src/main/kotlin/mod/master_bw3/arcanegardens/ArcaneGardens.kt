package mod.master_bw3.arcanegardens;

import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlockEntities.BLOCK_ENTITIES
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks.BLOCKS
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs.TABS
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems.ITEMS
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.util.function.BiConsumer

object ArcaneGardens {
    const val MODID = "arcanegardens"
    fun modLoc(s: String): ResourceLocation {
        return ResourceLocation(MODID, s)
    }

    val LOGGER: Logger = LogManager.getLogger(MODID)

    fun init() {
        LOGGER.info("hello world")
        initRegistries()

    // Write common init code here.
    }

    fun initRegistries() {
        BLOCKS.register()
        ITEMS.register()
        BLOCK_ENTITIES.register()
        TABS.register()

    }

}
