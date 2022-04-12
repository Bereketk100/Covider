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
import android.widget.Toast;

import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.Building;
import com.example.firebaselogin.classes.Class;
import com.example.firebaselogin.classes.Instructor;
import com.example.firebaselogin.enums.InstructStatus;
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
        btnAddClass = findViewById(R.id.addClass);


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
        classEditTxt = findViewById(R.id.classTxt);
        profEditTxt = findViewById(R.id.profTxt);
        dptEditTxt = findViewById(R.id.dptTxt);
        sectionEditTxt = findViewById(R.id.sectionTxt);

        profName = profEditTxt.getText().toString().trim();
        dpt = dptEditTxt.getText().toString().trim();
        classNum = classEditTxt.getText().toString().trim();
        section = sectionEditTxt.getText().toString().trim();

        Log.d("CLASS", "dpt: " + dpt + "\n classNum: " + classNum + "\n profName: " + profName + "\n sectionNum: " + section);
        ///classes/CSCI/310/Wang/sections/1
        DocumentReference classRef = mFirestore.collection("classes").document(dpt).collection(classNum).document(profName).collection("sections").document(section);
        classRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //ideally would query database to get the instructor and building objects, this is dummy
                //objects for now
                Instructor instructor = new Instructor();
                Building b = new Building();
                Class c = new Class("CSCI",instructor, b, InstructStatus.Hybrid, 1);
                thisUser.getSchedule().addClass(c);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR", "Didn't add class successfully");
                Toast.makeText(ScheduleActivity.this, "Class doesn't exist!", Toast.LENGTH_LONG);
            }
        });
    }
    public void home(){startActivity(new Intent(ScheduleActivity.this, MainActivity.class));}

}