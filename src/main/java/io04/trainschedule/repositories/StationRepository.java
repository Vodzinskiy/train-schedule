package io04.trainschedule.repositories;

import io04.trainschedule.models.Station;

public interface StationRepository {
    void save(Station station);
    Station findByName(String name);
    Station findById(int id);
    void delete(int id);
}
