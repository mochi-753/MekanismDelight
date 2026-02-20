package com.mochi_753.mekanismdelight.datagen;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.block.AlloyJellyMedleyBlock;
import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismDelightBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings({"depricated", "removal"})
public class MekanismDelightBlockStateProvider extends BlockStateProvider {
    public MekanismDelightBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MekanismDelight.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        AlloyJellyMedleyBlock block = (AlloyJellyMedleyBlock) MekanismDelightBlocks.ALLOY_JELLY_MEDLEY.get();
        getVariantBuilder(block).forAllStates(state -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = state.getValue(servingsProperty);

            ResourceLocation modelLocation = new ResourceLocation(MekanismDelight.MOD_ID, "block/alloy_jelly_medley_" + servings);
            return ConfiguredModel.builder()
                    .modelFile(new ModelFile.ExistingModelFile(modelLocation, models().existingFileHelper))
                    .rotationY((int) state.getValue(AlloyJellyMedleyBlock.FACING).toYRot() % 360)
                    .build();
        });
    }
}
