package com.example.firebaselogin;

import static com.example.firebaselogin.MainActivity.thisUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.firebaselogin.classes.Test;
import com.google.firebase.firestore.FirebaseFirestore;
import static com.example.firebaselogin.MainActivity.thisUser;

import java.util.Date;

@SuppressWarnings("ALL")
public class ProfileActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText editTestDate;
    private ImageButton btnNo, btnYes, btnDone;




    private Button btnHome, btnAddTest;
    private static FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    private TextView mNameView, mEmailView, mUserView, mPassView, mStatusView;

    private Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setViews();
        displayInfo();
        //buttons
        btnHome = (Button) findViewById(R.id.homePage);
        btnAddTest = (Button) findViewById(R.id.btnAddTest);

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

    public void returnHome(){
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
    }

    public void onButtonShowPopupWindowClick(View v) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.test_popup, null);

        // create the popup window

        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1200, focusable);
        btnNo = (ImageButton) popupView.findViewById(R.id.btnNo);
        btnYes = (ImageButton) popupView.findViewById(R.id.btnYes);
        btnDone = (ImageButton) popupView.findViewById(R.id.btnDone);
        //editText
        editTestDate = (EditText) popupView.findViewById(R.id.enterDate);
        // show the popup window

        //functionality
        test = new Test();
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setResult(true);
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setResult(false);
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setDate(dateParser(getDate()));
                thisUser.userAddTest(test);
                popupWindow.dismiss();
            }
        });
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        // dismiss the popup window when touched
    }
    public String getDate(){
        return editTestDate.getText().toString().trim();
    }
    public Date dateParser(String str){
        String[] sections = new String[3];
        sections = str.trim().split("/");
        int month = Integer.parseInt(sections[0]) - 1, day = Integer.parseInt(sections[1]),
        year = Integer.parseInt(sections[2])- 1900;
        Date date = new Date(year, month, day);
        return date;
    }
//
//    public void createNewContactDialog(){
//        dialogBuilder = new AlertDialog.Builder(this);
//        final View popup = getLayoutInflater().inflate(R.layout.test_popup, null);
//        btnNo = (ImageButton) popup.findViewById(R.id.btnNo);
//        btnYes = (ImageButton) popup.findViewById(R.id.btnYes);
//        btnDone = (ImageButton) popup.findViewById(R.id.btnDone);
//        //editText
//        editTestDate = (EditText) popup.findViewById(R.id.enterDate);
//        // show the popup window
//        dialogBuilder.setView(popup);
//        dialog = dialogBuilder.create();
//        dialog.show();
//    }


}