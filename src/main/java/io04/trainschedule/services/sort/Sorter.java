package io04.trainschedule.services.sort;

import io04.trainschedule.models.Station;
import io04.trainschedule.models.Train;

import java.util.ArrayList;

public interface Sorter {
    ArrayList<Train> sort(ArrayList<Train> trains, Station station);
}
