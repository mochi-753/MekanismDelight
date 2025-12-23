package com.mochi_753.mekanism_delight.register;

import com.mochi_753.mekanism_delight.FoodValues;
import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.item.RadioactiveFoodItem;
import com.mochi_753.mekanism_delight.item.alloy.AlloyFoodTier;
import com.mochi_753.mekanism_delight.item.alloy.AlloyJellyItem;
import com.mochi_753.mekanism_delight.item.alloy.AlloyShakeItem;
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

    public static final RegistryObject<Item> INFUSED_SHAKE = ITEMS.register("infused_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyFoodTier.INFUSED));
    public static final RegistryObject<Item> REINFORCED_SHAKE = ITEMS.register("reinforced_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyFoodTier.REINFORCED));
    public static final RegistryObject<Item> ATOMIC_SHAKE = ITEMS.register("atomic_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), AlloyFoodTier.ATOMIC));
    public static final RegistryObject<Item> INFUSED_JELLY = ITEMS.register("infused_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.INFUSED));
    public static final RegistryObject<Item> REINFORCED_JELLY = ITEMS.register("reinforced_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.REINFORCED));
    public static final RegistryObject<Item> ATOMIC_JELLY = ITEMS.register("atomic_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.ATOMIC));
    public static final RegistryObject<Item> PLUTONIUM_HAMBURGER = ITEMS.register("plutonium_hamburger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(FoodValues.RADIATION_BURGER_FOOD_PROPERTY), 50.0));
    public static final RegistryObject<Item> POLONIUM_HAMBURGER = ITEMS.register("polonium_hamburger",
            () -> new RadioactiveFoodItem(new Item.Properties().food(FoodValues.RADIATION_BURGER_FOOD_PROPERTY), 50.0));
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
