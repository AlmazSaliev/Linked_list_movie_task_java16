package service;

import enums.Genre;
import models.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    List<Movie> findMovieByFullNameOrPartName(String name);

    List<Movie> findMovieByActorName(String actorName);

    List<Movie> findMovieByYear(LocalDate year);

    List<Movie> findMovieByProducer(String producerFullName);

    List<Movie> findMovieByGenre(Genre genre);

    List<Movie> findMovieByRole(String role);

    boolean addNewMovie(Movie movie);
}
