package org.anhcraft.spaciouslib.Files;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class UTF8BOMCleaner {
    private static final String UTF8_BOM = "\uFEFF";

    /**
     * Remove all BOM in a string
     *
     * @param s a string
     *
     * @return a new string
     */
    public static String a(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
}
