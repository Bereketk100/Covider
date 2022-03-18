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
    Button firstButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstButton = findViewById(R.id.button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstButton.setBackgroundColor(firstButton.getContext().getResources().getColor(R.color.purple_700));
            }
        });
    }
}