package io04.trainschedule.services;

import io04.trainschedule.models.Train;

public interface TrainService {
    void save(Train train);
    void delete(int id);
    Train findById(int id);
}
