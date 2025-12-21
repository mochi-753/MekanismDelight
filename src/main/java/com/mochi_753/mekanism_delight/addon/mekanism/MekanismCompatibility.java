package com.mochi_753.mekanism_delight.addon.mekanism;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class MekanismCompatibility {
    public MekanismCompatibility(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("mekanism") != null) {
            MekanismDelightItems.register(eventBus);
            eventBus.addListener(MekanismDelightItems::onBuildCreativeModeTabContents);
        }
    }
}
