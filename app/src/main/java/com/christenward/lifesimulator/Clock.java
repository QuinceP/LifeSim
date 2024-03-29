package com.christenward.lifesimulator;

/**
 * Created by Giraffer on 5/12/2016.
 */
public class Clock {
    int hours;
    int minutes;
    int days;
    int years;
    boolean birthday;

    public Clock(){
        this.hours = 0;
        this.minutes = 0;
        this.days = 1;
        this.birthday = false;
    }
    public void setClock(int hours, int minutes, int days){
        this.hours = hours;
        this.minutes = minutes;
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void incrementHours(){
        this.hours++;
        if (this.hours > 23){
            this.hours = 0;
            incrementDays();
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void incrementMinutes(){
        this.minutes++;
        if (this.minutes > 59){
            this.minutes = 0;
            incrementHours();
        }
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void incrementDays(){
        this.days++;
        if ((this.days % 2) == 0) {
            incrementYears();
            setBirthday(true);
        }
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void incrementYears(){
        this.years++;
    }

    public boolean isBirthday() {
        return birthday;
    }

    public void setBirthday(boolean birthday) {
        this.birthday = birthday;
    }
}
