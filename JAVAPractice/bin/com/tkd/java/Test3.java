package com.example.demo;

public class Test3 {
    public static void main(String[] args) {
        Integer intArray[] = new Integer[]{Integer.MAX_VALUE, 40, Integer.MAX_VALUE};
        if (intArray.length == 0) {
            System.out.println("Empty Array");
        }
        Integer maxNumber = intArray[0];
        Integer smallNumber = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < smallNumber) {
                smallNumber = intArray[i];
            }
            if (intArray[i] > maxNumber) {
                maxNumber = intArray[i];
            }
        }
        System.out.println("Max Number:" + maxNumber);
        System.out.println("Small Number:" + smallNumber);

    }
}
