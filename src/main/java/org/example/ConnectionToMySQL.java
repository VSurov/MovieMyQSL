package org.example;

import java.sql.*;

public class ConnectionToMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbmovie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}