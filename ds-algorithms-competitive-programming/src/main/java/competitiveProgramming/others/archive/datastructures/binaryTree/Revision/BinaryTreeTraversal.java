package competitiveProgramming.others.archive.datastructures.binaryTree.Revision;

import java.util.Stack;

/**
 * 
 * @author tanmay
 * 
 *         1.Tree Traversal Revised
 *         2.
 *
 */
public class BinaryTreeTraversal {
	Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/**
	 * 
	 * 0
	 * / \
	 * 1 4
	 * / \ / \
	 * 2 3 5 6
	 */
	public static void main(String[] args) {
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(3);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);

		/*
		 * System.out.print("Inorder: ");
		 * inOrder(tree.root);
		 * 
		 * System.out.println("");
		 * System.out.print("Preorder: ");
		 * preOrder(tree.root);
		 * 
		 * System.out.println(" ");
		 * System.out.print("Postorder: ");
		 * postOrder(tree.root);
		 * 
		 * System.out.println(" ");
		 * System.out.print("Breath First: ");
		 * printLevelOrder(tree.root);
		 * 
		 * System.out.println();
		 * System.out.println("Height: " + height(tree.root));
		 */

		iterativeInorderTraversal(tree.root);

	}

	public static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.left);
		System.out.print(n.data + " ");
		inOrder(n.right);
	}

	public static void preOrder(Node n) {
		if (n == null)
			return;
		System.out.print(n.data + " ");
		preOrder(n.left);
		preOrder(n.right);

	}

	public static void postOrder(Node n) {
		if (n == null)
			return;
		preOrder(n.left);
		preOrder(n.right);
		System.out.print(n.data + " ");
	}

	public static int height(Node n) {
		if (n == null)
			return 0;
		else {
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}

	public static void printLevelOrder(Node n) {
		for (int i = 1; i <= height(n); i++) {
			printGivenLevel(i, n);
			System.out.println();
		}
	}

	public static void printGivenLevel(int level, Node n) {
		if (n == null)
			return;
		if (level == 1)
			System.out.print(n.data + " ");
		if (level > 1) {
			printGivenLevel(level - 1, n.left);
			printGivenLevel(level - 1, n.right);

		}

	}

	public static void iterativeInorderTraversal(Node n) {
		Stack<Node> myStack = new Stack<Node>();
		while(n!=null){
			myStack.push(n);
			n=n.left;
		}
		
		while(myStack.size()>0){
			n=myStack.pop();
			System.out.println(n.data);
			if(n.right!=null){
				n=n.right;
				while(n!=null){
					myStack.push(n);
					n=n.left;
				}
			}
		}
	}

}
