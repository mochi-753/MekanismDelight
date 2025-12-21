package com.mochi_753.mekanism_delight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@ParametersAreNonnullByDefault
public class AlloyShakeItem extends DrinkableItem {
    private final Tier tier;

    public AlloyShakeItem(Properties properties, Tier tier) {
        super(properties);
        this.tier = tier;
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        Iterator<MobEffectInstance> effectIterator = consumer.getActiveEffects().iterator();
        ArrayList<MobEffect> compatibleEffects = new ArrayList<>();

        while (effectIterator.hasNext()) {
            MobEffectInstance effect = effectIterator.next();
            if (effect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL) && effect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                compatibleEffects.add(effect.getEffect());
            }
        }

        int removalEffectsCount = switch (this.tier) {
            case INFUSED -> 1;
            case REINFORCED -> 2;
            case ATOMIC -> 4;
        };

        for (int i = 0; i < removalEffectsCount && !compatibleEffects.isEmpty(); i++) {
            int effectIndex = level.random.nextInt(compatibleEffects.size());
            MobEffect effect = compatibleEffects.remove(effectIndex);
            MobEffectInstance effectInstance = consumer.getEffect(effect);

            if (effectInstance != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(consumer, effectInstance))) {
                consumer.removeEffect(effectInstance.getEffect());
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent component = switch (this.tier) {
                case INFUSED -> Component.translatable("mekanismdelight.tooltip.infused_shake");
                case REINFORCED -> Component.translatable("mekanismdelight.tooltip.reinforced_shake");
                case ATOMIC -> Component.translatable("mekanismdelight.tooltip.atomic_shake");
            };
            tooltip.add(component.withStyle(ChatFormatting.BLUE));
        }
    }

    public enum Tier {
        INFUSED,
        REINFORCED,
        ATOMIC,
    }
}
