package com.example.firebaselogin.activities;


import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.firebaselogin.activities.MainActivity.healthAnswered;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;
import static com.example.firebaselogin.activities.MainActivity.thisUser;

import com.example.firebaselogin.R;
import com.example.firebaselogin.enums.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class HealthFormActivity extends AppCompatActivity {
    // YES - > BUTTON
// NO - >  BUTTON
    boolean symptom1, symptom2, symptom3, symptom4, symptom5, symptom6, symptom7;
    boolean click1 = false, click2 = false, click3= false, click4= false,
            click5= false, click6= false, click7= false;
    //button vars
    private Button btn1Yes, btn1No, btn2Yes, btn2No, btn3Yes, btn3No, btn4Yes, btn4No,
            btn5Yes, btn5No, btn6Yes, btn6No, btn7Yes, btn7No;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_form);
        //initalize buttons
        initButtons();

        btn1Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn1Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn1No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn1No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom1 = true;
                click1 = true;
            }
        });
        btn1No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn1No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn1Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn1Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom1 = false;
                click1 = true;
            }
        });
        btn2Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn2Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn2No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn2No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom2 = true;
                click2 = true;
            }
        });
        btn2No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn2No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn2Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn2Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom2 = false;
                click2 = true;
            }
        });
        btn3Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn3Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn3No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn3No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom3 = true;
                click3 = true;
            }
        });
        btn3No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn3No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn3Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn3Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom3 = false;
                click3 = true;
            }
        });
        btn4Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn4Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn4No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn4No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom4 = true;
                click4 = true;
            }
        });
        btn4No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn4No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn4Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn4Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom4 = false;
                click4 = true;
            }
        });
        btn5Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn5Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn5No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn5No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom5 = true;
                click5 = true;
            }
        });
        btn5No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn5No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn5Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn5Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom5 = false;
                click5 = true;
            }
        });
        btn6Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn6Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn6No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn6No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom6 = true;
                click6 = true;
            }
        });
        btn6No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn6No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn6Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn6Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom6 = false;
                click6 = true;
            }
        });
        btn7Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7Yes.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn7Yes.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn7No.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn7No.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom7 = true;
                click7 = true;
            }
        });
        btn7No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7No.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn7No.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn7Yes.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn7Yes.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom7 = false;
                click7 = true;
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnHome();
            }
        });
    }
    public void initButtons(){
        btn1Yes = (Button)findViewById(R.id.btn1Yes);
        btn1No = (Button)findViewById(R.id.btn1No);
        btn2Yes= (Button)findViewById(R.id.btn2Yes);
        btn2No = (Button)findViewById(R.id.btn2No);
        btn3Yes = (Button)findViewById(R.id.btn3Yes);
        btn3No = (Button)findViewById(R.id.btn3No);
        btn4Yes = (Button)findViewById(R.id.btn4Yes);
        btn4No = (Button)findViewById(R.id.btn4No);
        btn5Yes = (Button)findViewById(R.id.btn5Yes);
        btn5No = (Button)findViewById(R.id.btn5No);
        btn6Yes = (Button)findViewById(R.id.btn6Yes);
        btn6No = (Button)findViewById(R.id.btn6No);
        btn7Yes = (Button)findViewById(R.id.btn7Yes);
        btn7No = (Button)findViewById(R.id.btn7No);
        btnNext = (Button)findViewById(R.id.btnNext);
    }
    public void returnHome(){
        //infected case
        if (symptom1 || symptom2 || symptom3 || symptom4 || symptom5 || symptom6 || symptom7){
            thisUser.setStatus(Status.Infected);
            mUserDocRef.update("status", Status.Infected).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "DocumentSnapshot successfully updated!");
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error updating document", e);
                        }
                    });
        }
        //healthy case
        else {
            thisUser.setStatus(Status.Healthy);
            mUserDocRef.update("status", Status.Healthy).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "DocumentSnapshot successfully updated!");
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error updating document", e);
                        }
                    });
        }
        //checks if all symptoms were answered
        if (click1 && click2 && click3 && click4 && click5 && click6 && click7){
            healthAnswered = true;
            startActivity(new Intent(HealthFormActivity.this, MainActivity.class));
        }
        else {
            Toast.makeText(HealthFormActivity.this, "You have not answered one/more symptom checks", Toast.LENGTH_SHORT).show();
        }

    }


}