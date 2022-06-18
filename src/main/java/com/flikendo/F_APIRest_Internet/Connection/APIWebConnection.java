/**
 * Date: 03-08-2022
 * Author: Flikendo
 *
 * APIWebConnection class
 */
package com.flikendo.F_APIRest_Internet.Connection;

import com.flikendo.F_APIRest_Internet.Interfaces.APIConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static com.flikendo.F_APIRest_Internet.Commons.APIConstants.*;

public class APIWebConnection implements APIConnection {
    private APIWeb web;

    public APIWebConnection(String url) {
        this.web = new APIWeb(url);
    }

    /**
     * Extract data from URL
     * @return String which contains the URL data
     */
    @Override
    public String getDataUrl() {
        try {
            URL url = new URL(web.getUrl());
            Scanner sc = new Scanner(url.openStream());
            StringBuilder sb = new StringBuilder();

            while (sc.hasNext()) {
                sb.append(sc.next());
            }

            String result = sb.toString();

            // This regular expresion [^>] means negation of >
            result = result.replaceAll("<[^>]*>", "");

            writeLog(CONTENT_URL + url);

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Overrides the method from the interface "Connection". Check if the web is up or down.
     *
     * @return true if the website is up, otherwise returns false.
     */
    @Override
    public boolean isWebUp() {
        HttpURLConnection connection = null;
        URL url;

        try {
            url = new URL(web.getUrl());
            connection = (HttpURLConnection) url.openConnection();

            int code = connection.getResponseCode();

            writeLog(String.valueOf(code));

            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return false;
    }

    /**
     * Writes logs in LOGFILENAME
     *
     * @param log what to write in the log file.
     */
    //TODO: Look over this method. Sum 1 up after .log.XX
    @Override
    public void writeLog(String log) {
        // Logger instance e.g. "Connection.ConnectionWeb"
        Logger logger = Logger.getLogger(APIWebConnection.class.getName());

        try {
            // File where log is written
            FileHandler fh = new FileHandler(LOGDIR + LOGFILENAME);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(log);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
