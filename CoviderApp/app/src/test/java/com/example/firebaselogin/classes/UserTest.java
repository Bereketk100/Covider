package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Role;
import com.example.firebaselogin.enums.Status;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

public class UserTest extends TestCase {
    User user = new Student();

    public void testSetandGetUserID() {
        user.setUserID(1);
        assertEquals("Testing setter/getter", 1, user.getUserID());
    }

    public void testSetAndGetEmail() {
        user.setEmail("bob@usc.edu");
        assertEquals("Testing setter/getter", "bob@usc.edu", user.getEmail());
    }

    public void testTestSetAndGetName() {
        user.setName("Bob");
        assertEquals("Testing setter/getter", "Bob", user.getName());
    }

    public void testSetAndGetUsername() {
        user.setUsername("Bob123");
        assertEquals("Testing setter/getter", "Bob123", user.getUsername());
    }

    public void testSetAndGetPassword() {
        user.setPassword("password");
        assertEquals("Testing setter/getter", "password", user.getPassword());

    }

    public void testSetAndGetStatus() {
        user.setStatus(Status.Healthy);
        assertEquals("Testing setter/getter and Enum", Status.Healthy, user.getStatus());
    }

    public void testSetAndGetRole() {
        user.setRole(Role.Student);
        assertEquals("Testing setter/getter and Enum", Role.Student, user.getRole());
    }

    public void testSetGetRegisterDate() {
        Date presentDay = new Date(2022, 04, 9);
        user.setRegisterDate(new Date(2022, 04, 9));
        assertEquals("Testing setter/getter and Built in Date class", presentDay, user.getRegisterDate());

    }

    public void testUserAddTest() {
        Test testOne = new Test(false, new Date(2022, 03, 9));
        Test testTwo = new Test(true, new Date(2022, 04, 9));

        ArrayList<Test> userExpectedTests = new ArrayList<>();

        userExpectedTests.add(testOne);
        userExpectedTests.add(testTwo);

        user.userAddTest(testOne);
        user.userAddTest(testTwo);

        ArrayList<Test> userActualTests = new ArrayList<>();

        for(Test test: user.testRecords) {
            userActualTests.add(test);
        }

        assertEquals("Testing adding tests for user", userExpectedTests, userActualTests);

    }
}