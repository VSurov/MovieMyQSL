package org.example;
import java.sql.*;

public class ConnectionToMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbmovie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            if (!connection.isClosed()) {
                // System.out.println("We are connected!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("there is no connection... Exception!");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
