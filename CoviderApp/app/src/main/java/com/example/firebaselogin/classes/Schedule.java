package com.example.firebaselogin.classes;

import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;

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
    private Date currentTime;
    public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public Schedule(){
        schedule = new ArrayList<>();
    }
    public void addClass(Class c){
        schedule.add(c);
        //update database
        CollectionReference scheduleCollection = mUserDocRef.collection("schedule");
        /*

        scheduleCollection.document(c.getDpt()).collection(Integer.toString(c.getClassNum()))
                .document(c.getInstructor().getLastName()).collection("sections").document(Integer.toString(c.getSection()));*/
        scheduleCollection.document(c.getDpt()).set(c).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("SCHEDULE", "Added class");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("SCHEDULE", "Failed to add class");
            }
        });

    }



}
