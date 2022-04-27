package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Days;
import com.example.firebaselogin.enums.InstructStatus;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String dpt, classNum, profName, sectionNum;
    private int hour, minute;
    private List<Days> days;

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
