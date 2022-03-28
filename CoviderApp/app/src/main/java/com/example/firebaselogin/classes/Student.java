package com.example.firebaselogin.classes;

import static android.content.ContentValues.TAG;
import static com.example.firebaselogin.MainActivity.mUsers;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.firebaselogin.classes.User;
import com.example.firebaselogin.enums.Role;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;

import java.util.ArrayList;

public class Student extends User {
    public Student() {
    }

    public Student(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
        role = Role.Student;
    }

        /*
    @Override

    public void userAddTest(Test test){

        CollectionReference mRecords = mUsers.collection("students").document(email).collection("testRecords");
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
    }*/
}
