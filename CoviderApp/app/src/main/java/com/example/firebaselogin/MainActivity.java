package com.example.firebaselogin;

import static com.example.firebaselogin.RegisterActivity.NAME_KEY;
import static com.example.firebaselogin.RegisterActivity.mDocRef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentSnapshot;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView mProfTextView;
    private Button btnLogout, btnprof;
    private FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(this);
    public static int numUsers = 1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProfTextView = (TextView) findViewById(R.id.profView);
        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnlogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                logout();

            }

        });
        btnprof = findViewById(R.id.btnprof);
        btnprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchProf();
            }
        });
    }

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

    }
    public void fetchProf(){
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String nameText = documentSnapshot.getString(NAME_KEY);
                    mProfTextView.setText("\"" + nameText + "\" -- " + nameText);
                }
            }
        });
        //maybe add onFailureListener
    }
}


