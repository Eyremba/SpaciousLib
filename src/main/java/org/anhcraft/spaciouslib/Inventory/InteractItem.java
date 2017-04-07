package org.anhcraft.spaciouslib.Inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class InteractItem implements Listener {
    private static HashMap<Inventory, HashMap<ItemStack, InteractItemRunnable>> data = new HashMap<>();

    public static void a(Inventory inv, ItemStack item, InteractItemRunnable run){
        HashMap<ItemStack, InteractItemRunnable> items = new HashMap<>();
        if(data.containsKey(inv)){
            items = data.get(inv);
        }
        items.put(item, run);
        data.put(inv, items);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void interact(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        ClickType type = event.getClick();
        if (inventory != null && data.containsKey(inventory)){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
            ItemStack item = inventory.getItem(event.getSlot());
            if(item != null && !item.getType().equals(Material.AIR) && data.get(inventory).containsKey(item)){
                data.get(inventory).get(item).run(player, item, type, event.getSlot());
            }
        }
    }
}
