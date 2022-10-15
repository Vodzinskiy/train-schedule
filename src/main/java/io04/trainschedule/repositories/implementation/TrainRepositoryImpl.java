package io04.trainschedule.repositories.implementation;

import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.TrainRepository;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class TrainRepositoryImpl implements TrainRepository {
    private final Map<Integer, Train> repository;

    public TrainRepositoryImpl() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Train train) {
        repository.put(train.getId(), train);
    }

    @Override
    public Train findById(int id) {
        return repository.get(id);
    }
}
