package com.yaibatoken.ps2addon;

import com.mrdimka.playerstats2.api.core.IPSPlugin;
import com.mrdimka.playerstats2.api.core.IPSRuntime;
import com.mrdimka.playerstats2.api.stats.PlayerStatRegistry;
import com.mrdimka.playerstats2.api.stats.core.IPlayerStat;
import com.mrdimka.playerstats2.utility.PS2Log;
import com.yaibatoken.ps2addon.stats.PlayerStatAttackDamage;
import com.yaibatoken.ps2addon.stats.TreasureFinderOreDrops;
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

public class PS2Addon implements IPSPlugin{
    public static final String MODID = "ps2addon";
    public static final String VERSION = "0.1.0";

    public static final IPlayerStat attackDamageStat = new PlayerStatAttackDamage();

    @Override
    public void register() {
        PlayerStatRegistry.registerStat(attackDamageStat);
        TreasureFinderOreDrops.init();
    }

    @Override
    public void runtimeAvaliable(IPSRuntime ipsRuntime) {
        PS2Log.info("Player Stats 2 Addon working with Player Stats 2 v" + ipsRuntime.getModVersion());
    }
}
