package com.example.demo;

import java.util.Stack;

public class InOrderTreeTraversalUsingStack {
    static class BinaryTree {
        Node root;

        void printInorder() {
            if (root == null) {
                System.out.println("Empty Tree");
            }

            Stack<Node> stack = new Stack<>();
            Node current = root;

            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printInorder();
    }
}
