package com.example.firebaselogin.classes;

import junit.framework.TestCase;

import java.util.Date;

public class TestTest extends TestCase {
    private Test test = new Test(false, new Date(9, 11, 2022));

    public void testSetAndGetDate() {
        Date date = new Date(10, 17, 2022);
        test.setDate(date);

        assertEquals("Testing setter/getter", date, test.getDate());
    }

    public void testSetAndGetResult() {
        test.setResult(true);
        assertEquals("Testing setter/getter", true, test.isResult());

    }


}