package io04.trainschedule.services.implementation;

import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.services.TrainFinderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainFinderServiceImpl implements TrainFinderService {

    @Override
    public List<Train> getSuitableTrain(Station stationOfDeparture, Station stationOfArrival) {
        List<Train> resultTrains = new ArrayList<>();
        for (Train train : stationOfDeparture.getTrains()){
            if (train.getArrivalStations().containsKey(stationOfArrival)){
                resultTrains.add(train);
            }
        }
        return resultTrains;
    }
}
