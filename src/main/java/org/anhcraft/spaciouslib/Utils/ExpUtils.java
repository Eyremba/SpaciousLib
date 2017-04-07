package org.anhcraft.spaciouslib.Utils;

import org.bukkit.entity.Player;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class ExpUtils {
    public static void setTotalExperience(final Player player, final int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Experience is negative!");
        }
        player.setExp(0);
        player.setLevel(0);
        player.setTotalExperience(0);
        int amount = exp;
        while (amount > 0) {
            final int expToLevel = getExpAtLevel(player);
            amount -= expToLevel;
            if (amount >= 0){
                player.giveExp(expToLevel);
            }
            else{
                // give the rest
                amount += expToLevel;
                player.giveExp(amount);
                amount = 0;
            }
        }
    }

    private static int getExpAtLevel(final Player player)
    {
        return getExpAtLevel(player.getLevel());
    }

    public static int getExpAtLevel(final int level) {
        if (level > 29){
            return 62 + (level - 30) * 7;
        }
        if (level > 15){
            return 17 + (level - 15) * 3;
        }
        return 17;
    }

    public static int getExpToLevel(final int level){
        int currentLevel = 0;
        int exp = 0;

        while (currentLevel < level) {
            exp += getExpAtLevel(currentLevel);
            currentLevel++;
        }
        if (exp < 0){
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public static int getTotalExperience(final Player player){
        int exp = (int)Math.round(getExpAtLevel(player) * player.getExp());
        int currentLevel = player.getLevel();

        while (currentLevel > 0) {
            currentLevel--;
            exp += getExpAtLevel(currentLevel);
        }
        if (exp < 0) {
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public static int getExpUntilNextLevel(final Player player) {
        int exp = (int)Math.round(getExpAtLevel(player) * player.getExp());
        int nextLevel = player.getLevel();
        return getExpAtLevel(nextLevel) - exp;
    }
}
