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
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right = new Node(2);
		tree.root.right.left = new Node(3);
		//		tree.root.right.right = new Node(2);
		
		inorderTraversal(tree.root);
		System.out.println("________________________________");
		checkChildrenSumProperty(tree.root);
		System.out.println("________________________________");
		convertToChildrenSumPropertyTree(tree.root);
		System.out.println("________________________________");
		inorderTraversal(tree.root);
		System.out.println("________________________________");
		checkChildrenSumProperty(tree.root);
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
	 * Convert arbitrary tree to Children sum property tree
	 */
	public static void convertToChildrenSumPropertyTree(Node n) {
		if (n.left == null && n.right == null) {
			return;
		}

		//Left is null right is not null Sum is equal
		if (n.left == null && n.right != null && n.data == n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Right :" + n.right.data + " OKAY");
		}

		//Left is null right is not null sum is not equal
		if (n.left == null && n.right != null && n.data != n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Right :" + n.right.data + " NO");
			n.right.data = n.data;
		}
		//Left is not null right is  null sum is equal
		if (n.right == null && n.left != null && n.data == n.left.data) {
			System.out.println("PARENT :" + n.data + " Child LEFT :" + n.left.data + " OKAY");
		}

		//Left is not null right is null sum is not equal
		if (n.right == null && n.left != null && n.data != n.left.data) {
			System.out.println("PARENT :" + n.data + " Child LEFT :" + n.left.data + " NO");
			n.left.data = n.data;
		}

		//left is not null right is not null sum is equal
		if (n.left != null && n.right != null && n.data == n.left.data + n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Left :" + n.left.data + " Child Right :" + n.right.data + " YES");
		}

		//Left is not null right is not null sum is not equal
		if (n.left != null && n.right != null && n.data != n.left.data + n.right.data) {
			System.out.println("PARENT :" + n.data + " Child Left :" + n.left.data + " Child Right :" + n.right.data + " NO");
			int diff = n.data - (n.left.data + n.right.data);
			if (diff > 0) {//parent is more
				n.data=n.data-diff;
			} else {
				n.left.data=n.left.data+diff;
			}
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
	 * Lowest Common ancestor
	 */
	
	

}
