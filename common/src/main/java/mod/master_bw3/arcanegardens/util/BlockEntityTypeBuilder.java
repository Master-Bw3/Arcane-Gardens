package mod.master_bw3.arcanegardens.util;

import com.mojang.datafixers.types.Type;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.Nullable;

public class BlockEntityTypeBuilder {
    public static<T extends BlockEntity> BlockEntityType<T> build(BlockEntityType.Builder<T> builder, @Nullable Type<?> dataType) {
        return builder.build(dataType);
    }
}
