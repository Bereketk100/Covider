package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.InstructStatus;
import com.example.firebaselogin.enums.Role;

public class Instructor extends User{
    private InstructStatus instructStatus;

    //constructors
    public Instructor(){}

    public Instructor(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
        role = Role.Instructor;
    }

    public void changeInstructStatus(InstructStatus instructStatus){
        this.instructStatus = instructStatus;
    }

    public void checkClassHealth(){

    }

}
