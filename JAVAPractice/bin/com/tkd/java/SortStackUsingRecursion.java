package com.example.demo;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(22);
        stack.push(1);
        stack.push(5);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            Integer number = stack.pop();
            sortStack(stack);
            sortedInsert(number, stack);
        }
    }

    private static void sortedInsert(Integer number, Stack<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < number) {
            stack.push(number);
        } else {
            Integer currentTop = stack.pop();
            sortedInsert(number, stack);
            stack.push(currentTop);
        }
    }
}
