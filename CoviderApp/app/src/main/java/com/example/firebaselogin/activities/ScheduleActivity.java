package com.example.firebaselogin.activities;

import static com.example.firebaselogin.activities.MainActivity.mFirestore;
import static com.example.firebaselogin.activities.MainActivity.thisUser;
import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.Class;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

public class ScheduleActivity extends AppCompatActivity {
    private Button btnHome, btnAddClass;
    private EditText classEditTxt, profEditTxt, sectionEditTxt, dptEditTxt;
    private String profName, dpt, classNum, section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        btnHome = findViewById(R.id.home);
        classEditTxt = findViewById(R.id.classTxt);
        profEditTxt = findViewById(R.id.profTxt);
        dptEditTxt = findViewById(R.id.dptTxt);

        profName = profEditTxt.getText().toString().trim();
        dpt = dptEditTxt.getText().toString().trim();
        try {
            classNum = classEditTxt.getText().toString().trim();
            section = sectionEditTxt.getText().toString().trim();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryClass();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });
    }
    public void queryClass(){
        DocumentReference classRef = mFirestore.collection("classes").document(dpt).collection(classNum)
                .document(profName).collection("sections").document(section);
        classRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Class c = documentSnapshot.toObject(Class.class);
                thisUser.getSchedule().addClass(c);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR", "Didn't add class successfully");
            }
        });
    }
    public void home(){startActivity(new Intent(ScheduleActivity.this, MainActivity.class));}

}