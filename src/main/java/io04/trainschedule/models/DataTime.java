package io04.trainschedule.models;

import java.util.HashMap;
import java.util.Map;

public class DataTime {
    private int day;

    private String month;
    private Map<String, Integer> daysOfMonths = new HashMap<>(){{
        put("January", 31);
        put("February", 28);
        put("March", 31);
        put("April", 30);
        put("May", 31);
        put("June", 30);
        put("July", 31);
        put("August", 31);
        put("September", 30);
        put("October", 31);
        put("November", 30);
        put("December", 31);
    }};
//    private int year;
    private String weekday;
    private int hour;
    private int minute;

    public DataTime(int day, String month, String weekday, int hour, int minute) {
        this.day = day;
        this.month = month;
//        this.year = year;
        this.weekday = weekday;
        this.hour = hour;
        this.minute = minute;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getIntegerOfTime(){
        return 0;
    }

    @Override
    public String toString() {
        return weekday+", "+day+"-"+month+"-"+hour+":"+minute;
    }
}
