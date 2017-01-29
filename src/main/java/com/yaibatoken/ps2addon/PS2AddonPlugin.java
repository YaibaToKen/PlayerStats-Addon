package com.yaibatoken.ps2addon;

import com.mrdimka.playerstats2.api.PlayerStatsPlugin;
import com.mrdimka.playerstats2.api.core.IPSPlugin;
import com.mrdimka.playerstats2.api.core.IPSRuntime;
import com.mrdimka.playerstats2.api.stats.PlayerStatRegistry;
import com.mrdimka.playerstats2.api.stats.core.IPlayerStat;
import com.mrdimka.playerstats2.utility.PS2Log;
import com.yaibatoken.ps2addon.stats.PlayerStatAttackDamage;
import com.yaibatoken.ps2addon.stats.TreasureFinderOreDrops;

/**
 * Created by YaibaToKen on 25-Jan-17.
 * This is the plugin that registers all drops and stats
 */
@PlayerStatsPlugin
public class PS2Addon implements IPSPlugin {
    public static final IPlayerStat attackDamageStat = new PlayerStatAttackDamage();

    @Override
    public void register() {
        registerStat(attackDamageStat); //Register stat using always-sorted method
        TreasureFinderOreDrops.init();
    }

    @Override
    public void runtimeAvaliable(IPSRuntime ipsRuntime) {
        PS2Log.info("Player Stats 2 Addon working with Player Stats 2 v" + ipsRuntime.getModVersion());
    }
	
	/**
	* This method should be used to add stats, because sometimes Arrays.sort() gives an error;
	* This will get fixed in Player Stats, I promise! But for now, this will do...
	*/
	private static void registerStat(IPlayerStat stat)
	{
		int tries = 0;
		while(tries < 64) try {
			PlayerStatRegistry.registerStat(stat);
			break;
		} catch(Throwable err) { ++tries; }
	}
}