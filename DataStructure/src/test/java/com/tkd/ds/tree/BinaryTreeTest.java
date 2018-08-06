package com.tkd.ds.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	BinaryTree tree = new BinaryTree();

	@Before
	public void before() {
		/* Let us construct a Binary Tree
        4
       / \
      2   9
     / \   \
    3   5   7 
   / \   \   \
  10 12   1   6*/
	
		Node nodeTen = new Node(10, null, null);
		Node nodeTweleve = new Node(12, null, null);
		Node nodeOne = new Node(1, null, null);
		Node nodeSix = new Node(6, null, null);
		Node nodeThree = new Node(3, nodeTen, nodeTweleve);
		Node nodeFive = new Node(5, null, nodeOne);
		Node nodeSeven = new Node(7, null, nodeSix);
		Node nodeTwo = new Node(2, nodeThree, nodeFive);
		Node nodeNine = new Node(9, null, nodeSeven);
		Node rootNode = new Node(4, nodeTwo, nodeNine);
		tree.root = rootNode;
	}
	
	@Test
	public void testAverageOfLevels() {
		
		tree.averageOfLevels();
	}
	
	@Test
	public void testDiameterOfTree() {
		long diameter = tree.finDiameter();
		assertEquals(7L, diameter);
	}
	
	@Test
	public void testHeightOfTree() {
		long diameter = tree.findHeightOfTree();
		assertEquals(4L, diameter);
	}
	@Test
	public void printBoundary() {
		tree.printBoundary();
	}

}
