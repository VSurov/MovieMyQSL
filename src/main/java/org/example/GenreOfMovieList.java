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

    public String getGenre() {
        return genre;
    }
}