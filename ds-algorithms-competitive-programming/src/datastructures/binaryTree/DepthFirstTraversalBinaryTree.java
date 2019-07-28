package datastructures.binaryTree;
/*
 * Binary tree
 * my implementation depth first traversal
 */
public class DepthFirstTraversalBinaryTree {
	Node root;

	static class Node {
		int key;
		Node left;
		Node right;

		Node(int d) {
			key = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		DepthFirstTraversalBinaryTree btree = new DepthFirstTraversalBinaryTree();
		btree.root = new Node(1);
        btree.root.left = new Node(2);
        btree.root.right = new Node(3);
        btree.root.left.left = new Node(4);
        btree.root.left.right = new Node(5);
		btree.printInorder(btree.root);
		System.out.println("");
		btree.printPreorder(btree.root);
		System.out.println("");
		btree.printPostorder(btree.root);
	}

	void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + " ");
	}

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}

	void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

}
