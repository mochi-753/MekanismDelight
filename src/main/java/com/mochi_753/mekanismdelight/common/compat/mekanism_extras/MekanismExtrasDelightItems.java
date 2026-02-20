package com.mochi_753.mekanismdelight.common.compat.mekanism_extras;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.FoodValues;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyFoodTier;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyJellyItem;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyShakeItem;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class MekanismExtrasDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> RADIANCE_SHAKE = ITEMS.register("radiance_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.RADIANCE));
    public static final RegistryObject<Item> THERMONUCLEAR_SHAKE = ITEMS.register("thermonuclear_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.THERMONUCLEAR));
    public static final RegistryObject<Item> SHINING_SHAKE = ITEMS.register("shining_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.SHINING));
    public static final RegistryObject<Item> SPECTRUM_SHAKE = ITEMS.register("spectrum_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.SPECTRUM));

    public static final RegistryObject<Item> RADIANCE_JELLY = ITEMS.register("radiance_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.RADIANCE));
    public static final RegistryObject<Item> THERMONUCLEAR_JELLY = ITEMS.register("thermonuclear_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.THERMONUCLEAR));
    public static final RegistryObject<Item> SHINING_JELLY = ITEMS.register("shining_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.SHINING));
    public static final RegistryObject<Item> SPECTRUM_JELLY = ITEMS.register("spectrum_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.SPECTRUM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MekanismDelightCreativeTab.TAB_MEKANISM_DELIGHT.get())) {
            ITEMS.getEntries().forEach(registryObject -> event.accept(registryObject.get()));
        }
    }
}
