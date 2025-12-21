package com.mochi_753.mekanism_delight;

import com.mochi_753.mekanism_delight.addon.mekanismtools.MekanismToolsCompatibility;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismDelight.MOD_ID)
public class MekanismDelight {
    public static final String MOD_ID = "mekanism_delight";

    @SuppressWarnings("removal")
    public MekanismDelight() {
        this(FMLJavaModLoadingContext.get());
    }

    public MekanismDelight(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();
        new MekanismToolsCompatibility(eventBus);
    }
}
