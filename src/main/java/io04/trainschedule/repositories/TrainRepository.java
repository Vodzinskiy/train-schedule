package io04.trainschedule.repositories;

import io04.trainschedule.models.Train;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository {
    void save(Train train);
    void delete(int id);
    Train findById(int id);
    Train findByName(String name);
}
