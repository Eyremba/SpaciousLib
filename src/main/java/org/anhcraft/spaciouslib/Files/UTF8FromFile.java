package org.anhcraft.spaciouslib.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class UTF8FromFile {
    private File f;
    private StringBuilder s = new StringBuilder();

    /**
     * Read a UTF8 file
     *
     * @param f file to read
     *
     */
    public UTF8FromFile(File f){
        this.f = f;
        a();
    }

    private void nextLine(){
        if(0 < s.length()){
            s.append("\n");
        }
    }

    private void a(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
            String str;
            while ((str = in.readLine()) != null) {
                nextLine();
                s.append(UTF8BOMCleaner.a(str));
            }
            in.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get content of UTF8 file
     *
     * @return the content of that file
     *
     */
    public String b(){
        return s.toString();
    }

    /**
     * Get lines of UTF8 file
     *
     * @return list of lines of that file
     *
     */
    public List<String> c(){
        return new ArrayList<>(Arrays.asList(s.toString().replaceAll("\r\n", "\n").split("\n")));
    }
}
