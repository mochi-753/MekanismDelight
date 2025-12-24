package com.mochi_753.mekanismdelight.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.ParametersAreNonnullByDefault;

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
}
