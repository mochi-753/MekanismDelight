package com.mochi_753.mekanismdelight.common.block;

import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismDelightItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class AlloyJellyMedleyBlock extends FeastBlock {
    public static final IntegerProperty JELLY_SERVINGS = IntegerProperty.create("servings", 0, 3);
    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 15.0, 14.0);

    public final List<Supplier<Item>> alloyJellyServings = Arrays.asList(
            MekanismDelightItems.ATOMIC_JELLY,
            MekanismDelightItems.REINFORCED_JELLY,
            MekanismDelightItems.INFUSED_JELLY
    );

    public AlloyJellyMedleyBlock(Properties properties) {
        super(properties, MekanismDelightItems.INFUSED_JELLY, true);
    }

    @Override
    public IntegerProperty getServingsProperty() {
        return JELLY_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 3;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(alloyJellyServings.get(state.getValue(getServingsProperty()) - 1).get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, JELLY_SERVINGS);
    }
}
