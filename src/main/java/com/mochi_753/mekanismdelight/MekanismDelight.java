package com.mochi_753.mekanismdelight;

import com.mochi_753.mekanismdelight.common.compat.evolvedmekanism.EvolvedMekanismCompat;
import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismCompat;
import com.mochi_753.mekanismdelight.common.compat.mekanism_extras.MekanismExtrasCompat;
import com.mochi_753.mekanismdelight.common.compat.mekanismgenerators.MekanismGeneratorsCompat;
import com.mochi_753.mekanismdelight.common.compat.mekanismtools.MekanismToolsCompat;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightCreativeTab;
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

        new MekanismCompat(eventBus);
        new MekanismGeneratorsCompat(eventBus);
        new MekanismToolsCompat(eventBus);
        new MekanismExtrasCompat(eventBus);
        new EvolvedMekanismCompat(eventBus);
    }
}
