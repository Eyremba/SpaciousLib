package org.anhcraft.spaciouslib.Utils;

import org.bukkit.Bukkit;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class GameVersion {

    /**
     * Get the server's bukkit version
     *
     * @return GVersion
     */
    public static GVersion getVersion(){
        return GVersion.valueOf(Bukkit.getServer().getClass().getPackage()
                .getName().replace(".",  ",").split(",")[3]);
    }

    public static Boolean is1_8Above(){
        return (Bukkit.getBukkitVersion().contains("1.8") ||
                Bukkit.getBukkitVersion().contains("1.9") ||
            Bukkit.getBukkitVersion().contains("1.10") ||
            Bukkit.getBukkitVersion().contains("1.11"));
    }

    public static Boolean is1_9Above(){
        return (Bukkit.getBukkitVersion().contains("1.9") ||
                Bukkit.getBukkitVersion().contains("1.10") ||
                Bukkit.getBukkitVersion().contains("1.11"));
    }

    public static Boolean is1_10Above(){
        return (Bukkit.getBukkitVersion().contains("1.10") ||
                Bukkit.getBukkitVersion().contains("1.11"));
    }

    public static Boolean is1_11Above(){
        return Bukkit.getBukkitVersion().contains("1.11");
    }
}
