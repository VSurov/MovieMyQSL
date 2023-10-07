package org.example;

public class Main {
    public static void main(String[] args) {
        RequestManager requestManager = new RequestManager();
        Application application = new Application(requestManager);
        application.run();
    }
}