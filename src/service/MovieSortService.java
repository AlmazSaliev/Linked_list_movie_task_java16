package service;

public interface MovieSortService {
    void sortMovieByName(String ascOrDesc);

    void sortByYear(String ascOrDesc);

    void sortByProducer(String nameOrlastName);
}
