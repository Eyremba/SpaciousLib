package org.anhcraft.spaciouslib.Utils;

import java.io.*;
import java.net.*;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public class URLUtils {

    /**
     * Read a file from internet
     *
     * @param u url
     *
     */
    public static BufferedReader get(String u) {
        URL url;

        try {
            url = new URL(u);
            URLConnection conn = url.openConnection();

            return new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream()
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Download a fie from internet
     *
     * @param fileurl url of the file
     * @param filepath file path
     * @param r runnable
     *
     */
    public static boolean download(String fileurl, String filepath, DownloadProgressRunnable r) throws IOException {
        if(new File(filepath).exists()) {
            throw new IOException();
        }
        try {
            URL url = new URL(fileurl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(filepath);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x;
            while ((x = in.read(data)) != -1) {
                downloadedFileSize += x;
                long currentProgress = ((downloadedFileSize * 100 / completeFileSize) / 102400) * -1;
                if(currentProgress <= 100) {
                    r.run(currentProgress);
                }
                bout.write(data, 0, x);
            }
            bout.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
