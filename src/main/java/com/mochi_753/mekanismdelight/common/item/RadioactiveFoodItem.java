package com.mochi_753.mekanismdelight.common.item;

import mekanism.common.capabilities.Capabilities;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class RadioactiveFoodItem extends ConsumableItem {
    private final double radiationDose;

    public RadioactiveFoodItem(Properties properties, double radiationDose) {
        super(properties);
        this.radiationDose = radiationDose;
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.getCapability(Capabilities.RADIATION_ENTITY).ifPresent(c -> c.radiate(this.radiationDose));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        MutableComponent component = Component.translatable("tooltip.mekanismdelight.radioactive_food");
        tooltip.add(component.withStyle(ChatFormatting.RED));
    }
}
