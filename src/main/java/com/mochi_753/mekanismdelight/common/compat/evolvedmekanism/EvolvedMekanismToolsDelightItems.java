package com.mochi_753.mekanismdelight.common.compat.evolvedmekanism;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightCreativeTab;
import fr.iglee42.emtools.config.EMToolsConfig;
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

@SuppressWarnings("unused")
public class EvolvedMekanismToolsDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> BETTER_GOLD_KNIFE = ITEMS.register("better_gold_knife",
            () -> mekanismKnifeItem(Tiers.DIAMOND, EMToolsConfig.tools.betterGold));
    public static final RegistryObject<Item> PLASLITHERITE_KNIFE = ITEMS.register("plaslitherite_knife",
            () -> mekanismKnifeItem(Tiers.NETHERITE, EMToolsConfig.tools.plaslitherite));
    public static final RegistryObject<Item> REFINED_REDSTONE_KNIFE = ITEMS.register("refined_redstone_knife",
            () -> mekanismKnifeItem(Tiers.NETHERITE, EMToolsConfig.tools.refinedRedstone));

    private static KnifeItem mekanismKnifeItem(Tier tier, MaterialCreator material) {
        return new KnifeItem(tier, material.getAttackDamageBonus() - 1.0F, -2.0F, new Item.Properties().durability(material.getUses()));
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
