package com.appium.test;

import java.util.Arrays;

/**
 * Created by User on 7/11/2016.
 */
public class Asc {
    public static void main(String[] args) {
        int iArr[] = {5, 3, 9, 7, 1, 8};
        int temp;

        // DESC
        for (int j = 0; j < iArr.length - 1; j++) {
            for (int i = 0; i < iArr.length - 1 - j; i++) {
                if (iArr[i] < iArr[i + 1]) {
                    temp = iArr[i];
                    iArr[i] = iArr[i + 1];
                    iArr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(iArr));


        // ASC
        for (int j = 0; j < iArr.length - 1; j++) {
            for (int i = 0; i < iArr.length - 1 - j; i++) {
                if (iArr[i] > iArr[i + 1]) {
                    temp = iArr[i];
                    iArr[i] = iArr[i + 1];
                    iArr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(iArr));

    }
}
