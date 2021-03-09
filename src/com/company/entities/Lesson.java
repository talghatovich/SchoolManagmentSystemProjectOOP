package com.company.entities;

public class Lesson {
    private boolean present;
    private int mark;
    private String date;

    public Lesson(){}

    public Lesson(boolean present, String date){
        this.present = present;
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
