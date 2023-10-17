package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRequestManager implements RequestManager {

    private String URL;
    private String USERNAME;
    private String PASSWORD;
    private static final String DELETE = "DELETE FROM movie WHERE id=?";
    private static final String INSERT_NEW = "INSERT INTO movie(name,genre,year,rating) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE movie SET name=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM movie";
    private static final String SEARCH_FOR_NAME = "SELECT * FROM movie WHERE name LIKE ?";

    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public MySQLRequestManager(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(GET_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                int rating = resultSet.getInt(5);

                Movie movie = new Movie(id, name, genre, year, rating);

                list.add(movie);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Movie> getMoviesBySubstringInName(String searchingName) {
        List<Movie> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(SEARCH_FOR_NAME);

            preparedStatement.setString(1, "%" + searchingName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                int rating = resultSet.getInt(5);

                Movie movie = new Movie(id, name, genre, year, rating);

                list.add(movie);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void addMovie(String name, String genre, int year, int rating) {
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

    public void updateName(int id, String newName) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(UPDATE);

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void removeMovie(int idFilm) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            preparedStatement = getConnection().prepareStatement(DELETE);

            preparedStatement.setInt(1, idFilm);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}