package com.example.firebaselogin;

import java.util.Date;

public class Student extends User {
    Student() {
    }

    Student (int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
    }
}
