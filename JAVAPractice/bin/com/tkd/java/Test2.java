package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Integer intArray[] = new Integer[]{1, 4, 5, 7, 9, 50, 34, 7};
        List<Integer> integerList = Arrays.asList(intArray);
        for (int i = 1; i <= 100; i++) {
            if (!integerList.contains(i)) {
                System.out.println(i);
            }

        }

    }

    private static void print(int previous, Integer integer) {
        for (int i = previous; i < integer; i++) {
            System.out.println(i);
        }
    }
}
