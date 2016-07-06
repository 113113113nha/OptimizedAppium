package com.appium.test;

import libraries.utility.DataProviderSource;
import org.testng.annotations.Test;

/**
 * Created by User on 5/30/2016.
 */
public class TestDataSet {
    @Test(dataProvider = "excelData", dataProviderClass = DataProviderSource.class)
    public void testdata(String a, String b, String c, String d) {
        System.out.println(a + " | " + b + " | " + c + " | " + d);
    }
}
