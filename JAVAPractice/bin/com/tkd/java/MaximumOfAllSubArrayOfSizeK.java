package com.example.demo;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArrayOfSizeK {
    // Driver code
    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }

    static void printMax(int arr[], int n, int k) {

        Deque<Integer> queue = new LinkedList<>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k && i < arr.length; ++i) {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from queue
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                // Remove from rear
                queue.removeLast();
            }
            // Add new element at rear of queue
            queue.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[queue.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!queue.isEmpty()) && queue.peek() <=
                    i - k)
                queue.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!queue.isEmpty()) && arr[i] >=
                    arr[queue.peekLast()])
                queue.removeLast();

            // Add current element at the rear of queue
            queue.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[queue.peek()]);
    }
}
