package com.mochi_753.mekanism_delight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {
    public static final FoodProperties DT_DRINK_FOOD_PROPERTY =
            new FoodProperties.Builder().alwaysEat().effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties RADIATION_BURGER_FOOD_PROPERTY =
            new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).alwaysEat().build();
    public static final FoodProperties SALTED_RICE_BALL_FOOD_PROPERTY =
            new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0), 1.0F).build();
}
