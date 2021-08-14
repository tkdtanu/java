package com.example.demo;

public class ShiftAllZeroToRightSideWithSingleIteration {
    public static void main(String[] args) {
        //it doesn't matter, what is the sequence of other elements
        int[] arr = new int[]{1, 2, 3, 0, 0, 1, 4, 0, 5, 6, 6};
        int length = arr.length;
        int rightIndex = length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex) {
            if (arr[leftIndex] != 0) {
                leftIndex++;
                continue;
            }
            while (rightIndex > 0 && arr[rightIndex] == 0) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                int temp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = temp;
                rightIndex = rightIndex - 1;
            }
            leftIndex++;

        }
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);

        }
    }

    static void test() {
        int[] arr = new int[]{1, 2, 3, 0, 0, 1, 4, 0, 5, 6, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }
}
