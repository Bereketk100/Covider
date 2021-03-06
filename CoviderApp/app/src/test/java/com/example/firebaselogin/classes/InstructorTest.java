package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.InstructStatus;
import com.example.firebaselogin.enums.Role;
import com.example.firebaselogin.enums.Status;

import junit.framework.TestCase;

public class InstructorTest extends TestCase {
    private Instructor instructor = new Instructor();
    public void testSetandGet(){
        instructor.setName("Chao Wang");
        instructor.setEmail("Wanger@email.com");
        instructor.setStatus(Status.Healthy);
        instructor.setRole(Role.Instructor);
        instructor.setUsername("ChaoWang");
        instructor.setPassword("yes");
        instructor.setUserID(2);

        assertEquals(instructor.getUserID(), 2);
        assertEquals(instructor.getPassword(), "yes");
        assertEquals(instructor.getUsername(), "ChaoWang");
        assertEquals(instructor.getName(), "Chao Wang");
        assertEquals(instructor.getEmail(), "Wanger@email.com");
        assertEquals(instructor.getStatus(), Status.Healthy);
        assertEquals(instructor.getRole(), Role.Instructor);
    }

    public void testChangeInstructStatus() {


        Building building = new Building(1, "SAL", 10.0, 20);
        Class c = new Class("CSCI", instructor, building, InstructStatus.Hybrid, 1);
        instructor.getSchedule().addClass(c);

        instructor.changeInstructStatus(InstructStatus.Remote);
        assertEquals(instructor.getSchedule().getClass(c).getInstructStatus(), InstructStatus.Remote);
    }

    public void testCheckClassHealth() {

    }
}