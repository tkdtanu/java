package com.example.demo;

// Java program to print largest contiguous array sum

class Kadane {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        if (size == 0) {
            return 0;
        }
        int max_current = a[0], max_global = a[0];

        for (int i = 1; i < size; i++) {
            max_current = Math.max(a[i], max_current + a[i]);

            if (max_current > max_global) {
                max_global = max_current;
            }

        }
        return max_global;
    }
}
