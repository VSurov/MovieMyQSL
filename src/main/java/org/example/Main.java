package org.example;

public class Main {
    public static void main(String[] args) {
        ConnectionSettings connectionSettings = new ConnectionSettings();
        ConnectionSettingModule connectionSettingModule = connectionSettings.parseConnectionSettings();

        MySQLRequestManager mySQLRequestManager = new MySQLRequestManager(connectionSettingModule.getURL(), connectionSettingModule.getUSERNAME(), connectionSettingModule.getPASSWORD());

        Application application = new Application(mySQLRequestManager);
        application.run();
    }
}