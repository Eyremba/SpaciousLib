package org.anhcraft.spaciouslib.Inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public interface InteractItemRunnable {
    void run(Player player, ItemStack item, ClickType action, int slot);
}
