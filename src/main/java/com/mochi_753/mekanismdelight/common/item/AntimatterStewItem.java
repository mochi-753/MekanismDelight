package com.mochi_753.mekanismdelight.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;

@ParametersAreNonnullByDefault
public class AntimatterStewItem extends ConsumableItem {
    public AntimatterStewItem(Properties properties) {
        super(properties);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        level.explode(consumer, consumer.getX(), consumer.getY(), consumer.getZ(), level.getRandom().nextFloat() * 64.0F, Level.ExplosionInteraction.MOB);
        consumer.setHealth(0.0F);
    }

    @Override
    public @NotNull Component getName(ItemStack pStack) {
        Component component = super.getName(pStack);
        MutableComponent result = Component.empty();

        for (int i = 0; i < component.getString().length(); i++) {
            float hue = (System.currentTimeMillis() % 3000L) / 3000.0F + i / 20.0F;
            int color = Color.HSBtoRGB(hue, 1.0F, 1.0F);
            result.append(Component.literal(String.valueOf(component.getString().charAt(i)))
                    .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
        }

        return result;
    }
}
