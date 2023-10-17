package org.example;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        MySQLRequestManager mySQLRequestManager = parser.parseGson();

        Application application = new Application(mySQLRequestManager);
        application.run();
    }
}