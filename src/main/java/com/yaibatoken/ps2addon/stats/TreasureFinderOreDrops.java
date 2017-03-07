package com.yaibatoken.ps2addon.stats;

import com.mrdimka.playerstats2.api.stats.treasurefinder.TreasureFinderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by YaibaToKen on 27-Jan-17.
 */
public class TreasureFinderOreDrops {
    private static final int
            NUGGET_AMOUNT = 6,
            INGOT_AMOUNT = 1;

    private static final float
            NUGGET_CHANCE = 0.475F,
            INGOT_CHANCE = 0.175F,
            ORE_CHANCE = 0.2F;

    private static final boolean
            NUGGET_ENABLE = false,
            INGOT_ENABLE = false,
            ORE_ENABLE = true;

    public static void init(){
        //Vanilla Ores
        addOreDrop("Iron", 5, true, false, false);
        addOreDrop("Gold", 10, true, false, false);

        //Substratum Ores
        addOreDrop("Copper", 5);
        addOreDrop("Tin", 5);
        addOreDrop("Nickel", 10);
        addOreDrop("Zinc", 10);
        addOreDrop("Silver", 10);
        addOreDrop("Lead", 10);
        addOreDrop("Platinum", 15);
        addOreDrop("Alumina", 5);
        addOreDrop("Chromium", 15);

        //Ars Magica 2 Ores
        addOreDrop("Vinteum", 10);
        addOreDrop("Chimerite", 15);
        addOreDrop("Blue Topaz", 20);
        addOreDrop("Moonstone", 25);
        addOreDrop("Sunstone", 30);

        //Base Metals Ores
        addOreDrop("Mercury", 15);
        addOreDrop("ColdIron", 20);
        addOreDrop("Adamantine", 30);
        addOreDrop("StarSteel", 40);

        //Modern Metals Ores
        addOreDrop("Aluminum", 10);
        addOreDrop("Cadmium", 15);
        addOreDrop("Iridium", 15);
        addOreDrop("Magnesium", 10);
        addOreDrop("Manganese", 10);
        addOreDrop("Nichrome", 15);
        addOreDrop("Osmium", 15);
        addOreDrop("Plutonium", 20);
        addOreDrop("Rutile", 20);
        addOreDrop("Tantalum", 15);
        addOreDrop("Titanium", 25);
        addOreDrop("Tungsten", 15);
        addOreDrop("Uranium", 25);
        addOreDrop("Zirconium", 15);

        //Immersive Engineering Ores
        addOreDrop("Bauxite", 10);

        //TAIGA'S Ores
        addOreDrop("Tiberium", 30);
        addOreDrop("Aurorium", 30);
        addOreDrop("Prometheum", 30);
        addOreDrop("Duranite", 30);
        addOreDrop("Valyrium", 30);
        addOreDrop("Vibranium", 30);
        addOreDrop("Karmesine", 30);
        addOreDrop("Ovium", 30);
        addOreDrop("Jauxum", 30);
        addOreDrop("Palladium", 30);
        addOreDrop("Uru", 30);
        addOreDrop("Osram", 30);
        addOreDrop("Eezo", 30);
        addOreDrop("Abyssum", 30);
        addOreDrop("Dilithium", 30);

        //Tinker's Construct Ores
        addOreDrop("Cobalt", 20);
        addOreDrop("Ardite", 20);
    }

    private static void addOreDictDrop(String name, float chance, int minLevel){
        addOreDictDrop(name, chance, minLevel, 1);
    }

    private static void addOreDictDrop(String name, float chance, int minLevel, int amount){
        if(OreDictionary.doesOreNameExist(name)){
            ItemStack stack = OreDictionary.getOres(name).get(0);
            stack.stackSize = amount;
            TreasureFinderRegistry.registerDrop(chance, minLevel, stack);
        }
    }

    private static void addOreDrop(String name, int minLevel, boolean nugget, boolean ingot, boolean ore){
        if(ore) addOreDictDrop("ore" + name, ORE_CHANCE, minLevel);
        if(ingot) addOreDictDrop("ingot" + name, INGOT_CHANCE, minLevel, INGOT_AMOUNT);
        if(nugget) addOreDictDrop("nugget" + name, NUGGET_CHANCE, minLevel, NUGGET_AMOUNT);
    }

    private static void addOreDrop(String name, int minLevel){
        addOreDrop(name, minLevel, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
    }
}
