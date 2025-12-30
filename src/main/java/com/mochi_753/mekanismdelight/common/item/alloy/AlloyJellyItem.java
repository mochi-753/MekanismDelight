package com.mochi_753.mekanismdelight.common.item.alloy;

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
