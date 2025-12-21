package com.mochi_753.mekanism_delight.register;

import com.mochi_753.mekanism_delight.MekanismDelight;
import mekanism.common.registries.MekanismItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MekanismDelightCreativeTab {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MekanismDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB_MEKANISM_DELIGHT = CREATIVE_MODE_TABS.register(MekanismDelight.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Mekanism Delight"))
                    .icon(() -> new ItemStack(MekanismItems.POLONIUM_PELLET))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
