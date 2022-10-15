package io04.trainschedule.models;

import java.util.*;

public class DataTime {
    private final int day, month, hour, minute;

    private final ArrayList<Integer> days = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));
    private final String weekday;

    public DataTime(int day, int month, String weekday, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.weekday = weekday;
        this.hour = hour;
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