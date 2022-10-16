package io04.trainschedule.services;

import io04.trainschedule.models.DataTime;
import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;

import java.util.ArrayList;
import java.util.HashMap;

public interface TrainService {
    void save(Train train);
    void delete(int id);
    Train findById(int id);
    void editTrain(int id, String name, HashMap<Station, ArrayList<DataTime>> schedule);
    Train findByName(String name);
}
