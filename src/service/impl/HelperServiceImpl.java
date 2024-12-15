package service.impl;

import dao.impl.GeneralDaoImpl;
import models.Actor;
import models.Producer;
import service.HelperService;

import java.util.List;

public class HelperServiceImpl implements HelperService {
    private final GeneralDaoImpl generalDao = new GeneralDaoImpl();
    @Override
    public void addNewProducer(Producer producer) {
        generalDao.addNewProducer(producer);
    }

    @Override
    public List<Producer> getAllProducer() {
        return generalDao.getAllProducer();
    }

    @Override
    public Producer updateProducerById(Long id, Producer producer) {
        return generalDao.updateProducerById(id, producer);
    }

    @Override
    public boolean deleteProducer(Long id) {
        return generalDao.deleteProducer(id);
    }

    @Override
    public void addNewActor(Actor actor) {
        generalDao.addNewActor(actor);
    }

    @Override
    public List<Actor> getAllActor() {
        return generalDao.getAllActor();
    }

    @Override
    public Actor updateActor(Long id, Actor actor) {
        return generalDao.updateActor(id, actor);
    }

    @Override
    public boolean deleteActor(Long id) {
        return generalDao.deleteActor(id);
    }
}
