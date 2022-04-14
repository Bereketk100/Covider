package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Role;

public class Student extends User {
    public Student() {
    }

    public Student(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
        role = Role.Student;
    }

}
