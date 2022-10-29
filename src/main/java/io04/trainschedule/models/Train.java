package io04.trainschedule.models;


import java.util.*;

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

    public void addStation(Station station, DataTime arrTime, DataTime depTime){
        arrivalStations.put(station, new ArrayList<>(Arrays.asList(arrTime, depTime)));
    }

    public void removeStation(Station station) {
        arrivalStations.remove(station);
    }

    public HashMap<Station, ArrayList<DataTime>> getSortedStations(){
        HashMap<Station, ArrayList<DataTime>> trainStations = this.arrivalStations;
        List<Map.Entry<Station, ArrayList<DataTime>>> list = new LinkedList<>(trainStations.entrySet());

        // Sort the list
        list.sort(Comparator.comparingInt(o -> (o.getValue().get(0).getIntegerOfTime())));

        // put data from sorted list to hashmap
        HashMap<Station, ArrayList<DataTime>> temp = new LinkedHashMap<>();
        for (Map.Entry<Station, ArrayList<DataTime>> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    @Override
    public String toString() {
        return name;
    }
}
