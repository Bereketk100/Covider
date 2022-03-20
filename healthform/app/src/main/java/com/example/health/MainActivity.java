package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// USING SQLITE CREATE A DATABASE WITH A USER AND THEIR CURRENT HEALTH CONDITION
// YES - > BUTTON
// NO - >  BUTTON
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
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                secondButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                firstButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirdButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fourthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                thirdButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fifthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                sixthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                fifthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seventhButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                eighthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        eighthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eighthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                seventhButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ninthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                tenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        tenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                ninthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        twelfthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twelfthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                thirteenthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
        thirteenthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thirteenthButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
                twelfthButton.setBackgroundColor(getResources().getColor(R.color.light_gray));
            }
        });
    }
}