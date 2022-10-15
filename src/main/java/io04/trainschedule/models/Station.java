package io04.trainschedule.models;

import java.util.ArrayList;

public class Station {
    private int id;
    private final String name;

    private ArrayList<Train> trains;
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

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }
}
