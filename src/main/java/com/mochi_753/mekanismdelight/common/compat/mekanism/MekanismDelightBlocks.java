package com.mochi_753.mekanismdelight.common.compat.mekanism;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.block.AlloyJellyMedleyBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MekanismDelightBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MekanismDelight.MOD_ID);

    public static final RegistryObject<Block> ALLOY_JELLY_MEDLEY = BLOCKS.register("alloy_jelly_medley",
            () -> new AlloyJellyMedleyBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
