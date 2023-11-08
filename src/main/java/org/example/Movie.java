package org.example;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;
    private int rating;
    private static final String template = "name: %s, genre: %s, year: %d, rating: %d";

    public Movie(String name, String genre, int year, int rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Movie(int id, String name, String genre, int year, int rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toFormattedString() {
        return String.format(template, name, genre, year, rating);
    }

}