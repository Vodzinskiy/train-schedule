package io04.trainschedule.services;

import io04.trainschedule.models.Train;

import java.util.Map;

public interface TrainService {
    void save(Train train);
    void delete(int id);
    Train findById(int id);
    Train findByName(String name);
    Map<Integer, Train> findAll();
}
