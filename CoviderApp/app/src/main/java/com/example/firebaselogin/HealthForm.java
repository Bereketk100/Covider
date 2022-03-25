package com.example.firebaselogin;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HealthForm extends AppCompatActivity {
    // USING SQLITE CREATE A DATABASE WITH A USER AND THEIR CURRENT HEALTH CONDITION
// YES - > BUTTON
// NO - >  BUTTON
    boolean symptom1;
    boolean symptom2;
    boolean symptom3;
    boolean symptom4;
    boolean symptom5;
    boolean symptom6;
    boolean symptom7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button firstButton = findViewById(R.id.button1);
        final Button secondButton = findViewById(R.id.button2);
        final Button thirdButton = findViewById(R.id.button3);
        final Button fourthButton = findViewById(R.id.button4);
        final Button fifthButton = findViewById(R.id.button5);
        final Button sixthButton = findViewById(R.id.button6);
        final Button seventhButton = findViewById(R.id.button7);
        final Button eighthButton = findViewById(R.id.button8);
        final Button ninthButton = findViewById(R.id.button9);
        final Button tenthButton = findViewById(R.id.button10);
        final Button twelfthButton = findViewById(R.id.button12);
        final Button thirteenthButton = findViewById(R.id.button13);
        final Button fourteenthButton = findViewById(R.id.button14);
        final Button fifteenthButton = findViewById(R.id.button15);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                firstButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                secondButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                secondButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom1 = true;
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                secondButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                firstButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                firstButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom1 = false;
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                thirdButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                fourthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                fourthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom2 = true;
            }
        });
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fourthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                thirdButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                thirdButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom2 = false;
            }
        });
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fifthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fifthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                sixthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                sixthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom3 = true;
            }
        });
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                sixthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                fifthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                fifthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom3 = false;
            }
        });
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seventhButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                seventhButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                eighthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                eighthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom4 = true;
            }
        });
        eighthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eighthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                eighthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                seventhButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                seventhButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom4 = false;
            }
        });
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ninthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                ninthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                tenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                tenthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom5 = true;
            }
        });
        tenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                tenthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                ninthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                ninthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom5 = false;
            }
        });
        twelfthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twelfthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                twelfthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                thirteenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                thirteenthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom6 = true;
            }
        });
        thirteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirteenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                thirteenthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                twelfthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                twelfthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom6 = false;
            }
        });
        fourteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourteenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fourteenthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                fifteenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                fifteenthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom7 = true;
            }
        });
        fifteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fifteenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fifteenthButton.setTextColor(getApplication().getResources().getColor(R.color.white));
                fourteenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
                fourteenthButton.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom7 = false;
            }
        });
    }
}