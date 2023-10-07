package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestManager {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbmovie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DELETE = "DELETE FROM movie WHERE id=?";
    private static final String INSERT_NEW = "INSERT INTO movie(name,genre,year,rating) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE movie SET name=? WHERE name=?";
    private static final String GET_ALL = "SELECT * FROM movie";
    private static final String SEARCH_FOR_NAME = "SELECT * FROM movie WHERE name LIKE ?";

    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public void queryGetName() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(GET_ALL);

            int count = 1;

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");

                Movie movie = new Movie(name);

                System.out.println(count + ". " + movie.toFormattedStringName());
                count++;
            }
        } catch (SQLException e) {
        }

    }

    public void querySearchForName(String searchingName) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(SEARCH_FOR_NAME);

            int count = 1;

            preparedStatement.setString(1, "%" + searchingName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(2);

                Movie movie = new Movie(name);

                System.out.println(count + ". " + movie.toFormattedStringName());
                count++;
            }
        } catch (SQLException e) {
        }
    }

    public void queryAll() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(GET_ALL);

            int count = 1;

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                int rating = resultSet.getInt(5);

                Movie movie = new Movie(name, genre, year, rating);

                System.out.println(count + ". " + movie.toFormattedString());
                count++;
            }
        } catch (SQLException e) {
        }
    }

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

    public void executeRemoveFlow(String searchingName, String numberRemove) {
        ArrayList<Integer> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(SEARCH_FOR_NAME);

            int count = 1;

            preparedStatement.setString(1, "%" + searchingName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);

                list.add(id);

                String name = resultSet.getString(2);

                Movie movie = new Movie(name);

                System.out.println(count + ". " + movie.toFormattedStringName());
                count++;
            }
        } catch (SQLException e) {
        }

        int input = Integer.parseInt(numberRemove);
        int index = input - 1;
        int filmId = list.get(index);

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(DELETE);

            preparedStatement.setInt(1, filmId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}