package com.mochi_753.mekanismdelight.common.compat.evolvedmekanism;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class EvolvedMekanismCompat {
    public EvolvedMekanismCompat(IEventBus eventBus) {
        if (FMLLoader.getLoadingModList().getModFileById("evolvedmekanism") != null) {
            EvolvedMekanismDelightItems.register(eventBus);
            eventBus.addListener(EvolvedMekanismDelightItems::onBuildCreativeModeTabContents);
            if (FMLLoader.getLoadingModList().getModFileById("mekanismtools") != null) {
                EvolvedMekanismToolsDelightItems.register(eventBus);
                eventBus.addListener(EvolvedMekanismToolsDelightItems::onBuildCreativeModeTabContents);
            }
        }
    }
}
