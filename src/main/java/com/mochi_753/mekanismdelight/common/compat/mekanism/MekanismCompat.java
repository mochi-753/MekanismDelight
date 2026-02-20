package com.mochi_753.mekanismdelight.common.compat.mekanism;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class MekanismCompat {
    public MekanismCompat(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("mekanism") != null) {
            MekanismDelightBlocks.register(eventBus);
            MekanismDelightItems.register(eventBus);
            eventBus.addListener(MekanismDelightItems::onBuildCreativeModeTabContents);
        }
    }
}
