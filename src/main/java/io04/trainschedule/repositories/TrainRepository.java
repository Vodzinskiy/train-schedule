package io04.trainschedule.repositories;

import io04.trainschedule.models.Train;

public interface TrainRepository {
    void save(Train train);
    Train findById(int id);
}
