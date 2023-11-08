package org.example;

import com.google.gson.Gson;

import java.io.FileReader;

public class ConnectionSettings {
    public ConnectionSettingModule parseConnectionSettings(){
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("PathConnection.json")) {
            return gson.fromJson(reader, ConnectionSettingModule.class);
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
        return null;
    }
}
