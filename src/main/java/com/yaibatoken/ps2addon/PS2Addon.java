package com.yaibatoken.ps2addon;

import net.minecraftforge.fml.common.Mod;

/**
 * Created by YaibaToKen on 25-Jan-17.
 */

@Mod(
        modid = PS2Addon.MODID,
        version = PS2Addon.VERSION,
        dependencies =
                "required-after:playerstats2@[1.10.2-7r,);"
        )
public class PS2Addon {
    public static final String MODID = "ps2addon";
    public static final String VERSION = "0.1.0";
}