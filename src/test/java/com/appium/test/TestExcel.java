package com.appium.test;

import libraries.utility.ExcelUtils;

/**
 * Created by User on 5/30/2016.
 */
public class TestExcel {
    public static void main(String[] args) {

        // Test unit cell
        String path = System.getProperty("user.dir") + "/src/test/java/resources/Dataset.xlsx";
        String sheetname = "Dataset";
        ExcelUtils.openByPath(path);
        ExcelUtils.getSheet(sheetname);

        System.out.println(ExcelUtils.getCellValue(2,"name"));
        System.out.println(ExcelUtils.getCellValue(1,4));

        System.out.println("--------");
        // Test heap and garbage
        String path2 = System.getProperty("user.dir") + "/src/test/java/resources/Data.xlsx";
        ExcelUtils.openByPath(path2);

        Runtime.getRuntime().gc();
        long heapSize = ((Runtime.getRuntime().totalMemory()) / 1024) / 1024;
        long maxSize = ((Runtime.getRuntime().maxMemory()) / 1024) / 1024;
        long freeMemory = ((Runtime.getRuntime().freeMemory()) / 1024) / 1024;
        long usedMemory = heapSize - freeMemory;

        System.out.println("Max Size = " + maxSize + "m");
        System.out.println("Heap Size = " + heapSize + "m");
        System.out.println("Free Memory = " + freeMemory + "m");
        System.out.println("Used Memory = " + usedMemory + "m");

    }

}
