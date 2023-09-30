package org.example;

import java.sql.*;

public class RequestManager {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbmovie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DELETE = "DELETE FROM movie WHERE id=?";
    private static final String INSERT_NEW = "INSERT INTO movie VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE movie SET name=? WHERE id=?";

    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public void queryAdd(int id, String name, String genre, int year, int rating) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, genre);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, rating);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void queryUpdate(int id, String name){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void queryDelete(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}