package com.mochi_753.mekanism_delight.addon.mekanismtools;

import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import mekanism.tools.common.config.MekanismToolsConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class MekanismToolsDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    private static final RegistryObject<Item> BRONZE_KNIFE = ITEMS.register("bronze_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.bronze.getUses())));
    private static final RegistryObject<Item> LAPIS_LAZULI_KNIFE = ITEMS.register("lapis_lazuli_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.lapisLazuli.getUses())));
    private static final RegistryObject<Item> OSMIUM_KNIFE = ITEMS.register("osmium_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.osmium.getUses())));
    private static final RegistryObject<Item> REFINED_GLOWSTONE_KNIFE = ITEMS.register("refined_glowstone_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.refinedGlowstone.getUses())));
    private static final RegistryObject<Item> REFINED_OBSIDIAN_KNIFE = ITEMS.register("refined_obsidian_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.refinedObsidian.getUses())));
    private static final RegistryObject<Item> STEEL_KNIFE = ITEMS.register("steel_knife",
            () -> new KnifeItem(Tiers.IRON, 0.5F, -2.0F, new Item.Properties().durability(MekanismToolsConfig.tools.steel.getUses())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MekanismDelightCreativeTab.TAB_MEKANISM_DELIGHT.get())) {
            ITEMS.getEntries().forEach(registryObject -> {
                event.accept(registryObject.get());
            });
        }
    }
}
