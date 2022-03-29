package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Days;
import com.example.firebaselogin.enums.InstructStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Class {
    private int ID;
    private String name;
    private Days[] days;
    private Instructor instructor;
    private List<Student> students;
    private Building building;
    private InstructStatus instructStatus;

    //constructors
    public Class(String name, Instructor instructor, Building building, InstructStatus instructStatus){
        this.name = name;
        this.instructor = instructor;
        this.building = building;
        this.instructStatus = instructStatus;

        students = new ArrayList<>();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public InstructStatus getInstructStatus() {
        return instructStatus;
    }

    public void setInstructStatus(InstructStatus instructStatus) {
        this.instructStatus = instructStatus;
    }
    public void addStudent(Student student){
        students.add(student);
    }


}
