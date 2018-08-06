package com.tkd.ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class HuffmanEncodingDecoding {

	// A Tree node
	static class Node {
		char ch;
		int freq;
		Node left = null, right = null;

		Node(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
	};

	// traverse the Huffman Tree and store Huffman Codes
	// in a map.
	public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
		if (root == null)
			return;

		// found a leaf node
		if (root.left == null && root.right == null) {
			huffmanCode.put(root.ch, str);
		}

		encode(root.left, str + "0", huffmanCode);
		encode(root.right, str + "1", huffmanCode);
	}

	// traverse the Huffman Tree and decode the encoded string
	public static int decode(Node root, int index, StringBuilder sb) {
		if (root == null)
			return index;

		// found a leaf node
		if (root.left == null && root.right == null) {
			System.out.print(root.ch);
			return index;
		}

		index++;

		if (sb.charAt(index) == '0')
			index = decode(root.left, index, sb);
		else
			index = decode(root.right, index, sb);

		return index;
	}

	// Builds Huffman Tree and huffmanCode and decode given input text
	public static void buildHuffmanTree(String text) {
		// count frequency of appearance of each character
		// and store it in a map
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			if (!freq.containsKey(text.charAt(i))) {
				freq.put(text.charAt(i), 0);
			}
			freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
		}

		// Create a priority queue to store live nodes of Huffman tree
		// Notice that highest priority item has lowest frequency
		PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> l.freq - r.freq);

		// Create a leaf node for each character and add it
		// to the priority queue.
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			pq.add(new Node(entry.getKey(), entry.getValue()));
		}

		// do till there is more than one node in the queue
		while (pq.size() != 1) {
			// Remove the two nodes of highest priority
			// (lowest frequency) from the queue
			Node left = pq.poll();
			Node right = pq.poll();

			// Create a new internal node with these two nodes as children
			// and with frequency equal to the sum of the two nodes
			// frequencies. Add the new node to the priority queue.
			int sum = left.freq + right.freq;
			pq.add(new Node('\0', sum, left, right));
		}

		// root stores pointer to root of Huffman Tree
		Node root = pq.peek();

		// traverse the Huffman tree and store the Huffman codes in a map
		Map<Character, String> huffmanCode = new HashMap<>();
		encode(root, "", huffmanCode);

		// print the Huffman codes
		System.out.println("Huffman Codes are :\n");
		for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("\nOriginal string was :\n" + text);

		// print encoded string
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			sb.append(huffmanCode.get(text.charAt(i)));
		}

		System.out.println("\nEncoded string is :\n" + sb);

		// traverse the Huffman Tree again and this time
		// decode the encoded string
		int index = -1;
		System.out.println("\nDecoded string is: \n");
		while (index < sb.length() - 2) {
			index = decode(root, index, sb);
		}
	}

	public static void printHuffManEncoding() {
		Scanner sc = new Scanner(System.in);
		int noOfTestCase = sc.nextInt();
		sc.nextLine();
		while (noOfTestCase > 0) {
			String alphabets = sc.nextLine();

			int noOfString = alphabets.length();
			int frequencyArray[] = new int[noOfString];

			int j = noOfString;
			String frequencyString = sc.nextLine();
			
			String[] frequencyStringArray = frequencyString.split(" ");
			for (int i = 0; i < frequencyArray.length; i++) {
				frequencyArray[i] = Integer.parseInt(frequencyStringArray[i]);
			}
			char[] alphabetsArray = alphabets.toCharArray();
			PriorityQueue<Node> pc = new PriorityQueue<>((l, f) -> l.freq - f.freq);
			
			
			for (int i = 0; i < noOfString; i++) {
				pc.add(new Node(alphabetsArray[i], frequencyArray[i]));
			}
			while (pc.size() != 1) {

				Node leftNode = pc.poll();
				Node rightNode = pc.poll();

				int sum = leftNode.freq + (rightNode != null ? rightNode.freq : 0);

				pc.add(new Node('\0', sum, leftNode, rightNode));
			}

			Node root = pc.poll();
			Map<Character, String> huffmanCode = new HashMap<>();
			encode(root, "", huffmanCode);
			printHuffmanEncoingInPreOrder(root, huffmanCode);
			noOfTestCase--;
			if(noOfString != 0) {
				System.out.println();
			}
		}
		sc.close();
	}

	public static void printHuffmanEncoingInPreOrder(Node root,Map<Character, String> huffmanCode) {
		preOrder(root, huffmanCode);
	}

	private static void preOrder(Node node, Map<Character, String> huffmanCode) {
		if (node == null) {
			return;
		}
		
		if (node.left == null && node.right == null) {
			System.out.print(huffmanCode.get(node.ch) + " ");
			return;
		}
		
		preOrder(node.left, huffmanCode);
		preOrder(node.right, huffmanCode);
	}

	public static void main(String[] args) {
		String text = "Huffman coding is a data compression algorithm.";
		printHuffManEncoding();
		// buildHuffmanTree(text);
	}
}
