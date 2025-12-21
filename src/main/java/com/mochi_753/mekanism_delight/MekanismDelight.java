package com.mochi_753.mekanism_delight;

import com.mochi_753.mekanism_delight.addon.mekanism.MekanismCompatibility;
import com.mochi_753.mekanism_delight.addon.mekanismtools.MekanismToolsCompatibility;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismDelight.MOD_ID)
public class MekanismDelight {
    public static final String MOD_ID = "mekanismdelight";

    @SuppressWarnings("removal")
    public MekanismDelight() {
        this(FMLJavaModLoadingContext.get());
    }

    public MekanismDelight(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();

        MekanismDelightCreativeTab.register(eventBus);
        new MekanismCompatibility(eventBus);
        new MekanismToolsCompatibility(eventBus);
    }
}
