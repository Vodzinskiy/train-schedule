package io04.trainschedule.services;

import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;

import java.util.List;

public interface TrainFinderService {
    List<Train> getSuitableTrain(Station stationOfDeparture, Station stationOfArrival);
}
