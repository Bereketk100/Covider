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
    //class specific
    public String getLastName(){
        String words[] = new String[2];
        words = name.split(" ");

        return words[1];
    }
    public void changeInstructStatus(InstructStatus instructStatus){
        this.instructStatus = instructStatus;
    }
    public void checkClassHealth(){
        for (Class c : schedule.getSchedule()){
            
        }
    }

}
