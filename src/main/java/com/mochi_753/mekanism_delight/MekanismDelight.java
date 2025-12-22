package com.mochi_753.mekanism_delight;

import com.mochi_753.mekanism_delight.addon.mekanismgenerators.MekanismGeneratorsDelight;
import com.mochi_753.mekanism_delight.addon.mekanismtools.MekanismToolsDelight;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import com.mochi_753.mekanism_delight.register.MekanismDelightItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismDelight.MOD_ID)
public class MekanismDelight {
    public static final String MOD_ID = "mekanismdelight";

    @SuppressWarnings({"removal", "unused"})
    public MekanismDelight() {
        this(FMLJavaModLoadingContext.get());
    }

    public MekanismDelight(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();

        MekanismDelightCreativeTab.register(eventBus);

        MekanismDelightItems.register(eventBus);
        eventBus.addListener(MekanismDelightItems::onBuildCreativeModeTabContents);
        new MekanismGeneratorsDelight(eventBus);
        new MekanismToolsDelight(eventBus);
    }
}
