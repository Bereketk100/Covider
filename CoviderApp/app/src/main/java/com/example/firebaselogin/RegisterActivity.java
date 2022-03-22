package com.example.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    public static final String EMAIL_KEY = "email";
    public static final String NAME_KEY = "name";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";
    public static final String TAG = "User";
    //document instance to save to firestore
    public static DocumentReference mDocRef = FirebaseFirestore.getInstance().document("data/users");
    private FirebaseAuth mAuth;
    private EditText email, name, username, password;
    private Button btnRegister;
    private TextView textLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email);

        password = findViewById(R.id.register_password);
        name = findViewById(R.id.register_name);
        username = findViewById(R.id.register_username);

        btnRegister  = findViewById(R.id.register);
        textLogin = findViewById(R.id.text_login);

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
            Map<String, Object> dataToSave = new HashMap<String, Object>();
            dataToSave.put(EMAIL_KEY, emailTxt);
            dataToSave.put(NAME_KEY, nameTxt);
            dataToSave.put(USERNAME_KEY, usernameTxt);
            dataToSave.put(PASSWORD_KEY, passTxt);

            mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d(TAG, "Document has been saved!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG, "Document was not saved", e);
                }
            });
            
        }
    }
}