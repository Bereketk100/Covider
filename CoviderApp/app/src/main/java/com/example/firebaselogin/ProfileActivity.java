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
    private Button btnHome, btnDisplay;
    private static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    private TextView mNameView, mEmailView, mUserView, mPassView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mNameView = (TextView) findViewById(R.id.nameView);
        btnHome = findViewById(R.id.homePage);
        btnDisplay = findViewById(R.id.displayInfo);
        String nameText = thisUser.getName();
        mNameView.setText("\"" + nameText + "\" -- " + nameText);
        /*
        mUserDocRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String nameText = document.getString(NAME_KEY);
                        mNameView.setText("\"" + nameText + "\" -- " + nameText);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/
        //displayInfo();
        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                returnHome();
            }

        });
        /*
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //displayInfo();
            }

        });*/
    }
    public void displayInfo(){
        mUserDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Student student = documentSnapshot.toObject(Student.class);
                String nameText = student.getName();
                mNameView.setText("\"" + nameText + "\" -- " + nameText);
            }
        });

    }

    public void returnHome(){
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
    }


}