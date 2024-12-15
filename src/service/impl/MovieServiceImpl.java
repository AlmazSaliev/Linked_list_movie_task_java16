package service.impl;

import dao.impl.GeneralDaoImpl;
import enums.Genre;
import models.Movie;
import service.MovieService;

import java.time.LocalDate;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final GeneralDaoImpl generalDao = new GeneralDaoImpl();

    @Override
    public List<Movie> getAllMovies() {
        return generalDao.getAllMovies();
    }

    @Override
    public List<Movie> findMovieByFullNameOrPartName(String name) {
        return generalDao.findMovieByFullNameOrPartName(name);
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        return generalDao.findMovieByActorName(actorName);
    }

    @Override
    public List<Movie> findMovieByYear(LocalDate year) {
        return generalDao.findMovieByYear(year);
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        return generalDao.findMovieByProducer(producerFullName);
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        return generalDao.findMovieByGenre(genre);
    }

    @Override
    public List<Movie> findMovieByRole(String role) {
        return generalDao.findMovieByRole(role);
    }

    @Override
    public boolean addNewMovie(Movie movie) {
        return generalDao.addNewMovie(movie);
    }
}
