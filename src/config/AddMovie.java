package config;

import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class AddMovie {
    static String textPattern = "^[a-zA-Z\\s]+";
    static String numPattern = "\\d+";
    static String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(\\d{4})\\b";

    public static Movie addMovie(List<Producer> producers, List<Actor> actors) {
        Movie movie = new Movie();
//        private String name;
        String[] name = CheckValue.CheckValue("name of movie", textPattern);
        movie.setName(name[0]);
//        private LocalDate year;
        String date = CheckValue.CheckValue("date of movie (01.01.2024)", datePattern)[0];
        movie.setYear(LocalDate.of(Integer.parseInt(date.split("\\.")[2]), Integer.parseInt(date.split("\\.")[1]), Integer.parseInt(date.split("\\.")[0])));
//        private Genre genre;
        Genre genre = ChoiceGenre();
        movie.setGenre(genre);
//        private Producer producer;
        System.out.println("""
                Add producer to movie:
                1. Add have producer to movie
                2. Add new producer to movie
                3. Exit
                """);
        switch (CheckValue.CheckValue("number", numPattern)[0]) {
            case "1" -> {
                if (!producers.isEmpty()) {
                    Producer producer = addProducerToMovie(producers);
                    movie.setProducer(producer);
                } else {
                    System.out.println("Producers are empty!. For you need to add new producer!");
                    Producer producer = addNewProducer();
                    movie.setProducer(producer);
                }
            }
            case "2" -> {
                Producer producer = addNewProducer();
                movie.setProducer(producer);
            }
            case "3" -> {
                movie.setProducer(null);
            }
            default -> {
                CheckValue.InvalidValueMessage(5);
            }
        }
//        private List<Actor> actors;
        boolean isLoop = true;
        List<Actor> addActorList = new LinkedList<>();
        while (isLoop) {
            System.out.println("""
                    Add actors to movie:
                    1. Add have actors to movie
                    2. Add new actors to movie
                    3. Exit
                    """);
            switch (CheckValue.CheckValue("choice option by number", numPattern)[0]) {
                case "1" -> {
                    boolean isInLoop = true;
                    while (isInLoop) {
                        System.out.println("""
                                1. Add actors
                                2. Done
                                """);
                        switch (CheckValue.CheckValue("choice option by number", numPattern)[0]) {
                            case "1" -> {
                                if (!actors.isEmpty()) {
                                    Actor actor = addActorToMovie(actors);
                                    if (actor != null) {
                                        addActorList.add(actor);
                                        CheckValue.InvalidValueMessage(1);
                                    } else {
                                        CheckValue.InvalidValueMessage(2);
                                    }
                                } else {
                                    System.out.println("Actors is empty!, please add new actor and add to movie:");
                                    Actor actor = addNewActor();
                                    addActorList.add(actor);
                                    CheckValue.InvalidValueMessage(1);
                                }
                            }
                            case "2" -> {
                                movie.setActors(addActorList);
                                isInLoop = false;
                            }
                            default -> {
                                CheckValue.InvalidValueMessage(5);
                            }
                        }
                    }

                }
                case "2" -> {
                    boolean isInLoop = true;
                    while (isInLoop) {
                        System.out.println("""
                                1. Add new actor
                                2. Done
                                """);
                        switch (CheckValue.CheckValue("choice option by number", numPattern)[0]) {
                            case "1" -> {
                                Actor actor = addNewActor();
                                addActorList.add(actor);
                                CheckValue.InvalidValueMessage(1);
                            }
                            case "2" -> {
                                movie.setActors(addActorList);
                                isInLoop = false;
                            }
                            default -> {
                                CheckValue.InvalidValueMessage(5);
                            }
                        }
                    }

                }
                case "3" -> {
                    movie.setActors(addActorList);
                    isLoop = false;
                }
                default -> {
                    CheckValue.InvalidValueMessage(5);
                }
            }
        }
        return movie;
    }

    public static Genre ChoiceGenre() {
        System.out.println("Choice one genre by number: ");
        for (int i = 0; i < Genre.values().length; i++) {
            System.out.println((i + 1) + ". " + Genre.values()[i].toString().toLowerCase());
        }
        String[] genre = CheckValue.CheckValue("genre", numPattern);
        Genre findGenre = null;
        for (int i = 0; i < Genre.values().length; i++) {
            if (Integer.parseInt(genre[0]) == (i + 1)) {
                findGenre = Genre.values()[i];
            }
        }
        return findGenre;
    }

    public static Producer addProducerToMovie(List<Producer> producers) {
        System.out.println("Add producer to movie: ");
        for (int i = 0; i < producers.size(); i++) {
            System.out.println((i + 1) + ". " + producers.get(i).getFirstName() + " " + producers.get(i).getLastName());
        }
        String[] producerByNumbers = CheckValue.CheckValue("producer by number", numPattern);
        Producer findProducer = null;
        for (int i = 0; i < producers.size(); i++) {
            if (Integer.parseInt(producerByNumbers[0]) == (i - 1)) {
                findProducer = producers.get(i - 1);
            } else if (Integer.parseInt(producerByNumbers[0]) == producers.size()) {
                break;
            } else {
                CheckValue.InvalidValueMessage(5);
            }
        }
        return findProducer;
    }

    public static Producer addNewProducer() {
        System.out.println("Add new producer: ");
        Producer producer = new Producer();
        String[] firstName = CheckValue.CheckValue("first name", textPattern);
        String[] lastName = CheckValue.CheckValue("last name", textPattern);
        producer.setFirstName(firstName[0]);
        producer.setLastName(lastName[0]);
        return producer;
    }

    public static Actor addActorToMovie(List<Actor> actors) {
        Actor findActor = null;
        System.out.println("Add actor to movie: ");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + ". " + actors.get(i).getActorFullName());
        }
        String[] producerByNumbers = CheckValue.CheckValue("actor by number", numPattern);
        for (int i = 0; i < actors.size(); i++) {
            if (Integer.parseInt(producerByNumbers[0]) == (i - 1)) {
                findActor = actors.get(i - 1);
            } else if (Integer.parseInt(producerByNumbers[0]) == actors.size()) {
                break;
            } else {
                CheckValue.InvalidValueMessage(5);
            }
        }
        return findActor;
    }

    public static Actor addNewActor() {
        System.out.println("Add new actor: ");
        Actor actor = new Actor();
        String[] fullName = CheckValue.CheckValue("full name", textPattern);
        String[] role = CheckValue.CheckValue("role in movie", textPattern);
        actor.setActorFullName(fullName[0]);
        actor.setRole(role[0]);
        return actor;
    }
}
