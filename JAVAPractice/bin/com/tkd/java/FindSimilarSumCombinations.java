package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class FindSimilarSumCombinations {
    static class Combination {
        int num1;
        int num2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5,0,7};

        List<Combination> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Combination c = new Combination();
                c.num1 = arr[i];
                c.num2 = arr[j];
                list.add(c);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Combination c = list.get(i);
            int sum = c.num1 + c.num2;
            for (int j = i + 1; j < list.size(); j++) {
                Combination c1 = list.get(j);
                int sum1 = c1.num1 + c1.num2;

                if (sum == sum1) {
                    System.out.println("(" + c.num1 + "," + c.num2 + "),(" + c1.num1 + "," + c1.num2 + ")");
                }
            }
        }
    }
}
