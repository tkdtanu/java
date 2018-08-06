package com.tkd.ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	class Node {
		int value;
		Node leftNode;
		Node rightNode;

		public Node(int value, Node leftNode, Node rightNode) {
			super();
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

	}
	
	Node root;
	
	private long diameterOfTree;
	
	private long heightOfTree;
	
	private List<String> leafToLeafPath;

	public void averageOfLevels() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		int sum = 0;
		Queue<Node> tempQueue = new LinkedList<>();
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				Node tempNode = queue.peek();
				sum += queue.remove().value;
				count++;
				if (tempNode.leftNode != null) {
					tempQueue.add(tempNode.leftNode);
				}
				if (tempNode.rightNode != null) {
					tempQueue.add(tempNode.rightNode);
				}
			}
			queue = tempQueue;
			tempQueue = new LinkedList<>();
			System.out.println((double)sum / count);
			sum = 0;
			count = 0;
		}
	}
	public long finDiameter() {
		this.heightOfTree = findHeightOfTree(root);
		return this.diameterOfTree;
	}
	public long findHeightOfTree() {
		return this.findHeightOfTree(root);
	}
	private long findHeightOfTree(Node node) {
		if(node == null) {
			return 0;
		}
		long left_height = findHeightOfTree(node.leftNode);
		long right_height = findHeightOfTree(node.rightNode);
		 diameterOfTree = Math.max(diameterOfTree, 1L + left_height + right_height);
		return Math.max(left_height, right_height) + 1L;
	}
	public void printBoundary() {
		if(root != null) {
			System.out.println(root.value );
			
			//print left Boundary in top-down manner
			this.printLeftBoundary(root.leftNode);
			
			this.printLeaves(root.leftNode);
			this.printLeaves(root.rightNode);
			
			this.printRightBoundary(root.rightNode);
		}
		
	}
	private void printLeftBoundary(Node node) {
		if(node != null) {
			if(node.leftNode != null) {
				System.out.println(node.value);
				printLeftBoundary(node.leftNode);
			} else if(node.rightNode != null) {
				System.out.println(node.value);
				printLeftBoundary(node.rightNode);
			}
		}
		
	}
	
	private void printRightBoundary(Node node) {
		if(node != null) {
			if(node.rightNode != null) {
				printRightBoundary(node.rightNode);
				System.out.println(node.value);
			} else if(node.leftNode != null) {
				printRightBoundary(node.leftNode);
				System.out.println(node.value);
			}
		}
	}
	
	private void printLeaves(Node node) {
		
		if(node !=null) {
			printLeaves(node.leftNode);
			if(node.leftNode == null && node.rightNode == null) {
				System.out.println(node.value);
			}
			printLeaves(node.rightNode);
		}
		
	}
}


