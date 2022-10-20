package io04.trainschedule.repositories;

import io04.trainschedule.models.Train;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TrainRepository {
    void save(Train train);
    void delete(int id);
    Train findById(int id);
    Train findByName(String name);
    Map<Integer, Train> findAll();
}
