package com.example.demo;

public class CircularLinkedListInsertion {
    public static void main(String[] args) {
        Node head = createLinkedList();
        traverseLinkedList(head);
    }

    private static void traverseLinkedList(final Node head) {
        Node current = head;
        do {
            System.out.println(current.value);
            current = current.nextNode;
        } while (current != head);
    }

    private static Node createLinkedList() {
        Node head = new Node(2);
        Node node1 = new Node(6);
        Node node2 = new Node(8);
        Node node3 = new Node(9);
        Node node4 = new Node(10);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = head;
        return head;
    }
}

class Node {
    Integer value;
    Node nextNode;

    public Node(Integer value) {
        this.value = value;
    }
}