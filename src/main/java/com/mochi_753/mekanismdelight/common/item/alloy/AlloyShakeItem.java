package com.mochi_753.mekanismdelight.common.item.alloy;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@ParametersAreNonnullByDefault
public class AlloyShakeItem extends DrinkableItem {
    private final AlloyFoodTier tier;

    public AlloyShakeItem(Properties properties, AlloyFoodTier tier) {
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

            case RADIANCE, HYPERCHARGED -> 6;
            case THERMONUCLEAR, SUBATOMIC -> 8;
            case SHINING, SINGULAR -> 10;
            case SPECTRUM, EXOVERSAL, CREATIVE -> 10000;
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
                case INFUSED -> Component.translatable("tooltip.mekanismdelight.alloy_shake.1");
                case REINFORCED -> Component.translatable("tooltip.mekanismdelight.alloy_shake.2");
                case ATOMIC -> Component.translatable("tooltip.mekanismdelight.alloy_shake.4");

                case RADIANCE, HYPERCHARGED -> Component.translatable("tooltip.mekanismdelight.alloy_shake.6");
                case THERMONUCLEAR, SUBATOMIC -> Component.translatable("tooltip.mekanismdelight.alloy_shake.8");
                case SHINING, SINGULAR -> Component.translatable("tooltip.mekanismdelight.alloy_shake.10");
                case SPECTRUM, EXOVERSAL, CREATIVE -> Component.translatable("tooltip.mekanismdelight.alloy_shake.all");
            };
            tooltip.add(component.withStyle(ChatFormatting.BLUE));
        }
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    @Override
    public @NotNull Component getName(ItemStack pStack) {
        MutableComponent component = (MutableComponent) super.getName(pStack);
        return component.withStyle(style -> switch (this.tier) {
            // Mekanism
            case INFUSED -> style.withColor(ChatFormatting.YELLOW);
            case REINFORCED -> style.withColor(ChatFormatting.AQUA);
            case ATOMIC -> style.withColor(ChatFormatting.LIGHT_PURPLE);

            // Mekanism Extras
            case RADIANCE -> style.withColor(ChatFormatting.WHITE);
            case THERMONUCLEAR -> style.withColor(ChatFormatting.YELLOW);
            case SHINING -> style.withColor(ChatFormatting.AQUA);
            case SPECTRUM -> style.withColor(ChatFormatting.LIGHT_PURPLE);

            // Evolved Mekanism
            case HYPERCHARGED -> style.withColor(0x00DD00);
            case SUBATOMIC -> style.withColor(0xFC9EFA);
            case SINGULAR -> style.withColor(0xFDF55F);
            case EXOVERSAL, CREATIVE -> style.withColor(0x5A575A);
        });
    }
}
