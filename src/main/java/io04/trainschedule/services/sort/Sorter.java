package io04.trainschedule.services.sort;

import io04.trainschedule.models.Train;

import java.util.ArrayList;

public interface Sorter {
    void sort(ArrayList<Train> trains);
}
