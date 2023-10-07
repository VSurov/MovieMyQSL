package org.example;

import java.sql.*;

public class RequestManager {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbmovie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DELETE = "DELETE FROM movie WHERE name=?";
    private static final String INSERT_NEW = "INSERT INTO movie(name,genre,year,rating) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE movie SET name=? WHERE name=?";

    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public void queryAdd(String name, String genre, int year, int rating) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(INSERT_NEW);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, genre);
            preparedStatement.setInt(3, year);
            preparedStatement.setInt(4, rating);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void queryUpdate(String oldName, String newName) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(UPDATE);

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, oldName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void queryDelete(String name) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(DELETE);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}