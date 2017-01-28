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
        addOreDrop("Copper", 3, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Tin", 3, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Nickel", 7, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Zinc", 7, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Silver", 8, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Lead", 8, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Platinum", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Alumina", 4, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Chromium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);

        //Base Metals Ores
        addOreDrop("Mercury", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("ColdIron", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Adamantine", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("StarSteel", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);

        //Modern Metals Ores
        addOreDrop("Aluminum", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Cadmium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Iridium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Magnesium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Manganese", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Nichrome", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Osmium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Plutonium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Rutile", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Tantalum", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Titanium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Tungsten", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Uranium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Zirconium", 15, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);

        //TAIGA'S Ores
        addOreDrop("Tiberium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Aurorium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Prometheum", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Duranite", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Valyrium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Vibranium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Karmesine", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Ovium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Jauxum", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Palladium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Uru", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Osram", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Eezo", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Abyssum", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Dilithium", 30, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);

        //Tinker's Construct Ores
        addOreDrop("Cobalt", 20, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
        addOreDrop("Ardite", 20, NUGGET_ENABLE, INGOT_ENABLE, ORE_ENABLE);
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
}
