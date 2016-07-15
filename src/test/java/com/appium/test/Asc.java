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

        //MERGE

        int[] arr={22,21,19,18,15,14,9,7,5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

        // MERGE method
        public static void mergeSort(int[] inputArray) {
            int size = inputArray.length;
            if (size < 2) return;

            int mid = size / 2;
            int leftSize = mid;
            int rightSize = size - mid;

            int[] left = new int[leftSize];
            int[] right = new int[rightSize];

            for (int i = 0; i < mid; i++) {
                left[i] = inputArray[i];

            }
            for (int i = mid; i < size; i++) {
                right[i - mid] = inputArray[i];
            }
            mergeSort(left);
            mergeSort(right);

            merge(left, right, inputArray);
        }

        public static void merge(int[] left, int[] right, int[] arr) {
            int leftSize = left.length;
            int rightSize = right.length;
            int i = 0, j = 0, k = 0;

            while (i < leftSize && j < rightSize) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < leftSize) {
                arr[k++] = left[i++];
            }
            while (j < leftSize) {
                arr[k++] = right[j++];
            }
        }

}
