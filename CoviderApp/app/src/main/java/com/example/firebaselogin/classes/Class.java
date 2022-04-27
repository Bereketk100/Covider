package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Days;
import com.example.firebaselogin.enums.InstructStatus;

import java.util.ArrayList;
import java.util.List;

public class Class {


    private String dpt, classNum, profName, sectionNum;
    private int hour, minute;
    private List<Days> days;

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(String sectionNum) {
        this.sectionNum = sectionNum;
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

    public List<Days> getDays() {
        return days;
    }

    public void setDays(List<Days> days) {
        this.days = days;
    }
    //constructors
    public Class(){}
    public Class(String dpt, String classNum, String profName, String sectionNum, int hour, int minute,
        List<Days> days){
        this.dpt = dpt;
        this.classNum = classNum;
        this.profName = profName;
        this.sectionNum = sectionNum;
        this.hour = hour;
        this.minute = minute;
        this.days = days;
    }
    //methods


}
