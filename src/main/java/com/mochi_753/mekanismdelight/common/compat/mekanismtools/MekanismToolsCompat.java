package com.mochi_753.mekanismdelight.common.compat.mekanismtools;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class MekanismToolsCompat {
    public MekanismToolsCompat(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("mekanismtools") != null) {
            MekanismToolsDelightItems.register(eventBus);
            eventBus.addListener(MekanismToolsDelightItems::onBuildCreativeModeTabContents);
        }
    }
}
