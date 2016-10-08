package binaryTree;

import binaryTree.GetWidthTree.Node;

public class PrintKDistanceTree {
	Node root;

	static class Node {
		int key;
		Node right;
		Node left;

		Node(int d) {
			key = d;
		}
	}

	public static void main(String[] args) {
		PrintKDistanceTree tree = new PrintKDistanceTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.left.left = new Node(8);
		tree.printLevelOrder(3);
	}

	void printLevelOrder(int k) {
		printGivenLevel(root, k-1);
	}

	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public int height(Node n) {
		if (n == null) {
			return 0;
		}
		return Math.max(height(n.left), height(n.right)) + 1;
	}
}
