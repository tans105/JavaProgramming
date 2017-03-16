package binaryTree.Revision;

import java.util.Stack;

/**
 * 
 * @author tanmay
 * @date : 15 Mar 2017
 *
 */
public class BinaryTree {
	Node root;

	static class Node {
		Node right;
		Node left;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(3);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		System.out.println(maxDepth(tree.root));
	}

	/*
	 * Depth First traversals
	 */
	public static void inorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		inorderTraversal(n.left);
		System.out.println(n.data);
		inorderTraversal(n.right);
	}

	public static void preorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		System.out.println(n.data);
		inorderTraversal(n.left);
		inorderTraversal(n.right);
	}

	public static void postorderTraversal(Node n) {
		if (n == null) {
			return;
		}
		inorderTraversal(n.left);
		inorderTraversal(n.right);
		System.out.println(n.data);
	}

	/*
	 * 
	 */

	/*
	 * Breath First Traversal
	 */

	public static void levelorderTraversal(Node n) {
		for (int i = 1; i <= height(n) + 1; i++) {
			printGivenLevel(i, n);
		}
	}

	public static void printGivenLevel(int level, Node n) {
		if (n == null) {
			return;
		}
		if (level == 1) {
			System.out.print(n.data + "-");
		}
		printGivenLevel(level - 1, n.left);
		printGivenLevel(level - 1, n.right);
	}

	/*
	 * 
	 */

	/*
	 * Height of btree
	 */

	public static int height(Node n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math.max(height(n.right), height(n.left));
	}

	/*
	 * Size of btree
	 */
	public static int size(Node n) {
		if (n == null) {
			return 0;
		}
		return 1 + size(n.left) + size(n.right);
	}

	/*
	 * Inorder traversal without recursion
	 */
	public static void inorderTraversalWithoutRecursion(Node n) {
		Stack<Node> stack = new Stack<Node>();
		while (n != null) {
			stack.push(n);
			n = n.left;
		}
		while (stack.size() > 0) {
			n = stack.pop();
			System.out.println(n.data);
			if (n.right != null) {
				n = n.right;
				while (n != null) {
					stack.push(n);
					n = n.left;
				}
			}
		}
	}

	/*
	 * Diameter of binary tree
	 */
	public static int diameter(Node n) {
		if (n == null) {
			return 0;
		}
		int lheight = height(n.left);
		int rheight = height(n.right);
		int ldiameter = diameter(n.left);
		int rdiameter = diameter(n.right);

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}

	/*
	 * Maximum depth of Binary Tree
	 */

	public static int maxDepth(Node n) {
		if (n == null) {
			return 0;
		}
		int lDepth=maxDepth(n.left);
		System.out.println("left  :"+n.data);
		int rDepth=maxDepth(n.right);
		System.out.println("Right :"+n.data);
		return 1+Math.max(lDepth, rDepth);
	}

}
