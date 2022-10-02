package io04.newsportal.models;

public class DataTime {
    private int day;
    private int month;
    private int year;
    private String weekday;
    private int hour;
    private int minute;

    public DataTime(int day, int month, int year, String weekday, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    @Override
    public String toString() {
        return weekday+", "+day+"-"+month+"-"+year+" "+hour+":"+minute;
    }
}
