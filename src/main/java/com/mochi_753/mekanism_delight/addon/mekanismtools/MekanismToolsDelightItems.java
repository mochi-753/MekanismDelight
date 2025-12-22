package com.mochi_753.mekanism_delight.addon.mekanismtools;

import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import mekanism.tools.common.config.MekanismToolsConfig;
import mekanism.tools.common.material.MaterialCreator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class MekanismToolsDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> BRONZE_KNIFE = ITEMS.register("bronze_knife",
            () -> mekanismKnifeItem(Tiers.IRON, MekanismToolsConfig.tools.bronze));
    public static final RegistryObject<Item> LAPIS_LAZULI_KNIFE = ITEMS.register("lapis_lazuli_knife",
            () -> mekanismKnifeItem(Tiers.STONE, MekanismToolsConfig.tools.lapisLazuli));
    public static final RegistryObject<Item> OSMIUM_KNIFE = ITEMS.register("osmium_knife",
            () -> mekanismKnifeItem(Tiers.IRON, MekanismToolsConfig.tools.osmium));
    public static final RegistryObject<Item> REFINED_GLOWSTONE_KNIFE = ITEMS.register("refined_glowstone_knife",
            () -> mekanismKnifeItem(Tiers.DIAMOND, MekanismToolsConfig.tools.refinedGlowstone));
    public static final RegistryObject<Item> REFINED_OBSIDIAN_KNIFE = ITEMS.register("refined_obsidian_knife",
            () -> mekanismKnifeItem(Tiers.NETHERITE, MekanismToolsConfig.tools.refinedObsidian));
    public static final RegistryObject<Item> STEEL_KNIFE = ITEMS.register("steel_knife",
            () -> mekanismKnifeItem(Tiers.DIAMOND, MekanismToolsConfig.tools.steel));

    private static KnifeItem mekanismKnifeItem(Tier tier, MaterialCreator material) {
        return new KnifeItem(tier, material.getAttackDamageBonus() - 1.5F, -2.0F, new Item.Properties().durability(material.getUses()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MekanismDelightCreativeTab.TAB_MEKANISM_DELIGHT.get())) {
            ITEMS.getEntries().forEach(registryObject -> event.accept(registryObject.get()));
        }
    }
}
