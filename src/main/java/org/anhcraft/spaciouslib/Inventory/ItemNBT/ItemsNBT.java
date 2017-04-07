package org.anhcraft.spaciouslib.Inventory.ItemNBT;

import org.anhcraft.spaciouslib.Utils.GameVersion;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class ItemsNBT implements ItemNBTWarpper {
    private ItemStack item;

    /**
     * Manage NBT Tags of an item
     * @param i Item
     */
    public ItemsNBT(ItemStack i){
        item = i.clone();
    }

    @Override
    public ItemStack setString(String name, String value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setString(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setInt(String name, int value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setInt(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setBoolean(String name, Boolean value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setBoolean(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setShort(String name, short value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setShort(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setDouble(String name, double value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setDouble(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setFloat(String name, float value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setFloat(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setLong(String name, long value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setLong(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setByte(String name, byte value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setByte(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setIntArray(String name, int[] value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setIntArray(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemStack setByteArray(String name, byte[] value) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.setByteArray(name, value);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public String getString(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getString(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public int getInt(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getInt(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public Boolean getBoolean(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getBoolean(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public short getShort(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getShort(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public double getDouble(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getDouble(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public float getFloat(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getFloat(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public long getLong(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getLong(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public byte getByte(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getByte(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return 0;
        }
    }

    @Override
    public int[] getIntArray(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getIntArray(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public byte[] getByteArray(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getByteArray(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public HashMap<String, Byte> getAllTags() {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getAllTags();
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemNBTWarpper getCompound(String name) {
        try {
            Class e = Class.forName("org.anhcraft.spaciouslib.Inventory.ItemNBT.ItemNBT_"+
                    GameVersion.getVersion().toString().replace("v",""));
            Constructor c = e.getConstructor(ItemStack.class);
            ItemNBTWarpper i = (ItemNBTWarpper) c.newInstance(item);
            return i.getCompound(name);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException x) {
            x.printStackTrace();
            return null;
        }
    }
}
