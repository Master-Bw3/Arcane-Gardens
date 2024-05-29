package mod.master_bw3.arcanegardens.neoforge;

import dev.architectury.platform.hooks.EventBusesHooks;
import mod.master_bw3.arcanegardens.ArcaneGardens;
import mod.master_bw3.arcanegardens.common.blocks.BlockLog;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensBlocks;
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensCreativeTabs;
import mod.master_bw3.arcanegardens.common.registry.ArcaneGardensItems;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static mod.master_bw3.arcanegardens.ArcaneGardens.MODID;


@Mod(MODID)
final public class ArcaneGardensNeoForge {
    public ArcaneGardensNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        ArcaneGardens.INSTANCE.init();
    }


}
