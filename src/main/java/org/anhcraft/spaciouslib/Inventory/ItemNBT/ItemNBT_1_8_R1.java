package org.anhcraft.spaciouslib.Inventory.ItemNBT;

import net.minecraft.server.v1_8_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class ItemNBT_1_8_R1 implements ItemNBTWarpper {
    private ItemStack item;
    private net.minecraft.server.v1_8_R1.ItemStack nmsItem;
    private NBTTagCompound compound;

    public ItemNBT_1_8_R1(ItemStack i){
        item = i;
        nmsItem = CraftItemStack.asNMSCopy(i);
        NBTTagCompound c = nmsItem.getTag();
        if (c == null) {
            c = new NBTTagCompound();
            nmsItem.setTag(c);
            c = nmsItem.getTag();
        }
        compound = c;
    }

    public ItemNBT_1_8_R1(ItemStack i, String cp){
        item = i;
        nmsItem = CraftItemStack.asNMSCopy(i);
        NBTTagCompound c = nmsItem.getTag();
        compound = c.getCompound(cp);
    }

    @Override
    public ItemStack setString(String name, String value) {
        compound.setString(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setInt(String name, int value) {
        compound.setInt(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setBoolean(String name, Boolean value) {
        compound.setBoolean(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setShort(String name, short value) {
        compound.setShort(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setDouble(String name, double value) {
        compound.setDouble(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setFloat(String name, float value) {
        compound.setFloat(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setLong(String name, long value) {
        compound.setLong(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setByte(String name, byte value) {
        compound.setByte(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setIntArray(String name, int[] value) {
        compound.setIntArray(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public ItemStack setByteArray(String name, byte[] value) {
        compound.setByteArray(name, value);
        nmsItem.setTag(compound);
        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    @Override
    public String getString(String name) {
        return compound.getString(name);
    }

    @Override
    public int getInt(String name) {
        return compound.getInt(name);
    }

    @Override
    public Boolean getBoolean(String name) {
        return compound.getBoolean(name);
    }

    @Override
    public short getShort(String name) {
        return compound.getShort(name);
    }

    @Override
    public double getDouble(String name) {
        return compound.getDouble(name);
    }

    @Override
    public float getFloat(String name) {
        return compound.getFloat(name);
    }

    @Override
    public long getLong(String name) {
        return compound.getLong(name);
    }

    @Override
    public byte getByte(String name) {
        return compound.getByte(name);
    }

    @Override
    public int[] getIntArray(String name) {
        return compound.getIntArray(name);
    }

    @Override
    public byte[] getByteArray(String name) {
        return compound.getByteArray(name);
    }
    @Override
    public HashMap<String, Byte> getAllTags() {
        HashMap<String, Byte> h = new HashMap<>();
        for(Object s : compound.c()){
            h.put(s.toString(), compound.get(s.toString()).getTypeId());
        }
        return h;
    }

    @Override
    public ItemNBTWarpper getCompound(String name) {
        return new ItemNBT_1_8_R1(item, name);
    }
}
