package com.example.demo;

public class PrintAncesstorOfAGivenNodeInBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);
    }

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        Node root;

        boolean printAncestors(Node node, int target) {
            if (node == null) {
                return false;
            }
            if (target == node.data) {
                return true;
            }
            if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
                System.out.println(node.data);
                return true;
            }

            return false;
        }

    }
}
