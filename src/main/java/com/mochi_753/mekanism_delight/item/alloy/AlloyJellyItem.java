package com.mochi_753.mekanism_delight.item.alloy;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class AlloyJellyItem extends ConsumableItem {
    private final AlloyFoodTier tier;

    public AlloyJellyItem(Properties properties, AlloyFoodTier tier) {
        super(properties);
        this.tier = tier;
    }

    @Override
    public @NotNull Component getName(ItemStack pStack) {
        MutableComponent component = (MutableComponent) super.getName(pStack);
        return component.withStyle(switch (this.tier) {
            case INFUSED -> ChatFormatting.YELLOW;
            case REINFORCED -> ChatFormatting.AQUA;
            case ATOMIC -> ChatFormatting.LIGHT_PURPLE;
        });
    }
}
