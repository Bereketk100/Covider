package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.InstructStatus;

public class Instructor extends User{
    private InstructStatus instructStatus;

    public Instructor(){}
    public Instructor(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
    }
    public void changeInstructStatus(InstructStatus instructStatus){
        this.instructStatus = instructStatus;
    }
    //class specific
    public void checkClassHealth(){

    }

}
