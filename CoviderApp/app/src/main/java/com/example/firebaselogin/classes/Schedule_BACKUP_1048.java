package com.example.firebaselogin.classes;

import static android.content.ContentValues.TAG;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;
import static com.example.firebaselogin.activities.MainActivity.mUsers;
import static com.example.firebaselogin.activities.MainActivity.today;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.firebaselogin.enums.Days;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
//Ethan Zhang
=======
import java.util.TreeMap;

>>>>>>> schedulingbranch
public class Schedule {

    private List<Class> schedule;
    private TreeMap<Integer, Class> todaySchedule;
    public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    //constructors
    public Schedule(){
        schedule = new ArrayList<>();
        todaySchedule = new TreeMap<>();
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
        schedule.add(c);
        CollectionReference mSchedule = mUserDocRef.collection("schedule");
        mSchedule.document(c.getDpt() + " "+ c.getClassNum()).set(c).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("SCHEDULE", "Document has been saved!"); }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("SCHEDULE", "Document was not saved", e);
            }
        });
        getTodaySchedule();

        schedule.add(c);
<<<<<<< HEAD
    }
    public Class getClass(Class c){
        for (Class search: schedule){
            if (c == search){
                return search;
            }
        }
        return null;
=======


>>>>>>> schedulingbranch
    }
    public void getTodaySchedule(){
        int todayNum = today.get(Calendar.DAY_OF_WEEK);

        for (Class c : schedule){
            for (Days d: c.getDays()){
                //define thisDay after currentday obtained. Parse for hour/minute and sort
                if (getDayNum(d) == todayNum){
                    Log.d("DAY", c.getClassNum() + " added to today's schedule");
                    todaySchedule.put(c.getHour(), c);
                }
                //if (d == thisDay);
            }

        }
    }
    private int getDayNum(Days d){
        if (d == Days.Sunday)
            return 1;
        else if (d == Days.Monday)
            return 2;
        else if (d == Days.Tuesday)
            return 3;
        else if (d == Days.Wednesday)
            return 4;
        else if (d == Days.Thursday)
            return 5;
        else if (d == Days.Friday)
            return 6;
        else if (d == Days.Saturday)
            return 7;
        return 0;
    }






}
