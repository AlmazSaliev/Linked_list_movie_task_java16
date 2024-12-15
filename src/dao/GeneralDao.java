package dao;

import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.List;

public interface GeneralDao {
    List<Movie> getAllMovies();

    List<Movie> findMovieByFullNameOrPartName(String name);

    List<Movie> findMovieByActorName(String actorName);

    List<Movie> findMovieByYear(LocalDate year);

    List<Movie> findMovieByProducer(String producerFullName);

    List<Movie> findMovieByGenre(Genre genre);

    List<Movie> findMovieByRole(String role);

    void sortMovieByName(String ascOrDesc);

    void sortByYear(String ascOrDesc);

    void sortByProducer(String nameOrlastName);

    boolean addNewMovie(Movie movie);

    void addNewProducer(Producer producer);

    List<Producer> getAllProducer();

    Producer updateProducerById(Long id, Producer producer);

    boolean deleteProducer(Long id);

    void addNewActor(Actor actor);

    List<Actor> getAllActor();

    Actor updateActor(Long id, Actor actor);

    boolean deleteActor(Long id);
}
