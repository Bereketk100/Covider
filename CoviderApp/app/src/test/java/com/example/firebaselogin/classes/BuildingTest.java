package com.example.firebaselogin.classes;

import junit.framework.TestCase;

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


//    public void testGetPresentUsers() {
//    }
//
//    public void testSetPresentUsers() {
//    }
//
//    public void testGetUsersInPast3Days() {
//    }
//
//    public void testSetUsersInPast3Days() {
//    }
//
//    public void testCheckIn() {
//    }
//

}