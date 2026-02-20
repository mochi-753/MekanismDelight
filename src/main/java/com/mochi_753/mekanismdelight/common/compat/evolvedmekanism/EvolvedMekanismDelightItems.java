package com.mochi_753.mekanismdelight.common.compat.evolvedmekanism;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.FoodValues;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyFoodTier;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyJellyItem;
import com.mochi_753.mekanismdelight.common.item.alloy.AlloyShakeItem;
import com.mochi_753.mekanismdelight.common.register.MekanismDelightCreativeTab;
import mekanism.tools.common.material.MaterialCreator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

@SuppressWarnings("unused")
public class EvolvedMekanismDelightItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MekanismDelight.MOD_ID);

    public static final RegistryObject<Item> HYPERCHARGED_SHAKE = ITEMS.register("hypercharged_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.HYPERCHARGED));
    public static final RegistryObject<Item> SUBATOMIC_SHAKE = ITEMS.register("subatomic_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.SUBATOMIC));
    public static final RegistryObject<Item> SINGULAR_SHAKE = ITEMS.register("singular_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.SINGULAR));
    public static final RegistryObject<Item> EXOVERSAL_SHAKE = ITEMS.register("exoversal_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.EXOVERSAL));
    public static final RegistryObject<Item> CREATIVE_SHAKE = ITEMS.register("creative_shake",
            () -> new AlloyShakeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_SHAKE_FOOD_PROPERTY), AlloyFoodTier.CREATIVE));
    public static final RegistryObject<Item> HYPERCHARGED_JELLY = ITEMS.register("hypercharged_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.HYPERCHARGED));
    public static final RegistryObject<Item> SUBATOMIC_JELLY = ITEMS.register("subatomic_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.SUBATOMIC));
    public static final RegistryObject<Item> SINGULAR_JELLY = ITEMS.register("singular_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.SINGULAR));
    public static final RegistryObject<Item> EXOVERSAL_JELLY = ITEMS.register("exoversal_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.EXOVERSAL));
    public static final RegistryObject<Item> CREATIVE_JELLY = ITEMS.register("creative_jelly",
            () -> new AlloyJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(FoodValues.ALLOY_JELLY_FOOD_PROPERTY), AlloyFoodTier.CREATIVE));

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
