package com.yaibatoken.ps2addon.stats;

import com.mrdimka.playerstats2.api.PlayerStatsPlugin;
import com.mrdimka.playerstats2.api.core.IPSPlugin;
import com.mrdimka.playerstats2.api.core.IPSRuntime;
import com.mrdimka.playerstats2.api.stats.PlayerStatRegistry;
import com.mrdimka.playerstats2.api.stats.core.IPlayerStat;
import com.mrdimka.playerstats2.utility.PS2Log;

/**
 * Created by YaibaToKen on 28-Jan-17.
 */
@PlayerStatsPlugin
public class Register implements IPSPlugin {
    public static final IPlayerStat attackDamageStat = new PlayerStatAttackDamage();

    @Override
    public void register() {
        //PlayerStatRegistry.registerStat(attackDamageStat);
        TreasureFinderOreDrops.init();
    }

    @Override
    public void runtimeAvaliable(IPSRuntime ipsRuntime) {
        PS2Log.info("Player Stats 2 Addon working with Player Stats 2 v" + ipsRuntime.getModVersion());
    }
}
