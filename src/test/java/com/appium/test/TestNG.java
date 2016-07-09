package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by User on 5/30/2016.
 */
public class TestNG {
    @Test//(groups = "function")
    public void testCase1() {
        System.out.println("This is the Test Case 1");

        String a = "a";

        Assert.assertFalse(a.contentEquals("b"));
        System.out.println("Passed");
    }

    @Test//(groups = "non-function")
    public void testCase2() {
        System.out.println("This is the Test Case 2");
    }

    @Test//(groups = {"non-function", "function"})
    public void testCase3() {
        System.out.println("This is the Test Case 3");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This will execute before every Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This will execute after every Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This will execute beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This will execute afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This will execute beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This will execute afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute beforeTestSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute afterTestSuite");
    }
}
