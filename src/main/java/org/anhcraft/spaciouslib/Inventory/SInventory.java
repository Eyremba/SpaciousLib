package org.anhcraft.spaciouslib.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class SInventory extends InteractItem {
    private Inventory inv;

    /**
     * Create a new s-inventory
     *
     * @param size the size of inventory
     * @param name the inventory name
     *
     * */
    public SInventory(String name, int size){
        inv = Bukkit.getServer().createInventory(null, size, name.replace("&", "§"));
    }

    /**
     * Create a new s-inventory
     *
     * @param inv bukkit inventory
     *
     */
    public SInventory(Inventory inv){
        this.inv = inv;
    }


    /**
     * Set an item for inventory
     *
     * @param column numerical order of column
     * @param row    numerical order of row
     * @param item   the item
     */
    public void set(int column, int row, ItemStack item){
        this.inv.setItem(column*row, item);
    }

    /**
     * Set an item for inventory
     *
     * @param index numerical order
     * @param item   the item
     */
    public void set(int index, ItemStack item){
        this.inv.setItem(index, item);
    }

    /**
     * Set an item with interact event for inventory
     *
     * @param column numerical order of column
     * @param row    numerical order of row
     * @param item   the item
     * @param run    interact event
     */
    public void set(int column, int row, ItemStack item, InteractItemRunnable run){
        this.inv.setItem(column*row, item);
        a(inv, item, run);
    }

    /**
     * Set an item with interact event for inventory
     *
     * @param index numerical order
     * @param item   the item
     * @param run    interact event
     */
    public void set(int index, ItemStack item, InteractItemRunnable run){
        this.inv.setItem(index, item);
        a(inv, item, run);
    }

    /**
     * Remove an item of inventory
     *
     * @param column numerical order of column
     * @param row    numerical order of row
     *
     * @deprecation
     */
    @SuppressWarnings("deprecation")
    public void remove(int column, int row){
        this.inv.remove(column*row);
    }

    /**
     * Remove an item of inventory
     *
     * @param item this item
     */
    public void remove(ItemStack item){
        this.inv.remove(item);
    }

    /**
     * Get an item of inventory
     *
     * @param column numerical order of column
     * @param row    numerical order of row
     *
     * @return the item stack
     */
    public ItemStack get(int column, int row){
        return this.inv.getItem(column*row);
    }

    /**
     * Get an item of inventory
     *
     * @param index index
     *
     * @return the item stack
     */
    public ItemStack get(int index){
        return this.inv.getItem(index);
    }

    /**
     * Clear all item of inventory
     */
    public void clear(){
        this.inv.clear();
    }

    /**
     * Open an inventory for a player
     *
     * @param name the player name
     */
    public void open(String name){
        Bukkit.getServer().getPlayer(name).openInventory(this.inv);
    }

    /**
     * Open an inventory for a player
     *
     * @param uuid the uuid
     */
    public void open(UUID uuid){
        Bukkit.getServer().getPlayer(uuid).openInventory(this.inv);
    }

    /**
     * Open an inventory for a player
     *
     * @param player the player
     */
    public void open(Player player){
        player.openInventory(this.inv);
    }

    /**
     * Get inventory
     *
     * @return inventory
     */
    public Inventory getInventory(){
        return inv;
    }

    /**
     * Get all items (not include null item)
     *
     * @return all items
     */
    public List<ItemStack> getAllItems(){
        List<ItemStack> items = new ArrayList<>();
        for(ItemStack i : inv.getContents()){
            if(i != null && !i.getType().equals(Material.AIR)){
                items.add(i);
            }
        }
        return items;
    }
}
