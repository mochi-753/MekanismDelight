package com.mochi_753.mekanismdelight.datagen;

import com.mochi_753.mekanismdelight.common.compat.evolvedmekanism.EvolvedMekanismDelightItems;
import com.mochi_753.mekanismdelight.common.compat.evolvedmekanism.EvolvedMekanismToolsDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanism_extras.MekanismExtrasDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanismgenerators.MekanismGeneratorsDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanismtools.MekanismToolsDelightItems;
import fr.iglee42.evolvedmekanism.registries.EMTags;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.common.tags.MekanismTags;
import mekanism.generators.common.MekanismGenerators;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ItemExistsCondition;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@SuppressWarnings({"deprecation", "removal"})
public class MekanismDelightRecipeProvider extends RecipeProvider {
    public MekanismDelightRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private static void conditionalShaped(Consumer<FinishedRecipe> consumer, ShapedRecipeBuilder builder) {
        ResourceLocation resultId = BuiltInRegistries.ITEM.getKey(builder.getResult());
        ConditionalRecipe.builder()
                .addCondition(new ItemExistsCondition(resultId))
                .addRecipe(builder::save)
                .build(consumer, resultId);
    }

    private static void conditionalShapeless(Consumer<FinishedRecipe> consumer, ShapelessRecipeBuilder builder) {
        ResourceLocation resultId = BuiltInRegistries.ITEM.getKey(builder.getResult());
        ConditionalRecipe.builder()
                .addCondition(new ItemExistsCondition(resultId))
                .addRecipe(builder::save)
                .build(consumer, resultId);
    }

    private static void alloyJellyRecipe(Consumer<FinishedRecipe> consumer, Item result, TagKey<Item> tagKey) {
        conditionalShapeless(consumer, ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, result)
                .requires(Items.GLASS_BOTTLE)
                .requires(tagKey)
                .unlockedBy("has_alloy", has(tagKey))
        );
    }

    private static void alloyShakeRecipe(Consumer<FinishedRecipe> consumer, Item result, TagKey<Item> tagKey) {
        conditionalShapeless(consumer, ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, result)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.SUGAR)
                .requires(tagKey)
                .unlockedBy("has_alloy", has(tagKey))
        );
    }

    private static void hamburgerRecipe(Consumer<FinishedRecipe> consumer, Item result, TagKey<Item> tagKey) {
        conditionalShapeless(consumer, ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, result)
                .requires(ForgeTags.BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(tagKey)
                .unlockedBy("has_bread", has(ForgeTags.BREAD))
        );
    }

    private static void knifeRecipe(Consumer<FinishedRecipe> consumer, Item result, TagKey<Item> tagKey) {
        conditionalShaped(consumer, ShapedRecipeBuilder
                .shaped(RecipeCategory.TOOLS, result)
                .pattern("m")
                .pattern("s")
                .define('m', tagKey)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
        );
    }

    private static TagKey<Item> forgeTag(String id) {
        return ItemTags.create(new ResourceLocation("forge", id));
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Alloy Jelly Medley
        conditionalShapeless(consumer, ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, MekanismDelightItems.ALLOY_JELLY_MEDLEY.get())
                .requires(MekanismItems.ROBIT.get())
                .requires(MekanismTags.Items.ALLOYS_ADVANCED)
                .requires(MekanismTags.Items.ALLOYS_ELITE)
                .requires(MekanismTags.Items.ALLOYS_ULTIMATE)
                .unlockedBy("has_robit", InventoryChangeTrigger.TriggerInstance.hasItems(MekanismItems.ROBIT.get()))
        );

        // Alloy Jellies
        alloyJellyRecipe(consumer, EvolvedMekanismDelightItems.CREATIVE_JELLY.get(), EMTags.Items.ALLOYS_CREATIVE_FORGE);
        alloyJellyRecipe(consumer, EvolvedMekanismDelightItems.EXOVERSAL_JELLY.get(), EMTags.Items.ALLOYS_MULTIVERSAL);
        alloyJellyRecipe(consumer, EvolvedMekanismDelightItems.HYPERCHARGED_JELLY.get(), EMTags.Items.ALLOYS_OVERCLOCKED);
        alloyJellyRecipe(consumer, MekanismExtrasDelightItems.RADIANCE_JELLY.get(), forgeTag("alloys/absolute"));
        alloyJellyRecipe(consumer, MekanismExtrasDelightItems.SHINING_JELLY.get(), forgeTag("alloys/cosmic"));
        alloyJellyRecipe(consumer, EvolvedMekanismDelightItems.SINGULAR_JELLY.get(), EMTags.Items.ALLOYS_DENSE);
        alloyJellyRecipe(consumer, MekanismExtrasDelightItems.SPECTRUM_JELLY.get(), forgeTag("alloys/infinite"));
        alloyJellyRecipe(consumer, EvolvedMekanismDelightItems.SUBATOMIC_JELLY.get(), EMTags.Items.ALLOYS_QUANTUM);
        alloyJellyRecipe(consumer, MekanismExtrasDelightItems.THERMONUCLEAR_JELLY.get(), forgeTag("alloys/supreme"));

        // Alloy Shakes
        alloyShakeRecipe(consumer, MekanismDelightItems.ATOMIC_SHAKE.get(), MekanismTags.Items.ALLOYS_ULTIMATE);
        alloyShakeRecipe(consumer, EvolvedMekanismDelightItems.CREATIVE_SHAKE.get(), EMTags.Items.ALLOYS_CREATIVE_FORGE);
        alloyShakeRecipe(consumer, EvolvedMekanismDelightItems.EXOVERSAL_SHAKE.get(), EMTags.Items.ALLOYS_MULTIVERSAL);
        alloyShakeRecipe(consumer, EvolvedMekanismDelightItems.HYPERCHARGED_SHAKE.get(), EMTags.Items.ALLOYS_OVERCLOCKED);
        alloyShakeRecipe(consumer, MekanismDelightItems.INFUSED_SHAKE.get(), MekanismTags.Items.ALLOYS_ADVANCED);
        alloyShakeRecipe(consumer, MekanismExtrasDelightItems.RADIANCE_SHAKE.get(), forgeTag("alloys/absolute"));
        alloyShakeRecipe(consumer, MekanismDelightItems.REINFORCED_SHAKE.get(), MekanismTags.Items.ALLOYS_ELITE);
        alloyShakeRecipe(consumer, MekanismExtrasDelightItems.SHINING_SHAKE.get(), forgeTag("alloys/cosmic"));
        alloyShakeRecipe(consumer, EvolvedMekanismDelightItems.SINGULAR_SHAKE.get(), EMTags.Items.ALLOYS_DENSE);
        alloyShakeRecipe(consumer, MekanismExtrasDelightItems.SPECTRUM_SHAKE.get(), forgeTag("alloys/infinite"));
        alloyShakeRecipe(consumer, EvolvedMekanismDelightItems.SUBATOMIC_SHAKE.get(), EMTags.Items.ALLOYS_QUANTUM);
        alloyShakeRecipe(consumer, MekanismExtrasDelightItems.THERMONUCLEAR_SHAKE.get(), forgeTag("alloys/supreme"));

        // Cooking Pot Recipes
        CookingPotRecipeBuilder.cookingPotRecipe(MekanismGeneratorsDelightItems.DT_DRINK.get(), 1, 100, 2.0F)
                .addIngredient(BuiltInRegistries.ITEM.get(new ResourceLocation(MekanismGenerators.MODID, "fusion_fuel_bucket")))
                .unlockedBy("has_fusion_fuel", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltInRegistries.ITEM.get(new ResourceLocation(MekanismGenerators.MODID, "fusion_fuel_bucket"))))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(MekanismDelightItems.ROBIT_STEW.get(), 1, 200, 1.0F)
                .addIngredient(MekanismDelightItems.FORMERLY_ROBIT.get(), 2)
                .addIngredient(Items.CARROT)
                .addIngredient(Items.POTATO)
                .unlockedBy("has_robit", InventoryChangeTrigger.TriggerInstance.hasItems(MekanismItems.ROBIT.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);

        // Cutting Board Recipes
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MekanismItems.ROBIT.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), MekanismDelightItems.FORMERLY_ROBIT.get(), 2)
                .build(consumer);

        // Knives
        knifeRecipe(consumer, EvolvedMekanismToolsDelightItems.BETTER_GOLD_KNIFE.get(), EMTags.Items.INGOTS_BETTER_GOLD);
        knifeRecipe(consumer, MekanismToolsDelightItems.BRONZE_KNIFE.get(), MekanismTags.Items.INGOTS_BRONZE);
        knifeRecipe(consumer, MekanismToolsDelightItems.LAPIS_LAZULI_KNIFE.get(), Tags.Items.GEMS_LAPIS);
        knifeRecipe(consumer, MekanismToolsDelightItems.OSMIUM_KNIFE.get(), forgeTag("ingots/osmium"));
        knifeRecipe(consumer, EvolvedMekanismToolsDelightItems.PLASLITHERITE_KNIFE.get(), EMTags.Items.INGOTS_PLASLITHERITE);
        knifeRecipe(consumer, MekanismToolsDelightItems.REFINED_GLOWSTONE_KNIFE.get(), MekanismTags.Items.INGOTS_REFINED_GLOWSTONE);
        knifeRecipe(consumer, MekanismToolsDelightItems.REFINED_OBSIDIAN_KNIFE.get(), MekanismTags.Items.INGOTS_REFINED_OBSIDIAN);
        knifeRecipe(consumer, EvolvedMekanismToolsDelightItems.REFINED_REDSTONE_KNIFE.get(), EMTags.Items.INGOTS_REFINED_REDSTONE);
        knifeRecipe(consumer, MekanismToolsDelightItems.STEEL_KNIFE.get(), MekanismTags.Items.INGOTS_STEEL);

        // Hamburgers
        hamburgerRecipe(consumer, MekanismDelightItems.PLUTONIUM_HAMBURGER.get(), MekanismTags.Items.PELLETS_PLUTONIUM);
        hamburgerRecipe(consumer, MekanismDelightItems.POLONIUM_HAMBURGER.get(), MekanismTags.Items.PELLETS_POLONIUM);
        hamburgerRecipe(consumer, MekanismDelightItems.SAWDUST_HAMBURGER.get(), MekanismTags.Items.DUSTS_WOOD);

        // Salted Rice Ball
        conditionalShapeless(consumer, ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, MekanismDelightItems.SALTED_RICE_BALL.get(), 2)
                .requires(ModItems.COOKED_RICE.get())
                .requires(MekanismTags.Items.DUSTS_SALT)
                .unlockedBy("has_rice", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COOKED_RICE.get()))
        );

        // SPS Pie
        conditionalShaped(consumer, ShapedRecipeBuilder
                .shaped(RecipeCategory.FOOD, MekanismDelightItems.SPS_PIE.get())
                .pattern("ccc")
                .pattern("psp")
                .pattern("cOc")
                .define('c', MekanismBlocks.SPS_CASING.asItem())
                .define('p', MekanismBlocks.SPS_PORT.asItem())
                .define('s', MekanismBlocks.SUPERCHARGED_COIL.asItem())
                .define('O', ModItems.PIE_CRUST.get())
                .unlockedBy("has_sps_casing", InventoryChangeTrigger.TriggerInstance.hasItems(MekanismBlocks.SPS_CASING.asItem()))
        );
    }
}
