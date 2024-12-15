package db;

import models.Actor;
import models.Movie;
import models.Producer;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    public static List<Movie> movies = new LinkedList<>();
    public static List<Producer> producers = new LinkedList<>();
    public static List<Actor> actors = new LinkedList<>();
}
