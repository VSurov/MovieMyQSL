package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectionToMySQL connectionToMySQL = new ConnectionToMySQL();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try {
            Statement statement = connectionToMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Movie movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setName(resultSet.getString(2));
                movie.setGenre(resultSet.getString(3));
                movie.setYear(resultSet.getInt(4));
                System.out.println(movie);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
