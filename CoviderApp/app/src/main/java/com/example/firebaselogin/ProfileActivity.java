package com.example.firebaselogin;

import static android.content.ContentValues.TAG;
import static com.example.firebaselogin.MainActivity.thisUser;
import static com.example.firebaselogin.RegisterActivity.NAME_KEY;
import static com.example.firebaselogin.MainActivity.mUsers;
import static com.example.firebaselogin.MainActivity.numUsers;
import static com.example.firebaselogin.MainActivity.mFirestore;
import static com.example.firebaselogin.MainActivity.mUserDocRef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {
    private Button btnHome, btnAddTest;
    private static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    private TextView mNameView, mEmailView, mUserView, mPassView, mStatusView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setViews();
        displayInfo();
        btnHome = findViewById(R.id.homePage);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                returnHome();
            }

        });
    }
    public void setViews(){
        mNameView = (TextView) findViewById(R.id.nameView);
        mEmailView = (TextView) findViewById(R.id.emailView);
        mUserView = (TextView) findViewById(R.id.userView);
        mPassView = (TextView) findViewById(R.id.passView);
        mStatusView = (TextView) findViewById(R.id.statusView);
    }

    public void displayInfo(){
        String nameText = thisUser.getName();
        mNameView.setText("Name: " + nameText);
        String emailText = thisUser.getEmail();
        mEmailView.setText("Email: " + emailText);
        String statText = thisUser.getStatus().toString();
        mStatusView.setText("Status: " + statText);
        String userText = thisUser.getUsername();
        mUserView.setText("Username: " + userText);
        String passText = thisUser.getPassword();
        mPassView.setText("Password: " + passText);
    }

    public void returnHome(){
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
    }


}