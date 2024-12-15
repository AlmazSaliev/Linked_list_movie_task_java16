package dao.impl;

import config.CheckValue;
import dao.GeneralDao;
import db.DataBase;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GeneralDaoImpl implements GeneralDao {
    @Override
    public List<Movie> getAllMovies() {
        return DataBase.movies;
    }

    @Override
    public List<Movie> findMovieByFullNameOrPartName(String name) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (movie.getName() != null) {
                if (movie.getName().contains(name)) {
                    findMovie.add(movie);
                }
            }
        }
        return findMovie;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (!movie.getActors().isEmpty()) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName() != null) {
                        if (actor.getActorFullName().contains(actorName)) {
                            findMovie.add(movie);
                        }
                    }
                }
            }
        }
        return findMovie;
    }

    @Override
    public List<Movie> findMovieByYear(LocalDate year) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (movie.getYear() != null) {
                if (movie.getYear().getYear() == year.getYear()) {
                    findMovie.add(movie);
                }
            }
        }
        return findMovie;
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (movie.getProducer() != null) {
                if ((movie.getProducer().getFirstName() + " " + movie.getProducer().getLastName()).contains(producerFullName)) {
                    findMovie.add(movie);
                }
            }
        }
        return findMovie;
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (movie.getGenre() != null) {
                if (movie.getGenre() == genre) {
                    findMovie.add(movie);
                }
            }
        }
        return findMovie;
    }

    @Override
    public List<Movie> findMovieByRole(String role) {
        List<Movie> findMovie = new LinkedList<>();
        for (Movie movie : DataBase.movies) {
            if (!movie.getActors().isEmpty()) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getRole() != null) {
                        if (actor.getRole().contains(role)) {
                            findMovie.add(movie);
                        }
                    }
                }
            }
        }
        return findMovie;
    }

    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("1")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } else if (ascOrDesc.equalsIgnoreCase("2")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        }
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("1")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getYear().compareTo(o1.getYear());
                }
            });
        } else if (ascOrDesc.equalsIgnoreCase("2")) {
            DataBase.movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getYear().compareTo(o2.getYear());
                }
            });
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        switch (nameOrLastName) {
            case "1" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o1.getProducer() == null) {
                            return -1;
                        }
                        if (o2.getProducer() == null) {
                            return 1;
                        }
                        return o1.getProducer().getFirstName().compareTo(o2.getProducer().getFirstName());
                    }
                });
            }
            case "2" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o2.getProducer() == null) {
                            return -1;
                        }
                        if (o1.getProducer() == null) {
                            return 1;
                        }
                        return o2.getProducer().getFirstName().compareTo(o1.getProducer().getFirstName());
                    }
                });
            }
            case "3" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o1.getProducer() == null) {
                            return -1;
                        }
                        if (o2.getProducer() == null) {
                            return 1;
                        }
                        return o1.getProducer().getLastName().compareTo(o2.getProducer().getLastName());
                    }
                });
            }
            case "4" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o2.getProducer() == null) {
                            return -1;
                        }
                        if (o1.getProducer() == null) {
                            return 1;
                        }
                        return o2.getProducer().getLastName().compareTo(o1.getProducer().getLastName());
                    }
                });
            }
            case "5" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o1.getProducer() == null) {
                            return -1;
                        }
                        if (o2.getProducer() == null) {
                            return 1;
                        }
                        return (o1.getProducer().getFirstName() + " " + o1.getProducer().getLastName()).compareTo((o2.getProducer().getFirstName() + " " + o2.getProducer().getLastName()));
                    }
                });
            }
            case "6" -> {
                DataBase.movies.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if (o1.getProducer() == null && o2.getProducer() == null) {
                            return 0;
                        }
                        if (o2.getProducer() == null) {
                            return -1;
                        }
                        if (o1.getProducer() == null) {
                            return 1;
                        }
                        return (o2.getProducer().getFirstName() + " " + o2.getProducer().getLastName()).compareTo((o1.getProducer().getFirstName() + " " + o1.getProducer().getLastName()));
                    }
                });
            }
            default -> {
                CheckValue.InvalidValueMessage(5);
            }
        }
    }

    @Override
    public boolean addNewMovie(Movie movie) {
        for (Producer producer : DataBase.producers) {
            if (!producer.getId().equals(movie.getId())) {
                DataBase.producers.add(movie.getProducer());
            }
        }
        for (Actor actor : movie.getActors()) {
            for (Actor actor1 : DataBase.actors) {
                if (!actor.getId().equals(actor1.getId())) {
                    DataBase.actors.add(actor);
                }
            }
        }
        return DataBase.movies.add(movie);
    }

    @Override
    public void addNewProducer(Producer producer) {
        boolean add = DataBase.producers.add(producer);
        if (add) {
            CheckValue.InvalidValueMessage(1);
        } else {
            CheckValue.InvalidValueMessage(2);
        }
    }

    @Override
    public List<Producer> getAllProducer() {
        return DataBase.producers;
    }

    @Override
    public Producer updateProducerById(Long id, Producer producer) {
        Producer oldProducer = null;
        for (int i = 0; i < DataBase.producers.size(); i++) {
            if (DataBase.producers.get(i).getId().equals(id)) {
                producer.setId(id);
                oldProducer = DataBase.producers.set(i, producer);
                break;
            }
        }
        return oldProducer;
    }

    @Override
    public boolean deleteProducer(Long id) {
        boolean isDelete = false;
        for (int i = 0; i < DataBase.producers.size(); i++) {
            if (DataBase.producers.get(i).getId().equals(id)) {
                if (DataBase.producers.remove(i) != null) {
                    isDelete = true;
                    break;
                }
            }
        }
        return isDelete;
    }

    @Override
    public void addNewActor(Actor actor) {
        boolean add = DataBase.actors.add(actor);
        if (add) {
            CheckValue.InvalidValueMessage(1);
        } else {
            CheckValue.InvalidValueMessage(2);
        }
    }

    @Override
    public List<Actor> getAllActor() {
        return DataBase.actors;
    }

    @Override
    public Actor updateActor(Long id, Actor actor) {
        Actor oldActor = null;
        for (int i = 0; i < DataBase.actors.size(); i++) {
            if (DataBase.actors.get(i).getId().equals(id)) {
                actor.setId(id);
                oldActor = DataBase.actors.set(i, actor);
                break;
            }
        }
        return oldActor;
    }

    @Override
    public boolean deleteActor(Long id) {
        boolean isDelete = false;
        for (int i = 0; i < DataBase.actors.size(); i++) {
            if (DataBase.actors.get(i).getId().equals(id)) {
                if (DataBase.actors.remove(i) != null) {
                    isDelete = true;
                    break;
                }
            }
        }
        return isDelete;
    }
}
