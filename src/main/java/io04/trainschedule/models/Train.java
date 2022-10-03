package io04.trainschedule.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Train {
    private int id;
    private String name;
    private HashMap<Station, ArrayList<DataTime>> arrivalStations;


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

    public void setName(String name) {
        this.name = name;
    }

    public void setArrivalStations(HashMap<Station, ArrayList<DataTime>> arrivalStations) {
        this.arrivalStations = arrivalStations;
    }

    public HashMap<Station, ArrayList<DataTime>> getArrivalStations() {
        return arrivalStations;
    }
}
