package com.mochi_753.mekanismdelight.datagen;

import com.mochi_753.mekanismdelight.MekanismDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MekanismDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new MekanismDelightBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new MekanismDelightRecipeProvider(packOutput));
    }
}
