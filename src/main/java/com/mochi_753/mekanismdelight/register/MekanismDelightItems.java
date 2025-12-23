package com.mochi_753.mekanismdelight.register;

import com.mochi_753.mekanismdelight.FoodValues;
import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.item.RadioactiveFoodItem;
import com.mochi_753.mekanismdelight.item.RobitStewItem;
import com.mochi_753.mekanismdelight.item.alloy.AlloyFoodTier;
import com.mochi_753.mekanismdelight.item.alloy.AlloyJellyItem;
import com.mochi_753.mekanismdelight.item.alloy.AlloyShakeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

@SuppressWarnings("unused")
public class MekanismDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> FORMERLY_ROBIT = ITEMS.register("formerly_robit",
            () -> new Item(new Item.Properties().stacksTo(1)));

    // Foods
    public static final RegistryObject<Item> ROBIT_STEW = ITEMS.register("robit_stew",
            () -> new RobitStewItem(new Item.Properties().craftRemainder(Items.BOWL).food(FoodValues.ROBIT_STEW_FOOD_PROPERTY)));
    public static final RegistryObject<Item> INFUSED_SHAKE = ITEMS.register("infused_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.INFUSED));
    public static final RegistryObject<Item> REINFORCED_SHAKE = ITEMS.register("reinforced_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.REINFORCED));
    public static final RegistryObject<Item> ATOMIC_SHAKE = ITEMS.register("atomic_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.ATOMIC));
    public static final RegistryObject<Item> INFUSED_JELLY = ITEMS.register("infused_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.INFUSED));
    public static final RegistryObject<Item> REINFORCED_JELLY = ITEMS.register("reinforced_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.REINFORCED));
    public static final RegistryObject<Item> ATOMIC_JELLY = ITEMS.register("atomic_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.ATOMIC));
    public static final RegistryObject<Item> PLUTONIUM_HAMBURGER = ITEMS.register("plutonium_hamburger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(FoodValues.RADIATION_HAMBURGER_FOOD_PROPERTY), 50.0));
    public static final RegistryObject<Item> POLONIUM_HAMBURGER = ITEMS.register("polonium_hamburger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(FoodValues.RADIATION_HAMBURGER_FOOD_PROPERTY), 50.0));
    public static final RegistryObject<Item> SAWDUST_HAMBURGER = ITEMS.register("sawdust_hamburger",
            () -> new ConsumableItem(new Item.Properties().food(FoodValues.SAWDUST_HAMBURGER_FOOD_PROPERTY)));
    public static final RegistryObject<Item> SALTED_RICE_BALL = ITEMS.register("salted_rice_ball",
            () -> new ConsumableItem(new Item.Properties().food(FoodValues.SALTED_RICE_BALL_FOOD_PROPERTY), true));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MekanismDelightCreativeTab.TAB_MEKANISM_DELIGHT.get())) {
            ITEMS.getEntries().forEach(registryObject -> event.accept(registryObject.get()));
        }
    }
}
