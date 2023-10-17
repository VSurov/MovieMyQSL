package org.example;

import java.util.List;

public interface RequestManager {
    List<Movie> getAllMovies();
    List<Movie> getMoviesBySubstringInName(String substring);
    void addMovie(String name, String genre, int year, int rating);
    void updateName(int movieId, String newName);
    void removeMovie(int id);
}
