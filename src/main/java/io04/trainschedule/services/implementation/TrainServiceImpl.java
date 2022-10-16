package io04.trainschedule.services.implementation;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.repositories.TrainRepository;
import io04.trainschedule.services.TrainService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

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
        Train train = trainRepository.findById(id);
        for(Station station : train.getArrivalStations().keySet()){
            station.removeTrain(train);
        }
        trainRepository.delete(id);
    }

    @Override
    public void editTrain(int id, String newName, HashMap<Station, ArrayList<DataTime>> schedule){
        Train train = trainRepository.findById(id);
        for(Station station : train.getArrivalStations().keySet()){
            station.removeTrain(train);
        }
        train.setName(newName);
        train.setArrivalStations(schedule);
        train.addTrainToStations();

    }


    @Override
    public Train findById(int id) {
        return trainRepository.findById(id);
    }
}
