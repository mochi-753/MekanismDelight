package com.mochi_753.mekanism_delight.addon.mekanism;

import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.item.AlloyShakeItem;
import com.mochi_753.mekanism_delight.item.RadioactiveBurgerItem;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

public class MekanismDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    private static final RegistryObject<Item> INFUSED_SHAKE = ITEMS.register("infused_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.INFUSED));
    private static final RegistryObject<Item> REINFORCED_SHAKE = ITEMS.register("reinforced_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.REINFORCED));
    private static final RegistryObject<Item> ATOMIC_SHAKE = ITEMS.register("atomic_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.ATOMIC));
    private static final RegistryObject<Item> PLUTONIUM_BURGER = ITEMS.register("plutonium_burger",
            () -> new RadioactiveBurgerItem(new Item.Properties().food(FoodValues.HAMBURGER)));
    private static final RegistryObject<Item> POLONIUM_BURGER = ITEMS.register("polonium_burger",
            () -> new RadioactiveBurgerItem(new Item.Properties().food(FoodValues.HAMBURGER)));

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
