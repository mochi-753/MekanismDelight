package com.mochi_753.mekanismdelight.datagen;

import com.mochi_753.mekanismdelight.MekanismDelight;
import com.mochi_753.mekanismdelight.common.compat.evolvedmekanism.EvolvedMekanismDelightItems;
import com.mochi_753.mekanismdelight.common.compat.evolvedmekanism.EvolvedMekanismToolsDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismDelightBlocks;
import com.mochi_753.mekanismdelight.common.compat.mekanism.MekanismDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanism_extras.MekanismExtrasDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanismgenerators.MekanismGeneratorsDelightItems;
import com.mochi_753.mekanismdelight.common.compat.mekanismtools.MekanismToolsDelightItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class MekanismDelightLanguageProvider extends LanguageProvider {
    private final String locale;

    public MekanismDelightLanguageProvider(PackOutput output, String locale) {
        super(output, MekanismDelight.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        switch (this.locale) {
            case "en_us" -> addEnglishTranslations();
            case "ja_jp" -> addJapaneseTranslations();
            default -> throw new IllegalStateException("That language is not currently supported.");
        }
    }

    private void addEnglishTranslations() {
        add("itemGroup.mekanismdelight", "Mekanism Delight");

        add(MekanismDelightBlocks.ALLOY_JELLY_MEDLEY.get(), "Alloy Jelly Medley");
        // add(MekanismDelightItems.ALLOY_JELLY_MEDLEY.get(), "Alloy Jelly Medley");

        add(MekanismDelightItems.FORMERLY_ROBIT.get(), "Formerly Robit");
        add(MekanismDelightItems.ROBIT_STEW.get(), "Robit Stew");

        add(MekanismDelightItems.INFUSED_SHAKE.get(), "Infused Shake");
        add(MekanismDelightItems.REINFORCED_SHAKE.get(), "Reinforced Shake");
        add(MekanismDelightItems.ATOMIC_SHAKE.get(), "Atomic Shake");

        add(MekanismDelightItems.INFUSED_JELLY.get(), "Infused Jelly");
        add(MekanismDelightItems.REINFORCED_JELLY.get(), "Reinforced Jelly");
        add(MekanismDelightItems.ATOMIC_JELLY.get(), "Atomic Jelly");

        add(MekanismDelightItems.POLONIUM_ICE_CREAM.get(), "Polonium Ice Cream");

        add(MekanismDelightItems.PLUTONIUM_HAMBURGER.get(), "Plutonium Burger");
        add(MekanismDelightItems.POLONIUM_HAMBURGER.get(), "Polonium Burger");
        add(MekanismDelightItems.SAWDUST_HAMBURGER.get(), "Sawdust Burger");

        add(MekanismDelightItems.SALTED_RICE_BALL.get(), "Salted Rice Ball");
        add(MekanismDelightItems.ANTIMATTER_STEW.get(), "Antimatter Stew");

        add(MekanismGeneratorsDelightItems.DT_DRINK.get(), "D-T Drink");
        add(MekanismGeneratorsDelightItems.FISSION_FUEL_DRINK.get(), "Fissile Fuel Drink");

        add(MekanismToolsDelightItems.BRONZE_KNIFE.get(), "Bronze Knife");
        add(MekanismToolsDelightItems.LAPIS_LAZULI_KNIFE.get(), "Lapis Lazuli Knife");
        add(MekanismToolsDelightItems.OSMIUM_KNIFE.get(), "Osmium Knife");
        add(MekanismToolsDelightItems.REFINED_GLOWSTONE_KNIFE.get(), "Refined Glowstone Knife");
        add(MekanismToolsDelightItems.REFINED_OBSIDIAN_KNIFE.get(), "Refined Obsidian Knife");
        add(MekanismToolsDelightItems.STEEL_KNIFE.get(), "Steel Knife");

        add(EvolvedMekanismDelightItems.HYPERCHARGED_SHAKE.get(), "Hypercharged Shake");
        add(EvolvedMekanismDelightItems.SUBATOMIC_SHAKE.get(), "Subatomic Shake");
        add(EvolvedMekanismDelightItems.SINGULAR_SHAKE.get(), "Singular Shake");
        add(EvolvedMekanismDelightItems.EXOVERSAL_SHAKE.get(), "Exoversal Shake");
        add(EvolvedMekanismDelightItems.CREATIVE_SHAKE.get(), "Creative Shake");

        add(EvolvedMekanismDelightItems.HYPERCHARGED_JELLY.get(), "Hypercharged Jelly");
        add(EvolvedMekanismDelightItems.SUBATOMIC_JELLY.get(), "Subatomic Jelly");
        add(EvolvedMekanismDelightItems.SINGULAR_JELLY.get(), "Singular Jelly");
        add(EvolvedMekanismDelightItems.EXOVERSAL_JELLY.get(), "Exoversal Jelly");
        add(EvolvedMekanismDelightItems.CREATIVE_JELLY.get(), "Creative Jelly");

        add(EvolvedMekanismToolsDelightItems.BETTER_GOLD_KNIFE.get(), "Better Gold Knife");
        add(EvolvedMekanismToolsDelightItems.PLASLITHERITE_KNIFE.get(), "Plaslitherite Knife");
        add(EvolvedMekanismToolsDelightItems.REFINED_REDSTONE_KNIFE.get(), "Refined Redstone Knife");

        add(MekanismExtrasDelightItems.RADIANCE_SHAKE.get(), "Radiance Shake");
        add(MekanismExtrasDelightItems.THERMONUCLEAR_SHAKE.get(), "Thermonuclear Shake");
        add(MekanismExtrasDelightItems.SHINING_SHAKE.get(), "Shining Shake");
        add(MekanismExtrasDelightItems.SPECTRUM_SHAKE.get(), "Spectrum Shake");

        add(MekanismExtrasDelightItems.RADIANCE_JELLY.get(), "Radiance Jelly");
        add(MekanismExtrasDelightItems.THERMONUCLEAR_JELLY.get(), "Thermonuclear Jelly");
        add(MekanismExtrasDelightItems.SHINING_JELLY.get(), "Shining Jelly");
        add(MekanismExtrasDelightItems.SPECTRUM_JELLY.get(), "Spectrum Jelly");

        add("tooltip.mekanismdelight.alloy_shake.1", "Clears 1 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.2", "Clears 2 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.4", "Clears 4 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.6", "Clears 6 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.8", "Clears 8 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.10", "Clears 10 Harmful Effect");
        add("tooltip.mekanismdelight.alloy_shake.all", "Clears ALL Harmful Effect");

        add("tooltip.mekanismdelight.radioactive_food", "Warning: Contains high levels of radiation");
    }

    private void addJapaneseTranslations() {
        add("itemGroup.mekanismdelight", "Mekanism Delight");

        add(MekanismDelightBlocks.ALLOY_JELLY_MEDLEY.get(), "合金ゼリーのロビット盛り");
        // add(MekanismDelightItems.ALLOY_JELLY_MEDLEY.get(), "Alloy Jelly Medley");

        add(MekanismDelightItems.FORMERLY_ROBIT.get(), "たぶんロビット");
        add(MekanismDelightItems.ROBIT_STEW.get(), "ロビットシチュー");

        add(MekanismDelightItems.INFUSED_SHAKE.get(), "吹込シェイク");
        add(MekanismDelightItems.REINFORCED_SHAKE.get(), "強化シェイク");
        add(MekanismDelightItems.ATOMIC_SHAKE.get(), "原子シェイク");

        add(MekanismDelightItems.INFUSED_JELLY.get(), "吹込ゼリー");
        add(MekanismDelightItems.REINFORCED_JELLY.get(), "強化ゼリー");
        add(MekanismDelightItems.ATOMIC_JELLY.get(), "原子ゼリー");

        add(MekanismDelightItems.POLONIUM_ICE_CREAM.get(), "ポロニウムのアイスクリーム");

        add(MekanismDelightItems.PLUTONIUM_HAMBURGER.get(), "プルトニウムのハンバーガー");
        add(MekanismDelightItems.POLONIUM_HAMBURGER.get(), "ポロニウムのハンバーガー");
        add(MekanismDelightItems.SAWDUST_HAMBURGER.get(), "おがくずバーガー");

        add(MekanismDelightItems.SALTED_RICE_BALL.get(), "塩むすび");
        add(MekanismDelightItems.ANTIMATTER_STEW.get(), "反物質シチュー");

        add(MekanismGeneratorsDelightItems.DT_DRINK.get(), "D-T飲料");
        add(MekanismGeneratorsDelightItems.FISSION_FUEL_DRINK.get(), "核分裂飲料");

        add(MekanismToolsDelightItems.BRONZE_KNIFE.get(), "青銅のナイフ");
        add(MekanismToolsDelightItems.LAPIS_LAZULI_KNIFE.get(), "ラピスラズリのナイフ");
        add(MekanismToolsDelightItems.OSMIUM_KNIFE.get(), "オスミウムのナイフ");
        add(MekanismToolsDelightItems.REFINED_GLOWSTONE_KNIFE.get(), "精製グロウストーンのナイフ");
        add(MekanismToolsDelightItems.REFINED_OBSIDIAN_KNIFE.get(), "精製黒曜石のナイフ");
        add(MekanismToolsDelightItems.STEEL_KNIFE.get(), "鋼鉄のナイフ");

        add(EvolvedMekanismDelightItems.HYPERCHARGED_SHAKE.get(), "超電シェイク");
        add(EvolvedMekanismDelightItems.SUBATOMIC_SHAKE.get(), "反粒子シェイク");
        add(EvolvedMekanismDelightItems.SINGULAR_SHAKE.get(), "特異シェイク");
        add(EvolvedMekanismDelightItems.EXOVERSAL_SHAKE.get(), "超次元シェイク");
        add(EvolvedMekanismDelightItems.CREATIVE_SHAKE.get(), "クリエイティブシェイク");

        add(EvolvedMekanismDelightItems.HYPERCHARGED_JELLY.get(), "超電ゼリー");
        add(EvolvedMekanismDelightItems.SUBATOMIC_JELLY.get(), "反粒子ゼリー");
        add(EvolvedMekanismDelightItems.SINGULAR_JELLY.get(), "特異ゼリー");
        add(EvolvedMekanismDelightItems.EXOVERSAL_JELLY.get(), "超次元ゼリー");
        add(EvolvedMekanismDelightItems.CREATIVE_JELLY.get(), "クリエイティブゼリー");

        add(EvolvedMekanismToolsDelightItems.BETTER_GOLD_KNIFE.get(), "超原構金のナイフ");
        add(EvolvedMekanismToolsDelightItems.PLASLITHERITE_KNIFE.get(), "プラスリザライトのナイフ");
        add(EvolvedMekanismToolsDelightItems.REFINED_REDSTONE_KNIFE.get(), "精製レッドストーンのナイフ");

        add(MekanismExtrasDelightItems.RADIANCE_SHAKE.get(), "放射シェイク");
        add(MekanismExtrasDelightItems.THERMONUCLEAR_SHAKE.get(), "熱核シェイク");
        add(MekanismExtrasDelightItems.SHINING_SHAKE.get(), "光輝シェイク");
        add(MekanismExtrasDelightItems.SPECTRUM_SHAKE.get(), "分光シェイク");

        add(MekanismExtrasDelightItems.RADIANCE_JELLY.get(), "放射ゼリー");
        add(MekanismExtrasDelightItems.THERMONUCLEAR_JELLY.get(), "熱核ゼリー");
        add(MekanismExtrasDelightItems.SHINING_JELLY.get(), "光輝ゼリー");
        add(MekanismExtrasDelightItems.SPECTRUM_JELLY.get(), "分光ゼリー");

        add("tooltip.mekanismdelight.alloy_shake.1", "1種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.2", "2種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.4", "4種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.6", "6種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.8", "8種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.10", "10種類の負の効果を除去");
        add("tooltip.mekanismdelight.alloy_shake.all", "全種類の負の効果を除去");

        add("tooltip.mekanismdelight.radioactive_food", "警告：高レベルの放射線を持つ");
    }
}
