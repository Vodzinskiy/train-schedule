package io04.trainschedule.models;

import java.util.ArrayList;

public class Station {
    private int id;
    private final String name;

    private final ArrayList<Train> trains;
    public Station(int id, String name) {
        this.id = id;
        this.name = name;
        trains = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train train){
        trains.add(train);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }
}
