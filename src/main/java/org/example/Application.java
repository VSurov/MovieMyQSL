package org.example;

import java.util.Scanner;

public class Application {
    private RequestManager requestManager;

    public Application(RequestManager requestManager) {
        this.requestManager = requestManager;

    }

    private final String OPEN_MOVIE_LIST = "1";
    private final String OPEN_MOVIE_LIST_DETAIL = "2";
    private final String SEARCH_FOR_NAME = "3";
    private final String ADD_MOVIE = "4";
    private final String UPDATE_MOVIE = "5";
    private final String REMOVE_MOVIE = "6";
    private final String EXIT = "7";

    public void run() {
        System.out.println("Hello user, you are included in the personal films program ");

        System.out.println("1.If you want to see a list of films, enter [1] \n2.If you want to see a detailed list of movies, enter [2] \n3.If you want to find a movie by title, enter [3]\n4.If you want add to you list movie, enter [4] \n5.If you want to change the movie name from the list, enter [5] \n6.If you want to remove a movie from the list, enter [6] \n7. Exit, enter [7] \t");

        label:
        while (true) {
            String scanner = new Scanner(System.in).nextLine();
            switch (scanner) {
                case OPEN_MOVIE_LIST:
                    outputListName();
                    break label;
                case OPEN_MOVIE_LIST_DETAIL:
                    outputListAll();
                    break label;
                case SEARCH_FOR_NAME:
                    searchForName();
                    break label;
                case ADD_MOVIE:
                    addFilm();
                    break label;
                case UPDATE_MOVIE:
                    updateFilm();
                    break label;
                case REMOVE_MOVIE:
                    removeFilm();
                    break label;
                case EXIT:
                    System.out.println("Thx for using");
                    break label;
                default:
                    System.out.println("Error repeat");
                    break;
            }
        }
    }

    private void outputListName() {
        System.out.println("Your list of film");

        requestManager.queryGetName();
    }

    private void outputListAll() {
        System.out.println("Your detail list of film");

        requestManager.queryAll();
    }

    private void searchForName() {
        System.out.println("Enter: Movie name what are you looking for");

        String searchingName = new Scanner(System.in).nextLine();

        requestManager.querySearchForName(searchingName);
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

        requestManager.queryUpdate(oldName, newName);

        outputListName();
    }

    private void removeFilm() {
        System.out.println("Enter to find the movie and remove it from the list ");

        String nameOfRemoveFilm = new Scanner(System.in).nextLine();

        requestManager.querySearchForName(nameOfRemoveFilm);

        System.out.println("Enter number of movie to remove it from the list ");

        String numberRemove = new Scanner(System.in).nextLine();

        requestManager.executeRemoveFlow(nameOfRemoveFilm, numberRemove);

        outputListName();
    }
}