package org.example;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;

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
                ", year: " + year + "}";
    }
}
