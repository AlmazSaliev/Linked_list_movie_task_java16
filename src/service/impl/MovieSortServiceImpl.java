package service.impl;

import dao.impl.GeneralDaoImpl;
import service.MovieSortService;

public class MovieSortServiceImpl implements MovieSortService {
    private final GeneralDaoImpl generalDao = new GeneralDaoImpl();

    @Override
    public void sortMovieByName(String ascOrDesc) {
        generalDao.sortMovieByName(ascOrDesc);
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        generalDao.sortByYear(ascOrDesc);
    }

    @Override
    public void sortByProducer(String nameOrlastName) {
        generalDao.sortByProducer(nameOrlastName);
    }
}
