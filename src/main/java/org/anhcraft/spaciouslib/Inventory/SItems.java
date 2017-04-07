package org.anhcraft.spaciouslib.Inventory;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class SItems extends ItemStack {
	private ItemStack item;

	/**
	 * Register for an item
	 *
	 * @param item the item
	 */
	public SItems(ItemStack item){
		this.item = item;
	}

	/**
	 * Create new item
	 *
	 * @param name   new name for the item
	 * @param type   new type for the item
	 * @param amount amount for the item
	 *
	 * @return the item created
	 */
	public SItems(String name, Material type, int amount){
		ItemStack a = new ItemStack(type, amount);
		ItemMeta b = a.getItemMeta();
		b.setDisplayName(name.replace("&", "§"));
		a.setItemMeta(b);
        this.item = a;
	}

	/**
	 * Create new item
	 *
	 * @param name   new name for the item
	 * @param type   new type for the item
	 * @param amount amount for the item
	 * @param lores  new lores for the item
	 *
	 * @return the item created
	 */
	public SItems(String name, Material type, int amount, List<String> lores){
		ItemStack a = new ItemStack(type, amount);
		ItemMeta b = a.getItemMeta();
		b.setDisplayName(name.replace("&", "§"));
		List<String> loress = new ArrayList<String>();
		for(String c: lores){
			loress.add(c.replace("&", "§"));
		}
		b.setLore(loress);
		a.setItemMeta(b);
        this.item = a;
	}

	/**
	 * Get the name of an item
	 *
	 * @return the name of this item
	 */
	public String name(){
		ItemMeta a = this.item.getItemMeta();
		return a.getDisplayName();
	}

	/**
	 * Set the name for an item
	 *
	 * @param name new name for the item
	 */
	public void name(String name){
		ItemMeta a = this.item.getItemMeta();
		a.setDisplayName(name.replace("&", "§"));
		this.item.setItemMeta(a);
	}

	/**
	 * Add an echantment for an item
	 *
	 * @param enchant the enchant name
	 * @param level   the enchant level
	 */
	public void addEnchant(Enchantment enchant, int level){
		ItemMeta a = this.item.getItemMeta();
		a.addEnchant(enchant, level, true);
		this.item.setItemMeta(a);
	}

	/**
	 * Remove an echantment of an item
	 *
	 * @param enchant the enchant name
	 */
	public void removeEnchant(Enchantment enchant){
		ItemMeta a = this.item.getItemMeta();
		a.removeEnchant(enchant);
		this.item.setItemMeta(a);
	}

	/**
	 * Get all echantments of an item
	 *
	 * @return all echantments of this item
	 */
	public Map<Enchantment, Integer> enchants(){
		ItemMeta a = this.item.getItemMeta();
		return a.getEnchants();
	}

	/**
	 * Get level of an echantment of an item
	 *
	 * @param enchant the enchant
	 *
	 * @return the level of this echantment
	 */
	public int enchant(Enchantment enchant){
		ItemMeta a = this.item.getItemMeta();
		return a.getEnchantLevel(enchant);
	}

	/**
	 * Set lore for an item
	 *
	 * @param text the lore
	 */
	public void setLore(String text){
		ItemMeta a = this.item.getItemMeta();
		List<String> lores;
		if(a.hasLore()){
			lores = a.getLore();
		} else {
			lores = new ArrayList<String>();
		}
		lores.add(text.replace("&", "§"));
		a.setLore(lores);
		this.item.setItemMeta(a);
	}

	/**
	 * Set lores for an item
	 *
	 * @param texts the lores
	 */
	public void setLores(List<String> texts){
		ItemMeta a = this.item.getItemMeta();
		List<String> lores;
		if(a.hasLore()){
			lores = a.getLore();
		} else {
			lores = new ArrayList<String>();
		}
		for(String b: texts){
			lores.add(b.replace("&", "§"));
		}
		a.setLore(lores);
		this.item.setItemMeta(a);
	}

	/**
	 * Remove lore of an item
	 *
	 * @param order numerical order of row
	 */
	public void removeLore(int order){
		ItemMeta a = this.item.getItemMeta();
		List<String> lores = a.getLore();
		lores.remove(order);
		a.setLore(lores);
		this.item.setItemMeta(a);
	}

	/**
	 * Get all lores of an item
	 *
	 * @return all lores of this item
	 */
	public List<String> lore(){
		ItemMeta a = this.item.getItemMeta();
		return a.getLore();
	}

	/**
	 * Set flags for an item
	 *
	 * @param flag the flag
	 */
	public void flag(ItemFlag flag){
		ItemMeta a = this.item.getItemMeta();
		a.addItemFlags(flag);
		this.item.setItemMeta(a);
	}

	/**
	 * Get all flags of an item
	 *
	 * @return all flags of this item
	 */
	public Set<ItemFlag> flag(){
		ItemMeta a = this.item.getItemMeta();
		return a.getItemFlags();
	}

	/**
	 * Set the durability for an item
	 *
	 * @param durability the durability
	 */
	public void durability(short durability){
		this.item.setDurability(durability);
	}

	/**
	 * Get the durability of an item
	 *
	 * @return the durability of this item
	 */
	public short durability(){
		return this.item.getDurability();
	}
	
	/**
	 * 
     * Set the type for an item
     * 
     * @param type the type name
     * 
     */
	@Override
	public void setType(Material type){
		this.item.setType(type);
	}

	/**
	 * Set the type for an item
	 *
	 * @param type the type id
	 *
	 * @deprecation
	 */
	@SuppressWarnings("deprecation")
	public void setType(int type){
		this.item.setTypeId(type);
	}
	
	/**
	 * 
     * Get the type name of an item
     * 
     * @return the type name of this item
     * 
     */
	public Material getType(){
		return this.item.getType();
	}
	
	/**
	 * 
     * Get the type id of an item
     * 
     * @return the type id of this item
     * @deprecation 
     * 
     */
	@SuppressWarnings("deprecation")
	@Override
	public int getTypeId(){
		return this.item.getTypeId();
	}

	/**
	 * Set amount for an item
	 *
	 * @param amount amount
	 */
	public void amount(int amount){
		this.item.setAmount(amount);
	}

	/**
	 * Get amount of an item
	 *
	 * @return amount of this item
	 */
	public int amount(){
		return this.item.getAmount();
	}

    /**
     * Get the item
     *
     * @return item
     */
    public ItemStack getItem(){
        return item;
    }
}
