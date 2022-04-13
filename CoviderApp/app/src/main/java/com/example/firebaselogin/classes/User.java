package com.example.firebaselogin.classes;

import static android.content.ContentValues.TAG;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;
import static com.example.firebaselogin.activities.MainActivity.mUsers;
import static com.example.firebaselogin.activities.MainActivity.thisUser;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.firebaselogin.enums.Role;
import com.example.firebaselogin.enums.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class User {
    protected int userID;
    protected String email;
    protected String name;
    protected String username;
    protected String password;
    protected Role role;
    protected Status status;
    protected Date registerDate;
    public Schedule schedule;
    public List<Test> testRecords;
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
        schedule = new Schedule();
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    //methods
    public void userAddTest(Test test){
        //adding Firestore document to user subcollection testRecords
        CollectionReference mRecords = mUsers.document(email).collection("testRecords");
        mRecords.document(test.getDate().toString()).set(test).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Document has been saved!"); }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document was not saved", e);
            }
        });

        if (testRecords == null){
            testRecords = new ArrayList<>();
        }
        testRecords.add(test);
    }
    public void updateStatus(){
        mUserDocRef.update("status", status).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("UPDATE", "Updated user status");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("UPDATE", "Failed to update user status");
            }
        });
    }



}
