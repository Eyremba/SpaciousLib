package org.anhcraft.spaciouslib.Plugins;

import org.anhcraft.spaciouslib.Utils.DownloadProgressRunnable;
import org.anhcraft.spaciouslib.Utils.URLUtils;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class SPluginUpdate {
    public SPluginUpdate(Plugin p, String fileurl, String newfile, File oldfile, DownloadProgressRunnable r)
            throws IllegalAccessException, NoSuchFieldException, IOException,
            InvalidDescriptionException, InvalidPluginException {
        SPlugin.disablePlugin(p);
        SPlugin.unloadPlugin(p);
        if(URLUtils.download(fileurl, "plugins/" + newfile, r)) {
            SPlugin.enablePlugin(SPlugin.loadPlugin(newfile.replace(".jar","")));
            if(oldfile.exists()){
                oldfile.delete();
            }
        }
    }
}
