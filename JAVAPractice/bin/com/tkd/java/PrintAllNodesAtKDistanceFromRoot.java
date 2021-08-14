package com.example.demo;

public class PrintAllNodesAtKDistanceFromRoot {
    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left11 = new Node(4);
        Node left12 = new Node(5);
        Node right11 = new Node(8);

        root.left = left1;
        root.right = right1;

        left1.left = left11;
        left1.right = left12;

        right1.left = right11;

        printKDistanceNodes(root, 2);
    }

    private static void printKDistanceNodes(Node node, int i) {
        if (node == null) {
            return;
        }

        if (i == 0) {
            System.out.println(node.data);
            return;
        } else {
            printKDistanceNodes(node.left, i - 1);
            printKDistanceNodes(node.right, i - 1);
        }

    }
}
