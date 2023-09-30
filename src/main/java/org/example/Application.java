package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {
    public Application() {
        System.out.println("Hello user, you are included in the personal films program ");
    }

    public void run() {
        System.out.println("1.If you want to see a list of films, enter [1] \n2.If you want to see a detailed list of movies, enter [2] \n3.If you want add to you list movie, enter [3] \n4.If you want to change the movie name from the list, enter [4] \n5.If you want to remove a movie from the list, enter [5] \n6. Exit, enter [6] \t");

        while (true) {
            String scanner = new Scanner(System.in).nextLine();
            if (scanner.equals("1")) {
                funcOutputList();
                break;
            } else if (scanner.equals("2")) {
                funcOutputListRating();
                break;
            } else if (scanner.equals("3")) {
                funcAddFilm();
                break;
            } else if (scanner.equals("4")) {
                funcUpdateFilm();
                break;
            } else if (scanner.equals("5")) {
                funcRemoveFilm();
                break;
            } else if (scanner.equals("6")) {
                System.out.println("Thx for using");
                break;
            } else {
                System.out.println("Error repeat");
            }
        }
    }

    private void funcAddFilm() {
        System.out.println("Enter: Number id, name of Film, What genre,Year of film release and rating in yor opinion\n");

        System.out.println("Enter number");
        int id = new Scanner(System.in).nextInt();

        System.out.println("Enter Name Film");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter genre");
        String genre = new Scanner(System.in).nextLine();

        System.out.println("Enter Year");
        int year = new Scanner(System.in).nextInt();

        System.out.println("Enter rating");
        int rating = new Scanner(System.in).nextInt();

        RequestManager requestManager = new RequestManager();
        requestManager.queryAdd(id, name, genre, year, rating);

        System.out.println("End now you detailed list of movies");
        funcOutputListRating();
    }

    private void funcUpdateFilm() {
        funcOutputList();
        System.out.println("Enter the movie number and Name to change it from the list ");

        System.out.println("Enter number");
        int id = new Scanner(System.in).nextInt();

        System.out.println("Enter new Name Film");
        String name = new Scanner(System.in).nextLine();

        RequestManager requestManager = new RequestManager();
        requestManager.queryUpdate(id, name);

        funcOutputList();
    }

    private void funcRemoveFilm() {
        funcOutputList();
        System.out.println(" ");

        System.out.println("Enter the movie number to remove it from the list ");

        int number = new Scanner(System.in).nextInt();

        RequestManager requestManager = new RequestManager();
        requestManager.queryDelete(number);

        funcOutputList();
    }

    private void funcOutputListRating() {
        RequestManager requestManager = new RequestManager();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try {
            Statement statement = requestManager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                int rating = resultSet.getInt(5);

                Movie movie = new Movie();
                System.out.println(String.format(movie.toFormattedString(1), id, name, genre, year, rating));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void funcOutputList() {
        RequestManager requestManager = new RequestManager();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try {
            Statement statement = requestManager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                Movie movie = new Movie();
                System.out.println(String.format(movie.toFormattedString(0), id, name));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}