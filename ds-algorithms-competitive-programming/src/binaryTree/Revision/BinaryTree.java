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

		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(9);
		tree.root.right = new Node(15);
		tree.root.right.left = new Node(14);
		tree.root.right.right = new Node(16);
		convertToChildSum(tree.root);
		levelorderTraversal(tree.root);

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
		int lDepth = maxDepth(n.left);
		int rDepth = maxDepth(n.right);
		return 1 + Math.max(lDepth, rDepth);
	}

	/*
	 * Print all the leaf node
	 */
	public static void printLeafNodes(Node n) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			System.out.println(n.data);
		}

		printLeafNodes(n.left);
		printLeafNodes(n.right);

	}

	/*
	 * Check children sum property
	 */
	public static void checkChildrenSumProperty(Node n) {
		if (n.left == null && n.right == null) {
			return;
		}

		//Left is null right is not null Sum is equal
		if (n.left == null && n.right != null && n.data == n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Right :" + n.right.data + " YES");
		}

		//Left is null right is not null sum is not equal
		if (n.left == null && n.right != null && n.data != n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Right :" + n.right.data + " NO");
		}
		//Left is not null right is  null sum is equal
		if (n.right == null && n.left != null && n.data == n.left.data) {
			System.out.println("PARENT :" + n.data + " Child LEFT :" + n.left.data + " YES");
		}

		//Left is not null right is null sum is not equal
		if (n.right == null && n.left != null && n.data != n.left.data) {
			System.out.println("PARENT :" + n.data + " Child LEFT :" + n.left.data + " NO");
		}

		//left is not null right is not null sum is equal
		if (n.left != null && n.right != null && n.data == n.left.data + n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Left :" + n.left.data + " Child Right :" + n.right.data + " YES");
		}

		//Left is not null right is not null sum is not equal
		if (n.left != null && n.right != null && n.data != n.left.data + n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Left :" + n.left.data + " Child Right :" + n.right.data + " NO");
		}
		try {
			if (n.left != null) {
				checkChildrenSumProperty(n.left);
			}
			if (n.right != null) {
				checkChildrenSumProperty(n.right);
			}
		} catch (Exception e) {
			System.out.println("CAUGHT for :" + n.data);
		}

	}

	/*
	 * Get Ancestor of a node
	 */

	public static boolean printAncestors(Node node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree
		 * of this node, then print this node
		 */
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;

	}

	/*
	 * Lowest Common ancestor
	 */

	public static boolean printAncestorMyImplementation(Node node, int target) {
		if (node == null) {
			return false;
		}
		if (node.data == target) {
			return true;
		}
		Boolean isLeft = printAncestorMyImplementation(node.left, target);
		System.out.println("is Left: " + "Node " + node.data + " " + isLeft);
		Boolean isRight = printAncestorMyImplementation(node.right, target);
		System.out.println("is Right: " + "Node " + node.data + " " + isRight);
		if (isLeft || isRight) {
			System.out.println(node.data);
			return true;
		}
		return false;

	}

	/*
	 * Convert arbitary binary tree to follow child sum property
	 */
	public static void convertToChildSum(Node n) {
		if (n == null || (n.left == null && n.right == null)) {
			return;
		}
		int leftData = 0;
		int rightData = 0;
		int diff = 0;
		convertToChildSum(n.left);
		convertToChildSum(n.right);
		if (n.left != null) {
			leftData = n.left.data;
		}
		if (n.right != null) {
			rightData = n.right.data;
		}
		diff = n.data - (n.left.data + n.right.data);
		if (diff > 0) {//parent is more
			increment(n, diff);
		}
		if (diff < 0) {
			n.data = n.data - diff;
		}
	}

	static void increment(Node node, int diff) {
		if (node.left != null) {
			node.left.data = node.left.data + diff;

			increment(node.left, diff);
		} else if (node.right != null) 
		{
			node.right.data = node.right.data + diff;

			increment(node.right, diff);
		}
	}
	
}
