package com.example.firebaselogin;

import static com.example.firebaselogin.MainActivity.thisUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {
    private Button btnHome, btnAddTest;
    private static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    private TextView mNameView, mEmailView, mUserView, mPassView, mStatusView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setViews();
        displayInfo();
        btnHome = findViewById(R.id.homePage);
        btnAddTest = findViewById(R.id.btnAddTest);


        btnAddTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v);
            }

        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                returnHome();
            }

        });
    }
    public void setViews(){
        mNameView = (TextView) findViewById(R.id.nameView);
        mEmailView = (TextView) findViewById(R.id.emailView);
        mUserView = (TextView) findViewById(R.id.userView);
        mPassView = (TextView) findViewById(R.id.passView);
        mStatusView = (TextView) findViewById(R.id.statusView);
    }

    public void displayInfo(){
        String nameText = thisUser.getName();
        mNameView.setText("Name: " + nameText);
        String emailText = thisUser.getEmail();
        mEmailView.setText("Email: " + emailText);
        String statText = thisUser.getStatus().toString();
        mStatusView.setText("Status: " + statText);
        String userText = thisUser.getUsername();
        mUserView.setText("Username: " + userText);
        String passText = thisUser.getPassword();
        mPassView.setText("Password: " + passText);
    }
    public void addTest(){

    }

    public void returnHome(){
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
    }

    public void onButtonShowPopupWindowClick(View v) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.test_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }


}