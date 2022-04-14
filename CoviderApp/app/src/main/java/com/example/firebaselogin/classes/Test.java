package com.example.firebaselogin.classes;

import java.util.Date;
//Ethan Zhang
public class Test {
    private Date date;
    private boolean result;
    //constructors
    public Test(){}

    public Test (boolean result_, Date date_){
        result = result_;
        date = date_;
    }
    //getters/setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
