package io04.trainschedule.models;


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
        addTrainToStations();
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

    public HashMap<Station, ArrayList<DataTime>> getArrivalStations() {
        return arrivalStations;
    }

    public void setArrivalStations(HashMap<Station, ArrayList<DataTime>> arrivalStations) {
        this.arrivalStations = arrivalStations;
    }

    public int getDepTime(Station station) {
        return arrivalStations.get(station).get(1).getIntegerOfTime();
    }
    public int getArrTime(Station station) {
        return arrivalStations.get(station).get(0).getIntegerOfTime();
    }

    public void addTrainToStations() {
        for (Station station : arrivalStations.keySet()) {
            station.addTrain(this);
        }
    }


    @Override
    public String toString() {
        return "Потяг: " + name;
    }
}



 //        "відправка з станції " + station.toString() + " о " + arrivalStations.get(station).get(1).toString() + "\n"