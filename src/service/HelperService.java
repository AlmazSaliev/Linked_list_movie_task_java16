package service;

import models.Actor;
import models.Producer;

import java.util.List;

public interface HelperService {
    void addNewProducer(Producer producer);
    List<Producer> getAllProducer();
    Producer updateProducerById(Long id, Producer producer);
    boolean deleteProducer(Long id);

    void addNewActor(Actor actor);
    List<Actor> getAllActor();
    Actor updateActor(Long id, Actor actor);
    boolean deleteActor(Long id);
}
