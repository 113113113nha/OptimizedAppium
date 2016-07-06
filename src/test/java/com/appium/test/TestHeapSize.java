package com.appium.test;

/**
 * Created by User on 5/30/2016.
 */
public class TestHeapSize {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int i = 0;
        String a = "Hello";
        while (i++ < 1000) {
            a += i;
        }
        // Collect garbage . Have gc will save memory
        Runtime.getRuntime().gc();
        // Calculate
        long heapSize = ((Runtime.getRuntime().totalMemory()) / 1024) / 1024;
        long maxSize = ((Runtime.getRuntime().maxMemory()) / 1024) / 1024;
        long freeMemory = ((Runtime.getRuntime().freeMemory()) / 1024) / 1024;
        long usedMemory = heapSize - freeMemory;

        System.out.println("Max Size = " + maxSize + "m");
        System.out.println("Heap Size = " + heapSize + "m");
        System.out.println("Free Memory = " + freeMemory + "m");
        System.out.println("Used Memory = " + usedMemory + "m");

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
