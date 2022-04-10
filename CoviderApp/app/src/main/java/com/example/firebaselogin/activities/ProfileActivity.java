package com.example.firebaselogin.activities;

import static com.example.firebaselogin.activities.MainActivity.thisUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.firebaselogin.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.firebaselogin.classes.MySingleton;
import com.example.firebaselogin.classes.Test;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import static com.example.firebaselogin.activities.MainActivity.thisUser;
import java.util.Date;

@SuppressWarnings("ALL")
public class ProfileActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText editTestDate;
    private ImageButton btnNo, btnYes, btnDone;
    final private String FCM_API = "https://fcm.googleapis.com/fcm/send";
    final private String serverKey = "key=" + "AAAA2w3OKU0:APA91bEEnzG1HM7xyCjW2RXfT1SSd_3zGqJSudwxmOBED8_BgNy_pUn0iCl7fDv0Fk7fvyF7GoWTg2CFgU6c10L9R8Yo04gD7zlXJcDNSrr9s9YXYxp1pCsDmVjVa0TdplWliZV-nI3c";
    final private String contentType = "application/json";
    final String TAG = "NOTIFICATION TAG";
    String NOTIFICATION_TITLE;
    String NOTIFICATION_MESSAGE;
    String TOPIC;
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

    private void sendNotification(JSONObject notification) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(FCM_API, notification,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse: " + response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ProfileActivity.this, "Request error", Toast.LENGTH_LONG).show();
                        Log.i(TAG, "onErrorResponse: Didn't work");
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", serverKey);
                params.put("Content-Type", contentType);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
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
                mStatusView.setText("Status: Infected");
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setResult(false);
                mStatusView.setText("Status: Healthy");
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setDate(dateParser(getDate()));
                sendToCloseContacts();
                thisUser.userAddTest(test);

                popupWindow.dismiss();
            }
        });
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        // dismiss the popup window when touched
    }
    private void sendToCloseContacts(){
        // get the buildings that this user checked int 3 days prior to positive test date
        // get the time that this user checked into each of these buildings
        // iterate through the users that checked into these buildings within 30 min of infected date/time
        // get the user_id of this "close contact"
        // set topic to
        // TOPIC = "/topics/user_id"
        //send notification to this user
        TOPIC = "/topics/";
        NOTIFICATION_TITLE = "NEW POSITIVE COVID CASE";
        NOTIFICATION_MESSAGE = thisUser.getName() + " tested positive for covid-19";
        JSONObject notification = new JSONObject();
        JSONObject notifcationBody = new JSONObject();
        try {
            notifcationBody.put("title", NOTIFICATION_TITLE);
            notifcationBody.put("message", NOTIFICATION_MESSAGE);

            notification.put("to", TOPIC);
            notification.put("data", notifcationBody);
        } catch (JSONException e) {
            Log.e(TAG, "onCreate: " + e.getMessage() );
        }
        sendNotification(notification);
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


}