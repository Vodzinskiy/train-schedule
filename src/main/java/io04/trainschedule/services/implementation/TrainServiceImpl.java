package io04.trainschedule.services.implementation;

import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.TrainRepository;
import io04.trainschedule.services.TrainService;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }
    @Override
    public void save(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void delete(int id) {
        trainRepository.delete(id);
    }

    @Override
    public Train findById(int id) {
        return trainRepository.findById(id);
    }
}
