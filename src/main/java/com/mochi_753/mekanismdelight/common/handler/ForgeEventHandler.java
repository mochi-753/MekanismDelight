package com.mochi_753.mekanismdelight.common.handler;

import com.mochi_753.mekanismdelight.MekanismDelight;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MekanismDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onFinishUsingItem(LivingEntityUseItemEvent.Finish event) {
        ItemStack itemStack = event.getItem();
        if (!itemStack.isEdible()) return;

        CompoundTag compoundTag = itemStack.getTag();
        if (compoundTag == null || !compoundTag.contains("Toppings")) return;

        LivingEntity entity = event.getEntity();
        ListTag listTag = compoundTag.getList("Toppings", Tag.TAG_COMPOUND);

        for (Tag tag : listTag) {
            CompoundTag topping = (CompoundTag) tag;
        }
    }
}
