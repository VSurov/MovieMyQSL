package org.example;

import java.util.Scanner;

public enum GenreOfMovieList {
    SPORT("Sport"),
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    FANTASY("Fantasy"),
    HISTORICAL("Historical"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    THRILLER("Thriller");

    String genre;

    GenreOfMovieList(String genre) {
        this.genre = genre;
    }
    public String genreChoice(String value){
        int number = Integer.parseInt(value);

        return switch (number) {
            case 1 -> SPORT.genre;
            case 2 -> ACTION.genre;
            case 3 -> ADVENTURE.genre;
            case 4 -> COMEDY.genre;
            case 5 -> FANTASY.genre;
            case 6 -> HISTORICAL.genre;
            case 7 -> HORROR.genre;
            case 8 -> ROMANCE.genre;
            case 9 -> THRILLER.genre;
            default -> null;
        };
    }
}