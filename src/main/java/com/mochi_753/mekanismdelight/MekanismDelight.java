package com.mochi_753.mekanismdelight;

import com.mochi_753.mekanismdelight.common.addon.mekanismgenerators.MekanismGeneratorsDelight;
import com.mochi_753.mekanismdelight.common.addon.mekanismtools.MekanismToolsDelight;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightCreativeTab;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MekanismDelight.MOD_ID)
public class MekanismDelight {
    public static final String MOD_ID = "mekanismdelight";
    public static final Logger LOGGER = LogUtils.getLogger();

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
