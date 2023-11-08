package org.example;

import com.google.gson.Gson;

import java.io.FileReader;

public class ConnectionSettings {
    public ConnectionParse parseConnectionSettings(){
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("PathConnection.json")) {
            return gson.fromJson(reader, ConnectionParse.class);
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }
}
