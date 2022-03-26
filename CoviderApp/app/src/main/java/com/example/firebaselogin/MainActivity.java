package com.example.firebaselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLogout, btnprof;
    private FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(this);

    public static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    public static CollectionReference mUsers = mFirestore.collection("users");
    public static DocumentReference mUserDocRef;
    public static User thisUser;
    public static int numUsers = 1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        btnLogout = findViewById(R.id.btnlogout);
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
    }

    @Override

    public void onStart(){

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
        else { //gets document snapshot of currentUser if someone is already logged in
            String emailTxt = mAuth.getCurrentUser().getEmail();
            mUserDocRef = mUsers.document(emailTxt);
            mUserDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Student student = documentSnapshot.toObject(Student.class);
                    thisUser = student;
                }
            });
        }
    }

    public void logout() {

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }

    public void fetchProf(){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        //maybe add onFailureListener
    }
}


