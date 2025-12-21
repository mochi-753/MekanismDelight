package com.mochi_753.mekanism_delight.addon.mekanismtools;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class MekanismToolsDelight {
    public MekanismToolsDelight(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("mekanismtools") != null) {
            MekanismToolsDelightItems.register(eventBus);
            eventBus.addListener(MekanismToolsDelightItems::onBuildCreativeModeTabContents);
        }
    }
}
