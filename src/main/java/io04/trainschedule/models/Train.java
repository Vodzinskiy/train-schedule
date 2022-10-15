package io04.trainschedule.models;


import java.util.ArrayList;
import java.util.HashMap;

public class Train {
    private int id;
    private final String name;
    private final HashMap<Station, ArrayList<DataTime>> arrivalStations;


    public Train(int id, String name, HashMap<Station, ArrayList<DataTime>> arrivalStations) {
        this.id = id;
        this.name = name;
        this.arrivalStations = arrivalStations;
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

    public HashMap<Station, ArrayList<DataTime>> getArrivalStations() {
        return arrivalStations;
    }

    public int getDepTime(Station station)  {
       return arrivalStations.get(station).get(1).getIntegerOfTime();
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", arrivalStations=" + arrivalStations +
                '}';
    }
}
