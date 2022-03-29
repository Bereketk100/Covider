package com.example.firebaselogin.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import static com.example.firebaselogin.activities.MainActivity.mFirestore;
import static com.example.firebaselogin.activities.MainActivity.mUserDocRef;
import static com.example.firebaselogin.activities.MainActivity.thisUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    private TextView textRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        //HIDE PASSWORD
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btnLogin  = findViewById(R.id.login);
        textRegister = findViewById(R.id.text_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }        });    }

    private void login()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(user.isEmpty())
        {            email.setError("Email can not be empty");        }
        if(pass.isEmpty())
        {            password.setError("Password can not be empty");        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        //sets mUserDocRef and thisUser upon successful login
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        FirebaseMessaging.getInstance().subscribeToTopic("users")
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@android.support.annotation.NonNull Task<Void> task) {
                                        String msg = "";
                                        if (!task.isSuccessful()) {
                                            msg = "";
                                        }
                                        Log.d(TAG, msg);
                                        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                    }
                                });
                        mUserDocRef = mFirestore.document("users/" + user);
                        mUserDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                Student student = documentSnapshot.toObject(Student.class);
                                thisUser = student;
                            }
                        });
                        startActivity(new Intent(LoginActivity.this , HealthFormActivity.class));
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });        }    } }
