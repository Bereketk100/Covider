package com.example.firebaselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLogout;
    private FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(this);

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

            } }); }

    @Override

    public void onStart(){

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        { startActivity(new Intent(MainActivity.this, LoginActivity.class));

        } }

    public void logout() {

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }}

