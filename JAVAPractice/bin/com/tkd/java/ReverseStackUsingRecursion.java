package com.example.demo;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int number = stack.pop();
            reverseStack(stack);
            insert_at_bottom(number, stack);
        }
    }

    private static void insert_at_bottom(int number, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(number);
        } else {
            int currentTop = stack.pop();
            insert_at_bottom(number, stack);
            stack.push(currentTop);
        }
    }
}
