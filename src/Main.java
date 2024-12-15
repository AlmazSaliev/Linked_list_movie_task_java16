import config.AddMovie;
import config.CheckValue;
import config.MainIterator;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import service.impl.HelperServiceImpl;
import service.impl.MovieServiceImpl;
import service.impl.MovieSortServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static HelperServiceImpl helperService = new HelperServiceImpl();
    static MovieServiceImpl movieService = new MovieServiceImpl();
    static MovieSortServiceImpl movieSortService = new MovieSortServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1. Actor options
                    2. Producer options
                    3. Movie options
                    4. Exit
                    """);
            switch (CheckValue.CheckValue("number option", "\\d+")[0]) {
                case "1" -> {
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("""
                                1. Add new actor
                                2. Get all actors
                                3. Update actor by id
                                4. Delete actor by id
                                5. Exit
                                """);
                        switch (CheckValue.CheckValue("number option", "\\d+")[0]) {
                            case "1" -> {
                                helperService.addNewActor(AddMovie.addNewActor());
                            }
                            case "2" -> {
                                List<Actor> allActor = helperService.getAllActor();
                                if (!allActor.isEmpty()){
                                    System.out.println("All actors:");
                                    for (Actor actor : allActor) {
                                        System.out.println(actor);
                                    }
                                }else {
                                    System.out.println("Actors is empty!");
                                }
                            }
                            case "3" -> {
                                String id = CheckValue.CheckValue("actor id", "\\d+")[0];
                                Actor actor = helperService.updateActor(Long.parseLong(id), AddMovie.addNewActor());
                                if (actor != null){
                                    System.out.println("Successfully updated!");
                                }else {
                                    System.out.println("Error on updated!");
                                }
                            }
                            case "4" -> {
                                String id = CheckValue.CheckValue("actor id", "\\d+")[0];
                                boolean b = helperService.deleteActor(Long.parseLong(id));
                                if (b){
                                    CheckValue.InvalidValueMessage(3);
                                }else {
                                    CheckValue.InvalidValueMessage(4);
                                }
                            }
                            case "5" -> {
                                isLoop = false;
                            }
                            default -> {
                                CheckValue.InvalidValueMessage(5);
                            }
                        }
                    }

                }
                case "2" -> {
                    boolean isLoop = true;
                    while (isLoop) {
                        System.out.println("""
                                1. Add new producer
                                2. Get all producers
                                3. Update producer by id
                                4. Delete producer by id
                                5. Exit
                                """);
                        switch (CheckValue.CheckValue("number option", "\\d+")[0]) {
                            case "1" -> {
                                helperService.addNewProducer(AddMovie.addNewProducer());
                            }
                            case "2" -> {
                                List<Producer> allProducer = helperService.getAllProducer();
                                if (!allProducer.isEmpty()) {
                                    System.out.println("All producer:");
                                    for (Producer producer : allProducer) {
                                        System.out.println(producer);
                                    }
                                }else {
                                    System.out.println("Producers is empty!");
                                }
                            }
                            case "3" -> {
                                String id = CheckValue.CheckValue("id", "\\d+")[0];
                                Producer producer = helperService.updateProducerById(Long.parseLong(id), AddMovie.addNewProducer());
                                if (producer != null) {
                                    System.out.println("Successfully updated!");
                                }else {
                                    System.out.println("Error on updated!");
                                }
                            }
                            case "4" -> {
                                String id = CheckValue.CheckValue("id", "\\d+")[0];
                                boolean b = helperService.deleteProducer(Long.parseLong(id));
                                if (b){
                                    CheckValue.InvalidValueMessage(3);
                                }else {
                                    CheckValue.InvalidValueMessage(4);
                                }
                            }
                            case "5" -> {
                                isLoop = false;
                            }
                            default -> {
                                CheckValue.InvalidValueMessage(5);
                            }
                        }
                    }
                }
                case "3" -> {
                    boolean isBigLoop = true;
                    while (isBigLoop) {
                        System.out.println("""
                                1. Add new movie
                                2. Get all movies
                                3. Find movie by name
                                4. Find movies by actor name
                                5. Find movies by year
                                6. Find movies by producer name
                                7. Find movies by genre
                                8. Find movies by role
                                9. Sort movies by name(asc-desc)
                                10. Sort movies by year(old-new)
                                11. Sort movies by producer name(asc-desc)
                                12. Exit
                                """);
                        switch (CheckValue.CheckValue("option number", "\\d+")[0]) {
                            case "1" -> {
                                movieService.addNewMovie(AddMovie.addMovie(helperService.getAllProducer(), helperService.getAllActor()));
                            }
                            case "2" -> {
                                List<Movie> allMovies = movieService.getAllMovies();
                                MainIterator.MainIterator(allMovies, "All movies: ");
                            }
                            case "3" -> {
                                String movieName = CheckValue.CheckValue("movie name", "^[a-zA-Z\\s]+")[0];
                                List<Movie> movieByFullNameOrPartName = movieService.findMovieByFullNameOrPartName(movieName);
                                MainIterator.MainIterator(movieByFullNameOrPartName, "Find movies by name: ");
                            }
                            case "4" -> {
                                String actorName = CheckValue.CheckValue("actor name", "^[a-zA-Z\\s]+")[0];
                                List<Movie> movieByActorName = movieService.findMovieByActorName(actorName);
                                MainIterator.MainIterator(movieByActorName, "Find movies by actor name: ");
                            }
                            case "5" -> {
                                String date = CheckValue.CheckValue("year(2024)", "\\d+")[0];
                                List<Movie> findMoviesByYear = movieService.findMovieByYear(LocalDate.of(Integer.parseInt(date), 1,1));
                                MainIterator.MainIterator(findMoviesByYear, "Find movies by year: ");
                            }
                            case "6" -> {
                                String producerName = CheckValue.CheckValue("producer name", "^[a-zA-Z\\s]+")[0];
                                List<Movie> movieByProducer = movieService.findMovieByProducer(producerName);
                                MainIterator.MainIterator(movieByProducer, "Find movies by producer name: ");
                            }
                            case "7" -> {
                                Genre genre = AddMovie.ChoiceGenre();
                                List<Movie> movieByGenre = movieService.findMovieByGenre(genre);
                                MainIterator.MainIterator(movieByGenre, "Find movies by genre: ");
                            }
                            case "8" -> {
                                String role = CheckValue.CheckValue("role", "^[a-zA-Z\\s]+")[0];
                                List<Movie> movieByRole = movieService.findMovieByRole(role);
                                MainIterator.MainIterator(movieByRole, "Find movies by actor role: ");
                            }
                            case "9" -> {
                                boolean isLoop = true;
                                while (isLoop) {
                                    System.out.println("""
                                            1. Sort movies by name A-Z
                                            2. Sort movies by name Z-A
                                            3. Done or exit
                                            """);
                                    String sortOption = CheckValue.CheckValue("sort option", "\\d+")[0];
                                    movieSortService.sortMovieByName(sortOption);
                                    List<Movie> allMovies = movieService.getAllMovies();
                                    switch (sortOption){
                                        case "1"->{
                                            MainIterator.MainIterator(allMovies, "Sort movies by name A-Z");
                                        } case "2"->{
                                            MainIterator.MainIterator(allMovies, "Sort movies by name Z-A");
                                        }
                                        case "3"->{
                                            isLoop = false;
                                        }
                                        default -> {
                                            CheckValue.InvalidValueMessage(5);
                                        }
                                    }
                                }
                            }
                            case "10" -> {
                                boolean isLoop = true;
                                while (isLoop) {
                                    System.out.println("""
                                            1. Sort movies by new year
                                            2. Sort movies by old year
                                            3. Done or exit
                                            """);
                                    String sortOption = CheckValue.CheckValue("sort option", "\\d+")[0];
                                    movieSortService.sortByYear(sortOption);
                                    List<Movie> allMovies = movieService.getAllMovies();
                                    switch (sortOption) {
                                        case "1" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by new year");
                                        }
                                        case "2" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by old year");
                                        }
                                        case "3" -> {
                                            isLoop = false;
                                        }
                                        default -> {
                                            CheckValue.InvalidValueMessage(5);
                                        }
                                    }
                                }
                            }
                            case "11" -> {
                                boolean isLoop = true;
                                while (isLoop) {
                                    System.out.println("""
                                            1. Sort movies by producer first name A-Z
                                            2. Sort movies by producer first name Z-A
                                            3. Sort movies by producer last name A-Z
                                            4. Sort movies by producer last name Z-A
                                            5. Sort movies by producer full name A-Z
                                            6. Sort movies by producer full name Z-A
                                            7. Done or exit
                                            """);
                                    String sortOption = CheckValue.CheckValue("sort option", "\\d+")[0];
                                    movieSortService.sortByProducer(sortOption);
                                    List<Movie> allMovies = movieService.getAllMovies();
                                    switch (sortOption) {
                                        case "1" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer first name A-Z");
                                        }
                                        case "2" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer first name Z-A");
                                        }
                                        case "3" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer last name A-Z");
                                        }
                                        case "4" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer last name Z-A");
                                        }
                                        case "5" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer full name A-Z");
                                        }
                                        case "6" -> {
                                            MainIterator.MainIterator(allMovies, "Sort movies by producer full name Z-A");
                                        }
                                        case "7" -> {
                                            isLoop = false;
                                        }
                                        default -> {
                                            CheckValue.InvalidValueMessage(5);
                                        }
                                    }
                                }
                            }
                            case "12" -> {
                                isBigLoop = false;
                            }
                            default -> {
                                CheckValue.InvalidValueMessage(5);
                            }
                        }
                    }
                }
                case "4" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid value!");
                }
            }
        }
    }
}