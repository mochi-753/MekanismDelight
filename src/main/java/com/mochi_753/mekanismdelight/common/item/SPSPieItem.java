package com.mochi_753.mekanismdelight.common.item;

import mekanism.common.registries.MekanismItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SPSPieItem extends ConsumableItem {
    private static final RandomSource RANDOM = RandomSource.create();
    private static final String NAME_SUFFIX = " (Supercritical Phase Shifter Pie)";
    private static final String RANDOM_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public SPSPieItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        // 今だけ！1%の確率で反物質ペレットが手に入るおまけ付き！
        if (consumer instanceof Player player && level.getRandom().nextInt(100) == 0) {
            ItemStack antimatterPelletItem = new ItemStack(MekanismItems.ANTIMATTER_PELLET.get());
            if (!player.getInventory().add(antimatterPelletItem)) {
                player.drop(antimatterPelletItem, false);
            }
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    @Override
    public @NotNull Component getName(ItemStack pStack) {
        Component component = Component.literal("SPSP");
        long time = System.currentTimeMillis() % 10000L; // 10秒周期でサフィックス出現

        int length;
        if (time < 1000L) length = (int) (NAME_SUFFIX.length() * (time / 1000.0));
        else if (time < 3000L) length = NAME_SUFFIX.length();
        else if (time < 4000L) length = (int) (NAME_SUFFIX.length() * ((4000L - time) / 1000.0));
        else length = 0;

        if (length < 0 || length > NAME_SUFFIX.length()) return component;
        String suffix = NAME_SUFFIX.substring(0, length);

        if (time < 1000L) { // サフィックス出現中
            char c = RANDOM_CHARS.charAt(RANDOM.nextInt(RANDOM_CHARS.length()));
            suffix += c;
        }

        return component.copy().append(suffix);
    }
}
