package io04.trainschedule.services.implementation;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;
import io04.trainschedule.services.TrainFinderService;
import io04.trainschedule.services.sort.SortByTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import io04.trainschedule.services.sort.Sorter;

@Service
public class TrainFinderServiceImpl implements TrainFinderService {

    @Override
    public ArrayList<Train> getSuitableTrain(Station stationOfDeparture, Station stationOfArrival, DataTime dataTime) {
        ArrayList<Train> resultTrains = new ArrayList<>();
        try {
            for (Train train : stationOfDeparture.getTrains()) {
                if (train.getArrivalStations().containsKey(stationOfArrival) && dataTime.getIntegerOfTime() <= train.getDepTime(stationOfDeparture) && train.getArrTime(stationOfArrival) > train.getDepTime(stationOfDeparture)) {
                    resultTrains.add(train);
                }
            }
            Sorter sorter = new SortByTime();

            return sorter.sort(resultTrains, stationOfDeparture);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
