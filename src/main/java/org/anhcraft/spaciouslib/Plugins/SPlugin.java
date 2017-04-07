package org.anhcraft.spaciouslib.Plugins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Event;
import org.bukkit.plugin.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLClassLoader;
import java.util.*;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class SPlugin {
    public static Plugin getPlugin(String p){
        System.out.println(Arrays.toString(Bukkit.getServer().getPluginManager().getPlugins()));
        if(new ArrayList<>(Arrays.asList(Bukkit.getServer().getPluginManager().getPlugins())).contains(p)){
            return Bukkit.getServer().getPluginManager().getPlugin(p);
        } else {
            throw new NullPointerException();
        }
    }

    public static File getPluginFile(String p) throws IOException {
        File c = null;
        File directory = new File("plugins");
        if(directory.exists() && directory.isDirectory() && directory.listFiles() != null) {
            HashMap<String, File> files = new HashMap<>();
            for(File file : directory.listFiles()) {
                if(file.isFile()) {
                    String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                    if(-1 < file.getName().lastIndexOf(".") && type.equals("jar")) {
                        files.put(file.getName().replace("." + type, ""), file);
                    }
                }
            }
            if(0 < files.size()){
                if(files.containsKey(p)){
                    c = files.get(p);
                }
                else if(files.containsKey(p.toLowerCase())){
                    c = files.get(p.toLowerCase());
                }
                else if(files.containsKey(p.toUpperCase())){
                    c = files.get(p.toUpperCase());
                }
                // advanced
                p = p.split("\\.")[0];
                if(files.containsKey(p)){
                    c = files.get(p);
                }
                else if(files.containsKey(p.toLowerCase())){
                    c = files.get(p.toLowerCase());
                }
                else if(files.containsKey(p.toUpperCase())){
                    c = files.get(p.toUpperCase());
                }
            }
        }
        return c;
    }

    public static Boolean enablePlugin(Plugin p){
        if(!Bukkit.getServer().getPluginManager().isPluginEnabled(p)){
            Bukkit.getServer().getPluginManager().enablePlugin(p);
            return true;
        } else {
            return false;
        }
    }

    public static Boolean enablePlugin(String p){
        if(!Bukkit.getServer().getPluginManager().isPluginEnabled(p)){
            Bukkit.getServer().getPluginManager().enablePlugin(getPlugin(p));
            return true;
        } else {
            return false;
        }
    }

    public static Boolean disablePlugin(Plugin p){
        if(Bukkit.getServer().getPluginManager().isPluginEnabled(p)){
            Bukkit.getServer().getPluginManager().disablePlugin(p);
            return true;
        } else {
            return false;
        }
    }

    public static Boolean disablePlugin(String p){
        if(Bukkit.getServer().getPluginManager().isPluginEnabled(p)){
            Bukkit.getServer().getPluginManager().disablePlugin(getPlugin(p));
            return true;
        } else {
            return false;
        }
    }

    public static Plugin loadPlugin(String f) throws InvalidDescriptionException,
            InvalidPluginException, IOException {
        File fl = getPluginFile(f);
        if(fl != null){
            return Bukkit.getServer().getPluginManager().loadPlugin(fl);
        } else {
            return null;
        }
    }

    public static Boolean loadPlugin(File f) throws InvalidDescriptionException, InvalidPluginException {
        if(f.exists()){
            Bukkit.getServer().getPluginManager().loadPlugin(f);
            return true;
        } else {
            return false;
        }
    }

    public static boolean unloadPlugin(Plugin plugin) throws NoSuchFieldException, IllegalAccessException, IOException {
        String name = plugin.getName();
        PluginManager pluginManager = Bukkit.getPluginManager();
        SimpleCommandMap commandMap = null;
        List<Plugin> plugins = null;
        Map<String, Plugin> names = null;
        Map<String, Command> commands = null;
        Map<Event, SortedSet<RegisteredListener>> listeners = null;
        if (pluginManager != null) {
            disablePlugin(plugin);
            Field pluginsField = Bukkit.getPluginManager().getClass().getDeclaredField("plugins");
            pluginsField.setAccessible(true);
            plugins = (List<Plugin>) pluginsField.get(pluginManager);
            Field lookupNamesField = Bukkit.getPluginManager().getClass().getDeclaredField("lookupNames");
            lookupNamesField.setAccessible(true);
            names = (Map<String, Plugin>) lookupNamesField.get(pluginManager);
            Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (SimpleCommandMap) commandMapField.get(pluginManager);
            Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
            knownCommandsField.setAccessible(true);
            commands = (Map<String, Command>) knownCommandsField.get(commandMap);
        }
        disablePlugin(plugin);

        if (plugins != null && plugins.contains(plugin)) {
            plugins.remove(plugin);
        }
        if (names != null && names.containsKey(name)) {
            names.remove(name);
        }
        if (commandMap != null) {
            for (Iterator<Map.Entry<String, Command>> it = commands.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Command> entry = it.next();
                if (entry.getValue() instanceof PluginCommand) {
                    PluginCommand c = (PluginCommand) entry.getValue();
                    if (c.getPlugin() == plugin) {
                        c.unregister(commandMap);
                        it.remove();
                    }
                }
            }
        }
        ClassLoader cl = plugin.getClass().getClassLoader();
        if (cl instanceof URLClassLoader) {
            ((URLClassLoader) cl).close();
        }
        System.gc();
        return true;
    }

    public static boolean unloadPlugin(String pl) throws NoSuchFieldException, IllegalAccessException, IOException {
        Plugin plugin = getPlugin(pl);
        String name = plugin.getName();
        PluginManager pluginManager = Bukkit.getPluginManager();
        SimpleCommandMap commandMap = null;
        List<Plugin> plugins = null;
        Map<String, Plugin> names = null;
        Map<String, Command> commands = null;
        Map<Event, SortedSet<RegisteredListener>> listeners = null;
        if (pluginManager != null) {
            disablePlugin(plugin);
            Field pluginsField = Bukkit.getPluginManager().getClass().getDeclaredField("plugins");
            pluginsField.setAccessible(true);
            plugins = (List<Plugin>) pluginsField.get(pluginManager);
            Field lookupNamesField = Bukkit.getPluginManager().getClass().getDeclaredField("lookupNames");
            lookupNamesField.setAccessible(true);
            names = (Map<String, Plugin>) lookupNamesField.get(pluginManager);
            Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (SimpleCommandMap) commandMapField.get(pluginManager);
            Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
            knownCommandsField.setAccessible(true);
            commands = (Map<String, Command>) knownCommandsField.get(commandMap);
        }
        disablePlugin(plugin);

        if (plugins != null && plugins.contains(plugin)) {
            plugins.remove(plugin);
        }
        if (names != null && names.containsKey(name)) {
            names.remove(name);
        }
        if (commandMap != null) {
            for (Iterator<Map.Entry<String, Command>> it = commands.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Command> entry = it.next();
                if (entry.getValue() instanceof PluginCommand) {
                    PluginCommand c = (PluginCommand) entry.getValue();
                    if (c.getPlugin() == plugin) {
                        c.unregister(commandMap);
                        it.remove();
                    }
                }
            }
        }
        ClassLoader cl = plugin.getClass().getClassLoader();
        if (cl instanceof URLClassLoader) {
            ((URLClassLoader) cl).close();
        }
        System.gc();
        return true;
    }

    public static void reload(Plugin plugin) throws IllegalAccessException, NoSuchFieldException,
            IOException, InvalidDescriptionException, InvalidPluginException {
        if (plugin != null) {
            unloadPlugin(plugin);
            loadPlugin(plugin.getName());
        }
    }
}
