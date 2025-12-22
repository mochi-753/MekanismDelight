package com.mochi_753.mekanism_delight.register;

import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.item.AlloyShakeItem;
import com.mochi_753.mekanism_delight.item.RadioactiveFoodItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MekanismDelightItems {
    private static final FoodProperties RADIATION_BURGER_FOOD_PROPERTY = new FoodProperties.Builder().nutrition(11).saturationMod(0.8F).alwaysEat().build();
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> INFUSED_SHAKE = ITEMS.register("infused_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.INFUSED));
    public static final RegistryObject<Item> REINFORCED_SHAKE = ITEMS.register("reinforced_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.REINFORCED));
    public static final RegistryObject<Item> ATOMIC_SHAKE = ITEMS.register("atomic_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyShakeItem.Tier.ATOMIC));
    public static final RegistryObject<Item> PLUTONIUM_BURGER = ITEMS.register("plutonium_burger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(RADIATION_BURGER_FOOD_PROPERTY), 50.0));
    public static final RegistryObject<Item> POLONIUM_BURGER = ITEMS.register("polonium_burger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(RADIATION_BURGER_FOOD_PROPERTY), 50.0));

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
