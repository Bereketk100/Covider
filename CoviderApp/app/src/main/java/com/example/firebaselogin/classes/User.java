package com.example.firebaselogin.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class User {
    private int userID;
    private String email, name, username, password;
    private Status status;
    private Date registerDate;
    private List<Test> testRecords;
    //constructors
    User (){
    }
    User (int userID_, String email_, String name_, String username_, String password_){
        userID = userID_;
        email = email_;
        name = name_;
        username = username_;
        password = password_;

        registerDate = new Date();
        status = Status.Healthy;
        testRecords = new ArrayList<>();
    }
    //getters/setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

}
