package com.example.firebaselogin.classes;

import static android.content.ContentValues.TAG;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;
import static com.example.firebaselogin.activities.MainActivity.mUsers;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {


    private List<Class> schedule;
    public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    //constructors
    public Schedule(){
        schedule = new ArrayList<>();
    }
    //getters and setters
    public List<Class> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Class> schedule) {
        this.schedule = schedule;
    }
    //class specific methods
    public boolean classExists(Class c){
        for (Class search: schedule){
            if (c == search){
                return true;
            }
        }
        return false;
    }
    public void addClass(Class c){
        //adding Firestore document to user subcollection testRecords
        CollectionReference mSchedule = mUserDocRef.collection("schedule");
        mSchedule.document("dummyClass").set(c).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Document has been saved!"); }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document was not saved", e);
            }
        });


        schedule.add(c);
    }
    public Class getClass(Class c){
        for (Class search: schedule){
            if (c == search){
                return search;
            }
        }
        return null;
    }





}
