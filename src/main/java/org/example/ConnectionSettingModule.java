package org.example;

public class ConnectionSettingModul {
    private String URL;
    private String USERNAME;
    private String PASSWORD;

    public ConnectionSettingModul(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
