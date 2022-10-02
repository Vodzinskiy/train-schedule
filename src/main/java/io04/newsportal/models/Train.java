package io04.newsportal.models;

public class Train {
    private int id;
    private String name;
    private DataTime dataTime;
    private String sendingStation;
    private String from;
    private String to;

    public Train(int id, String name, DataTime dataTime, String sendingStation, String from, String to) {
        this.id = id;
        this.name = name;
        this.dataTime = dataTime;
        this.sendingStation = sendingStation;
        this.from = from;
        this.to = to;
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

    public DataTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(DataTime dataTime) {
        this.dataTime = dataTime;
    }

    public String getSendingStation() {
        return sendingStation;
    }

    public void setSendingStation(String sendingStation) {
        this.sendingStation = sendingStation;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
