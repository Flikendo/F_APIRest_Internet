/**
 * Date: 03-08-2022
 * Author: Flikendo
 *
 * Connection.Web class
 */
package com.flikendo.F_APIRest_Internet.Connection;

public class APIWeb {
    private String url;

    /**
     * Constructor of the class
     */
    public APIWeb(String url){
        this.url = url;
    }

    /**
     * Getter
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter
     * @param url web
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
