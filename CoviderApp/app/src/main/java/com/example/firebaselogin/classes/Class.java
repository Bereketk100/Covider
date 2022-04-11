package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Days;
import com.example.firebaselogin.enums.InstructStatus;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private int ID;
    private int section;

    private int classNum;

    private String dpt;
    private Days[] days;
    private Instructor instructor;
    private List<Student> students;
    private Building building;
    private InstructStatus instructStatus;

    //constructors
    public Class(String dpt, Instructor instructor, Building building, InstructStatus instructStatus, int section){
        this.dpt = dpt;
        this.instructor = instructor;
        this.building = building;
        this.instructStatus = instructStatus;
        this.section = section;

        students = new ArrayList<>();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
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
