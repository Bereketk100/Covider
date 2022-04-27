package com.example.firebaselogin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.Student;
import com.example.firebaselogin.classes.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLogout, btnprof, btnMap, btnSchedule;
    private FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(this);

    public static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    public static CollectionReference mUsers = mFirestore.collection("users");
    public static DocumentReference mUserDocRef;
    public static User thisUser;
    public static Calendar today = Calendar.getInstance();
    public static int numUsers = 1;
    public static boolean healthAnswered;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnlogout);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schedule();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                logout();
            }

        });
        btnprof = findViewById(R.id.btnprof);
        btnprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchProf();
            }
        });

        btnMap = findViewById(R.id.map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMap();
            }
        });
    }

    @Override

    public void onStart(){

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
        else if (!healthAnswered) { //gets document snapshot of currentUser if someone is already logged in
            String emailTxt = mAuth.getCurrentUser().getEmail();

            mUserDocRef = mUsers.document(emailTxt);
            mUserDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Student student = documentSnapshot.toObject(Student.class);
                    thisUser = student;
                }
            });
            startActivity(new Intent(MainActivity.this, HealthFormActivity.class));
        }
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void fetchProf(){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }

    public void schedule(){startActivity(new Intent(MainActivity.this, ScheduleActivity.class));}

    public void displayMap(){
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}