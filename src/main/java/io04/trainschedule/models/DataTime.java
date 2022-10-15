package io04.trainschedule.models;

import java.util.*;

public class DataTime {
    private int day;

    private int month;

    private ArrayList<Integer> days = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));
//    private int year;
    private String weekday;
    private int hour;
    private int minute;

    public DataTime(int day, int month, String weekday, int hour, int minute) {
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

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
        int res = 0;
        int temp = day;
        for (int i = 0; i < month;i++) {
            temp += days.get(i);
        }
        temp *= 1440;

        res +=temp;
        res += hour*60;
        res += minute;

        return res;
    }

    @Override
    public String toString() {
        return weekday+", "+day+"-"+month+"-"+hour+":"+minute;
    }

}
