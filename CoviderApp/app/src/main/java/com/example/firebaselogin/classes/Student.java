package com.example.firebaselogin.classes;

import com.example.firebaselogin.classes.User;

public class Student extends User {
    Student() {
    }

    public Student(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
    }
}
