package io04.trainschedule.models;

import java.util.*;

public class DataTime {
    private final int day, month, hour, minute;

    private final ArrayList<Integer> days = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));

    public DataTime(int day, int month, int hour, int minute) {
        this.day = day;
        this.month = month;
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

        res += temp;
        res += hour*60;
        res += minute;
        return res;
    }

    public static DataTime stringToDataTime(String data) {

        String[] temp =  data.split("[: .]");
        int[] dateTime = new int[4];
        for(int i = 0; i < temp.length; i++){
            dateTime[i] = Integer.parseInt(temp[i]);
        }
        return new DataTime(dateTime[2], dateTime[3], dateTime[0], dateTime[1]);
    }

    @Override
    public String toString() {
        return day+"."+month+" "+hour+":"+minute;
    }
    
}
