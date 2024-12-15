package config;

import models.Movie;

import java.util.List;

public class MainIterator {
    public static void MainIterator(List<Movie> movies, String label) {
        if (!movies.isEmpty()) {
            System.out.println(label);
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } else {
            System.out.println("Movies is empty!");
        }
    }
}
