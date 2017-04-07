package org.anhcraft.spaciouslib.Files;

import java.io.*;
import java.util.List;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class UTF8FileWriter {

    /**
     * Write a UTF8 file
     *
     * @param strs list of lines
     * @param f file to write
     *
     */
    public void UTF8FileWriter(List<String> strs, File f) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(f), "UTF8"));
        for(String s : strs) {
            out.write(s);
        }
        out.flush();
        out.close();
    }
}
