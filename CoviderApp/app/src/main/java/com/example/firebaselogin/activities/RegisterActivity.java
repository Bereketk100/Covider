package com.example.firebaselogin.activities;

import static com.example.firebaselogin.activities.MainActivity.mUsers;
import static com.example.firebaselogin.activities.MainActivity.numUsers;
import static com.example.firebaselogin.activities.MainActivity.mFirestore;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.Instructor;
import com.example.firebaselogin.classes.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class RegisterActivity extends AppCompatActivity {
    public static final String EMAIL_KEY = "email";
    public static final String NAME_KEY = "name";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";
    public static final String TOKEN_KEY = "token";
    public static final String TAG = "User";
    //document instance to save to firestore
    private FirebaseAuth mAuth;
    private EditText email, name, username, password;
    private Button btnRegister, btnStudent, btnInstructor;
    private TextView textLogin;
    private boolean isInstruct = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        // HIDE PASSWORD
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //initviews
        name = findViewById(R.id.register_name);
        username = findViewById(R.id.register_username);
        //initbuttons
        btnRegister  = findViewById(R.id.register);
        btnStudent = findViewById(R.id.btnStudent);
        btnInstructor = findViewById(R.id.btnInstructor);

        textLogin = findViewById(R.id.text_login);
        numUsers++;
        //btn listeners
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStudent.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnStudent.setTextColor(getApplication().getResources().getColor(R.color.white));
                btnInstructor.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btnInstructor.setTextColor(getApplication().getResources().getColor(R.color.black));
                isInstruct = false;
                Log.d("PRESS", "Student button pressed!");
            }
        });
        btnInstructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnInstructor.setBackgroundColor(getResources().getColor(R.color.purple_500));
                btnInstructor.setTextColor(getApplication().getResources().getColor(R.color.white));
                btnStudent.setBackgroundColor(getResources().getColor(R.color.light_gray));
                btnStudent.setTextColor(getApplication().getResources().getColor(R.color.black));
                isInstruct = true;
                Log.d("PRESS", "Instructor button pressed!");
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void Register()
    {
        String emailTxt = email.getText().toString().trim();
        String nameTxt = name.getText().toString().trim();
        String usernameTxt = username.getText().toString().trim();
        String passTxt = password.getText().toString().trim();

        if(emailTxt.isEmpty())
            email.setError("Email can not be empty");
        if(nameTxt.isEmpty())
            name.setError("Name can not be empty");
        if(usernameTxt.isEmpty())
            username.setError("Username can not be empty");
        if(passTxt.isEmpty())
            password.setError("Password can not be empty");

        else
        {
            mAuth.createUserWithEmailAndPassword(emailTxt, passTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
            //add username, password, name to firestore user doc
            if (!isInstruct){
                Student student = new Student(numUsers, emailTxt, nameTxt, usernameTxt, passTxt);

                mUsers.document(emailTxt).set(student).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "Student Document has been saved!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Document was not saved", e);
                    }
                });
            }
            else {
                Instructor instructor = new Instructor(numUsers, emailTxt, nameTxt, usernameTxt, passTxt);
                mUsers.document(emailTxt).set(instructor).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "Instructor Document has been saved!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Document was not saved", e);
                    }
                });
            }

            mUserDocRef = mFirestore.document("users/" + emailTxt);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if(user != null){
                String uid = user.getUid();
                //subscribe them to topic under their user_id
                FirebaseMessaging.getInstance().subscribeToTopic(uid)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                String msg = "subscribed";
                                if (!task.isSuccessful()) {
                                    msg = "failed to subscribe";
                                }
                                Log.d(TAG, msg);
                                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }
    }
}