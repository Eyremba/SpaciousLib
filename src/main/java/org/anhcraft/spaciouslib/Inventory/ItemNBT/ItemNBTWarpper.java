package org.anhcraft.spaciouslib.Inventory.ItemNBT;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public interface ItemNBTWarpper {
    ItemStack setString(String name, String value);
    ItemStack setInt(String name, int value);
    ItemStack setBoolean(String name, Boolean value);
    ItemStack setShort(String name, short value);
    ItemStack setDouble(String name, double value);
    ItemStack setFloat(String name, float value);
    ItemStack setLong(String name, long value);
    ItemStack setByte(String name, byte value);
    ItemStack setIntArray(String name, int[] value);
    ItemStack setByteArray(String name, byte[] value);
    String getString(String name);
    int getInt(String name);
    Boolean getBoolean(String name);
    short getShort(String name);
    double getDouble(String name);
    float getFloat(String name);
    long getLong(String name);
    byte getByte(String name);
    int[] getIntArray(String name);
    byte[] getByteArray(String name);
    HashMap<String,Byte> getAllTags();
    ItemNBTWarpper getCompound(String name);
}
