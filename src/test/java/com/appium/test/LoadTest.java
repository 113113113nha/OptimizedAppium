package com.appium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by User on 5/30/2016.
 */
public class LoadTest {

    public static long startTime;
    static {
        startTime = System.currentTimeMillis();
    }
    @Test(invocationCount = 25, threadPoolSize = 25)
    public void testdata1() {

        System.out.println("hello");

//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.google.com");
//        System.out.println("Page Title is " + driver.getTitle());
//        Assert.assertEquals("Google", driver.getTitle());
//        driver.quit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @AfterTest
    public void tearDown(){
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
