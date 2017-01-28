package com.yaibatoken.ps2addon.stats;

import com.mrdimka.playerstats2.api.stats.StatAnimation;
import com.mrdimka.playerstats2.api.stats.api.PlayerStatsAPI;
import com.mrdimka.playerstats2.api.stats.core.IPlayerStatCombat;
import com.mrdimka.playerstats2.init.ModStats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.UUID;

/**
 * Created by YaibaToKen on 28-Jan-17.
 */
public class PlayerStatAttackDamage implements IPlayerStatCombat {
    private UUID id;

    @Override
    public float getDamageDealt(int level, ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        return (float)Math.sqrt((double)level) + itemStack.getMaxDamage();
    }

    @Override
    public float getWeaponReequipSpeed(int level, ItemStack itemStack) {
        return 0.0F;
    }

    @Override
    public int getMaxLevel() {
        return 25;
    }

    @Override
    public int getXPToUpgrade(int prevLev) {
        return (int)Math.pow((double)(prevLev + 1), 1.5D);
    }

    @Override
    public Object getIconInactive() {
        return PlayerStatsAPI.INST.getUV(ModStats.icons, 0, 96, 24, 24);
    }

    @Override
    public Object getIconHovered() {
        return PlayerStatsAPI.INST.getUV(ModStats.icons, 24, 96, 24, 24);
    }

    @Override
    public StatAnimation getBookHoveredAnimation() {
        return StatAnimation.FLASING;
    }

    @Override
    public String getStatName() {
        return "stats.ps2addon:attack_damage.name";
    }

    @Override
    public String getStatDescription() {
        return "stats.ps2addon:attack_damage.description";
    }

    @Override
    public UUID getStatID() {
        return id;
    }

    @Override
    public Map.Entry<String, String>[] getAdditionalFormattingData(int level) {
        return new Map.Entry[0];
    }

    @Override
    public void setStatID(UUID uuid) {
        this.id = uuid;
    }
}
