package io04.trainschedule.repositories.implementation;

import io04.trainschedule.models.Station;
import io04.trainschedule.repositories.StationRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StationRepositoryImpl implements StationRepository {

    private final Map<Integer, Station> repository;

    public StationRepositoryImpl() {
        this.repository = new HashMap<>();
    }


    @Override
    public void save(Station station) {
        repository.put(station.getId(), station);
    }

    @Override
    public Station findByName(String name) {
        Collection<Station> stations = repository.values();
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name))
                return station;
        }
        return null;
    }
}
