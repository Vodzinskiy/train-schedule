package io04.trainschedule.services;

import io04.trainschedule.models.Station;

public interface StationService {
    void save(Station station);
    Station findByName(String name);
}
