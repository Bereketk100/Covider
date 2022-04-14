package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Status;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class BuildingTest extends TestCase {
    private Building building = new Building(1, "SAL", 10.0, 20);


    public void testSetandGetLongitude() {
        building.setLongitude(30.5);
        assertEquals("Testing setter/getter", 30.5, building.getLongitude());
    }

    public void testGetLatitude() {
        building.setLatitude(100.5);
        assertEquals("Testing setter/getter", 100.5, building.getLatitude());

    }

    public void testTestSetAndGetName() {
        building.setName("BookStore");
        assertEquals("Testing setter/getter", "BookStore", building.getName());
    }

    public void testSetAndGetId() {
        building.setId(9);
        assertEquals("Testing setter/getter", 9, building.getId());
    }


    public void testSetAndGetRiskFactor() {
        building.setRiskFactor(10);
        assertEquals("Testing setter/getter", 10, building.getRiskFactor());
    }


    public void testSetAndGetPresentUsers() {
        List<User> presentUsers = new ArrayList<>();
        User studentOne = new Student();
        studentOne.setName("Bereket");

        User InstructorOne = new Instructor();
        InstructorOne.setName("Dr. Chao");

        presentUsers.add(studentOne);
        presentUsers.add(InstructorOne);
        building.setPresentUsers(presentUsers);

        assertEquals("Testing subclasses of abstract User class and present Users functionality", presentUsers, building.getPresentUsers());

    }

    public void testSetandGetUsersInPast3Days() {
        List<User> presentUsersInPast3Days = new ArrayList<>();

        User InstructorOne = new Instructor();
        InstructorOne.setName("Dr. Chao");

        User studentOne = new Student();
        studentOne.setName("Bereket");
        studentOne.setEmail("bereket@usc.edu");
        studentOne.setPassword("*******");
        studentOne.setStatus(Status.Healthy);


        User studentTwo = new Student();
        studentTwo.setName("Ethan");
        studentTwo.setEmail("ethan@usc.edu");
        studentTwo.setPassword("*******");
        studentTwo.setStatus(Status.Healthy);


        User studentThree = new Student();
        studentThree.setName("Penelope");
        studentThree.setEmail("penelope@usc.edu");
        studentOne.setPassword("*******");
        studentOne.setStatus(Status.Healthy);

        presentUsersInPast3Days.add(InstructorOne);
        presentUsersInPast3Days.add(studentOne);
        presentUsersInPast3Days.add(studentTwo);
        presentUsersInPast3Days.add(studentThree);

        building.setUsersInPast3Days(presentUsersInPast3Days);

        assertEquals("Testing subclasses of abstract User class and present Users in the past 3 days functionality", presentUsersInPast3Days, building.getUsersInPast3Days());

    }

    public void testCheckIn() {
        User newStudentOne = new Student();
        newStudentOne.setName("Bob");
        newStudentOne.setEmail("Bob@usc.edu");
        newStudentOne.setPassword("*******");
        newStudentOne.setStatus(Status.Infected);

        User newStudentTwo = new Student();
        newStudentTwo.setName("Steve");
        newStudentTwo.setEmail("Steve@usc.edu");
        newStudentTwo.setPassword("*******");
        newStudentTwo.setStatus(Status.Healthy);

        List<User> checkInQueue = new ArrayList<>();
        checkInQueue.add(newStudentOne);
        checkInQueue.add(newStudentTwo);

        List<User> presentUsers = new ArrayList<>();

        for (User user : checkInQueue) {
            if (user.getStatus() == Status.Healthy) {
                presentUsers.add(user);
            }
        }

        building.setPresentUsers(presentUsers);


        User checkedIn = new Student();
        for (User user : building.getPresentUsers()) {
            checkedIn = user;
        }

        // Steve is the only healthy user that requested to check in
        assertEquals("Testing check in functionality (only healthy users can check in)", "Steve", checkedIn.getName());

    }


}