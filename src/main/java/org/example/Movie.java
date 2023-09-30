package org.example;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;
    private int rating;

    public Movie() {
    }

    public Movie(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Movie(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public Movie(int id, String name, String genre, int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id +
                " Name: " + name +
                ", genre: " + genre +
                ", year: " + year + ",rating: " + rating + "}";
    }

    public String toFormattedString(int a) {
        String template;
        if (a == 0) {
            template = "%d. %s";
        } else {
            template = "id: %d name: %s, genre: %s, year: %d, rating: %d";
        }
        return template;
    }
}