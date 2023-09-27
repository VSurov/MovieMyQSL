package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public App() {
        System.out.println( "Hello user, you are included in the personal films program ");
    }

    public void startChoseUser() {
        System.out.println("1.If you want to see a list of films enter [1] \n 2.if you want to see a list of movies with rating enter [2] \n 3. Exit \t");



        while (true) {
            int scanner = new Scanner(System.in).nextInt();
            if (scanner == 1) {
                funcOutputList();
                break;
            } else if (scanner == 2) {
                funcOutputListRating();
                break;
            } else if (scanner == 3) {
                System.out.println("Thx for using");
                break;
            } else {
                System.out.println("Error repeat");
            }
        }

    }

    private void funcOutputListRating() {
        ConnectionToMySQL connectionToMySQL = new ConnectionToMySQL();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try {
            Statement statement = connectionToMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Movie movie = new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5));
                System.out.println(movie);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void funcOutputList() {
        ConnectionToMySQL connectionToMySQL = new ConnectionToMySQL();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try {
            Statement statement = connectionToMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Movie movie = new Movie(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                System.out.println(movie);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}