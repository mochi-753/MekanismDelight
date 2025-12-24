package com.mochi_753.mekanismdelight.common.addon.mekanismgenerators;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class MekanismGeneratorsDelight {
    public MekanismGeneratorsDelight(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("mekanismgenerators") != null) {
            MekanismGeneratorsDelightItems.register(eventBus);
            eventBus.addListener(MekanismGeneratorsDelightItems::onBuildCreativeModeTabContents);
        }
    }
}
