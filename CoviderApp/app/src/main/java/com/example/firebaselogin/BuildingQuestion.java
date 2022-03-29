package com.example.firebaselogin;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BuildingQuestion extends AppCompatActivity {
    boolean symptom11, symptom22, symptom33;
    boolean click11 = false, click22 = false, click33= false;
    //button vars
    private Button btn1Yes1, btn1No1, btn2Yes1, btn2No1, btn3Yes1, btn3No1;
    private Button back, donee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_question);
        //initalize buttons
        initButtons();

        btn1Yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1Yes1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn1Yes1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn1No1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn1No1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom11 = true;
                click11 = true;
            }
        });
        btn1No1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1No1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn1No1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn1Yes1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn1Yes1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom11 = false;
                click11 = true;
            }
        });
        btn2Yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2Yes1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn2Yes1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn2No1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn2No1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom22 = true;
                click22 = true;
            }
        });
        btn2No1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2No1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn2No1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn2Yes1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn2Yes1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom22 = false;
                click22 = true;
            }
        });
        btn3Yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3Yes1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn3Yes1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn3No1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn3No1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom33 = true;
                click33 = true;
            }
        });
        btn3No1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3No1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btn3No1.setTextColor(getApplication().getResources().getColor(R.color.white));
                btn3Yes1.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btn3Yes1.setTextColor(getApplication().getResources().getColor(R.color.black));
                symptom33 = false;
                click33 = true;
            }
        });

        donee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnHome();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnBack();
            }
        });
    }
    public void initButtons(){
        btn1Yes1 = (Button)findViewById(R.id.btn1Yes1);
        btn1No1 = (Button)findViewById(R.id.btn1No1);
        btn2Yes1= (Button)findViewById(R.id.btn2Yes1);
        btn2No1 = (Button)findViewById(R.id.btn2No1);
        btn3Yes1 = (Button)findViewById(R.id.btn3Yes1);
        btn3No1 = (Button)findViewById(R.id.btn3No1);
        donee = (Button)findViewById(R.id.done);
        back = (Button)findViewById(R.id.back);

    }
    public void returnHome(){

        if (symptom11 == false || symptom22 == true || symptom33 == true) {
            Toast.makeText(BuildingQuestion.this, "SORRY, NOT ALLOWED IN THIS BUILDING!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(BuildingQuestion.this, MainActivity.class));

        }

        //checks if all symptoms were answered
        if (click11 && click22 && click33 ){
            Toast.makeText(BuildingQuestion.this, "WELCOME!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(BuildingQuestion.this, MapsActivity.class));
        }
        else {
            Toast.makeText(BuildingQuestion.this, "You have not answered one/more symptom checks", Toast.LENGTH_SHORT).show();
        }

    }

    public void returnBack(){
        startActivity(new Intent(BuildingQuestion.this, MapsActivity.class));

    }


}