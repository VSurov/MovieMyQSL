package org.example;

public class Main {
    public static void main(String[] args) {
        ConnectionSettings connectionSettings = new ConnectionSettings();
        ConnectionParse connectionParse = connectionSettings.parseConnectionSettings();

        MySQLRequestManager mySQLRequestManager = new MySQLRequestManager(connectionParse.getURL(),connectionParse.getUSERNAME(), connectionParse.getPASSWORD());

        Application application = new Application(mySQLRequestManager);
        application.run();
    }
}