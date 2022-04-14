package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.InstructStatus;
import com.example.firebaselogin.enums.Status;

import junit.framework.TestCase;

import java.util.ArrayList;

public class ClassTest extends TestCase {
    private Class c = new Class();

    public void testSetAndGetID() {
        c.setID(10);
        assertEquals("Testing setter/getter", 10, c.getID());
    }


    public void testSetAndGetInstructor() {
        Instructor instructor = new Instructor();
        instructor.setName("Dr. Chao");
        c.setInstructor(instructor);

        assertEquals("Testing setter/getter", instructor, c.getInstructor());

    }


    public void testSetAndGetStudents() {
        Student studentOne = new Student();
        studentOne.setName("Bk");

        Student studentTwo = new Student();
        studentOne.setName("Ethan");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(studentOne);
        studentList.add(studentTwo);

        c.setStudents(studentList);

        assertEquals("Testing setter/getter", studentList, c.getStudents());

    }


    public void testSetAndGetBuilding() {
        Building building = new Building();
        building.setName("BookStore");

        c.setBuilding(building);
        assertEquals("Testing setter/getter", building, c.getBuilding());

    }


    public void testSetAndGetInstructStatus() {
        Instructor instructor = new Instructor();
        instructor.setName("Dr. Chao");
        c.setInstructStatus(InstructStatus.Hybrid);

        assertEquals("Testing setter/getter", InstructStatus.Hybrid, c.getInstructStatus());
    }
}