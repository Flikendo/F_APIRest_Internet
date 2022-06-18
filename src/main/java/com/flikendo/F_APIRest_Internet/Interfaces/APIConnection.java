/**
 * Date: 03-08-2022
 * Author: Flikendo
 *
 * APIConnection interfaces
 */
package com.flikendo.F_APIRest_Internet.Interfaces;

public interface APIConnection {
    boolean isWebUp();
    String getDataUrl();
    void writeLog(String log);
}
