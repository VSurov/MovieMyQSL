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

        label:
        while (true) {
            String scanner = new Scanner(System.in).nextLine();
            switch (scanner) {
                case "1":
                    outputListName();
                    break label;
                case "2":
                    outputListAll();
                    break label;
                case "3":
                    addFilm();
                    break label;
                case "4":
                    updateFilm();
                    break label;
                case "5":
                    removeFilm();
                    break label;
                case "6":
                    System.out.println("Thx for using");
                    break label;
                default:
                    System.out.println("Error repeat");
                    break;
            }
        }
    }

    private void addFilm() {
        System.out.println("Enter: Name of Film, What genre,Year of film release and rating in yor opinion\n");

        System.out.println("Enter Name Film");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter genre");
        String genre = new Scanner(System.in).nextLine();

        System.out.println("Enter Year");
        int year = new Scanner(System.in).nextInt();

        System.out.println("Enter rating");
        int rating = new Scanner(System.in).nextInt();

        RequestManager requestManager = new RequestManager();
        requestManager.queryAdd(name, genre, year, rating);

        outputListAll();
    }

    private void updateFilm() {
        outputListName();
        System.out.println("Enter the movie Name to change it from the list ");

        System.out.println("Enter old Name Film");
        String oldName = new Scanner(System.in).nextLine();

        System.out.println("Enter new Name Film");
        String newName = new Scanner(System.in).nextLine();

        RequestManager requestManager = new RequestManager();
        requestManager.queryUpdate(oldName, newName);

        outputListName();
    }

    private void removeFilm() {
        outputListName();

        System.out.println("Enter the movie name to remove it from the list ");

        String name = new Scanner(System.in).nextLine();

        RequestManager requestManager = new RequestManager();
        requestManager.queryDelete(name);

        outputListName();
    }

    private void outputListAll() {
        RequestManager requestManager = new RequestManager();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try (Statement statement = requestManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            int count = 1;

            while (resultSet.next()) {
                int id = resultSet.getInt(1);

                String name = resultSet.getString(2);

                String genre = resultSet.getString(3);

                int year = resultSet.getInt(4);

                int rating = resultSet.getInt(5);

                Movie movie = new Movie(id, name, genre, year, rating);
                System.out.println(count + ". " + movie.toFormattedString());
                count++;
            }
        } catch (SQLException e) {
        }
    }

    private void outputListName() {
        RequestManager requestManager = new RequestManager();

        String query = "select * from movie"; //запрос получить все поля в таблице movie

        try (Statement statement = requestManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            int count = 1;

            while (resultSet.next()) {
                String name = resultSet.getString(2);

                Movie movie = new Movie(name);
                System.out.println(count + ". " + movie.toFormattedStringName());
                count++;
            }
        } catch (SQLException e) {
        }
    }
}