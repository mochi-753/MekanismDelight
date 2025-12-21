package com.mochi_753.mekanism_delight.addon.mekanismgenerators;

import com.mochi_753.mekanism_delight.MekanismDelight;
import com.mochi_753.mekanism_delight.register.MekanismDelightCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class MekanismGeneratorsDelightItems {
    private static final FoodProperties DT_DRINK_FOOD_PROPERTY = new FoodProperties.Builder().alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> DT_DRINK = ITEMS.register("dt_drink",
            () -> new DrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(DT_DRINK_FOOD_PROPERTY), true));

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
