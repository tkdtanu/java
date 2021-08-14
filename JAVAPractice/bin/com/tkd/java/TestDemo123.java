package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TestDemo123 {
    public static void main(String[] args) {
        //Integer[] input = new Integer[]{1, 3, 2, 5, 9, 7, 8, 2, 9};
        //Integer[] input = new Integer[]{1, 5, 2, 5, 9, 6, 7, 2, 4, 3, 6, 4, 1, 2, 5, 9};
        Integer[] input = new Integer[]{1, 1, 1, 3};
        if (input.length == 0) {
            System.out.println("Empty element");
            return;
        }
        findMaxSubArray(input);
    }

    public static void findMaxSubArray(Integer[] input) {
        List<Integer> result = new ArrayList<>();
        boolean isPositiveDifference = input[1] - input[0] > 0;

        for (int i = 0; i < input.length; i++) {
            List<Integer> tempResult = new ArrayList<>();
            tempResult.add(input[i]);

            int currentIndex = i;

            while (true) {
                int nextItemIndex;

                if (isPositiveDifference) {
                    nextItemIndex = findNextMaxElementIndex(currentIndex, input);

                } else {
                    nextItemIndex = findNextSmallestElementIndex(currentIndex, input);
                }
                
                if (nextItemIndex == -1) {
                    if (tempResult.size() > result.size()) {
                        result = tempResult;
                    }
                    break;
                }

                currentIndex = nextItemIndex;
                tempResult.add(input[nextItemIndex]);
                isPositiveDifference = !isPositiveDifference;
            }
        }

        System.out.println(result);

    }

    private static int findNextSmallestElementIndex(int currentIndex, Integer[] input) {
        int smallestNumber = Integer.MAX_VALUE;
        int resultIndex = -1;


        for (int i = currentIndex; i < input.length; i++) {
            if (input[i] < smallestNumber) {
                resultIndex = i;
                smallestNumber = input[i];
            }
            if (input[i] > smallestNumber) {
                break;
            }
        }

        if (resultIndex != -1 && resultIndex != currentIndex) {
            return resultIndex;
        } else {
            return -1;
        }
    }

    private static int findNextMaxElementIndex(int currentIndex, Integer[] input) {
        int maxNumber = Integer.MIN_VALUE;
        int resultIndex = -1;

        for (int i = currentIndex; i < input.length; i++) {
            if (input[i] > maxNumber) {
                resultIndex = i;
                maxNumber = input[i];
            }
            if (input[i] < maxNumber) {
                break;
            }
        }

        if (resultIndex != -1 && resultIndex != currentIndex) {
            return resultIndex;
        } else {
            return -1;
        }
    }
}
